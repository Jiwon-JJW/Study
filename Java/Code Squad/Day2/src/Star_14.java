import java.util.Scanner;

public class Star_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        for (int i =0; i<count;i++) {
            for(int j =0; j<count;j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
