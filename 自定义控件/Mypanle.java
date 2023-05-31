import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Label;
// import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

    

public class Mypanle extends JPanel {
    //添加成员变量
    JLabel label = new JLabel("我爱你");



    @Override
    public void paint(Graphics g) {

        // TODO Auto-generated method stub
        super.paint(g);

        int width = this.getWidth();
        int height = this.getHeight();


        try {
            File file = new File("image\25FEA61879F7A7FDC59C721DEA1AF984.png");
            BufferedImage image = ImageIO.read(file);
            g.drawImage(image, 0, 0, width,height,null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // g.setColor(Color.GREEN);
        // g.fillOval(0, 0, width, height);

        // g.setColor(Color.yellow);
        // g.fillOval(0, 0, width/2, height/2);
    }

    public Mypanle(){
        this.setPreferredSize(new Dimension(100, 100));
        this.add(label);
        this.setLayout(null);
        int width = getWidth();
        int height = getHeight();
        label.setBounds(width/2, height/2 ,50, 50);
        label.setOpaque(true);
        label.setBackground(Color.pink);
        

        
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                // this.setColor(Color.GRAY);
                System.out.println("点击事件");
                label.setText("笨笨猪");
                label.setBackground(Color.yellow);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("按下事件");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("释放事件");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("移入事件");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("移出事件");
                // Label.setBackground(Color.BLACK);
                label.setText("我爱你");
                label.setBackground(Color.PINK);
                
            }
            
        });

        
    }
}
