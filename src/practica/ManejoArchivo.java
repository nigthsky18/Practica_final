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

            String datos = registro.getNombreusuario() + ";" + registro.getPassword() + ";" + registro.getNombre() + ";" + registro.getFechaNacimiento() + ";" + registro.getCargo() + ";";
            escritor.write(datos);
            escritor.newLine();
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Usuario registrado", 3);

        } catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", 0);
        }
    }

    public boolean validarRegistro(Registro registro) {
        String dni = registro.getId();
        String usuario = registro.getNombreusuario();
        String nombre = registro.getNombre();
        String fechaNacimiento = registro.getFechaNacimiento();
        String cargo = registro.getCargo();
        String contrasena= registro.getPassword();

        
        if (dni.isEmpty() || nombre.isEmpty() || fechaNacimiento.isEmpty() || cargo.isEmpty() || usuario.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error",2);
            return false;
        }
        if (!nombre.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)*$"))
        {
            JOptionPane.showMessageDialog(null, "Nombre incorrecto", "Error", 2);
            return false;
        }
        if (!fechaNacimiento.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$"))
        {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto  (DD/MM/AAAA)", "Error",2);
            return false;
        }
        if (usuario.matches(".*\\s+.*"))
        {
            JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener espacios en blanco", "Error", 2);
            return false;
        }
        if (contrasena.length() < 8 || !contrasena.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
        JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres con al menos una mayúscula, una minúscula, un número y un carácter especial (@#$%^&+=)", "Error", 2);
        return false;
    }

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
