package com.finestweber.autenticacaologin.dto;

import com.finestweber.autenticacaologin.entity.Usuario;

public record UserRequest(String name, String email, String password) {
    public Usuario toModel() {
        return new Usuario(name,email,password);
    }
}
