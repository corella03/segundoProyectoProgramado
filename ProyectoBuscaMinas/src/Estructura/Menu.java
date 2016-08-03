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
        int opciones;
    Object obj= JOptionPane.showInputDialog("Menu \n1Jugar \n2.Salir");//porque no se sabe que devuelve el JOption
    if(obj==null)
        return;
    if(obj.toString().equals("")){
        JOptionPane.showMessageDialog(null, "No ingresaste ningun digito");
        menu();}
    else{
    opciones=Integer.parseInt((String) obj);
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
            tb.llenarMinas();
            tb.imprimirTablero();           
            //System.out.println(tablero[0][0]);    
        //break;

        } 
    }
    }
}
