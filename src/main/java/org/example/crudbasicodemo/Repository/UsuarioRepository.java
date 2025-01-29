package org.example.crudbasicodemo.Repository;

import org.example.crudbasicodemo.Dto.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
