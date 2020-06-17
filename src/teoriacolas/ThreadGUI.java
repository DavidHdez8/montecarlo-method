package teoriacolas;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadGUI extends Thread{
    Scanner dato = new Scanner(System.in);
    public int n;
    public int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0;
    javax.swing.JTextField txtTotal;
    javax.swing.JTextField txtRetiro;
    javax.swing.JTextField txtConsulta;
    javax.swing.JTextField txtTransferencia;
    javax.swing.JTextField txtOtros;
    
    public ThreadGUI(){
    
    }
    
    public ThreadGUI(int personas){
        //n = Integer.parseInt(txtTotal.getText());
    }
    
    
    @Override
    public void run(){
        n = Integer.parseInt(txtTotal.getText());
        for(int i = 1; i <= n; i++){
            double numero = Math.random();
            System.out.print(i + " ");
            if(numero > 0.1 && numero < 0.25){
                cont1 += 1;
                System.out.println("Transferencia");
            }else if(numero > 0.25 && numero < 0.50){
                cont2 += 1;
                System.out.println("Retiro");
            }else if(numero > 0.51 && numero < 0.75){
                cont3 += 1;
                System.out.println("Consulta");
            }else{
                cont4 += 1;
                System.out.println("Otros");
            }
        }
        
        System.out.println("En total: " + n + " Operaciones creados con threads");
        System.out.println(cont1 + " Operaciones de transferencia");
        System.out.println(cont2 + " Operaciones de Retiro ");
        System.out.println(cont3 + " Operaciones de Consulta");
        System.out.println(cont4 + " Operaciones de Otros");
        txtTransferencia.setText("" + cont1);
        txtRetiro.setText("" + cont2);
        txtConsulta.setText("" + cont3);
        txtOtros.setText("" + cont4);
    }
    
    public void recibeTxtTotal(javax.swing.JTextField txtTotal){
        this.txtTotal = txtTotal;
    }
    
    public void recibeTxtRetiro(javax.swing.JTextField txtRetiro){
        this.txtRetiro = txtRetiro;
    }
    
    public void recibeTxtConsulta(javax.swing.JTextField txtConsulta){
        this.txtConsulta = txtConsulta;
    }
    
    public void recibeTxtTransferencia(javax.swing.JTextField txtTransferencia){
        this.txtTransferencia = txtTransferencia;
    }
    
    public void recibeTxtOtros(javax.swing.JTextField txtOtros){
        this.txtOtros = txtOtros;
    }
    
    public static void main(String args[]){
        Thread h = new ThreadGUI(0);
        h.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}