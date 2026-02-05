package com.skyconnect.vista;

import com.skyconnect.controlador.ControladorBusqueda;
import com.skyconnect.controlador.ControladorDescuentos;
import com.skyconnect.controlador.ControladorVuelo;
import com.skyconnect.modelo.Pasajero;
import com.skyconnect.modelo.Vuelo;
import java.util.ArrayList;
import com.skyconnect.vista.VueloIVUELTAView;
import javax.swing.JOptionPane;

public class VueloIDAVUELTAView extends javax.swing.JPanel {

    ControladorBusqueda controladorBusqueda;
    private ControladorDescuentos controladorPasajeros;
    private ArrayList<Vuelo> vuelosMostrados; // Para identificar qué vuelo se seleccionó
    /**
     * Creates new form VueloIDAVUELTAView
     */
    private MainFrame mainFrame; 
    // Constructor que inicializa la vista y permite la navegación entre pantallas
    // a través del MainFrame usando CardLayout.
    public VueloIDAVUELTAView(MainFrame mainFrame, ControladorBusqueda controladorBusqueda, ControladorDescuentos controladorPasajero) {
        this.mainFrame = mainFrame;
        this.controladorBusqueda = controladorBusqueda;
        this.vuelosMostrados = new ArrayList<>();
        
        initComponents();
        
        java.net.URL imgURL = getClass().getResource("/imagenes/Vuelo.jpg");
        if (imgURL != null) {
            jLabelDAVUELTA.setIcon(new javax.swing.ImageIcon(imgURL));
        }
    }
    
    public void setControladorPasajeros(ControladorDescuentos controlador) {
        this.controladorPasajeros = controlador;
    }
    
    public void cargarDatosYBuscar() {
        //Crea un controlador para obtener el arreglo con todos los vuelos
        ControladorVuelo controlador = new ControladorVuelo();
        ArrayList<Vuelo> vuelos = controlador.obtenerVuelos();
        //Toma toda la lista de vuelos, pero solo devuelve y dibuja los que
        //nos interesa, o sea los seleccionados por el usuario
        mostrarVuelos(vuelos);
    }
    
    public void mostrarVuelos(ArrayList<Vuelo> todosLosVuelos) {
        limpiarCampos();
        vuelosMostrados.clear();
        //Controlador toma todos los vuelos y devuelve los 
        //que coinciden con lo que quiere el usuario
        ArrayList<Vuelo> vuelosFiltrados = controladorBusqueda.buscarVuelosIDA(todosLosVuelos);

        //La visa muestra los vuelos que son los que quiere el usuario
        for (int i = 0; i < vuelosFiltrados.size() && i < 3; i++) {
            Vuelo v = vuelosFiltrados.get(i);
            vuelosMostrados.add(v);
            switch (i) {
                case 0 -> cargarVuelo1(v);
                case 1 -> cargarVuelo2(v);
                case 2 -> cargarVuelo3(v);
            }
        }
    }
    
    private void seleccionarVuelo(int indice) {
        // 1. Validaciones
        if (controladorPasajeros == null) {
            JOptionPane.showMessageDialog(this, "Error: No se han recibido datos de pasajeros.");
            return;
        }

        if (indice < vuelosMostrados.size()) {
            // 2. Obtener el vuelo real
            Vuelo vueloSeleccionado = vuelosMostrados.get(indice);
            
            // A. Guardamos el PRECIO de este vuelo
            controladorBusqueda.setPrecioVueloSeleccionado(vueloSeleccionado.getPrecioEstimado());
            
            // B. Guardamos la HORA real de este vuelo
            controladorBusqueda.setHoraVueloSeleccionado(vueloSeleccionado.getHoraSalida());


            JOptionPane.showMessageDialog(this, "Vuelo de IDA seleccionado.\nPrecio: $" + vueloSeleccionado.getPrecioEstimado());
        }
    }
    
    //Metodos para que aparezcan los vuelos
    private void cargarVuelo1(Vuelo v) {
        txtFDestinoV1.setText(v.getRuta().getAeroLlegada().getCiudad());
        txtFFechaV1.setText(v.getFechaSalida());
        txtFDuracionV1.setText(v.getDuracion());
        txtFCostoV1.setText(String.valueOf(v.getPrecioEstimado()));
    }

    private void cargarVuelo2(Vuelo v) {
        txtFDestinoV2.setText(v.getRuta().getAeroLlegada().getCiudad());
        txtFFechaV2.setText(v.getFechaSalida());
        txtFDuracionV2.setText(v.getDuracion());
        txtFCostoV2.setText(String.valueOf(v.getPrecioEstimado()));
    }

    private void cargarVuelo3(Vuelo v) {
        txtFDestinoV3.setText(v.getRuta().getAeroLlegada().getCiudad());
        txtFFechaV3.setText(v.getFechaSalida());
        txtFDuracionV3.setText(v.getDuracion());
        txtFCostoV3.setText(String.valueOf(v.getPrecioEstimado()));
    }
    
    // Limpia
    private void limpiarCampos() {
        txtFDestinoV1.setText("");
        txtFFechaV1.setText("");
        txtFDuracionV1.setText("");
        txtFCostoV1.setText("");

        txtFDestinoV2.setText("");
        txtFFechaV2.setText("");
        txtFDuracionV2.setText("");
        txtFCostoV2.setText("");

        txtFDestinoV3.setText("");
        txtFFechaV3.setText("");
        txtFDuracionV3.setText("");
        txtFCostoV3.setText("");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnPredeterminadoGuayaquil = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFDestinoV1 = new javax.swing.JTextField();
        txtFFechaV1 = new javax.swing.JTextField();
        txtFDuracionV1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtFCostoV1 = new javax.swing.JTextField();
        radBtnVuelo1 = new javax.swing.JRadioButton();
        btnPredeterminadoGuayaquil1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtFDestinoV2 = new javax.swing.JTextField();
        txtFFechaV2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFDuracionV2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFCostoV2 = new javax.swing.JTextField();
        radBtnVuelo2 = new javax.swing.JRadioButton();
        btnPredeterminadoGuayaquil2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtFDestinoV3 = new javax.swing.JTextField();
        txtFFechaV3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFDuracionV3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFCostoV3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        radBtnVuelo3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabelDAVUELTA = new javax.swing.JLabel();
        txtObtenerNombreUsuario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel8.setText("Escoja su vuelo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 460, 60));

        btnPredeterminadoGuayaquil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPredeterminadoGuayaquil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        btnPredeterminadoGuayaquil.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 79, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setText("Estimado IDA      ");
        btnPredeterminadoGuayaquil.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 124, -1, -1));

        txtFDestinoV1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFDestinoV1.setEnabled(false);
        btnPredeterminadoGuayaquil.add(txtFDestinoV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 283, 44));

        txtFFechaV1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFFechaV1.setEnabled(false);
        txtFFechaV1.addActionListener(this::txtFFechaV1ActionPerformed);
        btnPredeterminadoGuayaquil.add(txtFFechaV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 283, 46));

        txtFDuracionV1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFDuracionV1.setEnabled(false);
        txtFDuracionV1.setName(""); // NOI18N
        btnPredeterminadoGuayaquil.add(txtFDuracionV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 192, 45));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("USD");
        btnPredeterminadoGuayaquil.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 166, 56, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Duración:");
        btnPredeterminadoGuayaquil.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnPredeterminadoGuayaquil.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, 196));

        txtFCostoV1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFCostoV1.setEnabled(false);
        txtFCostoV1.addActionListener(this::txtFCostoV1ActionPerformed);
        btnPredeterminadoGuayaquil.add(txtFCostoV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 120, 45));

        buttonGroup1.add(radBtnVuelo1);
        radBtnVuelo1.setText("Seleccionar");
        radBtnVuelo1.addActionListener(this::radBtnVuelo1ActionPerformed);
        btnPredeterminadoGuayaquil.add(radBtnVuelo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jPanel1.add(btnPredeterminadoGuayaquil, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 680, 210));

        btnPredeterminadoGuayaquil1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPredeterminadoGuayaquil1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        btnPredeterminadoGuayaquil1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 37, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnPredeterminadoGuayaquil1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, -1, 196));

        txtFDestinoV2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFDestinoV2.setEnabled(false);
        btnPredeterminadoGuayaquil1.add(txtFDestinoV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 18, 283, 50));

        txtFFechaV2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFFechaV2.setEnabled(false);
        txtFFechaV2.addActionListener(this::txtFFechaV2ActionPerformed);
        btnPredeterminadoGuayaquil1.add(txtFFechaV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 283, 45));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Duración:");
        btnPredeterminadoGuayaquil1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 151, -1, -1));

        txtFDuracionV2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFDuracionV2.setEnabled(false);
        txtFDuracionV2.setName(""); // NOI18N
        btnPredeterminadoGuayaquil1.add(txtFDuracionV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 140, 188, 46));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setText("Estimado IDA      ");
        btnPredeterminadoGuayaquil1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 107, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("USD");
        btnPredeterminadoGuayaquil1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 149, 45, 30));

        txtFCostoV2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFCostoV2.setEnabled(false);
        txtFCostoV2.addActionListener(this::txtFCostoV2ActionPerformed);
        btnPredeterminadoGuayaquil1.add(txtFCostoV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 140, 112, 50));

        buttonGroup1.add(radBtnVuelo2);
        radBtnVuelo2.setText("Seleccionar");
        radBtnVuelo2.addActionListener(this::radBtnVuelo2ActionPerformed);
        btnPredeterminadoGuayaquil1.add(radBtnVuelo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jPanel1.add(btnPredeterminadoGuayaquil1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 680, 210));

        btnPredeterminadoGuayaquil2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnPredeterminadoGuayaquil2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        btnPredeterminadoGuayaquil2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 73, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );

        btnPredeterminadoGuayaquil2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 8, -1, -1));

        txtFDestinoV3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFDestinoV3.setEnabled(false);
        btnPredeterminadoGuayaquil2.add(txtFDestinoV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 18, 277, 49));

        txtFFechaV3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFFechaV3.setEnabled(false);
        txtFFechaV3.addActionListener(this::txtFFechaV3ActionPerformed);
        btnPredeterminadoGuayaquil2.add(txtFFechaV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 79, 277, 49));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("Duración:");
        btnPredeterminadoGuayaquil2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 152, -1, -1));

        txtFDuracionV3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFDuracionV3.setEnabled(false);
        txtFDuracionV3.setName(""); // NOI18N
        btnPredeterminadoGuayaquil2.add(txtFDuracionV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 144, 183, 44));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setText("USD");
        btnPredeterminadoGuayaquil2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 150, 45, 30));

        txtFCostoV3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtFCostoV3.setEnabled(false);
        txtFCostoV3.addActionListener(this::txtFCostoV3ActionPerformed);
        btnPredeterminadoGuayaquil2.add(txtFCostoV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 137, 119, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setText("Estimado IDA     ");
        btnPredeterminadoGuayaquil2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 101, -1, -1));

        buttonGroup1.add(radBtnVuelo3);
        radBtnVuelo3.setText("Seleccionar");
        radBtnVuelo3.addActionListener(this::radBtnVuelo3ActionPerformed);
        btnPredeterminadoGuayaquil2.add(radBtnVuelo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jPanel1.add(btnPredeterminadoGuayaquil2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 720, 680, 210));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setText("Escoga su vuelo de vuelta");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 910, 300, 64));

        jLabelDAVUELTA.setText("jLabel13");
        jPanel1.add(jLabelDAVUELTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 1000));

        txtObtenerNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtObtenerNombreUsuario.setEnabled(false);
        jPanel1.add(txtObtenerNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 40, 190, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Usuario:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 40, 80, 40));

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

    private void txtFFechaV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFFechaV1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFFechaV1ActionPerformed

    private void txtFCostoV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFCostoV1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFCostoV1ActionPerformed

    private void txtFFechaV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFFechaV2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFFechaV2ActionPerformed

    private void txtFCostoV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFCostoV2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFCostoV2ActionPerformed

    private void txtFFechaV3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFFechaV3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFFechaV3ActionPerformed

    private void txtFCostoV3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFCostoV3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFCostoV3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            //No vuelve a instanciar VueloIDAVUELTA, sino que obtiene la ventana creada antes
            VueloIVUELTAView vueloIVUELTAView = mainFrame.getVueloVUELTAView();
            
            vueloIVUELTAView.setControladorPasajeros(this.controladorPasajeros);
            //Con los datos obtenidos, vueloIDAView muestra los vuelos
            vueloIVUELTAView.cargarDatosYBuscar();
            mainFrame.mostrarVista("VUELOS VUELTA");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radBtnVuelo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnVuelo1ActionPerformed
        // TODO add your handling code here:
        seleccionarVuelo(0);
    }//GEN-LAST:event_radBtnVuelo1ActionPerformed

    private void radBtnVuelo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnVuelo2ActionPerformed
        // TODO add your handling code here:
        seleccionarVuelo(1);
    }//GEN-LAST:event_radBtnVuelo2ActionPerformed

    private void radBtnVuelo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnVuelo3ActionPerformed
        // TODO add your handling code here:
        seleccionarVuelo(2);
    }//GEN-LAST:event_radBtnVuelo3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPredeterminadoGuayaquil;
    private javax.swing.JPanel btnPredeterminadoGuayaquil1;
    private javax.swing.JPanel btnPredeterminadoGuayaquil2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDAVUELTA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton radBtnVuelo1;
    private javax.swing.JRadioButton radBtnVuelo2;
    private javax.swing.JRadioButton radBtnVuelo3;
    private javax.swing.JTextField txtFCostoV1;
    private javax.swing.JTextField txtFCostoV2;
    private javax.swing.JTextField txtFCostoV3;
    private javax.swing.JTextField txtFDestinoV1;
    private javax.swing.JTextField txtFDestinoV2;
    private javax.swing.JTextField txtFDestinoV3;
    private javax.swing.JTextField txtFDuracionV1;
    private javax.swing.JTextField txtFDuracionV2;
    private javax.swing.JTextField txtFDuracionV3;
    private javax.swing.JTextField txtFFechaV1;
    private javax.swing.JTextField txtFFechaV2;
    private javax.swing.JTextField txtFFechaV3;
    private javax.swing.JTextField txtObtenerNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
