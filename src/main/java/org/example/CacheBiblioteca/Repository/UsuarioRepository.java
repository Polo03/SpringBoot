package org.example.CacheBiblioteca.Repository;

import org.example.CacheBiblioteca.Dto.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
