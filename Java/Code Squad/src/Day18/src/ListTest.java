import java.awt.*;

public class ListTest {
    public static void main(String[] args){
        Frame f = new Frame("List - Select");
        f.setSize(300,200);
        f.setLayout(null);

        List selectOne = new List(6);
        selectOne.setLocation(20,40);
        selectOne.setSize(100,120);
        selectOne.add("Student");
        selectOne.add("Teacher");
        selectOne.add("Driver");
        selectOne.add("Computer Programmer");
        selectOne.add("Sales Man");
        selectOne.add("Musician");
        selectOne.add("Director");

        List selectMany = new List(6,true);

    }
}

