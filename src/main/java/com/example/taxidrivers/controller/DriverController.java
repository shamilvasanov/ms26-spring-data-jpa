package com.example.taxidrivers.controller;

import com.example.taxidrivers.model.request.DriverRequest;
import com.example.taxidrivers.model.request.UpdateDriverRequest;
import com.example.taxidrivers.model.response.DriverResponse;
import com.example.taxidrivers.service.abstraction.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

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

    @GetMapping()
    public List<DriverResponse> getDrivers(){
        return  driverService.getDrivers();
    }

    @DeleteMapping("{id}")
    public void deleteDriver(@PathVariable Long id){
        driverService.deleteDriver(id);
    }

    @PatchMapping("{id}")
    public void updateDriverPhone(@PathVariable Long id, @RequestBody UpdateDriverRequest request){
        driverService.updateDriverPhone(id,request);
    }




}
