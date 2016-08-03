/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Paquete
package Estructura;
//Importes
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 **
 ** @author Luis Alonso & Lissa Elena Castro Barquero
 ** @date 2016-07-10 Domingo
 **/
public class Logica {
    private int minas [][];
    private boolean elegidos [][];
    private int filas ;
    private int columnas;
    private int x;
    private int y;
    private int tamaño;
    int[][] tablero;
    int[][] Respaldotablero;
    //Constructor Vacío

    /**
     * Metodo para crear el tablero
     * @return
     */
    public int[][] crearTablero(){
         tamaño=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamanno del tablero")); 
         tablero = new int[tamaño][tamaño];
         for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                tablero [i][j] = 0;
            }
        }
        return tablero;
    }
    //TODO:-Core, this metod need to be fixed with more variables and control to see how user need 
    //este metodo necesita que se arregle para ques e muestre al usuaria de manera bonita
    public void imprimirTablero(){
         for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                System.out.print(tablero[i][j]);
            }
           System.out.println(" ");
        }
    }
    
    public void llenarMinas(){
        ArrayList<Integer> miLista = new ArrayList<Integer>();
        int y;
        int x;        
        Random rand=new Random();
        
        while(miLista.size()<tablero.length*2){//mientras las minas agragadas sean menor a las necesitadas

           y=rand.nextInt(((tablero.length-1) - 0) + 1) + 0;
           x=rand.nextInt(((tablero.length-1) - 0) + 1) + 0;
           if(tablero[x][y]!=1){//si ese x y y ya no fueron agregados
              tablero[x][y]=1;
              miLista.add(1);
           }
        }
        Respaldotablero=new int[tamaño][tamaño];         
        for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                Respaldotablero[i][j]=tablero[i][j];
            }
        }
    } 
}