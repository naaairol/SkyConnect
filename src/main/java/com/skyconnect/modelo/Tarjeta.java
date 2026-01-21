package com.skyconnect.modelo;

public abstract class Tarjeta {
    
    protected double cc;
    protected String fecha;
    protected int cvv;

    public Tarjeta(double cc, String fecha, int cvv) {
        this.cc = cc;
        this.fecha = fecha;
        this.cvv = cvv;
    }
    
    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    
    
    
}
