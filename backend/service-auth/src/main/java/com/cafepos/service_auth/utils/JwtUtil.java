package com.cafepos.service_auth.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // กุญแจลับสำหรับเซ็นลายเซ็น (ของจริงควรย้ายไปไว้ใน application.yml)
    // ต้องยาวและเดายากมากๆ ไม่งั้นแฮกเกอร์ปลอมบัตรได้ครับ
    private final String SECRET = "CafePosSecretKeyThatIsVeryLongAndSecure1234567890!";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // ตั้งเวลาหมดอายุ 1 วัน (24 ชั่วโมง)
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    public String generateToken(String username, String role, Long refId) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)   // แปะตำแหน่งลงไปในบัตร
                .claim("refId", refId) // แปะ ID ประจำตัวลงไปในบัตร
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
