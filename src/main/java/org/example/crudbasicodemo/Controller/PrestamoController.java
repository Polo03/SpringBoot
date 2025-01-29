package org.example.crudbasicodemo.Controller;

import org.example.crudbasicodemo.Dto.Libro;
import org.example.crudbasicodemo.Dto.Prestamo;
import org.example.crudbasicodemo.Service.LibroService;
import org.example.crudbasicodemo.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    // Obtener todos los libros
    @GetMapping
    public ResponseEntity<List<Prestamo>> obtenerTodosPrestamos() {
        List<Prestamo> prestamos = prestamoService.obtenerTodosPrestamos();
        return new ResponseEntity<>(prestamos, HttpStatus.OK);
    }

}
