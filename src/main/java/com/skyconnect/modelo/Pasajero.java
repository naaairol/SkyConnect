package com.skyconnect.modelo;

public class Pasajero {
    
    private String nombre;
    private String apellido;
    private String cedula;
    private String pasaporte;

    public Pasajero(String nombre, String apellido, String cedula, String pasaporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.pasaporte = pasaporte;
    }

    public Pasajero(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", pasaporte=" + pasaporte + '}';
    }
    
}
