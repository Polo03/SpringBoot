package com.example.demo;

public class Coche {

    private String marca;
    private String tipo;
    private String color;
    private Integer caballos;
    private Float peso;
    private String combustible;

    public Coche() {}

    public Coche(String marca, String tipo, String color, Integer caballos, Float peso, String combustible) {
        this.marca = marca;
        this.tipo = tipo;
        this.color = color;
        this.caballos = caballos;
        this.peso = peso;
        this.combustible = combustible;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCaballos() {
        return caballos;
    }

    public void setCaballos(Integer caballos) {
        this.caballos = caballos;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", caballos=" + caballos +
                ", peso=" + peso +
                ", combustible='" + combustible + '\'' +
                '}';
    }
}
