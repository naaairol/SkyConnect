package com.skyconnect.controlador;

import com.skyconnect.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorPasajero {
    
    private List<Pasajero> listaPasajeros;

    public ControladorPasajero() {
        this.listaPasajeros = new ArrayList<>();
    }
    
    //Logica para obtener cantidades
    public void procesarPasajeros(int adultos, int ninios, int adultosMayores, int discapacitados) {
        listaPasajeros.clear(); // Limpiar lista antes de una nueva búsqueda

        for (int i = 0; i < adultos; i++) 
            listaPasajeros.add(new Adulto("", "", "", ""));
        
        for (int i = 0; i < ninios; i++) 
            listaPasajeros.add(new Ninio("", "", "", ""));
        
        for (int i = 0; i < adultosMayores; i++) 
            listaPasajeros.add(new AdultoMayor("", "", "", ""));
            
        for (int i = 0; i < discapacitados; i++) 
            listaPasajeros.add(new Discapacitado("", "", "", ""));
    }
    
    //Logica para asignar descuentos
    public static void asignarDescuento(Pasajero pasajero, Vuelo vuelo){
        if (pasajero == null || vuelo == null || vuelo.getRuta() == null) {
        return; 
        }
        
        String IATAorigen = vuelo.getRuta().getAeroSalida().getCodigoIATA();
        float descuentoCalculado = 1.00f;
        
        switch (IATAorigen){
            case "UIO", "GYE", "CUE", "GPS" -> {
                if (pasajero instanceof AdultoMayor || pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.50f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.25f;
                }
            }
            case "MAD" -> {
                if (pasajero instanceof AdultoMayor || pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.80f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.30f;
                }
            }
            case "MIA" -> {
                if (pasajero instanceof AdultoMayor || pasajero instanceof Ninio) {
                    descuentoCalculado = 0.85f;
                }else if (pasajero instanceof Discapacitado) {
                    descuentoCalculado = 1.00f;
                }
            }
            case "PTY" -> {
                if (pasajero instanceof AdultoMayor || pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.75f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.85f;
                }
            }
            default -> descuentoCalculado = 1.00f;
        }
        pasajero.setDescuento(descuentoCalculado);
    }
    
    public static float precioConDescuento(Pasajero pasajero, Vuelo vuelo) {
        return vuelo.getPrecioEstimado() * pasajero.getDescuento();
    }
    
    public List<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }
    
}

