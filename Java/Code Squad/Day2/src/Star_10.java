import java.lang.reflect.Array;
import java.util.Scanner;

public class Star_10 {

    static void StarBox(int count){
           for (int i = 1; i < 4; i++) {
               for (int j = 1; j < 4; j++) {
                   if (i % 2 == 0 && j % 2 == 0) {
                       System.out.print(" ");
                       continue;
                   }
                   System.out.print("*");
               }
               if (i > 3) {
                   continue;
               }
               System.out.println();
           }
           return;
       }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        StarBox(count);
    }
}