# Chapter 06

## 01. 객체 지향 언어(OOP - Object-Oriented Programming Language)

* 기존의 프로그래밍 언어에 새로운 규칙을 추가한 발전된 형태의 언어.

* 코드간에 서로 관계를 맺어줌으로써, 유기적으로 프로그램을 구성가능 함.

* 주요 특징:

  1. **코드의 재사용성이 높다.**

     새로운 코드를 작성할 때 기존의 코드를 이용하여 쉽게 작성할 수 있다.

  2. **코드의 관리가 용이하다.**
     코드간의 관계를 이용해서 적은 노력으로 쉽게 코드를 변경할 수 있다.

  3. **신뢰성이 높은 프로그래밍을 가능하게 한다.**
     제어자(access modifier)와 메서드(metod)를 이용해서 데이터를 보호하고 올바른 값을 유지하도록 하며,
     코드의 중복을 제거하여 코드의 불일치로 인한 오동작을 방지할 수 있다.

#### 객체지향 개념을 학습할 때, 재사용성과 유지보수 그리고 중복된 코드의 제거, 이 세가지 관점에서 보면 보다 쉽게 이해가 가능하다.





## 02. 클래스와 객체

* 클래스의 정의: 객체를 정의 해 놓은 것.
  클래스의 용도: 객체를 생성하는 데 사용.

  > 객체의 정의: 실제로 존재하는 것. (사물 또는 개념) -> 프로그래밍 내에서는 **실제로 메모리에 생성된 것.**
  >
  > 객체의 용도: 객체가 가지고 있는 기능과 속성에 따라 다름.
  >
  > > 유형의 객체: 책상, 의자, 자동차, TV와 같은 사물
  > >
  > > 무형의 객체: 수학공식, 프로그램 에러와 같은 논리나 개념

* **클래스는, 객체를 생성하는 데 사용 될 뿐, 객체 그 자체는 아니다.**
  원하는 기능의 객체를 사용하기 위해선, 클래스로부터 **객체를 생성하는 과정이 선행**되어야 함.

* 클래스는 단지 객체를 만드는 데만 사용 될 뿐이다.





## 03. 객체의 구성요소 - 속성과 기능

* 객체 : 속성과 기능의 집합.
  객체의 멤버(구성원,member) : 객체가 가지고 있는 속성과 기능

* 클래스에는 객체의 모든 속성과 기능이 정의 되어있음.
  -> 클래스로부터 객체를 생성하면, **클래스에 정의 된 속성과 기능을 가진 객체가 만들어짐.**

  > 속성(property) ➡️ 멤버변수(variable)
  >
  > 기능(funtion)    ➡️ 메서드(metod (= 멤버 함수(member funtion)))
  >
  > * 메서드는, 멤버 변수와 구분하기 위해 메서드라고 칭한다.
  >
  > > 채널 		   ➡️ int channel
  > >
  > > 채널 높이기 ➡️ channelUp() {...}

* 예제: TV클래스 생성

  ```java
  class TV {
   // 이하 변수
    String color;  //색깔
    boolean power; //전원상태
    int channel;   //채널
    
   // ---
    // 이하 메서드
    void power ()    	  {power =!power;}
    void channelUp()    {channel++;}
    void channel1Down() {channel--;}
  }
  ```





## 04. 객체와 인스턴스

* **인스턴스화 (instantiate) :** 객체를 만드는 과정을 클래스의 인스턴스화 하고 한다.

* **인스턴스 (instance)** : 클래스로부터 만들어진 객체를 그 클래스를 인스턴스라고 한다.

* 객체와 인스턴스의 차이점: 기본적으로 같은 의미이지만,

  * **객체:** 모든 인스턴스를 대표하는 포괄적인 의미이며, 일반적인 용어.
  * **인스턴스:** 특정 클래스로부터 생성된 객체.

  정도의 차이가 있다.

* 예시 이미지:

  > ![객체와 인스턴스](https://cremazer.github.io/assets/img/java/20140920/20180105_002_java-Objects-and-Instances.jpg)





## 05.한 파일에 여러 클래스 작성하기

* 하나의 소스파일에 하나의 클래스만을 정의하는 것이 일반적이지만,
  둘 이상의 클래스를 정의하는 것도 가능하다.
* 주의사항:
  * 소스파일 이름은 public class의 이름과 일치해야한다.
    (소스파일 내에 public class가 없다면, 소스파일 내의 어떤 클래스의 이름으로 해도 상관 없다.)

> 올바른 작성 예:
>
> ```java
> Hello2.java //소스파일 이름
>   public class Hello2 {}
>   			 class Hello3 {}
> ```
>
> ```java
> Hello2.java //소스파일 이름
>          class Hello2 {}
>   			 class Hello3 {}
> ```



> 올바르지 않은 작성 예:
>
> ```java
> Hello2.java //소스파일 이름
>   public class Hello2 {}
>   public class Hello3 {} // public class가 두 개.
> ```
>
> ```java
> Hello3.java //소스파일 이름이 public class와 불일치.
>   public class Hello2 {}
>          class Hello3 {}
> ```
>
> ```java
> Hello2.java //소스파일 이름
>          class hello2 {} // class이름이 hello2임. 대소문자를 구분하기 때문에 불일치.
>          class Hello3 {}
> ```



## 06. 객체의 생성과 사용

* 클래스로부터 인스턴스를 생성하는 방법은 여러가지가 있지만, 일반적으로 다음과 같이 한다.

  ```java
  클래스명 변수명;         // 클래스의 객체를 참조하기 위한 참조변수를 선언
  변수명 = new 클래스명(); // 클래스의 객체를 생성 후, 객체의 주소를 참조변수에 저장
  ```

  ```java
  Tv t;                // Tv클래스 타입의 참조변수 t를 선언
  t = new Tv();        // Tv인스턴스를 생성한 후, 생성된 Tv인스턴스의 주소를 t에 저장.
  ```

* 예제:

  ```java
  public class Ex6_0 {
  	public static void main(String[] args) {
  		TV t;			 //Tv인스턴스를 참조하기 위한 변수 t를 선언.
  		t = new TV();    //Tv인스턴스를 생성하고 할당한다.
  		t.channel = 7;   //Tv인스턴스의 멤버변수 channel의 값을 7로 한다.
  		t.channelDown(); //Tv인스턴스의 메서드 channelDown()을 호출한다.
  		System.out.println("현재 채널"+ t.channel +"입니다.");
  	}
  }
  
  class TV {
  	//Tv의 속성(멤버변수)
  	String color;  //색상
  	boolean power; //전원상태(on/off)
  	int channel;   //채널
  	
  	//Tv의 기능 (메서드)
  	void power() {power = !power;}  //Tv를 켜거나 끄는 기능을 하는 메서드
  	void channelUp() {++channel;}   //Tv의 채널을 높이는 기능을 하는 메서드
  	void channelDown() {--channel;} //Tv의 채널을 낮추는 기능을 하는 메서드
  }
  
  ```

  > 위 식의 결과: 현재 채널은 6입니다.



## 07. 객체의 생성과 사용 예제

* 같은 클래스에서 생성된 각 인스턴스의 속성(멤버변수)은 서로 다른 값을 유지할 수 있으며,
  메서드의 내용은 모든 인스턴스에 대해 동일하다.

* 하나의 인스턴스를 여러개의 참조변수가 가리키는 경우는 있지만,
  여러 인스턴스를 하나의 참조변수가 가리키는 경우는 없다.

* 그림 예제:  

* 1.  TV t1 = new TV();
      TV t2 = new TV();

     ![객체 생성 예제](https://user-images.githubusercontent.com/69128652/90951119-ab636f00-e492-11ea-92ea-6d5e156e1aa1.png)

  2. t1.channel =7;
     ![객체 예제 2](![스크린샷 2020-08-22 오후 4 17 11](https://user-images.githubusercontent.com/69128652/90951151-0dbc6f80-e493-11ea-8d1c-94dece1c62b9.png)

* 예제:

  ```java
  public class Ex6_2 {
  	public static void main(String[] args) {
  		TV t1 = new TV();	
  		TV t2 = new TV();   
  		System.out.println("t1의 channel값"+ t1.channel +"입니다.");
  		System.out.println("t2의 channel값"+ t2.channel +"입니다.");
  		
  		t1.channel = 7;
  		System.out.println("t1의 channel값을 7로 변경하였습니다.");
  		
  		System.out.println("t1의 channel값"+ t1.channel +"입니다.");
  		System.out.println("t2의 channel값"+ t2.channel +"입니다.");
  	}
  }
  ```

  > 위 식의 값:
  >
  > t1의 channel값0입니다.
  >
  > t2의 channel값0입니다.
  >
  > t1의 channel값을 7로 변경하였습니다.
  >
  > t1의 channel값7입니다.
  >
  > t2의 channel값0입니다.



## 08. 객체배열

* 객체 배열: 참조변수들을 하나로 묶은 참조변수 배열.

* 객체 배열 생성 방법: 기본적으로, 일반적인 배열 생성 방법과 동일하다.

  > ex) 
  > TV[] tvArr = new TV[3];

* 객체 생성 후, 객체 배열의 각 요소에 저장하는 것을 잊지않도록 주의.

  * 객체 배열 저장 방법:

    ```java
    TV[] tvArr = new TV[3]; // 참조변수 배열(객체 배열)을 생성
    
    // 객체를 생성해서 배열의 각 요소에 저장
    tvArr[0] = new TV();
    tvArr[1] = new TV();
    tvArr[2] = new TV();
    
    // 위 코드를 배열의 초기화 블럭 사용하여 요약 시,
    > TV[] tvArr = { new TV(),new TV(),new TV()};
    ```

  * for 문 사용시:

    ```java
    TV[] tvArr = new TV[100];
    
    for(int i=0;i<tvArr.length;i++) {
      tvArr[i] = new TV();
    }
    ```



## 09. 클래스의 정의(1) - 데이터와 함수의 결합

* 프로그래밍언어에서 데이터 처리를 위한 데이터 저장형태의 발전:
  ![클래스의 정의 1](https://user-images.githubusercontent.com/69128652/90951479-4873d700-e496-11ea-874e-0244089b6d00.png)
  1. **변수:** 하나의 데이터를 저장할 수 있는 공간
  2. **배열**: 같은종류의 여러 데이터를 하나의 집합으로 저장할 수 있는 공간
  3. **구조체**: 서로 관련된 여러 데이터를 종류에 관계 없이 하나의 집합으로 저장할 수 있는 공간
  4. **클래스**: 데이터와 함수의 결합(구조체+함수)

#### 클래스는, 변수(데이터)와 함수를 하나의 클래스에 정의하여 서로 관계가 깊은 변수와 함수들을 함께 다룰 수 있게 한 것이다.

* 자바에서는 문자열을 String이라는 클래스로 정의 하였는데, 
  그 이유는 **문자열과 문자열을 다루는 데 필요한 함수들을 함께 묶기 위해서이다.**

```java
public final clss String implements java.io.Serializable, Comparable {
  private char[] value; // 문자열을 저장하기 위한 공간
  
  public String replace(char oldChar, char newChar) {
    ...
    char[] val = value; // 같은 클래스 내의 변수를 사용해서 작업을 한다.
    ...
  }
}
```



## 10. 클래스의 정의 (2) - 사용자 정의 타입

#### 사용자 정의 타입(user-defined type) 이란?
* **프로그래머가 기본 자료형(primitive type) 외에 서로 관련된 변수들을 묶어서 하나의 타입으로 새로 추가하는 것.**

  * 자바같은 객체 지향 언어에서는, 클래스가 곧 사용자 정의 타입이다.
  * ex) 시간을 코드로 나타낼 때, 비객체지향적 코드를 사용을 한다면, 
    프로그램 수행 과정에서 시,분,초가 따로 뒤섞여 올바르지 않을 데이터가 될 가능성이 높기 때문에,
    시,분,초를 하나로 묶는 사용자 정의 타입 (=클래스)을 사용해주어야 한다.

| 비객체지향적 코드                                            | 객체지향적 코드                                              |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| int hour1, hour2, hour3;<br />int minute1, minute2, minute3;<br />float senond1, senond2, senond3; | Time t1 = new Time();<br />Time t2 = new Time();<br />Time t3 = new Time(); |
| int[] hour = new int[3];<br />int[] minute = new int[3];<br />int[] second = new int[3]; | Time[] t = new Time[3];<br />t[0] = new Time();<br />t[1] = new Time();<br />t[2] = new Time(); |

> 시간을 코드로 나타낼 때의 예시.



## 11. 선언위치에 따른 변수의 종류

* 변수의 종류를 결정 짓는 요소는, **'변수의 선언 위치'**

* 
  ![선언위치 예시](https://user-images.githubusercontent.com/69128652/90976170-c955d000-e575-11ea-9b04-b7b7e7c525d5.png)

  * **변수의 구분:**

  | 멤버변수                           | 지역변수                       |
  | ---------------------------------- | ------------------------------ |
  | 클래스 변수 (static이 붙음)        | 멤버 변수를 제외한 나머지 변수 |
  | 인스턴스 변수 (아무것도 붙지 않음) | -                              |

  * **변수의 종류:**

  | 변수의 종류                            | 선언위치                                                     | 생성시기                      |
  | -------------------------------------- | ------------------------------------------------------------ | ----------------------------- |
  | 클래스 변수<br />(class variable)      | 클래스 영역                                                  | 클래스가 메모리에 올라갈 때   |
  | 인스턴스 변수<br />(instance variable) | 클래스 영역                                                  | 인스턴스가 생성되었을 때      |
  | 지역변수<br />(local variable)         | 클래스 영역 이외의 영역<br />(메서드, 생성자, 초기화 블럭 내부) | 변수 선언문이 수행 되었을 때. |

  1. 인스턴스 변수(instance varable):
     * 클래스 영역에 선언 되며, 인스턴스를 생성할 때 만들어짐.
     * 인스턴스마다 별도의 저장공간을 가지므로, 서로 다른 값을 가질 수 있음.
  2. 클래스 변수(class variable):
     * 클래스 영역에 선언되며, 인스턴스 변수 앞에 static을 붙이면 됨.
     * 모든 인스턴스가 공통된 저장공간(변수)을 공유 하게 됨.
     * 모든 인스턴스들이 공통적인 값을 유지해야하는 속성의 경우에 주로 사용됨.
     * '클래스.클래스 변수'와 같은 형식으로 사용.
  3. 지역변수(local variable):
     * 메서드 내에 선언 되며, 메서드 내에서만 사용 가능.
     * 메서드가 종료되면 소멸되어 사용할 수 없음.
     * 블럭 내에서만 유효한 범위.



#### 클래스 변수와 인스턴스 변수 예제

* 트럼프 카드의 무늬, 숫자, 폭, 높이 등을 설정하는 예제.

  ```java
  class Ex6_3 {
  	public static void main(String[] args) {
      
  		System.out.println("Card.width = " + Card.width);
  		System.out.println("Card.height = " + Card.height); 
  		// -> 클래스 변수(static 변수)는 객체생성 없이 '클래스이름.클래스 변수'로 직접 사용 가능.
  		
      
  		Card c1=new Card();
  		c1.kind = "Heart";
  		c1.number = 7;
  		
  		Card c2=new Card();
  		c2.kind = "Spade";
  		c2.number = 4;
  		// -> 인스턴스 변수의 값을 변경한다.
  		
      
  		System.out.println("c1은" + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + "," + c1.height + ")" );
  		System.out.println("c2은" + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + "," + c2.height + ")" );
  		System.out.println("c1은 width와 height를 각각 50, 80으로 변경합니다.");
      
      
  		c1.width = 50;
  		c1.height = 80;
  		// 클래스변수의 값을 변경한다.
  		
  		System.out.println("c1은" + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + "," + c1.height + ")" );
  		System.out.println("c2은" + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + "," + c2.height +")" );
  	}
  }
  
  class Card {
  	String kind;
  	int number;
  	static int width =100;
  	static int height = 250;
  }
  ```

  > 위 식의 결과:Card.width = 100
  >
  > Card.height = 250
  >
  > c1은Heart, 7이며, 크기는 (100,250)
  >
  > c2은Spade, 4이며, 크기는 (100,250)
  >
  > c1은 width와 height를 각각 50, 80으로 변경합니다.
  >
  > c1은Heart, 7이며, 크기는 (50,80)
  >
  > c2은Spade, 4이며, 크기는 (50,80)



## 12. 메서드

### 메서드란?

* 객체 안에 있는 함수.

* **특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것.**

* 작은 기능만 수행 해야 하며, 하나로 묶을 때엔 블럭{} 을 사용.

* 메서드에 **넣을 값(입력)과 반환하는 결과(출력)만 알면 되며, 출력 과정은 몰라도 된다.**
  이러한 특성으로 메서드를 내부가 보이지않는 '블랙박스(black box)'라고 부르기도 함.

* 메서드의 구성 방식:

  * 선언부(header, 머리)
  * 구현부(body, 몸통)
  * 메서드를 정의한다 == 선언부와 구현부를 작성하는 것.

  ![메서드](https://user-images.githubusercontent.com/69128652/90976506-b264ad00-e578-11ea-9352-45e8f5b8de1b.png)



---



### 메서드의 선언부

* '메서드의 이름'과 '매개변수의 선언' 그리고 '반환타입'으로 구성.
* 작업을 수행하기 위해 어떤 타입과 값을 필요로 하는지에 대한 정보를 제공.
* 선언부를 변경하게 된다면, 메서드가 호출되는 모든 곳이 변경되어야 하므로, 신중히 작성 해야 함.
* 
  ![메서드의 선언부 예시](https://user-images.githubusercontent.com/69128652/90976972-ba265080-e57c-11ea-889d-77d2916a1424.png)

#### 매개변수의 선언 (parameter declaration)

* 메서드가 작업을 수행하는데 필요한 값들(입력)을 제공받기 위한 것.

* 필요한 값의 개수만큼 변언을 선언하며, 변수간의 구분은 쉼표','를 사용.

* **두 변수의 타입이 같아도 변수의 타입을 생략할 수 없다.**

  > int add (int x, **int y**) {...}  // OK.
  >
  > int add (int x,y) {...}		// 에러. 매개변수 y의 타입이 없다.

* 값의 개수가 많은 경우, 배열이나 참조 변수를 사용.
  값을 입력받을 필요가 없다면 괄호() 안에 아무것도 적지않는다.



#### 반환타입(return type)

* 메서드의 작업수행 결과(출력)인 '반환값(return value)'의 타입을 적는다.
  반환값이 없는 경우 반환타입을 'void'로 적어야 함.

* 예제: 구구단 전체를 출력 하는 예시이며, 작업을 수행하는 데 필요한 값(입력)과 반환값(출력)이 없어, 타입이 void이다.

  ```java
  void print99danAll() {
    for(int i=1;i<=9;i++) {
      for(int j=2;j<=9;j++) {
        System.out.print(j+"*"+i+"="+(j*i)+" ");
      }
      System.out.println();
    }
  }
  ```



---



### 메서드의 구현부

* 메서드의 선언부 다음에 오는 괄호{}를 '메서드의 구현부'라 한다.
* 메서드를 호출했을 때 수행될 문장들을 넣는다.



#### return문

* 메서드의 반환타입이 'void'가 아닌경우, 구현부 안에 'return 반환값;'이 반드시 포함 되어야함.

* **값의 타입은 반환타입과 일치하거나, 자동 형변환이 가능한 것이어야 함.**

* **단 하나의 값만 반환** 할 수 있으며, 입력(매개변수)은 여러 개 일 수 있어도, 출력(반환값)은 최대 하나만 허용.

* 


  ![return문 예제 1](https://user-images.githubusercontent.com/69128652/90977080-a2030100-e57d-11ea-99a4-737f50a44d67.png)



#### 지역변수(local variable)

* 메서드 내에 선언된 변수를 '지역변수(local variable)'이라 한다.

* 메서드에 선언 된 변수들은 해당 메서드 내에서만 사용 가능 하기 때문에, 다른 메서드라면 같은 변수의 이름을 사용 해도된다.

  ```java
  int add(int x,int y) {
    int result = x+y;
    return result;
  }
  
  int multiply(int x, int y) {
    int result = x+y;
    return result;
  }
  ```

  

* 매개 변수도 메서드 내에 선언된것으로 간주되기 때문에, 지역변수다.



---

### 메서드의 호출

* 메서드를 정의 했어도 호출되지 않으면 아무 일도 일어나지 않으며,
  메서드를 호출해야만 구현부{}의 문장들이 수행.

* 메서드를 호출하는 방법:

  ```java
  메서드이름(값1, 값2, ...); // 메서드를 호출하는 방법
  
  print99danAll(); 			 // void print99danAll()을 호출
  int result = add(3,5); // int add(int x,int y)를 호출하고, 결과를 result에 저장.
  ```



#### 인수(argument)와 매개변수(parameter)

* 인수: 메서드를 호출할 때 괄호() 안에 지정해준 값. '인자'라고도 한다.
  		인자의 개수와 순서는 호출된 메서드에 선언된 **매개변수와 일치해야함**.

  > int result = add (3, 5); // 메서드를 호출 한 것. (3, 5)부분이 인수(argument)

* 매개변수: 메서드에 선언된 입력매개변수

  > int add(int x, int y) {...} // (int x, int y)가 매개변수.



---



### 메서드의 실행 흐름

* 

![메서드의 실행 흐름](https://user-images.githubusercontent.com/69128652/90977568-5a7e7400-e581-11ea-806d-c3b0a6ecb8b0.png)

1. main메서드에서 메서드 add를 호출한다. 인수 1L와 2L이 메서드 add의 매개변수 a, b에 각각 복사(대입)된다.
2. 메서드 add의 괄호{}안에 있는 문장들이 순서대로 수행된다.
3. 메서드 add의 모든 문장이 실행되거나 return문을 만나면, 호출한 메서드(main메서드)로 되돌아와서 이후의 문장들을 실행.



#### 예제

* 사칙연산을 위한 4개의 메서드가 정의 되어있는 MyMath클래스를 이용한 예제.

  ```java
  class Ex6_4 {
  	public static void main(String[] args) {
  		MyMath mm = new MyMath();
  		long result1 = mm.add(5L, 3L);
  		long result2 = mm.subtract(5L, 3L);
  		long result3 = mm.multiply(5L, 3L);
  		double result4 = mm.divide(5L, 3L); //double 대신 long값으로 호출하였다. 이 값은 double로 자동 형변환 된다.
  		
  		System.out.println("add(5L, 3L) =" + result1);
  		System.out.println("substract(5L, 3L) =" + result2);
  		System.out.println("multiply(5L, 3L) =" + result3);
  		System.out.println("divide(5L, 3L) ="+ result4);
  	}
  }
  
  class MyMath {
  	long add(long a, long b) {
  		long result = a+b;
  		return result;
  		// return a + b; // 위의 두 줄을 이와 같이 한 줄로 간단히 할 수 있다.
  	}
  	
  	long subtract(long a, long b) {return a - b;}
  	long multiply(long a, long b) {return a * b;}
  	double divide(double a, double b) { return a / b; }
  }
  ```

  > 위 식의 결과: 
  >
  > add(5L, 3L) =8
  >
  > substract(5L, 3L) =2
  >
  > multiply(5L, 3L) =15
  >
  > divide(5L, 3L) =1.6666666666666667
  >
  > *  long형의 값인 5L는, double형 값인 5.0으로 자동 형변환 되어 divide의 매개변수 a에 저장되었다.



## 13. return문

* 현재 실행중인 메서드를 종료하고 호출한 메서드로 되돌아 가는 문.

* 반환값의 유무에 관계없이 모든 메서드에 적어도 하나의 return문이 있어야 한다.
  단, 반환타입이 'void'인 경우, 컴파일러가 메서드의 마지막에 자동으로 'return;'을 추가해준다.

  ![return문](https://user-images.githubusercontent.com/69128652/90978070-c19e2780-e585-11ea-911e-a827c875eb7b.png)

  * 반환값이 있는 경우의 예제:

    ```java
    int multiply(int x,int y) {
      int result = x*y;
      
      return result;
    }
    ```

* if문의 경우, 조건식의 결과에 따라 return문이 실행 되지 않을 수 있다.

  * 결과에 따라 실행되지 않는 예제:

    ```java
    int max(int a, int b) {
      if(a > b)
        return a; //조건이 참일때만 실행된다.
    }
    ```

  * 따라서, 이런 경우, if문의 else블럭에 return문을 추가 해야 한다.
    결과에 관계 없이 실행 되는 예제:

    ```java
    int max(int a, int b) {
      if(a > b)
        return a; // 조건식이 참일때 실행된다. 
      else
        return b; // 조건식이 거짓일때 실행된다.
    }
    ```

    * 위의 코드를 다음과 같이 표현할 수도 있다.

      ```java
      int max(int a, int b) {
        int result = 0;
        if(a > b)
          result = a; // 조건식이 참일때 실행된다. 
        else
          result = b; // 조건식이 거짓일때 실행된다.
        return result;
      }
      ```



## 14. 반환 값

* return문의 반환값으로 주로 변수가 오지만, 항상 그런 것은 아님.

  > * 예시 1 : 'x+y' 수식의 경우
  >
  > ```java
  > int add(int x, int y) {
  >   int result = x+y;
  >   return result;
  > }
  > 
  > // 위의 코드를 간단히 한다면,
  > int add(int x, int y) {
  >   return x + y;
  > } // 반환 결과로는 8이 된다.
  > ```
  >
  > ​	이와 같이, 수식을 계산한 결과가 반환 된다.
  >
  > 
  >
  > * 예시2: diff메서드 - 두 개의 정수를 받아서 그 차이를 절대값으로 반환함.
  >
  >   ```java
  >   int diff(int x, int y) {
  >     int result = abs(x-y);
  >     
  >     return result;
  >   }
  >   
  >   // 위의 코드를 간단히 한다면,
  >   int diff(int x, int y) {
  >   	return abs(x-y);
  >    }
  >   ```
  >
  >   이는, abs의 반환 타입이 메서드 diff의 반환 타입과 일치하기 때문에 가능한 경우이다.
  >
  >   
  >
  > 
  >
  > * 예시 3: 입력받은 정수의 부호를 판단해서, 음수일 경우 부호연산자(-)를 사용해 양수로 반환 하는 **간단한 메서드의 경우**.
  >
  >   ```java
  >   int abs(int x) {
  >     if(x>=0) {
  >       return x;
  >     } else {
  >       return -x;
  >     }
  >   }
  >   
  >   // 위의 코드를 간단히 한다면,
  >   int abs(int x) {
  >     return x>=0 ? x: -x;
  >   }
  >   ```



## 15. 호출스택(call stack)

* 메서드의 작업에 필요한 메모리 공간 제공.

* 호출 스택의 특징:

  * 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받음.
  * 메서드가 수행을 마치고 나면 사용했던 메모리를 반환하고 스택에서 제거.
  * 호출스택의 제일 위에있는 메서드가 현재 실행중인 메서드.
  * 아래에 있는 메서드가 바로 위의 메서드를 호출한 메서드.
    
  
* 예제: 

  ```java
  class Ex6_5 {
    public static void main(String[] args) {
      System.out.println("Hello");
    }
  }
  ```

  * 위 코드를 실행시켰을 때의 진행 순서:
    ![호출스택](https://user-images.githubusercontent.com/69128652/91039720-09858300-e648-11ea-920d-bc1c1c52eb74.png)

    1. ~2 위의 예제를 실행 시키면, JVM에 의해서 main메서드가 호출됨으로써 프로그램이 시작 됨.
       호출스택에는 main메서드를 위한 메모리 공간이 할당 되고, main메서드의 코드가 수행됨.

    3. main메서드에서 println()를 호출한 상태이다. 아직 main메서드가 끝난 것은 아니므로 main메서드는 호출스택에 대기 상태로 남아있고, println()의 수행이 시작.

       print메서드에 의해 "Hello"가 화면에 출력 됨.

    4. println메서드의 수행이 완료되어 호출스택에서 사라지고, 호출한 main메서드로 되돌아감.
       대기중이던 main메서드는 println()을 호출한 이후부터 수행 재개.

    5. main메서드에도 더이상 수행할 코드가 없으므로, 종료. 호출스택은 완전히 비워진 후 프로그램이 종료됨.



## 16. 기본형 매개변수

* 메서드를 호출 시, 매개변수로 지정한 값을 메서드의 **매개변수에 복사해서** 넘겨준다.
  * 기본형(primitive type)일 경우, 기본형 값이 복사. **변수의 값을 읽기만 할 수 있음.**(변경 X)
  * 참조형(reference type)의 경우, 인스턴스의 주소가 복사. **변수의 값을 읽고, 변경할 수 있다.**

* 예제:

  ```java
  class Data {int x;}
  
  class Ex6_6 {
  	public static void main(String[] args) {
  		Data d=new Data();
  		d.x= 10;
  		System.out.println("main(): x="+d.x);
  		
  		change(d.x);
  		System.out.println("After change(d.x)");
  		System.out.println("main() : x="+d.x);
  	}
  	
  	static void change(int x) { // 기본형 매개변수
  		x=1000;
  		System.out.println("change() : x="+x);
  	}
  }
  ```

  > 위 식의 결과: 
  >
  > main(): x=10
  >
  > change() : x=1000
  >
  > After change(d.x)
  >
  > main() : x=10

  * 위 식의 경우, 'd.x'의 값이 변경된 것이 아닌, change메서드의 매개변수 x의 값이 변경 된 것이다.
    복사본이 변경 된 것이나 마찬가지이기 때문에, 원본에는 영향이 없다.

  ![기본형 매개변수](https://user-images.githubusercontent.com/69128652/91042145-43588880-e64c-11ea-913b-5656bd9766b7.JPG)

  



## 17. 참조형 매개변수

* 예제:

  ```java
  class Data2 {int x;}
  
  public class Ex6_7 {
  	public static void main(String[] args) {
  		Data2 d=new Data2();
  		d.x= 10;
  		System.out.println("main(): x="+d.x);
  		
  		change(d);
  		System.out.println("After change(d)");
  		System.out.println("main() : x="+d.x);
  	}
  	
  	static void change(Data2 d) { // 참조형 매개변수
  		d.x=1000;
  		System.out.println("change() : x="+d.x);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > main(): x=10
  >
  > change() : x=1000
  >
  > After change(d)
  >
  > main() : x=1000

  * '값이 저장된 주소'를 change메서드에게 넘겨주었기 때문에, 값 변경이 가능하다.

  ![참조형 매개변수 예제](https://user-images.githubusercontent.com/69128652/91042141-42bff200-e64c-11ea-8e54-f6fa5667eee3.JPG)



## 18. 참조형 반환 타입

* 매개변수 뿐만 아니라, 반환타입도 참조형이 될 수 있다.

* 반환 하는 값의 타입이 참조형이라는 이야기인데, 참조형 타입의 값은 '객체의 주소'이기 때문에,
  정수값이 반환 되는 것일 뿐 특별 할 것이 없다.

* 예제:

  ```java
  class Data3 {int x;}
  
  class Ex6_8 {
  	public static void main(String[] args) {
  		Data3 d=new Data3();
  		d.x= 10;
  		
  		Data3 d2= copy(d);
  		System.out.println("d.x="+d.x);
  		System.out.println("d2.x="+d2.x);
  	}
  	
  	static Data3 copy(Data3 d) { 
  		Data3 tmp = new Data3(); // 새로운 객체 tmp를 생성한다.
  		
  		tmp.x=d.x;				 // d.x의 값을 tmp.x에 복사한다.
  		
  		return tmp;				 // 복사한 객체의 주소를 반환한다.
  	}
  }
  ```

  > 위 식의 결과: 
  >
  > d.x=10
  >
  > d2.x=10

  * 
    ![참조형 반환타입 예제](https://user-images.githubusercontent.com/69128652/91042127-3dfb3e00-e64c-11ea-8bae-823e3e8df0d1.JPG)





## 19. static 메서드와 인스턴스 메서드

* 메서드 앞에 static이 붙어있다면 클래스메서드, 없다면 인스턴스 메서드이다.
  * 클래스 메서드: 
    * 객체를 생성하지 않고도 '클래스.메서드 이름(매개변수)'와 같은 식으로 호출 가능.
    * 데이터(변수)와 데이터에 관련된 메서드의 집합. 
      (같은 클래스 내에 있는 멤버변수와 아주 밀접한 관계가 있음.)
  * 인스턴스 메서드:
    * 반드시 객체를 생성해야만 호출 가능.
    * 메서드의 작업을 수행하는데 인스턴스 변수를 필요로 함.
* 인스턴스와 관계없는 (인스턴스 변수나 인스턴스 메서드를 사용하지 않는)메서드를 클래스 메서드(static메서드)로 정의한다.
  *특별한 이유가 없는 한 인스턴스 변수를 사용하지 않는다면 클래스 메서드로 정의.*



* 예제:

  ```java
  class MyMath2 {
  	long a, b;
  	
  	// 인스턴스변수a, b만을 이용해서 작업하므로 매개변수가 필요없다.
  	long add() 		 {return a+b;} // a, b는 인스턴스 변수.
  	long subtract() {return a-b;}
  	long multiply()  {return a*b;}
  	double divide()  {return a/b;}
  	
  	// 인스턴스변수와 관계없이 매개변수만으로 작업이 가능하다.
  	static long add(long a,long b) {return a+b;} //a, b는 지역변수.
  	static long subtract(long a,long b) {return a-b;}
  	static long multiply(long a,long b) {return a*b;}
  	static double divide(double a,double b) {return a/b;}
  }
  
  public class Ex6_9 {
  	public static void main(String[] args) {
  		// 클래스메서드 호출. 인스턴스 생성없이 호출가능.
  		System.out.println(MyMath2.add(200L, 100L));
  		System.out.println(MyMath2.subtract(200L, 100L));
  		System.out.println(MyMath2.multiply(200L, 100L));
  		System.out.println(MyMath2.divide(200.0, 100.0));
  		
  		MyMath2 mm = new MyMath2(); // 인스턴스를 생성
  		mm.a = 200L;
  		mm.b = 100L;
  		// 인스턴스메서드는 객체생성 후에만 호출이 가능함.
  		System.out.println(mm.add());
  		System.out.println(mm.subtract());
  		System.out.println(mm.multiply());
  		System.out.println(mm.divide());
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 300
  >
  > 100
  >
  > 20000
  >
  > 2.0
  >
  > 300
  >
  > 100
  >
  > 20000
  >
  > 2.0



#### static을 언제 붙여야 할까?

1. **클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통으로 사용하는 것에 붙인다.**
2. **클래스 변수(static변수)는 인스턴스를 생성하지 않아도 사용할 수 있다.**
   * 클래스가 메모리에 올라갈 때 이미 자동적으로 생성되기 때문.
3. **클래스 메서드(static메서드)는 인스턴스 변수를 사용할 수 없다.**
   * 클래스메서드는 인스턴스 생성 없이 호출 가능하므로, 클래스 메서드가 호출 되었을 때 인스턴스가 존재하지 않을 수 있기 때문.
     그렇기 때문에 클래스 메서드에서 인스턴스 변수의 사용을 금한다.
   * 반면, 인스턴스 변수나 메서드에서는 static이 붙은 멤버들을 사용하는것이 가능하다. ( 인스턴스 변수가 존재한다 == static변수가 메모리에 존재한다)
4. **메서드 내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려한다.**
   * 메서드 호출시간이 짧아지므로 성능이 향상되기 때문.





## 20. 메서드 간의 호출과 참조

* 같은 클래스에 속한 멤버들 간에는 별도의 인스턴스를 생성하지 않고, 서로 참조 혹은 호출이 가능.
  * **단, 클래스 멤버가 인스턴스 멤버를 참조 또는 호출 할 때엔 인스턴스 생성이 필요.**

* 예제1 : 같은 클래스 내의 인스턴스 메서드와 static메서드 간의 호출

  ```java
  class TestClass {
    void instanceMetod() {...}      // 인스턴스메서드
    static void staticMetod() {...} // static메서드
    
    void instanceMetod2(){					// 인스턴스 메서드
      instanceMetod();							// 다른 인스턴스메서드를 호출한다.
      staticMetod(); 								// static메서드를 호출한다.
    }
    
    static void staticMetod2() {		// static메서드
      instanceMetod();							// 에러!!! 인스턴스메서드를 호출할 수 없다.
      staticMetod();							 	// static메서드는 호출 할 수 있다.
    }
  }
  ```

* 예제2: 변수와 메서드간의 호출

  ```java
  class TestClass2 {
    int iv;										  //인스턴스 변수
    static int cv;						  //클래스 변수
    
    void instanceMetod() {	    //인스턴스 메서드
      System.out.println(iv);   //인스턴스 변수를 사용할 수 있다.
      System.out.println(cv);   //클래스 변수를 사용할 수 있다.
    }
    
    static void staticMetod() { //static메서드
      System.out.println(iv);   //에러!!! 인스턴스 변수를 사용할 수 없다.
      System.out.println(cv);   //클래스 변수는 사용할 수 있다.
    }
  }
  ```

  

## 21. 오버로딩(overloading)

#### 오버로딩(overloading) 이란?

* 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것. '메서드 오버로딩(metod overloading)'이라고도 한다.

* 오버로딩이 성립하는 조건:

  1. 메서드 이름이 같아야 한다.
  2. 매개변수의 개수 또는 타입이 달라야 한다.

  위의 조건이 성립하지 못하는 메서드는, *중복 정의로 간주되어 컴파일 시 에러가 발생한다.*

* 오버로딩된 메서드들은 매개변수에 의해서 구별될 수 있음.
  **반환 타입은 오버로딩을 구현하는 데 영향을 주지 못함.**

* 오버로딩의 대표적인 예: println메서드.

  > PrintStream클래스에 정의되어있는 10개의 오버로딩된 println메서드:
  >
  > > void println()
  > >
  > > void println(boolean x)
  > >
  > > void println(char x)
  > >
  > > void println(char[] x)
  > >
  > > void println(double x)
  > >
  > > void println(float x)
  > >
  > > void println(int x)
  > >
  > > void println(long x)
  > >
  > > void println(Object x)
  > >
  > > void println(String x)

---



* 보기 1: **매개변수의 이름만 다를 뿐, 매개변수의 타입이 같을 경우, 오버로딩이 성립되지않는다.**
  매개변수의 이름이 다를 경우, 메서드 내에서 사용되는 변수의 이름만 달라질 뿐, 아무 의미 없기 때문.

  ```java
  int add(int a, int b) {return a+b;}
  int add(int x, int y) {return x+y;}
  ```

  컴파일시 : 'add(int.int) is already defined'(이미 같은 메서드가 정의 되었다.)라는 메시지 출력.

  

* 보기 2: 리턴타입만 다를 경우.
  매개변수의 타입과 개수가 일치하기 때문에, add(3,3)과 같이 호출 하였을 때, **어떤 메서드가 호출된 것인지 결정 할 수 없기에 오버로딩으로 간주하지 않음.**

  ```java
  int add(int a,int b) {return a+b;}
  long add(int a,int b) {return (long)(a+b);}
  ```

  컴파일시 : 'add(int.int) is already defined'(이미 같은 메서드가 정의 되었다.)라는 메시지 출력.

  

* 보기 3: int형과 long매개변수가 하나씩 선언 되어있지만, 서로 순서가 다를 경우.
  호출 시 **매개변수의 값에 의해 호출 될 메서드가 구분 될 수 있으므로 오버로딩으로 간주.**

  ```java
  long add(int a,long b) {return a+b;}
  long add(long a,int b) {return a+b;}
  ```

  * 매개변수의 순서만을 다르게 하여 오버로딩을 구현하면, 매개변수의 순서를 외우지 않아도 되는 장점이 있지만,
    단점이 될 수 있기 때문에 주의.



---



#### 오버로딩 예제

```java

class Ex6_10 {
	public static void main(String[] args) {
		MyMath3 mm = new MyMath3();
		System.out.println("mm.add(3, 3) 결과:"   + mm.add(3,3));
		System.out.println("mm.add(3L, 3) 결과:"  + mm.add(3L,3));
		System.out.println("mm.add(3, 3L) 결과:"  + mm.add(3,3L));
		System.out.println("mm.add(3L, 3L) 결과:" + mm.add(3L,3L));
		
		int[] a = {100, 200, 300};
		System.out.println("mm.add(a) 결과:" + mm.add(a));
	}
}

class MyMath3 {
	int add(int a,int b) {
		System.out.print("int add(int a,int b) - ");
		return a+b;
	}
	
	long add(int a,long b) {
		System.out.print("long add(int a,long b) - ");
		return a+b;
	}
	
	long add(long a,int b) {
		System.out.print("long add(long a,int b) - ");
		return a+b;
	}
	
	long add(long a,long b) {
		System.out.print("long add(long a,long b) - ");
		return a+b;
	}
	
	int add(int[] a) { // 배열의 모든 요소의 합을 결과로 돌려준다.
		System.out.print("int add(int[] a) - " );
		int result = 0;
		for(int i=0;i<a.length;i++)
			result += a[i];
		
		return result;
	}
}

```

> 위 식의 결과: 
>
> int add(int a,int b) - mm.add(3, 3) 결과:6
>
> long add(long a,int b) - mm.add(3L, 3) 결과:6
>
> long add(int a,long b) - mm.add(3, 3L) 결과:6
>
> long add(long a,long b) - mm.add(3L, 3L) 결과:6
>
> int add(int[] a) - mm.add(a) 결과:600

 * add메서드가 println 메서드보다 먼저 호출 되는지에 대한 이유:

   ```java
   		System.out.println("mm.add(3, 3) 결과:"   + mm.add(3,3));
   // 위의 문장이 아래의 문장을 하나로 합친 것.
   		int result = mm.add(3,3);
   		System.out.println("mm.add(3,3) 결과:" +result) 
   ```

   

## 22. 생성자(constructor)

* 인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메서드'

* 초기화 작업에 주로 사용되고, 인스턴스 생성 시, 실행되어야하는 작업을 위해서도 사용.

* 클래스 내에 선언 되며, 메서드와 구조가 유사하지만 리턴값이 없다.

  * 그렇다고 생성자 앞에 키워드 void를 사용하지는 않으며, 아무것도 적지 않음.

* 생성자의 조건:

  1. 생성자의 이름은 클래스의 이름과 같아야한다.
  2. 생성자는 리턴값이 없다.

* 생성자의 정의:

  생성자도 오버로딩이 가능하다.

  > 클래스 이름(타입 변수명, 타입 변수명, ...) {
  >
  > ​	// 인스턴스 생성 시 수행될 코드,
  >
  > ​	// 주로 인스턴스 변수의 초기화 코드를 적는다.
  >
  > }

  ```java
  class point {
  	point() {							//매개변수가 없는 생성자
  		...
  	}
  	point(int x, int y) { //매개변수가 있는 생성자
  		...
  	}
  	...
  }
  ```

* **연산자 new가 인스턴스를 생성하는 것이지, 생성자가 인스턴스를 생성하는 것이 아님.**



---

### 기본생성자 (default constructor)

* 모든 클래스에는 반드시 하나 이상의 생성자가 정의 되어있어야 한다.

* 컴파일 시, 소스파일(*.java)의 클래스에 생성자가 하나도 정의 되지 않은 경우,
  **컴파일러는 자동적으로 '기본생성자(default constructor)'를 추가하여 컴파일** 한다.

  > 클래스이름() {} // 기본 생성자
  >
  > poitn() {}	    // point 클래스의 기본 생성자

* 특별히 인스턴스 초기화 작업이 요구되어지지 않는다면, 생성자를 정의 하지 않고 기본 생성자를 사용하는 것도 좋다.

* 예제:

  ```java
  class Data_1 {
  	int value;
  }
  
  class Data_2 {
  	int value;
  	
  	Data_2(int x) { //매개 변수가있는 생성자.
  		value = x;
  	}
  }
  public class Ex6_11 {
  	public static void main(String[] args) {
  		Data_1 d1 = new Data_1();
  		Data_2 d2 = new Data_2(); //compile error 발생.
  	}
  }
  ```

  > 위의 예제를 실행 할 경우, Data_2클래스에서 Data_2()라는 생성자를 찾을 수 없다는 에러메세지가 나타난다.
  >
  > > Ex6_11.java:15: cannot resolve symbol
  > >
  > > symbol: constructor Data_2()
  > >
  > > location: class Data_2
  > >
  > > ​					Data_2 d2 = new Data_2();
  > >
  > > ^
  > >
  > > 1 error
  >
  > Data_1에는 정의되어있는 생성자가 하나도 없으므로, 생성자가 자동 생성 되었지만
  > Data_2에는 이미 생성자 Data_2(int x)가 정의 되어있으므로, 기본 생성자가 추가되어있지 않았기 때문.



##### 기본 생성자가 컴파일러에 의해서 추가되는 경우는 클래스에 정의 된 생성자가 하나도 없을때 뿐이다.





---

###  매개변수가 있는 생성자

* 생성자도 매개변수를 선언하여 호출 시 값을 넘겨받아, 인스턴스의 초기화 작업에 사용할 수 있다.

* 인스턴스마다 각기 다른 값으로 초기화 되어야하는 경우가 많기 때문에, 매개변수를 사용한 초기화는 매우 유용.

* 인스턴스를 생성할 때, 결정해야하는 두 가지 사항:

  1. 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가?
  2. 생성자 - 선택한 클래스의 어떤 생성자로 인스턴스를 생성할 것인가?

* 예제:

  ```java
  class Car {
  	String color;    // 색상
  	String gearType; // 변속기 종류 - auto(자동), manual(수동)
  	int door;		 // 문의 개수
  	
  	Car() {} // 기본 생성자
  	
  	Car(String c, String g, int d) { // 생성자
  		color = c;
  		gearType = g;
  		door = d;
  	}
  }
  public class Ex6_12 {
  	public static void main(String[] args) { // 아래는 인스턴스 변수의 값을 변경 하는 것.
  		Car c1 = new Car();
  		c1.color = "white";
  		c1.gearType = "auto";
  		c1.door = 4;
  		
  		Car c2= new Car("white","auto",4); // c1과 같은 내용이지만, 이는 매개변수를갖는 생성자를 사용 한 것이며, 보다 간결하고 직관적.
  		
  		System.out.println("c1의 color=" + c1.color + ", gearType=" +c1.gearType + ", door="+c1.door);
  		System.out.println("c2의 color=" + c2.color + ", gearType=" +c2.gearType + ", door="+c2.door);
  	}
  }
  ```

  > 위 식의 결과: 
  >
  > c1의 color=white, gearType=auto, door=4
  >
  > c2의 color=white, gearType=auto, door=4