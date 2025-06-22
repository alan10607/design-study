package com.alan.design.structural.adapter_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthInfo {
    private AuthProvider authProvider;
    private String token;
}