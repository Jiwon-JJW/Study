import java.io.IOException;

public class Time extends Thread {
    @Override

    public void run() {
        ClockSetting clockSetting = new ClockSetting();

        while (true) {
            clockSetting.InitClock();
            System.out.println("==============");

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }

        }
    }
}
