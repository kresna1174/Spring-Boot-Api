package com.example.codinginterview.Model.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity(name = "repair")
@Table(name="repair")
public class RepairEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Owner is required")
    private String owner;
    @NotEmpty(message = "Merk is required")
    private String merk;
    @NotEmpty(message = "Motorcycle Type is required")
    private String motorcycle_type;
    private String service_type;
    private String complaint;
    private float phone_number;
    private double cost;
    private int status;
    private int deleted;

    public  RepairEntity() {

    }

    public RepairEntity(Long id, String owner, String merk, String motorcycle_type, String service_type, String complaint, float phone_number, double cost, int status, int deleted) {
        this.id = id;
        this.owner = owner;
        this.merk = merk;
        this.motorcycle_type = motorcycle_type;
        this.service_type = service_type;
        this.complaint = complaint;
        this.phone_number = phone_number;
        this.cost = cost;
        this.status = status;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMotorcycle_type() {
        return motorcycle_type;
    }

    public void setMotorcycle_type(String motorcycle_type) {
        this.motorcycle_type = motorcycle_type;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public float getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(float phone_number) {
        this.phone_number = phone_number;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
