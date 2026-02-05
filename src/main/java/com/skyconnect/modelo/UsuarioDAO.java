package com.skyconnect.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class UsuarioDAO {
    
    private final static String RUTA = "database/usuarios.txt";
    
    public static ArrayList<Usuario> cargarUsuarios(String rutaArchivo) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                
                if (partes.length == 4) {
                    try {
                        String nombre = partes[0];
                        String apellido = partes[1];
                        String correo = partes[2];
                        String password = partes[3];
                        
                            Usuario usuario = new Usuario(
                                nombre,
                                apellido,
                                correo,
                                password);
                            usuarios.add(usuario);

                    } catch (NumberFormatException e) {
                        System.err.println("Error al procesar línea: " + linea + " por " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo de usuarios: " + e.getMessage());
        }
        return usuarios;
    }
    
    public static boolean guardarUsuarios(Usuario usuario) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {
            
            String linea = usuario.getNombre() + "," 
                     + usuario.getApellido() + "," 
                     + usuario.getCorreo() + "," 
                     + usuario.getPassword();
            
            bw.write(linea);
            bw.newLine();
        
            return true;
        
        } catch (IOException e) {
        System.err.println("Error guardando el usuario: " + e.getMessage());
        return false;
        }
    }  
}
