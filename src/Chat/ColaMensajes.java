/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author dani_
 */
public class ColaMensajes {
    public Queue<String> cola;
    
    public ColaMensajes(){
        this.cola = new LinkedList();
    }
    
    public void addMensaje(String mensaje){
        this.cola.add(mensaje);
    }
    
    public  boolean  estaVacio(){
        return cola.isEmpty();
    }
    
    public void popCola(){
        cola.poll();
    }
    
    public String getMensaje(){
        if (!this.cola.isEmpty()) {
            return this.cola.peek();
        }else{
            return "";
        }
        
    }
}
