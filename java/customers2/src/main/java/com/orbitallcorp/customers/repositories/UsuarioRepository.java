package com.orbitallcorp.customers.repositories;

import com.orbitallcorp.customers.domains.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
