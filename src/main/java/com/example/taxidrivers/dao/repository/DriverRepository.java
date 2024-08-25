package com.example.taxidrivers.dao.repository;

import com.example.taxidrivers.dao.entity.DriverEntity;
import com.example.taxidrivers.model.response.DriverResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity,Long>, JpaSpecificationExecutor<DriverEntity> {
    @Override
    List<DriverEntity> findAll();
}
