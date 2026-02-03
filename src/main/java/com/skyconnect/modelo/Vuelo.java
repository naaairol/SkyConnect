package com.skyconnect.modelo;

public class Vuelo {
    
    private String numeroVuelo;
    private String fechaSalida;
    private String fechaLlegada;
    private String horaSalida;
    private String horaLlegada;
    private String duracion;
    private float precioEstimado;
    private Ruta ruta;

    public Vuelo(String numeroVuelo, String fechaSalida, String fechaLlegada, String horaSalida, String horaLlegada, String duracion, float precioEstimado, Ruta ruta) {
        this.numeroVuelo = numeroVuelo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.duracion = duracion;
        this.precioEstimado = precioEstimado;
        this.ruta = ruta;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public String getDuracion() {
        return duracion;
    }

    public float getPrecioEstimado() {
        return precioEstimado;
    }

    public Ruta getRuta() {
        return ruta;
    }


    

}
