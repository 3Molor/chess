package GUIDemo.zr;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJFame extends JFrame{
    public MyJFame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel root = new JPanel();
        setContentPane(root);
        MyJfanel jf = new MyJfanel();
        jf.setPreferredSize(new Dimension(500, 500));
        root.add(jf);
        setSize(800, 600);
        this.setVisible(true);
    }
}
