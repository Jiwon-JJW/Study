import java.util.Scanner;

public class Star_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        for(int i=1; i<=count;i++ ) {
            if(i%2==0) {
                System.out.print(" ");
            }
            for (int j = 0; j<count;j++) {
                System.out.print("*");
                if( j != count-1) { System.out.print(" "); }
                if (j == count-1) { continue; }
            }
            System.out.println();
        }
        scanner.close();
    }
}
