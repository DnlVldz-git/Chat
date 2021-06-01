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
public class ClienteThread extends Thread {

    private Socket socket;
    private String nombre;
    private ColaMensajes cola;
    private ArrayList<ClienteThread> clientes; 

    public ClienteThread(String nombre, Socket socket, ColaMensajes cola) {
        this.nombre = nombre;
        this.socket = socket;
        this.cola = cola;
        
        
    }
    
    public void setClientes(ArrayList<ClienteThread> clientes){
        this.clientes = clientes;
    }
    
    public Socket getSocket(){
        return this.socket;
    }

    @Override
    public void run() {

        System.out.println("Inicio Cliente Thread");
        EscucharThread escuchar = new EscucharThread(this.nombre, this.socket, this.cola);

        escuchar.start();

    }

}
