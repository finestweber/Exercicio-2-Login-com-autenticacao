package com.finestweber.autenticacaologin.serivice;

import com.finestweber.autenticacaologin.entity.Usuario;
import com.finestweber.autenticacaologin.repository.UserRepository;
import com.finestweber.autenticacaologin.util.RandomString;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario RegisterUsuario(Usuario usuario) {
        if (userRepository.findByEmail(usuario.getEmail()) != null) {
            throw new RuntimeException("Este email já existe");
        } else {
            String codificaSenha = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(codificaSenha);

            String codigoAleatorio = RandomString.generateRandomString(64);
            usuario.setVerificationCode(codigoAleatorio);
            usuario.setEnabled(false);
            Usuario userSave = userRepository.save(usuario);
            return userSave;
        }
    }
}
