package qui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class swingimg extends javax.swing.JFrame{
    public swingimg() {
        a = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        a.setIcon(new javax.swing.ImageIcon("C:/samolocik.gif"));
        add(a);
        pack();
    }
    
    public static void main(String args[]) throws Exception{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new swingimg().setVisible(true);
            }
        });
    }
    
    private javax.swing.JLabel a;
}
