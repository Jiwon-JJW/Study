import java.util.Scanner;

public class Star_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        for(int i = 1; i<=count; i++) {
            for(int j = count; j>i; j--) {
                System.out.print(" ");
            }
            for(int k =0; k<i*2-1;k++){
                if((0<k && k<i*2-2)&&i<count){
                    System.out.print(" ");
                    continue;
                }
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
