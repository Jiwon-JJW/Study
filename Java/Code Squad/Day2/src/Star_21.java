import java.util.Scanner;

public class Star_21 {
    static void regularStar (int count) {
        for (int x = 1; x<= count*2; x++) {
            for (int y = 1; y <= count; y++) {

                if ((x%2!=0 && y%2==0)||(x%2==0 && y%2!=0)) {
                    System.out.print(" ");
                    continue;
                }
                System.out.print("*");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        regularStar(count);

        scanner.close();
            }
        }
