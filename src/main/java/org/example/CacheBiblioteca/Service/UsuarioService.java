package org.example.CacheBiblioteca.Service;

import org.example.CacheBiblioteca.Repository.UsuarioRepository;
import org.example.CacheBiblioteca.Dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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


    public boolean validarDNI(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numeros = Integer.parseInt(dni.substring(0,8));
        int resto = numeros % 23;
        if(dni.charAt(8)==letras.charAt(resto))
            return true;
        return false;
    }


}
