import java.util.Scanner;

public class Algorithm1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 0;
        int sum = 0;
        int score;

        int totalCount = scanner.nextInt();

        for(int i = 0; i < totalCount; i++) {
            score = scanner.nextInt();

            if(max<score){
                max = score;
            }
            sum+=score;
        }

        double total = (double)sum/(double)max*100/totalCount;

        System.out.println(total);
    }
}
