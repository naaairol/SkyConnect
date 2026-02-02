package com.skyconnect.modelo;

import java.sql.Time;
import java.util.Date;

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

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public float getPrecioEstimado() {
        return precioEstimado;
    }

    public void setPrecioEstimado(float precioEstimado) {
        this.precioEstimado = precioEstimado;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

 
    
}
