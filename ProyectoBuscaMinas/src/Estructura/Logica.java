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
    //Variables de la clase
    private int tamaño;
    int[][] tablero;
    int[][] respaldoTablero;
    int contadorBanderas=0;
    //Constructor Vacío
    Logica() {
    }
    //Constructor Lleno
    public Logica(int tamaño, int[][] tablero, int[][] Respaldotablero) {
        this.tamaño = tamaño;
        this.tablero = tablero;
        this.respaldoTablero = Respaldotablero;
    }
    /**
     *Método Set pata variable "tamaño"
     * @param tamaño
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    /**
     *Método Set pata variable "tablero"
     * @param tablero
     */
    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
    /**
     *Método Set pata variable "respaldoTablero"
     * @param respaldoTablero
     */
    public void setRespaldoTablero(int[][] respaldoTablero) {
        this.respaldoTablero = respaldoTablero;
    }
    /**
     *Método Set pata variable "contador Bandera"
     * @param contadorBanderas
     */
    public void setContadorBanderas(int contadorBanderas) {
        this.contadorBanderas = contadorBanderas;
    }
    /**
     *Método Get pata variable "tamaño"
     * @return int tamaño
     */
    public int getTamaño() {
        return tamaño;
    }
    /**
     *Método Get pata variable "tablero"
     * @return int [][] tablero
     */
    public int[][] getTablero() {
        return tablero;
    }
    /**
     *Método Get pata variable "respaldoTablero"
     * @return int [][] respaldoTablero
     */
    public int[][] getRespaldotablero() {
        return respaldoTablero;
    }
    /**
     *Método Get pata variable "contadorBanderas"
     * @return int contadorBanderas 
     */
    public int getContadorBanderas() {
        return contadorBanderas;
    }
    /**
     * Método para crear el tablero
     * @return
     */
    public int[][] crearTablero(){
         tamaño=0;
         while(tamaño<4||tamaño>25){
            tamaño=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamanno del tablero")); 
            if(tamaño<4||tamaño>25){//indica los parámetros del tablero
                JOptionPane.showMessageDialog(null, "minimo 4x4 y maximo 25x25");//Rango del Tablero
            }
         }
         tablero = new int[tamaño][tamaño];
         for (int i = 0; i < tablero.length ; i++) {//EL .length es para recorrer el Tablero casilla por casilla
            for (int j = 0; j < tablero.length; j++){
                tablero [i][j] = 0;
            }
        }
        return tablero;//retorna el tablero con el tamaño que el usuario ingreso
    }  
    /**
     *Método en el cual se se determina cuando el usuario gana
     * @return
     */
    public boolean verificarGanador(){
        for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                if(respaldoTablero[i][j]==1 && tablero[i][j]!=2){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     *Método en el cual se imprime el tablero 
     * @return
     */
    public int imprimirTablero(){
        if(verificarGanador()){
            int result=JOptionPane.showConfirmDialog(null, "Felicidades as Ganado, Deseas volver a jugar", "Victoria",JOptionPane.OK_CANCEL_OPTION);
            if(result==JOptionPane.CLOSED_OPTION){
                return 1;
            }
            if(result==JOptionPane.CANCEL_OPTION){
                return 1;
            }
            if(result==JOptionPane.OK_OPTION){
                return 2;
            }       
        }       
        for (int _j = 0; _j < tablero.length; _j++){//Muestra las coordenadas de las columnas por medio de números
            if(_j>9){
                System.out.print(_j+" ");//Antes del 9 lleva un espacio junto al número
            }
            else{
                System.out.print(" "+_j+" ");//Apartir del 10 el número no lleva espacios
            }           
        }
        System.out.println("");
         for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                if(tablero[i][j]==0 || tablero[i][j]==1){
                    System.out.print("[ ]");
                } 
                else if(tablero[i][j]==2){//Opcion 2 muestra bandera con el simbolo "!"
                    System.out.print("[!]");
                }
                else if(tablero[i][j]==3){//Los espacios en blanco en el tablero se representan con un "0"
                    System.out.print("[0]");
                }               
                else if(tablero[i][j]==4){
                    System.out.print("["+cantidadDeMinasAlrededor(i, j)+"]");//Nos muestra el numero de minas que  hay alrrededor de una casilla
                }
            }
           System.out.println(" "+i+"  ");//Muestra las coordenadas de las filas por medio de números 
        }         
        return 0;
    }   
    /**
     *Este Método es para imprimir el Tablero solo con las minas destapadas
     */
    public void imprimirTablero2(){
         for (int i = 0; i < respaldoTablero.length ; i++) {
            for (int j = 0; j < respaldoTablero.length; j++){
                if(respaldoTablero[i][j]==1){
                    System.out.print("[*]");//Minas se representa con un "*"
                }
                else
                    System.out.print("[ ]");
            }
           System.out.println("");
        }
    }
    /**
     *Método Para Llenar el Tablero con minas de manera  Random 
     */
    public void llenarMinas(){
        ArrayList<Integer> miLista = new ArrayList<>();//La función de esta lista es para que no se coloquen minas encima de otras
        int y;//Filas 
        int x;//Columnas        
        Random rand=new Random(); 
        while(miLista.size()<tablero.length*2){//Mientras las minas agragadas sean menor a las necesitadas
           y=rand.nextInt(((tablero.length-1) - 0) + 1) + 0;
           x=rand.nextInt(((tablero.length-1) - 0) + 1) + 0;
           if(tablero[x][y]!=1){//Si ese X y Y ya no fueron agregados
              tablero[x][y]=1;
              miLista.add(1);//Añade la mina a la lista
           }
        }
        respaldoTablero=new int[tamaño][tamaño];         
        for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                respaldoTablero[i][j]=tablero[i][j];
            }
        }
    } 
    /**
     *Método para colocar Banderas
     * @param x
     * @param y
     */
    public void ponerBandera(int x,int y){
          if(contadorBanderas>=tablero.length*2){//La cantidad de banderas es igual a las minas
            JOptionPane.showMessageDialog(null, "te quedaste sin banderas--> debes cambiar de decisiones");
            return;
          }
          if(tablero[x][y]==2){//Si ya se coloco Bandera no se puede colocar otra encima de ella 
              JOptionPane.showMessageDialog(null, "No se puede poner una bandera sobre otra");
              return;
          }
          contadorBanderas+=1;
          tablero[x][y]=2;
    }
    /**
     *Método para Quitar Banderas
     * @param x
     * @param y
     */
    public void quitarBandera(int x,int y){
          if(tablero[x][y]==2){//Si casilla tiene  bandera
              contadorBanderas-=1;//Se elimina la bandera
              tablero[x][y]=respaldoTablero[x][y];//Si no hay bandera no se puede quiitar nada y envia mensaje
              return;
          }
          JOptionPane.showMessageDialog(null, "No se puede quitar una bandera sobre algo que no sea bandera");
    }
    /**
     *Método para elegir las diferentes opciones que tiene la casillas
     * @param x
     * @param y
     * @return
     */
    public int elegirCasilla(int x, int y){
        int casilla=tablero[x][y];
        if(casilla==0){
            abrirCasillas(x,y);
        }
        if(casilla==1){//Si pisa Mina Pierde
            JOptionPane.showMessageDialog(null, "Has Perdido", "Derrota", JOptionPane.ERROR_MESSAGE);
            System.out.println("");
            System.out.println("");
            System.out.println("------------Mapa de Minas-----------");
            System.out.println("");
            System.out.println("");
            this.imprimirTablero2();//Tablero con solo minas descubiertas
            //Cuando pierda muestra este mensaje  para decidir si juega de nuevo o no
            int result=JOptionPane.showConfirmDialog(null, "Deseas volver a jugar", "",JOptionPane.OK_CANCEL_OPTION);
            if(result==JOptionPane.CLOSED_OPTION){
                return 1;
            }
            if(result==JOptionPane.CANCEL_OPTION){
                return 1;
            }
            if(result==JOptionPane.OK_OPTION){
                return 2;
            }
        }
        if(casilla==2){//Si se elige una casilla que tenga bandera
            JOptionPane.showMessageDialog(null, "Acabas de activar una bandera esta acción no hace nada si quieres quitar una bandera porfavor elige la opcion quitar bandera");
        }
        if(casilla==3){
            JOptionPane.showMessageDialog(null, "Esta casilla ya se habia abierto anteriormente");
        }
        return 0;
    }
    /**
     *Método para abrir casillas
     * @param x
     * @param y
     */
    public void abrirCasillas(int x,int y){
        ArrayList<Integer> colaPendiende = new ArrayList<>();//Lista para definir hasta donde se expande
        colaPendiende.add(x);//Visita vecinos y vicita los vecinos de los vecinos  hasta que toda el area alrredor tope con alguien topa con una mina
        colaPendiende.add(y); 
        while(colaPendiende.size() > 0 )
        {
            int _x=colaPendiende.remove(0);//En java el _ no significa nada, se usa normalmente para decir que pertenece al contexto actual y no al global
            int _y=colaPendiende.remove(0);
            int CantidadMinas=cantidadDeMinasAlrededor(_x,_y);     
            if(CantidadMinas==0){
               tablero[_x][_y]=3;
               ArrayList<Integer> _vecinos=vecinos(_x,_y);
               for(int i=0;i<_vecinos.size();i=i+2){
                   int nX=_vecinos.get(i);
                   int nY=_vecinos.get(i+1);
                   if(tablero[nX][nY]==0){
                        colaPendiende.add(nX);
                        colaPendiende.add(nY);
                   }
               }
            }
            else{
                 tablero[_x][_y]=4;
            }
        }    
    }  
    /**
     *Arreglode lista para expandir cuando casilla esta en 0 "espacios en blando"
     * @param x
     * @param y
     * @return Devuelve una lista con los X y Y de los vecinos
     */
    public ArrayList<Integer> vecinos(int x, int y){
        ArrayList<Integer> vecinos = new ArrayList<>();
         //SE moviliza casilla por casilla
        if(x==0){
            if(y!=tablero.length-1){
                vecinos.add(x+1);
                vecinos.add(y+1);
                vecinos.add(x);
                vecinos.add(y+1);
            }
            if(y!=0){
                vecinos.add(x+1);
                vecinos.add(y-1);
                vecinos.add(x);
                vecinos.add(y-1);
            }
            vecinos.add(x+1);
            vecinos.add(y);
        }
        else if(y==tablero.length-1){
            if(x!=tablero.length-1){
                vecinos.add(x+1);
                vecinos.add(y);
                vecinos.add(x+1);
                vecinos.add(y-1);
            }
            if(x!=0){
                vecinos.add(x-1);
                vecinos.add(y-1);
                vecinos.add(x-1);
                vecinos.add(y);
            }
            vecinos.add(x);
            vecinos.add(y-1);
        }
        else if(y==0){
            if(x!=respaldoTablero.length-1){
                vecinos.add(x+1);
                vecinos.add(y);
                //
                vecinos.add(x+1);
                vecinos.add(y+1);
            }
            if (x!=0){
                vecinos.add(x-1);
                vecinos.add(y+1);
                //
                vecinos.add(x-1);
                vecinos.add(y);
            }
            vecinos.add(x);
            vecinos.add(y+1);
        }
        else if(x==tablero.length-1){
            vecinos.add(x);
            vecinos.add(y+1);
            //
            vecinos.add(x-1);
            vecinos.add(y);
            // 
            vecinos.add(x);
            vecinos.add(y-1);
            //
            vecinos.add(x-1);
            vecinos.add(y-1);
            //
            vecinos.add(x-1);
            vecinos.add(y+1);
        }  
        else {
            vecinos.add(x+1);
            vecinos.add(y);
            //
            vecinos.add(x);
            vecinos.add(y+1);
            //
            vecinos.add(x-1);
            vecinos.add(y);
            //
            vecinos.add(x);
            vecinos.add(y-1);
            //
            vecinos.add(x-1);
            vecinos.add(y-1);
            //
            vecinos.add(x+1);
            vecinos.add(y+1);
            //
            vecinos.add(x+1);
            vecinos.add(y-1);
            //
            vecinos.add(x-1);
            vecinos.add(y+1);
        }
        return vecinos;
    } 
    /**
     *Método para saber con cuantas minas toca una casilla
     * @param x
     * @param y
     * @return cantidad de minas alrededor
     */
    public int cantidadDeMinasAlrededor(int x, int y){
        int casilla=respaldoTablero[x][y];
        int cantidadDeMinas=0;
        //Define la cantida de minas que hay alrededor de una casilla
        if(x==0){
            if(y!=respaldoTablero.length-1){
                if(respaldoTablero[x+1][y+1]==1){cantidadDeMinas+=1;}
                if(respaldoTablero[x][y+1]==1){cantidadDeMinas+=1;}
            }
            if(respaldoTablero[x+1][y]==1){cantidadDeMinas+=1;}
            if(y!=0){
                if(respaldoTablero[x][y-1]==1){cantidadDeMinas+=1;}
                if(respaldoTablero[x+1][y-1]==1){cantidadDeMinas+=1;}
            }
            return cantidadDeMinas;
        }
        if(y==respaldoTablero.length-1){            
            if(x!=respaldoTablero.length-1){
                if(respaldoTablero[x+1][y]==1){cantidadDeMinas+=1;}
                if(respaldoTablero[x+1][y-1]==1){cantidadDeMinas+=1;}
            }
            if(x!=0){
                if(respaldoTablero[x-1][y]==1){cantidadDeMinas+=1;}
                if(respaldoTablero[x-1][y-1]==1){cantidadDeMinas+=1;}
            }
            if(respaldoTablero[x][y-1]==1){cantidadDeMinas+=1;}
            return cantidadDeMinas;
        }
        if(y==0){
            if(x!=respaldoTablero.length-1){
                if(respaldoTablero[x+1][y]==1){cantidadDeMinas+=1;}
                if(respaldoTablero[x+1][y+1]==1){cantidadDeMinas+=1;} 
            }
            if (x!=0){
              if(respaldoTablero[x-1][y+1]==1){cantidadDeMinas+=1;} 
              if(respaldoTablero[x-1][y]==1){cantidadDeMinas+=1;}
            } 
            if(respaldoTablero[x][y+1]==1){cantidadDeMinas+=1;}
            return cantidadDeMinas;
        }
        if(x==respaldoTablero.length-1){
            if(respaldoTablero[x][y+1]==1){cantidadDeMinas+=1;}
            if(respaldoTablero[x-1][y]==1){cantidadDeMinas+=1;}
            if(respaldoTablero[x][y-1]==1){cantidadDeMinas+=1;}
            if(respaldoTablero[x-1][y-1]==1){cantidadDeMinas+=1;} 
            if(respaldoTablero[x-1][y+1]==1){cantidadDeMinas+=1;}
            return cantidadDeMinas;
        }       
        if(respaldoTablero[x+1][y]==1){cantidadDeMinas+=1;}
        if(respaldoTablero[x][y+1]==1){cantidadDeMinas+=1;}
        if(respaldoTablero[x-1][y]==1){cantidadDeMinas+=1;}
        if(respaldoTablero[x][y-1]==1){cantidadDeMinas+=1;}
        if(respaldoTablero[x-1][y-1]==1){cantidadDeMinas+=1;}
        if(respaldoTablero[x+1][y+1]==1){cantidadDeMinas+=1;}
        if(respaldoTablero[x+1][y-1]==1){cantidadDeMinas+=1;}
        if(respaldoTablero[x-1][y+1]==1){cantidadDeMinas+=1;}
        return cantidadDeMinas;
    }
    /**
     *Método toString para que imprime (en este caso no se usa se coloca por convención)
     * @return
     */
    @Override
    public String toString() {
        return "";
    }   
}