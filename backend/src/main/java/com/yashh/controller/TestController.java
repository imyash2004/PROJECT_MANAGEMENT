package com.yashh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/ping")
    public ResponseEntity<Map<String, String>> ping() {
        System.out.println("Ping test endpoint called");
        Map<String, String> response = new HashMap<>();
        response.put("message", "API is working!");
        response.put("status", "success");
        response.put("timestamp", new java.util.Date().toString());
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/debug")
    public ResponseEntity<Map<String, Object>> debug() {
        System.out.println("Debug endpoint called");
        Map<String, Object> response = new HashMap<>();
        Map<String, String> endpoints = new HashMap<>();
        
        // List active endpoints for testing
        endpoints.put("Register", "/api/auth/register");
        endpoints.put("Login", "/api/auth/login");
        endpoints.put("Test ping", "/api/test/ping");
        
        response.put("message", "API debugging information");
        response.put("endpoints", endpoints);
        response.put("status", "active");
        response.put("javaVersion", System.getProperty("java.version"));
        response.put("timestamp", new java.util.Date().toString());
        
        return ResponseEntity.ok(response);
    }
}
