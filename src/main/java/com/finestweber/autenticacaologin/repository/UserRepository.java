package com.finestweber.autenticacaologin.repository;

import com.finestweber.autenticacaologin.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
