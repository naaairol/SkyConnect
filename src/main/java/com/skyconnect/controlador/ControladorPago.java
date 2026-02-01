package com.skyconnect.controlador;

import com.skyconnect.modelo.Factura;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorPago {

    private Factura reserva;
    private ControladorFactura controladorFactura; // Integrar ControladorFactura

    // Constructor
    public ControladorPago(Factura reserva, ControladorFactura controladorFactura) {
        this.reserva = reserva;
        this.controladorFactura = controladorFactura;
    }

    // ============================
    // Métodos de pago (getters para la vista)
    // ============================
    public String getOrigen() { return reserva.getOrigen(); }
    public String getDestino() { return reserva.getDestino(); }
    public String getFecha() { return reserva.getFecha(); }
    public String getHorario() { return reserva.getHorario(); }
    public int getNumeroPasajeros() { return reserva.getNumeroPasajeros(); }
    public List<String> getAsientos() { return reserva.getAsientosSeleccionados(); }
    public double getPrecioBase() { return reserva.getPrecioBase(); }
    public double getImpuestos() { return reserva.getImpuestos(); }
    public double getAdicionales() { return reserva.getAdicionales(); }
    public double getDescuentos() { return reserva.getDescuentos(); }
    public double getTotal() { return reserva.getTotal(); }

    // ============================
    // Método para procesar pagos con PayPal
    // ============================
    public void procesarPagoPayPal(String correo, String contrasena) {
        if (correo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Correo y contraseña son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aquí podrías agregar una validación real con PayPal, pero por ahora se simula el éxito
        JOptionPane.showMessageDialog(null, "Pago realizado con éxito con PayPal.", "Pago Aprobado", JOptionPane.INFORMATION_MESSAGE);

        // Después de procesar el pago, mostrar la factura
        controladorFactura.mostrarFactura("PayPal");
    }

    // ============================
    // Método para procesar pagos con tarjeta
    // ============================
    public void procesarPagoTarjeta(String numeroTarjeta, String fechaVencimiento, String cvv) {
        if (numeroTarjeta.isEmpty() || fechaVencimiento.isEmpty() || cvv.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!numeroTarjeta.matches("\\d{16}")) {
            JOptionPane.showMessageDialog(null, "El número de tarjeta debe tener 16 dígitos", "Tarjeta inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!cvv.matches("\\d{3}")) {
            JOptionPane.showMessageDialog(null, "El CVV debe tener 3 dígitos", "CVV inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Pago con tarjeta realizado con éxito", "Pago Aprobado", JOptionPane.INFORMATION_MESSAGE);

        // Después de procesar el pago, mostrar la factura
        controladorFactura.mostrarFactura("Tarjeta de Crédito/Débito");
    }
}
