package org.example.crudbasicodemo.Repository;

import org.example.crudbasicodemo.Dto.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}
