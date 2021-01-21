package com.orbitallcorp.customers.services;

import com.orbitallcorp.customers.domains.Customer;
import com.orbitallcorp.customers.domains.Usuario;
import com.orbitallcorp.customers.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        List<Usuario> users = new ArrayList<>();
        usuarioRepository.findAll().forEach(users :: add);

        return users;
    }

    public Usuario save(Usuario user){
        return usuarioRepository.save(user);
    }

    public Usuario findOne(long id){
        Usuario user = usuarioRepository.findById(id).orElse(null);

        return user;
    }

    public Boolean login(long id, String user, String password){

        Usuario find = usuarioRepository.findById(id).orElse(null);

        Boolean login = find.equals(user);
        Boolean pass = find.equals(password);

        if((login && pass) == true){
            return true;
        }

        return false;

    }
}
