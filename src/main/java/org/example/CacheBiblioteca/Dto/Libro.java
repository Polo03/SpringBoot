package org.example.CacheBiblioteca.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Column(name = "isbn", nullable = false, length = 20)
    @NotNull(message = "El isbn no puede ser nulo.")
    @NotBlank(message = "El isbn no puede estar en blanco")
    @Pattern(regexp = "^(\\d{3}-\\d{1}-\\d{5}-\\d{3}-\\d{1}|\\d{13}$)",message = "El formato del ISBN es incorrecto")
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 200)
    @NotNull(message = "El título no puede ser nulo.")
    @NotBlank(message = "El título no puede estar en blanco")
    @Size(max = 200, message = "El título no puede tener más de 200 caracteres.")
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    @NotNull(message = "El autor no puede ser nulo.")
    @NotBlank(message = "El autor no puede estar en blanco")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres.")
    private String autor;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}