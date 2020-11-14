import java.util.Scanner;
public class Gugudan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 시작 단 을 입력하세요.");
        int num1 = scanner.nextInt();
        System.out.println("출력할 마지막 단 을 입력하세요.");
        int num2 = scanner.nextInt();

        System.out.printf("출력 값은 %d단 에서 %d단 까지 입니다.%n",num1,num2);

        for(int j= num1; j<= num2; j++) {
            System.out.println(j+"단: ");
            for (int i = 1; i < 10; i++) {
                System.out.printf("%d*%d = %d%n",j,i,j*i);
        }
            System.out.println();
        }
    }
}

