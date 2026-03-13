package com.cafepos.service_auth.service;

import com.cafepos.service_auth.dto.AuthDTO;
import com.cafepos.service_auth.entity.UserCredential;
import com.cafepos.service_auth.repository.UserCredentialRepository;
import com.cafepos.service_auth.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthDTO.LoginResponseDTO login(AuthDTO.LoginRequestDTO dto) {
        // 1. หา user จากฐานข้อมูล
        UserCredential user = repository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("ไม่พบชื่อผู้ใช้งานนี้!"));

        // 2. เทียบรหัสผ่านที่ส่งมา กับ รหัสที่เข้ารหัสไว้ใน Database
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("รหัสผ่านไม่ถูกต้อง!");
        }

        // 3. รหัสถูก! สั่งโรงงานผลิต JWT
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole(), user.getRefId());

        // 4. คืนค่าให้ Controller
        AuthDTO.LoginResponseDTO response = new AuthDTO.LoginResponseDTO();
        response.setToken(token);
        response.setRole(user.getRole());
        response.setRefId(user.getRefId());

        return response;
    }

    // (แถม) ลอจิกสำหรับสมัครไอดีใหม่ (ซ่อนรหัสผ่านก่อนเซฟ)
    public UserCredential register(UserCredential user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
