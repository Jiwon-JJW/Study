import java.util.Scanner;

public class star_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for(int q = 1 ; q <=count; q++) {
            for (int n= 1; n<=q ; n++) {System.out.print("*"); }
            for (int m= count*2-q; m>q ;m--) { System.out.print(" ");}
            for (int n= 1; n<=q ; n++) {System.out.print("*"); }
            System.out.println(" ");
        }
        for(int i = 1; i <count; i++) {
            for (int j = count; j > i; j--) { System.out.print("*"); }
            for (int k = 0; k < i*2; k++) { System.out.print(" "); }
            for (int j = count; j > i; j--) { System.out.print("*"); }
            System.out.println(" ");
        }

    }
}
