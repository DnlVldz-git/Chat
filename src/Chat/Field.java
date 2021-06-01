/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dani_
 */
public class Field extends JPanel{
    private JTextField field;
    private JButton btn;
    private JLabel lbl;
    
    public Field(){
        this.field = new JTextField(15);
        this.btn = new JButton("Enviar");
        this.lbl= new JLabel();

        this.add(lbl);
        this.add(field);
        this.add(btn);
    }
    
    public void setLbl(String text){
        this.lbl.setText(text);
    }
    
    public JButton getBtn(){
        return this.btn;
    }
    
    public JTextField getFld(){
        return this.field;
    }
    
    public void cleanField(){
        this.field.setText("");
    }

}
