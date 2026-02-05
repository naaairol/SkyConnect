package com.skyconnect.controlador;

import com.skyconnect.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorDescuentos {
    
    private List<Pasajero> listaPasajeros;
    private String ciudadOrigen = "Quito"; // Valor por defecto

    public ControladorDescuentos() {
        this.listaPasajeros = new ArrayList<>();
    }
    
    // Método para guardar de dónde sale el vuelo (Lo llamaremos desde la pantalla de buscar)
    public void setCiudadOrigen(String ciudad) {
        this.ciudadOrigen = ciudad;
    }

    // --- AQUÍ ESTÁ LA LÓGICA COMPLETA ---
    public void aplicarDescuento(Pasajero pasajero) {
        if (pasajero == null) return;

        float descuentoCalculado = 1.00f; // 1.00 es precio completo (100%)
        
        // Usamos la ciudad guardada para decidir
        // Convertimos a switch usando los nombres de tu ComboBox
        switch (ciudadOrigen) {
            case "Quito":
            case "Guayaquil":
            case "Cuenca":
            case "Galápagos":
                // Regla Nacional: 50% Seniors/Discapacitados, 25% Niños
                if (pasajero instanceof AdultoMayor || pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.50f; 
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.75f; // (Nota: Si el descuento es 25%, pagan el 0.75)
                }
                break;

            case "Madrid":
                // Regla Europa: 80% (Pagan 0.20?) o Pagan 80%? 
                // Asumo según tu código anterior: 
                if (pasajero instanceof AdultoMayor || pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.80f; 
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.70f; // 30% descuento -> pagan 0.70
                }
                break;

            case "Miami":
                if (pasajero instanceof AdultoMayor || pasajero instanceof Ninio) {
                    descuentoCalculado = 0.85f; 
                } else if (pasajero instanceof Discapacitado) {
                    descuentoCalculado = 1.00f; // Tu código decía 1.00f (Pagan completo)
                }
                break;

            case "Ciudad de Panamá":
                if (pasajero instanceof AdultoMayor || pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.75f; 
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.85f; 
                }
                break;
                
            default:
                descuentoCalculado = 1.00f;
                break;
        }

        pasajero.setDescuento(descuentoCalculado);
    }
    
    // Mantenemos tus otros métodos
    public void procesarPasajeros(int adultos, int ninios, int adultosMayores, int discapacitados) {
        listaPasajeros.clear(); 
        for (int i = 0; i < adultos; i++) listaPasajeros.add(new Adulto("", "", "", ""));
        for (int i = 0; i < ninios; i++) listaPasajeros.add(new Ninio("", "", "", ""));
        for (int i = 0; i < adultosMayores; i++) listaPasajeros.add(new AdultoMayor("", "", "", ""));
        for (int i = 0; i < discapacitados; i++) listaPasajeros.add(new Discapacitado("", "", "", ""));
    }

    public List<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }
}