package honux.calendar;

import java.util.Scanner;

public class Prompt {

	
	
	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar3 cal = new Calendar3();
		
		int month=1;
		int year=1;
		int weekday = 0;
		
		while(true) {
			System.out.println("년도를 입력하세요");
			System.out.println("YEAR>");
			
			year = scanner.nextInt();
			
			if (year<=0) {
				System.out.println("입력이 올바르지 않습니다.");
				break;
			}
			
			System.out.println("월을 입력하세요.");
			System.out.println("MONTH> ");
			
			month = scanner.nextInt();
			
			if(month<=0||month>12) {
				System.out.println("입력이 올바르지 않습니다.");
				break;
			}
			
			System.out.println("첫째날의 요일을 입력하세요.(요일을 제외하고 입력.)");
			System.out.println("DAY> ");
			String day = scanner.next();
			weekday = cal.parseDay(day);
			System.out.println(day+weekday);
			
			if(weekday>6) {
				System.out.println("입력이 올바르지 않습니다.");
			}else {
				cal.SampleCalendar(year,month,weekday);
			}
		}
		scanner.close();
	}
	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
