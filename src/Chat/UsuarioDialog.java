/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dani_
 */
public class UsuarioDialog extends JDialog{
    private JPanel pnl;
    private JLabel lblNom;
    private JLabel lblContra;
    private JTextField fldNom;
    private JTextField fldContra;
    private JButton btn;
    private JButton btnReg;
    private DAO dao;
    
    public UsuarioDialog(){
        super.setLocation(500, 500);
        this.lblNom = new JLabel("Introduzca su nombre");
        this.pnl = new JPanel();
        this.fldNom = new JTextField(10);
        this.lblContra = new JLabel("Introduzca su contraseña");
        this.fldContra = new JTextField(10);
        this.btn = new JButton("Aceptar");
        this.btnReg = new JButton("Registrarse");       
        this.dao = new DAO();
        
        pnl.setBackground(Color.PINK);
        
        pnl.add(lblNom);        
        pnl.add(fldNom);
        pnl.add(lblContra);        
        pnl.add(fldContra);
        
        pnl.add(btn);
        pnl.add(btnReg);
        
        this.add(pnl);
    }
    
    public DAO getDAO(){
        return this.dao;               
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
    
    public JButton getBtnReg() {
        return btnReg;
    }
    
    
    
}
