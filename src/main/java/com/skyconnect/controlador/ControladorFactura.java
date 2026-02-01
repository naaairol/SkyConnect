package com.skyconnect.controlador;

import com.skyconnect.modelo.Factura;
import com.skyconnect.vista.FacturaView;
import com.skyconnect.vista.MainFrame;

public class ControladorFactura {

    private Factura factura;
    private MainFrame mainFrame;

    // Constructor
    public ControladorFactura(MainFrame mainFrame, Factura factura) {
        this.mainFrame = mainFrame;
        this.factura = factura;
    }

    // Método para mostrar la factura
    public void mostrarFactura(String metodoPago) {
        // Crear una instancia de la vista de la factura con el método de pago
        FacturaView facturaView = new FacturaView(mainFrame, factura, metodoPago);
        
        // Asegurarnos de agregar la vista de factura al contenedor del MainFrame
        mainFrame.setContentPane(facturaView);  // Cambiar el contenedor del JFrame
        mainFrame.revalidate();  // Refrescar el JFrame para que se muestre correctamente
        mainFrame.repaint();  // Asegurarse de que la interfaz se actualice visualmente 
    }
}