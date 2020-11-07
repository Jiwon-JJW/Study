import java.util.Random;

public class Bomb extends Unit {
    Random random = new Random();
    Monster monster = new Monster();

    public void initBomb(){
        while(true) {
            setX(random.nextInt(10));
            setY(random.nextInt(10));
            if (x != 5 && y != 5) {
                if (x != monster.x && y != monster.y){
                    break;
                }
            }
        }
    }


}
