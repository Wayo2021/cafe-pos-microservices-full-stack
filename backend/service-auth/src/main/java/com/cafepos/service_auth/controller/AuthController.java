package com.cafepos.service_auth.controller;

import com.cafepos.service_auth.dto.AuthDTO;
import com.cafepos.service_auth.entity.UserCredential;
import com.cafepos.service_auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // 🟢 เส้นทางสำหรับเข้าสู่ระบบ
    @PostMapping("/login")
    public ResponseEntity<AuthDTO.LoginResponseDTO> login(@RequestBody AuthDTO.LoginRequestDTO request) {
        AuthDTO.LoginResponseDTO response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    // 🟢 เส้นทางสำหรับสร้างไอดีพนักงาน/ลูกค้าใหม่
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserCredential user) {
        authService.register(user);
        return ResponseEntity.ok("สร้างบัญชีผู้ใช้สำเร็จ!");
    }
}
