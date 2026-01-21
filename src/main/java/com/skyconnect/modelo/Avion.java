package com.skyconnect.modelo;

public class Avion {
    
    private String matricula;
    private String modelo;
    private int capacidadTotal;

    public Avion(String matricula, String modelo, int capacidadTotal) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.capacidadTotal = capacidadTotal;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }
}
