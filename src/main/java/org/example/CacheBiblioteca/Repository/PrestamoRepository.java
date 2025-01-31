package org.example.CacheBiblioteca.Repository;

import org.example.CacheBiblioteca.Dto.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}
