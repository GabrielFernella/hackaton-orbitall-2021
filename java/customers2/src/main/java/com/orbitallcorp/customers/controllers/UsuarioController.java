package com.orbitallcorp.customers.controllers;

import com.orbitallcorp.customers.domains.Usuario;
import com.orbitallcorp.customers.services.UsuarioService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        Usuario savedCustomer = usuarioService.save((usuario));

        return new ResponseEntity(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/login/{id}")
    public ResponseEntity alter(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
        String validate =  usuarioService.login(id, usuario.getLogin(),usuario.getPassword());

        return ResponseEntity.ok(validate);
    }
}