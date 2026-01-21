package com.skyconnect.modelo;

public class Visa extends Tarjeta implements MetodoPago {

    public Visa(double cc, String fecha, int cvv) {
        super(cc, fecha, cvv); 
    }

    
}
