/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {


    // Estado de la conexión
    protected Connection Conexion;
    
    public void setConexion(Connection conexion) {
    this.Conexion = conexion;
}


    // Credenciales de la base de datos
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/abarrotesLuna";
    private static final String username = "root";
    private static final String password = "ADMINISTRATORLUNA";

    // Método para conectar
    public void conectar() throws ClassNotFoundException {
        try {
            
            Conexion = DriverManager.getConnection(url, username, password);
            Class.forName(JDBC_DRIVER);
            
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null,e);
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        if (Conexion != null) {
            try {
                Conexion.close();
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e);
            }
        }
    }

}