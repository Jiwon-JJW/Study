public class Character extends Unit {
    public void initCharacter() {
        setX(5);
        setY(5);
    }

    public void CharacterUp() {

        if (super.x - 1 < 0) {
            System.out.println("위로는 더이상 갈 수 없습니다.");
            return;
        }
        super.x--;
    }

    public void CharacterDown() {
        if (super.x + 1 >= 11) {
            System.out.println("아래로는 더이상 갈 수 없습니다.");
            return;
        }
        super.x++;
    }

    public void CharacterLeft() {
        if (super.y - 1 < 0) {
            System.out.println("왼쪽으로는 더이상 갈 수 없습니다.");
            return;
        }
        super.y--;
    }

    public void CharacterRight() {
        if (super.y + 1 >= 11) {
            System.out.println("오른쪽으로는 더이상 갈 수 없습니다.");
            return;
        }
        super.y++;
    }

    public void moveinput(String move){
        while (true) {
            if (move.equalsIgnoreCase("W")) {
                CharacterUp();
                return;
            }
            if (move.equalsIgnoreCase("S")) {
                CharacterDown();
                return;
            }
            if (move.equalsIgnoreCase("A")) {
                CharacterLeft();
                return;
            }
            if (move.equalsIgnoreCase("D")) {
                CharacterRight();
                return;
            }

            if (move.equalsIgnoreCase("1")){
                return;
            }
            if (move.equalsIgnoreCase("0")){
                return;
            }

            else {
                System.out.println("잘못 입력하셨습니다. 올바른 키를 입력해주세요.");
                return;
            }

        }

    }


    public void StageUp(int n){
        setStage(stage+n);
    }
}
