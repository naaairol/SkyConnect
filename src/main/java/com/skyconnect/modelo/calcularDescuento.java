package com.skyconnect.modelo;

public class calcularDescuento {
    
    public static void asignarDescuento(Pasajero pasajero, Vuelo vuelo){
        if (pasajero == null || vuelo == null || vuelo.getRuta() == null) {
        return; 
        }
        
        String IATAorigen = vuelo.getRuta().getAeroSalida().getCodigoIATA();
        float descuentoCalculado = 0.0f;
        
        switch (IATAorigen){
            case "UIO" -> {
                if (pasajero instanceof AdultoMayor) {
                    descuentoCalculado = 0.50f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.25f;
                } else if (pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.50f;
                }
            }
            case "GYE" -> {
                if (pasajero instanceof AdultoMayor) {
                    descuentoCalculado = 0.50f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.25f;
                } else if (pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.50f;
                }
            }
            case "CUE" -> {
                if (pasajero instanceof AdultoMayor) {
                    descuentoCalculado = 0.50f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.80f;
                } else if (pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.50f;
                }
            }
            case "GPS" -> {
                if (pasajero instanceof AdultoMayor) {
                    descuentoCalculado = 0.50f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.80f;
                } else if (pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.50f;
                }
            }
            case "MAD" -> {
                if (pasajero instanceof AdultoMayor) {
                    descuentoCalculado = 0.80f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.30f;
                } else if (pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.80f;
                }
            }
            case "MIA" -> {
                if (pasajero instanceof AdultoMayor) {
                    descuentoCalculado = 0.85f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.85f;
                } else if (pasajero instanceof Discapacitado) {
                    descuentoCalculado = 1.00f;
                }
            }
            case "PTY" -> {
                if (pasajero instanceof AdultoMayor) {
                    descuentoCalculado = 0.75f;
                } else if (pasajero instanceof Ninio) {
                    descuentoCalculado = 0.85f;
                } else if (pasajero instanceof Discapacitado) {
                    descuentoCalculado = 0.75f;
                }
            }
            default -> descuentoCalculado = 1.00f;
        }
        pasajero.setDescuento(descuentoCalculado);
    }
    
    public static float precioConDescuento(Pasajero pasajero, Vuelo vuelo) {
        float precioBase = vuelo.getPrecioEstimado();
        float descuento = pasajero.getDescuento();
        
        return precioBase * descuento;
    }
    
}
