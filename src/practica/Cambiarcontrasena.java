/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package practica;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Mariana M
 */
public class Cambiarcontrasena extends javax.swing.JInternalFrame {

    
    public Cambiarcontrasena() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablacambiar = new javax.swing.JTable();
        btnCambiar = new javax.swing.JButton();

        tablacambiar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de usuario", "Cargo", "Fecha de cambio", "Contraseña"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablacambiar);

        btnCambiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnrestablecer-la-contrasena.png"))); // NOI18N
        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCambiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
       String usuario;
       String contraseña_nueva;
       String contraseña_actualpp;
       String nombreArchivo="src/practica/usuarios.txt";
       usuario=JOptionPane.showInputDialog("su usuario");
       contraseña_actualpp=JOptionPane.showInputDialog("contraseña actual ");
       contraseña_nueva=JOptionPane.showInputDialog("nueva contraseña");
       try ( BufferedReader bufferReader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            StringBuilder fileContent = new StringBuilder();
            while ((linea = bufferReader.readLine()) != null) {
                String[] partes = linea.split(";");
                String user = partes[0].trim();
                String contraseña_actual = partes[1].trim();
                if (contraseña_actual.equals(contraseña_actualpp) && usuario.equals(user)) {
                    // Modifica el campo correspondiente
                    partes[1] = contraseña_nueva;
                    // Reconstruye la línea con los cambios
                    String nuevaLinea = String.join(",", partes);
                    fileContent.append(nuevaLinea).append("\n");
                } else {
                    fileContent.append(linea).append("\n");
                }
            }
            try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
                fileWriter.write(fileContent.toString());
                JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente");
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
       JOptionPane.showMessageDialog(null, "La contraseña se restablecido con éxito", "Eliminar", 3);
       
    }//GEN-LAST:event_btnCambiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablacambiar;
    // End of variables declaration//GEN-END:variables
}
