package com.example.taxidrivers.mapper;

import com.example.taxidrivers.dao.entity.DriverEntity;
import com.example.taxidrivers.model.enums.DriverStatus;
import com.example.taxidrivers.model.request.DriverRequest;
import com.example.taxidrivers.model.response.DriverResponse;

import static com.example.taxidrivers.model.enums.DriverStatus.WORKING;

public enum DriverMapper {
    DRIVER_MAPPER;
    public DriverEntity buildDriverEntity(DriverRequest request){
        return DriverEntity.builder()
                .name(request.getName())
                .balance(request.getBalance())
                .status(WORKING)
                .category(request.getCategory())
                .phone(request.getPhone())
                .build();
    }
    public DriverResponse mapEntityToResponse(DriverEntity driverEntity){
        return DriverResponse.builder()
                .id(driverEntity.getId())
                .name(driverEntity.getName())
                .balance(driverEntity.getBalance())
                .status(driverEntity.getStatus())
                .category(driverEntity.getCategory())
                .phone(driverEntity.getPhone())
                .build();
    }
}
