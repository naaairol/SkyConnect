package com.skyconnect.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AeropuertoDAO {

    public ArrayList<Aeropuerto> cargarAeropuertos(String rutaArchivo) {
        ArrayList<Aeropuerto> lista = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(","); 
                
                if(partes.length == 4) {
                    String codigoIATA = partes[0];
                    String nombre = partes[1];
                    String ciudad = partes[2];
                    String pais = partes[3];
                    lista.add(new Aeropuerto(codigoIATA, nombre, ciudad, pais));
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return lista;
    }
    
}
