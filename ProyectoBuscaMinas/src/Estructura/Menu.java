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
    //Variables de la Clase
    public int ganados=0;
    public int perdidos=0;
    public int totales=0;
    // Constructor Vacío
    public Menu() {
    }
    /**
     *Método Set pata variable "ganados"
     * @param ganados
     */
    public void setGanados(int ganados) {
        this.ganados = ganados;
    }
    /**
     *Método Set pata variable "perdidos"
     * @param perdidos
     */
    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }
    /**
     *Método Set pata variable "totales"
     * @param totales
     */
    public void setTotales(int totales) {
        this.totales = totales;
    }
    /**
     *Método Get pata variable "ganados"
     * @return int ganados
     */
    public int getGanados() {
        return ganados;
    }
    /**
     *Método Get pata variable "perdidos"
     * @return int perdidos
     */
    public int getPerdidos() {
        return perdidos;
    }
    /**
     *Método Get pata variable "totales"
     * @return
     */
    public int getTotales() {
        return totales;
    }
    /**
     *Métodos menu
     * @return
     */
    public boolean menu() {
        boolean varGlobal = true;
        while (varGlobal == true) {
            try {
                //Variables del metodo
                int opciones = 0;
                int desicion = 0;
                int x = 0;
                int y = 0;
                while (opciones != 1) {//Opciones del primer enunciado y si es diferente a los parámetros muestra mensaje 
                    opciones = Integer.parseInt(JOptionPane.showInputDialog("Menu \n1Jugar \n2.Salir"));
                    if (opciones >= 3) {
                        JOptionPane.showMessageDialog(null, "Dato inválido");
                    }
                    if (opciones == 2) {
                        break;
                    }
                }
                switch (opciones) {
                    case 1: {//Introducción al juego
                        System.out.println("================================");
                        System.out.println("         JUEGO BUSCA MINA       ");
                        System.out.println("================================");
                        System.out.println("             EXITOS             ");
                        System.out.println("================================");
                        System.out.println("A jugar ¯\\_(ツ)_/¯");
                        Logica tb = new Logica();
                        int[][] tablero = tb.crearTablero();;//pide el tamañao del tablero y crea una matriz cuadrada con 0s del tamaño seleccionado
                        tb.llenarMinas();
                        tb.imprimirTablero();
//                        System.out.println("");
//                        System.out.println("-------------------***----------------------");
//                        System.out.println("");
//                        tb.imprimirTablero2();
                        while (true) {//Verifica que este entre los parámetros 
                            boolean veriLetraMenu2 = true;
                            while (veriLetraMenu2 == true) {
                                try {
                                    while (desicion != 1 && desicion != 2 && desicion != 3) {
                                        desicion = Integer.parseInt(JOptionPane.showInputDialog("Acciones \n1.Elegir \n2.Colocar Bandera \n3.Quitar Bandera"));
                                        if (desicion >= 4) {
                                            JOptionPane.showMessageDialog(null, "Dato inválido");
                                        }
                                    }
                                    boolean veriTam = true;
                                    while (veriTam == true) {
                                        x = Integer.parseInt(JOptionPane.showInputDialog("ingrese la fila"));
                                        y = Integer.parseInt(JOptionPane.showInputDialog("ingrese la columna"));
                                        if ((x > tb.tablero.length) || (y > tb.tablero.length)) {
                                            JOptionPane.showMessageDialog(null, "Coordenadas invalidas");
                                        } else {
                                            veriTam = false;
                                        }
                                    }
                                    if (desicion == 2) {
                                        tb.ponerBandera(x, y);
                                    }
                                    if (desicion == 3) {
                                        tb.quitarBandera(x, y);
                                    }
                                    if (desicion == 1) {
                                        int dec = tb.elegirCasilla(x, y);
                                        if (dec == 1) {                                           
                                            this.totales+=1;
                                            this.perdidos+=1;
                                            JOptionPane.showMessageDialog(null, "Juegos: "+this.totales+" ganados: "+this.ganados+" Perdidos: "+this.perdidos);                                        
                                            return false;
                                        }
                                        if (dec == 2) {
                                            this.totales+=1;
                                            this.perdidos+=1;
                                            JOptionPane.showMessageDialog(null, "Juegos: "+this.totales+" ganados: "+this.ganados+" Perdidos: "+this.perdidos);                                       
                                            return true;
                                        }
                                    }
                                    System.out.println("");
                                    System.out.println("-------------------***----------------------");
                                    System.out.println("");
                                    int deci = tb.imprimirTablero();
                                    if (deci == 1) {
                                        this.totales+=1;
                                        this.ganados+=1;
                                        JOptionPane.showMessageDialog(null, "Juegos: "+this.totales+" ganados: "+this.ganados+" Perdidos"+this.perdidos);
                                        return false;
                                    }
                                    if (deci == 2) {
                                        this.totales+=1;
                                        this.ganados+=1;
                                        JOptionPane.showMessageDialog(null, "Juegos: "+this.totales+" ganados: "+this.ganados+" Perdidos"+this.perdidos);                                       
                                        return true;//
                                    }
//                                    System.out.println("");
//                                    System.out.println("-------------------***----------------------");
//                                    System.out.println("");
//                                    tb.imprimirTablero2();
                                    desicion = 0;
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Dato inválido");
                                    int resulMenu2 = JOptionPane.showConfirmDialog(null, "Ingrese un dato que esté estre los parametros", "Error", JOptionPane.OK_CANCEL_OPTION);
                                    if (resulMenu2 == JOptionPane.OK_OPTION) {
                                        veriLetraMenu2 = false;
                                    }
                                    if (resulMenu2 == JOptionPane.OK_OPTION) {
                                        veriLetraMenu2 = false;
                                    }
                                    if (resulMenu2 == JOptionPane.OK_OPTION) {
                                        veriLetraMenu2 = true;
                                    }
                                }
                            }
                        }
                    }
                    case 2: {
                        varGlobal = false;
                    }
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingresaste un dato  inválido o cancelaste");
                int resultado = JOptionPane.showConfirmDialog(null, " Deseas volver a jugar", "Error", JOptionPane.OK_CANCEL_OPTION);
                if (resultado == JOptionPane.CLOSED_OPTION) {
                    varGlobal = false;
                }
                if (resultado == JOptionPane.CANCEL_OPTION) {
                    varGlobal = false;
                }
                if (resultado == JOptionPane.OK_OPTION) {
                    varGlobal = true;
                }
                
            }          
        }    
        return false;
    }
}