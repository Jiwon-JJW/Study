import java.util.*;
public class Monster extends Unit {

    Random random = new Random();

    public void initMonster() {
        Bomb bomb = new Bomb();
        while (true) {
            setX(random.nextInt(10));
            setY(random.nextInt(10));
            if (x != 5 && y != 5) {
                if (x != bomb.x && y != bomb.y) {
                    break;
                }
            }
            if (x == 5 && y == 5) {
                if (x == bomb.x && y == bomb.y) {
                    setX(random.nextInt(10));
                    setY(random.nextInt(10));
                }
            }
        }
    }


}
