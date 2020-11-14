import java.util.Scanner;

public class star_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        for (int i = 1; i <=count; i++) {
            for (int j = count; j>i;j--) { System.out.print(" "); }
            for (int k = 1; k<=i; k++) { System.out.print("*"); }
            System.out.println();
        }
        for (int i = 1; i <count; i++) {
            for (int j = 0; j<i;j++){ System.out.print(" "); }
            for (int k = count; k>i;k--) { System.out.print("*"); }
            System.out.println();
        }
    }
}
