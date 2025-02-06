package org.example.CacheBiblioteca.Controller;

import jakarta.validation.Valid;
import org.example.CacheBiblioteca.Dto.Libro;
import org.example.CacheBiblioteca.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
@CacheConfig(cacheNames = {"libros"})
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Obtener todos los libros
    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodosLosLibros() {
        List<Libro> libros = libroService.obtenerTodosLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    // ✅ Obtener un libro por ISBN
    @GetMapping("/{isbn}")
    @Cacheable
    public ResponseEntity<Optional<Libro>> obtenerLibroPorIsbn(@PathVariable String isbn) {
        try{
            Thread.sleep(3000);
            Optional<Libro> libro = libroService.obtenerLibroPorIsbn(isbn);
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // Crear libro
    @PostMapping
    public ResponseEntity<String> guardarLibro(@RequestBody @Valid Libro libro) {
        Libro libroGuardar = libroService.guardarLibro(libro);

        if (libroGuardar!=null) {
            return ResponseEntity.ok("Libro guardado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no guardado");
        }
    }

    //Actualizar libro
    @PutMapping
    public ResponseEntity<String> actualizarLibro(@RequestBody Libro nuevoLibro) {
        boolean actualizado = libroService.actualizarLibro(nuevoLibro);

        if (actualizado) {
            return ResponseEntity.ok("Libro actualizado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado");
        }
    }

    //Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable int id) {
        boolean eliminado = libroService.eliminarLibro(id);

        if (eliminado) {
            return ResponseEntity.ok("Libro eliminado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado");
        }
    }
}
