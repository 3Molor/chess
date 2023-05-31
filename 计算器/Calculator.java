package 计算器;
// 导入swing和awt包
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 定义一个计算器类，继承JFrame类
public class Calculator extends JFrame {

    // 定义组件
    private JTextField textField; // 显示框
    private JButton[] buttons; // 按钮数组
    private String[] labels = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/"}; // 按钮标签
    private double result = 0; // 计算结果
    private String operator = "="; // 运算符
    private boolean start = true; // 是否开始输入

    // 构造方法，设置窗口属性和布局
    public Calculator() {
        // 设置窗口标题
        super("计算器");
        // 设置窗口大小
        setSize(300, 300);
        // 设置窗口位置居中
        setLocationRelativeTo(null);
        // 设置窗口关闭时退出程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // 设置窗口不可调整大小
        setResizable(false);

        // 创建一个面板，用网格布局放置按钮
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // 创建按钮数组，并添加监听器
        buttons = new JButton[16];
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(labels[i]);
            buttons[i].addActionListener(new MyListener());
            panel.add(buttons[i]);
        }

        // 创建显示框，并设置属性
        textField = new JTextField("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        // 将显示框和面板添加到窗口中
        getContentPane().add(textField, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.CENTER);

        // 显示窗口
        setVisible(true);
    }

    // 定义一个内部类，实现ActionListener接口，处理按钮事件
    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // 获取按钮的标签
            String input = e.getActionCommand();
            // 如果是数字或小数点，拼接到显示框中
            if ("0123456789.".indexOf(input) >= 0) {
                if (start) {
                    textField.setText(input);
                } else {
                    textField.setText(textField.getText() + input);
                }
                start = false;
            } else { // 如果是运算符，进行计算并更新显示框和运算符
                if (start) {
                    if (input.equals("-")) { // 如果是负号，拼接到显示框中
                        textField.setText(input);
                        start = false;
                    } else { // 否则，更新运算符
                        operator = input;
                    }
                } else {
                    double x = Double.parseDouble(textField.getText()); // 获取显示框中的数字
                    calculate(x); // 调用calculate方法进行计算
                    operator = input; // 更新运算符
                    start = true; // 开始新的输入
                }
            }
        }
    }

    // 定义一个计算方法，根据运算符进行相应的运算，并更新结果和显示框
    private void calculate(double n) {
        switch (operator) {
            case "+":
                result += n;
                break;
            case "-":
                result -= n;
                break;
            case "*":
                result *= n;
                break;
            case "/":
                result /= n;
                break;
            case "=":
                result = n;
                break;
        }
        textField.setText("" + result); // 更新显示框
    }

    // 主方法，创建一个计算器对象
    public static void main(String[] args) {
        new Calculator();
    }
}
