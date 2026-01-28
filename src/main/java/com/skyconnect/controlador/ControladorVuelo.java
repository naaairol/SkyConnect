/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skyconnect.controlador;

import com.skyconnect.modelo.Aeropuerto;
import com.skyconnect.modelo.Vuelo;
import com.skyconnect.modelo.VueloDAO;
import com.skyconnect.vista.VueloIDAView;
import java.util.ArrayList;
import java.util.List;

public class ControladorVuelo { 
    private VueloDAO vueloDAO;
    private ControladorAeropuerto controladorAeropuerto;
    /** 
    *Controlador encargado de gestionar
    *la obtención de vuelos disponibles.
    */
    public ControladorVuelo() {
        vueloDAO = new VueloDAO();
        controladorAeropuerto = new ControladorAeropuerto();
    }

    public List<Vuelo> obtenerVuelos() {
        ArrayList<Aeropuerto> aeropuertos = controladorAeropuerto.getAeropuertos();
        return vueloDAO.cargarVuelos("database/vuelos.txt", aeropuertos);
    }
    // Envía a la vista la lista de vuelos obtenidos desde el modelo
    public void mostrarVuelosIda(VueloIDAView vista) {
    ArrayList<Aeropuerto> aeropuertos = controladorAeropuerto.getAeropuertos();

    List<Vuelo> vuelos = vueloDAO.cargarVuelos(
        "database/vuelos.txt",
        aeropuertos
    );

    vista.mostrarVuelos(vuelos);
    }
}