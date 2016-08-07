/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Paquete
package Estructura;
//Importes
import javax.swing.JOptionPane;
/**
 **
 ** @author Luis Alonso & Lissa Elena Castro Barquero
 ** @date 2016-07-10 Domingo
 **/
public class Menu {
    public void  menu () {
        try{
      int opciones;
      int desicion;
      int x;
      int y;
    opciones = Integer.parseInt(JOptionPane.showInputDialog("Menu \n1Jugar \n2.Salir"));
    switch(opciones){
        case 1:
            System.out.println("================================");
            System.out.println("         JUEGO BUSCA MINA       ");
            System.out.println("================================");
            System.out.println("             EXITOS             ");
            System.out.println("================================"); 
            System.out.println("A jugar ¯\\_(ツ)_/¯");           
            Logica tb = new Logica();
            int[][] tablero=tb.crearTablero();;//pide el tamañao del tablero y crea una matriz cuadrada con 0s del tamaño seleccionado
           
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
}