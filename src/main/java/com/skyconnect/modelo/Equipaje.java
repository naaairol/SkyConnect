/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skyconnect.modelo;

/**
 * Modelo que representa equipaje adicional.
 */
public class Equipaje {

    private String tipo;
    private String propietario;
    private double peso;
    private double precioBase;

    public Equipaje(String tipo, String propietario, double peso) {
        this.tipo = tipo;
        this.propietario = propietario;
        this.peso = peso;
        this.precioBase = calcularPrecio();
    }

    private double calcularPrecio() {
        // Regla de negocio simple (ejemplo)
        if (peso <= 10) return 20.0;
        if (peso <= 20) return 40.0;
        return 60.0;
    }
    
    public String getTipo() { return tipo; }
    public String getPropietario() { return propietario; }
    public double getPeso() { return peso; }
    public double getPrecioBase() { return precioBase; }
}
