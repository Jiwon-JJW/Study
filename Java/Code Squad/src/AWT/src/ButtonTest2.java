import java.awt.*;

public class ButtonTest2 {
    public static void main(String[] args){
        Frame f = new Frame("Login");
        f.setSize(300,200);
        f.setLayout(null);
        // 해당 메서드를 사용하지 않으면, 이미 지정되어 있는 Layout이 있기 때문에 Frame 전체에 확인 버튼이 나타나게 된다.

        Button b = new Button("확 인");
        b.setSize(100,50); // Button의 크기 설정.
        b.setLocation(100,75);   // Frame 내의 Button의 위치 설정.

        f.add(b);
        f.setVisible(true);
    }
}
