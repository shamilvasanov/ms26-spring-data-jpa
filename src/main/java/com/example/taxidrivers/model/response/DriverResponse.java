package com.example.taxidrivers.model.response;

import com.example.taxidrivers.model.enums.DriverCategory;
import com.example.taxidrivers.model.enums.DriverStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponse {
    private Long id;

    private String name;

    private BigDecimal balance;

    private DriverStatus status;

    private DriverCategory category;

    private String phone;
}
