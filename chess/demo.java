package chess;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.*;

public class demo extends JFrame {

    public demo(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        JPanel jp = new JPanel();
        setContentPane(jp);

        
        ImageIcon image = new ImageIcon("chess/sucai/red/兵.png");
        JButton jb = new JButton(image);
        jb.setSize(50,50);
        setIcon("chess/sucai/red/兵.png", jb);
        jb.setContentAreaFilled(false);
        jb.setBorder(null);
        jb.addActionListener(e ->{
            System.out.println("1");
        });




        add(jb);
        



        setVisible(true);
    }

    public void setIcon(String file, JButton com) {
        ImageIcon ico = new ImageIcon(file);
        Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), ico.getImage().SCALE_DEFAULT);
        ico = new ImageIcon(temp);
        com.setIcon(ico);
    }

    public static void main(String[] args) {
        new demo("测试");
    }
}
