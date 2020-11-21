import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

 class Solution {
    static String timeConversion(String s) {
        String[] time = s.split(":");
        int hh = Integer.parseInt(time[0]);

        String x = String.valueOf(time[2].charAt(2))+String.valueOf(time[2].charAt(3));

        if(x.equalsIgnoreCase("AM")){
            if (hh==12){
                hh = 00;
            }
            else {hh = 00+hh;}

            if(hh<10) {
                time[0] = "0"+String.valueOf(hh);
            }
            else {
                time[0] = String.valueOf(hh);
            }

            time[2] = String.valueOf(time[2].charAt(0))+String.valueOf(time[2].charAt(1));

            s = String.join(":", time);
            return s;
        }

        if(x.equalsIgnoreCase("PM")){
            if (hh==12){
                hh = 12;
            }
            else {hh = 12+hh;}

            time[0] = String.valueOf(hh);
            time[2] = String.valueOf(time[2].charAt(0))+String.valueOf(time[2].charAt(1));

            s = String.join(":", time);
            return s;
        }
        return s;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

public class TimeConversion {

}
