package com.skyconnect.controlador;

import com.skyconnect.modelo.Sesion;

/**
 * Controlador encargado de gestionar
 * la selección de la clase del vuelo.
 */
public class ControladorClaseVuelo {

    // Guarda la clase seleccionada en la sesión
    public void seleccionarClase(String clase) {
        Sesion.setClaseVueloSeleccionada(clase);
    }

    // Indica si el usuario ya inició sesión
    public boolean usuarioEstaLogueado() {
        return Sesion.estaLogueado();
    }
}