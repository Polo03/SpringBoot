package org.example.casademo;

import org.springframework.stereotype.Component;

@Component
public class Puerta {

    private String material;

    private Float peso;

    public Puerta() {
        this.material = "Material ejemplo";
        this.peso = 123.4F;
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
        return "Puerta{" +
                "material='" + material + '\'' +
                ", peso=" + peso +
                '}';
    }
}
