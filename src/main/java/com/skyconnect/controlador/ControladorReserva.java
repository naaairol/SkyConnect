package com.skyconnect.controlador;

import com.skyconnect.modelo.Equipaje;
import com.skyconnect.modelo.Reserva;
import java.util.List;

public class ControladorReserva {

    private Reserva reserva;
    private int numeroBoletos;

    public ControladorReserva(int numeroBoletos) {
        this.numeroBoletos = numeroBoletos;
        this.reserva = new Reserva(numeroBoletos);
    }
    //NUEVO CONSTRUCTOR POR DEFECTO (PARA MainFrame)
    public ControladorReserva() {
        this.numeroBoletos = 1; // valor por defecto
        this.reserva = new Reserva(numeroBoletos);
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
}

    public Reserva getReserva() {
        return this.reserva;
    }
}