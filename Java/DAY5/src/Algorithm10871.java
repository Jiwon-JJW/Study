import java.util.Scanner;

public class Algorithm10871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();

        int[] number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] = scanner.nextInt();
            if (number[i] < X) {
                System.out.print(number[i] + " ");
            }

        }
        scanner.close();
    }
}
