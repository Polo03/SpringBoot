package org.example.CacheBiblioteca.Service;

import org.example.CacheBiblioteca.Dto.Libro;
import org.example.CacheBiblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Obtener todos los libros
    public List<Libro> obtenerTodosLibros() {
        return libroRepository.findAll();
    }

    // Obtener libro por id
    public Optional<Libro> obtenerLibroPorIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn);
    }

    //Guardar libro
    public Libro guardarLibro(Libro libro) {
        Libro libroGuardar = libroRepository.save(libro);
        return libroGuardar;
    }

    //Actualizar libro
    public boolean actualizarLibro(Libro nuevoLibro) {
        Optional<Libro> libroExistente = libroRepository.findByIsbn(nuevoLibro.getIsbn());
        if (libroExistente.isPresent()) {
            libroRepository.save(nuevoLibro);
            return true;
        }
        return false;
    }

    //Eliminar libro
    public boolean eliminarLibro(Integer id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
