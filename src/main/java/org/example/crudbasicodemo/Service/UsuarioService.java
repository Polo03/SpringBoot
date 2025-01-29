package org.example.crudbasicodemo.Service;

import org.example.crudbasicodemo.Dto.Libro;
import org.example.crudbasicodemo.Repository.UsuarioRepository;
import org.example.crudbasicodemo.Dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener usuario by ID
    public Optional<Usuario> obtenerUsuarioByID(Integer id) {
        return usuarioRepository.findById(id);
    }

    //Guardar usuario
    public Usuario guardarUsuario(Usuario usuario) {
        Usuario usuarioGuardar = usuarioRepository.save(usuario);
        return usuarioGuardar;
    }

    //Actualizar usuario
    public boolean actualizarUsuario(Usuario nuevoUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(nuevoUsuario.getId());
        if (usuarioExistente.isPresent()) {
            usuarioRepository.save(nuevoUsuario);
            return true;
        }
        return false;
    }

    //Eliminar usuario
    public boolean eliminarLibro(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
