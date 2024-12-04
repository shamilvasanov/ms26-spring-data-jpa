package com.example.taxidrivers.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequest {
    private String name;
    private Integer age;
    private BigDecimal balance;
    private String category;
    private String phone;
}
