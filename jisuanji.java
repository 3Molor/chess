import javax.swing.*;
import java.awt.*;

public class jisuanji {
    public static void main(String[] args) {
       //1、画一个窗口(桌子)
        JFrame frame =new JFrame("加减乘除计算器");
        JPanel panel=new JPanel();
        //2、 在窗口.上画组件 文本框,字符数量为10个
        JTextField onejTextField=new JTextField(10);
        JTextField twojTextField=new JTextField(10);
        //3、在窗口.上画组件按钮: 加减乘除
        JButton addButton=new JButton("+");
        JButton substract=new JButton("-");
        JButton multip1y=new JButton("*");
        JButton devide=new JButton("/");
        JTextField resultjTextField=new JTextField(10);
        //3、调整摆放组件位置
        panel.setLayout(null);
        onejTextField.setBounds(10,10,150,20);
        twojTextField. setBounds(10,30, 150,20); 
        resultjTextField.setBounds(10, 300 ,150,20);
        addButton.setBounds (10,70, 150,20);
        substract.setBounds(10, 90,150,20);
        multip1y.setBounds(10, 120, 150,20);
        devide.setBounds(10,150,150,20);
        //4、将这些组件组合在一起
        panel.add(onejTextField);
        panel.add(twojTextField);
        panel.add(resultjTextField);
        panel.add(addButton);
        panel.add( substract);
        panel.add(multip1y);
        panel.add(devide);
        frame.add(panel);
        //添加功能
        addButton.addActionListener(e -> {
            //获取文本框中的文字
            int one=Integer.parseInt(onejTextField.getText());
            int two=Integer.parseInt (twojTextField.getText());
            //将结果再存回去
            resultjTextField.setText(String.valueOf(one+two));
        });
        substract. addActionListener(e -> {
            //获取文本框中的文字
            int one=Integer.parseInt(onejTextField.getText());
            int two=Integer.parseInt(twojTextField.getText());
            //将结果再存回去
            resultjTextField.setText (String.valueOf(one-two));
        });
        multip1y.addActionListener(e -> {
            //获取文本框中的文字
            int one=Integer . parseInt( onejTextField.getText());
            int two=Integer. parseInt(twojTextField. getText());
            //将结果再存回去
            resultjTextField. setText (String. valueOf (one*two));
        });
        devide . addActionListener(e -> {
            //获取文本框中的文字
            int one=Integer.parseInt (onejTextField.getText());
            int two=Integer.parseInt(twojTextField.getText());
            //将结果再存回去
            resultjTextField. setText(String.valueOf(one/two));
        });
        //让窗口展示出来
        frame. setBounds(500, 360, 300,360);
        frame. setVisible(true);
        frame. setDefaultCloseOperation(3);
    }
}
