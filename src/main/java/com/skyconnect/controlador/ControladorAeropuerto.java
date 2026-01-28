package com.skyconnect.controlador;

import com.skyconnect.modelo.Aeropuerto;
import com.skyconnect.modelo.AeropuertoDAO;
import java.util.ArrayList;

// Controlador encargado de gestionar la lógica de negocio relacionada con los aeropuertos,
// actuando como intermediario entre la vista y el modelo Aeropuerto.
public class ControladorAeropuerto {
    private ArrayList<Aeropuerto> aeropuertos; 
    /**
    *Carga los aeropoertos de destinos en archivos
    *Facilita la lista para usar en los JPanel 
    */
    public ControladorAeropuerto() {
        aeropuertos = AeropuertoDAO.cargarAeropuertos("database/aeropuerto.txt");
    }

    public ArrayList<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }
}
