
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// 简化版的DateFormat
import java.text.SimpleDateFormat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class MyFrame extends JFrame {


    JLabel j1 = new JLabel("点击有惊喜哦");
    // JLabel j1 = new JLabel();

    public MyFrame(String title){
        super(title);

        this.setLocation(700,300);	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp1 = new JPanel();
        this.setContentPane(jp1);

        JButton jb1 = new JButton("刷新时间");
      
        jp1.add(jb1);
        jp1.add(j1);

        // MYActionListener listener = new MYActionListener();
        jb1.addActionListener(new MYActionListener());
        
        // 宽高
        this.setSize(500, 300);

        this.setVisible(true);

    }

    
    private class MYActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            Date d = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String s4 = sdf.format(d);

            System.out.println(s4);
            j1.setText(s4);
            System.out.println(s4);
        }

    }



    public static void main(String[] args) {
        JFrame t = new MyFrame("");
    }
}
