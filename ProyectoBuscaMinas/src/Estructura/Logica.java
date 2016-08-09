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
    int[][] Respaldotablero;
    int contadorBanderas=0;
    Logica() {
    }
    public Logica(int tamaño, int[][] tablero, int[][] Respaldotablero) {
        this.tamaño = tamaño;
        this.tablero = tablero;
        this.Respaldotablero = Respaldotablero;
    }
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public void setRespaldotablero(int[][] Respaldotablero) {
        this.Respaldotablero = Respaldotablero;
    }

    public void setContadorBanderas(int contadorBanderas) {
        this.contadorBanderas = contadorBanderas;
    }

    public int getTamaño() {
        return tamaño;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public int[][] getRespaldotablero() {
        return Respaldotablero;
    }

    public int getContadorBanderas() {
        return contadorBanderas;
    }
    
    /**
     * Metodo para crear el tablero
     * @return
     */
    public int[][] crearTablero(){
         tamaño=0;
         while(tamaño<4||tamaño>100){
            tamaño=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamanno del tablero")); 
            if(tamaño<4||tamaño>100){
                JOptionPane.showMessageDialog(null, "minimo 4x4 y maximo 100x100");
            }
         }
         //da error verificar tamaño 

         tablero = new int[tamaño][tamaño];
         for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                tablero [i][j] = 0;
            }
        }
        return tablero;
    }
    
    public boolean verificarGanador(){
        for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                if(Respaldotablero[i][j]==1 && tablero[i][j]!=2){
                    return false;
                }
            }
        }
        return true;
    }
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
        
        for (int _j = 0; _j < tablero.length; _j++){
            System.out.print(" "+_j+" ");
        }
        System.out.println("");
        System.out.println("");
         for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                if(tablero[i][j]==0 || tablero[i][j]==1){
                    System.out.print("[ ]");
                }
                else if(tablero[i][j]==1){
                    System.out.print("[*]");
                }    
                else if(tablero[i][j]==2){
                    System.out.print("[!]");
                }
                else if(tablero[i][j]==3){
                    System.out.print("[0]");
                }               
                else if(tablero[i][j]==4){
                    System.out.print("["+cantidadDeMinasAlrededor(i, j)+"]");
                }
            }
           System.out.println("   "+i+" ");
        }
        return 0;
    }
    
/*    public void imprimirTablero2(){
         for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero.length; j++){
                System.out.print(tablero[i][j]);
            }
           System.out.println("");
        }
    }
*/
    
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
        //Respaldotablero=tablero.clone();
    } 
    public void ponerBandera(int x,int y){
          if(contadorBanderas>=tablero.length*2){
            JOptionPane.showMessageDialog(null, "te quedaste sin banderas--> debes cambiar de decisiones");
            return;
          }
          if(tablero[x][y]==2){
              JOptionPane.showMessageDialog(null, "No se puede poner una bandera sobre otra");
              return;
          }
          contadorBanderas+=1;
          tablero[x][y]=2;
    }
    public void quitarBandera(int x,int y){
          if(tablero[x][y]==2){
              contadorBanderas-=1;
              tablero[x][y]=Respaldotablero[x][y];
              return;
          }
          JOptionPane.showMessageDialog(null, "No se puede quitar una bandera sobre algo que no sea bandera");
    }
    public int elegirCasilla(int x, int y){
        int casilla=tablero[x][y];
        if(casilla==0){
            abrirCasillas(x,y);
        }
        if(casilla==1){
            JOptionPane.showMessageDialog(null, "Perdio Perdedor Perdido");
            int result=JOptionPane.showConfirmDialog(null, "As perdido, Deseas volver a jugar", "Perdedor",JOptionPane.OK_CANCEL_OPTION);
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
        if(casilla==2){
            JOptionPane.showMessageDialog(null, "acabas de activar una bandera esta accion no hace nada si quieres quitar una bandera porfavor elige la opcion quitar bandera");
        }
        if(casilla==3){
            JOptionPane.showMessageDialog(null, "esta casilla ya se habia abierto anteriormente");
        }
        return 0;
    }
    public void abrirCasillas(int x,int y){
        ArrayList<Integer> colaPendiende = new ArrayList<Integer>();
        colaPendiende.add(x);
        colaPendiende.add(y);
        
        while(colaPendiende.size() > 0 )
        {
            int _x=colaPendiende.remove(0);//java no significa nada, se usa normalmente para decir que pertenece al contexto actual y no al global
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
    
    public ArrayList<Integer> vecinos(int x, int y){
        ArrayList<Integer> vecinos = new ArrayList<Integer>();
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
            if(x!=Respaldotablero.length-1){
                vecinos.add(x+1);
                vecinos.add(y);
            
                vecinos.add(x+1);
                vecinos.add(y+1);
            }
            if (x!=0){
                vecinos.add(x-1);
                vecinos.add(y+1);
                
                vecinos.add(x-1);
                vecinos.add(y);
            }
            vecinos.add(x);
            vecinos.add(y+1);
        }
        else if(x==tablero.length-1){
            vecinos.add(x);
            vecinos.add(y+1);

            vecinos.add(x-1);
            vecinos.add(y);

            vecinos.add(x);
            vecinos.add(y-1);

            vecinos.add(x-1);
            vecinos.add(y-1);

            vecinos.add(x-1);
            vecinos.add(y+1);

        }
        
        else {
            vecinos.add(x+1);
            vecinos.add(y);

            vecinos.add(x);
            vecinos.add(y+1);

            vecinos.add(x-1);
            vecinos.add(y);

            vecinos.add(x);
            vecinos.add(y-1);
 
            vecinos.add(x-1);
            vecinos.add(y-1);

            vecinos.add(x+1);
            vecinos.add(y+1);

            vecinos.add(x+1);
            vecinos.add(y-1);

            vecinos.add(x-1);
            vecinos.add(y+1);
        }
        return vecinos;

    }
    
    public int cantidadDeMinasAlrededor(int x, int y){
        int casilla=Respaldotablero[x][y];
        int cantidadDeMinas=0;
        if(x==0){
            if(y!=Respaldotablero.length-1){
                if(Respaldotablero[x+1][y+1]==1){cantidadDeMinas+=1;}
                if(Respaldotablero[x][y+1]==1){cantidadDeMinas+=1;}
            }
            if(Respaldotablero[x+1][y]==1){cantidadDeMinas+=1;}
            if(y!=0){
                if(Respaldotablero[x][y-1]==1){cantidadDeMinas+=1;}
                if(Respaldotablero[x+1][y-1]==1){cantidadDeMinas+=1;}
            }
            return cantidadDeMinas;
        }
        if(y==Respaldotablero.length-1){            
            if(x!=Respaldotablero.length-1){
                if(Respaldotablero[x+1][y]==1){cantidadDeMinas+=1;}
                if(Respaldotablero[x+1][y-1]==1){cantidadDeMinas+=1;}
            }
            if(x!=0){
                if(Respaldotablero[x-1][y]==1){cantidadDeMinas+=1;}
                if(Respaldotablero[x-1][y-1]==1){cantidadDeMinas+=1;}
            }
            if(Respaldotablero[x][y-1]==1){cantidadDeMinas+=1;}
            return cantidadDeMinas;
        }
        if(y==0){
            if(x!=Respaldotablero.length-1){
                if(Respaldotablero[x+1][y]==1){cantidadDeMinas+=1;}
                if(Respaldotablero[x+1][y+1]==1){cantidadDeMinas+=1;} 
            }
            if (x!=0){
              if(Respaldotablero[x-1][y+1]==1){cantidadDeMinas+=1;} 
              if(Respaldotablero[x-1][y]==1){cantidadDeMinas+=1;}
            } 
            if(Respaldotablero[x][y+1]==1){cantidadDeMinas+=1;}
            return cantidadDeMinas;
        }
        if(x==Respaldotablero.length-1){
            if(Respaldotablero[x][y+1]==1){cantidadDeMinas+=1;}
            if(Respaldotablero[x-1][y]==1){cantidadDeMinas+=1;}
            if(Respaldotablero[x][y-1]==1){cantidadDeMinas+=1;}
            if(Respaldotablero[x-1][y-1]==1){cantidadDeMinas+=1;} 
            if(Respaldotablero[x-1][y+1]==1){cantidadDeMinas+=1;}
            return cantidadDeMinas;
        }
        
        if(Respaldotablero[x+1][y]==1){cantidadDeMinas+=1;}
        if(Respaldotablero[x][y+1]==1){cantidadDeMinas+=1;}
        if(Respaldotablero[x-1][y]==1){cantidadDeMinas+=1;}
        if(Respaldotablero[x][y-1]==1){cantidadDeMinas+=1;}
        if(Respaldotablero[x-1][y-1]==1){cantidadDeMinas+=1;}
        if(Respaldotablero[x+1][y+1]==1){cantidadDeMinas+=1;}
        if(Respaldotablero[x+1][y-1]==1){cantidadDeMinas+=1;}
        if(Respaldotablero[x-1][y+1]==1){cantidadDeMinas+=1;}
        return cantidadDeMinas;
    }
    @Override
    public String toString() {
        return "";
    }   
}