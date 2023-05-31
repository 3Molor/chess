package Demo531;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJrame extends JFrame{
    public MyJrame(){
        this.setTitle("测试");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        this.setContentPane(root);

        MyPanel p = new MyPanel();
        root.add(p);

        

        this.setSize(450,300);
        this.setVisible(true);
    }
    
}
