package com.br.odv.springboot.dto;

import com.br.odv.springboot.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
