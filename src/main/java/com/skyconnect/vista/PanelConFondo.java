
package com.skyconnect.vista;

import javax.swing.*;
import java.awt.*;

class FondoPanel extends JPanel {

    private Image imagen;

    public FondoPanel(String rutaImagen) {
        this.imagen = new ImageIcon(
            getClass().getResource(rutaImagen)
        ).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}
