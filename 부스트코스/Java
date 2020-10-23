## 데이터와 연산

* 숫자(Numbers)
  * +, *, -, /
* 문자열(String)
  * length, substring
* 영상/소리/기타 등등



* 이를 구분하는 이유는, 데이터마다 처리하는 방식이 다르기 때문.





### 자바의 데이터 타입

```java
public class Datatype {
	public static void main(String[] args) {
		System.out.println(6); 	     // Number  
		System.out.println("Six");   // String
		
		System.out.println("6");     // String 6
		
		System.out.println(6+6);     // 12
		System.out.println("6"+"6"); // 66 < 결합 연산자가 됨.
		
		System.out.println(6*6);	 // 36
//		System.out.println("6"*"6"); // Error 발생.
		
		System.out.println("1111".length()); // 4 문자열의 길이를 알려주는 연산.
//		System.out.println(1111.length()); 	 // 이러한 연산은 존재하지 않음.
		
		// 타입에 어울리는 연산법이 있기 때문에, 타입을 엄격하게 분류한다.
		// 1. 해당 프로그램에 어떤 종류의 데이터 타입이 있는지 알아가기.
		// 2. 각각의 데이터 타입별로 어떤 연산 방법들이 존재하나 알아가기.
		
	}
}
```



### 숫자와 연산

```java
public class Number {
	public static void main(String[] args) {
		// Operator (연산자) 
		System.out.println(6+2); // 8
		System.out.println(6-2); // 4
		System.out.println(6*2); // 12
		System.out.println(6/2); // 3
		
		System.out.println(Math.PI); // 3.141592653589793
		System.out.println(Math.floor(Math.PI)); //3.0 내림 
		System.out.println(Math.ceil(Math.PI));  //4.0 올림 
	}
}
```





### 문자열의 표현

```java
public class StringApp {
	public static void main(String[] args) {
		System.out.println("Hello World"); // String
//		System.out.println('Hello World'); // Error! ''==Character
		System.out.println('H'); 		   // Character
		System.out.println("H");
		
		System.out.println("Hello "
				+ "World"); // 중간에 엔터를 넣으면, 이클립스 내에서 자동적으로 + 를 넣어줌. 줄바꾸기는 아님.
		
		// new Line
		System.out.println("Hello \nWorld"); 
		
		// escape
		System.out.println("Hello \"World\""); //Hello "World"
		
	}
}
```





### 문자열 다루기

```java
public class StringOperation {
	public static void main(String[] args) {
		
		System.out.println("Hello World".length()); // 문자열의 글자수를 알려준다.
		System.out.println("Hello, [[[name]]] ... bye".replace("[[[name]]]", "egoing")); // 글 바꾸기
		
		// 문자열과 관련된 기능을 이용해, 여러 문제를 해결할 수 있다.
	}
}
```



### 작심삼일이 되었을 때 어떻게 해야 할까

* 절대 "나는 의지가 박약이다" 라고 생각하지 않기.

* 과감히 공부를 중단 후, 배운 것을 되새겨 보며 삶의 문제들과 연결지어 보고, 실제로 해결하기 위해 노력해 본다.
* 이 작업으로 우리가 배우고 있는 것들이 우리의 삶에 쓸모있다는 것을 뇌에 증명할 수 있는 것이다.
* 뇌의 흥분도가 올라가고, "더 공부해도 좋다"는 명령을 내리게 된다.

* **일을 해야할 때와 공부를 해야할 때를 주체적으로 판단할 수 있는 사람이 되자.**



## 변수

#### 변수 지정

* 포장되어 이름이 적혀져 있는 음료수와 같이, 변수를 만들 때 데이터 타입을 지정하는 이유는, 
  데이터 타입을 바로 판단할 수 있기 때문.

```java
public class Variable {
	public static void main(String[] args) {
//		a = 1; 이라고 하면, 자바는 어떤 데이터 타입이 들어가는지 명시를 해주어야한다.
		//  Number -> integer(정수) ... -2, -1, 0, 1, 2...
		int a = 1;
		System.out.println(a);
		
//		int b = 1.1;. int는 정수만 가능한데, 1.1은 실수 이므로
		// real number -> double ... -2.0, -1.0, 0, 1.0, 2.0
		double b = 1.1;
		System.out.println(b);
		
		String c = "Hello World";
		System.out.println(c);
		
		//표현하고자 하는타입이 무엇인지 정확한 파악이 중요하다.
	}
}
```



#### 변수의 효용

```java
public class Letter {

	public static void main(String[] args) {
		
		String name = "egoing";
		//String name = "leezche"; 로 바꾸면, name 내의 내용이 변경됨.
				
		System.out.println("Hello, "+name+" ... "+name+" ... "+name+" ... bye");
		// egoing을 일일히 바꿔야 하는 경우, 변수 사용.
		
		double VAT = 10.0;
		System.out.println(VAT);
		// 변수를 사용하면, 왜 이러한 숫자를,혹은 문자를 사용했는지 의미를 더 빠르게 파악할 수 있다.
		// 값에 이름을 부여하는 것이기 때문.
	}
}
```



#### 데이터 타입의 변환

* 데이터 타입을 컨버팅 하는 것.

  ```java
  public class Casting {
  
  	public static void main(String[] args) {
  		
  		double a = 1.1;
  		double b = 1; // 이러한 식으로 한다면, 1.0으로 컨버팅 된다.
  		//double b = (double) 1; 손실이 없기때문에 그냥 1로 써도 되는 것.
  
  		System.out.println(b);
  
  		// int c = 1.1; 값이 실수이기 때문에, int타입이 허용되지 않음.
  		double d = 1.1;
  		int e = (int) 1.1; // 값의 손실이 있기 때문에 명시적으로 형변환이 필요.
  		// 자바 내에서 잘못 썼을 때, 빨간 밑줄이 생기며 자동으로 변경시켜주는 방법을 제시함.
  		System.out.println(e);
  
  		// 1 to String
  		// 검색하는 능력을 기르기. 문법은 모르더라도, 익숙해지는것이 가장 중요하다.
  		String f = Integer.toString(1);
  		System.out.println(f.getClass()); // getClass는, 해당 변수가, 어떤 데이터 타입인지 알려주는 메서드.
  
  	}
  
  }
  ```



## 프로그래밍

#### 프로그래밍이란 무엇인가.

* 시간의 순서에 따라서 어떠한 일이 일어나는 것들을 "프로그램"이라고 부르고 있다.
* 시간에 따라 컴퓨터가 정해진 순서에 작업을 실행하게 된다면, 업무를 자동적으로 처리할 수 있게 된다.
* 컴퓨터 언어를 이용해, 프로그램을 만드는 것은 업무의 자동화된 처리를 위해서라고 할 수 있다.



#### IOT 프로그램 만들기

```java
package program;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.*;

public class OkJavaGoInHome {

	public static void main(String[] args) {
		
		String id = "Java APT 507";
		
		// Elevator call
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		// Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		// Light on
		Lighting hallLamp = new Lighting(id+ "/ Hall Lamp"); 
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id+ "/ floor Lamp"); 
		floorLamp.on();
	}
}

```

* 강사님이 미리 만들어둔, IOT 프로그램 작동파일을 내 패키지 내에 입력 시켜, 그 것을 활용한 예시.
* 엘리베이터를 1층으로 내리고, 보안을 해제하고, 불을 켜는 등. 집 까지 가는 데에 있어, 자동화가 필요한 부분을 프로그램 코드로 자동화 시킨 것이다.
* "Java APT 507" 의 경우, 반복적으로 사용 되어 변수로 지정해 가독성을 높였다.





#### 디버거

벌레모양 아이콘으로 들어가서 에러를 확인하는 기능.

* 원하는 코드의 위치에 줄번호 왼편에서 더블클릭하면, 브레이크 포인트를 지정할 수 있다.
* Strp Over 버튼을 누르면, 다음 줄에 브레이크 포인트가 생성되어 그 지점까지만 코드가 실행.
* Resume 버튼을 누르면 다음 브레이크 포인트까지 실행 되는 데, 브레이크 포인트가 없다면 끝까지 실행.
* Step Into는 코드의 자세한 실행과정을 알 수 있다.
* Step Return은 원래의 코드로 돌아갈 때 사용.



## 프로그램의 입력과 출력

#### 입력과 출력 - 다이어로그(dialog)

* 프로그램은 입력 정보를 받아서 출력을 하는 것.

* 이전에 만들었던 IOT프로그램을 수정해보자.

  ```java
  import org.opentutorials.iot.Elevator;
  import org.opentutorials.iot.*;
  
  import javax.swing.JOptionPane;
  // popup 창을 띄워, 사용자에게 값을 입력 받도록 하는 메소드. 강의 내에서는 구글링을 통해 이 방법을 알아내었다.
  
  public class OkJavaGoInHomeInput {
  
  	public static void main(String[] args) {
  		
  		String id = JOptionPane.showInputDialog("Enter a ID");
      // 팝업을 했을 때, 팝업 창에 나타나는 세부 내용을 적을 수 있다. (ID가 매번 바뀔 수 있으니, 이러한 작업을 했다.)
  		String bright = JOptionPane.showInputDialog("Enter a Bright level");
  		
  		// Elevator call
  		Elevator myElevator = new Elevator(id);
  		myElevator.callForUp(1);
  		
  		// Security off
  		Security mySecurity = new Security(id);
  		mySecurity.off();
  		
  		// Light on
  		Lighting hallLamp = new Lighting(id+ "/ Hall Lamp"); 
  		hallLamp.on();
  		
  		Lighting floorLamp = new Lighting(id+ "/ floor Lamp"); 
  		floorLamp.on();
      
        // 밝기 조절이 가능한 램프를 추가하였다.
  		DimmingLights moodLamp = new DimmingLights(id+"mood Lamp");
  		moodLamp.setBright(Double.parseDouble(bright));
      // 해당 사항은, setBright의 경우, double값으로 이루어져 있기 때문에, String을 double로 형변환 시켜주는 메소드.
    
  		moodLamp.on();
  	}
  }
  ```





#### 입력과 출력 - 아규먼트(argument) & 파라미터(parameter)

```java
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.*;

public class OkJavaGoInHomeInput {

	// args -> parameter, 매개변수 
	public static void main(String[] args) {
		
		String id = args[0];
		//arguments 에서 입력한 첫번째 값을 입력하겠다. 라는 뜻.
		String bright = args[1];
		//두번째값을 입력.
		
		// Elevator call
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		// Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		// Light on
		Lighting hallLamp = new Lighting(id+ "/ Hall Lamp"); 
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id+ "/ floor Lamp"); 
		floorLamp.on();
		
		DimmingLights moodLamp = new DimmingLights(id+"mood Lamp");
		moodLamp.setBright(Double.parseDouble(bright));
		moodLamp.on();
	}
}
```

* 이클립스에선, Run Configurations 내에서 Aguments를 지정 및 수정 할 수 있다.
* 한 문장을 입력하고싶다면 'Java APT 504'처럼 따옴표 사용하면 된다. 맨 앞부터 args[0]이다.
* 만일 다른 내용의 아규먼트를 입력하고싶다면, Duplicate를 사용해, 복사본을 만들 수 있다.
* Organize favorites 에서 자주 사용하는 Application을 즐겨찾기 할 수 있다.



## 컴파일

