package org.example.crudbasicodemo.Service;

import org.example.crudbasicodemo.Dto.Prestamo;
import org.example.crudbasicodemo.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    // Obtener todos los prestamos
    public List<Prestamo> obtenerTodosPrestamos() {
        return prestamoRepository.findAll();
    }

    // Obtener prestamo por id
    public Optional<Prestamo> obtenerPrestamoPorID(Integer id) {
        return prestamoRepository.findById(id);
    }

    //Guardar prestamo
    public Prestamo guardarPrestamo(Prestamo prestamo) {
        Prestamo prestamoGuardar = prestamoRepository.save(prestamo);
        return prestamoGuardar;
    }

    //Actualizar prestamo
    public boolean actualizarPrestamo(Prestamo nuevoPrestamo) {
        Optional<Prestamo> prestamoExistente = prestamoRepository.findById(nuevoPrestamo.getId());
        if (prestamoExistente.isPresent()) {
            prestamoRepository.save(nuevoPrestamo);
            return true;
        }
        return false;
    }

    //Eliminar prestamos
    public boolean eliminarPrestamo(Integer id) {
        if (prestamoRepository.existsById(id)) {
            prestamoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
