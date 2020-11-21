import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    menuSelect();
    }

    public static void menuSelect(){
        Scanner scanner = new Scanner(System.in);
        Time t = new Time();
        Cal c = new Cal();

        System.out.println("원하시는 항목을 입력하여 주세요.");
        System.out.println("  clock  |  calendar");
        System.out.print("> ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("clock")) {
            t.start();
            if (scanner.nextLine().equalsIgnoreCase("")) {
                t.interrupt();
            }
        }
        if (answer.equalsIgnoreCase("calendar")) {
            c.calMenu();
        }
    }

    public static void returnMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("메뉴로 돌아가시겠습니까?");
        System.out.println("   Y   |   N");
        if(scanner.nextLine().equalsIgnoreCase("y")) {
            Main.menuSelect();
        }
        if(scanner.nextLine().equalsIgnoreCase("n")){
            System.exit(0);
        }
    }
}

