package com.security.security.controller;

import com.security.security.DTO.AuthenticationRequest;
import com.security.security.DTO.AuthenticationResponse;
import com.security.security.config.MyUserDetailsService;
import com.security.security.service.LoginService;
import com.security.security.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/auth/")
public class LoginController {

	private final JwtUtils jwtTokenUtil;

	private final LoginService loginService;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(
			@RequestBody AuthenticationRequest request, HttpServletRequest servletRequest
	) {
		return ResponseEntity.ok(loginService.authenticate(request, servletRequest));
	}


}
