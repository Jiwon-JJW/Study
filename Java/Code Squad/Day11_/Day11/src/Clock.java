import java.sql.Timestamp;

public class Clock {
    public static void main(String[] args) {
        Time t = new Time();

            t.start();
            Timestamp time = new Timestamp(System.currentTimeMillis());
        }

}