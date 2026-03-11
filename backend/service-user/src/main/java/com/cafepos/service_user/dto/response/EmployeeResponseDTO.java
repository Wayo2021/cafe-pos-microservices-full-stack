package com.cafepos.service_user.dto.response;

import lombok.Data;

@Data
public class EmployeeResponseDTO {
    private Long empId;
    private String firstName;
    private String lastName;
    private String phoneNum;
}
