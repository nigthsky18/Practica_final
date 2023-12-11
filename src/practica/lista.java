package practica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class lista {

    int tam = 100;
    private Nodo head;

    public lista() {
        head = null;
    }

    public Nodo getHead() {
        return head;
    }
    lista listaAdmins;
    lista listaProfesores;
    lista listaInvitados;
    private static final String RUTA_ARCHIVO = "src/practica/usuarios.txt";
    private static final String RUTA_ARCHIVO_MATRICULAS = "Matriculas.txt";

    public void abrirarchivo(String nombreArchivo) {
        listaAdmins = new lista();
        listaProfesores = new lista();
        listaInvitados = new lista();
        try ( BufferedReader bufferReader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = bufferReader.readLine()) != null) {
                String[] partes = linea.split(";");
                String usuario = partes[0];
                String cargo = partes[4];

                // Agregar nodos a las listas según el cargo
                if ("Administrador".equalsIgnoreCase(cargo)) {
                    listaAdmins.AgregarNodo(cargo, usuario);
                } else if ("Profesor".equalsIgnoreCase(cargo)) {
                    // Agregar un nodo de profesor a la lista de profesores
                    listaProfesores.AgregarNodo(cargo, usuario);
                } else if ("Invitado".equalsIgnoreCase(cargo)) {
                    listaInvitados.AgregarNodo(cargo, usuario);
                }
            }

            // Luego, iterar por el archivo de matrículas para vincular estudiantes a profesores
            /*try ( BufferedReader matriculasReader = new BufferedReader(new FileReader(RUTA_ARCHIVO_MATRICULAS))) {
                String matriculaLinea;
                while ((matriculaLinea = matriculasReader.readLine()) != null) {
                    String[] partesMatricula = matriculaLinea.split(",");
                    String usuarioProfesor = partesMatricula[0].trim();
                    String usuarioEstudiante = partesMatricula[1].trim();
                    // Utilizar el método modificado para agregar estudiantes con sublista a profesores
                    listaProfesores.AgregarNodoConSublista(usuarioEstudiante, usuarioProfesor);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void AgregarNodoConSublista(String usuarioEstudiante, String usuarioProfesor) {
        Nodo nuevoEstudiante = new Nodo("Estudiante", usuarioEstudiante, 0);

        // Buscar el profesor en la lista
        Nodo actualProfesor = head;
        while (actualProfesor != null && !actualProfesor.getUsuario().equals(usuarioProfesor)) {
            actualProfesor = actualProfesor.getLiga();
        }
        // Encontró al profesor, cambia el tag y vincula la sublista del estudiante
        if (actualProfesor.getTag() != 1) {
            actualProfesor.setTag(1); // Cambia el tag del profesor a 1
        }
        nuevoEstudiante.setSubLista(actualProfesor.getSubLista()); // Vincula la sublista del profesor al estudiante
        actualProfesor.setSubLista(nuevoEstudiante); // Vincula al estudiante como sublista del profesor
    }

    public void AgregarNodo(String cargo, String user) {
        Nodo nuevoNodo = new Nodo(cargo, user, 0);
        if (head == null) {
            head = nuevoNodo;
        } else {
            Nodo temp = head;
            while (temp.liga != null) {
                temp = temp.liga;
            }
            temp.liga = nuevoNodo;
        }
    }

    public void mostrarListas() {
        mostrarLista(listaAdmins);
        mostrarLista(listaProfesores);
        mostrarLista(listaProfesores);
    }

    public void mostrarLista(lista lista) {
        Nodo current = lista.head;
        System.out.println("Usuarios:");
        while (current != null) {
            System.out.println("Usuario: " + current.getUsuario() + ", Cargo: " + current.getCargo());
            current = current.getLiga();
        }

    }
}