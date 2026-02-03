package com.skyconnect.controlador;

import com.skyconnect.modelo.Vuelo;
import java.util.ArrayList;

public class ControladorBusqueda {

    //Variables para guardar lo que el usuario seleccionó
    private String origenBuscado;
    private String destinoBuscado;
    private String fechaIdaBuscado;
    private String fechaRetornoBuscado;

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
    public ArrayList<Vuelo> buscarVuelosSoloIDA(ArrayList<Vuelo> todosLosVuelos) {
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
    
    //Para que en vista se setten las variables de esta clase
    public void setCriteriosBusquedaIDA(String origen, String destino, String fechaIda) {
        this.origenBuscado = origen;
        this.destinoBuscado = destino;
        this.fechaIdaBuscado = fechaIda;
    }
    
    //Para que en vista se setten las variables, incluido la fecha de regreso
    public void setCriteriosBusquedaIDAVUELTA(String origen, String destino, String fechaIda, String fechaVuelta){
        this.origenBuscado = origen;
        this.destinoBuscado = destino;
        this.fechaIdaBuscado = fechaIda;
        this.fechaRetornoBuscado = fechaVuelta;
    }
    
}
