import java.util.Scanner;
public class value_comparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
      String[] val = value.split(" ");

      int  A = Integer.parseInt(val[0]);
      int  B = Integer.parseInt(val[1]);

        scanner.close();

        if (A > B) { System.out.println(">"); return; }
        if (A < B) { System.out.println("<"); return; }
        if (A == B){ System.out.println("=="); return; }
    }
}