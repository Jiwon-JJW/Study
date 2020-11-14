import java.util.Scanner;

public class Algorithm2475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num;
        int sum = 0;

        for (int i = 0; i < 5; i++){
             num = scanner.nextInt();
             sum += (num * num);
        }

        System.out.println((sum%10));
        scanner.close();
    }
}
