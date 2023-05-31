package chess.ActionListenner;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class BlackActionListener implements ActionListener {

    ImageIcon image = new ImageIcon("chess/sucai/路径点.png");
    JPanel jp;
    ArrayList<Point> points; 
    // 卒的触发
    private static JButton[] whites = null;
    private static JButton white = null;
    public static synchronized JButton[] getWhites() {
        if (whites == null) {
            whites = new JButton[3];
            for (int i = 0; i < 3; i++) {
                whites[i] = new JButton();
            }
        }
        return whites;
    }
    public static JButton getWhite() {
        if (white == null) {
            white = new JButton();
        }
        return white;
    }
    public BlackActionListener(){

    }

    //棋盘，不管
    public BlackActionListener(JPanel jPanel) {
        this.jp = jPanel;
        
    }
    public BlackActionListener(ArrayList<Point> list){
        this.points = list;
        points = new ArrayList<>();
        for (int i = 0; i < jp.getComponentCount(); i++) {
            Component comp = jp.getComponent(i);
            if(comp instanceof JButton){
                JButton btnpoint = (JButton)comp;
                points.add(btnpoint.getLocation()); 
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        Point XY = btn.getLocation();
        int X = (int) XY.getX();
        int Y = (int) XY.getY();
        if (btn.getText().equals("卒")) {
            if (Y >= 30 + (5 * 72)) {
                getWhites();
                for (int i = 0; i < 3; i++) {
                    whites[i].setSize(30, 30);
                    setIcon("chess/sucai/路径点.png", whites[i]);
                    whites[i].setContentAreaFilled(false);
                    whites[i].setBorder(null);
                    for(ActionListener al : whites[i].getActionListeners()){
                        whites[i].removeActionListener(al);
                    };
                    whites[i].addActionListener(new ButtonListener(btn));
                    jp.add(whites[i], 0);
                    jp.repaint();
                }
                if (!(X <= 35)) {
                    whites[2].setLocation(X - 61, Y + 10);
                }
                if (!(X >= 35 + 9 * 71)) {
                    whites[1].setLocation(X + 81, Y + 10);
                }
                if (!(Y >= 30 + 9 * 72))
                    whites[0].setLocation(X + 10, Y + 82);
                jp.repaint();
            } else {
                getWhite();
                white.setSize(30, 30);
                setIcon("chess/sucai/路径点.png", white);
                white.setLocation(X + 10, Y + 82);
                white.setContentAreaFilled(false);
                white.setBorder(null);
                for (ActionListener al : white.getActionListeners()) {
                    white.removeActionListener(al);
                }
                
                white.addActionListener(new ButtonListener(btn));
                jp.add(white, 0);
                jp.repaint();
            }

        }

    }

    public void setIcon(String file, JButton com) {
        ImageIcon ico = new ImageIcon(file);
        ico.getImage();
        Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_DEFAULT);
        ico = new ImageIcon(temp);
        com.setIcon(ico);
    }



    class ButtonListener implements ActionListener{
        private JButton btn;

        public ButtonListener(JButton btn) {
            this.btn = btn;
        }
        public void actionPerformed(ActionEvent e) {
            JButton bt = (JButton) e.getSource();
            int x = (int)bt.getLocation().getX() - 10;
            int y = (int)bt.getLocation().getY() - 10;
            bt.setLocation(x, y);
            btn.setLocation(x, y);

            for (Point point : points) {
                // System.out.println(bt.getLocation() == point);
                // if (bt.getLocation() == point) {
                //     jp.remove(jp.getComponentAt(point));
                //     System.out.println(1);
                // }else if(bt.getLocation() == point){
                //     jp.remove(jp.getComponentAt(point));
                //     System.out.println(2);
                // }
            }
            if (whites != null) {
                for(int j = 0; j < whites.length ; j++){
                    jp.remove(whites[j]);
                }
            }
            if (white != null) {
                jp.remove(white);
            }
            jp.repaint();
        }
        
    }
}
