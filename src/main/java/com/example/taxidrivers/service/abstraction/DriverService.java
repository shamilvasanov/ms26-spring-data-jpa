package com.example.taxidrivers.service.abstraction;

import com.example.taxidrivers.model.criteria.PageCriteria;
import com.example.taxidrivers.model.criteria.DriverCriteria;
import com.example.taxidrivers.model.request.DriverRequest;
import com.example.taxidrivers.model.request.UpdateDriverRequest;
import com.example.taxidrivers.model.response.DriverResponse;
import com.example.taxidrivers.model.response.PageableDriverResponse;

public interface DriverService {
    void createDriver(DriverRequest request);

    DriverResponse getDriver(Long id);

    PageableDriverResponse getDrivers(PageCriteria pageCriteria, DriverCriteria userCriteria);

    void deleteDriver(Long id);

    void updateDriverPhone(Long id, UpdateDriverRequest request);
}
