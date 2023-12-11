/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package practica;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mariana M
 */
public class Matricular extends javax.swing.JInternalFrame {

    /**
     * Creates new form Matricular
     */
    public Matricular() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMatricula = new javax.swing.JTable();
        btnMatricular = new javax.swing.JButton();

        tablaMatricula.setBorder(new javax.swing.border.MatteBorder(null));
        tablaMatricula.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tablaMatricula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Nombre", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaMatricula);

        btnMatricular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnmatricula.png"))); // NOI18N
        btnMatricular.setText("Matricular");
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        ManejoArchivo matricula = new ManejoArchivo();
        String profesor = obtenerProfesorSeleccionado();
        String estudiante = JOptionPane.showInputDialog(null, "Ingresa el nombre del estudiante que matriculará con el docente", "Matricular", 3);
        ManejoArchivo archivo= new ManejoArchivo();
       if( archivo.validarEstudiante(estudiante))
       {
        matricula.escibirMatricula(profesor, estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante matriculado correctamente", "Validacion", 3);
       }else
       {
           JOptionPane.showMessageDialog(null, "Ha ingresado un estudiarnte no registrado", "Validacion", 2);
       }
    }//GEN-LAST:event_btnMatricularActionPerformed

    public String obtenerProfesorSeleccionado() {
    int filaSeleccionada = tablaMatricula.getSelectedRow();
    if (filaSeleccionada >= 0) {
        return tablaMatricula.getValueAt(filaSeleccionada, 0).toString();
    }
    return null; // Retorna null si no se selecciona ninguna fila
}

    public void cargarDatosTabla(lista listaProfesores) {
        DefaultTableModel model = (DefaultTableModel) tablaMatricula.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

        Nodo current = listaProfesores.getHead();
        while (current != null)
        {
            // Agregar cada profesor a la tabla
            model.addRow(new Object[]
            {
                current.getUsuario(), current.getCargo()
            });
            current = current.getLiga();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMatricular;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaMatricula;
    // End of variables declaration//GEN-END:variables

    

}
