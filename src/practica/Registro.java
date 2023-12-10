/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Registro extends javax.swing.JInternalFrame {

    private JTextField nombreUsuarioField, idField, nombreField, fechaNacimientoField;
    private JComboBox<String> cargoComboBox;
    private JPasswordField passwordField;
    private JButton registrarButton;
    private JButton limpiarButton;
    private ManejoArchivo registros = new ManejoArchivo();

    public Registro() {
        setTitle("Registro de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null);

        initComponents(); // Inicialización de los componentes
        ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
        setVisible(true);
    }

    private void initComponents() {
        JLabel dniLabel = new JLabel("Nombre de usuario:");
        dniLabel.setBounds(20, 20, 120, 25);
        add(dniLabel);
        nombreUsuarioField = new JTextField();
        nombreUsuarioField.setBounds(180, 20, 300, 35); // Aumentar el tamaño del campo de texto
        add(nombreUsuarioField);

        JLabel idLabel = new JLabel("´ID:");
        idLabel.setBounds(20, 70, 120, 25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(180, 70, 300, 35); // Aumentar el tamaño del campo de texto
        add(idField);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(20, 120, 120, 25);
        add(nombreLabel);
        nombreField = new JTextField();
        nombreField.setBounds(180, 120, 300, 35); // Aumentar el tamaño del campo de texto
        add(nombreField);

        JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento:");
        fechaNacimientoLabel.setBounds(20, 170, 150, 25);
        add(fechaNacimientoLabel);
        fechaNacimientoField = new JTextField();
        fechaNacimientoField.setBounds(180, 170, 300, 35); // Aumentar el tamaño del campo de texto
        add(fechaNacimientoField);

        JLabel cargoLabel = new JLabel("Cargo:");
        cargoLabel.setBounds(20, 220, 120, 25);
        add(cargoLabel);

        String[] opcionesCargo = {"Administrador", "Estudiante", "Profesor", "Invitado"};
        cargoComboBox = new JComboBox<>(opcionesCargo);
        cargoComboBox.setBounds(180, 220, 300, 35); // Aumentar el tamaño del combo box
        add(cargoComboBox);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(20, 270, 120, 25);
        add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 270, 300, 35); // Aumentar el tamaño del campo de contraseña
        add(passwordField);

        registrarButton = new JButton("Registrar");
        registrarButton.setBounds(180, 320, 120, 35);
        add(registrarButton);
        registrarButton.addActionListener((e) -> {
            if (e.getSource() == registrarButton) {
                if (registros.validarRegistro(this)) {
                    registros.escibirRegistro(this);
                    limpiarCampos();
                }
            }
        });

        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(360, 320, 120, 35);
        add(limpiarButton);
        limpiarButton.addActionListener((e) -> {
            limpiarCampos();
        });
}
private void limpiarCampos() {
        nombreUsuarioField.setText("");
        idField.setText("");
        nombreField.setText("");
        fechaNacimientoField.setText("");
        cargoComboBox.setSelectedIndex(0);
        passwordField.setText("");
    }
    public String getNombreusuario() {
        return nombreUsuarioField.getText();
    }

    public void setDniField(JTextField dniField) {
        this.nombreUsuarioField = dniField;
    }

    public String getId() {
        return idField.toString();
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public String getNombre() {
        return nombreField.getText();
    }

    public void setNombreField(JTextField nombreField) {
        this.nombreField = nombreField;
    }

    public String getFechaNacimiento() {
        return fechaNacimientoField.getText();
    }

    public void setFechaNacimientoField(JTextField fechaNacimientoField) {
        this.fechaNacimientoField = fechaNacimientoField;
    }

    public String getCargo() {
        return cargoComboBox.getSelectedItem().toString();
    }

//    public void setCargoField(JTextField cargoField) {
//        this.cargoField = cargoField;
//    }
    public String getPassword() {
        return passwordField.getText();
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarButton)
        {
            if (registros.validarRegistro(this))
            {
                registros.escibirRegistro(this);
                
                
            }

        }
    }

}
