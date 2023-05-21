

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    public MyFrame(String title) {
        super(title);

        this.setLayout(new BorderLayout());
        setSize(250, 300);
        setLocation(400, 400);

        JPanel jPanel = new JPanel(new GridLayout(4, 4, 10, 25));
        JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JTextField jTextField = new JTextField(20);
        // 用来记录用户输入的数字和字符串
        List<String> lists = new ArrayList<>();
        jPanel.add(jTextField);

        String[] strings = new String[] { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", ".", "0", "=",
                "/" };
        String[] st = new String[] { "AC", "BECK", "CE" };

        // 添加按键 AC BECE CE
        JButton AC = new JButton(st[0]);    //全部清空
        JButton Beck = new JButton(st[1]);  //删除一个数
        JButton CE = new JButton(st[2]);    //清空当前数

        // 将上边三个按钮添加到面板
        jPanel1.add(AC);
        jPanel1.add(Beck);
        jPanel1.add(CE);

        // 添加按钮123456789
        JButton jButton1 = new JButton(strings[0]);
        JButton jButton2 = new JButton(strings[1]);
        JButton jButton3 = new JButton(strings[2]);
        JButton add = new JButton(strings[3]);
        JButton jButton4 = new JButton(strings[4]);
        JButton jButton5 = new JButton(strings[5]);
        JButton jButton6 = new JButton(strings[6]);
        JButton sum = new JButton(strings[7]);
        JButton jButton7 = new JButton(strings[8]);
        JButton jButton8 = new JButton(strings[9]);
        JButton jButton9 = new JButton(strings[10]);
        JButton Chenfa = new JButton(strings[11]);
        JButton Point = new JButton(strings[12]);
        JButton jButton0 = new JButton(strings[13]);
        JButton result = new JButton(strings[14]);
        JButton ChuFa = new JButton(strings[15]);

        // 将按钮添加到面板上
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(add);
        jPanel.add(jButton4);
        jPanel.add(jButton5);
        jPanel.add(jButton6);
        jPanel.add(sum);
        jPanel.add(jButton7);
        jPanel.add(jButton8);
        jPanel.add(jButton9);
        jPanel.add(Chenfa);
        jPanel.add(Point);
        jPanel.add(jButton0);
        jPanel.add(result);
        jPanel.add(ChuFa);
        // 将面板加到容器里边

        this.add(jTextField, BorderLayout.PAGE_START);
        this.add(jPanel1, BorderLayout.CENTER);
        this.add(jPanel, BorderLayout.PAGE_END);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // 添加AC监听器
        AC.addActionListener(e -> {
            lists.clear();
            jTextField.setText("");
        });
        // 添加Beck监听器
        Beck.addActionListener(e -> {
            String text = jTextField.getText(); // 得到文本框
            // 如果文本框的内容是空或者长度是一，直接将文本框的内容设置为空
            if ("".equals(text) || text.length() == 1) {
                jTextField.setText("");
                return;
            }
            // 如果文本的长度大于1就要向前截取
            if (text.length() > 1) {
                text = text.substring(0, text.length() - 1);
                jTextField.setText(text);
            }
        });

        // 添加CE监听器
        CE.addActionListener(e -> {
            String text = jTextField.getText();
            if ("".equals(text)) {
                return;
            }
            // 将加减乘除，防止出现错误
            if ("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                lists.remove(0);
            }
            // 直接将文本框清空
            jTextField.setText("");

        });

        // 添加数字按钮的监听器
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextField.getText();

                if ("除数不能为0".equals(text)) {
                    jTextField.setText(e.getActionCommand());
                    return;
                }

                if ("0".equals(text)) {
                    return;
                }

                if ("".equals(text)) {
                    jTextField.setText(e.getActionCommand());
                } else {
                    if (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")) {
                        lists.add(text);
                        jTextField.setText("");
                        // 将文本框中的数字设为0
                        text = "";
                    }
                    text += e.getActionCommand();
                    jTextField.setText(text);
                }
            };
        };

        // 为数字设置监听器
        jButton1.addActionListener(actionListener);
        jButton2.addActionListener(actionListener);
        jButton3.addActionListener(actionListener);
        jButton4.addActionListener(actionListener);
        jButton5.addActionListener(actionListener);
        jButton6.addActionListener(actionListener);
        jButton7.addActionListener(actionListener);
        jButton8.addActionListener(actionListener);
        jButton9.addActionListener(actionListener);

        // 为0设置监听器
        jButton0.addActionListener(e -> {
            String text = jTextField.getText();
            // 如果是0 ，就不可以再为0
            if ("0".equals(text)) {
                return;
            }
            // 如果是 +-*/
            if ("+".equals("+") || "-".equals("-") || "*".equals("*") || "/".equals("/")) {
                lists.add(text);
                text = "";
            }
            text += e.getActionCommand();
            jTextField.setText(text);
        });

        // 为小数点设置监听器
        Point.addActionListener(e -> {
            String text = jTextField.getText();
            if ("0".equals(text)) {
                return;
            }
            // 判断是否是+-*/
            if ("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                return;
            }
            // 数字后面不能同时出现两个小数点
            if (text.contains(".")) {
                return;
            }
            text = text + e.getActionCommand();
            jTextField.setText(text);
        });

        // 为加减乘除设置监听器
        ActionListener actionListener1 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextField.getText();
                if ("".equals(text)) {
                    return;
                }
                if ("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                    return;
                }
                // 将内容添加到集合里
                lists.add(text);
                // 将文本框清空
                jTextField.setText("");
                // 获取按键上的数字
                jTextField.setText(e.getActionCommand());
            }
        };
        // 为加减乘除设置监听器
        sum.addActionListener(actionListener1);
        add.addActionListener(actionListener1);
        Chenfa.addActionListener(actionListener1);
        ChuFa.addActionListener(actionListener1);

        // 为= 添加监听器
        ActionListener actionListener2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (lists.isEmpty()) {
                    return;
                }
                String text = jTextField.getText();
                if ("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                    return;
                }
                // 将其添加在集合里
                lists.add(text);
                if (lists.size() < 3) {
                    return;
                }
                String one = lists.get(0); // 获取集合的第一个数
                String two = lists.get(1); // 获取集合的第二个数
                String three = lists.get(2); // 获取集合的第三个数
                switch (two) {
                    case "+":
                        // Double 类中有一个parseDouble(),
                        double i = Double.parseDouble(one);
                        double j = Double.parseDouble(three);
                        jTextField.setText((i + j) + "");
                        break;
                    case "-":
                        double x = Double.parseDouble(one);
                        double y = Double.parseDouble(three);
                        jTextField.setText((x - y) + "");
                        break;
                    case "*":
                        double m = Double.parseDouble(one);
                        double n = Double.parseDouble(three);
                        jTextField.setText((m * n) + "");
                        break;
                    case "/":
                        double k = Double.parseDouble(one);
                        double z = Double.parseDouble(three);
                        if (z == 0) {
                            jTextField.setText("除数不为0");
                            lists.clear();
                            return;
                        }
                        jTextField.setText((k / z) + "");
                        break;
                }
                // 将集合清空
                lists.clear();
            }
        };

        // 为等号添加监听器
        result.addActionListener(actionListener2);
    }

    public static void main(String[] args) {

        JFrame jsq = new MyFrame("计算器");
    }
}