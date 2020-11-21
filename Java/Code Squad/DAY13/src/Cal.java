import java.util.Calendar;
import java.util.Scanner;

class Year {
    Calendar c = Calendar.getInstance();
    public int year;

    public Year(int y) {
        year=y;
        if(year == 0){
            year =c.get(c.YEAR);
        }
    }
}

class Month {
    Calendar c = Calendar.getInstance();
    public int month;
    public Month(int m){
        month = m;
        if(month == 0){
            month= c.get(c.MONTH)+1;
        }
    }
}

public class Cal {
    Scanner scanner = new Scanner(System.in);

    public void calMenu(){

        int inputYear=0;
        int inputMonth=0;

        System.out.println("달력을 출력하는 옵션을 선택하여 주세요.");
        System.out.println("  1.현재 달력 | 2.날짜 지정");
        System.out.print("> ");
        switch (scanner.nextInt()) {
            case 1 -> {
                inputYear = 0;
                inputMonth = 0;
                break;
            }
            case 2 -> {
                System.out.println("원하시는 년도를 입력하여 주세요.");
                System.out.print("> ");
                inputYear = scanner.nextInt();

                System.out.println("원하시는 달을 입력하여 주세요.");
                System.out.print("> ");
                inputMonth = scanner.nextInt();
                break;
            }
        }
        Year y = new Year(inputYear);
        Month m = new Month(inputMonth);

        settingcal(y.year, m.month);
        }


    public void settingcal(int y,int m){
        Calendar c = Calendar.getInstance();

        c.set(y, m-1, 1);
        int startDayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        int endDay = c.getActualMaximum(Calendar.DATE);

        System.out.println("=====================");
        System.out.printf("%9d년 %3d월 %n",y,m);
        printcal(startDayOfWeek, endDay);

        Main.returnMenu();
    }


    public void printcal(int sDay,int eDay) {
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");
        for (int i = 1; i < sDay; i++)
            System.out.print("   ");

        for (int i = 1, n = sDay; i <= eDay; i++, n++) {

            System.out.printf("%3d", i);
            if (n % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("=====================");
    }
}

