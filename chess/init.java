package chess;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import chess.ActionListenner.Run;
import chess.chessPieces.black;
import chess.chessPieces.red;

public class init extends JFrame {

    JPanel board;
    Run run;
    ArrayList<Point> list;
    JButton white = new JButton();
    // 透明面板
    JPanel jp;

    public init(String title) {
        // 初始化
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("chess/sucai/black/象.png");
        setIconImage(icon.getImage());
        setSize(500, 500);
        setLocationRelativeTo(null);
        // setResizable(false);

        // 棋盘
        board = new JPanel();
        chessboard();
        // jp.add(white);
        // 添加红色棋子
        new red(jp);
        // redchess();

        // 添加黑色棋子
        // blackchess();
        new black(jp);
        list = new ArrayList<>();
        for (int i = 0; i < jp.getComponentCount(); i++) {
            Component comp = jp.getComponent(i);
            if (comp instanceof JButton) {
                JButton btp = (JButton)comp;
                btp.getLocation(getLocation());
            }
        }

        // 棋子作用
        new Run(jp,list);
        // 结束条件

        // 添加
        add(board);

        // 最后
        setVisible(true);
    }
    /**
     * @see: 黑色棋子
     * @car: 车
     * @horse: 马
     * @boss: 将
     * @gun: 炮
     * @guard: 士
     * @PrimeMinister: 相
     * @soldiers: 兵
     */
    // private void blackchess() {
    // JButton[] car = new JButton[2];
    // JButton[] horse = new JButton[2];
    // JButton boss = new JButton();
    // JButton[] soldiers = new JButton[5];
    // JButton[] gun = new JButton[2];
    // JButton[] guard = new JButton[2];
    // JButton[] PrimeMinister = new JButton[2];
    // ImageIcon image;
    // // 车
    // for (int i = 0; i < car.length; i++) {
    // image = new ImageIcon("chess/sucai/black/车.png");
    // car[i] = new JButton(image);
    // car[i].setSize(50, 50);
    // setIcon("chess/sucai/black/车.png", car[i]);
    // car[i].setContentAreaFilled(false);
    // car[i].setBorder(null);
    // car[i].addActionListener(new BlackActionListener());
    // }
    // car[0].setLocation(getWidth()-85, 31);
    // car[1].setLocation(31, 31);
    // for (int i = 0; i < car.length; i++) {
    // jp.add(car[i]);
    // }

    // // 兵
    // for (int i = 0; i < soldiers.length; i++) {
    // image = new ImageIcon("chess/sucai/black/卒.png");
    // soldiers[i] = new JButton("卒",image);
    // soldiers[i].setFont(new Font("楷体", 0, 0));;
    // soldiers[i].setIconTextGap(-10);
    // soldiers[i].setSize(50, 50);
    // setIcon("chess/sucai/black/卒.png", soldiers[i]);
    // soldiers[i].setContentAreaFilled(false);
    // soldiers[i].setBorder(null);
    // }
    // soldiers[0].setLocation(getWidth()-85, 31+(3*72));
    // soldiers[1].setLocation(getWidth()-85-72*2, 31+(3*72));
    // soldiers[2].setLocation(getWidth()-85-72*4, 31+(3*72));
    // soldiers[3].setLocation(getWidth()-85-72*6, 31+(3*72));
    // soldiers[4].setLocation(getWidth()-85-72*8, 31+(3*72));
    // for (int i = 0; i < soldiers.length; i++) {
    // soldiers[i].addActionListener(e ->{
    // jp.remove(white);
    // JButton white = new JButton();
    // JButton btn = (JButton) e.getSource();
    // Point XY = run.pao((JButton) e.getSource());
    // int X = (int) XY.getX();
    // int Y = (int) XY.getY();
    // white.setSize(30,30);
    // setIcon("chess/sucai/路径点.png", white);
    // white.setContentAreaFilled(false);
    // white.setBorder(null);
    // white.setLocation(X+10,Y+81);
    // jp.add(white);
    // white.addActionListener(o ->{
    // btn.setLocation(white.getX()-10,white.getY()-10);
    // jp.remove(white);
    // });
    // this.repaint();
    // });
    // jp.add(soldiers[i]);
    // }

    // // 马
    // for (int i = 0; i < horse.length; i++) {
    // image = new ImageIcon("chess/sucai/black/马.png");
    // horse[i] = new JButton(image);
    // horse[i].setSize(50, 50);
    // setIcon("chess/sucai/black/马.png", horse[i]);
    // horse[i].setContentAreaFilled(false);
    // horse[i].setBorder(null);
    // }
    // horse[0].setLocation(getWidth() - 85-72, 31);
    // horse[1].setLocation(31+72, 31);
    // for (int i = 0; i < horse.length; i++) {
    // horse[i].addActionListener(new BlackActionListener());
    // jp.add(horse[i]);
    // }

    // //相
    // for (int i = 0; i < PrimeMinister.length; i++) {
    // image = new ImageIcon("chess/sucai/black/象.png");
    // PrimeMinister[i] = new JButton();
    // PrimeMinister[i].setSize(50, 50);
    // setIcon("chess/sucai/black/象.png", PrimeMinister[i]);
    // PrimeMinister[i].setContentAreaFilled(false);
    // PrimeMinister[i].setBorder(null);
    // PrimeMinister[i].addActionListener(e -> {
    // System.out.println("1");
    // });
    // }
    // PrimeMinister[0].setLocation(getWidth() - 85-72*2, 31);
    // PrimeMinister[1].setLocation(31+72*2, 31);
    // for (int i = 0; i < PrimeMinister.length; i++) {
    // jp.add(PrimeMinister[i]);
    // }

    // //炮
    // for (int i = 0; i < gun.length; i++) {
    // image = new ImageIcon("chess/sucai/black/炮.png");
    // gun[i] = new JButton(image);
    // gun[i].setSize(50, 50);
    // setIcon("chess/sucai/black/炮.png", gun[i]);
    // gun[i].setContentAreaFilled(false);
    // gun[i].setBorder(null);
    // gun[i].addActionListener(e -> {
    // System.out.println("1");
    // });
    // }
    // gun[0].setLocation(getWidth() - 85 - 72, 31+72*2);
    // gun[1].setLocation(31 + 72, 31+72*2);
    // for (int i = 0; i < gun.length; i++) {
    // jp.add(gun[i]);
    // }

    // // 士
    // for (int i = 0; i < guard.length; i++) {
    // image = new ImageIcon("chess/sucai/black/士.png");
    // guard[i] = new JButton(image);
    // guard[i].setSize(50, 50);
    // setIcon("chess/sucai/black/士.png", guard[i]);
    // guard[i].setContentAreaFilled(false);
    // guard[i].setBorder(null);
    // guard[i].addActionListener(e -> {
    // System.out.println("1");
    // });
    // }
    // guard[0].setLocation(getWidth() - 85 - 72*3, 31);
    // guard[1].setLocation(31 + 72*3, 31);
    // for (int i = 0; i < guard.length; i++) {
    // jp.add(guard[i]);
    // }

    // //将军
    // image = new ImageIcon("chess/sucai/black/将.png");
    // boss = new JButton(image);
    // boss.setSize(50, 50);
    // setIcon("chess/sucai/black/将.png", boss);
    // boss.setContentAreaFilled(false);
    // boss.setBorder(null);
    // boss.addActionListener(e -> {
    // System.out.println("1");
    // });
    // boss.setLocation(31+72*4, 31);
    // jp.add(boss);
    // }

    // /**
    // * @see: 红色棋子
    // * @car: 车
    // * @horse: 马
    // * @boss: 将
    // * @gun: 炮
    // * @guard: 士
    // * @PrimeMinister: 相
    // * @soldiers: 兵
    // */
    // private void redchess() {
    // JButton[] car = new JButton[2];
    // JButton[] horse = new JButton[2];
    // JButton boss = new JButton();
    // JButton[] soldiers = new JButton[5];
    // JButton[] gun = new JButton[2];
    // JButton[] guard = new JButton[2];
    // JButton[] PrimeMinister = new JButton[2];
    // ImageIcon image;
    // // 车
    // for (int i = 0; i < car.length; i++) {
    // image = new ImageIcon("chess/sucai/red/车.png");
    // car[i] = new JButton(image);
    // car[i].setSize(50, 50);
    // setIcon("chess/sucai/red/车.png", car[i]);
    // car[i].setContentAreaFilled(false);
    // car[i].setBorder(null);
    // car[i].addActionListener(e -> {
    // System.out.println("1");
    // });
    // }
    // car[0].setLocation(getWidth()-85, getHeight()-90);
    // car[1].setLocation(31, getHeight()-90);
    // for (int i = 0; i < car.length; i++) {
    // jp.add(car[i]);
    // }

    // // 兵
    // for (int i = 0; i < soldiers.length; i++) {
    // image = new ImageIcon("chess/sucai/red/兵.png");
    // soldiers[i] = new JButton(image);
    // soldiers[i].setSize(50, 50);
    // setIcon("chess/sucai/red/兵.png", soldiers[i]);
    // soldiers[i].setContentAreaFilled(false);
    // soldiers[i].setBorder(null);
    // }
    // soldiers[0].setLocation(getWidth()-85, getHeight()-90-(3*72));
    // soldiers[1].setLocation(getWidth()-85-72*2, getHeight()-90-(3*72));
    // soldiers[2].setLocation(getWidth()-85-72*4, getHeight()-90-(3*72));
    // soldiers[3].setLocation(getWidth()-85-72*6, getHeight()-90-(3*72));
    // soldiers[4].setLocation(getWidth()-85-72*8, getHeight()-90-(3*72));
    // for (int i = 0; i < soldiers.length; i++) {
    // soldiers[i].addActionListener(new BlackActionListener());
    // jp.add(soldiers[i]);
    // }

    // // 马
    // for (int i = 0; i < horse.length; i++) {
    // image = new ImageIcon("chess/sucai/red/马.png");
    // horse[i] = new JButton(image);
    // horse[i].setSize(50, 50);
    // setIcon("chess/sucai/red/马.png", horse[i]);
    // horse[i].setContentAreaFilled(false);
    // horse[i].setBorder(null);
    // horse[i].addActionListener(e -> {
    // System.out.println("1");
    // });
    // }
    // horse[0].setLocation(getWidth() - 85-72, getHeight() - 90);
    // horse[1].setLocation(31+72, getHeight() - 90);
    // for (int i = 0; i < horse.length; i++) {
    // jp.add(horse[i]);
    // }

    // //相
    // for (int i = 0; i < PrimeMinister.length; i++) {
    // image = new ImageIcon("chess/sucai/red/相.png");
    // PrimeMinister[i] = new JButton(image);
    // PrimeMinister[i].setSize(50, 50);
    // setIcon("chess/sucai/red/相.png", PrimeMinister[i]);
    // PrimeMinister[i].setContentAreaFilled(false);
    // PrimeMinister[i].setBorder(null);
    // PrimeMinister[i].addActionListener(e -> {
    // System.out.println("1");
    // });
    // }
    // PrimeMinister[0].setLocation(getWidth() - 85-72*2, getHeight() - 90);
    // PrimeMinister[1].setLocation(31+72*2, getHeight() - 90);
    // for (int i = 0; i < PrimeMinister.length; i++) {
    // jp.add(PrimeMinister[i]);
    // }

    // //炮
    // for (int i = 0; i < gun.length; i++) {
    // image = new ImageIcon("chess/sucai/red/炮.png");
    // gun[i] = new JButton(image);
    // gun[i].setSize(50, 50);
    // setIcon("chess/sucai/red/炮.png", gun[i]);
    // gun[i].setContentAreaFilled(false);
    // gun[i].setBorder(null);
    // gun[i].addActionListener(e -> {
    // System.out.println("1");
    // });
    // }
    // gun[0].setLocation(getWidth() - 85 - 72, getHeight() - 90-72*2);
    // gun[1].setLocation(31 + 72, getHeight() - 90-72*2);
    // for (int i = 0; i < gun.length; i++) {
    // jp.add(gun[i]);
    // }

    // // 士
    // for (int i = 0; i < guard.length; i++) {
    // image = new ImageIcon("chess/sucai/red/士.png");
    // guard[i] = new JButton(image);
    // guard[i].setSize(50, 50);
    // setIcon("chess/sucai/red/士.png", guard[i]);
    // guard[i].setContentAreaFilled(false);
    // guard[i].setBorder(null);
    // guard[i].addActionListener(e -> {
    // System.out.println("1");
    // });
    // }
    // guard[0].setLocation(getWidth() - 85 - 72*3, getHeight() - 90);
    // guard[1].setLocation(31 + 72*3, getHeight() - 90);
    // for (int i = 0; i < guard.length; i++) {
    // jp.add(guard[i]);
    // }

    // //将军
    // image = new ImageIcon("chess/sucai/red/帅.png");
    // boss = new JButton(image);
    // boss.setSize(50, 50);
    // setIcon("chess/sucai/red/帅.png", boss);
    // boss.setContentAreaFilled(false);
    // boss.setBorder(null);
    // boss.addActionListener(e -> {
    // System.out.println("1");
    // });
    // boss.setLocation(31+72*4, getHeight() - 90);
    // jp.add(boss);
    // }

    /**
     * @see: 背景图片，棋盘
     */
    private void chessboard() {
        ImageIcon bacakimageurl = new ImageIcon("chess/sucai/chessboard1.png");
        setBounds(0, 0, bacakimageurl.getIconWidth() + 15, bacakimageurl.getIconHeight() + 37);
        JLabel backimage = new JLabel(bacakimageurl);
        backimage.setBounds(0, 0, bacakimageurl.getIconWidth(),
                bacakimageurl.getIconHeight());
        jp = (JPanel) this.getContentPane();
        jp.setOpaque(false);
        jp.setLayout(null);
        add(backimage);
        this.getLayeredPane().add(backimage, new Integer(Integer.MIN_VALUE));
    }

    // public void paint(Graphics g) {
    //     super.paint(g);
    //     Graphics2D g2d = (Graphics2D) g;
    //     g2d.setStroke(new BasicStroke(3f));
    //     g.drawRect(58, 78, 590, 660);
    //     g2d.setStroke(new BasicStroke(2f));
    //     g.drawRect(65, 85, 576, 648);
    //     for (int i = 0; i < 10; i++) {
    //         g.drawLine(65, 85+i*72,65+8*72,85+i*72);
    //     }
    //     for (int i = 1; i <= 7; i++) {
    //         g.drawLine(65+i*72, 85,65+i*72,85+4*72);
    //     }
    //     for (int i = 1; i <= 7; i++) {
    //         g.drawLine(65+i*72, 85+5*72,65+i*72,85+5*72+4*72);
    //     }
    // }

    /**
     * 
     * @param file: 图片路径
     * @param com:  按钮
     */
    public void setIcon(String file, JButton com) {
        ImageIcon ico = new ImageIcon(file);
        ico.getImage();
        Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_DEFAULT);
        ico = new ImageIcon(temp);
        com.setIcon(ico);
    }

    // public void loc(){
    // int count = jp.getComponentCount();
    // for (int i = 0; i < count; i++) {
    // Component comp = jp.getComponent(i);
    // if(comp instanceof JButton){
    // JButton btn = (JButton)comp;
    // Point loc = btn.getLocation(null);
    // System.out.println(loc);
    // }

    // }
    // }
}
