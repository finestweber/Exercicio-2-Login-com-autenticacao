package com.finestweber.autenticacaologin.controller;

import com.finestweber.autenticacaologin.dto.UserRequest;
import com.finestweber.autenticacaologin.entity.Usuario;
import com.finestweber.autenticacaologin.serivice.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UserService userService;
    public UsuarioController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Usuario> RegisterLogin(@RequestBody UserRequest userRequest){
        Usuario usuario  = userRequest.toModel();
        Usuario userSave = userService.RegisterUsuario(usuario);
        return ResponseEntity.ok().body(userSave);
    }
}
