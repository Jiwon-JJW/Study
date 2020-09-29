# CHAPTER 10

## 01. 날짜와 시간

* Date: JDK 1.0부터 제공되어온 클래스. 날짜와 시간을 다룰 목적으로 제공되었다.
* Calender: JDK 1.1부터 제공 된 클래스. Date클래스가 빈약하여 새로운 클래스로 제공 함.
* java.time패키지: JDK 1.8부터 제공 된 클래스. 기존의 단점들을 개선한 새로운 클래스들.



## 02. Calender 클래스

* 추상 클래스.
  그 때문에 직접 객체를 선택할 수 없고, 메서드를 통해서 완전히 구현된 클래스의 인스턴스를 얻어야 함.

  ```java
  Calendar cal= new Calender(); // 에러!! 추상클래스는 인스턴스를 생성할 수 없다.
  // OK, getInstance()메서드는 Calender클래스를 구현한 클래스의 인스턴스를 반환한다.
  Calendar cal = Calendar.getInstance();
  ```

  * getInastance(): 태국인 경우 BuddhistCalendar의 인스턴스 반환.
    						   그 이외의 경우, GregorianCalendar의 인스턴스 반환.

* 인스턴스를 직접 생성해서 사용하지 않고, 메서드를 통해 인스턴스를 반환받게 하는 이유는,
  **최소한의 변경으로 프로그램이 동작할 수 있도록 하기 위한 것.**

  ```java
  class MyApplication {
    public static void main(String[] args) {
      Calendar cal = new GregorianCalendar(); // 경우에 따라 이 부분을 변경해야한다.
      ...
    }
  }
  ```

  * 만일 위와 같이 특정 인스턴스를 생성하도록 프로그램이 작성된 경우,
    다른 종류의 인스턴스를 필요로 하는 경우 MyAplication을 변경해야함.

* 하지만, 메서드를 통해서 인스턴스를 얻어오도록 하면, MyApplication을 변경하지 않아도 됨.

  ```java
  class MyApplication {
    public static void main(String[] args) {
      Calendar cal = Calendar.getInstance();
      ...
    }
  }
  ```

  * getInstance()의 값은 달라져야 하겠지만, MyApplication이 변경되지 않아도 되는 것이 중요.
  * getInstance() 메서드가 static인 이유는, 메서드 내의 코드에서 인스턴스 변수를 사용하거나, 인스턴스 메서드를 호출하지 않기 때문.
    또 다른 이유는, getInstance()가 static이 아니면 객체를 생성 후 호출해야하는데, Calendar는 추상 클래스이기 때문.





* 예제1: 'int get(int field)'를 이용해서 원하는 필드의 값을 얻어오는 방법.

  ```java
  import java.util.*;
  
  public class Ex10_1 {
  	public static void main(String[] args) {
  		// 기본적으로 현재날짜와 시간으로 설정된다.
  		Calendar today = Calendar.getInstance();
  		System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
  		System.out.println("월(0~11, 0:1월): " + today.get(Calendar.MONTH));
  		System.out.println("이 해의 몇 째 주: " + today.get(Calendar.WEEK_OF_YEAR));
  		System.out.println("이 달의 몇 째 주: " + today.get(Calendar.WEEK_OF_MONTH));
  		// DATE와 DAY_OF_MONTH는 같다.
  		
  		System.out.println("이 달의 몇 일: " + today.get(Calendar.DATE));
  		System.out.println("이 달의 몇 일: " + today.get(Calendar.DAY_OF_MONTH));
  		System.out.println("이 해의 몇 일: " + today.get(Calendar.DAY_OF_YEAR));
  		System.out.println("요일(1~7, 1:일요일): " + today.get(Calendar.DAY_OF_WEEK));
  		// 1: 일요일, 2: 월요일 ...
  		System.out.println("이 달의 몇 째 요일: " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
  		System.out.println("오전_오후(0:오전, 1:오후): " + today.get(Calendar.AM_PM));
  		System.out.println("시간(0~11): " + today.get(Calendar.HOUR));
  		System.out.println("시간(0~23): " + today.get(Calendar.HOUR_OF_DAY));
  		System.out.println("분(0~59): " + today.get(Calendar.MINUTE));
  		System.out.println("초(0~59): " + today.get(Calendar.SECOND));
  		
  		System.out.println("1000분의 1초(0~999): " + today.get(Calendar.MILLISECOND));
  		// 천분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다.(1시간 = 60*60초)
  		System.out.println("TimeZone(-12~+12): " + (today.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
  		System.out.println("이 달의 마지막 날: " + today.getActualMaximum(Calendar.DATE)); 
  		// 이 달의 마지막일을 찾는다.
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > 이 해의 년도 : 2020
  >
  > 월(0~11, 0:1월): 8
  >
  > 이 해의 몇 째 주: 40
  >
  > 이 달의 몇 째 주: 5
  >
  > 이 달의 몇 일: 29
  >
  > 이 달의 몇 일: 29
  >
  > 이 해의 몇 일: 273
  >
  > 요일(1~7, 1:일요일): 3
  >
  > 이 달의 몇 째 요일: 5
  >
  > 오전_오후(0:오전, 1:오후): 1
  >
  > 시간(0~11): 3
  >
  > 시간(0~23): 15
  >
  > 분(0~59): 39
  >
  > 초(0~59): 14
  >
  > 1000분의 1초(0~999): 299
  >
  > TimeZone(-12~+12): 9
  >
  > 이 달의 마지막 날: 30

  * get메서드의 매개변수로 사용되는 int값들은 Calendar에 정의된 static상수.
  * get(Calendar.MONTH)로 얻어오는 값의 범위가 1~12가 아닌, 0~11이니 주의.



* 예제2: set메서드로 날짜를 설정하고, 현 날짜와의 차이를 구하는 식.

  ```java
  import java.util.*;
  
  public class Ex10_2 {
  	public static void main(String[] args) {
  		// 요일은 1부터 시작하기 때문에, DAY_OF_WEEK[0]은 비워두었다.
  		final String[] DAY_OF_WEEK = { "","일","월","화","수","목","금","토"};
  		
  		Calendar date1 = Calendar.getInstance();
  		Calendar date2 = Calendar.getInstance();
  		
  		// month의 경우 0부터 시작하기 때문에 4월인 경우, 3으로 지정해야한다.
  		// date1.set(2019, Calendar.APRIL, 29);와 같이 할 수도 있다.
  		date1.set(2019, 3, 29); // 2019년 4월 29일로 날짜를 설정한다.
  		System.out.println
  		("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고, ");
  		System.out.println
  		("오늘(date2)은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]+"요일입니다.");
  		
  		// 두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야한다.
  		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
  		System.out.println("그 날(date1)부터 지금(date2)까지 " + difference + "초가 지났습니다.");
  		System.out.println("일(day)로 계산하면 "+ difference/(24*60*60) +"일입니다."); // 1일 = 24*60*60
  	}
  	
  	public static String toString(Calendar date) {
  		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH)+1) 
  				+"월 " + date.get(Calendar.DATE)+ "일 ";
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > date1은 2019년 4월 29일 월요일이고, 
  >
  > 오늘(date2)은 2020년 9월 29일 화요일입니다.
  >
  > 그 날(date1)부터 지금(date2)까지 44841600초가 지났습니다.
  >
  > 일(day)로 계산하면 519일입니다.

  * 두 날짜간의 차이를 구하기 위해 두 날짜를 최소단위인 초단위로 변경한 다음 그 차이를 구한 것.
    getTimeMillis()는 1/1000초 단위로 값을 반환하기 때문에 초단위로 얻기 위해서는 1000으로 나눠주어야 함.
    일단위로 얻기 위해서는 '24(시간) *60(분)\*60(초)\*1000' 으로 나누어야 한다.
  * 예제에서는 변수 difference에 저장할 때 이미 초단위로 변경했기 때문에, 일단위로 변경할 때 '24(시간)*60(분)\*60(초)' 로 나눈 것.



* 예제3: 두 개의 시간 데이터로부터 초 단위로 차이를 구한 뒤, 시분초로 바꿔 출력하는 예제.

  ```java
  import java.util.*;
  
  public class Ex10_3 {
  	public static void main(String[] args) {
  		final int[] TIME_UNIT = {3600, 60, 1}; // 큰 단위를 앞에 놓는다.
  		final String[] TIME_UNIT_NAME = {"시간 ","분 ","초 "};
  		
  		Calendar time1 = Calendar.getInstance();
  		Calendar time2 = Calendar.getInstance();
  		
  		time1.set(Calendar.HOUR_OF_DAY, 10); // time1을 10시 20분 30초로 설정 
  		time1.set(Calendar.MINUTE, 20);
  		time1.set(Calendar.SECOND, 30);
  		
  		time2.set(Calendar.HOUR_OF_DAY, 20); // time1을 20시 30분 10초로 설정 
  		time2.set(Calendar.MINUTE, 30);
  		time2.set(Calendar.SECOND, 10);
  		
  		System.out.println("time1 :"+time1.get(Calendar.HOUR_OF_DAY)+"시 "
  				+time1.get(Calendar.MINUTE)+"분 "+time1.get(Calendar.SECOND)+"초 ");
  		System.out.println("time2 :"+time2.get(Calendar.HOUR_OF_DAY)+"시 "
  				+time2.get(Calendar.MINUTE)+"분 "+time2.get(Calendar.SECOND)+"초 ");
  		
  		long difference = 
  				Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) /1000;
  		System.out.println("time1과 time2의 차이는 "+difference+"초 입니다.");
  		
  		String tmp = "";
  		for(int i=0; i<TIME_UNIT.length;i++) {
  			tmp += difference/TIME_UNIT[i]+TIME_UNIT_NAME[i];
        // difference = difference%TIME_UNIT[i];
        // 가장 큰 단위인 시간 단위(3600초)로 나누고 남은 나머지를 다시 분 단위(60초)로 나누면 그 나머지는 초 단위의 값이 됨.
  			difference %= TIME_UNIT[i];
  		}
  		System.out.println("시분초로 변환하면 "+tmp+"입니다.");
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > time1 :10시 20분 30초 
  >
  > time2 :20시 30분 10초 
  >
  > time1과 time2의 차이는 36580초 입니다.
  >
  > 시분초로 변환하면 10시간 9분 40초 입니다.



* 예제4: 

  ```java
  import java.util.*;
  
  public class Ex10_4 {
  	public static void main(String[] args) {
  		Calendar date = Calendar.getInstance();
  		date.set(2019, 7, 31); //2019년 8월 31일
  		
  		System.out.println(toString(date));
  		System.out.println("= 1일 후 =");
  		date.add(Calendar.DATE, 1);
  		System.out.println(toString(date));
  		
  		System.out.println("= 6달 전=");
  		date.add(Calendar.MONTH, -6);
  		System.out.println(toString(date));
  		
  		System.out.println("= 31일 후(roll) =");
  		date.roll(Calendar.DATE, 31);
  		System.out.println(toString(date));
      
      	System.out.println("= 31일 후(add) =");
  		date.add(Calendar.DATE, 31);
  		System.out.println(toString(date));
  	}
  	
  	public static String toString(Calendar date) {
  		return date.get(Calendar.YEAR)+"년 "+(date.get(Calendar.MONTH)+1) 
  				+"월 "+ date.get(Calendar.DATE)+"일 ";
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > 2019년 8월 31일 
  >
  > = 1일 후 =
  >
  > 2019년 9월 1일 
  >
  > = 6달 전=
  >
  > 2019년 3월 1일 
  >
  > = 31일 후(roll) =
  >
  > 2019년 3월 1일 
  >
  > = 31일 후(add) =
  >
  > 2019년 4월 1일 

  * 'add(int field, int amount)'를 사용 시:
    지정한 필드의 값을 원하는 만큼 증가 또는 감소 시킬 수 있다.
    특정 날짜 또는 시간을 기점으로 해서 일정기간 전 후의 날짜와 시간을 알아낼 수 있다.

  * 'roll(int field, int amount)':
    지정한 필드의 값을 증가 또는 감소시킬 수 있다.
    다른 필드에 영향을 미치지 않음.
    ex) add메서드로 날짜필드(Calendar.DATE)의 값을 31만큼 증가시켰다면, 다음 달로 넘어가므로 월 필드(Calendar.MONTH)의 값도 1증가하지만,
    roll메서드는 같은 경우 월 필드의 값은 변하지 않고 일 필드의 값만 바뀜.

    **단, 일 필드가 말일이라면, roll메서드를 이용해서 월 필드를 변경하면 일 필드에 영향을 미칠 수 있다.**



* 예제 5:

  ```java
  import java.util.*;
  
  public class Ex10_5 {
  	public static void main(String[] args) {
  		if(args.length !=2) {
  			System.out.println("Usage : java Ex10_5 2019 9");
  			return;
  		}
  		int year = Integer.parseInt(args[0]);
  		int month = Integer.parseInt(args[1]);
  		int START_DAY_OF_WEEK = 0;
  		int END_DAY = 0;
  		
  		Calendar sDay = Calendar.getInstance(); //시작일
  		Calendar eDay = Calendar.getInstance(); //끝일
  		
  		//월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 한다.
  		//예를 들어, 2019년 11월 1일은 sDay.set(2019, 10, 1);과 같이 해줘야 한다.
  		sDay.set(year, month-1, 1);
  		eDay.set(year, month, 1);
  		
  		//다음달의 첫날(12월 1일)에서 하루를 빼면 현재달의 마지막 날(11월 30일)이 된다.
  		eDay.add(Calendar.DATE, -1);
  		
  		//첫 번째 요일이 무슨 요일인지 알아낸다.
  		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
  		
  		//eDay에 지정된 날짜를 얻어온다.
  		END_DAY = eDay.get(Calendar.DATE);
  		
  		System.out.println("       " +args[0]+"년 "+args[1]+"월 ");
  		System.out.println(" SU MO TU WE TH FR SA");
  		
  		//해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
  		//만일 1일이 수요일이라면 공백을 세 번 찍는다.(일요일부터 시작)
  		for(int i=1; i< START_DAY_OF_WEEK; i++)
  			System.out.print("   ");
  		
  		for(int i=1, n = START_DAY_OF_WEEK; i<=END_DAY;i++,n++) {
  			System.out.print((i<10)?" "+i:" "+i);
  			if(n%7==0) System.out.println();
  		}
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > 입력한 년도와 월의 달력이 나온다.



## 03. Date와 Calendar간의 변환

* Calendar가 새로 추가되면서 Date는 대부분의 메서드가 'deprecated'되었으므로 잘 사용되지 않음.

* 그럼에도 Date를 필요로 하는 메서드들이 있기 때문에, Calendar를 Date로 또는 그 반대로 변환할 일이 생길 때 사용 법은 아래와 같다.

  1. Calendar를 Date로 변환

     ```java
     Calendar cal = Calendar.getInstance();
     ...
     Date d = new Date(cal.getTimeInMillis()); // Date(long date)
     ```

  2. Date를 Calendar로 변환

     ```java
     Date d = new Date();
     ...
     Calendar cal = Calendar.getInstance();
     cal.setTime(d)
     ```



## 04. 형식화 클래스

* 이 클래스는 java.text패키지에 포함되어 있으며 숫자, 날짜, 텍스트 데이터를 일정한 형식에 맞게 표현할 수 있는 방법을 객체지향적으로 설계하여 표준화 함.
* 형식화에 사용될 패턴을 정의하는데, 데이터를 정의된 패턴에 맞춰 형식화 할 수 있을 뿐만 아니라 역으로 형식화된 데이터에서 원래의 데이터를 얻어낼 수도 있다.
* ex) "123"과 같은 문자열을 Integer.parseInt()를 사용해 123이라는 숫자로 변환하는 것.
* 대표적으로 DecimalFormat이 있다.



## 05. DecimalFormat

* 형식화 클래스 중, 숫자를 형식화 하는 데 사용되는 DecimalFormat.
* 숫자 데이터를 정수, 부동소수점, 금액 등의 다양한 형식으로 표현할 수 있으며, 일정한 형식의 텍스트 데이터를 숫자로 쉽게 변환하는 것도 가능.
  

| 기호   | 의미                     | 패턴                                                         | 결과(1234567.89)                                             |
| ------ | ------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 0      | 10진수(값이 없을 때는 0) | 0<br />0.0<br />0000000000.0000                              | 1234568<br />1234567.9<br />00012345677.8900                 |
| #      | 10진수                   | #<br />#.#<br />##########.####                              | 1234568<br />1234567.9<br />1234567.89                       |
| .      | 소수점                   | #.#                                                          | 1234567.9                                                    |
| -      | 음수부호                 | #.#-<br />-#.#                                               | 1234567.9-<br />-1234567.9                                   |
| ,      | 단위 구분자              | #,###.##<br />#,####.##                                      | 1,234,567.89<br />123,4567.89                                |
| E      | 지수기호                 | #E0<br />0E0<br />##E0<br />00E0<br />####E0<br />0000E0<br />#.#E0<br />0.0E0<br />0.000000000E0<br />00.00000000E0<br />000.0000000E0<br />#.#########E0<br />##.########E0<br />###.#######E0 | .1E7<br />1E6<br />1.2E6<br />12E5<br />123.5E4<br />1235E3<br />1.2E6<br />1.2E6<br />1.234567890E6<br />12.34567890E5<br />123.4567890E4<br />1.23456789E6<br />1.23456789E6<br />1.23456789E6 |
| ;      | 패턴구분자               | #,###.##+;#,###.##-                                          | 1,234,567.89+ (양수일 때)<br />1,234,567.89- (음수일 때)     |
| %      | 퍼센트                   | #.#%                                                         | 123456789%                                                   |
| \u2030 | 퍼밀(퍼센트x10)          | #.#\u2030                                                    | 1234567890‰                                                  |
| \u00A4 | 통화                     | \u00A4 #,###                                                 | ₩ 1,234,568                                                  |
| '      | escape문자               | '#'#,###<br />''#,###                                        | #1,234,568<br />'1,234,568                                   |

* 사용하는 방법:
  원하는 출력형식의 패턴을 작성하여 DecimalFormat인스턴스를 생성한 다음, 출력하고자 하는 문자열로 format메서드를 호출하면
  원하는 패턴에 맞게 변환된 문자열을 얻게됨.

  ```java
  double number = 1234567.89;
  DecimalFormat df = new DecimalFormat("#.#E0");
  String result = df.format(number); // result = "1.2E6"
  ```





* 예제1:

  ```java
  import java.text.*;
  
  public class Ex10_6 {
  	public static void main(String[] args) throws Exception {
  		double number = 1234567.89;
  		String[] pattern = {
  				"0",
  				"#",
  				"0.0",
  				"#.#",
  				"0000000000.0000",
  				"##########.####",
  				"#.#-",
  				"-#.#",
  				"#,###.##",
  				"#,####.##",
  				"#E0",
  				"0E0",
  				"##E0",
  				"00E0",
  				"####E0",
  				"0000E0",
  				"#.#E0",
  				"0.0E0",
  				"0.000000000E0",
  				"00.00000000E0",
  				"000.0000000E0",
  				"#.#########E0",
  				"##.########E0",
  				"###.#######E0",
  				"#,###.##+;#,###.##-",
  				"#.#%",
  				"#.#\u2030",
  				"\u00A4 #,###",
  				"'#'#,###",
  				"''#,###",
  		};
  		
  		for(int i=0; i<pattern.length;i++) {
  			DecimalFormat df = new DecimalFormat(pattern[i]);
  			System.out.printf("%19s : %s\n", pattern[i],df.format(number));
  		}
  	}// main
  }
  ```

  > 위 코드의 결과:
  >
  > ​         0 : 1234568
  >
  > ​         \# : 1234568
  >
  > ​        0.0 : 1234567.9
  >
  > ​        \#.# : 1234567.9
  >
  >   0000000000.0000 : 0001234567.8900
  >
  >   \##########.#### : 1234567.89
  >
  > ​        \#.#- : 1234567.9-
  >
  > ​        -#.# : -1234567.9
  >
  > ​      \#,###.## : 1,234,567.89
  >
  > ​     \#,####.## : 123,4567.89
  >
  > ​        \#E0 : .1E7
  >
  > ​        0E0 : 1E6
  >
  > ​        \##E0 : 1.2E6
  >
  > ​        00E0 : 12E5
  >
  > ​       \####E0 : 123.5E4
  >
  > ​       0000E0 : 1235E3
  >
  > ​       \#.#E0 : 1.2E6
  >
  > ​       0.0E0 : 1.2E6
  >
  >    0.000000000E0 : 1.234567890E6
  >
  >    00.00000000E0 : 12.34567890E5
  >
  >    000.0000000E0 : 123.4567890E4
  >
  >    \#.#########E0 : 1.23456789E6
  >
  >    \##.########E0 : 1.23456789E6
  >
  >    \###.#######E0 : 1.23456789E6
  >
  > \#,###.##+;#,###.##- : 1,234,567.89+
  >
  > ​        \#.#% : 123456789%
  >
  > ​        \#.#‰ : 1234567890‰
  >
  > ​      ¤ #,### : ₩ 1,234,568
  >
  > ​      '#'#,### : #1,234,568
  >
  > ​      ''#,### : '1,234,568



* 예제2: 패턴을 이용해서 숫자를 변환하는 예제.

  ```java
  import java.text.*;
  
  public class Ex10_7 {
  	public static void main(String[] args) {
  		DecimalFormat df = new DecimalFormat("#,###.##");
  		DecimalFormat df2 = new DecimalFormat("#.###E0");
  		
  		
  		try {
  			Number num = df.parse("1,234,567.89");
  			System.out.print("1,234,567.89"+"->");
  			
  			double d = num.doubleValue();
  			System.out.print(d+"->");
  			
  			System.out.println(df2.format(num));
  		} catch(Exception e) {}
  	}//main
  }
  ```

  > 위 코드의 결과:
  > 1,234,567.89->1234567.89->1.235E6

  * parse메서드를 이용하면, 기호와 문자가 포함된 문자열을 숫자로 쉽게 변환할 수 있다.

  * parse(String source)는 DecimalFormat의 조상인 NumberFormat에 정의된 메서드.

  * 선언부:

    > public Number parse(String source) throws ParseException

  * Number클래스는 Integer, Double과 같은 숫자를 저장하는 래퍼 클래스의 조상.
    doubleValue()는 Number에 저장된 값을 double형의 값으로 변환하여 반환.
    이외에도 intValue(), floatValue()등의 메서드가 Number클래스에 정의되어있다.



## 06. SimpleDateFormat

* Date와 Calendar만으로 날자 데이터를 원하는 형태로 다양하게 출력하는 것은 복잡하므로, 이 기능을 사용하면 좋다.
* DateFormat은 추상클래스로, SimpleDateFormat의 조상.
  DateFormat은 인스턴스를 생성하기 위해서는 getDateInstance()와 같은 static메서드를 이용해야함.
  반환되는 것은 DateFormat을 상속받아 완전하게 구현한 SimpleDateFormat인스턴스.

| 기호 | 의미                                   | 보기             |
| ---- | -------------------------------------- | ---------------- |
| G    | 연대(BC, AD)                           | AD               |
| y    | 년도                                   | 2006             |
| M    | 월(1~12 또는 1월 ~ 12월)               | 10또는 10월, OCT |
| w    | 년의 몇 번째 주(1~53)                  | 50               |
| W    | 월의 몇 번째 주(1~5)                   | 4                |
| D    | 년의 몇 번째 일(1~366)                 | 100              |
| d    | 월의 몇 번째 일(1~31)                  | 15               |
| F    | 월의 몇 번째 요일(1~5)                 | 1                |
| E    | 요일                                   | 월               |
| a    | 오전/오후(AM, PM)                      | PM               |
| H    | 시간 (0~23)                            | 20               |
| k    | 시간(1~24)                             | 13               |
| K    | 시간(0~11)                             | 10               |
| h    | 시간(1~12)                             | 11               |
| m    | 분(0~59)                               | 35               |
| s    | 초(0~59)                               | 55               |
| S    | 천분의 일초(0~999)                     | 253              |
| z    | Time zone(General time zone)           | GMT +9:00        |
| Z    | Time zone(RFC 822 time zone)           | +0900            |
| '    | escape문자(특수문자를 표현하는데 사용) | 없음             |

* SimpleDateFormat을 사용하는 방법:
  위의 표를 참고하여 원하는 출력형식의 패턴을 작성해, SimpleDateFormat인스턴스를 생성한 다음, 출력하고자 하는 Date인스턴스를 가지고 format(Date d)를 호출하면 지정한 출력형식에 맞게 변환된 문자열을 얻음.

  ```java
  Date today = new Date();
  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  
  //오늘 날짜를 yyyy-MM-dd형태로 변환하여 반환한다.
  String result = df.format(today);
  ```

  

* 예제1: 자주 사용될 만한 패턴을 만들어서 다양한 형식으로 예제가 실행된 날짜와 시간을 출력한 예제.

  ```java
  import java.util.*;
  import java.text.*;
  
  public class Ex10_8 {
  	public static void main(String[] args) {
  		Date today = new Date();
  		
  		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
  		SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;
  		
  		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
  		sdf2 = new SimpleDateFormat("''yy년 MMM dd일 E요일");
  		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
  		
  		sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
  		sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
  		sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
  		sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
  		sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");
  		
  		System.out.println(sdf1.format(today)); // format(Date d)
  		System.out.println(sdf2.format(today));
  		System.out.println(sdf3.format(today));
  		System.out.println(sdf4.format(today));
  		System.out.println();
  		System.out.println(sdf5.format(today));
  		System.out.println(sdf6.format(today));
  		System.out.println(sdf7.format(today));
  		System.out.println(sdf8.format(today));
  		System.out.println(sdf9.format(today));
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > 2020-09-29
  >
  > '20년 9월 29일 화요일
  >
  > 2020-09-29 17:58:57.455
  >
  > 2020-09-29 05:58:57 오후
  >
  > 
  >
  > 오늘은 올 해의 273번째 날입니다.
  >
  > 오늘은 이 달의 29번째 날입니다.
  >
  > 오늘은 올 해의 40번째 주입니다.
  >
  > 오늘은 이 달의 5번째 주입니다.
  >
  > 오늘은 이 달의 5번째 화요일입니다.



* 예제2: parse(String source)를 사용하여 날짜 데이터의 출력형식을 변환하는 방법을 보여주는 예제.

  ```java
  import java.util.*;
  import java.text.*;
  
  public class Ex10_9 {
  	public static void main(String[] args) {
  		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
  		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
  		
  		try {
  			Date d = df.parse("2019년 11월 23일");
  			System.out.println(df2.format(d));
  		} catch(Exception e) {}
  	} // main 
  }
  ```

  > 위 코드의 결과:
  >
  > 2019/11/23

  * Integer의 parseInt()가 문자열을 정수로 변환하는 것 처럼, SimpleDate Format의 parse(String source)는 문자열 source을 날짜 Date인스턴스로 변환해주기 때문에 매우 유용.



* 예제3: 화면으로부터 날짜를 입력받아서 계산결과를 출력하는 예제.

  ```java
  import java.util.*;
  import java.text.*;
  
  public class Ex10_10 {
  	public static void main(String[] args) {
  		String pattern = "yyyy/MM/dd";
  		DateFormat df = new SimpleDateFormat(pattern);
  		Scanner s = new Scanner(System.in);
  		
  		Date inDate = null;
  		
  		System.out.println("날짜를 "+pattern+"의 형태로 입력해주세요.(입력예: 2019/12/31)");
  		while(s.hasNextLine()) {
  			try {
  				inDate = df.parse(s.nextLine());
  				break;
  			} catch(Exception e) {
  				System.out.println("날짜를 " + pattern + "의 형태로 다시 입력해주세요.(입력예:2019/12/31)");
  			}
  		} // while
  		
  		Calendar cal = Calendar.getInstance();
  		cal.setTime(inDate);
  		Calendar today = Calendar.getInstance();
  		long day = (cal.getTimeInMillis() - today.getTimeInMillis())/(60*60*1000);
  		System.out.println("입력하신 날짜는 현재와 "+day+"시간 차이가 있습니다.");
  	} // main
  }
  ```

  > 위 코드의 결과:
  >
  > 날짜를 yyyy/MM/dd의 형태로 입력해주세요.(입력예: 2019/12/31)
  >
  > 20191231
  >
  > 날짜를 yyyy/MM/dd의 형태로 다시 입력해주세요.(입력예:2019/12/31)
  >
  > 2019/12/31
  >
  > 입력하신 날짜는 현재와 -6570시간 차이가 있습니다.

  * 지정된 패턴으로 입력되지 않은 경우, parse메서드를 호출하는 부분에서 예외(Parse Exception)가 발생하기 때문에 while문을 벗어나지 못함.

