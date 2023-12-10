/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

/**
 *
 * @author Usuario
 */
public class Lista {
    int tam =100;
    Lista listaAdmins;
    Lista listaProfesores;
    Lista listaInvitados;
    private static final String RUTA_ARCHIVO = "usuarios.txt";
    private static final String RUTA_ARCHIVO_MATRICULAS = "Matriculas.txt";    
    public void abrirarchivo(){
        listaAdmins=new Lista();
        listaProfesores=new Lista();
        listaInvitados=new Lista();
    }
}