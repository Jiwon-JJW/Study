import java.util.Scanner;

public class alarm_clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String time = scanner.nextLine();

        String[] inputvalue = time.split(" ");

        int hour = Integer.parseInt(inputvalue[0]);
        int minute = Integer.parseInt(inputvalue[1]);

        if (minute<45) { hour--; minute = 60-(45-minute);
            if (hour<0) { hour = 23; } System.out.println(hour+" "+ minute); return;}

        if (minute>=45) { minute = minute-45; System.out.println(hour+" "+ minute); return;}
    }
}
