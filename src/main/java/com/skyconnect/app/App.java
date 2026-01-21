package com.skyconnect.app;

import com.skyconnect.modelo.*;
import com.skyconnect.vista.*;
import com.skyconnect.controlador.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        
        //En este punto se carga la informacion necesaria
        ArrayList<Aeropuerto> listaAeropuertos = new ArrayList<>();
        listaAeropuertos = AeropuertoDAO.cargarAeropuertos("resources/aeropuerto.txt");
        System.out.println(listaAeropuertos);
        
        
        //Se despliega la vista
        //MainFrame ventanaInicio = new MainFrame();
        //ventanaInicio.setVisible(true);
    }
}
