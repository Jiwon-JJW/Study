import java.util.Scanner;
public class star_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 1; i <= count; i++) {
            for (int j = count; j >= i+1; j--) { System.out.print(" ");}
            for (int k = 0; k < i; k++) { System.out.print("*"); }
            for (int l = 1; l < i; l++) { System.out.print("*"); }
            System.out.println();
        }
    }
}