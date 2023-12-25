package com.br.ebatista.springboot.domain.user;

public enum UserRole {
    AFFILIATE("affiliate"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
