package com.br.ebatista.springboot.dto;

import com.br.ebatista.springboot.domain.user.UserRole;

public record RegisterRecordDto(String login, String password, UserRole role) {
}
