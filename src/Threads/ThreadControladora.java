/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Utilitarios.Impressoras;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ThreadControladora extends Thread {

    @Override
    public void run() {
        System.out.println("BEM VINDO AO SERVIDOR DE IMPRESSÃO, DIGIRTE '0' A QUALQUER MOMENTO PARA PARAR O SERVIDOR!");
        Scanner scan = new Scanner(System.in);

        ThreadImpressora1 impressora1 = new ThreadImpressora1();
        ThreadImpressora2 impressora2 = new ThreadImpressora2();
        ThreadImpressora3 impressora3 = new ThreadImpressora3();
        ThreadImpressora4 impressora4 = new ThreadImpressora4();
        ThreadImpressora5 impressora5 = new ThreadImpressora5();

        impressora1.start();
        impressora2.start();
        impressora3.start();
        impressora4.start();
        impressora5.start();
        while (!scan.nextLine().equals("0")) {

        }
        System.out.println("PARANDO O SERVIDOR DE IMPRESSÃO AGUARDE ...");
       
        try {
            Impressoras.getInstance().PararImpressão();
            impressora1.join();
            impressora2.join();
            impressora3.join();
            impressora4.join();
            impressora5.join();
            
            Thread.sleep(5000);
             System.out.println("SERVIDOR ENCERRADO! PODE ENCERRAR O PROGRAMA, REINICIE PARA UTILAR NOVAMENTE");
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadControladora.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(ThreadControladora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
