/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superluna;
import com.mycompany.db.Conexion;
import com.mycompany.interfaces.DAOproductos;
import com.mycompany.models.productos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author luis-alberto
 */
public class DAOproductosImp extends Conexion implements DAOproductos {

    @Override
    public void registrar(productos producto) throws Exception {
      try {
            this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("INSERT INTO productos(idProducto,nombreProducto,pzCaja,existencias,precioUnitario,precioMayoreo,idTipo,idPresentacion,contenedor,cantidadMayoreo) VALUES(?,?,?,?,?,?,?,?,?,?);");
            st.setString(1, producto.getIdProducto());
            st.setString(2, producto.getNombreProducto());
            st.setDouble(3, producto.getPzCaja());
            st.setDouble(4, producto.getExistencias());
            st.setDouble(5, producto.getPrecioUnitario());
            st.setDouble(6, producto.getPrecioMayoreo());
            st.setInt(7, producto.getIdTipo());
            st.setInt(8, producto.getIdPresentacion());
            st.setString(9, producto.getContenedor());
            st.setDouble(10, producto.getCantidadMa());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Se ha registrado el producto correctamente","OPERACION EXITOSA",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLIntegrityConstraintViolationException e){
        JOptionPane.showMessageDialog(null, "El producto '" + producto.getNombreProducto()+ "' ya está registrado.");
        JOptionPane.showMessageDialog(null, e);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally{
        this.cerrarConexion();
        }  
    }

    @Override
    public void eliminar(productos producto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(productos producto) throws Exception {
        try {
         this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("UPDATE productos SET nombreProducto = ?,pzCaja = ?,existencias = ?,precioUnitario = ?,precioMayoreo = ?,idTipo = ?,idPresentacion = ?,contenedor = ?,cantidadMayoreo =? WHERE idProducto = ?;"); 
            
            st.setString(1, producto.getNombreProducto());
            st.setDouble(2, producto.getPzCaja());
            st.setDouble(3, producto.getExistencias());
            st.setDouble(4, producto.getPrecioUnitario());
            st.setDouble(5, producto.getPrecioMayoreo());
            st.setInt(6, producto.getIdTipo());
            st.setInt(7, producto.getIdPresentacion());
            st.setString(8, producto.getContenedor());
            st.setDouble(9, producto.getCantidadMa());
            st.setString(10, producto.getIdProducto());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);   
        }finally{
        this.cerrarConexion();
        }
    }

    @Override
    public List<productos> listar() throws Exception {
       List<productos> lista  = null;
        try {
           this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("SELECT * FROM productos;"); 
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            productos producto = new productos();
            producto.setIdProducto(rs.getString("idProducto"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setPrecioMayoreo(rs.getDouble("precioMayoreo"));
            producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
            producto.setExistencias(rs.getDouble("existencias"));
            producto.setPzCaja(rs.getDouble("pzCaja"));
            producto.setIdTipo(rs.getInt("idTipo"));
            producto.setIdPresentacion(rs.getInt("idPresentacion"));
            producto.setContenedor(rs.getString("contenedor"));
            producto.setCantidadMa(rs.getDouble("cantidadMayoreo"));
            lista.add(producto);
            
            }
            rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return lista;
    }

    @Override
    public productos obtenerProductosTipo(String identificador) throws Exception {
       productos producto = new productos();
        try {
            this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("SELECT * FROM productos WHERE idProducto = ? LIMIT 1;"); 
            st.setString(1, identificador);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            producto.setIdProducto(rs.getString("idProducto"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
            producto.setPrecioMayoreo(rs.getDouble("precioMayoreo"));
            producto.setExistencias(rs.getDouble("existencias"));
            producto.setPzCaja(rs.getDouble("pzCaja"));
            producto.setIdTipo(rs.getInt("idTipo"));
            producto.setIdPresentacion(rs.getInt("idPresentacion"));
            producto.setContenedor(rs.getString("contenedor"));
            producto.setCantidadMa(rs.getDouble("cantidadMayoreo"));
            }
         rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar productos: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return producto;
    }

    @Override
    public List<productos> listaCremeria() throws Exception {
        List<productos> lista  = null;
        try {
           this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("SELECT idProducto, nombreProducto, precioUnitario, precioMayoreo, cantidadMayoreo, existencias, pzCaja, contenedor  "
                    + "FROM productos "
                    + "WHERE idTipo = 4;"); 
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            productos producto = new productos();
            producto.setIdProducto(rs.getString("idProducto"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setPrecioMayoreo(rs.getDouble("precioMayoreo"));
            producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
            producto.setExistencias(rs.getDouble("existencias"));
            producto.setPzCaja(rs.getDouble("pzCaja"));
            producto.setCantidadMa(rs.getDouble("cantidadMayoreo"));
            producto.setContenedor(rs.getString("contenedor"));
            lista.add(producto);
            
            }
            rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return lista;
    }

    @Override
    public List<productos> listaAbarrotes() throws Exception {
               List<productos> lista  = null;
        try {
           this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("SELECT idProducto, nombreProducto, precioUnitario, precioMayoreo, cantidadMayoreo, existencias, pzCaja, idPresentacion, contenedor  FROM productos WHERE idTipo = 1;"); 
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            productos producto = new productos();
            producto.setIdProducto(rs.getString("idProducto"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setPrecioMayoreo(rs.getDouble("precioMayoreo"));
            producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
            producto.setExistencias(rs.getDouble("existencias"));
            producto.setPzCaja(rs.getDouble("pzCaja"));
            producto.setCantidadMa(rs.getDouble("cantidadMayoreo"));
            producto.setContenedor(rs.getString("contenedor"));
            producto.setIdPresentacion(rs.getInt("idPresentacion"));
            lista.add(producto);
            
            }
            rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return lista;
    }

    @Override
    public List<productos> listaPanaderia() throws Exception {
    List<productos> lista  = null;
        try {
           this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("SELECT idProducto, nombreProducto, precioUnitario, precioMayoreo, cantidadMayoreo, existencias FROM productos WHERE idTipo = 2;"); 
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            productos producto = new productos();
            producto.setIdProducto(rs.getString("idProducto"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setPrecioMayoreo(rs.getDouble("precioMayoreo"));
            producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
            producto.setExistencias(rs.getDouble("existencias"));
            producto.setCantidadMa(rs.getDouble("cantidadMayoreo"));
            lista.add(producto);
            
            }
            rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return lista;
    }

    @Override
    public List<productos> listaVerduras() throws Exception {
            List<productos> lista  = null;
        try {
           this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("SELECT idProducto, nombreProducto, precioUnitario, precioMayoreo, cantidadMayoreo, existencias FROM productos WHERE idTipo = 3;"); 
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            productos producto = new productos();
            producto.setIdProducto(rs.getString("idProducto"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setPrecioMayoreo(rs.getDouble("precioMayoreo"));
            producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
            producto.setExistencias(rs.getDouble("existencias"));
            producto.setCantidadMa(rs.getDouble("cantidadMayoreo"));
            lista.add(producto);
            
            }
            rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return lista;
    }

    @Override
    public List<productos> listaBultos() throws Exception {
               List<productos> lista  = null;
        try {
           this.conectar();
            PreparedStatement st = this.Conexion.prepareStatement("SELECT idProducto, nombreProducto, precioUnitario, precioMayoreo, cantidadMayoreo, existencias, pzCaja, idPresentacion, contenedor  FROM productos WHERE idTipo = 5;"); 
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            productos producto = new productos();
            producto.setIdProducto(rs.getString("idProducto"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setPrecioMayoreo(rs.getDouble("precioMayoreo"));
            producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
            producto.setExistencias(rs.getDouble("existencias"));
            producto.setPzCaja(rs.getDouble("pzCaja"));
            producto.setCantidadMa(rs.getDouble("cantidadMayoreo"));
            producto.setContenedor(rs.getString("contenedor"));
            producto.setIdPresentacion(rs.getInt("idPresentacion"));
            lista.add(producto);
            
            }
            rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al listar productos: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return lista;
    }

    @Override
    public productos obtenerProductoId(String codigoBarras) throws Exception {
      productos prod = new productos();
        try {
                this.conectar();
                PreparedStatement st = this.Conexion.prepareStatement("SELECT * FROM productos WHERE idProducto = ? LIMIT 1;"); 
                st.setString(1, codigoBarras);
                ResultSet rs = st.executeQuery();
                while(rs.next()){  
                    prod.setIdProducto(rs.getString("idProducto"));
                    prod.setNombreProducto(rs.getString("nombreProducto"));
                    prod.setContenedor(rs.getString("contenedor"));
                    prod.setCantidadMa(rs.getDouble("cantidadMayoreo"));
                    prod.setExistencias(rs.getDouble("existencias"));
                    prod.setIdPresentacion(rs.getInt("idPresentacion"));
                    prod.setPrecioMayoreo(rs.getDouble("precioMayoreo"));
                    prod.setPrecioUnitario(rs.getDouble("precioUnitario"));
                    prod.setPzCaja(rs.getInt("pzCaja"));
                    prod.setIdTipo(rs.getInt("idTipo"));
            }
            
            rs.close();
            st.close();
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al consultar el producto: " + e.getMessage());
        throw e;

        }finally{
        this.cerrarConexion();
        }
    return prod;
    }

    @Override
    public void aumentarExistencias(String idProducto, int cantidad) throws Exception {
         String sql = "UPDATE productos SET existencias = existencias + ? WHERE idProducto = ?";

    try (PreparedStatement ps = Conexion.prepareStatement(sql)) {
        ps.setInt(1, cantidad);
        ps.setString(2, idProducto);
        ps.executeUpdate();
    }
    }
    
    public List<productos> buscar(String texto) throws Exception {

    List<productos> lista = new ArrayList<>();

    String sql = """
        SELECT idProducto, nombreProducto, precioUnitario, existencias
        FROM productos
        WHERE nombreProducto LIKE ? OR idProducto LIKE ?
    """;

    try {
        this.conectar();
        PreparedStatement ps = Conexion.prepareStatement(sql);
        ps.setString(1, "%" + texto + "%");
        ps.setString(2, "%" + texto + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            productos p = new productos();
            p.setIdProducto(rs.getString("idProducto"));
            p.setNombreProducto(rs.getString("nombreProducto"));
            p.setPrecioUnitario(rs.getDouble("precioUnitario"));
            p.setExistencias(rs.getInt("existencias"));
            lista.add(p);
        }

        rs.close();
        ps.close();

    } finally {
        this.cerrarConexion();
    }

    return lista;
}

    
}
