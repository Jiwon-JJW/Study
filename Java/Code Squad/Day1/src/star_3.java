import java.util.Scanner;
public class star_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        for (int i = 1; i <= count; i++) {
            for (int j = count; j >= i; j--) { System.out.print("*"); }
            System.out.println();
        }
    }
}
