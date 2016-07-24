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
    private int filas ;
    private int columnas;
    private int x;
    private int y;
    //Constructor Vacío
    Tablero() {//daba error en Tablero tb = new Tablero();
    }
    /**
     *Columnas
     * @param minas
     * @param elegidos
     * @param mostrarTrablero
     */
    public Tablero(int[][] minas, boolean[][] elegidos, int mostrarTrablero) {
        this.minas = minas;
        this.elegidos = elegidos;
        this.mostrarTrablero = mostrarTrablero;
    }
    /**
     *Metodo Set para "minas"
     * @param minas
     */
    public void setMinas(int[][] minas) {
        this.minas = minas;
    }
    /**
     *Metodos Set para "elegidos"
     * @param elegidos
     */
    public void setElegidos(boolean[][] elegidos) {
        this.elegidos = elegidos;
    }

    /**
     *Metodos Set para "filas"
     * @param filas
     */
    public void setFilas(int filas) {
        this.filas = filas;
    }
    /**
     *Metodos Set para "columnas"
     * @param columnas
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        
        this.y = y;
    }
    
    /**
     *Metodos Get para "minas"
     * @return int Minas
     */
    public int[][] getMinas() {
        return minas;
    }
    /**
     *Metodos Get para "Elegidos"
     * @return int elegidos
     */
    public boolean[][] getElegidos() {
        return elegidos;
    }
    /**
     *Metodos Get para "Filas"
     * @return 
     */
    public int getFilas() {
        return filas;
    }
    /**
     *Metodos Get para "Columnas"
     * @return
     */
    public int getColumnas() {
        return columnas;
    }
    public int[][] getTablero() {
        return tablero;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    /**
     *Metodo para crear el tablero
     */
     public int tablero [][] = new int[0][0]; { 
         filas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de Filas"));
         columnas=Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de columnas"));  
        for (int i = 0; i < filas; i++) {
            for (int j = 1; j < columnas; j++) 
            {
                System.out.print("[ ]");
            }
            System.out.println("[ ]");
        }   
    }
     public int mostrarTrablero; {
         
     }
}