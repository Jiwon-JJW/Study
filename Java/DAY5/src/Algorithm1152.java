import java.util.*;

public class Algorithm1152 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString," ");

        if(inputString.isEmpty()){
            System.out.println("0");
        }
        System.out.println(stringTokenizer.countTokens());

        scanner.close();
    }
}
