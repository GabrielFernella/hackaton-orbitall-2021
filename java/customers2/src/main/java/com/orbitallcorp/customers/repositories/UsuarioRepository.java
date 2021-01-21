package com.orbitallcorp.customers.repositories;

import com.orbitallcorp.customers.domains.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
