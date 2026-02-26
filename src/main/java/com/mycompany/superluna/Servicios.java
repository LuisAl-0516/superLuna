/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superluna;

import com.mycompany.models.compras;
import com.mycompany.models.detalleCompra;
import java.util.List;

public class Servicios extends com.mycompany.db.Conexion {

public void guardarCompra(compras compra, List<detalleCompra> detalles) throws Exception {

    try {
        this.conectar();
        this.Conexion.setAutoCommit(false);

        DAOcomprasImp daoCompra = new DAOcomprasImp();
        daoCompra.setConexion(Conexion);

        int idCompra = daoCompra.registrar(compra);

        DAOcomprasDetalleImp daoDetalle = new DAOcomprasDetalleImp();
        daoDetalle.setConexion(Conexion);
        
        DAOproductosImp daoProductos = new DAOproductosImp();
        daoProductos.setConexion(Conexion);

        for (detalleCompra d : detalles) {
            d.setIdCompra(idCompra);
            daoDetalle.registrar(d);
            daoProductos.aumentarExistencias(d.getIdProducto(),d.getCantidad());
            
        }

        this.Conexion.commit();

    } catch (Exception e) {
        if (this.Conexion != null) {
            this.Conexion.rollback();
        }
        throw e;
    } finally {
        this.cerrarConexion();
    }
}

}
