import java.util.Scanner;
public class leap_year {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int year = scanner.nextInt();

    scanner.close();

    if(year % 4 == 0 && (year%100 != 0 || year%400== 0)) { System.out.println("1"); return; }
    if(year % 4 != 0 && (year%100 == 0 || year%400 != 0)) { System.out.println("0"); return; }
    }
}
