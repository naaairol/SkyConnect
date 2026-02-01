package com.skyconnect.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo que representa una reserva de vuelo.
 * Mantiene estado y reglas del negocio.
 */
public class Factura {

    // ===================== DATOS DEL VUELO =====================
    private String origen;
    private String destino;
    private String fecha;
    private String horario;
    private int numeroPasajeros;

    // ===================== COSTOS =====================
    private double precioBase;
    private double impuestos;
    private double adicionales;
    private double descuentos;

    // ===================== BENEFICIOS =====================
    private int millas;

    // ===================== ASIENTOS =====================
    private final List<String> asientosSeleccionados = new ArrayList<>();
    private final int maxAsientos;

    // ===================== EQUIPAJE =====================
    private final List<Equipaje> equipajesExtra = new ArrayList<>();

    // ===================== CONSTRUCTOR =====================
    public Factura(int maxAsientos) {
        this.maxAsientos = maxAsientos;
    }

    // ===================== GETTERS =====================
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public String getFecha() { return fecha; }
    public String getHorario() { return horario; }
    public int getNumeroPasajeros() { return numeroPasajeros; }

    public double getPrecioBase() { return precioBase; }
    public double getImpuestos() { return impuestos; }
    public double getAdicionales() { return adicionales; }
    public double getDescuentos() { return descuentos; }

    //Total calculado SIEMPRE
    public double getTotal() {
        return precioBase + impuestos + adicionales - descuentos;
    }



    public List<String> getAsientosSeleccionados() {
        return new ArrayList<>(asientosSeleccionados);
    }

    // ===================== SETTERS CONTROLADOS =====================
    public void setDatosVuelo(String origen, String destino, String fecha, String horario) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.horario = horario;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public void setMillas(int millas) {
        this.millas = millas;
    }
    
    //mover a donde corresponda
    
    // ===================== ASIENTOS =====================
    public boolean seleccionarAsiento(String codigo) {
        if (asientosSeleccionados.size() >= maxAsientos) return false;
        if (asientosSeleccionados.contains(codigo)) return false;
        asientosSeleccionados.add(codigo);
        return true;
    }

    public boolean quitarAsiento(String codigo) {
        return asientosSeleccionados.remove(codigo);
    }

    // ===================== EQUIPAJE =====================
    public void agregarEquipajeExtra(Equipaje equipaje) {
        equipajesExtra.add(equipaje);
        adicionales += equipaje.getPrecioBase();
    }

    // ===================== MÉTODO COMPATIBLE (OPCIONAL) =====================
    /** Para evitar errores si en alguna vista usas getPrecio() */
    public double getPrecio() {
        return getPrecioBase();
    }
}
