/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superluna;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagenLabel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JLabel con imagen");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        try {
            // Cargar la imagen
            ImageIcon icon = new ImageIcon(ImageIO.read(ImagenLabel.class.getResource("/com/images/store.jpg")));

            // Redimensionar la imagen
            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            System.out.println("No se pudo cargar la imagen");
        }

        frame.add(label);
        frame.setVisible(true);
    }
}
