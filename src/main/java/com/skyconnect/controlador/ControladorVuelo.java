/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skyconnect.controlador;

import com.skyconnect.modelo.Aeropuerto;
import com.skyconnect.modelo.Vuelo;
import com.skyconnect.modelo.VueloDAO;
import java.util.ArrayList;

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

    public ArrayList<Vuelo> obtenerVuelos() {
        ArrayList<Aeropuerto> aeropuertos = controladorAeropuerto.getAeropuertos();
        return vueloDAO.cargarVuelos("database/vuelos.txt", aeropuertos);
    }
}