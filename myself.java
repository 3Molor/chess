package Jisuanqi;

import javax.print.attribute.standard.PrinterMakeAndModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class myself extends JFrame{
    private String[] nums = new String[]{"C","1","2","3","+","4","5","6","-","7","8","9","*",".","0","=","/"};
    private double result = 0;//结果默认值为0
    private String operator = "=";//结果运算符
    private boolean start = true; // 是否开始输入
    JTextField field = new JTextField(11);
    public myself(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel root = new JPanel();
        root.setBackground(new Color(209,183,241));
        this.setContentPane(root);
        this.setLocationRelativeTo(null);
        field.setBackground(new Color(255,190,185));
        root.add(field);
        field.setEditable(true); //文本框是否显示
        JButton button[] = new JButton[17];
        //使用for循环将nums数组中的字符串一个一个依次加入测试窗口
        for(int i = 0;i < button.length;i++){
            button[i] = new JButton(nums[i]);           
            button[i].addActionListener(new anjian());
            button[i].setBackground(new Color(255,190,185));
            // button[i].setForeground(new Color(245,231,45));
            root.add(button[i]);
        }
        
        this.setSize(200, 230);
        this.setVisible(true);
    }
    //设置一个按键使用代码的内部类
    class anjian implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //获取按键的标签
            String input = e.getActionCommand();
            // 如果是数字或小数点，拼接到显示框中
            if("0123456789.".indexOf(input) >= 0){
                if(start){
                    field.setText(input);
                }else{  //大于9的数字将前后两个数拼接在一起
                    field.setText(field.getText() + input);
                }
                start = false;
            }else{ //如果是运算符，进行计算并更新显示框和运算符
                if(start){
                    if(input.equals("+")){
                        field.setText(input);
                        start = false;//输入结束
                    }else if(input.equals("C")){  
                    //如果符号为C,文本框内的数字将会清零
                        result = 0;
                        field.setText("" + result);
                    }else{
                        //更新运算符
                        operator = input;
                    }
                }else{
                    //将字符串转化为数字类型
                    double b = Double.valueOf(field.getText());
                    print (b); // 调用print方法进行计算
                    operator = input;
                    start = true; // 开始新的输入
                }
            }
        }
    }
    
    //符号的运行代码
    public void print(double n){   
        switch(operator){
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
            default:
                result = 0;
                break;
        }
        field.setText("" + result);
    }

    public static void main(String[] args) {
        new myself("计算器");
    }
}
