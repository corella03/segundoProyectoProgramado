/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Paquete
package proyectobuscaminas;
/**
 **
 ** @author Luis Alonso & Lissa Elena Castro Barquero
 ** @date 2016-07-10 Domingo
 **/
public class ProyectoBuscaMinas {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Instancia del paquete Estructura y la clase Menu
      Estructura.Menu m= new Estructura.Menu();
      //Llamada al método del paquete Estructura y la clase Menu
      boolean respuesta=m.menu();//Para que los menus no se llamen dentro de si mismos y se pueda cancelar una otra y vez
      if(respuesta){
        m.menu();
      }
    } //Fin del main [] 
}//Fin de la CLase()