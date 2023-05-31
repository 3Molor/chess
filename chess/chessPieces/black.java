package chess.chessPieces;

import java.awt.*;
import javax.swing.*;

import chess.ActionListenner.BlackActionListener;

public class black {
    public black() {

    }

    public black(JPanel jp) {
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
            car[i].addActionListener(new BlackActionListener());
        }
        car[0].setLocation(35 + 8 * 72, 30);
        car[1].setLocation(35, 30);
        for (int i = 0; i < car.length; i++) {
            jp.add(car[i]);
        }

        // 兵
        for (int i = 0; i < soldiers.length; i++) {
            image = new ImageIcon("chess/sucai/black/卒.png");
            soldiers[i] = new JButton("卒", image);
            soldiers[i].setFont(new Font("楷体", 0, 0));
            ;
            soldiers[i].setIconTextGap(-10);
            soldiers[i].setSize(50, 50);
            setIcon("chess/sucai/black/卒.png", soldiers[i]);
            soldiers[i].setContentAreaFilled(false);
            soldiers[i].setBorder(null);
        }
        soldiers[0].setLocation(35, 30 + (3 * 72));
        soldiers[1].setLocation(35 + 71 * 2, 30 + (3 * 72));
        soldiers[2].setLocation(35 + 71 * 4, 30 + (3 * 72));
        soldiers[3].setLocation(35 + 71 * 6, 30 + (3 * 72));
        soldiers[4].setLocation(35 + 71 * 8, 30 + (3 * 72));
        for (int i = 0; i < soldiers.length; i++) {
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
        }
        horse[0].setLocation(35 + 7 * 71, 30);
        horse[1].setLocation(35 + 71, 30);
        for (int i = 0; i < horse.length; i++) {
            jp.add(horse[i]);
        }

        // 相
        for (int i = 0; i < PrimeMinister.length; i++) {
            image = new ImageIcon("chess/sucai/black/象.png");
            PrimeMinister[i] = new JButton();
            PrimeMinister[i].setSize(50, 50);
            setIcon("chess/sucai/black/象.png", PrimeMinister[i]);
            PrimeMinister[i].setContentAreaFilled(false);
            PrimeMinister[i].setBorder(null);
            PrimeMinister[i].addActionListener(e -> {
                System.out.println("1");
            });
        }
        PrimeMinister[0].setLocation(35 + 71 * 6, 30);
        PrimeMinister[1].setLocation(35 + 71 * 2, 30);
        for (int i = 0; i < PrimeMinister.length; i++) {
            jp.add(PrimeMinister[i]);
        }

        // 炮
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
        gun[0].setLocation(35 + 71 * 7, 30 + 72 * 2);
        gun[1].setLocation(35 + 71, 30 + 72 * 2);
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
        guard[0].setLocation(35 + 71 * 5, 30);
        guard[1].setLocation(35 + 71 * 3, 30);
        for (int i = 0; i < guard.length; i++) {
            jp.add(guard[i]);
        }

        // 将军
        image = new ImageIcon("chess/sucai/black/将.png");
        boss = new JButton(image);
        boss.setSize(50, 50);
        setIcon("chess/sucai/black/将.png", boss);
        boss.setContentAreaFilled(false);
        boss.setBorder(null);
        boss.addActionListener(e -> {
            System.out.println("1");
        });
        boss.setLocation(35 + 71 * 4, 30);
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
