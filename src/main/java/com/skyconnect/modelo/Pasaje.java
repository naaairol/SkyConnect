package com.skyconnect.modelo;

public class Pasaje {
    
    private Pasajero pasajero;
    private int idPasaje;
    private String asiento;
    private String cabina;

    public Pasaje(Pasajero pasajero, int idPasaje, String asiento, String cabina) {
        this.pasajero = pasajero;
        this.idPasaje = idPasaje;
        this.asiento = asiento;
        this.cabina = cabina;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getCabina() {
        return cabina;
    }

    public void setCabina(String cabina) {
        this.cabina = cabina;
    }
    
    
    
    
}
