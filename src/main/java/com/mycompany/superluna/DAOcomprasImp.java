/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superluna;

import com.mycompany.interfaces.DAOcompras;
import com.mycompany.models.compras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


/**
 *
 * @author abarrotesluna
 */
public class DAOcomprasImp extends com.mycompany.db.Conexion implements DAOcompras {

    

    @Override
    public void eliminar(compras compra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(compras compra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<compras> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public int registrar(compras compra) throws Exception {

        String sql = """
            INSERT INTO compras
            (totalCompra, efectivo, cambio, fechaCompra)
            VALUES (?, ?, ?, ?)
        """;

        try (
            PreparedStatement ps = Conexion.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS
            )
        ) {

            ps.setDouble(1, compra.getTotalCompra());
            ps.setDouble(2, compra.getEfectivo());
            ps.setDouble(3, compra.getCambio());
            ps.setTimestamp(4, compra.getFechaCompra());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (!rs.next()) {
                    throw new SQLException("No se generó el id de la compra");
                }
                return rs.getInt(1);
            }
        }
    }

    
}
