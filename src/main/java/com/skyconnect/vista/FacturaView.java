package com.skyconnect.vista;

import com.skyconnect.controlador.ControladorBusqueda;
import com.skyconnect.controlador.ControladorPasajeros;
import com.skyconnect.modelo.Pasajero;
import java.util.List;

public class FacturaView extends javax.swing.JPanel {
    private MainFrame mainFrame;

    // Constructor que inicializa la vista con los datos de la factura.
    // Constructor limpio (sin pasarle datos todavía)
    public FacturaView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        
        java.net.URL imgURL = getClass().getResource("/imagenes/Factura.jpg");
        if (imgURL != null) {
            jLabelFactura.setIcon(new javax.swing.ImageIcon(imgURL));
        }
    }
    // Método para mostrar los datos de la factura en un JTextArea.
    public void generarFactura(ControladorBusqueda ctrlBusqueda, ControladorPasajeros ctrlPasajeros, String metodoPago) {
        
        StringBuilder ticket = new StringBuilder();
        
        // 1. Validar datos
        if (ctrlBusqueda == null || ctrlPasajeros == null) {
            txtFacturaFinal.setText("Error: No hay datos de vuelo o pasajeros.");
            return;
        }

        // 2. Variables para cálculos (Igual que en PagoView para que cuadre)
        double precioBaseUnitario = ctrlBusqueda.getPrecioVueloSeleccionado();
        double subtotalBase = 0;
        double totalDescuentos = 0;
        double totalExtras = 0;
        
        List<Pasajero> lista = ctrlPasajeros.getListaPasajeros();
        
        // 3. Encabezado
        ticket.append("************************************************\n");
        ticket.append("             SKYCONNECT AIRLINES             \n");
        ticket.append("************************************************\n\n");
        
        ticket.append("FECHA DE EMISIÓN: ").append(java.time.LocalDate.now()).append("\n");
        ticket.append("MÉTODO DE PAGO:   ").append(metodoPago).append("\n\n");
        
        ticket.append("=== DETALLES DEL VUELO ===\n");
        ticket.append("Origen:   ").append(ctrlBusqueda.getOrigen()).append("\n");
        ticket.append("Destino:  ").append(ctrlBusqueda.getDestino()).append("\n");
        ticket.append("Fecha:    ").append(ctrlBusqueda.getFechaIda()).append("\n");
        ticket.append("Horario:  ").append(ctrlBusqueda.getHoraVueloSeleccionado()).append("\n");
        ticket.append("------------------------------------------------\n\n");

        ticket.append("=== DETALLES DE PASAJEROS ===\n");
        
        // 4. Bucle de Pasajeros y Cálculos
        for (Pasajero p : lista) {
            subtotalBase += precioBaseUnitario;
            
            // Cálculo Descuento
            double ahorro = precioBaseUnitario * (1.0 - p.getDescuento());
            totalDescuentos += ahorro;
            
            // Cálculo Extras
            String extraTxt = "";
            if (p.isEquipajeExtra()) {
                totalExtras += 40.00;
                extraTxt = " (+Maleta $40)";
            }
            
            // Imprimir línea por pasajero
            ticket.append("- ").append(p.getNombre().toUpperCase())
                  .append(" ").append(p.getApellido().toUpperCase())
                  .append("\n  Asiento: ").append(p.getCodigoAsiento())
                  .append(extraTxt).append("\n");
        }
        
        // 5. Cálculos Finales
        double baseMenosDescuento = subtotalBase - totalDescuentos;
        double impuestos = baseMenosDescuento * 0.12;
        double granTotal = baseMenosDescuento + impuestos + totalExtras;

        ticket.append("------------------------------------------------\n");
        ticket.append("=== DESGLOSE DE PAGO ===\n");
        ticket.append(String.format("Precio Base (%d pax):   $ %8.2f\n", lista.size(), subtotalBase));
        ticket.append(String.format("Descuentos Aplicados:  -$ %8.2f\n", totalDescuentos));
        ticket.append(String.format("Equipaje Adicional:     $ %8.2f\n", totalExtras));
        ticket.append(String.format("Impuestos (IVA 12%%):    $ %8.2f\n", impuestos));
        ticket.append("================================================\n");
        ticket.append(String.format("TOTAL PAGADO:           $ %8.2f\n", granTotal));
        ticket.append("================================================\n\n");
        
        ticket.append("      ¡Gracias por volar con SkyConnect!      \n");
        ticket.append("************************************************\n");

        // 6. Mostrar en el área de texto
        txtFacturaFinal.setText(ticket.toString());
        
        // Opcional: Bloquear edición y poner cursor al inicio
        txtFacturaFinal.setEditable(false);
        txtFacturaFinal.setCaretPosition(0);
    }

    // Método para regresar a la vista anterior (ej. PagoView)
    private void regresar() {
        mainFrame.mostrarVista("PAGO"); // Redirige a la vista de pago
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFacturaFinal = new javax.swing.JTextArea();
        jLabelFactura = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 36))); // NOI18N
        jPanel2.setOpaque(false);

        txtFacturaFinal.setColumns(20);
        txtFacturaFinal.setRows(5);
        jScrollPane1.setViewportView(txtFacturaFinal);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, -1));

        jLabelFactura.setText("jLabel1");
        jPanel1.add(jLabelFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1690, 1000));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.setEnabled(false);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 50, 190, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Usuario:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 50, 80, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabelFactura;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txtFacturaFinal;
    // End of variables declaration//GEN-END:variables
    }
