package com.skyconnect.controlador;

import com.skyconnect.modelo.Pasajero;
import com.skyconnect.modelo.PasajeroDAO;
import com.skyconnect.vista.RegistroPasajeroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorPasajeros implements ActionListener{
    private RegistroPasajeroView vista;
    private PasajeroDAO modeloDAO;
    private List<Pasajero> listaPasajeros;
    private int indiceActual = 0; //Para saber que pasajero se esta registrando 
    
    public ControladorPasajeros(RegistroPasajeroView vista, PasajeroDAO modeloDAO, List<Pasajero> listaPasajeros){
        this.vista = vista;
        this.modeloDAO = modeloDAO;
        this.listaPasajeros = listaPasajeros;
        //Boton guardar de la vista
        this.vista.addBtnGuardarListener(this);
        
        // Inicializar el label con el primer pasajero al abrir la vista
        if (this.listaPasajeros != null && !this.listaPasajeros.isEmpty()) {
            String tipo = this.listaPasajeros.get(0).getClass().getSimpleName();
            this.vista.actualizarIdentificador(tipo, 1);
        }
        
    }
    
    private void registrarPasajeroActual() {
        
        //Verificar si aún quedan pasajeros por registrar en la lista
        if (indiceActual >= listaPasajeros.size()) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Todos los pasajeros ya han sido registrados.");
            return;
        }
        //Extraer datos de la vista
        String nombre = vista.getNombre();
        String apellido = vista.getApellido();
        String cedula = vista.getCedula();
        String pasaporte = vista.getPasaporte();

        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Por favor complete los campos obligatorios.");
            return;
        }

        //Obtener el objeto Pasajero de la lista y actualizar sus datos
        Pasajero p = listaPasajeros.get(indiceActual);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setCedula(cedula);
        p.setPasaporte(pasaporte);

        if (modeloDAO.guardarPasajeros(p)) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Pasajero registrado con éxito.");
            vista.limpiarCampos(); // Limpiamos para el siguiente pasajero
            indiceActual++;

        }else {
            javax.swing.JOptionPane.showMessageDialog(vista, "Error al guardar en el archivo.");
        }
        
        //Actualizacion del label
        if (indiceActual < listaPasajeros.size()) {
            Pasajero siguiente = listaPasajeros.get(indiceActual);
            // Obtenemos el nombre del tipo de pasajero
            String tipo = siguiente.getClass().getSimpleName();
            // Actualizamos el label
            vista.actualizarIdentificador(tipo, indiceActual + 1);
        } else {
            // Si ya no hay más, avisamos en el label
            vista.actualizarIdentificador("TODOS REGISTRADOS", 0);
        }
    }
    
    // Agrega esto al final de ControladorPasajeros.java
    public List<Pasajero> getListaPasajeros() {
        return this.listaPasajeros;
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Guardar")) {
                registrarPasajeroActual();
            }
        }

        
}
