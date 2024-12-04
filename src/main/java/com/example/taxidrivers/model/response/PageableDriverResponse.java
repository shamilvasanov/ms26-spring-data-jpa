package com.example.taxidrivers.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableDriverResponse {
    private List<DriverResponse> drivers;
    private int lastPageNumber;
    private long totalElements;
    private boolean hasNextPage;
}
