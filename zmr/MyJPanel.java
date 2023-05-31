package zmr;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
// import java.io.*;
// import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
// import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyJPanel extends JPanel{
    private JLabel label = new JLabel();
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // int width = this.getWidth();
        // int height = this.getHeight();
        // try{
        //     g.setColor(Color.PINK);
        //     g.fillRect(0,0,width,height);
        //     file = new File("GUI/Image/2.png");
        //     Image = ImageIO.read(file);
        //     g.drawImage(Image, 0, 0,200,200,null);
        // }catch(IOException e){
        //     e.printStackTrace();
        // }
        // // g.setColor(Color.RED);
        // // g.drawOval(0,0,width,height);
        label.setIcon(new ImageIcon("zmr\\1.png"));        
    }

    public MyJPanel(){
        this.setLayout(null);
        int width = this.getWidth();
        int height = this.getHeight();
        label.setBounds(0, 0, 300,150);
        label.setOpaque(true);
        //文字居中
        // label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(new Color(209,183,241));
        label.setText("什么都没有哦");
        this.add(label);
        // this.setPreferredSize(new Dimension(150, 150));
        this.addMouseListener(new MouseListener(){
            //点击事件
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("好难受,要emo了");
                label.setBackground(Color.YELLOW);
            }
            //鼠标按下
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("都说了什么都没有啦");
                label.setBackground(Color.ORANGE);
                label.setText("我喜欢你");
            }
            //释放
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("我喜欢你!");
                label.setText("居然拒绝我?好难受...");
                label.setBackground(new Color(207,99,145));
                // JLabel one = new JLabel();
                // one.setBounds(0, 00, 200,200);
                label.setIcon(new ImageIcon("zmr\\2.png"));
                // try{
                //     file = new File("GUI/Image/3.png");
                //     Image = ImageIO.read(file);
                //     .drawImage(Image, 0, 0,200,200,null);
                // }catch(IOException a){
                //     a.printStackTrace();
                // }   
            }
            //移入
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("什么都没有,就别看了吧");
                label.setBackground(new Color(234,155,123));
            }
            //鼠标移开事件
            @Override
            public void mouseExited(MouseEvent e) {
               System.out.println("浪费我感情,你很烦耶,快走吧你!!!");
               label.setBackground(Color.GRAY);
            }
        });
    }
}
