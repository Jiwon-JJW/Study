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

* (1) 수식 사용 방법을 잘 모르겠습니다..

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

  잘 모르겠습니다.. 6-18 응용 같은 느낌인데..





## Chapter 07. 객체지향 프로그래밍 2



**[7-1] 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)을 정의 한 것이다. 섯다카드 20장을 담는 SutdaCard배열을 초기화 하시오. 단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고, 숫자가 1,3,8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다. 즉, SutdaCard의 인스턴스 변수 isKwang의 값이 true이어야 한다.**

```java
class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		/* 
		 		(1) 배열 sutdaCard를 적절히 초기화 하시오.
		*/
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1,true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num=num;
		this.isKwang=isKwang;
	}
	
	public String toString() {
		return num+(isKwang ? "K" : "");
	}
}

public class Exercise7_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		for (int i = 0; i<deck.cards.length; i++)
			System.out.print(deck.cards[i]+",");
	}
}

[결과]
1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10,
```

(1)  

* 순서대로 입력하는 걸 사용 해봄... (결과 null..)

```java
	SutdaDeck() {
		int num = 0;
		int[] cards = new int [CARD_NUM];
		
		for(int i =0;i<2;i++) {
			for(int j=1; j<=10;j++) {
				cards[i] = j;
				num++;
			}
		}
	}
}
```

* 1,3,8은 광이어야 해서 쓴 것인데.. 이후 출력을 어떻게 해야하는걸까요..

  ```java
  		int[] cards = new int [CARD_NUM];
  		for(int i =0;i<cards.length;i++) {
  			if (i == 1 || i ==3 || i ==8) {
  				
  ```





**[7-2] 문제7-1의 SutdaDeck클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트 하시오.**

>  ([주의] Math.random()를 사용하는 경우 실행결과와 다를 수 있음.)

> 1. 메서드명 : shuffle
>
>    기능 : 배열 cards에 담긴 카드의 위치를 뒤섞는다. (Math.random() 사용)
>
>    반환타입 : 없음
>
>    매개변수 : 없음
>    
>2. 메서드명 : pick
> 
>   기능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
> 
>   반환타입 : SutdaCard
> 
>   매개변수 : int index - 위치
> 
>   
> 
>3. 메서드명 : pick 
> 
>   기능 : 배열 cards에서 임의의 위치의 SutdaCard를 반환한다. (Math.random() 사용)
> 
>   반환타입 : SutdaCard
> 
>   매개변수 : 없음  

```java
class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() { 
		/* 
		 문제 7-1의 답이므로 내용생략  
		*/
	} 

	/* 
	 (1) 위에 정의된 세 개의 메서드를 작성하시오. 
	*/

} // SutdaDeck


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

	public String toString() {
		return num + (isKwang ? "K" : "");

	}

}

class Exercise7_2 {

	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();

		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();

		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");

		System.out.println();
		System.out.println(deck.pick(0));

	}

}

[결과]
7
2,10,1K,7,3,10,5,7,8,5,1,2,9,6,9,4,8K,4,3K
  2
```

* (1) 지정된 위치의 값을 반환하는 방법에 대한 수식을 잘 모르겠습니다.. 

  ```java
  	void shuffle() {
  	    for (int i = 0; i < cards.length; i++) {
  	        int j = (int) (Math.random() % cards.length);
  	        SutdaCard tmp = 0;
  	        
  	        tmp = cards[i];
  	        cards[i]=cards[j];
  	        cards[j]=tmp;
          
    SutdaCard pick(int index) {???}
  	void pick() {???}
  ```



**[7-3] 다음의 코드는 컴파일하면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기 위해서는 코드를 어떻게 바꾸어야 하는가?**

```java
class Product{
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint=(int)(price/10.0);
	}
}

class Tv extends Product{
	Tv() {}
	
	public String toString() {
		return "Tv";
	}
}
public class Exercise7_3 {
	public static void main(String[] args) {
		Tv t =new Tv();
	}
}
```

* 에러가 발생하는 이유는, 생성자 Product가 정의 되지 않았기 때문에.
  해결하는 방법은, Product클래스에 Product(){}를 지정해 줘야한다.



**[7-4] MyTv클래스의 멤버변수 isPowerOn, channel, volume을 클래스 외부에서 접근할 수 없도록 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록 getter와 setter에서 메서드를 추가하시오.**

```java
class MyTv {

	boolean isPowerOn;
	int channel;
	int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1; 

        /* (1) 알맞은 코드를 넣어 완성하시오. */
}

public class Exercise7_4 {

	public static void main(String args[]) {
		MyTv2 t = new MyTv2();
		t.setChannel(10);
    
		System.out.println("CH:" + t.getChannel());
		t.setVolume(20);

		System.out.println("VOL:" + t.getVolume());
	}
}
```

* (1)

  ```java
  	public void setChannel(int channel) {
  		this.channel=channel;
  		if (channel >MIN_CHANNEL || MAX_CHANNEL > channel)
  			return;
  	}
  	
  	public int getChannel() {
  		return channel;
  }
  
  	public void setVolume(int volume) {
  		this.volume=volume;
  		if (volume >MIN_VOLUME || MAX_VOLUME > volume)
  			return;
  	}
  	
  	public int getVolume() {
  		return volume;	}
  	
  	public void turnOnOff() {
  		this.isPowerOn =!isPowerOn;
  		}
  ```



**[7-5] 문제7-4에서 작성한 MyTv2클래스에 이전 채널(previous channel)로 이동하는 기능의 메서드를 추가해서 실행결과와 같은 결과를 얻도록 하시오.**

> 이전 채널의 값을 저장할 멤버변수를 정의하라.

```java
class MyTv2 { 

	/*  
	(1)문제 7-10의 MyTv2클래스에 gotoPrevChannel 메서드를 추가하여 완성하시오. 
	*/

}



class Exercise7_5 {

	public static void main(String args[]) {

		MyTv2 t = new MyTv2();
		t.setChannel(10);
		System.out.println("CH:" + t.getChannel());
		t.setChannel(20);
		System.out.println("CH:" + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());
	}
}

[실행결과]

CH:10

CH:20

CH:10

CH:20
```

* (1)

  ```java
  	public void setChannel(int channel) {
  		Prevchannel=this.channel;
		this.channel=channel;
  		if (channel >MIN_CHANNEL || MAX_CHANNEL > channel)
  			return;
  
    private int Prevchannel;
  	
  	public void getPrevChannel() {
  	 setChannel(Prevchannel);
  	}
  	
  ```
  





**[7-6] Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.**

```java
class Outer7_6 {
	class Inner {
		int iv = 100;
	}
}

class Exercise7_6 {
	public static void main(String[] args) { 

		/* (1) 알맞은 코드를 넣어 완성하시오. */

	}
}

[실행결과]
100
```

* (1)

  ```java
  	Outer7_6 T = new Outer7_6();
  	Outer7_6.Inner Te = T.new Inner();
  	
  	System.out.println(Te.iv);
  ```



**[7-7]Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.**

```java
class Outer7_7 {
	class Inner {
		int iv = 200;
	}
}

class Exercise7_7 {
	public static void main(String[] args) { 

		/* (1) 알맞은 코드를 넣어 완성하시오. */

	}
}

[실행결과]
200
```

* (1)

  ```java
  		Outer7_7 T = new Outer7_7();
  		Outer7_7.Inner Te = T.new Inner();
  		
  		System.out.println(Te.iv);
  ```

  



**[7-8]다음과 같은 실행결과를 얻도록 (1)~(4)의 코드를 완성하시오.**

```java
class Outer {
	int value = 10;

	class Inner {
		int value = 20;

		void method1() {
			int value = 30;

			System.out.println(/* (1) */);
			System.out.println(/* (2) */);
			System.out.println(/* (3) */);

		} // Inner 클래스의 끝
	}// Outer클래스의 끝
}

class Exercise7_8 {
	public static void main(String args[]) {

		/* (4) 알맞은 코드를 넣어 완성하시오 . */

		inner.method1();
	}
}

[실행결과]
30
20
10
```

* (1)

  ```java
  value
  ```

* (2)

  ```java
  this.value
  ```

* (3)

  ```java
  Outer.this.value
  ```

* (4)

  ```java
  		Outer outer = new Outer();
  		Outer.Inner inner = outer.new Inner();
  
  		
  		inner.method1();
  ```



**[7-9]아래의 EventHandler를 익명 클래스(annoymous class)로 변경하시오.**

```java
import java.awt.*;
import java.awt.event.*;

class Exercise7_9 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.addWindowListener(new EventHandler());
	}
}



class EventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
  }
}
```

* 변경 후:

  ```java
  import java.awt.*;
  import java.awt.event.*;
  
  public class Exercise7_9 {
  	public static void main(String[] args) {
  		Frame f = new Frame();
  		f.addWindowListener(new WindowAdapter() {
  		public void windowClosing(WindowEvent e) {
  			e.getWindow().setVisible(false);
  			e.getWindow().dispose();
  			System.exit(0);
  		}
  	  }
  	);
  	}
  }
  ```

  