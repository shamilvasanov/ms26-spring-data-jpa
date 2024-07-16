package com.example.taxidrivers.dao.entity;

import com.example.taxidrivers.model.enums.DriverCategory;
import com.example.taxidrivers.model.enums.DriverStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private DriverStatus status;

    @Enumerated(EnumType.STRING)
    private DriverCategory category;

    private String phone;

}