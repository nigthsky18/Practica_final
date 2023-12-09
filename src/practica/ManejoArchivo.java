package practica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ManejoArchivo {
    private static final String archivo = "src/practica/usuarios.txt";
     private String usuario;
    private String contraseña;
    private String tipo;

    public ManejoArchivo() {
    }

    public ManejoArchivo(String usuario, String contraseña, String tipo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }
    

   public void escibirRegistro(Registro registro) {
        try ( BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true)))
        {

            String datos = registro.getDni() + ";" + registro.getNombre() + ";" + registro.getFechaNacimiento()+ ";" + registro.getCargo() + ";";
            escritor.write(datos);
            escritor.newLine();
            JOptionPane.showMessageDialog(null, "Vendedor registrado correctamente", "Usuario registrado", 3);

        } catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", 0);
        }
    }
   public boolean validarRegistro(Registro registro) {
        String dni = registro.getDni();
        String nombre = registro.getNombre();
        String fechaNacimiento = registro.getFechaNacimiento();
        String cargo = registro.getCargo();
        
        // Validar que los campos no estén vacíos y que la fecha de nacimiento tenga el formato dd/MM/yyyy
        if (dni.isEmpty() || nombre.isEmpty() || fechaNacimiento.isEmpty() || cargo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!fechaNacimiento.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto (dd/MM/yyyy)", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Otras validaciones que puedas necesitar para la contraseña o campos adicionales

        return true;
    }
   
    public boolean validarIngreso(int usuarioIndex, int contraseñaIndex, int tipoIndex) {
        try
        {
            FileReader lector = new FileReader(archivo);
            BufferedReader escritor = new BufferedReader(lector);

            String linea;
            while ((linea = escritor.readLine()) != null)
            {
                String[] campos = linea.split(";|,");

                if (campos.length > tipoIndex)
                {
                    String usuarioActual = campos[usuarioIndex];
                    String contraseñaActual = campos[contraseñaIndex];
                    String tipoActual = campos[tipoIndex];

                    if (usuario.equals(usuarioActual) && contraseña.equals(contraseñaActual) && tipo.equals(tipoActual))
                    {
                        escritor.close();
                        return true;
                    }
                }
            }

            escritor.close();
            return false;
        } catch (IOException e)
        {
            System.err.println("Error: No se pudo leer el archivo '" + archivo + "'.");
            return false;
        }
    }

}
