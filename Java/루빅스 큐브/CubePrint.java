public class CubePrint {

    public void print2(){ // 두 번째 줄을 출력하는 메소드.
        for (int j = 0; j < CubeShuffle.cube[0].length; j++) {
            for (int i = 1; i < CubeShuffle.cube.length - 1; i++) {
                for (int k = 0; k < 3; k++) {
                    System.out.printf("%2s", CubeShuffle.cube[i][j][k]);
                }
                System.out.printf("%6s", " "); // 중간에 공백 출력
            }
            System.out.println();
        }
    }

    public void print1(int n){ // 첫 번째 , 세 번째 줄을 출력하는 메소드
        for (int j = 0; j < CubeShuffle.cube[0].length; j++) {
            for (int k = 0; k < CubeShuffle.cube[0][0].length; k++) {
                if (k == 0 || k == 4 || k == 7) {
                    System.out.printf("%18s", " "); // 첫 번째에 공백 출력
                }
                System.out.printf("%2s", CubeShuffle.cube[n][j][k]);
            }
            System.out.println();
        }
    }

    public void printCube(){
        print1(0); // 첫 번째 줄을 출력하는 메소드
        print2();     // 두 번째 줄을 출력하는 메소드
        print1(5); // 세 번째 줄을 출력하는 메소드
    }
}
