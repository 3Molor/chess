
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class computer extends JFrame implements ActionListener {

    JPanel jp1, jp2;
    JTextField jtf;
    JLabel jl;
    JButton jbn1, jbn2, jbn3, jbn4, jbn5, jbn6, jbn7, jbn8, jbn9, jbn0;
    JButton jba, jbs, jbm, jbd, jbe, jbc;

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    double num3 = 0;
    int op = 0;

    public computer() {

        jp1 = new JPanel();
        jtf = new JTextField(20);
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        jp1.add(jtf);

        jl = new JLabel();
        jp1.add(jl);

        jp2 = new JPanel();
        jp2.setLayout(new GridLayout(4, 4, 8, 8));
        // 添加数字键
        jbn1 = new JButton("1");
        jbn1.addActionListener(this);
        jp2.add(jbn1);
        jbn2 = new JButton("2");
        jbn2.addActionListener(this);
        jp2.add(jbn2);
        jbn3 = new JButton("3");
        jbn3.addActionListener(this);
        jp2.add(jbn3);
        jba = new JButton("+");
        jba.addActionListener(this);
        jp2.add(jba);
        jbn4 = new JButton("4");
        jbn4.addActionListener(this);
        jp2.add(jbn4);
        jbn5 = new JButton("5");
        jbn5.addActionListener(this);
        jp2.add(jbn5);
        jbn6 = new JButton("6");
        jbn6.addActionListener(this);
        jp2.add(jbn6);
        jbs = new JButton("-");
        jbs.addActionListener(this);
        jp2.add(jbs);
        jbn7 = new JButton("7");
        jbn7.addActionListener(this);
        jp2.add(jbn7);
        jbn8 = new JButton("8");
        jbn8.addActionListener(this);
        jp2.add(jbn8);
        jbn9 = new JButton("9");
        jbn9.addActionListener(this);
        jp2.add(jbn9);

        // 添加 加减乘除等于清零

        jbm = new JButton("*");
        jbm.addActionListener(this);
        jp2.add(jbm);
        jbd = new JButton("/");
        jbd.addActionListener(this);
        jp2.add(jbd);
        jbn0 = new JButton("0");
        jbn0.addActionListener(this);
        jp2.add(jbn0);
        jbe = new JButton("=");
        jbe.addActionListener(this);
        jp2.add(jbe);
        jbc = new JButton("C");
        jbc.addActionListener(this);
        jp2.add(jbc);
        // 设置窗口属性
        this.setTitle("计算器");
        this.add(jp1, BorderLayout.NORTH);
        this.add(jp2, BorderLayout.CENTER);

        this.setSize(335, 510);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String input = btn.getText();

        if (input.equals("+")) {
            num1 = Double.parseDouble(jtf.getText());
            jtf.setText("");
            op = 1;
            jl.setText(String.valueOf(result));
            result = num3 + num1;
        } else if (input.equals("-")) {
            num1 = Double.parseDouble(jtf.getText());
            jtf.setText("");
            op = 2;
            result = num3 - num1;
            jl.setText(String.valueOf(result));
        } else if (input.equals("*")) {
            num1 = Double.parseDouble(jtf.getText());
            jtf.setText("");
            op = 3;
            result = num3 * num1;
            jl.setText(String.valueOf(result));
        } else if (input.equals("/")) {
            num1 = Double.parseDouble(jtf.getText());
            jtf.setText("");
            op = 4;
            result = num3 / num1;
            jl.setText(String.valueOf(result));
        } else if (input.equals("C")) {
            num1 = 0;
            num2 = 0;
            num3 = 0;
            result = 0;
            jtf.setText("");
            op = 0;
            jl.setText(String.valueOf(result));
        } else if (input.equals("=")) {
            num2 = Double.parseDouble(jtf.getText());
            switch (op) {
                case 1:
                    result = result + num2;
                    break;
                case 2:
                    result = result - num2;
                    break;
                case 3:
                    result = result * num2;
                    break;
                case 4:
                    result = result / num2;
                    break;
                default:
                    result = 0;
                    break;
            }
            jtf.setText(String.valueOf(result));
        } else {
            String sc = jtf.getText();
            sc += input;
            jtf.setText(sc);
            jl.setText(String.valueOf(result));
        }

        num3 = num1;

    }

    public static void main(String[] args) {
        new computer();
    }

}