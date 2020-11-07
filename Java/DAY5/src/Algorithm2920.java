import java.util.*;

public class Algorithm2920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();

        scanner.close();
        if(num.equalsIgnoreCase("1 2 3 4 5 6 7 8")){
            System.out.println("ascending");
            return;
        }
        if(num.equalsIgnoreCase("8 7 6 5 4 3 2 1")){
            System.out.println("descending");
            return;
        }
        else {
            System.out.println("mixed");
            return;
        }

    }
}
