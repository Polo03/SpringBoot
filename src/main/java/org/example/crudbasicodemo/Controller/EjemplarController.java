package org.example.crudbasicodemo.Controller;

import org.example.crudbasicodemo.Dto.Ejemplar;
import org.example.crudbasicodemo.Dto.Libro;
import org.example.crudbasicodemo.Service.EjemplarService;
import org.example.crudbasicodemo.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ejemplares")
public class EjemplarController {

    @Autowired
    private EjemplarService ejemplarService;

    // Obtener todos los ejemplares
    @GetMapping
    public ResponseEntity<List<Ejemplar>> obtenerTodosEjemplares() {
        List<Ejemplar> ejemplares = ejemplarService.obtenerTodosEjemplares();
        return new ResponseEntity<>(ejemplares, HttpStatus.OK);
    }

    // Obtener ejemplar by ID
    @GetMapping("{id}")
    public ResponseEntity<Optional<Ejemplar>> obtenerEjemplarByID(@PathVariable Integer id) {
        Optional<Ejemplar> ejemplar = ejemplarService.obtenerEjemplarByID(id);
        return new ResponseEntity<>(ejemplar, HttpStatus.OK);
    }

    // Crear ejemplar
    @PostMapping
    public ResponseEntity<String> guardarEjemplar(@RequestBody Ejemplar ejemplar) {
        Ejemplar ejemplarGuardar = ejemplarService.guardarEjemplar(ejemplar);

        if (ejemplarGuardar!=null) {
            return ResponseEntity.ok("Ejemplar guardado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ejemplar no guardado");
        }
    }

    //Actualizar ejemplar
    @PutMapping("/update")
    public ResponseEntity<String> actualizarEjemplar(@RequestBody Ejemplar nuevoEjemplar) {
        boolean actualizado = ejemplarService.actualizarEjemplar(nuevoEjemplar);

        if (actualizado) {
            return ResponseEntity.ok("Ejemplar actualizado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ejemplar no encontrado");
        }
    }

    //Eliminar un ejemplar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEjemplar(@PathVariable int id) {
        boolean eliminado = ejemplarService.eliminarEjemplar(id);

        if (eliminado) {
            return ResponseEntity.ok("Ejemplar eliminado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ejemplar no encontrado");
        }
    }

}
