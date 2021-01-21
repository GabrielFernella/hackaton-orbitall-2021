package com.orbitallcorp.customers.services;

import com.orbitallcorp.customers.domains.Usuario;
import com.orbitallcorp.customers.repositories.UsuarioRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario user){
        return usuarioRepository.save(user);
    }

    public String login(Long id, String user, String password){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        Boolean login = usuario.equals(user);
        Boolean pass = usuario.equals(password);

        if((login && pass) == true){
            return "{\"success\":1}";
        }
        return "{\"Error\":1}";
    }
}
