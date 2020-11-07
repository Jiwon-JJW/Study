import java.util.Scanner;

public class IndianName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Indian indian= new Indian();

        System.out.println("생년월일을 입력해주세요 ((ex) 2010 10 3)");
        System.out.print("> ");

        String Birthday = scanner.nextLine();

        String[] arr = Birthday.split(" ");

        char yearEndNumber= arr[0].charAt(3);

        int year = Integer.parseInt(String.valueOf(yearEndNumber));
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);



        System.out.println(indian.makeIndianName(year,month-1,day-1));

        scanner.close();
    }
}


