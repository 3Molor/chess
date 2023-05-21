package 项目;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
// import javax.swing.SwingConstants;

// import 包装类.Int;

// import java.awt.BorderLayout;
// import java.awt.Dimension;
// import java.awt.LayoutManager;
// import java.awt.Color;

public class MyJafeam extends JFrame {
    JTextField read = new JTextField("请输入要计算的数字");
    JTextField read1 = new JTextField("请输入要计算的数字");
    
    JTextField read2 = new JTextField("得到的结果是");
    public MyJafeam(String title) {
        super(title);
        JPanel root = new JPanel();
        JLabel jl = new JLabel("输入计算数字");
        
        JLabel j2 = new JLabel("输入计算数字");
        
        read.getPreferredSize();
        // LayoutManager layou = new BorderLayout();
        // root.setLayout(layou);

        this.setContentPane(root);
        JButton look = new JButton("提交");
        JButton look1 = new JButton("提交");
        JButton look2 = new JButton("加");
        JButton look3 = new JButton("减");
        JButton look4 = new JButton("乘");
        JButton look5 = new JButton("除");
        // root.add(new MyColorLabel("计算器",Color.pink), BorderLayout.NORTH);
        root.add(jl);
        root.add(look);
        root.add(read);
        root.add(j2);
        root.add(look1);
        root.add(read1);
        root.add(look2);
        root.add(look3);
        root.add(look4);
        root.add(look5);
        root.add(read2);

        look.addActionListener(e -> {
            showtime();
        });


        look1.addActionListener(e -> {
            showtime1();
        });

        look2.addActionListener(e -> {
            showtime2();
        });

        look3.addActionListener(e -> {
            showtime3();
        });

        look4.addActionListener(e -> {
            showtime4();
        });

        look5.addActionListener(e -> {
            showtime5();
        });
        
        // String write = read2.getText();
        // write = showtime2();
        this.setSize(600, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    public int showtime(){
        
        String a = "";
        a = read.getText();
        int b = Integer.parseInt(a);
        return b;
        
    }

    public int showtime1(){
        String b = "";
        b = read1.getText();
        int a = Integer.parseInt(b);
        return a;
    }

    public String showtime2(){
        int c;
        // String a = showtime();
        // String b = showtime1();
        c = showtime() + showtime1();
        String write = String.valueOf(c);
        read2.setText(write);
        System.out.println(c);
        return write;
        
    }

    public String showtime3(){
        int c;
        // String a = showtime();
        // String b = showtime1();
        c = showtime() - showtime1();
        String write = String.valueOf(c);
        read2.setText(write);
        System.out.println(c);
        return write;
        
    }

    public String showtime4(){
        int c;
        // String a = showtime();
        // String b = showtime1();
        c = showtime() * showtime1();
        String write = String.valueOf(c);
        read2.setText(write);
        System.out.println(c);
        return write;
        
    }

    public String showtime5(){
        int c;
        // String a = showtime();
        // String b = showtime1();
        c = showtime() / showtime1();
        String write = String.valueOf(c);
        read2.setText(write);
        System.out.println(c);
        return write;
        
    }

}

// class MyColorLabel extends JLabel {
//     public MyColorLabel(String name , Color color) {
//         this.setText(name);
//         this.setPreferredSize(new Dimension(60, 30));
//         this.setOpaque(true);
//         this.setBackground(color);
//         // 设置文本对齐方式为水平居中
//         this.setHorizontalAlignment(SwingConstants.CENTER);
//     }
// }

    
