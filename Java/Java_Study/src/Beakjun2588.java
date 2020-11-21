import java.util.Scanner;

public class Beakjun2588 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        String b = sc.next();

        int num1 = a*Integer.parseInt(String.valueOf(b.charAt(2)));
        int num2 = a*Integer.parseInt(String.valueOf(b.charAt(1)));
        int num3 = a*Integer.parseInt(String.valueOf(b.charAt(0)));

        int sum = num1+(num2*10)+(num3*100);

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(sum);
    }
}
