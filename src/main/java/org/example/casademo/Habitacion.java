package org.example.casademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Habitacion {

    @Autowired
    private Puerta puerta;

    @Autowired
    private Ventana ventana;

    public Habitacion(Puerta puerta, Ventana ventana) {
        this.puerta = puerta;
        this.ventana = ventana;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

    public Ventana getVentana() {
        return ventana;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "puerta=" + puerta +
                ", ventana=" + ventana +
                '}';
    }
}
