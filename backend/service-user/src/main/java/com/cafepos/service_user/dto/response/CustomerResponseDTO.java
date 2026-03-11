package com.cafepos.service_user.dto.response;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private Long cusId;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private Integer totalPoint;
}
