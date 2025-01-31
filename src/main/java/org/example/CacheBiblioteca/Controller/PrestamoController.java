package org.example.CacheBiblioteca.Controller;

import org.example.CacheBiblioteca.Dto.Prestamo;
import org.example.CacheBiblioteca.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prestamos")
@CacheConfig(cacheNames = {"prestamos"})
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    // Obtener todos los prestamos
    @GetMapping
    public ResponseEntity<List<Prestamo>> obtenerTodosPrestamos() {
        List<Prestamo> prestamos = prestamoService.obtenerTodosPrestamos();
        return new ResponseEntity<>(prestamos, HttpStatus.OK);
    }

    // ✅ Obtener un libro por ID (posición en la lista)
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Optional<Prestamo>> obtenerPrestamoPorID(@PathVariable Integer id) {
        try{
            Thread.sleep(3000);
            Optional<Prestamo> prestamo = prestamoService.obtenerPrestamoPorID(id);
            return new ResponseEntity<>(prestamo, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // Crear libro
    @PostMapping
    public ResponseEntity<String> guardarPrestamo(@RequestBody Prestamo prestamo) {
        Prestamo prestamoGuardar = prestamoService.guardarPrestamo(prestamo);

        if (prestamoGuardar!=null) {
            return ResponseEntity.ok("Prestamo guardado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestamo no guardado");
        }
    }

    //Actualizar libro
    @PutMapping("/update")
    public ResponseEntity<String> actualizarPrestamo(@RequestBody Prestamo nuevoPrestamo) {
        boolean actualizado = prestamoService.actualizarPrestamo(nuevoPrestamo);

        if (actualizado) {
            return ResponseEntity.ok("Prestamo actualizado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestamo no encontrado");
        }
    }

    //Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPrestamo(@PathVariable int id) {
        boolean eliminado = prestamoService.eliminarPrestamo(id);

        if (eliminado) {
            return ResponseEntity.ok("Prestamo eliminado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prestamo no encontrado");
        }
    }

}
