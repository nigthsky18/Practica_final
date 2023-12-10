/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class Lista {

    int tam = 100;
    private Nodo head;

    public Lista() {
        head = null;
    }

    public Nodo getHead() {
        return head;
    }
    Lista listaAdmins;
    Lista listaProfesores;
    Lista listaInvitados;
    private static final String nombreArchivo = "src/practica/usuarios.txt";
    private static final String RUTA_ARCHIVO_MATRICULAS = "src/practica/matricula.txt";

    public void abrirarchivo() {
        listaAdmins = new Lista();
        listaProfesores = new Lista();
        listaInvitados = new Lista();
        try ( BufferedReader bufferReader = new BufferedReader(new FileReader(nombreArchivo)))
        {
            String linea;
            while ((linea = bufferReader.readLine()) != null)
            {
                String[] partes = linea.split(";");
                String usuario = partes[0];
                String cargo = partes[4];

                // Agregar nodos a las listas según el cargo
                if ("Administrador".equalsIgnoreCase(cargo))
                {
                    listaAdmins.AgregarNodo(cargo, usuario);
                } else if ("Profesor".equalsIgnoreCase(cargo))
                {
                    // Agregar un nodo de profesor a la lista de profesores
                    listaProfesores.AgregarNodo(cargo, usuario);
                } else if ("Invitado".equalsIgnoreCase(cargo))
                {
                    listaInvitados.AgregarNodo(cargo, usuario);
                }
            }

            // Luego, iterar por el archivo de matrículas para vincular estudiantes a profesores
            try ( BufferedReader matriculasReader = new BufferedReader(new FileReader(RUTA_ARCHIVO_MATRICULAS)))
            {
                String matriculaLinea;
                while ((matriculaLinea = matriculasReader.readLine()) != null)
                {
                    String[] partesMatricula = matriculaLinea.split(";");
                    String usuarioProfesor = partesMatricula[0].trim();
                    String usuarioEstudiante = partesMatricula[1].trim();
                    // Utilizar el método modificado para agregar estudiantes con sublista a profesores
                    listaProfesores.AgregarNodoConSublista(usuarioEstudiante, usuarioProfesor);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void AgregarNodoConSublista(String usuarioEstudiante, String usuarioProfesor) {
        Nodo nuevoEstudiante = new Nodo("Estudiante", usuarioEstudiante, 0);

        // Buscar el profesor en la lista
        Nodo actualProfesor = head;
        while (actualProfesor != null && !actualProfesor.getUsuario().equals(usuarioProfesor))
        {
            actualProfesor = actualProfesor.getLiga();
        }
        // Encontró al profesor, cambia el tag y vincula la sublista del estudiante
        if (actualProfesor.getTag() != 1)
        {
            actualProfesor.setTag(1); // Cambia el tag del profesor a 1
        }
        nuevoEstudiante.setSubLista(actualProfesor.getSubLista()); // Vincula la sublista del profesor al estudiante
        actualProfesor.setSubLista(nuevoEstudiante); // Vincula al estudiante como sublista del profesor
    }

    public void AgregarNodo(String cargo, String user) {
        Nodo nuevoNodo = new Nodo(cargo, user, 0);
        if (head == null)
        {
            head = nuevoNodo;
        } else
        {
            Nodo temp = head;
            while (temp.liga != null)
            {
                temp = temp.liga;
            }
            temp.liga = nuevoNodo;
        }
    }

    public void mostrarLista() {
        Nodo actual = head;
        while (actual != null)
        {
            System.out.println("Cargo: " + actual.getCargo() + ", Usuario: " + actual.getUsuario());
            if (actual.getSubLista() != null)
            {
                Nodo sublista = actual.getSubLista();
                while (sublista != null)
                {
                    System.out.println("\tEstudiante de " + actual.getUsuario() + ": " + sublista.getUsuario());
                    sublista = sublista.getLiga();
                }
            }
            actual = actual.getLiga();
        }
        
    }
    public void mostrarInformacionCompleta() {
    Nodo actual = head;
    while (actual != null) {
        System.out.println("Cargo: " + actual.getCargo() + ", Usuario: " + actual.getUsuario() + ", Tag: " + actual.getTag());
        
        // Si el nodo tiene una sublista
        if (actual.getSubLista() != null) {
            System.out.println("\tSublista de " + actual.getUsuario() + ":");
            Nodo sublista = actual.getSubLista();
            while (sublista != null) {
                System.out.println("\t\tCargo: " + sublista.getCargo() + ", Usuario: " + sublista.getUsuario() + ", Tag: " + sublista.getTag());
                sublista = sublista.getLiga();
            }
        }
        actual = actual.getLiga();
    }
}

}
