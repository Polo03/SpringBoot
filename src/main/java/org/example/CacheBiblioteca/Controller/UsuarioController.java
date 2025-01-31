package org.example.CacheBiblioteca.Controller;

import org.example.CacheBiblioteca.Dto.Libro;
import org.example.CacheBiblioteca.Dto.Usuario;
import org.example.CacheBiblioteca.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CacheConfig(cacheNames = {"usuarios"})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    //Obtener usuario por ID
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Optional<Usuario>> obtenerUsuarioPorId(@PathVariable Integer id) {
        try{
            Thread.sleep(3000);
            Optional<Usuario> usuario = usuarioService.obtenerUsuarioByID(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // Crear usuario
    @PostMapping
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioGuardar = usuarioService.guardarUsuario(usuario);

        if (usuarioGuardar!=null) {
            return ResponseEntity.ok("Usuario guardado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no guardado");
        }
    }

    //Actualizar usuario
    @PutMapping("/update")
    public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario nuevoUsuario) {
        boolean actualizado = usuarioService.actualizarUsuario(nuevoUsuario);

        if (actualizado) {
            return ResponseEntity.ok("Usuario actualizado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    //Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id) {
        boolean eliminado = usuarioService.eliminarLibro(id);

        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

}
