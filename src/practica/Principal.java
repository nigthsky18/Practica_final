/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica;

/**
 *
 * @author Mariana M
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Iniciosesion inicio =new Iniciosesion();
       inicio.setVisible(true);
        lista metodos = new lista();
        metodos.abrirarchivo("src/practica/usuarios.txt");
        metodos.mostrarListas();}
    
}
