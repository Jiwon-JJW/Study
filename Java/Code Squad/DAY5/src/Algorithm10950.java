import java.util.Scanner;

public class Algorithm10950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T =scanner.nextInt();
        int[] sum = new int[T];


        for(int i = 0; i<T; i++){
            int sum1 = 0;
            for(int j = 0; j<2; j++) {
                int num = scanner.nextInt();
                sum1 += num;
            }
            sum[i]=sum1;

        }

        for (int i = 0; i<T; i++){
            System.out.println(sum[i]);
        }

        scanner.close();
    }
}
