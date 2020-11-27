import java.awt.*;

public class ButtionTest {
    public static void main(String[] args){
        Frame f = new Frame("Login");
        f.setSize(300,200);

        Button b = new Button("확 인"); // Button위에 "확 인" 이라는 글자가 나타난다.
        b.setSize(100,50);      // Button의 크기 설정.

        f.add(b);                           // 생성된 Buton을 Frame에 포함.
        f.setVisible(true);
    }
}
