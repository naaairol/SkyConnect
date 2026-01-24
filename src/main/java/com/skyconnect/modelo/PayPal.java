package com.skyconnect.modelo;

public class PayPal implements MetodoPago {
    
    private String correo;
    private String contrasenia;

    public PayPal(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    @Override
    public void realizarPago(){
    }
    
}
