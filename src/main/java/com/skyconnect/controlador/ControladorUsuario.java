/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skyconnect.controlador;

import com.skyconnect.modelo.Usuario;
import com.skyconnect.vista.MainFrame;

public class ControladorUsuario {
    private MainFrame mainFrame; 
    //Constructor
    public ControladorUsuario(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
}
    /**
     * Controlador que gestiona la autenticación
     * y registro de usuarios del sistema.
     */
    public boolean iniciarSesion(String correo, String clave) {
        // Lógica real se implementará después
        return true;
    }

    public void registrarUsuario(Usuario usuario) {
        // Implementación futura
    }
    
    public void registrarUsuario(String nombre, String apellido, String correo, String clave) {
    // Aquí luego irá la lógica real de registro (validaciones, BD, etc.)
    System.out.println("Usuario registrado:");
    System.out.println(nombre + " " + apellido + " - " + correo);
    }
}
