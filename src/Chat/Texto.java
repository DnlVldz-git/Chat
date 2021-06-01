/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.awt.TextArea;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author dani_
 */
public  class Texto extends Thread implements Serializable{
    private TextArea area;
    private Socket socket;
    private JPanel pnl;

    public Texto(Socket socket) {
        this.area = new TextArea();        
        area.setSize(500, 500);        
        area.setEditable(false);
        this.area.setText("----------Chat Sónico 101--------");        
        this.socket = socket;
        this.pnl = new JPanel();                  
        
        pnl.add(area);
    }
    
    public void setSocket(Socket socket){
        this.socket = socket;
    }
    
    public TextArea getTxt(){
        return this.area;
    }
    
    public JPanel getPnl(){
        return this.pnl;
    }

    public void refreshText(String text) {
        String txt = area.getText();
        this.area.setText(txt + "\n" + text);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("inicio texto");
                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

                String msg = (String) entrada.readObject();
                
                refreshText(msg);                               
                
                area.repaint();
                
                this.area.repaint();

            } catch (IOException ex) {
                System.out.println("mamo ?");
                System.out.println(ex.getMessage());
                break;
            } catch (ClassNotFoundException ex) {
                System.out.println("mamo?");
                Logger.getLogger(Texto.class.getName()).log(Level.SEVERE, null, ex);                
            }
        }
    }

}
