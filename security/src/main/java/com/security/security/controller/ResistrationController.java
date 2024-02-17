package com.security.security.controller;

import com.security.security.DTO.AuthenticationResponse;
import com.security.security.DTO.RegisterRequest;
import com.security.security.service.ResistrationService;
import com.security.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class ResistrationController {
private  final ResistrationService resisterService;
private  final JwtUtils JwtUtils;

@PostMapping(value="/register")
public ResponseEntity<AuthenticationResponse> resister(@RequestBody RegisterRequest request){
    return ResponseEntity.ok(resisterService.resister(request));
}
}
