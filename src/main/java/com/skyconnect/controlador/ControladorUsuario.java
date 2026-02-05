package com.skyconnect.controlador;

import com.skyconnect.modelo.Usuario;
import com.skyconnect.modelo.UsuarioDAO;
import com.skyconnect.vista.MainFrame;
import java.util.ArrayList;

public class ControladorUsuario {
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private UsuarioDAO usuarioDAO;
    private MainFrame mainFrame; 
    private final static String RUTA = "database/usuarios.txt";
    
    /**
     * Controlador que gestiona la autenticación
     * y registro de usuarios del sistema.
     * @param mainFrame
     */
    
    //Constructor
    public ControladorUsuario() {
        usuarios = UsuarioDAO.cargarUsuarios(RUTA);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
    public boolean iniciarSesion(String correo, String password) {
        for (Usuario u : usuarios) {
        if (u.getCorreo().equals(correo) && u.getPassword().equals(password)) {
        return true; //COINCIDE Y PUEDE INICIAR SESIÓN
            }
        }
        return false; //CLAVE INCORRECTA o usuario no registrado
    }

    //Recibe los datos de CreacionUsuario, los pasa por el constructor
    //de usuario y los añade a la lista con todos los usuarios
    public void registrarUsuario(String nombre, String apellido, String correo, String clave) {
        Usuario tempUsuario = new Usuario(nombre, apellido, correo, clave);
                //Añade al usuario a la lista que se inicializa con el programa
                usuarios.add(tempUsuario);
               //Guarda las credenciales en el txt
                guardarUsuario(tempUsuario);
    }
    
    //Recibe un objeto USUARIO y lo guarda en el txt del database
    public void guardarUsuario(Usuario usuario){
        usuarioDAO.guardarUsuarios(usuario);
    }
    
}
