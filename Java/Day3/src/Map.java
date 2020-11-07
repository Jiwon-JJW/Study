public class Map extends Unit {
    public String FieldSize[][] = new String[11][11];

    public void initField() {
        for (int x = 0; x < FieldSize.length; x++) {
            for (int y = 0; y < FieldSize[0].length; y++) {
                FieldSize[x][y] = ".";
            }
        }

    }


    public void AddBombField(Bomb b){
        b.initBomb();
        FieldSize[b.x][b.y] = "!";
    }

    public void Character(Character c){
        FieldSize[c.x][c.y] = "@";
        PrintField();

        }


        public void Monster(Monster m){
            FieldSize[m.x][m.y] = "$";
        }


    public void PrintField() {
        for (int x = 0; x < FieldSize.length; x++) {
            for (int y = 0; y < FieldSize[0].length; y++) {
                System.out.print(FieldSize[x][y]);
            }
            System.out.println();
        }
    }
}