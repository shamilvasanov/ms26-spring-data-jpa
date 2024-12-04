package com.example.taxidrivers.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverCriteria {
    private Integer ageFrom;
    private Integer ageTo;
    private String category;
}
