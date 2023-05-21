package 计算器;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import demo516.myframe;

public class CounterTest1 {
	
	String btn0 = "0";
	String btn1 = "1";
	String btn2 = "2";
	String btn3 = "3";
	String btn4 = "4";
	String btn5 = "5";
	String btn6 = "6";
	String btn7 = "7";
	String btn8 = "8";
	String btn9 = "9";
	String btnAdd = "+";
	String btnSub = "-";
	String btncheng = "*";
	String btnchu = "/";
	String btnDot = ".";
	String btndnegyu = "=";
	String btnDel = "C";
	
	String title;

	double result = 0 ;
	String stringResult = "";
	//设置文本框的大小为30
	TextField textField = new TextField(30);
	
	public CounterTest1() {
		
	}
	
	public CounterTest1 (String title){
		this.title = title;
	}
	
//创建页面	
	public void createFrame() {
		
		JFrame jf = new JFrame("计算器");

		jf.setLayout(new FlowLayout(FlowLayout.CENTER));

		jf.setSize(500,500);   //大小

		jf.setLocation(700,300);		//位置
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//关闭按钮
		
		//设置按钮7,8,9，+ 
		JPanel jP1 = new JPanel(new GridLayout(1,4,5,5));
		jP1.add(ActionButtonInput(btn7));
		jP1.add(ActionButtonInput(btn8));
		jP1.add(ActionButtonInput(btn9));
		jP1.add(ActionButtonInput(btnAdd));

		//设置按钮4,5,6，-
		JPanel jp2 = new JPanel(new GridLayout(1,4,5,5));
		jp2.add(ActionButtonInput(btn4));
		jp2.add(ActionButtonInput(btn5));
		jp2.add(ActionButtonInput(btn6));
		jp2.add(ActionButtonInput(btnSub));

		//设置按钮1,2,3，*
		JPanel jP3 = new JPanel(new GridLayout(1,4,5,5));
		jP3.add(ActionButtonInput(btn1));
		jP3.add(ActionButtonInput(btn2));
		jP3.add(ActionButtonInput(btn3));
		jP3.add(ActionButtonInput(btncheng));

		//设置按钮   清除，0，/ =
		JPanel jP4 = new JPanel(new GridLayout(1,4,5,5));
		jP4.add(ActionButtonInput(btnDot));
		jP4.add(ActionButtonInput(btn0));
		jP4.add(ActionButtonInput(btnchu));
		// 设置等于按钮
		jP4.add(ActionButtonEqu(btndnegyu));
		
		//设置删除按钮为一行一列，5个像素点
		JPanel jP5 = new JPanel(new GridLayout(1,1,5,5));
		jP5.add(DelButton(btnDel));
		// 创建横向Box布局
		Box box = Box.createVerticalBox();  
		//从上到下，将组件添加到box容器中
		box.add(textField);
		box.add(jP1);
		box.add(jp2);
		box.add(jP3);
		box.add(jP4);
		box.add(jP5);
		//将box布局添加到Frame容器中
		jf.setContentPane(box);
		//窗口显示出来
		jf.setVisible(true);
	}
	//对于button 的操作
	public JButton ActionButtonInput(String buttonName) {
		JButton button = new JButton(buttonName);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				stringResult =stringResult + buttonName;
				//将输入的计算数字在文本框中显示
				textField.setText(stringResult);
				//将输入的计算数字在控制台显示
				System.out.println(stringResult);
			}
		});
			return button;
	}
	//设置等于按钮	
	public JButton ActionButtonEqu(String buttonName) {
		JButton button = new JButton(buttonName);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				calculate();
				//将结果显示在文本框
				textField.setText(Double.toString(result));
				System.out.println(result);
			}
		});
		return button;
	}
	//计算输入的字符串
	 public	double calculate() {
		//得到输入字符串的数字和操作符
		 //转义字符相当于+，-，*，/
		 String regex0 = "(\\+)|(\\-)|(\\*)|(\\/)";
		//该语句定义一个正则表达式
		String regex1 = "[0-9]+|[0-9]+\\.[0-9]";
		
		//将输入的字符串按运算符（+，-, * , / ）分割出来  ，剩下数字
		String split1[] = stringResult.split(regex0);

		String split2[] = stringResult.split(regex1);
		String str[] = new String[split2.length];
			
		//格式化split2数组,
		int j = 0;
		for(int i = 0; i < split2.length; ++i) {
				
			if(split2[i].equals("."));
				
			else str[j++] = split2[i];
		}
			
		//计算结果
		double tresult = 0;
		for (int i = 0; i < split1.length; ++i) {
			if (i == 0) {
				//表示将从数组中得到的值转换成Double类型的数据
				tresult = Double.parseDouble(split1[i]);   
			}else {
				//判断进行什么操作
				if (str[i].equals("+"))
					tresult += Double.parseDouble(split1[i]);
				else if (str[i].equals("-"))
					tresult -= Double.parseDouble(split1[i]);
				else if (str[i].equals("*"))
					tresult *= Double.parseDouble(split1[i]);
				else if (str[i].equals("/"))
					tresult /= Double.parseDouble(split1[i]);
				else continue;
			}
		}
		this.result = tresult;		
		return result;
	}
	 //设置清除按钮监听器
	public JButton DelButton(String buttonName) {
		JButton button = new JButton(buttonName);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//将结果和文本框内容清除
				result = 0;
				stringResult = "";
				textField.setText(stringResult);
			}
		});
		return button;
	}
	public static void main(String[] args) {
		CounterTest1 test = new CounterTest1();
		test.createFrame();
	}
}