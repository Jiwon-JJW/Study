import java.util.*;


public class RandomOX {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();


        while (count>0) {
            int StringLength = random.nextInt(80);
            System.out.println(randomOX(StringLength));

            count--;
            continue;
        }

    }

    static String randomOX(int StringLength){
        Random random = new Random();
        String OX = "OX";
        StringBuilder randomOX = new StringBuilder(StringLength);

        for (int i = 1; i < StringLength; i++) {
            char OX2 = OX.charAt(random.nextInt(OX.length()));
            randomOX.append(OX2);
        }
        return randomOX.toString();
    }
}
