package com.example.taxidrivers.service.concrete;

import com.example.taxidrivers.dao.entity.DriverEntity;
import com.example.taxidrivers.dao.repository.DriverRepository;
import com.example.taxidrivers.exception.NotFoundException;
import com.example.taxidrivers.model.criteria.PageCriteria;
import com.example.taxidrivers.model.criteria.DriverCriteria;
import com.example.taxidrivers.model.request.DriverRequest;
import com.example.taxidrivers.model.request.UpdateDriverRequest;
import com.example.taxidrivers.model.response.DriverResponse;
import com.example.taxidrivers.model.response.PageableDriverResponse;
import com.example.taxidrivers.service.abstraction.DriverService;
import com.example.taxidrivers.service.specification.DriverSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.example.taxidrivers.mapper.DriverMapper.DRIVER_MAPPER;
import static com.example.taxidrivers.model.enums.DriverStatus.NOT_WORKING;
import static com.example.taxidrivers.model.enums.ExceptionConstants.ORDER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriverServiceHandler implements DriverService {
    private final DriverRepository driverRepository;

    @Override
    public void createDriver(DriverRequest request) {
         driverRepository.save(DRIVER_MAPPER.buildDriverEntity(request));
    }

    @Override
    public DriverResponse getDriver(Long id) {
        log.error("ActionLog.getDriver.start id:{}",id);
        return DRIVER_MAPPER.mapEntityToResponse(fetchDriverOfExist(id));

    }

    @Override
    public void deleteDriver(Long id) {
        var driver = fetchDriverOfExist(id);
        driver.setStatus(NOT_WORKING);
        driverRepository.save(driver);

    }

    @Override
    public void updateDriverPhone(Long id, UpdateDriverRequest request) {
        var driver = fetchDriverOfExist(id);
        driver.setPhone(request.getPhone());
        driverRepository.save(driver);

    }
    @Override
    public PageableDriverResponse getDrivers(PageCriteria pageCriteria, DriverCriteria driverCriteria) {
        var driversPage = driverRepository.findAll(
                new DriverSpecification(driverCriteria),
                PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount(), Sort.by("id").descending())
        );

        return DRIVER_MAPPER.mapToPageableResponse(driversPage);
    }
    private DriverEntity fetchDriverOfExist(Long id){
        return driverRepository.findById(id).orElseThrow(()->new NotFoundException(ORDER_NOT_FOUND.getMessage(), ORDER_NOT_FOUND.getCode()));
    }
}
