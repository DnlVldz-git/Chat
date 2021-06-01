/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dani_
 */
public class RegistroDialog extends JDialog{
    private JLabel lblNom;
    private JTextField fldNom;
    private JLabel lblContra;
    private JTextField fldContra;
    private JButton btn;
    private JPanel pnl;
    
    public RegistroDialog(){
        super.setSize(300, 300);
        this.lblNom = new JLabel("Usuario");
        this.lblContra = new JLabel("Contraseña");
        this.fldNom = new JTextField(10);
        this.fldContra = new JTextField(10);
        this.pnl = new JPanel();
        this.btn = new JButton("Aceptar");
        
        pnl.add(this.lblNom);        
        pnl.add(this.fldNom);
        pnl.add(this.lblContra);
        pnl.add(this.fldContra);
        pnl.add(this.btn);
        
        this.add(pnl);
    
    }

    public JTextField getFldNom() {
        return fldNom;
    }

    public JTextField getFldContra() {
        return fldContra;
    }

    public JButton getBtn() {
        return btn;
    }
    
    
    
}
