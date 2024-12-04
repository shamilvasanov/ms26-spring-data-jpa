package com.example.taxidrivers.mapper;

import com.example.taxidrivers.dao.entity.DriverEntity;
import com.example.taxidrivers.model.enums.DriverStatus;
import com.example.taxidrivers.model.request.DriverRequest;
import com.example.taxidrivers.model.response.DriverResponse;
import com.example.taxidrivers.model.response.PageableDriverResponse;
import org.springframework.data.domain.Page;

import java.util.List;

import static com.example.taxidrivers.model.enums.DriverStatus.WORKING;

public enum DriverMapper {
    DRIVER_MAPPER;
    public DriverEntity buildDriverEntity(DriverRequest request){
        return DriverEntity.builder()
                .name(request.getName())
                .age(request.getAge())
                .balance(request.getBalance())
                .status(WORKING)
                .category(request.getCategory())
                .phone(request.getPhone())
                .build();
    }
    public static DriverResponse mapEntityToResponse(DriverEntity driverEntity){
        return DriverResponse.builder()
                .id(driverEntity.getId())
                .name(driverEntity.getName())
                .age(driverEntity.getAge())
                .balance(driverEntity.getBalance())
                .status(driverEntity.getStatus())
                .category(driverEntity.getCategory())
                .phone(driverEntity.getPhone())
                .build();
    }
    public PageableDriverResponse mapToPageableResponse(Page<DriverEntity> page){
        return PageableDriverResponse.builder()
                .drivers(page.getContent().stream().map(DriverMapper::mapEntityToResponse).toList())
                .lastPageNumber(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .hasNextPage(page.hasNext())
                .build();
    }

}
