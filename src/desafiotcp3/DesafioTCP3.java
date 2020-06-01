/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiotcp3;

import Threads.ThreadClient;
import Threads.ThreadControladora;
import Threads.ThreadImpressora1;
import Threads.ThreadImpressora2;
import Threads.ThreadImpressora3;
import Threads.ThreadImpressora4;
import Threads.ThreadImpressora5;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class DesafioTCP3 {

   private static ServerSocket server;
    private static int port = 6969;
     public void StartsThread(){
   
    
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException{
        server = new ServerSocket(port);
        
      ThreadControladora controladora = new ThreadControladora();
      controladora.start();
        while(true){
            Socket socket = server.accept();
            ThreadClient client = new ThreadClient(socket);
            client.start();
        }
    }
   
}
