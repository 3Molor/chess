// 一个简单的Java计算器代码，可以处理多个数
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    // 定义一些组件
    private JTextField display; // 显示器
    private JButton[] digitButtons; // 数字按钮
    private JButton[] operatorButtons; // 运算符按钮
    private JButton clearButton; // 清除按钮
    private JButton equalButton; // 等号按钮

    // 定义一些变量
    private double number; // 当前输入的数
    private double memValue; // 前面输入数的结果
    private char op; // 当前的运算符
    private boolean setClear; // 是否清空显示器

    // 定义一些常量
    private static final int FRAME_WIDTH = 300; // 窗口宽度
    private static final int FRAME_HEIGHT = 400; // 窗口高度
    private static final int BUTTON_SIZE = 50; // 按钮大小
    private static final int GAP = 10; // 间隙大小
    private static final String[] DIGIT_TEXTS = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "+/-"}; // 数字按钮文本
    private static final String[] OPERATOR_TEXTS = {"/", "*", "-", "+", "%", "sqrt", "1/x"}; // 运算符按钮文本

    // 构造方法
    public Calculator() {
        super("Calculator"); // 调用父类构造方法，设置窗口标题
        initComponents(); // 初始化组件
        initLayout(); // 初始化布局
        initListeners(); // 初始化监听器
        initVariables(); // 初始化变量
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时退出程序
        setSize(FRAME_WIDTH, FRAME_HEIGHT); // 设置窗口大小
        setLocationRelativeTo(null); // 设置窗口居中显示
        setVisible(true); // 设置窗口可见
    }

    // 初始化组件的方法
    private void initComponents() {
        display = new JTextField("0"); // 创建显示器，并设置初始文本为0
        display.setHorizontalAlignment(JTextField.RIGHT); // 设置文本右对齐
        display.setEditable(false); // 设置文本不可编辑

        digitButtons = new JButton[DIGIT_TEXTS.length]; // 创建数字按钮数组
        for (int i = 0; i < digitButtons.length; i++) {
            digitButtons[i] = new JButton(DIGIT_TEXTS[i]); // 创建数字按钮，并设置文本为对应的值
            digitButtons[i].setForeground(Color.BLUE); // 设置数字按钮的前景色为蓝色
        }

        operatorButtons = new JButton[OPERATOR_TEXTS.length]; // 创建运算符按钮数组
        for (int i = 0; i < operatorButtons.length; i++) {
            operatorButtons[i] = new JButton(OPERATOR_TEXTS[i]); // 创建运算符按钮，并设置文本为对应的值
            operatorButtons[i].setForeground(Color.RED); // 设置运算符按钮的前景色为红色
        }

        clearButton = new JButton("C"); // 创建清除按钮，并设置文本为C
        clearButton.setForeground(Color.RED); // 设置清除按钮的前景色为红色

        equalButton = new JButton("="); // 创建等号按钮，并设置文本为=
        equalButton.setForeground(Color.RED); // 设置等号按钮的前景色为红色

        add(display); // 将显示器添加到窗口中

        for (JButton button : digitButtons) { // 遍历数字按钮数组
            add(button); // 将每个数字按钮添加到窗口中
        }

        for (JButton button : operatorButtons) { // 遍历运算符按钮数组
            add(button); // 将每个运算符按钮添加到窗口中
        }

        add(clearButton); // 将清除按钮添加到窗口中
        add(equalButton); // 将等号按钮添加到窗口中
    }

    // 初始化布局的方法
    private void initLayout() {
        setLayout(null); // 设置窗口的布局为null，即绝对布局

        // 设置显示器的位置和大小
        display.setBounds(GAP, GAP, FRAME_WIDTH - 2 * GAP, BUTTON_SIZE);

        // 设置数字按钮的位置和大小
        int x = GAP; // x坐标
        int y = GAP + BUTTON_SIZE + GAP; // y坐标
        for (int i = 0; i < digitButtons.length; i++) {
            digitButtons[i].setBounds(x, y, BUTTON_SIZE, BUTTON_SIZE); // 设置每个数字按钮的位置和大小
            x += BUTTON_SIZE + GAP; // 更新x坐标
            if ((i + 1) % 3 == 0) { // 如果是每行的最后一个按钮
                x = GAP; // 重置x坐标为初始值
                y += BUTTON_SIZE + GAP; // 更新y坐标
            }
        }

        // 设置运算符按钮的位置和大小
        x = FRAME_WIDTH - GAP - BUTTON_SIZE; // x坐标
        y = GAP + BUTTON_SIZE + GAP; // y坐标
        for (int i = 0; i < operatorButtons.length; i++) {
            operatorButtons[i].setBounds(x, y, BUTTON_SIZE, BUTTON_SIZE); // 设置每个运算符按钮的位置和大小
            y += BUTTON_SIZE + GAP; // 更新y坐标
            if ((i + 1) % 2 == 0) { // 如果是每列的最后一个按钮
                x -= BUTTON_SIZE + GAP; // 更新x坐标
                y = GAP + BUTTON_SIZE + GAP; // 重置y坐标为初始值
            }
        }

        // 设置清除按钮的位置和大小
        clearButton.setBounds(GAP, FRAME_HEIGHT - GAP - BUTTON_SIZE, 2 * BUTTON_SIZE + GAP, BUTTON_SIZE);

        // 设置等号按钮的位置和大小
        equalButton.setBounds(FRAME_WIDTH - GAP - 2 * BUTTON_SIZE - GAP, FRAME_HEIGHT - GAP - BUTTON_SIZE, 2 * BUTTON_SIZE + GAP, BUTTON_SIZE);
    }

    // 初始化监听器的方法
    private void initListeners() {
        for (JButton button : digitButtons) { // 遍历数字按钮数组
            button.addActionListener(this); // 给每个数字按钮添加动作监听器，实现ActionListener接口的类可以作为参数传递，这里是当前类的对象this
        }

        for (JButton button : operatorButtons) { // 遍历运算符按钮数组
            button.addActionListener(this); // 给每个运算符按钮添加动作监听器，实现ActionListener接口的类可以作为参数传递，这里是当前类的对象this
        }

        clearButton.addActionListener(this); // 给清除按钮添加动作监听器，实现ActionListener接口的类可以作为参数传递，这里是当前类的对象this

        equalButton.addActionListener(this); // 给等号按钮添加动作监听器，实现ActionListener接口的类可以作为参数传递，这里是当前类的对象this

    }

    // 初始化变量的方法
    private void initVariables() {
        number = 0; // 初始化当前输入的数为0
        memValue = 0; // 初始化前面输入数的结果为0
        op = ' '; // 初始化当前的运算符为空格字符（表示没有运算符）
        setClear = true; // 初始化是否清空显示器为true（表示需要清空）
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取触发事件的组件
        Object source = e.getSource();

        // 如果是数字按钮
        if (source instanceof JButton && contains(DIGIT_TEXTS, ((JButton) source).getText())) {
            // 获取按钮的文本
            String text = ((JButton) source).getText();

            // 如果是小数点
            if (text.equals(".")) {
                // 如果显示器已经有小数点，就不再添加
                if (display.getText().contains(".")) {
                    return;
                }
            }

            // 如果是正负号
            if (text.equals("+/-")) {
                // 如果显示器的文本是0，就不改变符号
                if (display.getText().equals("0")) {
                    return;
                }

                // 如果显示器的文本已经有负号，就去掉它
                if (display.getText().startsWith("-")) {
                    display.setText(display.getText().substring(1));
                } else { // 否则，就在前面加上负号
                    display.setText("-" + display.getText());
                }
                return;
            }

            // 如果需要清空显示器，就把显示器的文本设为按钮的文本，否则就在后面追加按钮的文本
            if (setClear) {
                display.setText(text);
            } else {
                display.setText(display.getText() + text);
            }

            // 把是否清空显示器设为false
            setClear = false;
        }

        // 如果是运算符按钮
        if (source instanceof JButton && contains(OPERATOR_TEXTS, ((JButton) source).getText())) {
            // 获取按钮的文本
            String text = ((JButton) source).getText();

            // 把显示器的文本转换为双精度数，并赋值给number变量
            number = Double.parseDouble(display.getText());

            // 根据op变量的值，执行相应的运算，并把结果赋值给memValue变量
            switch (op) {
                case '+':
                    memValue += number;
                    break;
                case '-':
                    memValue -= number;
                    break;
                case '*':
                    memValue *= number;
                    break;
                case '/':
                    memValue /= number;
                    break;
                case ' ':
                    memValue = number;
                    break;
            }

            // 把memValue变量的值转换为字符串，并显示在显示器上
            display.setText(String.valueOf(memValue));

            // 把按钮的文本赋值给op变量，表示当前的运算符
            op = text.charAt(0);

            // 把是否清空显示器设为true，表示下次输入数字时需要清空显示器
            setClear = true;
        }

        // 如果是清除按钮
        if (source == clearButton) {
            // 调用initVariables方法，初始化所有变量
            initVariables();

            // 把显示器的文本设为0
            display.setText("0");
        }
        // 如果是等号按钮
        if (source == equalButton) {
            // 把显示器的文本转换为双精度数，并赋值给number变量
            number = Double.parseDouble(display.getText());

            // 根据op变量的值，执行相应的运算，并把结果赋值给memValue变量
            switch (op) {
                case '+':
                    memValue += number;
                    break;
                case '-':
                    memValue -= number;
                    break;
                case '*':
                    memValue *= number;
                    break;
                case '/':
                    memValue /= number;
                    break;
            }

            // 把memValue变量的值转换为字符串，并显示在显示器上
            display.setText(String.valueOf(memValue));

            // 把op变量设为空格字符，表示没有运算符
            op = ' ';

            // 把是否清空显示器设为true，表示下次输入数字时需要清空显示器
            setClear = true;
        }
    }

    // 判断一个字符串数组是否包含一个字符串的方法
    private boolean contains(String[] array, String text) {
        for (String s : array) { // 遍历字符串数组
            if (s.equals(text)) { // 如果有一个字符串和text相等，就返回true
                return true;
            }
        }
        return false; // 否则，返回false
    }

    // 主方法，用于启动程序
    public static void main(String[] args) {
        new Calculator(); // 创建Calculator对象，调用构造方法
    }
}



