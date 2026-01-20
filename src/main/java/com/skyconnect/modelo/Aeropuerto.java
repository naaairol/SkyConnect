package com.skyconnect.modelo;

public class Aeropuerto {
    
    private String codigoIATA;
    private String nombre;
    private String ciudad;
    private String pais;

    public Aeropuerto(String codigoIATA, String nombre, String ciudad, String pais) {
        this.codigoIATA = codigoIATA;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }
    
    
    
}
