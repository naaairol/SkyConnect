package com.skyconnect.modelo;

import java.sql.Time;
import java.util.Date;

public class Vuelo {
    
    private String numeroVuelo;
    private Date fechaSalida;
    private Date fechaLlegada;
    private Time horaSalida;
    private Time horaLlegada;
    private Time duracion;
    private float precioEstimado;
    private Ruta ruta;

    public Vuelo(String numeroVuelo, Date fechaSalida, Date fechaLlegada, Time horaSalida, Time horaLlegada, Time duracion, float precioEstimado, Ruta ruta) {
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

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
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
