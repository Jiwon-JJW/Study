import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for(int i =0; i < num; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.printf("Case #%d: %d+%d = %d", i+1,a,b,a+b);
        }
    }
}
