package org.example.casademo;

import org.springframework.stereotype.Component;

@Component
public class Ventana {

    private String material;

    private Float peso;

    public Ventana() {
        this.material = "Material ejemplo";
        this.peso = 123.3F;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Ventana{" +
                "material='" + material + '\'' +
                ", peso=" + peso +
                '}';
    }
}
