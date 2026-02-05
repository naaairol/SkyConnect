package com.skyconnect.modelo;

public class Asiento {
    
    private String zona;
    private String asiento;
    private String tipoAsiento;

    public Asiento(String zona, String asiento, String tipoAsiento) {
        this.zona = zona;
        this.asiento = asiento;
        this.tipoAsiento = tipoAsiento;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }
 
    
    
}
