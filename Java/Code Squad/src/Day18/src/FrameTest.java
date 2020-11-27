import java.awt.*;

public class FrameTest {
    public static void main(String[] args){
        Frame f = new Frame("Login"); // Frame객체를 생성한다. 생성자에 사용 된 String은 Frame의 titlebar에 나타남.
        f.setSize(300,200);   // Frame의 크기를 설정한다. 폭 / 높이(pixcel)
        f.setVisible(true);               // 생성한 Frame을 화면에 보이도록 한다. 반드시 setVisible을 해주어야 한다.
    }
}
