package com.example.taxidrivers.controller;

import com.example.taxidrivers.model.criteria.PageCriteria;
import com.example.taxidrivers.model.criteria.DriverCriteria;
import com.example.taxidrivers.model.request.DriverRequest;
import com.example.taxidrivers.model.request.UpdateDriverRequest;
import com.example.taxidrivers.model.response.DriverResponse;
import com.example.taxidrivers.model.response.PageableDriverResponse;
import com.example.taxidrivers.service.abstraction.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/drivers")
public class DriverController {
    private final DriverService driverService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createDriver(@RequestBody DriverRequest request){
        driverService.createDriver(request);
    }

    @GetMapping("{id}")
    public DriverResponse getDriver(@PathVariable Long id){
        return driverService.getDriver(id);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteDriver(@PathVariable Long id){
        driverService.deleteDriver(id);
    }

    @PatchMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateDriverPhone(@PathVariable Long id, @RequestBody UpdateDriverRequest request){
        driverService.updateDriverPhone(id,request);
    }

    @GetMapping()
    public PageableDriverResponse getDrivers(PageCriteria pageCriteria, DriverCriteria driverCriteria){
        return driverService.getDrivers(pageCriteria,driverCriteria);
    }




}
