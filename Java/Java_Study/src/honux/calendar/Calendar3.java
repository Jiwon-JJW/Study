package honux.calendar;


public class Calendar3 {
	private final int[] MAX_DAYS = { 31, 28, 31,30,31,30,31,31,30,31,30,31};
	private final int[] LEEP_MAX_DAYS = { 31, 29, 31,30,31,30,31,31,30,31,30,31};
//	
//	public int parseDay(String day) {
//			 if(day.equalsIgnoreCase("일")) {return 0;} 
//		else if(day.equalsIgnoreCase("월")) {return 1;}
//		else if(day.equalsIgnoreCase("화")) {return 2;}
//		else if(day.equalsIgnoreCase("수")) {return 3;}
//		else if(day.equalsIgnoreCase("목")) {return 4;}
//		else if(day.equalsIgnoreCase("금")) {return 5;}
//		else if(day.equalsIgnoreCase("토")) {return 6;}
//		else {return 0;}
//	}
	
	public boolean isLeapYear(int year) {
		if (year % 4==0 && (year%100 != 0 || year % 400 == 0)) {
			return true;
		} else {
		return false;}
	}
	
	public int allday(int year) {
		int a = ((year-1)*365) + ((year-1)/4) - ((year-1)/100) + ((year-1)/400);
		return a;
		
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEEP_MAX_DAYS[month-1];
		}else {
		return MAX_DAYS[month-1];}
	}
	

		
		public void SampleCalendar(int year,int month,int weekday) {
			System.out.printf("   <<%4d년%3d월 >>%n", year,month);
			System.out.println(" 일  월  화 수  목  금 토");
			System.out.println("----------------------");
			
			// 첫 번째 줄 날짜.
//			for(int j=0; j<weekday;j++) {
//				System.out.print("   ");
//			}
			
//			int maxDay = getMaxDaysOfMonth(year,month);
//			int count = 7-weekday;
//			int delim = (count<7)? count:0;
			// count의 값이 7보다 작을 경우, count. 그 것이 아닐 경우, 0.
			
			for(int i=1; i<=allday(year);i++) {
				System.out.printf("%3d",i);
				}
			System.out.println();
//			count++;
//			for(int i = count; i<= maxDay;i++ ) {
//				System.out.printf("%3d",i);
//				if(i%7 == delim) {
//					System.out.println();
//				}
//			}
			System.out.println();
			System.out.println();			

			}

		}

