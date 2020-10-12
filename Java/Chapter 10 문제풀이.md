## Chapter 10. 연습문제

**[10-1] Calendar클래스와 SimpleDateFormat클래스를 이용해서 2020년의 매월 두 번째 일요일의 날짜를 출력하시오.**

> 결과:



**[10-2] 화면으로부터 날짜를 "2017/05/11"의 형태로 입력받아서 무슨 요일인지 출력하는 프로그램을 작성하시오. 단. 입력된 날짜의 형식이 잘못된 경우 메세지를 보여주고 다시 입력받아야 한다.**

```java
import java.util.*;
import java.text.*; 

public class Exercise10_2 {
	public static void main(String[] args) {
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Scanner s = new Scanner(System.in);
		
		Date inDate = null;
		
		System.out.println("날짜를"+pattern+"의 형태로 입력해주세요.(입력예:2017/05/11)");
		while(s.hasNextLine()) {
			try {
				inDate = df.parse(s.nextLine());
				break;
			} catch(Exception e) {
				System.out.println("날짜를" +pattern+"의 형태로 다시 입력해주세요.(입력예:2017/05/11");
			}
		}
		SimpleDateFormat sdf;
		
		sdf = new SimpleDateFormat("입력하신 날짜는 E요일입니다.");
		
		System.out.println(sdf.format(inDate));
	}
}

```

* 결과:

  날짜를yyyy/MM/dd의 형태로 입력해주세요.(입력예:2017/05/11)

  2039

  날짜를yyyy/MM/dd의 형태로 다시 입력해주세요.(입력예:2017/05/11)

  2020/09/30

  입력하신 날짜는 수요일입니다.



**[10-3] 어떤 회사의 월급날이 매월 21일이다. 두 날짜 사이에 월급날이 몇 번 있는지 계산해서 반환하는 메서드를 작성하고 테스트 하시오.**

```java
import java.util.*;
import java.text.*;

public class Exercise10_3 {
	static int paycheckCount(Calendar from, Calendar to) {
		/*
		 * (1) 아래의 로직에 맞게 코드를 작성하시오.
		 * 1. from또는 to가 null이면 0을 반환한다.
		 * 2. from와 to가 같고 날짜가 21일이면 1을 반환한다.
		 * 3. to와 from이 몇 개월 차이인지 계산해서 변수 monDiff에 담는다.
		 * 4. monDiff가 음수이면 0을 반환한다.
		 * 5. 만일 from의 일(DAY_OF_MONTH)이 21이거나 이전이고
		 * to의 일(DAY_OF_MONTH)이 21일이거나 이후이면 monDiff의 값을 1 증가시킨다.
		 * 6. 만일 from의 일(DAY_OF_MONTH)이 21일 이후고
		 * to의 일(DAY_OF_MONTH)이 21일 이전이면 monDiff의 값을 1 감소시킨다. 
		 */
		
		return monDiff;
	}
	
	static void printResult(Calendar from, Calendar to) {
		Date fromDate = from.getTime();
		Date toDate = to.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print(sdf.format(fromDate) + "~" +sdf.format(toDate)+":");
		System.out.println(paycheckCount(from, to));
	}
	
	public static void main(String[] args) {
		Calendar fromCal = Calendar.getInstance();
		Calendar toCal = Calendar.getInstance();
		
		fromCal.set(2020, 0, 1);
		toCal.set(2020, 0, 1);
		printResult(fromCal, toCal);
		
		fromCal.set(2020, 0, 21);
		toCal.set(2020, 0, 21);
		printResult(fromCal, toCal);
		
		fromCal.set(2020, 0, 1);
		toCal.set(2020, 2, 1);
		printResult(fromCal, toCal);
		
		fromCal.set(2020, 0, 1);
		toCal.set(2020, 2, 23);
		printResult(fromCal, toCal);
		
		fromCal.set(2020, 0, 23);
		toCal.set(2020, 2, 21);
		printResult(fromCal,toCal);
		
		fromCal.set(2021, 0, 22);
		toCal.set(2020, 2, 21);
		printResult(fromCal,toCal);
	}
}

```

* (1)

  ```java
  int fday = from.get(Calendar.DAY_OF_MONTH);
  		int tday = to.get(Calendar.DAY_OF_MONTH);
  		int fm = from.get(Calendar.MONTH);
  		int tm = to.get(Calendar.MONTH);
  		
  		if (from == null || to == null) {
  			return 0;
  		}
  		
  		if (from.equals(to) && fday == 21 ) {
  			return 1;
  		}
  		
  		//int monDiff = tm-fm;
  		int monDiff = (to.get(Calendar.YEAR) * 12 + tm) - (from.get(Calendar.YEAR) * 12 + fm);
  		
  		if (monDiff <0) {
  			return 0;
  	}
  		if (fday <=21 && tday >=21) {
  			monDiff++;
  		}
  		
  		if (fday >21 && tday <21 ) {
  			monDiff--;
  		}
  		
  		return monDiff;
  	}
  ```

  



**[10-4] 자신이 태어난 날부터 지금까지 며칠이 지났는지 계산해서 출력하시오.**

> 문제 내의 결과:
>
> birth day=2000-01-01
>
> today=2016-01-29
>
> 5872days

```java
import java.util.*;

public class Exercise10_4 {
	public static void main(String[] args) {
		
		Calendar date1= Calendar.getInstance();
		Calendar date2= Calendar.getInstance();
		
		date1.set(1998, 0, 19);
		System.out.println("birth day="+ toString(date1));
		System.out.println("today="+toString(date2));
		
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		System.out.println(difference/(24*60*60)+"days");
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"-"+(date.get(Calendar.MONTH)+1) + "-" + date.get(Calendar.DATE);
	}
}
```

* birth day=1998-1-19

  today=2020-9-30

  8290days

