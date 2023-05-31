import javax.swing.*;
import java.awt.*;

class Chess extends JFrame {

    public Chess(){
        this.setTitle("国际象棋");
        this.setSize(450,450);
        this.setVisible(true);
        //绘制网格
        int grid = 8;
        int gridSize = 50;
        // 行
        for(int i=0;i<grid;i++){
            // 每行的每一格
            for(int j=0;j<grid;j++){
                JLabel jLabel = new JLabel();
                jLabel.setSize(gridSize,gridSize);
                //设置每个Label的位置
                jLabel.setLocation(i*gridSize,j*gridSize);
                //设置颜色
                if( (i+j)%2==0 ){
                    jLabel.setBackground(Color.black);
                }else{
                    jLabel.setBackground(Color.white);
                }
                jLabel.setOpaque(true);
                //设置每个Label边框的颜色
                jLabel.setBorder(BorderFactory.createLineBorder(Color.yellow));
                this.add(jLabel);
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Chess();
            }
        });
    }
}
