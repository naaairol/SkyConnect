package com.skyconnect.controlador;

import com.skyconnect.modelo.Equipaje;
import com.skyconnect.modelo.Factura;
import java.util.List;

public class ControladorReserva {

    private Factura reserva;
    private int numeroBoletos;
    private boolean deseaAgregarEquipajeExtra; 

    public ControladorReserva(int numeroBoletos) {
        this.numeroBoletos = numeroBoletos;
        this.reserva = new Factura(numeroBoletos);
        this.deseaAgregarEquipajeExtra = deseaAgregarEquipajeExtra = false; 
    }
    //NUEVO CONSTRUCTOR POR DEFECTO (PARA MainFrame)
    public ControladorReserva() {
        this.numeroBoletos = 1; // valor por defecto
        this.reserva = new Factura(numeroBoletos);
        this.deseaAgregarEquipajeExtra = deseaAgregarEquipajeExtra = false; 
    }

    // ================= ASIENTOS =================
    public int getNumeroBoletos() {
        return numeroBoletos;
    }

    public void setAsientosSeleccionados(List<String> asientos) {
        for (String asiento : asientos) {
            reserva.seleccionarAsiento(asiento);
        }
    }

    public List<String> getAsientosSeleccionados() {
        return reserva.getAsientosSeleccionados();
    }

    //Equipaje extra 
    public void registrarEquipajeExtra(String tipo, String propietario, double peso) {
    if (reserva == null) return;

    Equipaje equipaje = new Equipaje(tipo, propietario, peso);
    reserva.agregarEquipajeExtra(equipaje);
    this.deseaAgregarEquipajeExtra = true;
}

    public Factura getReserva() {
        return this.reserva;
    }
    
    public boolean getdeseaAgregarEquipajeExtra () {
        return deseaAgregarEquipajeExtra; 
    }
}