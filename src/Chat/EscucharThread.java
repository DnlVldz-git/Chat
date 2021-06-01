/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dani_
 */
public class EscucharThread extends Thread {

    private Socket socket;
    private String nombre;
    private ColaMensajes cola;
    private ObjectInputStream entrada;
    private GregorianCalendar calendario;

    public EscucharThread(String nombre, Socket socket, ColaMensajes cola) {
        this.nombre = nombre;
        this.socket = socket;
        this.cola = cola;      
        this.calendario = new GregorianCalendar();
    }
    
    public String getHour(){
        return (calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE)+":"+calendario.get(Calendar.SECOND));
    }
    
    @Override
    public void run() {
        System.out.println("Inicio escuchar");
        while (true) {
            try {
                entrada = new ObjectInputStream(this.socket.getInputStream());

                String msg = (String) entrada.readObject();

                String msg_completo = (getHour()+" "+this.nombre + " : " + msg);                                    

                cola.addMensaje(msg_completo);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                break;                
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al leer");
            }
        }

    }

}
