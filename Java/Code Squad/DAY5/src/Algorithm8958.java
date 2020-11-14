import java.util.Scanner;

public class Algorithm8958 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrValue = scanner.nextInt();
        String[] OX = new String[arrValue];

        for (int i = 0; i < OX.length; i++) {

            OX[i] = scanner.next();
        }

        scanner.close();


        for (int i = 0; i < OX.length; i++) {
            int score = 0;
            int sum = 0;
            for (int j = 0; j < OX[i].length(); j++) {
                if (OX[i].charAt(j) == 'O') {
                    sum++;
                }
                if (OX[i].charAt(j) != 'O') {
                    sum = 0;
                }
                score += sum;
            }
            System.out.println(score);
        }
    }
}
