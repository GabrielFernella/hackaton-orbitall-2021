package com.orbitallcorp.customers.controllers;

import com.orbitallcorp.customers.domains.Customer;
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

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> users = usuarioService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        Usuario savedCustomer = usuarioService.save((usuario));

        return new ResponseEntity(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/login/{id}")
    public ResponseEntity logon(@RequestBody String login, String password, @PathVariable("id") Long id) {
        //Boolean validate =  usuarioService.login(usuario.getId(), usuario.getLogin(),usuario.getPassword());

        Usuario user = usuarioService.findOne(id);
        Boolean available = usuarioService.login(user.getId(),login, password);

        return ResponseEntity.ok(available);
    }
}