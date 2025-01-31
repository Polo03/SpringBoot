package org.example.CacheBiblioteca.Service;

import org.example.CacheBiblioteca.Dto.Ejemplar;
import org.example.CacheBiblioteca.Repository.EjemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjemplarService {

    @Autowired
    private EjemplarRepository ejemplarRepository;

    // Obtener todos los ejemplares
    public List<Ejemplar> obtenerTodosEjemplares() {
        return ejemplarRepository.findAll();
    }

    // Obtener ejemplar by ID
    public Optional<Ejemplar> obtenerEjemplarByID(Integer id) {
        return ejemplarRepository.findById(id);
    }

    //Guardar ejemplar
    public Ejemplar guardarEjemplar(Ejemplar ejemplar) {
        Ejemplar ejemplarGuardar = ejemplarRepository.save(ejemplar);
        return ejemplarGuardar;
    }

    //Actualizar ejemplar
    public boolean actualizarEjemplar(Ejemplar nuevoEjemplar) {
        Optional<Ejemplar> libroExistente = ejemplarRepository.findById(nuevoEjemplar.getId());
        if (libroExistente.isPresent()) {
            ejemplarRepository.save(nuevoEjemplar);
            return true;
        }
        return false;
    }

    //Eliminar ejemplar
    public boolean eliminarEjemplar(Integer id) {
        if (ejemplarRepository.existsById(id)) {
            ejemplarRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
