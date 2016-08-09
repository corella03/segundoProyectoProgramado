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
    public boolean  menu () {
        try{
            //Variables del metodo
      int opciones=0;
      int desicion=0;
      int x = 0;
      int y=0;
        while(opciones!=1){
         opciones = Integer.parseInt(JOptionPane.showInputDialog("Menu \n1Jugar \n2.Salir"));

            if(opciones>=3){
                JOptionPane.showMessageDialog(null, "Dato invalido");
            }
            if(opciones==2){
                break;
            }
        }
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
            /*System.out.println("");
            System.out.println("-------------------***----------------------");
            System.out.println("");
            tb.imprimirTablero2();*/
            while(true){
                //desicion = Integer.parseInt(JOptionPane.showInputDialog("Acciones \n1.Elegir \n2.Colocar Bandera \n3.Quitar Bandera"));
                while (desicion!=1&&desicion!=2&&desicion!=3){
                    desicion = Integer.parseInt(JOptionPane.showInputDialog("Acciones \n1.Elegir \n2.Colocar Bandera \n3.Quitar Bandera"));  
                  if(desicion>4){
                        JOptionPane.showMessageDialog(null, "Dato invalido");    
                    }
                
                }
                 x= Integer.parseInt(JOptionPane.showInputDialog("ingrese la fila"));
               /* while(x!=tb.imprimirTablero()){  
                    
                    if(x>tb.imprimirTablero()){
                        JOptionPane.showMessageDialog(null, "fila no admita");
                    }
                }*/
                   y= Integer.parseInt(JOptionPane.showInputDialog("ingrese la columna")); 
                /*while(x>tb.imprimirTablero()){  
                    y= Integer.parseInt(JOptionPane.showInputDialog("ingrese la columna"));
                    if(x>tb.imprimirTablero()){
                        JOptionPane.showMessageDialog(null, "fila no admita");
                    }
                }*/
                    
                if (desicion==2){
                    tb.ponerBandera(x, y);
                }
                if ( desicion==3){
                    tb.quitarBandera(x, y);
                }
                if (desicion==1){
                    int dec=tb.elegirCasilla(x, y);
                    
                    if(dec==1){return false;}
                    if(dec==2){return true;}               
                }                  
                System.out.println("");
                System.out.println("-------------------***----------------------");
                System.out.println("");
                int deci=tb.imprimirTablero();
                if(deci==1){return false;}
                if(deci==2){return true;}
                /*System.out.println("");
                System.out.println("-------------------***----------------------");
                System.out.println("");
                tb.imprimirTablero2();*/
            }
                 
        } 
        
        
        }catch(Exception e){
        }
        return false;
    }
}