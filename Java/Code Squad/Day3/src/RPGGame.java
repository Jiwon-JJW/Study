import java.util.*;

public class RPGGame {
    Scanner scanner = new Scanner(System.in);
    static Map map = new Map();
    static Character character = new Character();
    static Bomb bomb = new Bomb();
    static Monster monster = new Monster();


    public static void main(String[] args) {

        for(int i = 1; i<=character.getStage();i++){
            System.out.println("1");;
            }



        character.setStage(1);
        Scanner scanner = new Scanner(System.in);
        initWorld();

        while (true) {

            System.out.println("========================================");
            System.out.println("현재 스테이지:"+character.getStage());
            System.out.println("| W: UP | A: LEFT | S: DOWN | D: RIGHT |");
            System.out.println("|   GAME START: 1 |   GAME FINISH: 0   |");
            System.out.println("========================================");
            System.out.print("> ");

            String characterMove = scanner.nextLine();
            if(characterMove.equalsIgnoreCase("1")){
                initWorld();
                continue;
            }
            if(characterMove.equalsIgnoreCase("0")){
                scanner.close();
                return;
            }

            map.FieldSize[character.getX()][character.getY()]=".";
            character.moveinput(characterMove);
            map.Character(character);
            Status();

        }

    }

    static void initWorld(){
        character.initCharacter();
        monster.initMonster();

        map.initField();
        map.AddBombField(bomb);
        if(character.getStage()>1){
            for(int i = 1;i<character.getStage();i++){
                map.AddBombField(bomb);
            }
        }
        map.Monster(monster);
        map.Character(character);

    }


    static void Status(){
        if(character.getX()== monster.getX() && character.getY()== monster.getY()){
            character.StageUp(1);
            System.out.println("!!Stage clear!!");
            System.out.printf("계속 하시겠습니까?%n(yes:1 | No:0)%n >");
        }

        if(character.getX()==bomb.getX() && character.getY()==bomb.getY()){
            System.out.println("!!지뢰가 터졌습니다!!");
            System.out.println("Game Over");
            System.out.printf("계속 하시겠습니까?%n(yes:1 | No:0)%n >");
        }
    }

}





