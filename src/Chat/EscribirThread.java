/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class EscribirThread extends Thread {

    private ColaMensajes cola;
    private ArrayList<ClienteThread> clientes;

    public EscribirThread(ColaMensajes cola, ArrayList<ClienteThread> clientes) {
        this.cola = cola;
        this.clientes = clientes;
    }    
    
    @Override
    public void run(){
        
        System.out.println("inicio ecribir");
        while(true){       
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(EscribirThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!cola.estaVacio()) {
                try {
                    for (ClienteThread cliente : clientes) {    
                        System.out.println(cliente.getName());
                        ObjectOutputStream salida = new ObjectOutputStream(cliente.getSocket().getOutputStream());                    
                        salida.writeObject(cola.getMensaje());
                        salida.flush();
                    }                                        
                    cola.popCola();                    
                } catch (IOException ex) {
                    Logger.getLogger(EscribirThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
