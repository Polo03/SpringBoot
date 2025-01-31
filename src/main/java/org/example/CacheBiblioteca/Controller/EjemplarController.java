package org.example.CacheBiblioteca.Controller;

import org.example.CacheBiblioteca.Dto.Ejemplar;
import org.example.CacheBiblioteca.Dto.Usuario;
import org.example.CacheBiblioteca.Service.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ejemplares")
@CacheConfig(cacheNames = {"ejemplares"})
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
    @Cacheable
    public ResponseEntity<Optional<Ejemplar>> obtenerEjemplarByID(@PathVariable Integer id) {
        try{
            Thread.sleep(3000);
            Optional<Ejemplar> ejemplar = ejemplarService.obtenerEjemplarByID(id);
            return new ResponseEntity<>(ejemplar, HttpStatus.OK);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
