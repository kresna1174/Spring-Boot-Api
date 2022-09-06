package com.example.codinginterview.Model.Repository;

import com.example.codinginterview.Model.Entity.RepairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<RepairEntity, Long> {

    @Query("SELECT rp FROM repair rp WHERE rp.status = ?1")
    public List<RepairEntity> findByStatus(int status);

}
