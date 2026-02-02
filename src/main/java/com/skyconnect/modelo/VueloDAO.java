package com.skyconnect.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {
    
    private Aeropuerto buscarAeropuerto(String codigo, List<Aeropuerto> lista) {
        for (Aeropuerto a : lista) {
            if (a.getCodigoIATA().trim().equalsIgnoreCase(codigo.trim())) {
                return a;
            }
        }
        return null;
    }
    
    public ArrayList<Vuelo> cargarVuelos(String rutaArchivo, ArrayList<Aeropuerto> listaAeropuertos) {
        ArrayList<Vuelo> vuelos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                
                if (partes.length == 10) {
                    try {
                        String numeroVuelo = partes[0];
                        String aeroOrigen = partes[1];
                        String aeroDestino = partes[2];
                        String fechaSalida = partes[3];
                        String horaSalida = partes[4];
                        String fechaLlegada = partes[5];
                        String horaLlegada = partes[6];
                        String duracion = partes[7];
                        float precio = Float.parseFloat(partes[8]);
                        float distancia = Float.parseFloat(partes[9]);

                        Aeropuerto origen = buscarAeropuerto(aeroOrigen, listaAeropuertos);
                        Aeropuerto destino = buscarAeropuerto(aeroDestino, listaAeropuertos);

                        if (origen != null && destino != null) {
                            Ruta ruta = new Ruta(origen, destino, distancia);
                            Vuelo vuelo = new Vuelo(
                                numeroVuelo,
                                fechaSalida,
                                fechaLlegada,
                                horaSalida,
                                horaLlegada,
                                duracion,
                                precio,
                                ruta
                            );

                            vuelos.add(vuelo);
                            
                        } else {
                            System.err.println("No se encontró aeropuerto para la ruta " + aeroOrigen + "-" + aeroDestino);
                        }

                    } catch (NumberFormatException e) {
                        System.err.println("Error al procesar línea: " + linea + " por " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo de vuelos: " + e.getMessage());
        }

        return vuelos;
    }
}
