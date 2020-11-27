import java.awt.*;
import java.awt.event.*;

public class GraphicE4 extends Frame implements MouseMotionListener{
    int x = 0;
    int y = 0;

    Image img = null;
    Graphics gImg = null;

    public static void main(String[] args){
        new GraphicE4("GraphicE4");
    }

    public GraphicE4(String title){
        super(title);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setBounds(100,100, 500,500);
        setVisible(true);

        img = createImage(500,500);
        gImg = img.getGraphics();
        gImg.drawString("왼쪽 버튼을 누른 채로 마우스를 움직여 보세요", 10,50);
        repaint();
    }

    public void paint(Graphics g){
        if(img!=null)
            g.drawImage(img,0,0,this);
    }

    public void mouseMoved(MouseEvent me){
    }

    public void mouseDragged(MouseEvent me){
        if(me.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK){
            x = me.getX();
            y = me.getY();
            gImg.drawString("*",x,y);
            repaint();
        }
    }
}
