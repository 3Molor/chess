// import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Myfram extends JFrame{
    public Myfram(String title){
        super(title);
        JPanel root = new JPanel();
        this.setContentPane(root);
        
        Mypanle pl = new Mypanle();
        root.add(pl);
        



        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}