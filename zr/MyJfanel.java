package GUIDemo.zr;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyJfanel extends JPanel {
    JLabel la = new JLabel("测试");
    JLabel label;
    File file1, file2;
    ImageIcon icon1, icon2;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = this.getWidth();
        int height = this.getHeight();
        g.setColor(new Color(76, 76, 108));
        g.fillRect(0, 0, width, height);
        la.setBackground(new Color(218, 218, 231));
    }

    public MyJfanel() {
        this.setLayout(null);
        la.setBounds(0, 50, 50, 50);
        la.setOpaque(true);
        la.setBackground(Color.WHITE);
        la.setPreferredSize(new Dimension(50, 50));

        label = new JLabel();
        label.setBounds(0, 0, 500, 500);
        label.setOpaque(true);
        label.setBackground(new Color(76, 76, 108));

        file1 = new File("GUIDemo/Mouse/brny.jpg");
        icon1 = new ImageIcon(file1.getAbsolutePath());
        int width = icon1.getIconWidth();
        int height = icon1.getIconHeight();
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();
        double scale = Math.min(labelWidth * 1.0 / width, labelHeight * 1.0 / height);
        Image image = icon1.getImage().getScaledInstance((int) (width * scale), (int) (height * scale),
                Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));

        file2 = new File("GUIDemo/Mouse/bigbrny.jpg");
        icon2 = new ImageIcon(file2.getAbsolutePath());

        this.add(la);
        this.add(label);
        repaint();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("鼠标点击mouseClicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("鼠标按下mousePressed");
                int width = icon2.getIconWidth();
                int height = icon2.getIconHeight();
                int labelWidth = label.getWidth();
                int labelHeight = label.getHeight();
                double scale = Math.min(labelWidth * 1.0 / width, labelHeight * 1.0 / height);
                Image image = icon2.getImage().getScaledInstance((int) (width * scale), (int) (height * scale),
                        Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(image));
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("鼠标松开mouseReleased");
                label.setIcon(new ImageIcon(image));
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("鼠标进入mouseEntered");
                la.setBackground(new Color(194, 150, 218));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("鼠标移出mouseExited");
                la.setBackground(Color.WHITE);
            }

        });
    }
}
