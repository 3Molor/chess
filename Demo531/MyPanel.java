package Demo531;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyPanel extends JPanel {
    JLabel label = new JLabel("点我一下");

    
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        
        int width = this.getWidth();
        int height = this.getHeight();
      

        g.setColor(new Color(138, 43, 226,68));
        g.fillOval(0, 0, width, height);
        
    }
  

    public MyPanel(){
        
        this.setLayout(null);
        label.setBounds(35,35,75,80);
        label.setOpaque(true);
        label.setBackground(Color.GREEN);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);
        this.setPreferredSize(new Dimension(150,150));


        this.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("鼠标点击事件mouseClicked");               
                label.setIcon(new ImageIcon("Demo531/image/你过来啊1.jpg"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
               System.out.println("鼠标按下mousePressed");
               label.setText("千万别放手!");
               label.setBackground(new Color(255, 0, 0));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("鼠标释放mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("鼠标移入mouseEntered");
                label.setText("快点我！快点我！");
                label.setBackground(new Color(255, 255, 0));
               
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("鼠标移出mouseExited");
                label.setText("你咋就放了呢？");
                label.setBackground(Color.GREEN);
            }
            
        });
        
    }

}
