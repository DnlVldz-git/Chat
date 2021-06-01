/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author dani_
 */
public class Chat extends JFrame {

    private Texto texto;
    private Field fld;
    private Socket socket;
    private UsuarioDialog dialog;
    private ObjectOutputStream salida;
    private RegistroDialog regDialog;

    public Chat() {
        super("Chat");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(300, 380);
        super.setLocationRelativeTo(null);

        dialog = new UsuarioDialog();
        fld = new Field();
        regDialog = new RegistroDialog();

        dialog.setVisible(true);
        dialog.pack();

        BtnActionListener e = new BtnActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                while (true) {
                    try {
                        if (!dialog.getFldContra().getText().equals(dialog.getDAO().getDatos(dialog.getFldNom().getText()))) {
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta, comprueba tus datos");
                        } else {

                            socket = new Socket("127.0.0.1", 1131);

                            System.out.println("Me aceptaron");

                            texto = new Texto(socket);

                            texto.start();

                            salida = new ObjectOutputStream(socket.getOutputStream());

                            salida.writeObject(dialog.getFldNom().getText());

                            fld.setLbl("Usuario: " + dialog.getFldNom().getText());

                            add(texto.getPnl(), BorderLayout.NORTH);
                            pack();
                            dialog.setVisible(false);
                            setVisible(true);
                        }
                        break;
                    } catch (IOException ex) {
                        System.out.println("Error al conectar o esperando");
                    }
                }
            }
        };

        BtnActionListener enviar = new BtnActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {

                    salida = new ObjectOutputStream(socket.getOutputStream());

                    String msg = fld.getFld().getText();

                    salida.reset();

                    salida.writeObject(msg);

                    fld.cleanField();

                    pack();

                } catch (IOException ex) {
                    System.out.println("peto");
                }
            }
        };

        BtnActionListener registro = new BtnActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                regDialog.setVisible(true);
            }
        };

        BtnActionListener registroAceptar = new BtnActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog.getDAO().insertar(regDialog.getFldNom().getText(), regDialog.getFldContra().getText());
                regDialog.setVisible(false);
            }
        };

        fld.getBtn().addActionListener(enviar);
        this.dialog.getBtn().addActionListener(e);
        this.dialog.getBtnReg().addActionListener(registro);
        this.regDialog.getBtn().addActionListener(registroAceptar);

        add(fld, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Chat();
            }
        });
    }

}
