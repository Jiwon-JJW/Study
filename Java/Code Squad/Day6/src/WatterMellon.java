import java.util.Scanner;

public class WatterMellon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solution(scanner.nextInt());
    }
        public static String solution(int n) {
            String answer = "";
            for(int i = 0; i<n;i++) {
                if (i % 2 == 0) {
                    answer = answer + "수";
                } else {
                    answer = answer + "박";
                }
            }

            return answer;
        }
    }
