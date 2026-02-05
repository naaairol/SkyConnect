package com.skyconnect.controlador;

import com.skyconnect.modelo.Pasajero;
import com.skyconnect.modelo.PasajeroDAO;
import java.util.ArrayList;
import java.util.List;

public class ControladorPasajeros {
    
    private PasajeroDAO modeloDAO;
    private List<Pasajero> listaPasajeros;
    
    // Constructor LIMPIO (sin la Vista)
    public ControladorPasajeros(PasajeroDAO modeloDAO, List<Pasajero> listaPasajeros) {
        this.modeloDAO = modeloDAO;
        
        // Seguridad: Si la lista es null, creamos una nueva
        if (listaPasajeros == null) {
            this.listaPasajeros = new ArrayList<>();
        } else {
            this.listaPasajeros = listaPasajeros;
        }
    }
    
    // Método para agregar pasajero
    public void agregarPasajero(Pasajero p) {
        // 1. Memoria
        if (listaPasajeros != null) {
            listaPasajeros.add(p);
        }
        
        // 2. Archivo
        if (modeloDAO != null) {
            modeloDAO.guardarPasajeros(p);
        }
    }
    
    public List<Pasajero> getListaPasajeros() {
        return this.listaPasajeros;
    }
}