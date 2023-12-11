package practica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManejoArchivo {

    private static final String archivo = "src/practica/usuarios.txt";
     private static final String archivoM = "src/practica/matricula.txt";
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
    public void escibirMatricula(String estudiante, String profesor) {
        try ( BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoM, true)))
        {

            String datos = profesor + ";" + estudiante + ";";
            escritor.write(datos);
            escritor.newLine();
            JOptionPane.showMessageDialog(null, "Usuario Matriculado correctamente", "Usuario registrado", 3);

        } catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", 0);
        }
    }

    

    public void escibirRegistro(Registro registro) {
        try ( BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true)))
        {

            String datos = registro.getNombreusuario() + ";" + registro.getPassword() + ";" + registro.getNombre() + ";" + registro.getFechaNacimiento() + ";" + registro.getCargo() + ";"+ registro.getId();
            escritor.write(datos);
            escritor.newLine();
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Usuario registrado", 3);

        } catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar", "Error", 0);
        }
    }


    
    public void escibirInvitado(RegistroInvitados registro) {
        try ( BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true)))
        {

            String datos = registro.getNombreusuario() + ";" + registro.getPassword() + ";" + registro.getNombre() + ";" + registro.getFechaNacimiento() + ";" + "Invitado" + ";"+ registro.getId();
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
    
     public boolean validarInvitado(RegistroInvitados registro) {
        String dni = registro.getId();
        String usuario = registro.getNombreusuario();
        String nombre = registro.getNombre();
        String fechaNacimiento = registro.getFechaNacimiento();
        String cargo = "Invitado";
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
     
    public ArrayList<String[]> leerRegistros() {
        ArrayList<String[]> registros = new ArrayList<>();
        try ( BufferedReader lector = new BufferedReader(new InputStreamReader(new FileInputStream(archivo))))
        {
            String linea;
            while ((linea = lector.readLine()) != null)
            {
                String[] campos = linea.split(";");
                
                registros.add(campos);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return registros;
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
    public boolean validarEstudiante(String nombre) {
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = bufferReader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 5) { 
                    String campo2 = partes[2].trim();
                    String campo4 = partes[4].trim();
                    if (campo2.equalsIgnoreCase(nombre) && campo4.equalsIgnoreCase("Estudiante")) {
                        return true; // Se encontró un estudiante con ambos campos como "Estudiante"
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // No se encontró ninguna línea que cumpla con las condiciones
    }

      public void modificarRegistros(Registro registro) {
        boolean encontrado = false;

        try
        {
            ArrayList<String> lineas = new ArrayList<>();
            String linea;
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            while ((linea = reader.readLine()) != null)
            {
                String[] campos = linea.split(";");
                if (campos.length >= 6 && campos[5].equals(registro.getId()))
                {

                    campos[0] = registro.getNombreusuario();
                    campos[1] = registro.getPassword();
                    campos[2] = registro.getNombre();
                    campos[3] = registro.getFechaNacimiento();
                    campos[4] = registro.getCargo();
                    campos[5] = registro.getId();

                    linea = String.join(";", campos);
                    encontrado = true;
                }
                lineas.add(linea);
            }
            reader.close();

            // Reescribe el archivo con las modificaciones
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo));
            for (String l : lineas)
            {
                escribir.write(l);
                escribir.newLine();
            }
            escribir.close();

        } catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (encontrado)
        {
            JOptionPane.showMessageDialog(null, "Registro modificado correctamente", "Registro modificado", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JOptionPane.showMessageDialog(null, "La cédula ingresada no se encuentra registrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
