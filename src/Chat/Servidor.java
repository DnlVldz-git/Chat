/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class Servidor {

    public static void main(String[] args) {
        ServerSocket server;

        ColaMensajes cola = new ColaMensajes();                
        
        ArrayList<ClienteThread> clientes = new ArrayList();
        
        EscribirThread escribir = new EscribirThread(cola, clientes);
        
        escribir.start();
        
        try {
            server = new ServerSocket(1131);
            while (true) {
                Socket socket = server.accept();       
                
                System.out.println("HOla");
                
                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

                String nom;

                while (true) {
                    try {
                        nom = (String) entrada.readObject();
                        
                        System.out.println("Se metío "+ nom);

                        ClienteThread cliente = new ClienteThread(nom, socket, cola);
                        
                        clientes.add(cliente);
                        
                        cliente.setClientes(clientes);
                        
                        cliente.start();
                        break;
                    } catch (ClassNotFoundException ex) {
                        System.out.println("No se mandó el msg");
                    }

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
