package com.cafepos.service_loyalty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    // 🌟 เครื่องมือสำหรับให้ RedeemService ใช้ยิง API ไปหา User Service
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // เปิดทางให้หน้าบ้าน
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
