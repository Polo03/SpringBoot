package org.example.crudbasicodemo.Service;

import org.example.crudbasicodemo.Dto.Libro;
import org.example.crudbasicodemo.Dto.Prestamo;
import org.example.crudbasicodemo.Repository.LibroRepository;
import org.example.crudbasicodemo.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    // Obtener todos los libros
    public List<Prestamo> obtenerTodosPrestamos() {
        return prestamoRepository.findAll();
    }

}
