package org.example.CacheBiblioteca.Dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dni", nullable = false, length = 15)
    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\d{8}[A-Z]$", message = "El formato del DNI no es el correcto")
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El nombre solo puede tener caracteres alfanuméricos")
    @Max(100)
    private String nombre;

    @Column(name = "email", nullable = false, length = 100)
    @NotNull
    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9]{1,50}@gmail.com", message = "El formato del email no es el correcto")
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{4,12}$", message = "El formato de la contraseña es el incorrecto")
    private String password;

    @Lob
    @Column(name = "tipo", nullable = false)
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(normal|administrador)$", message = "El formato del tipo solo adminte administrador o normal")
    private String tipo;

    @Column(name = "penalizacion_hasta")
    @NotBlank
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