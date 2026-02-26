/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.views;

import com.mycompany.interfaces.DAOproductos;
import com.mycompany.models.productos;
import java.awt.Color;
import java.sql.*;
import com.mycompany.superluna.Conexion;
import com.mycompany.superluna.DAOproductosImp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis-alberto
 */
public class Inventario extends javax.swing.JPanel {

    /**
     * Creates new form Inventario
     */
    int tipo=1;
    public Inventario() {
        initComponents();
        inicializarprecio();
        borrrarTabla();
        tablaAbarrotes();
       loadAbarrotes();
        
    }
    private void gestionarVisibilidad(javax.swing.JComponent componente, boolean visible) {
    // Si queremos que sea visible, lo restauramos totalmente
    if (visible) {
        componente.setVisible(true);
        componente.setEnabled(true);
    } else {
        // En GroupLayout, si ponemos setVisible(false) el espacio se pierde.
        // Para "engañar" al layout, lo mantenemos visible pero vacío o transparente
        componente.setVisible(false); 
        
        // NOTA: Si al poner setVisible(false) se sigue moviendo todo, 
        // la solución definitiva es cambiar el layout a GridBagLayout.
    }
}
    private void loadAbarrotes(){
        try {
            DAOproductos daoProd = new DAOproductosImp();
            DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
            daoProd.listaAbarrotes().forEach((u) -> model.addRow(new Object[]{u.getIdProducto(),u.getNombreProducto(),u.getPrecioUnitario(),u.getPrecioMayoreo(),u.getCantidadMa(),u.getExistencias(),u.getPzCaja(),u.getIdPresentacion(),u.getContenedor()}));
        } catch (Exception e) {
        }
    }
    private void loadPanaderia(){
        try {
            DAOproductos daoProd = new DAOproductosImp();
            DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
            daoProd.listaPanaderia().forEach((u) -> model.addRow(new Object[]{u.getIdProducto(),u.getNombreProducto(),u.getPrecioUnitario(),u.getPrecioMayoreo(),u.getCantidadMa(),u.getExistencias()}));
        } catch (Exception e) {
        }
    }
    private void loadVerduras(){
        try {
            DAOproductos daoProd = new DAOproductosImp();
            DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
            daoProd.listaVerduras().forEach((u) -> model.addRow(new Object[]{u.getIdProducto(),u.getNombreProducto(),u.getPrecioUnitario(),u.getPrecioMayoreo(),u.getCantidadMa(),u.getExistencias()}));
        } catch (Exception e) {
        }
    }
    private void loadCremeria(){
        try {
            DAOproductos daoProd = new DAOproductosImp();
            DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
            daoProd.listaCremeria().forEach((u) -> model.addRow(new Object[]{u.getIdProducto(),
                u.getNombreProducto(),
                u.getPrecioUnitario(),
                u.getPrecioMayoreo(),
                u.getCantidadMa(),
                u.getExistencias(),
                u.getContenedor()}));
        } catch (Exception e) {
        }
    }
    private void loadBultos(){
        try {
            DAOproductos daoProd = new DAOproductosImp();
            DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
            daoProd.listaBultos().forEach((u) -> model.addRow(new Object[]{u.getIdProducto(),u.getNombreProducto(),u.getPrecioUnitario(),u.getPrecioMayoreo(),u.getCantidadMa(),u.getExistencias(),u.getPzCaja(),u.getIdPresentacion()}));
        } catch (Exception e) {
        }
    }
    private void MostrarCampos(productos producto){
    if(producto != null){
        if(tipo != 4){
    txtNombre.setText(producto.getNombreProducto());
    txtCodigo.setText(producto.getIdProducto());
    txtCantidadMa.setText(Double.toString(producto.getCantidadMa()));
    txtContenedor.setText(producto.getContenedor());
    txtExistencias.setText(Double.toString(producto.getExistencias()));
    txtPrecioMa.setText(Double.toString(producto.getPrecioMayoreo()));
    txtPrecioUni.setText(Double.toString(producto.getPrecioUnitario()));
    txtPiezasCj.setText(Double.toString(producto.getPzCaja()));
    }else{
    txtNombre.setText(producto.getNombreProducto());
    txtCodigo.setText(producto.getIdProducto());
    txtCantidadMa.setText(Double.toString(producto.getCantidadMa()));
    txtExistencias.setText(Double.toString(producto.getExistencias()));
    txtPrecioMa.setText(Double.toString(producto.getPrecioMayoreo()));
    txtPrecioUni.setText(Double.toString(producto.getPrecioUnitario()));
    txtPiezasCj.setText(producto.getContenedor());
        }
    if(producto.getIdPresentacion()==1)
    {
    cbxPresentacion.setSelectedIndex(0);
    }else if(producto.getIdPresentacion()==2){
    cbxPresentacion.setSelectedIndex(1);
    }else if(producto.getIdPresentacion()==3){
    cbxPresentacion.setSelectedIndex(2);
    }else if(producto.getIdPresentacion()==4){
    cbxPresentacion.setSelectedIndex(3);
    }else{
    cbxPresentacion.setSelectedIndex(4);
    }
    }
    }
    private void borrrarTabla(){
     DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();

        // Borra todas las columnas y filas
        model.setColumnCount(0);
        model.setRowCount(0);

    }
    private void inicializarprecio(){
    txtCantidadMa.setText("0");
    txtExistencias.setText("0");
    txtPiezasCj.setText("0");
    txtPrecioMa.setText("0");
    txtPrecioUni.setText("0");
    
    
    }
    private void limpiarCampos(){
    txtCodigo.setText("");
    txtContenedor.setText("");
    txtExistencias.setText("");
    txtNombre.setText("");
    txtPiezasCj.setText("");
    txtPrecioMa.setText("");
    txtPrecioUni.setText("");
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecioUni = new javax.swing.JTextField();
        lblPrecioUni = new javax.swing.JLabel();
        lblPrecioMa = new javax.swing.JLabel();
        txtPrecioMa = new javax.swing.JTextField();
        lblExistencias = new javax.swing.JLabel();
        txtExistencias = new javax.swing.JTextField();
        lblPresentacion = new javax.swing.JLabel();
        txtContenedor = new javax.swing.JTextField();
        lblConte = new javax.swing.JLabel();
        txtPiezasCj = new javax.swing.JTextField();
        lblPiezasCj = new javax.swing.JLabel();
        jpInventarioMneu = new javax.swing.JPanel();
        jbModificar = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jbConsultar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbCremeria = new javax.swing.JButton();
        jbAbarrotes = new javax.swing.JButton();
        jbPanaderia = new javax.swing.JButton();
        jbVerduras = new javax.swing.JButton();
        jbBultos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        cbxPresentacion = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        lblCantidadMa = new javax.swing.JLabel();
        txtCantidadMa = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(225, 124, 22));

        jLabel1.setFont(new java.awt.Font("Roboto SemiCondensed SemiBold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INVENTARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        lblCodigo.setFont(new java.awt.Font("Roboto Condensed SemiBold", 0, 24)); // NOI18N
        lblCodigo.setText("CÓDIGO DE BARRAS");

        txtCodigo.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        txtCodigo.setBorder(null);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Roboto Condensed SemiBold", 0, 24)); // NOI18N
        lblNombre.setText("NOMBRE DEL PRODUCTO");

        txtNombre.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtPrecioUni.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        txtPrecioUni.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPrecioUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUniActionPerformed(evt);
            }
        });

        lblPrecioUni.setFont(new java.awt.Font("Roboto Condensed SemiBold", 0, 24)); // NOI18N
        lblPrecioUni.setText("PRECIO UNITARIO");

        lblPrecioMa.setFont(new java.awt.Font("Roboto Condensed SemiBold", 0, 24)); // NOI18N
        lblPrecioMa.setText("PRECIO MAYOREO");

        txtPrecioMa.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        txtPrecioMa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPrecioMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioMaActionPerformed(evt);
            }
        });

        lblExistencias.setFont(new java.awt.Font("Roboto Condensed SemiBold", 0, 24)); // NOI18N
        lblExistencias.setText("EXISTENCIAS");

        txtExistencias.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        txtExistencias.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtExistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExistenciasActionPerformed(evt);
            }
        });

        lblPresentacion.setFont(new java.awt.Font("Roboto Condensed SemiBold", 0, 24)); // NOI18N
        lblPresentacion.setText("PRESENTACION");

        txtContenedor.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        txtContenedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblConte.setFont(new java.awt.Font("Roboto Condensed SemiBold", 0, 24)); // NOI18N
        lblConte.setText("CONTENEDOR");

        txtPiezasCj.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        txtPiezasCj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblPiezasCj.setFont(new java.awt.Font("Roboto Condensed SemiBold", 0, 24)); // NOI18N
        lblPiezasCj.setText("PIEZAS CAJA");

        jpInventarioMneu.setBackground(new java.awt.Color(225, 140, 55));

        jbModificar.setBackground(new java.awt.Color(225, 124, 22));
        jbModificar.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        jbModificar.setForeground(new java.awt.Color(239, 239, 239));
        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/images/editar.png"))); // NOI18N
        jbModificar.setText("MODIFICAR");
        jbModificar.setBorder(null);
        jbModificar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbModificar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbModificar.setIconTextGap(10);
        jbModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbModificarMouseClicked(evt);
            }
        });

        jbAgregar.setBackground(new java.awt.Color(225, 124, 22));
        jbAgregar.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(239, 239, 239));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/images/guardar.png"))); // NOI18N
        jbAgregar.setText("AGREGAR");
        jbAgregar.setToolTipText("");
        jbAgregar.setBorder(null);
        jbAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbAgregar.setIconTextGap(10);
        jbAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAgregarMouseClicked(evt);
            }
        });
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbConsultar.setBackground(new java.awt.Color(225, 124, 22));
        jbConsultar.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        jbConsultar.setForeground(new java.awt.Color(239, 239, 239));
        jbConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/images/buscar.png"))); // NOI18N
        jbConsultar.setText("CONSULTAR");
        jbConsultar.setBorder(null);
        jbConsultar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbConsultar.setIconTextGap(10);

        jbLimpiar.setBackground(new java.awt.Color(225, 124, 22));
        jbLimpiar.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        jbLimpiar.setForeground(new java.awt.Color(239, 239, 239));
        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/images/limpiar.png"))); // NOI18N
        jbLimpiar.setText("LIMPIAR");
        jbLimpiar.setBorder(null);
        jbLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbLimpiar.setIconTextGap(10);
        jbLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbLimpiarMouseClicked(evt);
            }
        });
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbCremeria.setBackground(new java.awt.Color(225, 124, 22));
        jbCremeria.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        jbCremeria.setForeground(new java.awt.Color(239, 239, 239));
        jbCremeria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/images/queso.png"))); // NOI18N
        jbCremeria.setText("CREMERÍA");
        jbCremeria.setBorder(null);
        jbCremeria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbCremeria.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbCremeria.setIconTextGap(10);
        jbCremeria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCremeriaMouseClicked(evt);
            }
        });

        jbAbarrotes.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        jbAbarrotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/images/leche.png"))); // NOI18N
        jbAbarrotes.setText("ABARROTES");
        jbAbarrotes.setBorder(null);
        jbAbarrotes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbAbarrotes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbAbarrotes.setIconTextGap(10);
        jbAbarrotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAbarrotesMouseClicked(evt);
            }
        });
        jbAbarrotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbarrotesActionPerformed(evt);
            }
        });

        jbPanaderia.setBackground(new java.awt.Color(225, 124, 22));
        jbPanaderia.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        jbPanaderia.setForeground(new java.awt.Color(239, 239, 239));
        jbPanaderia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/images/pan.png"))); // NOI18N
        jbPanaderia.setText("PANADERÍA");
        jbPanaderia.setBorder(null);
        jbPanaderia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbPanaderia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbPanaderia.setIconTextGap(10);
        jbPanaderia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPanaderiaMouseClicked(evt);
            }
        });
        jbPanaderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPanaderiaActionPerformed(evt);
            }
        });

        jbVerduras.setBackground(new java.awt.Color(225, 124, 22));
        jbVerduras.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        jbVerduras.setForeground(new java.awt.Color(239, 239, 239));
        jbVerduras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/images/verdura.png"))); // NOI18N
        jbVerduras.setText("VERDURAS");
        jbVerduras.setBorder(null);
        jbVerduras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbVerduras.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbVerduras.setIconTextGap(10);
        jbVerduras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVerdurasMouseClicked(evt);
            }
        });
        jbVerduras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerdurasActionPerformed(evt);
            }
        });

        jbBultos.setBackground(new java.awt.Color(225, 124, 22));
        jbBultos.setFont(new java.awt.Font("Roboto SemiBold", 0, 24)); // NOI18N
        jbBultos.setForeground(new java.awt.Color(239, 239, 239));
        jbBultos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/images/bulto.png"))); // NOI18N
        jbBultos.setText("BULTOS");
        jbBultos.setBorder(null);
        jbBultos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbBultos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbBultos.setIconTextGap(10);
        jbBultos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbBultosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpInventarioMneuLayout = new javax.swing.GroupLayout(jpInventarioMneu);
        jpInventarioMneu.setLayout(jpInventarioMneuLayout);
        jpInventarioMneuLayout.setHorizontalGroup(
            jpInventarioMneuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioMneuLayout.createSequentialGroup()
                .addGroup(jpInventarioMneuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbConsultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(jbAbarrotes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbBultos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbCremeria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVerduras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPanaderia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jpInventarioMneuLayout.setVerticalGroup(
            jpInventarioMneuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInventarioMneuLayout.createSequentialGroup()
                .addComponent(jbAbarrotes)
                .addGap(0, 0, 0)
                .addComponent(jbPanaderia)
                .addGap(0, 0, 0)
                .addComponent(jbVerduras)
                .addGap(0, 0, 0)
                .addComponent(jbCremeria)
                .addGap(0, 0, 0)
                .addComponent(jbBultos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jbConsultar)
                .addGap(0, 0, 0)
                .addComponent(jbAgregar)
                .addGap(0, 0, 0)
                .addComponent(jbModificar)
                .addGap(0, 0, 0)
                .addComponent(jbLimpiar)
                .addGap(16, 16, 16))
        );

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInventario);

        cbxPresentacion.setFont(new java.awt.Font("Roboto SemiBold", 0, 18)); // NOI18N
        cbxPresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Paquete Chico", "Paquete Mediano", "Paquete Grande", "Granel" }));
        cbxPresentacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cbxPresentacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPresentacionItemStateChanged(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        lblCantidadMa.setFont(new java.awt.Font("Roboto Condensed SemiBold", 0, 24)); // NOI18N
        lblCantidadMa.setText("CANTIDAD MAYOREO");

        txtCantidadMa.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        txtCantidadMa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtCantidadMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpInventarioMneu, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addComponent(txtCodigo)
                            .addComponent(jSeparator1)
                            .addComponent(lblPrecioUni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrecioUni)
                            .addComponent(lblExistencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtExistencias)
                            .addComponent(lblConte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContenedor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(lblPrecioMa, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                    .addComponent(txtPrecioMa)
                                    .addComponent(lblPiezasCj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPiezasCj))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(cbxPresentacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCantidadMa)
                                    .addComponent(lblCantidadMa, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                                .addGap(4, 4, 4))
                            .addComponent(txtNombre)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jScrollPane1)))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblPrecioMa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidadMa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioUni, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCantidadMa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioMa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioUni, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPiezasCj, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPiezasCj, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblConte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(txtContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jpInventarioMneu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void txtExistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExistenciasActionPerformed
    if(txtPiezasCj.isEnabled() == true && txtPiezasCj.isVisible() == true)
        txtPiezasCj.requestFocus();
    else if(txtContenedor.isEnabled() == true && txtContenedor.isVisible() == true){
        txtContenedor.requestFocus();
    }// TODO add your handling code here:
    }//GEN-LAST:event_txtExistenciasActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbPanaderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPanaderiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbPanaderiaActionPerformed

    private void jbVerdurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerdurasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbVerdurasActionPerformed

    private void jbAbarrotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbarrotesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAbarrotesActionPerformed
    private void inicializaPanaderia(){
    tipo=2;
    cbxPresentacion.enable(true);
    cbxPresentacion.setSelectedIndex(1);
        jbPanaderia.setBackground(Color.WHITE); 
    jbPanaderia.setForeground(Color.black);
    jbAbarrotes.setBackground(new Color(225,124,22));
    jbAbarrotes.setForeground(Color.WHITE);
    jbBultos.setBackground(new Color(225,124,22)); 
    jbBultos.setForeground(Color.WHITE);
    jbVerduras.setBackground(new Color(225,124,22));
    jbVerduras.setForeground(Color.WHITE);
    jbCremeria.setBackground(new Color(225,124,22));
    jbCremeria.setForeground(Color.WHITE);
    
    lblCodigo.setText("IDENTIFICADOR");
    lblNombre.setText("DESCRIPCION");
    lblPrecioUni.setText("PRECIO UNITARIO");
    lblPrecioMa.setText("PRECIO MAYOREO");
    lblPrecioMa.setVisible(true);
    txtPrecioMa.setVisible(true);
    gestionarVisibilidad(lblPiezasCj, false);
    gestionarVisibilidad(lblConte, false);
    gestionarVisibilidad(txtContenedor, false);
    gestionarVisibilidad(txtPiezasCj, false);
    gestionarVisibilidad(cbxPresentacion, false);
    gestionarVisibilidad(lblPresentacion, false);
    lblCantidadMa.setVisible(true);
    txtCantidadMa.setVisible(true);
    }
    private void tablaPanaderia(){
    DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
    model.addColumn("CODIGO DE BARRAS");
    model.addColumn("NOMBRE");
    model.addColumn("PRECIO UNITARIO");
    model.addColumn("PRECIO MAYOREO");
    model.addColumn("CANTIDAD MAYOREO");
    model.addColumn("EXISTENCIAS");

    }
    private void jbPanaderiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPanaderiaMouseClicked
    inicializaPanaderia();
    limpiarCampos();
    inicializarprecio();
    borrrarTabla();
    tablaPanaderia();
    loadPanaderia();
    }//GEN-LAST:event_jbPanaderiaMouseClicked
    private void inicializaAbarrotes(){
    cbxPresentacion.enable(true);
    jbAbarrotes.setBackground(Color.WHITE); 
    jbAbarrotes.setForeground(Color.black);
    jbPanaderia.setBackground(new Color(225,124,22));
    jbPanaderia.setForeground(Color.WHITE);
    jbBultos.setBackground(new Color(225,124,22)); 
    jbBultos.setForeground(Color.WHITE);
    jbVerduras.setBackground(new Color(225,124,22));
    jbVerduras.setForeground(Color.WHITE);
    jbCremeria.setBackground(new Color(225,124,22));
    jbCremeria.setForeground(Color.WHITE);
    lblCodigo.setText("CODIGO DE BARRAS");
    lblNombre.setText("NOMBRE DEL PRODUCTO");
    lblPrecioUni.setText("PRECIO UNITARIO");
    lblConte.setText("CONTENEDOR");
    lblPrecioMa.setText("PRECIO MAYOREO");
    lblPiezasCj.setText("PIEZAS CAJA");
    lblPiezasCj.setVisible(true);
    lblConte.setVisible(true);
    lblPrecioMa.setVisible(true);
    txtPrecioMa.setVisible(true);
    lblPresentacion.setVisible(true);
    txtPiezasCj.setVisible(true);
    txtContenedor.setVisible(true);
    cbxPresentacion.setVisible(true);
    lblCantidadMa.setVisible(true);
    txtCantidadMa.setVisible(true);
    tipo=1;
        
    }
    private void tablaAbarrotes(){
    DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
    model.addColumn("CODIGO DE BARRAS");
    model.addColumn("NOMBRE");
    model.addColumn("PRECIO UNITARIO");
    model.addColumn("PRECIO MAYOREO");
    model.addColumn("CANTIDAD MAYOREO");
    model.addColumn("EXISTENCIAS");
    model.addColumn("PIEZAS CAJA");
    model.addColumn("PRESENTACION");
    model.addColumn("CONTENEDOR");
    }
    private void jbAbarrotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAbarrotesMouseClicked
    inicializaAbarrotes();
    limpiarCampos();
    inicializarprecio();
    borrrarTabla();
    tablaAbarrotes();
    loadAbarrotes();
    
// TODO add your handling code here:
    }//GEN-LAST:event_jbAbarrotesMouseClicked
    private void inicializaVerduras(){
        tipo=3;
        cbxPresentacion.enable(true);
    cbxPresentacion.setSelectedIndex(1);
    jbVerduras.setBackground(Color.WHITE);
    jbVerduras.setForeground(Color.black);
    jbPanaderia.setBackground(new Color(225,124,22));
    jbPanaderia.setForeground(Color.WHITE);
    jbBultos.setBackground(new Color(225,124,22)); 
    jbBultos.setForeground(Color.WHITE);
    jbAbarrotes.setBackground(new Color(225,124,22));
    jbAbarrotes.setForeground(Color.WHITE);
    jbCremeria.setBackground(new Color(225,124,22)); 
    jbCremeria.setForeground(Color.WHITE);
    lblCodigo.setText("IDENTIFICADOR");
    lblNombre.setText("DESCRIPCION");
    lblPrecioUni.setText("PRECIO MENUDEO KG");
    lblPrecioMa.setText("PRECIO MAYOREO KG");
    lblPrecioMa.setVisible(true);
    txtPrecioMa.setVisible(true);
    gestionarVisibilidad(lblPiezasCj, false);
    gestionarVisibilidad(lblConte, false);
    gestionarVisibilidad(txtContenedor, false);
    gestionarVisibilidad(txtPiezasCj, false);
    gestionarVisibilidad(cbxPresentacion, false);
    gestionarVisibilidad(lblPresentacion, false);
    lblCantidadMa.setVisible(true);
    txtCantidadMa.setVisible(true);
    }
    private void tablaVerduras(){
    DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
    model.addColumn("IDENTIFICADOR");
    model.addColumn("DESCRIPCION");
    model.addColumn("PRECIO MENUDEO KG");
    model.addColumn("PRECIO MAYOREO KG");
    model.addColumn("CANTIDAD MAYOREO");
    model.addColumn("EXISTENCIAS");
    }
    private void jbVerdurasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVerdurasMouseClicked
    inicializaVerduras();
    limpiarCampos();
    inicializarprecio();
    borrrarTabla();
    tablaVerduras();
    loadVerduras();
    
    }//GEN-LAST:event_jbVerdurasMouseClicked
    private void inicializaCremeria(){
    tipo=4;
    cbxPresentacion.enable(true);
    cbxPresentacion.setSelectedIndex(4);
    jbCremeria.setBackground(Color.WHITE); 
    jbCremeria.setForeground(Color.black);
    jbBultos.setBackground(new Color(225,124,22)); 
    jbBultos.setForeground(Color.WHITE);
    jbPanaderia.setBackground(new Color(225,124,22));
    jbPanaderia.setForeground(Color.WHITE);
    jbVerduras.setBackground(new Color(225,124,22));
    jbVerduras.setForeground(Color.WHITE);
    jbAbarrotes.setBackground(new Color(225,124,22)); 
    jbAbarrotes.setForeground(Color.WHITE);
    lblCodigo.setText("IDENTIFICADOR");
    lblNombre.setText("DESCRIPCION");
    lblPrecioUni.setText("PRECIO MENUDEO");
    lblPrecioMa.setText("PRECIO MAYOREO");
    lblPiezasCj.setText("CONTENEDOR");
    lblPrecioMa.setVisible(true);
    txtPrecioMa.setVisible(true);
    lblConte.setVisible(false);
    lblPresentacion.setVisible(true);
    txtPiezasCj.enable(true);
    txtContenedor.setVisible(false);
    cbxPresentacion.setVisible(true);
    lblPiezasCj.setVisible(true);
    txtPiezasCj.setVisible(true);
    lblCantidadMa.setVisible(true);
    txtCantidadMa.setVisible(true);
    }
    private void tablaCremeria(){
    DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
    model.addColumn("IDENTIFICADOR");
    model.addColumn("DESCRIPCION");
    model.addColumn("PRECIO MENUDEO");
    model.addColumn("PRECIO MAYOREO");
    model.addColumn("CANTIDAD MAYOREO");
    model.addColumn("EXISTENCIAS");
    model.addColumn("CONTENEDOR");
    }
    private void jbCremeriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCremeriaMouseClicked
    inicializaCremeria();
    limpiarCampos();
    inicializarprecio();
    borrrarTabla();
    tablaCremeria();
    loadCremeria();
    }//GEN-LAST:event_jbCremeriaMouseClicked
    private void habilitarBotones(){
    jbAbarrotes.setEnabled(true);
    jbAgregar.setEnabled(true);
    jbBultos.setEnabled(true);
    jbConsultar.setEnabled(true);
    jbCremeria.setEnabled(true);
    jbModificar.setEnabled(true);
    jbPanaderia.setEnabled(true);
    jbVerduras.setEnabled(true);
    }
    private void deshabilitarBotones(){
     
    jbAbarrotes.setEnabled(false);
    jbAgregar.setEnabled(false);
    jbBultos.setEnabled(false);
    jbConsultar.setEnabled(false);
    jbCremeria.setEnabled(false);
    jbModificar.setEnabled(false);
    jbPanaderia.setEnabled(false);
    jbVerduras.setEnabled(false);
}
    private void validarCampos(){
    
    }
    private void jbAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAgregarMouseClicked
    String codigo,nombre,contenedor;
    double precioU,precioM,pzCaja,cantidadMa,existencias;
    
    com.mycompany.models.productos producto = new com.mycompany.models.productos();
    if(txtCodigo.getText().isEmpty()||txtNombre.getText().isEmpty()||txtExistencias.getText().isEmpty()||txtPrecioUni.getText().isEmpty()||txtPrecioMa.getText().isEmpty())
    {
        JOptionPane.showMessageDialog(this, "Llene los campos necesarios para el registro","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }else {
        try {
            if(tipo==4){           
            codigo = txtCodigo.getText();
            nombre = txtNombre.getText();
            precioU = Double.parseDouble(txtPrecioUni.getText());
            precioM = Double.parseDouble(txtPrecioMa.getText());
            existencias = Double.parseDouble(txtExistencias.getText());
            pzCaja = 0;
            cantidadMa = Double.parseDouble(txtCantidadMa.getText());
            contenedor = txtPiezasCj.getText();
            
            }else{
            codigo = txtCodigo.getText();
            nombre = txtNombre.getText();
            precioU = Double.parseDouble(txtPrecioUni.getText());
            precioM = Double.parseDouble(txtPrecioMa.getText());
            existencias = Double.parseDouble(txtExistencias.getText());
            pzCaja = Double.parseDouble(txtPiezasCj.getText());
            cantidadMa = Double.parseDouble(txtCantidadMa.getText());
            contenedor = txtContenedor.getText();
            
            }
    int presentacion;
    Object selectedItem = cbxPresentacion.getSelectedItem();
if (selectedItem == null) {
    throw new IllegalStateException("No se ha seleccionado ningún tipo.");
}

switch (selectedItem.toString()) {
    case "Individual":
        presentacion = 1;
        break;
    case "Paquete Chico":
        presentacion = 2;
        break;
    case "Paquete Mediano":
        presentacion = 3;
        break;
    case "Paquete Grande":
        presentacion = 4;
        break;
    case "Granel":
        presentacion = 5;
        break;
    default:
        throw new IllegalArgumentException("Tipo desconocido: " + selectedItem);
    }
    
    
    producto.setIdProducto(codigo);
    producto.setNombreProducto(nombre);
    producto.setPrecioUnitario(precioU);
    producto.setPrecioMayoreo(precioM);
    producto.setExistencias(existencias);
    producto.setContenedor(contenedor);
    producto.setIdPresentacion(presentacion);
    producto.setIdTipo(tipo);
    producto.setCantidadMa(cantidadMa);
    producto.setPzCaja(pzCaja);
    
     try {
            DAOproductos dao = new DAOproductosImp();
            dao.registrar(producto);
            limpiarCampos();
            borrrarTabla();
            if(tipo==1)
            {
            loadAbarrotes();
            }else if(tipo==2){
            loadPanaderia();
            }else if(tipo==3){
            loadVerduras();
            }else if(tipo==4){
            loadCremeria();
            }else if(tipo==5){
            loadBultos();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al guardar los datos","ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Se han ingresado datos incompatibles, intentelo de nuevo","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    


        // TODO add your handling code here:
    }
    }//GEN-LAST:event_jbAgregarMouseClicked

    private void jbModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbModificarMouseClicked
    int presentacion;
    String codigo,nombre,contenedor;
    double precioU,precioM,pzCaja,cantidadMa,existencias; 
    com.mycompany.models.productos producto = new com.mycompany.models.productos();
    if(txtCodigo.getText().isEmpty()||txtNombre.getText().isEmpty()||txtExistencias.getText().isEmpty()||txtPrecioUni.getText().isEmpty()||txtPrecioMa.getText().isEmpty())
    {
        JOptionPane.showMessageDialog(this, "Llene los campos necesarios para la modificacion","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }else{
        try {
        if(tipo != 4){
        codigo = txtCodigo.getText();
        nombre = txtNombre.getText();
        precioU = Double.parseDouble(txtPrecioUni.getText());
        precioM = Double.parseDouble(txtPrecioMa.getText());
        existencias = Double.parseDouble(txtExistencias.getText());
        pzCaja = Double.parseDouble(txtPiezasCj.getText());
        cantidadMa = Double.parseDouble(txtCantidadMa.getText());
        contenedor = txtContenedor.getText();
        }else{
        codigo = txtCodigo.getText();
        nombre = txtNombre.getText();
        precioU = Double.parseDouble(txtPrecioUni.getText());
        precioM = Double.parseDouble(txtPrecioMa.getText());
        existencias = Double.parseDouble(txtExistencias.getText());
        pzCaja = 0;
        cantidadMa = Double.parseDouble(txtCantidadMa.getText());
        contenedor = txtPiezasCj.getText();
        }    
    
    
    Object selectedItem = cbxPresentacion.getSelectedItem();
if (selectedItem == null) {
    throw new IllegalStateException("No se ha seleccionado ningún tipo.");
}

switch (selectedItem.toString()) {
    case "Individual":
        presentacion = 1;
        break;
    case "Paquete Chico":
        presentacion = 2;
        break;
    case "Paquete Mediano":
        presentacion = 3;
        break;
    case "Paquete Grande":
        presentacion = 4;
        break;
    case "Granel":
        presentacion = 5;
        break;
    default:
        throw new IllegalArgumentException("Tipo desconocido: " + selectedItem);
    }
    
    
    producto.setIdProducto(codigo);
    producto.setNombreProducto(nombre);
    producto.setPrecioUnitario(precioU);
    producto.setPrecioMayoreo(precioM);
    producto.setExistencias(existencias);
    producto.setContenedor(contenedor);
    producto.setIdPresentacion(presentacion);
    producto.setIdTipo(tipo);
    producto.setCantidadMa(cantidadMa);
    producto.setPzCaja(pzCaja);
    
     try {
            DAOproductos dao = new DAOproductosImp();
            dao.modificar(producto);
            limpiarCampos();
            borrrarTabla();
            if(tipo==1)
            {
            loadAbarrotes();
            }else if(tipo==2){
            loadPanaderia();
            }else if(tipo==3){
            loadVerduras();
            }else if(tipo==4){
            loadCremeria();
            }else if(tipo==5){
            loadBultos();
            }
            JOptionPane.showMessageDialog(this, "Se ha modificado el producto correctamente","OPERACION EXITOSA",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al guardar los datos","ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Se han ingresado datos incompatibles, intentelo de nuevo"+e,"AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    


        // TODO add your handling code here:
    }
    }//GEN-LAST:event_jbModificarMouseClicked
    private void inicializaBUltos(){
    tipo=5;
    cbxPresentacion.enable(false);
    txtPiezasCj.enable(true);
        jbBultos.setBackground(Color.WHITE); 
    jbBultos.setForeground(Color.black);
    jbCremeria.setBackground(new Color(225,124,22)); 
    jbCremeria.setForeground(Color.WHITE);
    jbPanaderia.setBackground(new Color(225,124,22));
    jbPanaderia.setForeground(Color.WHITE);
    jbVerduras.setBackground(new Color(225,124,22));
    jbVerduras.setForeground(Color.WHITE);
    jbAbarrotes.setBackground(new Color(225,124,22)); 
    jbAbarrotes.setForeground(Color.WHITE);
    lblCodigo.setText("IDENTIFICADOR");
    lblNombre.setText("DESCRIPCION");
    lblPrecioUni.setText("PRECIO UNITARIO");
    lblPiezasCj.setText("KG BULTO");
    lblConte.setText("PRODUCTO CONTENIDO");
    
    lblPrecioMa.setVisible(true);
    txtPrecioMa.setVisible(true);
    lblPresentacion.setVisible(true);
    lblConte.setVisible(false);
    txtContenedor.setVisible(false);
    cbxPresentacion.setVisible(true); 
    lblPiezasCj.setVisible(true);
    txtPiezasCj.setVisible(true);
    lblCantidadMa.setVisible(true);
    txtCantidadMa.setVisible(true);
    
    }
    private void tablaBultos(){
     DefaultTableModel model = (DefaultTableModel) tablaInventario.getModel();
    model.addColumn("IDENTIFICADOR");
    model.addColumn("DESCRIPCION");
    model.addColumn("PRECIO UNITARIO");
    model.addColumn("PRECIO MAYOREO");
    model.addColumn("CANTIDAD MAYOREO");
    model.addColumn("EXISTENCIAS");
    model.addColumn("KG BULTO");
    }
    private void jbBultosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbBultosMouseClicked
    inicializaBUltos();
    limpiarCampos();
    inicializarprecio();
    borrrarTabla();
    tablaBultos();
    loadBultos();
    }//GEN-LAST:event_jbBultosMouseClicked

    private void cbxPresentacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPresentacionItemStateChanged
    if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        if (tipo==4){
        
        }else{
        // Obtén el valor seleccionado
        Object selectedItem = cbxPresentacion.getSelectedItem();
        if(selectedItem=="Individual"||selectedItem=="Granel"){
            txtPiezasCj.setText("0");
            txtPiezasCj.enable(false);
        }
        if(selectedItem!="Individual"&&selectedItem!="Granel"){
            txtPiezasCj.setText("0");
            txtPiezasCj.enable(true);
    }
        }
        
    }
    }//GEN-LAST:event_cbxPresentacionItemStateChanged

    private void jbLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLimpiarMouseClicked
    limpiarCampos();    // TODO add your handling code here:
    }//GEN-LAST:event_jbLimpiarMouseClicked

    private void tablaInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInventarioMouseClicked
        if(tablaInventario.getSelectedRow() > -1){
    String idProducto = (String) tablaInventario.getValueAt(tablaInventario.getSelectedRow(), 0);
    DAOproductos dao = new DAOproductosImp();
            try {
                MostrarCampos(dao.obtenerProductosTipo(idProducto));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Error al mostrar los datos","ERROR",javax.swing.JOptionPane.ERROR_MESSAGE);
            }
    
    }
    }//GEN-LAST:event_tablaInventarioMouseClicked

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
    txtNombre.requestFocus();    // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    txtPrecioUni.requestFocus();    // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtPrecioUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUniActionPerformed
    txtPrecioMa.requestFocus();   // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioUniActionPerformed

    private void txtPrecioMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioMaActionPerformed
    txtCantidadMa.requestFocus();    // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioMaActionPerformed

    private void txtCantidadMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadMaActionPerformed
    txtExistencias.requestFocus();   // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadMaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxPresentacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAbarrotes;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBultos;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbCremeria;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbPanaderia;
    private javax.swing.JButton jbVerduras;
    private javax.swing.JPanel jpInventarioMneu;
    private javax.swing.JLabel lblCantidadMa;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConte;
    private javax.swing.JLabel lblExistencias;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPiezasCj;
    private javax.swing.JLabel lblPrecioMa;
    private javax.swing.JLabel lblPrecioUni;
    private javax.swing.JLabel lblPresentacion;
    private javax.swing.JTable tablaInventario;
    private javax.swing.JTextField txtCantidadMa;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtContenedor;
    private javax.swing.JTextField txtExistencias;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPiezasCj;
    private javax.swing.JTextField txtPrecioMa;
    private javax.swing.JTextField txtPrecioUni;
    // End of variables declaration//GEN-END:variables
}
