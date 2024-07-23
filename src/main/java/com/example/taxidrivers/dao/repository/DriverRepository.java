package com.example.taxidrivers.dao.repository;

import com.example.taxidrivers.dao.entity.DriverEntity;
import com.example.taxidrivers.model.response.DriverResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends CrudRepository<DriverEntity,Long> {
    @Override
    List<DriverEntity> findAll();
}
