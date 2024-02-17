package com.security.security.DTO;

import com.security.security.user.Role;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private Role role;
}
