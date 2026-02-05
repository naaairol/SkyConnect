package com.skyconnect.controlador;

import com.skyconnect.modelo.Vuelo;
import java.util.ArrayList;

public class ControladorBusqueda {

    //Variables para guardar lo que el usuario seleccionó
    private String origenBuscado;
    private String destinoBuscado;
    private String fechaIdaBuscado;
    private String fechaRetornoBuscado;
    private double precioVueloSeleccionado; // Variable para guardar el precio
    private String horaVueloSeleccionado; // Variable para guardar la hora (ej: "08:00 AM")

    //Pasar ciudad obtenida del combobox a codigoIATA
    public static String ciudadAIATA(String ciudad){
        //Impide que explote todo
        if (ciudad == null) return null;

    return switch (ciudad.trim()) {
        case "Quito" -> "UIO";
        case "Guayaquil" -> "GYE";
        case "Galápagos" -> "GPS";
        case "Bogotá" -> "BOG";
        case "Ciudad de Panamá" -> "PTY";
        case "Miami" -> "MIA";
        case "Madrid" -> "MAD";
        default -> null;
        };
    }
    
    // Recibe toda la lista de vuelos y devuelve solo los que coinciden
    public ArrayList<Vuelo> buscarVuelosIDA(ArrayList<Vuelo> todosLosVuelos) {
        ArrayList<Vuelo> vuelosEncontrados = new ArrayList<>();

        for (Vuelo v : todosLosVuelos) {
            //Verifica los vuelos
            boolean mismoOrigen = v.getRuta().getAeroSalida().getCodigoIATA().
                    equalsIgnoreCase(ControladorBusqueda.ciudadAIATA(
                            origenBuscado));
            boolean mismoDestino = v.getRuta().getAeroLlegada().getCodigoIATA().
                    equalsIgnoreCase(ControladorBusqueda.ciudadAIATA(
                            destinoBuscado));
            boolean mismaFecha = v.getFechaSalida().
                    equalsIgnoreCase(fechaIdaBuscado);
            //Agrega a la lista solo los que coinciden
            if (mismoOrigen && mismoDestino && mismaFecha) {
                vuelosEncontrados.add(v);
            }
        }
        return vuelosEncontrados;
    }
    
    // Recibe toda la lista de vuelos y devuelve solo los que coinciden
    public ArrayList<Vuelo> buscarVuelosVUELTA(ArrayList<Vuelo> todosLosVuelos) {
        ArrayList<Vuelo> vuelosEncontrados = new ArrayList<>();

        for (Vuelo v : todosLosVuelos) {
            //Verifica los vuelos
            boolean mismoOrigen = v.getRuta().getAeroSalida().getCodigoIATA().
                    equalsIgnoreCase(ControladorBusqueda.ciudadAIATA(
                            destinoBuscado));
            boolean mismoDestino = v.getRuta().getAeroLlegada().getCodigoIATA().
                    equalsIgnoreCase(ControladorBusqueda.ciudadAIATA(
                            origenBuscado));
            boolean mismaFecha = v.getFechaSalida().
                    equalsIgnoreCase(fechaRetornoBuscado);
            //Agrega a la lista solo los que coinciden
            if (mismoOrigen && mismoDestino && mismaFecha) {
                vuelosEncontrados.add(v);
            }
        }
        return vuelosEncontrados;
    }
    
    
    
    //Para que en vista se setten las variables de esta clase
    public void setCriteriosBusqueda(String origen, String destino, String fechaIda, String fechaRetornoBuscado) {
        this.origenBuscado = origen;
        this.destinoBuscado = destino;
        this.fechaIdaBuscado = fechaIda;
        this.fechaRetornoBuscado = fechaRetornoBuscado;
    }
    
    public String getOrigen() {
        return origenBuscado; 
    }

    public String getDestino() {
        return destinoBuscado; 
    }

    public String getFechaIda() {
        return fechaIdaBuscado; // Ojo: Asegúrate de que la variable se llame 'fechaViaje' o 'fechaIda' arriba
    }
    public String getFechaRetorno() {
        return fechaRetornoBuscado;
    }
    public void setPrecioVueloSeleccionado(double precio) {
        this.precioVueloSeleccionado = precio;
    }

    public double getPrecioVueloSeleccionado() {
        return this.precioVueloSeleccionado;
    }
    public void setHoraVueloSeleccionado(String hora) {
        this.horaVueloSeleccionado = hora;
    }

    public String getHoraVueloSeleccionado() {
        // Seguridad: Si no hay hora guardada, devolvemos un texto por defecto para que no salga vacío
        if (this.horaVueloSeleccionado == null) {
            return "Pendiente"; 
        }
        return this.horaVueloSeleccionado;
    }
    
}
