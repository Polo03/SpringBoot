package org.example.CacheBiblioteca.Dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dni", nullable = false, length = 15)
    @NotNull(message = "El dni no puede ser nulo")
    @NotBlank(message = "El dni no puede estar en blanco")
    @Pattern(regexp = "^\\d{8}[A-Z]$", message = "El formato del DNI no es el correcto")
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Pattern(regexp = "^[a-zA-Z0-9\s]+$", message = "El nombre solo puede tener caracteres alfanuméricos")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres.")
    private String nombre;

    @Column(name = "email", nullable = false, length = 100)
    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede estar en blanco")
    @Pattern(regexp = "[A-Za-z0-9]{1,50}@gmail.com", message = "El formato del email no es el correcto")
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull(message = "La password no puede ser nulo")
    @NotBlank(message = "La password no puede estar en blanco")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,12}$", message = "El formato de la contraseña es el incorrecto")
    private String password;

    @Lob
    @Column(name = "tipo", nullable = false)
    @NotNull(message = "El tipo no puede ser nulo")
    @NotBlank(message = "El tipo no puede estar en blanco")
    @Pattern(regexp = "^(normal|administrador)$", message = "El formato del tipo solo adminte administrador o normal")
    private String tipo;

    @Column(name = "penalizacion_hasta")
    private LocalDate penalizacionHasta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getPenalizacionHasta() {
        return penalizacionHasta;
    }

    public void setPenalizacionHasta(LocalDate penalizacionHasta) {
        this.penalizacionHasta = penalizacionHasta;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipo='" + tipo + '\'' +
                ", penalizacionHasta=" + penalizacionHasta +
                '}';
    }
}