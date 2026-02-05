package com.skyconnect.vista;
import com.skyconnect.controlador.ControladorBusqueda;
import com.skyconnect.controlador.ControladorPago;
import com.skyconnect.controlador.ControladorDescuentos;
import com.skyconnect.controlador.ControladorPasajeros;
import com.skyconnect.controlador.ControladorReserva;
import com.skyconnect.controlador.ControladorUsuario;
import com.skyconnect.modelo.Factura;
import com.skyconnect.modelo.Pasajero;
import com.skyconnect.modelo.PasajeroDAO;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    private CardLayout cardLayout;
    private ControladorReserva controladorReserva;
    private ControladorPago controladorPago;
    private ControladorBusqueda controladorBusqueda;
    private ControladorDescuentos controladorDescuentos;
    private ControladorUsuario controladorUsuario;
    private ControladorPasajeros controladorPasajeros;

    
    // ===== VISTAS (UNA SOLA INSTANCIA) =====
    private InicioView inicioView;
    private LoginView loginView;
    private BuscarVueloView buscarVueloView;
    private RegistroPasajeroView registroPasajeroView; 
    private VueloIDAView vueloIDAView; 
    private VueloIDAVUELTAView vueloIDAVUELTAView;
    private VueloIVUELTAView vueloIVUELTAView; 
    private ClaseVueloView claseVueloView;
    private AsientosView asientosView;
    private EquipajeExtraView equipajeExtraView;
    //private BoletoView boletoView; 
    private IniciarSesionView iniciarSesionView;
    private CreacionUsuarioView creacionUsuarioView;
    private PagoView pagoView;
    private TarjetaView tarjetaView; 
    private PayPalView payPalView;
    private FacturaView facturaView; // Añadido para la vista de factura
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        inicializarVistas();
    }
    
    private void inicializarVistas() {

        cardLayout = (CardLayout) PanelContenedor.getLayout();

        // CONTROLADORES (UNA SOLA INSTANCIA)
        controladorReserva = new ControladorReserva();
        
        controladorPago = new ControladorPago(this);
        
        // Inicializamos el ControladorBusqueda
        controladorBusqueda = new ControladorBusqueda();
        
        // Crear la reserva antes de instanciar el controladorPago
        Factura reserva = controladorReserva.getReserva();  // Obtener la reserva de controladorReserva
        
        //Preparamos los datos necesarios
        List<Pasajero> listaCompartida = new ArrayList<>();
        PasajeroDAO dao = new PasajeroDAO(); // Asegúrate de tener esta clase

        controladorPasajeros = new ControladorPasajeros(dao, listaCompartida);

        controladorDescuentos = new ControladorDescuentos(); // Asegúrate de iniciarlo también
        registroPasajeroView = new RegistroPasajeroView(this, controladorDescuentos, controladorPasajeros);
        
        // Inicializar AsientosView (Asegúrate de importar la clase si te lo pide)
        asientosView = new AsientosView(this); 
    
        // Agregarla al panel de cartas con el nombre "ASIENTOS" (IMPORTANTE: Debe ser mayúscula igual que en tu otro código)
        PanelContenedor.add(asientosView, "ASIENTOS");
        
        // VISTAS
        inicioView = new InicioView(this);
        buscarVueloView = new BuscarVueloView(this, controladorBusqueda, controladorDescuentos);
        iniciarSesionView = new IniciarSesionView(this, controladorUsuario, controladorPasajeros, controladorDescuentos);
        creacionUsuarioView = new CreacionUsuarioView(this, controladorUsuario);
        registroPasajeroView = new RegistroPasajeroView(this, controladorDescuentos, controladorPasajeros); 
        vueloIDAView = new VueloIDAView(this, controladorBusqueda);
        vueloIDAVUELTAView = new VueloIDAVUELTAView(this, controladorBusqueda, controladorDescuentos);
        vueloIVUELTAView = new VueloIVUELTAView(this, controladorBusqueda, controladorDescuentos);
        claseVueloView = new ClaseVueloView(this);
        asientosView = new AsientosView(this);
        equipajeExtraView = new EquipajeExtraView(this, controladorReserva);
        //boletoView = new BoletoView(this);
        loginView = new LoginView(this);
        pagoView = new PagoView(this);
        tarjetaView = new TarjetaView(this, controladorPago);
        //payPalView = new PayPalView(this, controladorPago);
        
        // FacturaView: la vista de la factura
        facturaView = new FacturaView(this);

        // CARD LAYOUT
        PanelContenedor.add(inicioView, "INICIO");
        PanelContenedor.add(buscarVueloView, "BUSCAR");
        PanelContenedor.add(loginView, "LOGIN");
        PanelContenedor.add(iniciarSesionView, "INICIAR");
        PanelContenedor.add(registroPasajeroView, "REGISTRO");
        PanelContenedor.add(vueloIDAView, "VUELOS IDA");
        PanelContenedor.add(vueloIDAVUELTAView, "VUELOS IDA Y VUELTA");
        PanelContenedor.add(vueloIVUELTAView, "VUELOS VUELTA");
        PanelContenedor.add(claseVueloView, "CLASE");
        PanelContenedor.add(asientosView, "ASIENTOS");
        PanelContenedor.add(equipajeExtraView, "EQUIPAJE");
        //PanelContenedor.add(boletoView, "BOLETO");
        PanelContenedor.add(creacionUsuarioView, "CREAR");
        PanelContenedor.add(pagoView, "PAGO");
        PanelContenedor.add(tarjetaView, "TARJETA");
        //PanelContenedor.add(payPalView, "PAYPAL");
        
        // Agregar FacturaView al CardLayout
        PanelContenedor.add(facturaView, "FACTURA");
        
        // Inicializamos la vista de inicio
        mostrarVista("INICIO");
    }

    //Getters para pedir las ventanas sin crear una nueva instancia
    public void mostrarVista(String nombreVista) {
        cardLayout.show(PanelContenedor, nombreVista);
        
        if (nombreVista.equals("PAGO")) {
            if (pagoView != null) {
                pagoView.cargarDatosCalculados(this.controladorBusqueda, this.controladorPasajeros);
            }
        }
        
        if (nombreVista.equals("FACTURA")) {
            if (facturaView != null) {
                // Pasamos el método de pago guardado
                facturaView.generarFactura(this.controladorBusqueda, this.controladorPasajeros, this.metodoPagoActual);
            }
        }
    }
    
    public VueloIDAView getVueloIDAView() {
        return vueloIDAView;
    }

    public VueloIDAVUELTAView getVueloIDAVUELTAView() {
        return vueloIDAVUELTAView;
    }
    
    public VueloIVUELTAView getVueloVUELTAView() {
        return vueloIVUELTAView;
    }

    public IniciarSesionView getIniciarSesionView() {
        return iniciarSesionView;
    }
    
    public RegistroPasajeroView getRegistroPasajeroView() {
        return registroPasajeroView;
    }
    
    public LoginView getLoginView() {
        return loginView;
    }
    
    // Para que todos usen el mismo controlador, es decir, los mismos datos
    public ControladorBusqueda getControladorBusqueda() {
        return controladorBusqueda;
    }
    
    // Para que todos usen el mismo controlador, es decir, los mismos datos
    public ControladorDescuentos getControladorDescuentos() {
        return controladorDescuentos;
    }
    
    public AsientosView getAsientosView() {
        return asientosView;
    }
    private String metodoPagoActual = "Desconocido"; 

    // 2. El método que te está marcando error en rojo
    public void setMetodoPagoActual(String metodo) {
        this.metodoPagoActual = metodo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelContenedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelContenedor.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContenedor;
    // End of variables declaration//GEN-END:variables
}
