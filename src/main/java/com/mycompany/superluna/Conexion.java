/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superluna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    // Constructor privado para implementar Singleton
    private Conexion() {}

    // Estado de la conexión
    private static Connection Conexion;
    // Instancia de la conexión
    private static Conexion instancia;

    // Credenciales de la base de datos
    private static final String url = "jdbc:mysql://localhost:3306/abarrotesLuna";
    private static final String username = "root";
    private static final String password = "ADMINISTRATORLUNA";

    // Método para conectar
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Conexion = DriverManager.getConnection(url, username, password);
            JOptionPane.showMessageDialog(null, "Conexión exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return Conexion;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        if (Conexion != null) {
            try {
                Conexion.close();
                JOptionPane.showMessageDialog(null, "Conexión cerrada");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e);
            }
        }
    }

    // Método Singleton para obtener la instancia
    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}