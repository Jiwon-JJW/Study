import java.awt.*;
import java.awt.event.*;

public class Painter extends Frame{
    // 메뉴컴포넌트
    MenuBar menuBar;
    Menu mPainter, mTools;
    MenuItem miNew, miExit;
    MenuItem miPencil, miCircle, miRectangle;

    int startX,startY,endX,endY,x,y;
    Image img;
    Graphics gImg;

    public static void main(String[] args) {
        new Painter("Painter");
    }

    public Painter(String title) {
        super(title);
        //메뉴
        menuAdd();

        //종료버튼
        addWindowListener(new WindowAdapter() {// 종료버튼 눌렀을 때.
            public void windowClosing(WindowEvent e) {
                System.exit(0); // 시스템 종료
            }
        });

        addMyListener();

        // Frame을 (100,100)의 위치에 width 500, height 500 크기로 보이게 한다.
        setBounds(100, 100, 500, 500);
        setVisible(true);

        img = createImage(500, 500);
        gImg = img.getGraphics(); // Image 객체의 Graphics 객체를 얻어서 선을 출력.
        repaint();
    }

    public void paint(Graphics g) {
        if (img == null) return;
        g.drawImage(img, 0, 0, this); // 가상 화면에 그려진 그림을 Frame에 복사
    }

    public void addMyListener(){
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent me){
                x = me.getX();
                y = me.getY();
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                    startX = e.getX();
                    startY = e.getY();

                    repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("pressed");
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Released");
                endX = e.getX();
                endY = e.getY();
                repaint();
            }
        });

    }

    public void menuAdd() {
        menuBar = new MenuBar();
        mPainter = new Menu("Painter");
        mTools = new Menu("Tools");
        miNew = new MenuItem("New");
        miExit = new MenuItem("Exit");
        miPencil = new MenuItem("Pencil");
        miCircle = new MenuItem("Circle");
        miRectangle = new MenuItem("Rectangle");

        mPainter.addSeparator();
        mPainter.add(miNew);
        mPainter.add(miExit);
        mTools.add(miPencil);
        mTools.add(miCircle);
        mTools.add(miRectangle);

        menuBar.add(mPainter);
        menuBar.add(mTools);
        setMenuBar(menuBar);

        EventHandler eventHandler = new EventHandler();
        miNew.addActionListener(eventHandler);
        miExit.addActionListener(eventHandler);
        miPencil.addActionListener(eventHandler);
        miCircle.addActionListener(eventHandler);
        miRectangle.addActionListener(eventHandler);
    }

    class EventHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "New":
                    gImg.clearRect(0, 0, 500, 500);
                    repaint();
                    break;
                case "Exit":
                    System.exit(0);
                    break;
                case "Pencil":
                    System.out.println("펜");
                    gImg.drawLine(x, y, endX, endY);
                    break;
                case "Circle":
                    System.out.println("원");
                    gImg.drawOval(startX, startY, endX - startX, endY - startY);
                    break;
                case "Rectangle":
                    System.out.println("사각형");
                    gImg.drawRect(startX, startY, endX - startX, endY - startY);
                    break;
            }
        }
    }
}
