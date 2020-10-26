package honux.calendar;
import java.util.Scanner;
public class Calendar {
	/* 강의 코드 2 
	private final int[] MAX_DAYS = { 31, 28, 31,30,31,30,31,31,30,31,30,31};
	
	public int getMaxDaysOfMonth(int month) {
	// 1.	return MAX_DAYS[month-1];
	// 2. switch(month) {
		case 2: return 28;
		
		case 4: return 30;
		
		default: return 31;
		}
	}
	
	public void printSampleCalendar() {
		System.out.println("일  월  화 수  목  금 토");
		System.out.println("----------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		}
	*/
	
	public static void main(String[] args) {
		
		
		
		System.out.println("Hello Calendar");
		
		System.out.println("일  월  화 수  목  금 토");
		System.out.println("----------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		
		// 숫자를 입력받아, 해당하는 달의 최대 일수를 출력하는 프로그램.
		// * if 사용, 변수 사용, 배열 사용.
		
		Scanner scanner = new Scanner(System.in);
		// 강의 코드 2: Calendar cal = new Calendar();
		System.out.println("달을 입력하세요");
		int month = scanner.nextInt();
		
		// 내가 짠 코드.
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			System.out.println(month+"월은 31일까지 있습니다.");
		} else if (month==4||month==6||month==9||month==11) { // 1<짝수, 짝수/2 == 0 , 짝수 <8
			System.out.println(month+"월은 30일까지 있습니다.");
		} else  {
			System.out.println(month+"월은 28일까지 있습니다.");
		}
		
		/* 실제로 강의에서 짠 코드
		int[] maxDays = { 31, 28, 31,30,31,30,31,31,30,31,30,31};
		
		System.out.printf("%d월은 %d일까지 있습니다.", month,maxDays[month-1]);
		*/
		/* 실제로 강의에서 짠 코드2
		int[] maxDays = { 31, 28, 31,30,31,30,31,31,30,31,30,31};
		
		System.out.printf("%d월은 %d일까지 있습니다.", month,cal.getMaxDaysOfMonth[month-1]);
		*/
		
		//cal.printSampleCalendar();
		
		
		
		scanner.close();
		
		}
		
	} 


