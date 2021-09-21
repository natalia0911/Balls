/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Natalia
 */
public class Bolita extends Thread {
    
    private JLabel bolita;
    private JPanel pane;
    private int x;
    private int y;
   

    public Bolita(JLabel label,JPanel pane,int x,int y) {
        this.bolita = label;
        this.pane = pane;
        this.x = x;
        this.y = y;
        
    }
    /**
     * Selecciona una direccion a la cual debe ir la pelota, segun la rosa de los vientos
     */
    @Override
    public void run(){
        while(true){
            try {
                Random numAl= new Random();
                int opc = numAl.nextInt(8);
                switch(opc){
                    case 0:
                        norte();
                        break;
                    case 1:
                        sur();
                        break;
                    case 2:
                        oeste();
                        break;
                    case 3:
                        este();
                        break;
                    case 4:
                        diagonalNE();
                        break;
                    case 5:
                        diagonalSE();
                        break; 
                    case 6:
                        diagonalSO();
                        break;
                    case 7:
                        diagonalNO();
                        break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Bolita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    
    /*Estas funciones que generacion movimiento en X y Y, según la direccion*/
    
    public void norte() throws InterruptedException{
        while(y>0){
            y=y-1;
            bolita.setBounds(x,y,100,100);
            sleep(5);
        }
    }
    public void sur() throws InterruptedException{
        while(y<pane.getHeight()-100){
            y=y+1;
            bolita.setBounds(x,y,100,100);
            sleep(5);
        }
    }
    public void oeste() throws InterruptedException{
        while(x>0){
            x=x-1;
            bolita.setBounds(x,y,100,100);
            sleep(5);
        }
    }
    public void este() throws InterruptedException{
        while(x<pane.getWidth()-100){
            x=x+1;
            bolita.setBounds(x,y,100,100);
            sleep(5);
        }
    }
    public void diagonalNE() throws InterruptedException{
        while(y>0 && x<pane.getWidth()-100){
            x=x+1;
            y=y-1;
            bolita.setBounds(x,y,100,100);
            sleep(5);
        }
    }
   
    public void diagonalSE() throws InterruptedException{
        while(y<pane.getHeight()-100 && x<pane.getWidth()-100){
            x=x+1;
            y=y+1;
            bolita.setBounds(x,y,100,100);
            sleep(5);
        }
    }
    public void diagonalSO() throws InterruptedException{
        while(y<pane.getHeight()-100 && x>0){
            x=x-1;
            y=y+1;
            bolita.setBounds(x,y,100,100);
            sleep(5);
        }
    }
    public void diagonalNO() throws InterruptedException{
        while(y>0 && x>0){
            x=x-1;
            y=y-1;
            bolita.setBounds(x,y,100,100);
            sleep(5);
        }
    }
   }

