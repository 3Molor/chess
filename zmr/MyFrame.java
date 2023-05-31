package zmr;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
    public MyFrame(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel root = new JPanel();
        this.setContentPane(root);
        MyJPanel p = new MyJPanel();
        p.setPreferredSize(new Dimension(300,300));
        root.add(p);
        JLabel lable = new JLabel();
        root.add(lable);
        this.setSize(400,200);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame("测试窗口");
    }
}
