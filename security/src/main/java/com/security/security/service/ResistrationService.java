package com.security.security.service;

import com.security.security.DTO.AuthenticationResponse;
import com.security.security.DTO.RegisterRequest;
import com.security.security.repository.UserRepository;
import com.security.security.user.User;
import com.security.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResistrationService {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse resister(RegisterRequest request) {
        var user =User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        var savedUser=userRepository.save(user);
        var token = jwtUtils.generateToken(user);

        return AuthenticationResponse.builder()
                .access_token(token)
                .build();
    }
}
