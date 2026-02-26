/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superluna;

import com.mycompany.models.productos;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BuscarProductoDialog extends JDialog {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JTextField txtBuscar;
    private productos productoSeleccionado;

    public BuscarProductoDialog(JFrame parent) {
        super(parent, "Buscar producto", true);
        init();
    }
    
    private void init() {
        setSize(600, 400);
        setLocationRelativeTo(null);

        txtBuscar = new JTextField();
        JButton btnBuscar = new JButton("Buscar");

        modelo = new DefaultTableModel(
            new String[]{"Código", "Nombre", "Precio", "Existencia"}, 0
        ){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

        tabla = new JTable(modelo);

        btnBuscar.addActionListener(e -> buscar());

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    seleccionarProducto();
                }
            }
        });

        JPanel top = new JPanel(new BorderLayout());
        top.add(txtBuscar, BorderLayout.CENTER);
        top.add(btnBuscar, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
    private void buscar() {
    try {
        DAOproductosImp dao = new DAOproductosImp();
        modelo.setRowCount(0);

        for (productos p : dao.buscar(txtBuscar.getText())) {
            modelo.addRow(new Object[]{
                p.getIdProducto(),
                p.getNombreProducto(),
                p.getPrecioUnitario(),
                p.getExistencias()
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
private void seleccionarProducto() {
    int fila = tabla.getSelectedRow();
    if (fila == -1) return;

    productoSeleccionado = new productos();

    productoSeleccionado.setIdProducto(
        modelo.getValueAt(fila, 0).toString()
    );

    productoSeleccionado.setNombreProducto(
        modelo.getValueAt(fila, 1).toString()
    );

    Number precio = (Number) modelo.getValueAt(fila, 2);
    productoSeleccionado.setPrecioUnitario(precio.doubleValue());

    Number existencias = (Number) modelo.getValueAt(fila, 3);
    productoSeleccionado.setExistencias(existencias.intValue());

    dispose(); // ahora sí se cierra
}


public productos getProductoSeleccionado() {
    return productoSeleccionado;
}


}