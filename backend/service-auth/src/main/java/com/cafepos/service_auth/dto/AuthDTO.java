package com.cafepos.service_auth.dto;

import lombok.Data;

public class AuthDTO {
    @Data
    public static class LoginRequestDTO {
        private String username;
        private String password;
    }

    @Data
    public static class LoginResponseDTO {
        private String token; // บัตรผ่าน JWT ของเรา
        private String role;
        private Long refId;
    }

}

