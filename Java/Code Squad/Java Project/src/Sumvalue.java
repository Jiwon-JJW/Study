import java.util.Scanner;

public class Sumvalue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        String line = scanner.next();

        scanner.close();
        int sum = 0;
        for(int i= 0; i<num;i++) { sum += line.charAt(i)-'0'; }
        System.out.println(sum);

    }
}
