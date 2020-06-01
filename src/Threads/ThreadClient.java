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

/**
 *
 * @author Usuario
 */
public class ThreadClient extends Thread {

    private Socket client;

    public ThreadClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println("Cliente conectado: " + client.getInetAddress().getHostAddress());
        Impressoras.getInstance().InserirClientes(client);
        try ( InputStream stream = client.getInputStream()) {
            boolean ativo = true;
            while (client.isConnected()) {
                if (stream.available() != 0) {
                    byte[] dados = new byte[stream.available()];
                    stream.read(dados);
                    if (!new String(dados).equals("sair")) {
                        Impressoras.getInstance().InserirMsgImpressora(new String(dados));
                    } else {
                        client.close();
                    }

                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
