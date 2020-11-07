import java.util.Scanner;
public class star_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 1; i <= count; i++) {
            for (int k = 1; k < i; k++) { System.out.print(" "); }
            for (int j = count; j >= i; j--) { System.out.print("*"); }
            for (int l = count; l > i; l--) { System.out.print("*"); }
            System.out.println();
        }
    }
}