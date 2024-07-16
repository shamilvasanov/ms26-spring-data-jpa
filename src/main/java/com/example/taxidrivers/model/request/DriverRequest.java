package com.example.taxidrivers.model.request;

import com.example.taxidrivers.model.enums.DriverCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequest {
    private String name;
    private DriverCategory category;
    private String phone;
}
