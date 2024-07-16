package com.example.taxidrivers.service.abstraction;

import com.example.taxidrivers.model.request.DriverRequest;
import com.example.taxidrivers.model.request.UpdateDriverRequest;
import com.example.taxidrivers.model.response.DriverResponse;

import java.util.List;

public interface DriverService {
    void createDriver(DriverRequest request);

    DriverResponse getDriver(Long id);

    List<DriverResponse> getDrivers();

    void deleteDriver(Long id);

    void updateDriverPhone(Long id, UpdateDriverRequest request);
}
