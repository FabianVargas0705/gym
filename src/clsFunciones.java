
import java.awt.TextArea;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faby0
 */
public class clsFunciones {
    public int recibeInt(String mensaje){
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }
    public String recibeString(String mensaje){
        return JOptionPane.showInputDialog(mensaje);
    }
    public char recibeChar(String mensaje){
        return JOptionPane.showInputDialog(mensaje).toUpperCase().charAt(0);
    }
    public void imprimeMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void imprimeMensaje(TextArea mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
