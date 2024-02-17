package com.security.security.service;

import com.security.security.DTO.AuthenticationRequest;
import com.security.security.DTO.AuthenticationResponse;
import com.security.security.repository.UserRepository;
import com.security.security.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class LoginService {
    private final JwtUtils jwtUtils;
    private  final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletRequest servletRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.getFindByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtUtils.generateToken(user);
        // Set the token attribute in the session
        HttpSession session = servletRequest.getSession();
        servletRequest.setAttribute("token", jwtToken);
        return AuthenticationResponse.builder()
                .access_token(jwtToken)
                .build();
    }
    }
