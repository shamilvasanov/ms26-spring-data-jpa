package com.example.taxidrivers.model.response;

import com.example.taxidrivers.model.enums.DriverStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverResponse {
    private Long id;

    private String name;

    private BigDecimal balance;

    private DriverStatus status;

    private String category;

    private String phone;
}
