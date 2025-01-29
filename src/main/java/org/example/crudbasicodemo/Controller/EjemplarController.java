package org.example.crudbasicodemo.Controller;

import org.example.crudbasicodemo.Dto.Ejemplar;
import org.example.crudbasicodemo.Dto.Libro;
import org.example.crudbasicodemo.Service.EjemplarService;
import org.example.crudbasicodemo.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ejemplares")
public class EjemplarController {

    @Autowired
    private EjemplarService ejemplarService;

    // Obtener todos los libros
    @GetMapping
    public ResponseEntity<List<Ejemplar>> obtenerTodosUsuarios() {
        List<Ejemplar> ejemplares = ejemplarService.obtenerTodosEjemplares();
        return new ResponseEntity<>(ejemplares, HttpStatus.OK);
    }

}
