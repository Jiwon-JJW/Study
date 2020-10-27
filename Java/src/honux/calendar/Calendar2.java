//package honux.calendar;
//
//import java.util.Scanner;
//
//public class Calendar2 {
//
//		private final int[] MAX_DAYS = { 31, 28, 31,30,31,30,31,31,30,31,30,31};
//		
//		public int getMaxDaysOfMonth(int month) {
//			return MAX_DAYS[month-1];
//		}
//		
//		public void printSampleCalendar() {
//			System.out.println("일  월  화 수  목  금 토");
//			System.out.println("----------------------");
//			System.out.println(" 1  2  3  4  5  6  7");
//			System.out.println(" 8  9 10 11 12 13 14");
//			System.out.println("15 16 17 18 19 20 21");
//			System.out.println("22 23 24 25 26 27 28");
//			}
//		
//		public static void main(String[] args) {
//			
//			
//			Scanner scanner = new Scanner(System.in);
//			Calendar2 cal = new Calendar2();
//			
//			// cal.printSampleCalendar();
//			System.out.println("반복 횟수를 입력하세요");
//
//			int num = scanner.nextInt();
//			
//			if(num<=0) {
//				System.out.println("0이상 입력해주세요.");
//			}
//			for(int i = 0;i<num;i++) {
//				
//			int month = 1;
//			while(true) {
//				System.out.println("월을 입력하세요.");
//				System.out.println("cal> ");
//				month = scanner.nextInt();
//				
//				if(month<=0) {
//					System.out.println("입력이 올바르지 않습니다.");
//					break;
//				}else {
//					System.out.printf("%d월은 %d일까지 있습니다.%n", month,cal.getMaxDaysOfMonth(month));
//				}
//
//				break;
//				}
//			if(month<=0) {
//				break;
//			}
//			}
//			System.out.println("완료되었습니다.");
//			
//			/* 1. 수정 전
//			for(int i=0;i<num;i++) {
//			
//			System.out.println("월을 입력하세요");
//			System.out.print("cal> ");
//			int month = scanner.nextInt();
//			
//			if(month<=0) {
//				System.out.println("입력이 올바르지 않습니다.");
//			}
//			
//			System.out.printf("%d월은 %d일까지 있습니다.%n", month,cal.getMaxDaysOfMonth(month));
//			
//			
//			}
//			System.out.println("완료되었습니다.");
//			*/
//			
//			scanner.close();
//
//	}
//}
