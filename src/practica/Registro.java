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

public class Registro extends JFrame implements ActionListener {
    private JTextField dniField, idField, nombreField, fechaNacimientoField;
    private JComboBox<String> cargoComboBox;
    private JPasswordField passwordField;
    private JButton registrarButton;
    private ManejoArchivo registros =new ManejoArchivo();

    public Registro() {
setTitle("Registro de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        initComponents(); // Inicialización de los componentes

        setVisible(true);
    }
     private void initComponents() {
        JLabel dniLabel = new JLabel("DNI (opcional):");
        dniLabel.setBounds(20, 20, 120, 25);
        add(dniLabel);
        dniField = new JTextField();
        dniField.setBounds(150, 20, 200, 25);
        add(dniField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 50, 120, 25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(150, 50, 200, 25);
        add(idField);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(20, 80, 120, 25);
        add(nombreLabel);
        nombreField = new JTextField();
        nombreField.setBounds(150, 80, 200, 25);
        add(nombreField);

        JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento:");
        fechaNacimientoLabel.setBounds(20, 110, 120, 25);
        add(fechaNacimientoLabel);
        fechaNacimientoField = new JTextField();
        fechaNacimientoField.setBounds(150, 110, 200, 25);
        add(fechaNacimientoField);

        JLabel cargoLabel = new JLabel("Cargo:");
        cargoLabel.setBounds(20, 140, 120, 25);
        add(cargoLabel);

        String[] opcionesCargo = {"Administrador", "Estudiante", "Profesor", "Invitado"};
        cargoComboBox = new JComboBox<>(opcionesCargo);
        cargoComboBox.setBounds(150, 140, 200, 25);
        add(cargoComboBox);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(20, 170, 120, 25);
        add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 170, 200, 25);
        add(passwordField);

        registrarButton = new JButton("Registrar");
        registrarButton.setBounds(150, 220, 100, 25);
        add(registrarButton);
        registrarButton.addActionListener(this);
    }


    public String getDni() {
        return dniField.getText();
    }

    public void setDniField(JTextField dniField) {
        this.dniField = dniField;
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
        if (e.getSource() == registrarButton) {
            if(registros.validarRegistro(this))
            {
                registros.escibirRegistro(this);
            }
            
        }
    }
    
    
     

    
}