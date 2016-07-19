/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;
//Importes
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author Luis Alonso
 * @author Lissa Elena Castro Barquero
 * @date 2016-07-10 Domingo
 **/
public class Tablero {
    private int minas [][];
    private boolean elegidos [][];
    private final int filas ;
    private final int columnas;
    /**
     *Metodo para crear el tablero
     */
     public int tablero [][] = new int[0][0]; {
         filas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de Filas"));
         columnas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de columnas"));  
        for (int i = 0; i < filas; i++) {
            for (int j = 1; j < columnas; j++) {
                System.out.print("[ ]");
            }
            System.out.println("[ ]");
               int matriz[][] = new int[0][0];
		int r=0;		
		Random rnd= new Random();{		
		for (int o=0; i < 0; i++){
		{
			for (int j=0; j < 0; j++)
				matriz[i][j] = rnd.nextInt(25)+1;			
		}
        }
        }
        }
}    
}