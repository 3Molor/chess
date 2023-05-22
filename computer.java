import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * computer
 */
public class computer extends JFrame {

    String[] jparrs = { "%", "CE", "C", "backspace", "1/x", "x^2", "2√x", "÷", "7", "8", "9", "×", "4", "5", "6", "-",
            "1", "2", "3", "+", "±", "0", ".", "=" };
    JTextField textField;
    JButton[] buttons;
    double result = 0;
    String operator = "="; // 运算符
    boolean start = true; // 是否开始输入

    public computer(String title) {
        super(title);
        setSize(335, 510);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setResizable(false);
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(6, 4, 5, 5));

        buttons = new JButton[jparrs.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(jparrs[i]);
            buttons[i].setSize(80, 70);
            buttons[i].addActionListener(new MyActionListener());
            jp.add(buttons[i]);
        }
        textField = new JTextField("0") {
            public void setPreferredSize(Dimension preferredSize) {
                textField.setPreferredSize(new Dimension(50, 50));
            }
        };
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        getContentPane().add(jp, BorderLayout.SOUTH);
        getContentPane().add(textField, BorderLayout.NORTH);
        setVisible(true);
    }

    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            System.out.println(input);
            if (".0123456789".indexOf(input) >= 0) {
                if (start) {
                    textField.setText(input);
                } else {
                    textField.setText(textField.getText() + input);
                }
                start = false;
            } else if (input.equals("CE")) {
                textField.setText("0");
                start = true;
            } else if (input.equals("C")) {
                textField.setText("0");
                start = true;
                result = 0;
            } else if (input.equals("backspace")) {
                textField.setText(textField.getText().substring(0, textField.getText().length()-1));
            } else{
                if (start) {
                    if (input.equals("-")) {
                        textField.setText(input);
                        start = false;
                    } else {
                        operator = input;
                    }
                } else {
                    double x = Double.parseDouble(textField.getText());
                    Calculate(x);
                    operator = input;
                    start = true;
                }
            }
        }

        private void Calculate(double x) {
            switch (operator) {
                case "+":
                    result += x;
                    break;
                case "-":
                    result -= x;
                    break;
                case "×":
                    result *= x;
                    break;
                case "÷":
                    result /= x;
                    break;
                case "%":
                    result %= x;
                    break;
                case "±":
                    result = 0 - x;
                    break;
                case "1/x":
                    result = 1 / x;
                    break;
                case "x^2":
                    result = Math.pow(x, 2);
                    break;
                case "2√x":
                    result = Math.sqrt(x);
                    break;
                case "=":
                    result = x;
                    break;
            }
                textField.setText("" + result);
        }
    }

}