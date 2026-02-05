package com.skyconnect.controlador;

import com.skyconnect.vista.MainFrame;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorPago {
    private MainFrame mainFrame;
 

    // Constructor
    public ControladorPago(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    // ============================
    // Método para procesar pagos con PayPal
    // ============================
    public void procesarPagoPayPal(String correo, String contrasena) {
        if (correo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Correo y contraseña son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación exitosa
        JOptionPane.showMessageDialog(null, "Pago realizado con éxito con PayPal.", "Pago Aprobado", JOptionPane.INFORMATION_MESSAGE);

        // --- MAGIA: CAMBIAR A LA PANTALLA DE FACTURA ---
        mainFrame.setMetodoPagoActual("PayPal"); // Guardamos el método
        mainFrame.mostrarVista("FACTURA");       // Cambiamos de vista
    }

    // ============================
    // Método para procesar pagos con tarjeta
    // ============================
    public void procesarPagoTarjeta(String numeroTarjeta, String fechaVencimiento, String cvv) {
        // Validaciones
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

        // Validación exitosa
        JOptionPane.showMessageDialog(null, "Pago con tarjeta realizado con éxito", "Pago Aprobado", JOptionPane.INFORMATION_MESSAGE);

        // --- MAGIA: CAMBIAR A LA PANTALLA DE FACTURA ---
        mainFrame.setMetodoPagoActual("Tarjeta de Crédito"); // Guardamos el método
        mainFrame.mostrarVista("FACTURA");                   // Cambiamos de vista
    }
}
