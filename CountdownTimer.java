
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountdownTimer extends JFrame {
    private JLabel timerLabel;
    private JButton startButton;
    private int timeRemaining;

    public CountdownTimer() {
        timerLabel = new JLabel("我的窗口");
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        JPanel panel = new JPanel();
        panel.add(timerLabel);
        panel.add(startButton);

        add(panel);
        pack();
        setVisible(true);
    }

    private void startTimer() {
        timeRemaining = 10; // set initial time
        Thread timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (timeRemaining > 0) {
                    try {
                        Thread.sleep(1000); // wait for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    timeRemaining--;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            timerLabel.setText("Time remaining: " + timeRemaining);
                        }
                    });
                }
                // perform necessary actions when timer reaches 0
            }
        });
        timerThread.start();
    }

    public static void main(String[] args) {
        new CountdownTimer();
    }
}