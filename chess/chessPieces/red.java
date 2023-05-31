package chess.chessPieces;

import java.awt.*;
import javax.swing.*;

/**
 * red
 */
public class red extends JButton{

    public red() {

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
    public red(JPanel jp) {
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
        car[0].setLocation(35 + 8 * 71, 30 + 9 * 72);
        car[1].setLocation(35, 30 + 9 * 72);
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
        soldiers[0].setLocation(35, 30 + 72 * 6);
        soldiers[1].setLocation(35+ 71 * 2, 30 + 72 * 6);
        soldiers[2].setLocation(35+ 71 * 4, 30 + 72 * 6);
        soldiers[3].setLocation(35+ 71 * 6, 30 + 72 * 6);
        soldiers[4].setLocation(35+ 71 * 8, 30 + 72 * 6);
        for (int i = 0; i < soldiers.length; i++) {
            soldiers[i].addActionListener(e ->{
                JButton white = new JButton();
                JButton btn = (JButton) e.getSource();
                Point XY = btn.getLocation();
                int X = (int) XY.getX();
                int Y = (int) XY.getY();
                white.setSize(30, 30);
                setIcon("chess/sucai/路径点.png", white);
                white.setContentAreaFilled(false);
                white.setBorder(null);
                white.setLocation(X + 10, Y - 63);
                jp.add(white);
                white.addActionListener(o -> {
                    btn.setLocation(white.getX() - 10, white.getY() - 10);
                    jp.remove(white);
                });
                jp.repaint();
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
        horse[0].setLocation(35 + 71, 30 + 72 * 9);
        horse[1].setLocation(35 + 71 * 7, 30 + 72 * 9);
        for (int i = 0; i < horse.length; i++) {
            jp.add(horse[i]);
        }

        // 相
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
        PrimeMinister[0].setLocation(35 + 71 * 2, 30 + 72 * 9);
        PrimeMinister[1].setLocation(35 + 71 * 6, 30 + 72 * 9);
        for (int i = 0; i < PrimeMinister.length; i++) {
            jp.add(PrimeMinister[i]);
        }

        // 炮
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
        gun[0].setLocation(35 + 71, 30 + 72 * 7);
        gun[1].setLocation(35 + 71 * 7, 30 + 72 * 7);
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
        guard[0].setLocation(35 + 71 * 5, 30 + 72 * 9);
        guard[1].setLocation(35 + 71 * 3, 30 + 72 * 9);
        for (int i = 0; i < guard.length; i++) {
            jp.add(guard[i]);
        }

        // 将军
        image = new ImageIcon("chess/sucai/red/帅.png");
        boss = new JButton(image);
        boss.setSize(50, 50);
        setIcon("chess/sucai/red/帅.png", boss);
        boss.setContentAreaFilled(false);
        boss.setBorder(null);
        boss.addActionListener(e -> {
            System.out.println("1");
        });
        boss.setLocation(35 + 71 * 4, 30 + 72 * 9);
        jp.add(boss);
    }

    public void setIcon(String file, JButton com) {
        ImageIcon ico = new ImageIcon(file);
        ico.getImage();
        Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), Image.SCALE_DEFAULT);
        ico = new ImageIcon(temp);
        com.setIcon(ico);
    }
}
