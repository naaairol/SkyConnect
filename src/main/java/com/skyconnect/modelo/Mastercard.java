package com.skyconnect.modelo;

public class Mastercard extends Tarjeta implements MetodoPago {

    public Mastercard(double cc, String fecha, int cvv) {
        super(cc, fecha, cvv);
    }
    
    @Override
    public void realizarPago(){
    }
    
}
