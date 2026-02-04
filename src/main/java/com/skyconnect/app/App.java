package com.skyconnect.app;

import com.skyconnect.vista.*;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        
        
       
        //Se inicializan las pestañas de las GUI creadas
        SwingUtilities.invokeLater(() -> {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("SkyConnect");
        mainFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        mainFrame.setLocationRelativeTo(null); 
        mainFrame.setVisible(true);
        
        });
        
    }
}
