package com.example.codinginterview.Service;

import com.example.codinginterview.Model.Entity.RepairEntity;
import com.example.codinginterview.Model.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RepairService{

    @Autowired
    private RepairRepository repairRepository;

    public RepairEntity create(RepairEntity repairEntity) {
        return repairRepository.save(repairEntity);
    }

    public RepairEntity findOne(Long id) {
        return repairRepository.findById(id).get();
    }

    public Iterable<RepairEntity> findAll() {
        return repairRepository.findAll();
    }

    public void deleteById(Long id) {
        repairRepository.deleteById(id);
    }

    public List<RepairEntity> findByStatus(int status) {
        return repairRepository.findByStatus(status);
    }

}
