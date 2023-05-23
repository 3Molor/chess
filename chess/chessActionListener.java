package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chessActionListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();
        int width = btn.getWidth();
        int height = btn.getHeight();

        
    }

    public void setIcon(String file, JButton com) {
        ImageIcon ico = new ImageIcon(file);
        Image temp = ico.getImage().getScaledInstance(com.getWidth(), com.getHeight(), ico.getImage().SCALE_DEFAULT);
        ico = new ImageIcon(temp);
        com.setIcon(ico);
    }
    
}
