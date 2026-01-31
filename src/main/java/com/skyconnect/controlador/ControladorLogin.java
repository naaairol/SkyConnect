/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skyconnect.controlador;

import com.skyconnect.vista.MainFrame;

/**
 *
 * @author mateo
 */
public class ControladorLogin {
    /**
    * Controlador encargado de gestionar
    * el proceso de inicio de sesión y registro.
    */
    private MainFrame mainFrame;

    public ControladorLogin(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void irAIniciarSesion() {
        mainFrame.mostrarVista("INICIAR");
    }

    public void irACrearUsuario() {
        mainFrame.mostrarVista("CREAR");
    }
    public boolean validarCampos(String usuario, String clave) {
    return usuario != null && !usuario.isEmpty()
        && clave != null && !clave.isEmpty();
    }

    public boolean autenticar(String usuario, String clave) {
    // Simulación básica (luego irá BD)
    return usuario.equals("admin@sky.com") && clave.equals("1234");
    }

    public void loginExitoso() {
    mainFrame.mostrarVista("AsientosView");
    }
}
