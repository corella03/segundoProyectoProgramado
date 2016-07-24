/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;
//Importes
import javax.swing.JOptionPane;
/**
 *
 * @author Luis Alonso
 * @author Lissa Elena Castro Barquero
 * @date 2016-07-10 Domingo
 **/
public class Juego {
    int opciones;

    public Juego(int opciones) {
        this.opciones = opciones;
    }

    Juego() {
    }
    
    /**
     *
     */
    public void  menu () {
    Object obj= JOptionPane.showInputDialog("Menu \n1Jugar \n2.Salir");
    if(obj==null)
        return;
    if(obj.toString().equals("")){
        JOptionPane.showMessageDialog(null, "Sea bruto");
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
            Tablero tb = new Tablero(); 

        break;
        case 2:      
        break;
    } }
 //  } while (opciones!=2);
      } 
     //   public void Jugar(){ 
    //}
}