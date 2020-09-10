# [Java의 정석 연습문제]

## Chapter 06. 객체지향 프로그래밍

##### [6-2] 다음과 같은 실행 결과를 얻도록 Student클래스에 생성자와 info()를 추가하시오.

```java
class Exercise6_2 {
	public static void main(String[] args) {
		Student s = new Student("홍길동",1,1,100,60,76);
		
	String s = s.info();
	System.out.println(s);
	}
}

class Student {
  /*
  	(1) 알맞은 코드를 넣어 완성하시오
 	*/
}

결과:
홍길동,1,1,100,60,76,236
```

* (1) 

  ```java
  class Student {
  	String name;
  	int ban;
  	int no;
  	int kor;
  	int eng;
  	int math;
  
  	Student(String name, int ban, int no, int kor, int eng, int math) {
  		this.name = name;
  		this.ban = ban;
  		this.no = no;
  		this.kor = kor;
  		this.eng =eng;
  		this.math = math;
  	}
  	
  	public String info() {
  		return name+ ","+ ban+ ","+ kor+ ","+ eng+ "," + math+ "," + (kor+eng+math)+ "," + ((int)((kor+eng+math)/3f*10+0.5f)/10f) ;
  	}
  }
  ```



##### [6-4] 두 점의 거리를 계산하는 getDistance()를 완성하시오.

> 제곱근 계산은 Math.sqrt(double a)를 사용하면 된다.

```java
public class Exercise6_4 {
// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
	static double getDistance(int x,int y, int x1, int y1) {
		/*
				(1)알맞은 코드를 넣어 완성하시오.
		*/
	}
	
	public static void main(String[] args) {
		System.out.println(getDistance(1, 1, 2, 2));
	}
}

결과:
1.4142135623730951
```

* (1) 

  ```java
  public class Exercise6_4 {
  // 두 점 (x,y)와 (x1,y1)간의 거리를 구한다.
  	int x;
  	int y;
  	int x1;
  	int y1;
  	
  	static double getDistance(int x,int y, int x1, int y1) {
  		double no1 = Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1)); // 두점 사이의 거리 공식 : √(x-x1)2+(y-y1)2
  		return no1;
  	}
  	
  	public static void main(String[] args) {
  		System.out.println(getDistance(1, 1, 2, 2));
  	}
  }
  ```

  

**[6-6] 연습문제 6-4에서 작성한 클래스 메서드 getDistance()를 MyPoint클래스의 인스턴스 메서드로 정의하시오.**

```java
class MyPoint {
	int x;
	int y;
	
	MyPoint(int x,int y) {
		this.x = x;
		this.y = y;
	}
	/*
			(1) 인스턴스메서드 getDistance를 작성하시오.
	*/
	
}

public class Exercise6_6 {
	public void main(String[] args) {
		MyPoint p = new MyPoint(1, 1);
		
		// p와 (2,2)의 거리를 구한다.
		System.out.println(p.getDistance(2,2));
	}
}

결과:
1.4142135623730951
```

* (1)

  ```java
  static double getDistance(int x, int y) {
  		double no1;
  		no1= Math.sqrt((x-x)*(x-x)+(y-y)*(y-y));
  		return no1;
  	}
  ```



**[6-8] 다음 중 생성자에 대한 설명으로 옳지 않은 것은? (모두 고르시오)**

a. 모든 생성자의 이름은 클래스의 이름과 동일해야한다.

**b. 생성자는 객체를 생성하기 위한 것이다.**

c. 클래스에는 생성자가 반드시 하나 이상 있어야 한다.

d. 생성자가 없는 클래스는 컴파일러가 기본 생성자를 추가한다.

**e. 생성자는 오버로딩 할 수 없다.**



**[6-10] 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은? (모두 고르시오)**

a. 메서드의 이름이 같아야 한다.

b. 매개변수의 개수나 타입이 달라야 한다.

**c. 리턴타입이 달라야 한다.**

**d. 매개변수의 이름이 달라야한다.**



**[6-12] 다음 중 초기화에 대한 설명으로 옳지 않은 것은? (모두 고르시오)**

a. 멤버 변수는 자동 초기화 되므로 초기화 하지 않고도 값을 참조할 수 있다.

b. 지역변수는 사용하기 전에 반드시 초기화해야 한다.

**c. 초기화 블럭보다 생성자가 먼저 수행된다.**

d. 명시적 초기화를 제일 우선적으로 고려해야 한다.

**e. 클래스 변수보다 인스턴스 변수가 먼저 초기화 된다.**



**[6-14] 다음 중 지역변수에 대한 설명으로 옳지 않은 것은? (모두 고르시오)**

**a. 자동 초기화 되므로 별도의 초기화가 필요 없다.**

b. 지역변수가 선언된 메서드가 종료되면 지역변수도 함께 소멸된다.

c. 매서드의 매개변수로 선언된 변수도 지역변수이다.

d. 클래스 변수나 인스턴스 변수보다 메모리 부담이 적다.

**e. 힙(heap)영역에 생성되며 가비지 컬렉터에 의해 소멸된다.**



**[6-16] 다음 코드의 실행 결과를 예측하여 적으시오.**

```java
class Exercise6_16 {
  public static void main(String str) {
    str += "456";
  }
  
  public static void main(String[] args) {
    String str = "ABC123";
    System.out.println(str);
    change(str);
    System.out.println("After change:"+str)
  }
}
```

* 답변:
  ABC123

  After change: ABC123456



**[6-18] 다음과 같이 정의된 메서드를 작성하고 테스트 하시오**

> * 메서드명: isNumber
>
> * 기능: 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
>   모두 숫자로만 이루어져 있으면 true를 반환하고, 그렇지 않으면 false를 반환한다.
>
>   만일 주어진 문자열이 null이거나 빈문자열""이라면 false를 반환한다.
>
> * 반환타입: boolean
>
> * 매개 변수: String str - 검사할 문자열
>
>   > String 클래스의 char(int i) 메서드를 사용하면 문자열의 i번째 위치한 문자를 얻을 수 있다.

```java
public class Exercise6_18 {

  /*
  		(1)isNumber메서드를 작성하시오.
	*/
	public static void main(String[] args) {
		String str ="123";
		System.out.println(str+"는 숫자입니까?"+isNumber(str));
		
		str= "1234o";
		System.out.println(str+"는 숫자입니까?"+isNumber(str));
	}
}
```

* (1) 잘 모르겠습니다..

  ```java
  	boolean isNumber() { 
  		if (str==null || str.equals(""))
  			return false;
  	}
  ```


**[6-20] 다음과 같이 정의된 메서드를 작성하고 테스트 하시오.**

> * 메서드명: max
>
> * 기능: 주어진 int형 배열의 값 중에서 제일 큰 값을 반환 한다.
>
>   만일 주어진 배열이 null 이거나 크기가 0인경우, -999999를 반환한다.
>
> * 반환 타입: int
>
> * 매개 변수: int[]arr - 최대값을 구할 배열

```java
public class Exercise6_20 {

	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("최대값:" + max(null));
		System.out.println("최대값:" + max(new int[] {})); //크기가 0인 배열 
		
	}
}
```

* (1) 

  ```java
  	int max(int[] data) {
  		if (data == null || data.length == 0) {
  			return -999999;
  	}
  	
  ```

  잘 모르겠습니다..
  