package com.data.jdbc.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePageDTO {
    private boolean isFirstPage;
    private boolean isLastPage;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private boolean hasNext;
    private  boolean hasPrevious;
    private boolean hasContent;
    private int numberOfElements;
    private List<EmployeeDTO> employeeDTOList;
}
