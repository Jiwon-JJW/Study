import java.util.Scanner;

public class star_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        for(int q = 1 ; q <=count; q++) {
            for (int n= 0; n<q-1 ; n++) {System.out.print(" "); }
            for (int m= count*2-q+1; m>q ;m--) { System.out.print("*");}
            System.out.println(" ");
        }
        for(int i = 1; i <count; i++) {
            for (int j = count-1; j > i; j--) { System.out.print(" "); }
            for (int k = 0; k < i*2+1; k++) { System.out.print("*"); }
            System.out.println(" ");
        }
    }
}
