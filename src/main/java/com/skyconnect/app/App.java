package com.skyconnect.app;

import com.skyconnect.modelo.*;
import com.skyconnect.vista.*;
import com.skyconnect.controlador.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        
        //Arreglos para guardar aeropuertos y vuelos
        ArrayList<Aeropuerto> listaAeropuertos = new ArrayList<>();
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();
        
        //Carga de datos de aeropuertos y vuelos desde archivos
        AeropuertoDAO aeropuertoDAO = new AeropuertoDAO();
        VueloDAO vueloDAO = new VueloDAO();
        
        listaAeropuertos = aeropuertoDAO.cargarAeropuertos("src/main/java/Resources/aeropuerto.txt");
        listaVuelos = vueloDAO.cargarVuelos("src/main/java/Resources/vuelos.txt", listaAeropuertos);
        
        /*
        //Se inicializan las pestañas de las GUI creadas
        SwingUtilities.invokeLater(() -> {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("SkyConnect");
        mainFrame.setLocationRelativeTo(null); 
        mainFrame.setVisible(true);
        });
        //Se despliega la vista
        //MainFrame ventanaInicio = new MainFrame();
        //ventanaInicio.setVisible(true);
        
        */
    }
}
