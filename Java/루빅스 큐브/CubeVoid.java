import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CubeVoid {
    char[][][] answerCube = { // 3차원 배열을 이용한 루빅스 큐브 생성
            {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}},
            {{'W', 'W', 'W'}, {'W', 'W', 'W'}, {'W', 'W', 'W'}},
            {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}},
            {{'G', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'G'}},
            {{'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}, {'Y', 'Y', 'Y'}},
            {{'R', 'R', 'R'}, {'R', 'R', 'R'}, {'R', 'R', 'R'}},
    };

    CubeShuffle cubeShuffle = new CubeShuffle();
    CubePrint cubePrint = new CubePrint();

    static int score = 0;

    public void main(){
        cubeShuffle.start = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("원본");
        cubePrint.printCube();
        System.out.println("=========================================");
        cubeShuffle.shuffle();
        cubePrint.printCube();

        while(answer()){ // 정답이 안맞을 때 까지만 무한 반복문
            answer(); // 정답을 매번 확인하는 작업을 거침
            info();
            String command = scanner.next();
            try {
                cmd(command);
            }catch (Exception e){
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
        System.out.println("큐브를 풀었습니다 ! 축하합니다!");
        scanner.close();
        cubeShuffle.exit("q");
    }

    public void info(){
        System.out.println("=========================================");
        System.out.println("> U  윗줄을 시계방향으로 돌린다");
        System.out.println("> U' 윗줄을 반시계방향으로 돌린다");
        System.out.println("> R  오른쪽줄을 시계방향으로 돌린다");
        System.out.println("> R' 오른쪽줄을 반시계방향으로 돌린다");
        System.out.println("> L  왼쪽줄을 시계방향으로 돌린다");
        System.out.println("> L' 왼쪽줄을 반시계방향으로 돌린다");
        System.out.println("> B  아랫줄을 시계방향으로 돌린다");
        System.out.println("> B' 아랫줄을 반시계방향으로 돌린다");
        System.out.println("> F  전면을 시계방향으로 돌린다");
        System.out.println("> F' 전면을 반시계방향으로 돌린다");
        System.out.println("> Q  프로그램을 종료한다.");
        System.out.println("=========================================");

        System.out.println("명령어를 입력하여주세요.");
        System.out.print("CUBE >");
    }

    public void cmd(String command){ // 명령어를 배열로 나누는 메소드
        String[] split = command.split(""); // 한 글자 씩 배열에 저장
        List<String> keyword = new ArrayList<String>();
        keyword.addAll(Arrays.asList(split)); // 배열에 저장한 것을 List로 만들어줌 (재저장)

        for(int i = 0; i<keyword.size(); i++){
            saveLoopNumber((ArrayList<String>) keyword, i); // 숫자확인
            if(i+1< keyword.size()){ // 코멘트 뒤에 ' 가 붙어있는지 확인하고, 붙어있다면 앞의 배열에 합치는 메소드
                if(keyword.get(i+1).equalsIgnoreCase("'")){
                    keyword.set(i,keyword.get(i)+"'");
                    keyword.remove(i+1);
                }
            }
        }
        score += keyword.size(); // 몇 번 돌렸는지 세어주기 위해 키워드의 갯수를 세서 저장
        printCMD((ArrayList<String>) keyword); // 무슨 키워드가 나오는지 출력
    }

    public void printCMD(ArrayList<String> arr){ // 키워드와 맞춰진 큐브를 출력하는 기능
        for(int i = 0; i<arr.size();i++){
            System.out.println(arr.get(i)); //키워드를 하나씩 출력
            loopNum(arr, i); // 만약 키워드 앞에 숫자가 있을 경우 발생하는 메소드
            cubePrint.printCube(); // 키워드에 맞는 기능 수행 후 큐브를 출력
            }
        }

    public void saveLoopNumber(ArrayList<String> arr,int i){ // 만일 숫자가 입력 되었을 때 확인하는 메소드
        try {
            if(0 < Integer.parseInt(arr.get(i)) && 9 > Integer.parseInt(arr.get(i))){
                arr.set(i+1,arr.get(i)+arr.get(i+1)); // 숫자 다음 인덱스에 숫자와 함께 저장 시키는 메소드
                arr.remove(i); // 숫자가 담겨있는 인덱스 자체를 삭제
            }
        }catch (NumberFormatException e){ // 숫자가 없을 경우 처리하는 메소드
            return; // 반복문을 넘어가도록진행
        }

    }
    public void loopNum(ArrayList<String> arr,int i) { // 담겨있는 숫자 및 키워드를 확인하여 큐브를 돌리는 기능
        try {
            if (0 < arr.get(i).charAt(0) || 9 > arr.get(i).charAt(0)) {
                int n = Integer.parseInt(String.valueOf(arr.get(i).charAt(0))); // 반복문을 위한 숫자 저장용

                if (arr.get(i).length() == 2) { // 글자 수가 2u 같이 숫자와 키워드만 담겨있을 경우
                    String answer = String.valueOf(arr.get(i).charAt(1));
                    // String 자체에 u 와 같은 글자를 저장시킴
                    cubeShuffle.inputCommand(answer,n);
                    // 반복문에 해당하는 숫자와 글자를 집어넣어 큐브 생성
                }
                if (arr.get(i).length() == 3) {// 글자 수가 2u' 같이 숫자와 키워드, ' 까지 담겨있을 경우
                    String answer = arr.get(i).charAt(1) + String.valueOf(arr.get(i).charAt(2));
                    // String 자체에 u' 와 같은 글자를 저장시킴
                    cubeShuffle.inputCommand(answer,n);
                    // 반복문에 해당하는 숫자와 글자를 집어넣어 큐브 생성
                }
            }
        }catch (NumberFormatException e){ // 숫자가 없을 경우, 반복문은 그냥 한 번만 진행하도록 진행
            cubeShuffle.inputCommand(arr.get(i),1);
            return;
        }
    }

    public boolean answer(){ // 큐브가 다 맞춰졌는지 확인하는 기능
        boolean b = false; //기본 값
        for(int k = 0; k < answerCube.length; k++) {
            for (int i = 0; i < answerCube[0].length; i++) {
                for (int j = 0; j < answerCube[0][0].length; j++) {
                    String a = String.valueOf(answerCube[k][i][j]);
                    String c = String.valueOf(CubeShuffle.cube[k][i][j]);
                    b = a.equalsIgnoreCase(c); // 배열에 담긴 글자가 전체적으로 같은지 확인
                    if(b == false){ // 하나라도 false가 나올 경우 true를 리턴
                        return true;
                    }
                }
            }
        }
        if (b == true){ // 전체 글자가 모두 같을 경우, false를 리턴하여 while문 정지
            return false;
        }
        return true;
    }
}
