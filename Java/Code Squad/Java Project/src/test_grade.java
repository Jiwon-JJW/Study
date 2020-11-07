import java.util.Scanner;

public class test_grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int grade = scanner.nextInt();

        if (90<=grade&&grade<=100) { System.out.println("A"); return; }
        if (80<=grade&&grade<=89) { System.out.println("B"); return; }
        if (70<=grade && grade<=79 ) { System.out.println("C"); return; }
        if (60<=grade && grade<=69) { System.out.println("D"); return; }
        if (0<=grade && grade<=59){ System.out.println("F"); return; }
    }
}
