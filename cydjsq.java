package demo512;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//继承父类方法，重写ActionListener
public class cydjsq extends JFrame implements ActionListener {
	// 定义界面上的按钮控件
	String JBtton[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "×", ".", "0", "=", "÷" };
	// 定义字体
	Font font = new Font("粗体", Font.PLAIN, 20);
	// 定义面板,p1:输入框和qk ,p2:操作的按钮
	JPanel p1, p2;
	// 创建按钮数组
	JButton Jb[] = new JButton[JBtton.length];
	// 创建清空按钮
	JButton qk;
	// 创建输入框
	JTextField shuru;

    // 创建构造方法
	public cydjsq(){
		// 为每一个按钮进行点击事件
		for (int i = 0; i < JBtton.length; i++) {
			// 实例化并声明按钮名称
			Jb[i] = new JButton("" + JBtton[i]);
			// 设置字体
			Jb[i].setFont(font);
			// 设置按钮透明
			Jb[i].setContentAreaFilled(false);
			Jb[i].addActionListener(this);
		}
		// 布局
        
		p1 = new JPanel(new GridLayout(5, 5));
		// 把按钮添加到网格布局中
		for (int i = 0; i < JBtton.length; i++){
			p1.add(Jb[i]);
		}
		// 设置第2个面板
		p2 = new JPanel(new BorderLayout());
		// 为qk按钮赋值
		qk = new JButton("清空");

        //直接不显示
		qk.setContentAreaFilled(false);
		// 为qk按钮设置监听器
		qk.addActionListener(this);
		// 输入框
        //默认为0
		shuru = new JTextField("0");
		shuru.setFont(font);
        //面板添加清空和输入框
		p2.add(qk, "East");
		p2.add(shuru, "Center");

		this.add(p2, BorderLayout.NORTH);
		this.add(p1, BorderLayout.CENTER);
        this.setSize(400, 500);
		this.setTitle("陈雨私有计算器");
        this.setVisible(true);
	}

	public void actionPerformed(ActionEvent a) {
		// 返回按的按钮名
		String label = a.getActionCommand();
        //通过点击事件获取点击事件对象
		if (a.getSource() == qk){
			Reset();
            //数字和小数点拼接到文本框显示
        }else if ("0123456789.".indexOf(label) >= 0){
			RunNumber(label);
        }else
			RunOperator(label);
	}
	// 判断是否是第一次按数字
	boolean xs = true;
	public void RunNumber(String key) {
		if (xs){
			shuru.setText(key);
            //判断和
        }else if ((key.equals(".")) && (shuru.getText().indexOf(".") < 0)){
			shuru.setText(shuru.getText() + ".");
        }else if (!key.equals("."))
			shuru.setText(shuru.getText() + key);
		xs = false;
	}
	double number = 0;
	String operator = "=";
    //清空按钮的设置
	public void Reset() {
		shuru.setText("0");
		xs = true;
		operator = "=";
	}
	public void RunOperator(String key) {
		if (operator.equals("+")){
			// 将文本框中的字符串强制转化为Double类型
			number += Double.valueOf(shuru.getText());
        }else if (operator.equals("-")){
			number -= Double.valueOf(shuru.getText());
        }else if (operator.equals("×")){
			number *= Double.valueOf(shuru.getText());
		}else if (operator.equals("÷")) {
			number /= Double.valueOf(shuru.getText());
		}else if (operator.equals("="))
			number = Double.valueOf(shuru.getText());
			
		shuru.setText(String.valueOf(number));
		operator = key;
		xs = true;
	}

	public static void main(String[] args) {
		new cydjsq();
	}
}