/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skyconnect.modelo;

/**
 * Clase que gestiona la sesión actual de la aplicación,
 * almacenando temporalmente la información del usuario
 * autenticado y la clase de vuelo seleccionada durante
 * la navegación entre vistas.
 */
public class Sesion {
    private static Usuario usuarioActual;
    private static String claseVueloSeleccionada;

    public static void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }

    public static boolean estaLogueado() {
        return usuarioActual != null;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setClaseVueloSeleccionada(String clase) {
        claseVueloSeleccionada = clase;
    }

    public static String getClaseVueloSeleccionada() {
        return claseVueloSeleccionada;
    }
}