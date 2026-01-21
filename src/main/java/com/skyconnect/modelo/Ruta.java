package com.skyconnect.modelo;

public class Ruta {
    private Aeropuerto aeroSalida;
    private Aeropuerto aeroLlegada;
    private float distancia;

    public Ruta(Aeropuerto aeroSalida, Aeropuerto aeroLlegada, float distancia) {
        this.aeroSalida = aeroSalida;
        this.aeroLlegada = aeroLlegada;
        this.distancia = distancia;
    }

    public Aeropuerto getAeroSalida() {
        return aeroSalida;
    }

    public void setAeroSalida(Aeropuerto aeroSalida) {
        this.aeroSalida = aeroSalida;
    }

    public Aeropuerto getAeroLlegada() {
        return aeroLlegada;
    }

    public void setAeroLlegada(Aeropuerto aeroLlegada) {
        this.aeroLlegada = aeroLlegada;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Ruta{" + "aeroSalida=" + aeroSalida + ", aeroLlegada=" + aeroLlegada + ", distancia=" + distancia + '}';
    }
    
}
