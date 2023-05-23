package chess;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class init extends JFrame {

    JPanel board;
    JButton redchess;
    JButton blackchess;
    //透明面板
    JPanel jp;

    public init(String title) {
        // 初始化
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("chess/sucai/black/象.png");
        setIconImage(icon.getImage());
        setSize(500, 500);
        setLocationRelativeTo(null);

        // 棋盘
        board = new JPanel();
        chessboard();

        // 添加红色棋子
        redchess();

        // 添加黑色棋子
        blackchess();

        // 棋子作用


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
    private void blackchess() {
        JButton[] car = new JButton[2];
        JButton[] horse = new JButton[2];
        JButton boss = new JButton();
        JButton[] soldiers = new JButton[5];
        JButton[] gun = new JButton[2];
        JButton[] guard = new JButton[2];
        JButton[] PrimeMinister = new JButton[2];
        ImageIcon image;
        // 车
        for (int i = 0; i < car.length; i++) {
            image = new ImageIcon("chess/sucai/black/车.png");
            car[i] = new JButton(image);
            car[i].setSize(50, 50);
            setIcon("chess/sucai/black/车.png", car[i]);
            car[i].setContentAreaFilled(false);
            car[i].setBorder(null);
            car[i].addActionListener(e ->{
                System.out.println("1");
            });
        }
        car[0].setLocation(getWidth()-85, 31);
        car[1].setLocation(31, 31);
        for (int i = 0; i < car.length; i++) {
            jp.add(car[i]);
        }
        

        // 兵
        for (int i = 0; i < soldiers.length; i++) {
            image = new ImageIcon("chess/sucai/black/卒.png");
            soldiers[i] = new JButton(image);
            soldiers[i].setSize(50, 50);
            setIcon("chess/sucai/black/卒.png", soldiers[i]);
            soldiers[i].setContentAreaFilled(false);
            soldiers[i].setBorder(null);
        }
        soldiers[0].setLocation(getWidth()-85, 31+(3*72));
        soldiers[1].setLocation(getWidth()-85-72*2, 31+(3*72));
        soldiers[2].setLocation(getWidth()-85-72*4, 31+(3*72));
        soldiers[3].setLocation(getWidth()-85-72*6, 31+(3*72));
        soldiers[4].setLocation(getWidth()-85-72*8, 31+(3*72));
        System.out.println(getWidth()-85-72*8);
        for (int i = 0; i < soldiers.length; i++) {
            soldiers[i].addActionListener(e -> {
                
            });
            jp.add(soldiers[i]);
        }

        // 马
        for (int i = 0; i < horse.length; i++) {
            image = new ImageIcon("chess/sucai/black/马.png");
            horse[i] = new JButton(image);
            horse[i].setSize(50, 50);
            setIcon("chess/sucai/black/马.png", horse[i]);
            horse[i].setContentAreaFilled(false);
            horse[i].setBorder(null);
            horse[i].addActionListener(new chessActionListener());
        }
            horse[0].setLocation(getWidth() - 85-72, 31);
            horse[1].setLocation(31+72, 31);
            for (int i = 0; i < horse.length; i++) {
                jp.add(horse[i]);
            }

        //相
        for (int i = 0; i < PrimeMinister.length; i++) {
            image = new ImageIcon("chess/sucai/black/象.png");
            PrimeMinister[i] = new JButton(image);
            PrimeMinister[i].setSize(50, 50);
            setIcon("chess/sucai/black/象.png", PrimeMinister[i]);
            PrimeMinister[i].setContentAreaFilled(false);
            PrimeMinister[i].setBorder(null);
            PrimeMinister[i].addActionListener(e -> {
                System.out.println("1");
            });
        }
            PrimeMinister[0].setLocation(getWidth() - 85-72*2, 31);
            PrimeMinister[1].setLocation(31+72*2, 31);
            for (int i = 0; i < PrimeMinister.length; i++) {
                jp.add(PrimeMinister[i]);
            }

        //炮
        for (int i = 0; i < gun.length; i++) {
            image = new ImageIcon("chess/sucai/black/炮.png");
            gun[i] = new JButton(image);
            gun[i].setSize(50, 50);
            setIcon("chess/sucai/black/炮.png", gun[i]);
            gun[i].setContentAreaFilled(false);
            gun[i].setBorder(null);
            gun[i].addActionListener(e -> {
                System.out.println("1");
            });
        }
        gun[0].setLocation(getWidth() - 85 - 72, 31+72*2);
        gun[1].setLocation(31 + 72, 31+72*2);
        for (int i = 0; i < gun.length; i++) {
            jp.add(gun[i]);
        }

        // 士
        for (int i = 0; i < guard.length; i++) {
            image = new ImageIcon("chess/sucai/black/士.png");
            guard[i] = new JButton(image);
            guard[i].setSize(50, 50);
            setIcon("chess/sucai/black/士.png", guard[i]);
            guard[i].setContentAreaFilled(false);
            guard[i].setBorder(null);
            guard[i].addActionListener(e -> {
                System.out.println("1");
            });
        }
        guard[0].setLocation(getWidth() - 85 - 72*3, 31);
        guard[1].setLocation(31 + 72*3, 31);
        for (int i = 0; i < guard.length; i++) {
            jp.add(guard[i]);
        }

        //将军
        image = new ImageIcon("chess/sucai/black/将.png");
        boss = new JButton(image);
        boss.setSize(50, 50);
        setIcon("chess/sucai/black/将.png", boss);
        boss.setContentAreaFilled(false);
        boss.setBorder(null);
        boss.addActionListener(e -> {
            System.out.println("1");
        });
        boss.setLocation(31+72*4, 31);
        jp.add(boss);
    }

    /**
     * @see: 红色棋子
     * @car: 车
     * @horse: 马
     * @boss: 将
     * @gun: 炮
     * @guard: 士
     * @PrimeMinister: 相
     * @soldiers: 兵
     */
    private void redchess() {
        JButton[] car = new JButton[2];
        JButton[] horse = new JButton[2];
        JButton boss = new JButton();
        JButton[] soldiers = new JButton[5];
        JButton[] gun = new JButton[2];
        JButton[] guard = new JButton[2];
        JButton[] PrimeMinister = new JButton[2];
        ImageIcon image;
        // 车
        for (int i = 0; i < car.length; i++) {
            image = new ImageIcon("chess/sucai/red/车.png");
            car[i] = new JButton(image);
            car[i].setSize(50, 50);
            setIcon("chess/sucai/red/车.png", car[i]);
            car[i].setContentAreaFilled(false);
            car[i].setBorder(null);
            car[i].addActionListener(e -> {
                System.out.println("1");
            });
            
        }
        car[0].setLocation(getWidth()-85, getHeight()-90);
        car[1].setLocation(31, getHeight()-90);
        for (int i = 0; i < car.length; i++) {
            jp.add(car[i]);
        }
        

        // 兵
        for (int i = 0; i < soldiers.length; i++) {
            image = new ImageIcon("chess/sucai/red/兵.png");
            soldiers[i] = new JButton(image);
            soldiers[i].setSize(50, 50);
            setIcon("chess/sucai/red/兵.png", soldiers[i]);
            soldiers[i].setContentAreaFilled(false);
            soldiers[i].setBorder(null);
        }
        soldiers[0].setLocation(getWidth()-85, getHeight()-90-(3*72));
        soldiers[1].setLocation(getWidth()-85-72*2, getHeight()-90-(3*72));
        soldiers[2].setLocation(getWidth()-85-72*4, getHeight()-90-(3*72));
        soldiers[3].setLocation(getWidth()-85-72*6, getHeight()-90-(3*72));
        soldiers[4].setLocation(getWidth()-85-72*8, getHeight()-90-(3*72));
        System.out.println(getWidth()-85-72*8);
        for (int i = 0; i < soldiers.length; i++) {
            soldiers[i].addActionListener(e -> {
                System.out.println("1");
            });
            jp.add(soldiers[i]);
        }

        // 马
        for (int i = 0; i < horse.length; i++) {
            image = new ImageIcon("chess/sucai/red/马.png");
            horse[i] = new JButton(image);
            horse[i].setSize(50, 50);
            setIcon("chess/sucai/red/马.png", horse[i]);
            horse[i].setContentAreaFilled(false);
            horse[i].setBorder(null);
            horse[i].addActionListener(e -> {
                System.out.println("1");
            });
        }
            horse[0].setLocation(getWidth() - 85-72, getHeight() - 90);
            horse[1].setLocation(31+72, getHeight() - 90);
            for (int i = 0; i < horse.length; i++) {
                jp.add(horse[i]);
            }

        //相
        for (int i = 0; i < PrimeMinister.length; i++) {
            image = new ImageIcon("chess/sucai/red/相.png");
            PrimeMinister[i] = new JButton(image);
            PrimeMinister[i].setSize(50, 50);
            setIcon("chess/sucai/red/相.png", PrimeMinister[i]);
            PrimeMinister[i].setContentAreaFilled(false);
            PrimeMinister[i].setBorder(null);
            PrimeMinister[i].addActionListener(e -> {
                System.out.println("1");
            });
        }
            PrimeMinister[0].setLocation(getWidth() - 85-72*2, getHeight() - 90);
            PrimeMinister[1].setLocation(31+72*2, getHeight() - 90);
            for (int i = 0; i < PrimeMinister.length; i++) {
                jp.add(PrimeMinister[i]);
            }

        //炮
        for (int i = 0; i < gun.length; i++) {
            image = new ImageIcon("chess/sucai/red/炮.png");
            gun[i] = new JButton(image);
            gun[i].setSize(50, 50);
            setIcon("chess/sucai/red/炮.png", gun[i]);
            gun[i].setContentAreaFilled(false);
            gun[i].setBorder(null);
            gun[i].addActionListener(e -> {
                System.out.println("1");
            });
        }
        gun[0].setLocation(getWidth() - 85 - 72, getHeight() - 90-72*2);
        gun[1].setLocation(31 + 72, getHeight() - 90-72*2);
        for (int i = 0; i < gun.length; i++) {
            jp.add(gun[i]);
        }

        // 士
        for (int i = 0; i < guard.length; i++) {
            image = new ImageIcon("chess/sucai/red/士.png");
            guard[i] = new JButton(image);
            guard[i].setSize(50, 50);
            setIcon("chess/sucai/red/士.png", guard[i]);
            guard[i].setContentAreaFilled(false);
            guard[i].setBorder(null);
            guard[i].addActionListener(e -> {
                System.out.println("1");
            });
        }
        guard[0].setLocation(getWidth() - 85 - 72*3, getHeight() - 90);
        guard[1].setLocation(31 + 72*3, getHeight() - 90);
        for (int i = 0; i < guard.length; i++) {
            jp.add(guard[i]);
        }

        //将军
        image = new ImageIcon("chess/sucai/red/帅.png");
        boss = new JButton(image);
        boss.setSize(50, 50);
        setIcon("chess/sucai/red/帅.png", boss);
        boss.setContentAreaFilled(false);
        boss.setBorder(null);
        boss.addActionListener(e -> {
            System.out.println("1");
        });
        boss.setLocation(31+72*4, getHeight() - 90);
        jp.add(boss);
    }

    /**
     * @see: 背景图片，棋盘
     */
    private void chessboard() {
        ImageIcon bacakimageurl = new ImageIcon("chess/sucai/chessboard.png");
        setBounds(0, 0, bacakimageurl.getIconWidth(), bacakimageurl.getIconHeight());
        JLabel backimage = new JLabel(bacakimageurl);
        backimage.setBounds(0, 0, bacakimageurl.getIconWidth(), bacakimageurl.getIconHeight());
        jp = (JPanel) this.getContentPane();
        jp.setOpaque(false);
        jp.setLayout(null);
        add(backimage);
        this.getLayeredPane().add(backimage, new Integer(Integer.MIN_VALUE));
    }

    /**
     * 
     * @param file: 图片路径
     * @param com: 按钮
     */
    public void setIcon(String file, JButton com) {
        ImageIcon ico = new ImageIcon(file);
        Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), ico.getImage().SCALE_DEFAULT);
        ico = new ImageIcon(temp);
        com.setIcon(ico);
    }

    // private class chessActionListener implements ActionListener{

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         (JButton)e = e.setLocation(MAXIMIZED_BOTH, ABORT);
    //     }
        
    // }
}
