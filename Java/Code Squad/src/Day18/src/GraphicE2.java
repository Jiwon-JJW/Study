import java.awt.*;
import java.awt.event.*;

public class GraphicE2 extends Frame implements MouseMotionListener {
    int x = 0;
    int y = 0;

    public static void main(String[] args){
        new GraphicE2("GraphicsE2");
    }

    public GraphicE2(String title){
        super(title);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
        });

        setBounds(100,100, 500,500);
        setVisible(true);
    }

    public void paint(Graphics g){
        g.drawString("마우스를 움직여 보세요", 10, 50);
        g.drawString("*", x, y);
    }

    public void mouseMoved(MouseEvent me){
        x =me.getX();
        y =me.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent me){
    }
}
