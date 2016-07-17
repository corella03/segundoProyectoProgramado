/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Importes
package buscaminas;
/**
 *
 * @author Luis Alonso
 * @author Lissa Elena astro Barquero
 * @date 2016-07-10 Domingo
 **/
public class Tablero {
    private String tablero [][];
    private int minas [][];
    private boolean elegidos [][];
    private int filas = 3;
    private int columnas = 5;
    //
    public Tablero(String[][] tablero, int[][] minas, boolean[][] elegidos) {
        this.tablero = tablero;
        this.minas = minas;
        this.elegidos = elegidos;
    }
    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }
    public void setMinas(int[][] minas) {
        this.minas = minas;
    }
    public void setElegidos(boolean[][] elegidos) {
        this.elegidos = elegidos;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public String[][] getTablero() {
        return tablero;
    }
    public int[][] getMinas() {
        return minas;
    }
    public boolean[][] getElegidos() {
        return elegidos;
    }
    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }  
}