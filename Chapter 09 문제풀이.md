# Chapter 09. 연습문제

**[9-1] 다음과 같은 실행결과를 얻도록 SutdaCard클래스의 equals()를 멤버변수인 num, isKwang의 값을 비교하도록 오버라이딩하고 테스트 하시오.**

```java
public class Exercise9_1 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		
		System.out.println("c1=" + c1);
		System.out.println("c2=" + c2);
		System.out.println("c1.equals(c2):" + c1.equals(c2));
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public boolean equals(Object obj) {
		/*
		 *(1) 매개변수로 넘겨진 객체의 num, isKwang과
		 * 멤버변수 num, isKwang을 비교하도록 오버라이딩 하시오.
		 */
	}
	
	public String toString() {
		return num + (isKwang ? "K":"");
	}
}

결과:
c1 = 3K
c2 = 3K
c1.equals(c2): true
```

* (1)

  ```java
  	if(obj instanceof SutdaCard2)
  			return num ==((SutdaCard2)obj).num; // obj가 Object타입이므로 num값을 참조하기 위해서는타입으로 형변환이 필요하다.
  			
  		else
  			return false; // 타입이 SutdaCard가 아니면 값을 비교할 필요도 없다.
  		}
  ```

  > equals()의 오버라이딩 E9_2 예제 참고



**[9-2] 다음과 같은 실행결과를 얻도록 Point3D클래스의 equals()를 멤버변수인 x,y,z의 값을 비교하도록 오버라이딩하고, toString()은 실행결과를 참고해서 적절히 오버라이딩 하시오.**

```java
public class Exercise9_2 {
	public static void main(String[] args) {
		Point3D p1 = new Point3D(1, 2, 3);
		Point3D p2 = new Pount3D(1, 2, 3);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2?"+ (p1==p2));
		System.out.println("p1.equals(p2)?"+ (p1.equals(p2)));
	}
}

class Point3D {
	int x, y, z;
	
	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	Point3D() {
		this(0, 0, 0);
	}
	
	public boolean equals(Object obj) {
		/*
		 * (1) 인스턴스변수 x, y, z를 비교하도록 오버라이딩하시오.
		 */
	}
	
	public String toSting() {
		/*
		 * (2) 인스턴스변수 x, y, z의 내용을
		 * 출력하도록 오버라이딩하시오.
		 */
	}
}

결과:
[1,2,3]
[1,2,3]
p1==p2? false
p1.equals(p2)? true
```

* (1)

  ```java
  if(obj instanceof Point3D2)
  			return  x ==((Point3D2)obj).x;
  	
  		if(obj instanceof Point3D2)
  			return  y ==((Point3D2)obj).y;
  		
  		if(obj instanceof Point3D2)
  			return  z ==((Point3D2)obj).z;
  		
  		else
  			return false;
  ```

* (2)

  ```java
  return "x: " + x + ", y: "+y + ", z:" + z;
  ```

  



**[9-3] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.**

> * 메서드명: count
>
> * 기       능: 주어진 문자열(src)에 찾으려는 문자열(target)이 몇 번 나오는지 세어서 반환한다.
>
> * 반환타입: int
>
> * 매개변수: String src
>
>   ​			   String target
>
> > String클래스의 indexOf(String str, int fromIndex)를 사용할 것

```java
class Exercise9_3 {
	public static int count(String src, String target) {
		int count = 0; // 찾은 횟수
		int pos = 0; // 찾기 시작할 위치 
		
		/*
		 * (1) 반복문을 사용해서 아래의 과정을 반복한다.
		 * 1. src에서 target을 pos의 위치부터 찾는다.
		 * 2. 찾으면 count의 값을 1 증가시키고, pos의 값을 target.length만큼 증가시킨다.
		 * 3. indexOf의 결과가 -1이면 반복문을 빠져나가서 count를 반환한다.
		 */
	}
	
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	}
}

결과:
3
0
```

* (1)

  ```java
  src.indexOf(target, pos);
  		
  		if (pos!=-1) {
  			count ++;
  			pos += target.length();
  		} else src.indexOf(target)!=-1 {
  			return count;
  		}
  	}
  	
  ```

  > 정답:
  >
  > ```java
  > while(true) {
  > 1. src에서 target을 pos의 위치부터 찾는다. pos = src.indexOf(target,pos);
  > 2. 찾으면 count의 값을 1 증가 시키고,
  > pos의 값을 target.length만큼 증가시킨다.
  > if(pos!=-1) { count++;
  > pos += target.length(); // pos를 찾은 단어 이후로 옮긴다. } else {
  > 3. indexOf의 결과가 -1이면 반복문을 빠져나가서 count를 반환한다. break;
  > } }
  > return count;
  > }
  > ```
  >
  > 



**[9-4] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.**

> * 메서드명: contains
>
> * 기       능: 첫번째 문자열(src)에 두 번째 문자열(target)이 포함되어 있는지 확인한다.
>
>     			  포함되어있으면 true, 그렇지 않으면 false를 반환한다.
>
> * 반환타입: boolean
>
> * 매개변수: String src
>
>   ​			   String target
>
> > String클래스의 indexOf()를 사용할 것

```java
public class Exercise9_4 {
	/*
	 * (1) contains메서드를 작성하시오.
	 */
	
	public static void main(String[] args) {
		System.out.println(contains("12345","23"));
		System.out.println(contains("12345","67"));
	}
}

결과:
true
false
```

* (1)

  ```java
  public static boolean contains ( String src, String target) {
    return src.indexOf(target)!=-1;
  }
  ```

  



**[9-5] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.**

> * 메서드명: delChar
>
> * 기       능: 주어진 문자열에서 금지된 문자들을 제거하여 반환한다.
>
> * 반환타입: String
>
> * 매개변수: String src - 변환할 문자열
>
>   ​			   String target - 제거할 문자들로 구성된 문자열
>
> > StringBuffer와 String클래스의 charAt(int i)과 indexOf(int ch)를 사용하라.

```java
public class Exercise9_5 {
	/*
	 * (1) delChar메서드를 작성하시오.
	 */
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + "->" + delChar("(1!2@3^4~5)", "~!@#$%^&&*()"));
		System.out.println("(1 2 3 4\t5)" + "->" + delChar("(1 2 3 4\t5)"," \t"));
	}
}

결과:
(1!2@3^4~5) -> 12345
(1 2 3 4 5) -> (12345)
```

* 잘 모르겠음



**[9-6] 다음은 화면으로부터 전화번호의 일부를 입력받아 일치하는 전화번호를 주어진 문자열 배열에서 찾아서 출력하는 프로그램이다. 알맞은 코드를 넣어 프로그램을 완성하시오.**

> Pattern,Matcher클래스를 사용할 것.

```java
import java.util.*;
import java.util.regex.*;

public class Exercise9_6 {
	public static void main(String[] args) {
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890" };
		
		ArrayList list = new ArrayList();
		Scanner s = new Scanner(System.in);
		
		while (true) {
			System.out.print(">>");
			String input = s.nextLine().trim();
			
			if (input.equals("")) {
				continue;
			} else if (input.equalsIgnoreCase("Q")) {
				System.exit(0);
			}
			
			/*
			 * (1) 알맞은 코드를 넣어 완성하시오.
			 */
			
			if (list.size() > 0) {
				System.out.println(list);
				list.clear();
			} else {
				System.out.println("일치하는 번호가 없습니다.");
			}
		}
		}
	}

결과:
>>
>>
>>asdf
일치하는 번호가 없습니다.
>>
>>
>>0
[012-3456-7890,099-2456-7980, 088-2346-9870, 013-3456-7890 ]
>>234
[012-3456-7890, 088-2346-9870]
>>7890
[012-3456-7890, 013-3456-7890]
>>q
```

* 잘 모르겠음.