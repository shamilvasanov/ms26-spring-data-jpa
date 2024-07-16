package com.example.taxidrivers.service.concrete;

import com.example.taxidrivers.dao.entity.DriverEntity;
import com.example.taxidrivers.dao.repository.DriverRepository;
import com.example.taxidrivers.model.request.DriverRequest;
import com.example.taxidrivers.model.request.UpdateDriverRequest;
import com.example.taxidrivers.model.response.DriverResponse;
import com.example.taxidrivers.service.abstraction.DriverService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DriverServiceHandler implements DriverService {
    private final DriverRepository driverRepository;

    @Override
    public void createDriver(DriverRequest request) {

    }

    @Override
    public DriverResponse getDriver(Long id) {
        return null;
    }

    @Override
    public List<DriverResponse> getDrivers() {
        return null;
    }

    @Override
    public void deleteDriver(Long id) {

    }

    @Override
    public void updateDriverPhone(Long id, UpdateDriverRequest request) {

    }
}
