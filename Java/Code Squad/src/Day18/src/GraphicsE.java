import java.awt.*;
import java.awt.event.*;

public class GraphicsE extends Frame{
    public static void main(String[] args) {
        new GraphicsE("Graphics");
    }

    public void paint(Graphics g){
        g.setFont(new Font("Serif", Font.PLAIN, 15));
        g.drawString("Graphics를 이용해서 그림을 그립니다.",10, 50);

        g.drawOval(50,100,50,50); // 선만 그림
        g.setColor(Color.blue);
        g.fillOval(100,100, 50,50); // 색을 채워 그림

        g.setColor(Color.red);
        g.drawLine(100,100, 150,150); // 선 그림

        g.fillRoundRect(200,100, 120,80,30,30);// 라운드 진 사각형
        g.setColor(Color.orange);
        g.fillPolygon(new int[]{50, 100, 150, 200},
                new int[]{250,200,200,250},4); //사다리 꼴로 그림
        g.setColor(Color.cyan);
        g.fillArc(250,200,100,100,0,120); // 부채꼴로 그림
    }

    public GraphicsE(String title){
        super(title);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });

        setBounds(100,100, 400,300);
        setVisible(true);
    }
}