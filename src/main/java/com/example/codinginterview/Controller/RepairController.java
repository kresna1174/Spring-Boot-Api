package com.example.codinginterview.Controller;

import com.example.codinginterview.DTO.ResponseData;
import com.example.codinginterview.Exception.ResourceNotFoundException;
import com.example.codinginterview.Model.Entity.RepairEntity;
import com.example.codinginterview.Model.Repository.RepairRepository;
import com.example.codinginterview.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;
    private RepairRepository repairRepository;

    @PostMapping
    public ResponseEntity<ResponseData<RepairEntity>> create(@Valid @RequestBody RepairEntity repairEntity, Errors errors) {
        ResponseData<RepairEntity> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(repairService.create(repairEntity));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<RepairEntity> findAll() {
        return repairService.findAll();
    }

    @GetMapping("{status}")
    public List<RepairEntity> findById(@PathVariable("status") int status) {
        if (status > 1 || status < 0) {
            throw new ResourceNotFoundException("Status not found : " + status);
        } else {
            return repairService.findByStatus(status);
        }
    }

    @PutMapping
    public ResponseEntity<ResponseData<RepairEntity>> updateById(@Valid @RequestBody RepairEntity repairEntity, Errors errors) {
        ResponseData<RepairEntity> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        RepairEntity ifExist = repairService.findOne(repairEntity.getId());

        ifExist.setOwner(repairEntity.getOwner());
        ifExist.setMerk(repairEntity.getMerk());
        ifExist.setMotorcycle_type(repairEntity.getMotorcycle_type());
        ifExist.setService_type(repairEntity.getService_type());
        ifExist.setComplaint(repairEntity.getComplaint());
        ifExist.setPhone_number(repairEntity.getPhone_number());
        ifExist.setCost(repairEntity.getCost());
        ifExist.setStatus(repairEntity.getStatus());
        ifExist.setDeleted(repairEntity.getDeleted());
        responseData.setStatus(true);
        responseData.setPayload(repairService.create(ifExist));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<RepairEntity> deleteById(@PathVariable Long id) {
        repairService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
