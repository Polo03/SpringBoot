package org.example.CacheBiblioteca.Repository;

import org.example.CacheBiblioteca.Dto.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer> {
}
