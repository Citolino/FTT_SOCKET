/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Utilitarios.Impressoras;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ThreadImpressora2  extends Thread {

    @Override
    public void run() {
       
        while(Impressoras.getInstance().GetImprime() || Impressoras.getInstance().GetMsgImpressora(2).size() > 0){
            for(int x = 0 ; x < Impressoras.getInstance().GetMsgImpressora(2).size();x++){
                System.out.println( "Imprimindo na impressora 2 :" + Impressoras.getInstance().GetMsgImpressora(2).get(x));
                  Impressoras.getInstance().GetMsgImpressora(2).remove(x);
            }
              try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadImpressora5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
