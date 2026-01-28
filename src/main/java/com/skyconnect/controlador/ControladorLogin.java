/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skyconnect.controlador;

/**
 *
 * @author mateo
 */
public class ControladorLogin {
    /**
    * Controlador encargado de gestionar
    * el proceso de inicio de sesión y registro.
    */
    public boolean validarCampos(String usuario, String clave) {
        return usuario != null && !usuario.isEmpty()
            && clave != null && !clave.isEmpty();
    }

    public boolean autenticar(String usuario, String clave) {
        // Lógica provisional (luego se conecta a UsuarioDAO)
        return usuario.equals("admin") && clave.equals("1234");
    }
}
