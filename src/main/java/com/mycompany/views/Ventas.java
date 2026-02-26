/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.views;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author abarrotesluna
 */
public class Ventas extends javax.swing.JPanel {

    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        jPanel1.setLayout(new BorderLayout());
        JPanel acciones = crearPanelAcciones();
        jPanel1.add(jPanel4, BorderLayout.NORTH); // total arriba
        jPanel1.add(acciones, BorderLayout.CENTER); // acciones abajo
        jPanel1.add(acciones);
        estilizarFondos();
        estilizarTabla();
        estilizarTotal();
        estilizarScanner();
        configurarTabla();
        
        
        
    }
    private JPanel crearCardAccion(String fKey, String titulo) {

    Color fondoNormal = new Color(248, 249, 251);
    Color fondoHover  = new Color(235, 240, 245);
    Color bordeColor  = new Color(220, 225, 230);

    JPanel card = new JPanel();
    card.setLayout(new BorderLayout(10, 5));
    card.setBackground(fondoNormal);
    card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(bordeColor, 1, true),
            BorderFactory.createEmptyBorder(18, 22, 18, 22)
    ));
    card.setCursor(new Cursor(Cursor.HAND_CURSOR));

    // F-Key arriba
    JLabel lblFKey = new JLabel(fKey);
    lblFKey.setFont(new Font("SansSerif", Font.BOLD, 13));
    lblFKey.setForeground(new Color(0, 102, 204));

    // Título principal
    JLabel lblTitulo = new JLabel(titulo);
    lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
    lblTitulo.setForeground(new Color(45, 45, 45));

    JPanel contenido = new JPanel();
    contenido.setLayout(new BorderLayout());
    contenido.setOpaque(false);
    contenido.add(lblFKey, BorderLayout.NORTH);
    contenido.add(lblTitulo, BorderLayout.CENTER);

    card.add(contenido, BorderLayout.CENTER);

    // Hover effect
    card.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            card.setBackground(fondoHover);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            card.setBackground(fondoNormal);
        }
    });

    return card;
}
private JPanel crearPanelAcciones() {

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2, 20, 20));
    panel.setBackground(Color.WHITE);
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    panel.add(crearCardAccion("F1", "Buscar"));
    panel.add(crearCardAccion("F2", "Anular"));
    panel.add(crearCardAccion("F3", "Descuento"));
    panel.add(crearCardAccion("F4", "Existencias"));
    panel.add(crearCardAccion("F5", "Cantidad"));
    panel.add(crearCardAccion("F6", "Re-ticket"));
    panel.add(crearCardAccion("F7", "Mayoreo"));

    return panel;
}

    private void configurarTabla() {

    jTable1.setRowHeight(28);
    jTable1.setShowVerticalLines(false);
    jTable1.setGridColor(new Color(230, 230, 230));

    jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            if (!isSelected) {
                if (row % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(new Color(245, 247, 250)); // gris claro moderno
                }
            }

            setBorder(noFocusBorder);
            return c;
        }
    });
}

    private void estilizarTabla() {

    jTable1.setRowHeight(42);
    jTable1.setShowGrid(false);
    jTable1.setIntercellSpacing(new Dimension(0, 0));
    jTable1.setFillsViewportHeight(true);

    jTable1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    jTable1.setSelectionBackground(new Color(220, 235, 255));
    jTable1.setSelectionForeground(Color.BLACK);

    // Encabezado
    jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
    jTable1.getTableHeader().setReorderingAllowed(false);
    jTable1.getTableHeader().setBackground(new Color(245, 247, 250));
    jTable1.getTableHeader().setForeground(Color.DARK_GRAY);

    // Quitar borde feo del scroll
    jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
    }
    //estilizar panel total
    private void estilizarTotal() {

        jPanel4.setBackground(Color.WHITE);
        jPanel4.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 230, 230)),
                BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 13));
        jLabel1.setForeground(new Color(120, 120, 120));

        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 28));
        jLabel2.setForeground(new Color(0, 120, 215));

        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 46));
        jLabel3.setForeground(new Color(0, 170, 90));
    }
    
    //estilizar los botones
    
    //mejorar visualmente el escaneo
    private void estilizarScanner() {

    jTextField1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    jTextField1.setPreferredSize(new Dimension(400, 50));

    jTextField1.putClientProperty(
            "JTextField.placeholderText",
            "Escanear código de barras o presionar F1 para buscar..."
    );
}   
    //fondo del jpanel principal
    private void estilizarFondos() {

    this.setBackground(new Color(245, 247, 250));

    jPanel1.setBackground(new Color(245, 247, 250));
    jPanel2.setBackground(Color.WHITE);
    jPanel3.setBackground(new Color(245, 247, 250));
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
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(17, 17, 17));
        jLabel1.setText("TOTAL A PAGAR");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("$");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("0.00");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 177, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addGap(160, 160, 160))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
