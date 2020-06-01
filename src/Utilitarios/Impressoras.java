/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Impressoras {

    private static Impressoras uniqueInstance;

    private static List<String> Impressora1 = Collections.synchronizedList(new ArrayList<>());
    ;
    private static List<String> Impressora2 = Collections.synchronizedList(new ArrayList<>());
    ;
    private static List<String> Impressora3 = Collections.synchronizedList(new ArrayList<>());
    ;
    private static List<String> Impressora4 = Collections.synchronizedList(new ArrayList<>());
    ;
    private static List<String> Impressora5 = Collections.synchronizedList(new ArrayList<>());
    ;
    
     private static List<Socket> Clients = Collections.synchronizedList(new ArrayList<>());
    
    private static boolean Imprime = true;

    private Impressoras() {

    }

    public static synchronized Impressoras getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Impressoras();
        }
        return uniqueInstance;
    }

    public void InserirMsgImpressora(String MSG) {
        int[] quantidades = {Impressora1.size(), Impressora2.size(), Impressora3.size(), Impressora4.size(), Impressora5.size()};
        int menor = 0;
        int impressora = 0;
        for (int x = 0; x < 5; x++) {
            if (quantidades[x] <= menor) {
                menor = quantidades[x];
                impressora = x;
            }
        }
        if (impressora == 0) {
            Impressora1.add(MSG);
        } else if (impressora == 1) {
            Impressora2.add(MSG);
        } else if (impressora == 2) {
            Impressora3.add(MSG);
        } else if (impressora == 3) {
            Impressora4.add(MSG);
        } else {
             Impressora5.add(MSG);
        }

    }

    public void PararImpressão() throws IOException {
        Imprime = false;
        for(Socket x : Clients){
        x.close();
        }

    }

    public boolean GetImprime() {
        return Imprime;
    }

    public List<String> GetMsgImpressora(int impressora) {
        if (impressora == 1) {
            return Impressora1;
        } else if (impressora == 2) {
            return Impressora2;
        } else if (impressora == 3) {
            return Impressora3;
        } else if (impressora == 4) {
            return Impressora4;
        } else {
            return Impressora5;
        }
    }
    public void InserirClientes(Socket cli) {
        Clients.add(cli);
    }

}
