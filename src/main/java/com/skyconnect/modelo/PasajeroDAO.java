package com.skyconnect.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class PasajeroDAO {
    private File archivo;
    
    public PasajeroDAO(){
        archivo = new File("pasajeros.txt");
    }
    
    //Metodo para guardar pasajeros
    public boolean guardarPasajeros(Pasajero p){
        try(FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);){
            // Obtenemos el nombre de la clase (Adulto, Ninio, etc.) para guardarlo
            String tipoClase = p.getClass().getSimpleName();
            // Escribimos los datos separados por coma más el tipo de objeto
            String linea = p.getNombre() + "," + p.getApellido() + "," + 
                       p.getCedula() + "," + p.getPasaporte() + "," + tipoClase;
            bw.write(linea);
            bw.newLine();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    
    //Metodo para listar pasajeros
    public ArrayList<Pasajero> listarPasajeros(){
        ArrayList<Pasajero> listaPasajeros = new ArrayList<>();
            if(!archivo.exists()) return listaPasajeros;
            try(FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);){
                String linea;
                while((linea = br.readLine()) != null){
                    String[] partes = linea.split(",");
                    if(partes.length == 5){
                            String nombre = partes[0];
                            String apellido = partes[1];
                            String cedula = partes[2];
                            String pasaporte = partes[3];
                            String tipo = partes[4];
                            Pasajero p;
                            switch(tipo){
                                case "Ninio" -> p = new Ninio(nombre, apellido, cedula, pasaporte);
                                case "AdultoMayor" -> p = new AdultoMayor(nombre, apellido, cedula, pasaporte);
                                case "Discapacitado" -> p = new Discapacitado(nombre, apellido, cedula, pasaporte);
                                default -> p = new Adulto(nombre, apellido, cedula, pasaporte);
                            }
                        listaPasajeros.add(p);
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return listaPasajeros;
    }
}

