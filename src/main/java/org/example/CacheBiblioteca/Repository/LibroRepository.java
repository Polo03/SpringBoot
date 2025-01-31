package org.example.CacheBiblioteca.Repository;

import org.example.CacheBiblioteca.Dto.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    public Optional<Libro> findByIsbn(String isbn);

}
