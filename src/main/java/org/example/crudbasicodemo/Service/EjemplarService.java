package org.example.crudbasicodemo.Service;

import org.example.crudbasicodemo.Dto.Ejemplar;
import org.example.crudbasicodemo.Dto.Libro;
import org.example.crudbasicodemo.Repository.EjemplarRepository;
import org.example.crudbasicodemo.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjemplarService {

    @Autowired
    private EjemplarRepository ejemplarRepository;

    // Obtener todos los libros
    public List<Ejemplar> obtenerTodosEjemplares() {
        return ejemplarRepository.findAll();
    }

}
