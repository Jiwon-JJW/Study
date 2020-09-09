# Chapter 07

## 01. 상속

#### 상속이란?

* 기존의 클래스를 재 사용하여 새로운 클래스를 작성하는 것.

  * 특징:
    - 보다 적은 양의 코드로 새로운 클래스를 작성할 수 있음.
    - 코드를 공통적으로 관리 할 수 있기 때문에 코드의 추가 및 변경이 용이.
    - 코드의 재사용성을 높이고, 중복을 제거하여 프로그램의 생상선과 유지보수에 크게 기여 함.

* 상속을 구현하는 방법:
  작성하고자 하는 클래스의 이름 뒤에 상속 받고자 하는 클래스의 이름을 'extends'와 함께 작성 한다.

  ```java
  class Parent { }
  class Child extends Parent {
    // ...
  }
  ```

* 상속 관계에 있는 클래스에 대한 명칭:

  * 상속해주는 클래스 (위 코드의 경우, Parent) : 조상 클래스 라고 한다.

    * 조상 클래스가 변경 될 경우, 자손 클래스는 자동적으로 영향을 받는다.
      

  * 상속 받는 클래스( 위 코드의 경우, Child)      : 자손 클래스 라고 한다.

    * 자손클래스가 변경 되어도 조상 클래스에는 영향을 주지 못한다.

    - 자손 클래스는 조상 클래스의 모든 멤버를 상속받는다.
      (단, 생성자와 초기화 블럭은 상속되지 않음.)
    - 자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다.

* 예제: Tv클래스로부터 상속받고, 기능을 추가한 CaptionTv클래스 작성.

  ```java
  class Tv_1 {
  	boolean power; // 전원 상태(on/off)
  	int channel;   // 채널
  	
  	void power() { power = !power; }
  	void channelUp() { ++channel; }
  	void channelDown() { --channel;}
  }
  
  class CaptionTv extends Tv_1 { // Caption는 Tv에 캡션(자막)을 보여주는 기능을 추가
  	boolean caption;						 // 캡션상태(on/off)
  	void displatCaption(String text) { 
  		if (caption) {						 // 캡션 상태가 on(true)일 때만 text를 보여 준다.
  			System.out.println(text);
  		}
  	}
  }
  
  public class Ex7_1 {
  	public static void main(String[] args) {
  		CaptionTv ctv = new CaptionTv();
  		ctv.channel =10;					 // 조상 클래스로부터 상속받은 멤버
  		ctv.channelUp();					 // 조상 클래스로부터 상속받은 멤버
  		System.out.println(ctv.channel);
  		ctv.displatCaption("Hello, World");
  		ctv.caption = true;				 // 캡션(자막) 기능을 켠다.
  		ctv.displatCaption("Hello,World");
  	}
  }
  ```

  > 위 코드의 결과: 
  > 11
  > Hello,World

![상속 예제의 이미지](https://user-images.githubusercontent.com/69128652/92079702-54975700-edfb-11ea-952d-0762ab003d47.png)

* 위의 이미지의 경우, 클래스 간의 상속관계를 그림으로 표현한, **'상속계층도(class hierarchy)'**라고 한다.



## 02. 클래스 간의 관계 - 포함관계

#### 포함(Composite) 관계란?

* 상속 이외에도 클래스를 재사용 할 수 있는 방법.

* 포함 관계를 맺어 주는 것은, **한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것**을 뜻한다.

* 일반적 경우:

  ```java
  class circle {
    int x; // 원점의 x좌표
    int y; // 원점의 y좌표
    int r; // 반지름(radius)
  }
  
  class point {
    int x; //x좌표
    int y; //y좌표
  }
  ```

* 클래스를 포함관계로 만들어 줬을 경우:

  ```java
  class circle {
   	point c = new Point(); //원점
    int r; // 반지름(radius)
  }
  
  class point {
    int x; //x좌표
    int y; //y좌표
  }
  ```

  * 하나의 거대한 클래스를 작성하는 것 보다, 단위별로 여러 개의 클래스를 작성한 후
    이 단위 클래스들을 포함관계로 재사용 시, 간결하고 손쉽게 클래스를 작성할 수 있다.
  * 작성된 단위 클래스들은 다른 클래스를 작성하는데 재사용 할 수도 있음.



## 03. 클래스 간의 관계 설정하기

* 클래스를 작성하는 데 있어서 상속관계를 맺어줄 것인지, 포함관계를 맺어줄 것인지 혼돈스럽다면,
  '~은 ~이다(is -a)' 와 '~은 ~를 가지고 있다(has -a)'를 넣어서 문장을 만들어 보면  클래스간의 관계가 명확해짐.

  > **상속관계 : '~은 ~이다(is -a)'** 
  > 				ex) 원(Circle)은 점(Point)이다.
  >
  > **포함관계 : '~은 ~를 가지고 있다(has -a)'**
  > 				ex) 원(Circle)은 점(Point)을 가지고 있다.



## 04. 단일 상속(single inheritance)

* 다른 객체 지향 언어 (C++)에서는 여러 조상 클래스로부터 상속 가능 한, '다중 상속(muliple inheritance)'을 허용.

* **자바에서는 단일 상속만을 허용 하기 때문에, 둘 이상의 클래스로부터 상속을 받을 수 없다.**

* **다중 상속의 경우 :**
  장점:

  - 여러 클래스로부터 상속 가능하기에, 복합적인 기능을 가진 클래스를 쉽게 작성 가능.

  단점:

  * 클래스 간의 관계가 매우 복잡해짐
  * 서로 다른 클래스로부터 상속받은 멤버간의 이름이 같을 경우, 구별할 수 없음.
    (해결하는 방법으로는 조상 클래스의 메서드 이름이나 매개변수를 바꾸는 법 밖에 없음. = 굉장히 번거로움.)

  **이러한 문제점이 있기 때문에, 다중 상속의 장점을 포기하고 단일 상속만을 허용 하게 되었다.**

* **단일 상속이 다중상속보다 유리한 점:**

  * 클래스간의 관계가 보다 명확해짐.
  * 코드를 더욱 신뢰 할 수 있음.



## 05. Object클래스 -모든 클래스의 조상

#### Object 클래스란?

* 모든 클래스 상속계층도의 최상위에 있는 조상 클래스.

* 다른 클래스로부터 상속받지 않은 모든 클래스들을 자동적으로 Object클래스로부터 상속 받게 함.

  ```java
  class Tv {
    ...
  }
  
  // 위 코드를 컴파일 할 경우, 컴파일러는 다음과 같이 자동적으로 'extends Object'를 추가.
  // 이미 어떤 클래스로부터 상속 받은 경우, 위의 항목을 추가하지않는다.
  
  class Tv extends Object {
    ...
  }
  ```

* Object클래스의 상속계층도는 다음과 같다.
  ![Obj 상속계층도](https://user-images.githubusercontent.com/69128652/92083673-52d09200-ee01-11ea-9616-08eea634288d.png)

* 그간 toString()이나 equals(Object o)와 같은 메서드를 따로 정의 하지 않고 사용 가능 했던 이유는,
  이 메서드들이 Object클래스에 정의된 것이기 때문이다.



## 06 오버라이딩(overriding)

#### 오버라이딩이란?

* 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것.

* 상속받은 메서드를 그대로 사용하기도 하지만, 자손 클래스에 맞게 변형해야하는 경우 조상의 메서드를 오버라이딩 함.

* 예제: Point의 경우, 2차원 좌표계의 한 점을 표현 하지만, Point3D의 경우, 3차원 좌표계의 한 점을 표현하기 위한 것이기 때문에 오버라이딩 함.

  ```java
  class Point {
    int x;
    int y;
    
    String getLocation() {
      return "x:" +x +",y:" +y;
    }
  }
  
  class Point3D extends Point {
    int z;
    
    String getLocation() { // 오버라이딩
    return "x:" +x +",y:" +y + ",z:"+z;
  }
  ```

  * Point 클래스를 사용하던 사람들은, 새로 작성 된 Point3D클래스가 Point클래스의 자손이므로,
    Point3D클래스의 인스턴스에 대해 getLocation()을 호출 시, 점의 좌표를 문자열로 얻을 수 있을 것이라 기대하기 때문에,
    **새로운 메서드를 제공하는 것 보다 오버라이딩을 하는 것이 바른 선택.**



#### 오버라이딩의 조건

* 메서드의 내용만을 새로 작성하는 것 이므로 

  1. **메서드의 선언부(메서드 이름, 매개변수, 반환타입)는 조상의 것과 완전히 일치해야한다.**

* 접근제어자(access modifier)와 예외(exception)는 제한된 조건 하에서만 다르게 변경 가능.

  2. **접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.**
     만일 조상 클래스에 정의된 메서드의 접근 제어자가 protected라면, 이를 오버라이딩 하는 자손 클래스의 메서드는 접근 제어자가 protected나 public이어야 한다.
     보통 같은 범위의 접근제어자 사용.
     
> public > protected > (default) > private 순. 

3. **조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.**
  
   * 오버라이딩의 바른 예시:
   
       ```java
       class parent { // 조상메서드
         void parentMethod() throws IOException, SQLException { // 예외가 2개
           ...
         }
       }
       
       class Child extends Parent { // 자손 메서드
         void parentMethod() throws IOException { // 예외가 1개
           ...
         }
         ...
       }
       ```



## 07. 오버로딩 vs 오버라이딩

* **오버로딩(overloading)** 
  기존에 없는 새로운 메서드를 정의하는 것(new)

* **오버라이딩(overrriding)**

  상속받은 메서드의 내용을 변경하는 것(change, modify)

* 예시:

  ```java
  class Parent {
    void parentMethod() {}
  }
  
  class Child extends Parent {
    void parentMethod() {} 	   // 오버라이딩
    void parentMethod(int) {}  // 오버로딩
    
    void parentMethod() {}    
    void parentMethod(int i) {} // 오버로딩
    void parentMethod() {} // 에러. 중복정의 되었음. (already defined in Child)
  }
  ```





## 08. 참조변수 super

#### super란?

* 자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수.
* 상속받은 멤버와 자신의 멤버와 이름이 같을 때, super를 붙여서 구별 가능.



#### 예제

* 예제1: Child클래스는 조상인 Parent클래스로부터 x를 상속받는데, 자신의 멤버 x와 이름이 같아서 구분하기 위해 super를 사용.

  ```java
  class Ex7_2 {
  	public static void main(String[] args) {
  		Child c = new Child();
  		c.method();
  	}
  }
  
  class Parent { int x=10; /*super.x*/ }
  
  class Child extends Parent {
  	int x = 20; // this.x
  	
  	void method() {
  		System.out.println("x="+x);
  		System.out.println("this.x="+this.x);
  		System.out.println("super.x="+super.x);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > x=20
  >
  > this.x=20
  >
  > super.x=10

* 예제2:x, this.x, super.x 모두 같은 변수를 의미하므로 같은 값을 출력한 경우

  ```java
  class Ex7_3 {
  	public static void main(String[] args) {
  		Child2 c = new Child2();
  		c.method();
  	}
  }
  
  class Parent2{int x=10; /* super.x */ }
  
  class Child2 extends Parent2 {
  	int x =20; //this.x
  	
  	void method() {
  		System.out.println("x="+x);
  		System.out.println("this.x="+this.x);
  		System.out.println("super.x="+super.x);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > x=20
  >
  > this.x=20
  >
  > super.x=10

* 모든 인스턴스 메서드에는 this와 super가 지역변수로 존재.
  이 들에는 자신이 속한 인스턴스의 주소가 자동으로 저장됨.



## 09. super() - 조상의 생성자

* this()의 경우, 같은 클래스의 다른 생성자를 호출하는데 사용 되지만,
  super()는 조상의 생성자를 호출하는 데 사용된다.

* 예제:

  ```java
  public class Ex7_4 {
  	public static void main(String[] args) {
  		Point3D p =new Point3D(1, 2, 3);
  		System.out.println("x="+p.x+",y="+p.y+",z="+p.z);
  	}
  }
  
  class Point {
  	int x, y;
  	
  	Point(int x, int y) {
  		this.x=x;
  		this.y=y;
  	}
  }
  
  class Point3D extends Point {
  	int z;
  	
  	Point3D(int x,int y, int z) {
      // this.x =x;
      // this.y =y; 처럼 사용 할 수도 있음.
  		super(x,  y); // 조상클래스의 생성자 Point(int x,int y)를 호출
  		this.z =z; // 자신의 멤버를 초기화
  	}
  }
  ```

  > 위 식의 결과:
  >
  > x=1,y=2,z=3



## 10. 패키지(package)

#### 패키지란?

* 클래스의 묶음.
* 클래스 또는 인터페이스를 포함시킬 수 있음.
* 서로 관련된 클래스들끼리 그룹 단위로 묶어 놓음으로써 클래스를 효율적으로 관리 가능.
* 같은 이름의 클래스 일지라도 서로 다른 패키지에 존재하는 것이 가능하므로, 다른 개발자가 개발한 클래스 라이브러리의 클래스와 충돌 하지 않고 자신만의 패키지 체계를 유지할 수 있음.
* **클래스가 물리적으로 하나의 클래스(.class)인 것과 같이 패키지는 물리적으로 하나의 디렉토리 이다.**



#### 패키지의 선언

* 선언 방법:

  > package 패키지명;

* 주의 사항:

  * 소스파일에서 주석과 공백을 제외한 첫 번째 문장이어야 한다.
  * 하나의 소스파일에 단 한 번만 선언 될 수 있다.
  * 해당 소스파일에 포함된 모든 클래스나 인터페이스는 선언된 패키지에 속하게 됨.
  * 대소문자를 모두 허용 하지만, 클래스명과 구분이 쉽게 하기 위해 소문자로 하는 것이 원칙.

* 자신이 속할 패키지를 지정하지 않은 클래스는 자동적으로 '이름없는 패키지'에 속하게 된다.

* 간단한 프로그램의 경우, 패키지를 지정하지 않아도 되지만,
  큰 프로젝트나 Java API와 같은 클래스 라이브러리를 작성하는 경우, 미리 패키지를 구성하여 적용해야함.

* 예제:

  ```java
  package com.codechobo.book;
  
  public class PackageTest {
  	public static void main(String[] args) {
  		System.out.println("Hello World!");
  	}
  }
  ```



## 11. import문

* 소스코드를 작성 할 때, 다른 패키지의 클래스를 사용하려면 패키지명이 포함된 클래스 이름을 사용해야한다.

* 클래스의 코드를 작성하기 전**, import문으로 사용하고자 하는 클래스의 패키지를 미리 명시해 준다면, 소스코드에 사용되는 클래스 이름에서 패키지명 생략 가능**.

* **import문의 역할:**

  * 컴파일러에게 소스파일에 사용된 클래스의 패키지에 대한 정보를 제공 하는 것.
  * 컴파일 시, 컴파일러는 import문을 통해 모든 클래스이름 앞에 패키지명을 붙여준다.

* import문의 경우, package문과 달리 한 소스파일에 **여러번 선언 가능.**

* **import문 선언 방법:**

  * import문은 package문 다음에, 그리고 클래스 선언문 이전에 위치해야한다.

  ```java
  import 패키지명.클래스명;
  	또는
  import 패키지명.*;
  ```

  * 같은 패키지에서 여러개의 클래스가 사용될 때, '패키지명.*'을 사용하면 지정된 패키지에 속하는 모든 클래스를 패키지명 없이 사용할 수 있다.
    (컴파일러가 해당 패키지에서 일치하는 클래스 이름을 찾아야하는 수고가 들겠지만, 성능차이는 없음.)


## 12. static import문

* static import문 사용 시, static멤버를 호출할 때 클래스 이름을 생략할 수 있다.

* 특정 클래스의 static멤버를 자주 사용할 때 편리.

  > import static java.lang.Integer.*;  		// Integer클래스의 모든 static메서드 
  >
  > import static java.lang.Math.random; // Math.random()만. 괄호 안붙임
  >
  > import static java.lang.System.out;	  // System.out을 out만으로 참조 가능.
  > 

* 예제:

  ```java
  import static java.lang.System.out;
  import static java.lang.Math.*;
  
  class Ex7_6 {
  
  	public static void main(String[] args) {
  		// System.out.println(Math.random());
  		out.println(random());
  		
  		// System.out.println("Math.PI:"Math.PI);
  		out.println("Math.PI:"+PI);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 0.9560811907653743
  >
  > Math.PI:3.141592653589793



## 13. 제어자(modifier)

* 제어자(modifier)는 클래스, 변수 또는 메서드의 선언부에 함께 사용되어 부가적인 의미 부여.

* 제어자의 종류:

  | 접근 제어자                         | 그 외                                                        |
  | ----------------------------------- | ------------------------------------------------------------ |
  | public, protected, default, private | static, final, abstract, <br />(자주 사용하진 않음: native, transient, synchronized, strictfp) |

  * 제어자는 클래스나 멤버변수와 메서드에 주로 사용됨.
  * 하나의 대상에 대해 여러 제어자를 조합하여 사용하는 것이 가능.
  * 단, 접근 제어자는 한 번에 네 가지 중 하나만 선택해서 사용 가능.
    (하나의 대상에 public과 private을 함께 사용 할 수 없음.)


## 14. static - 클래스의, 공통적인

* static은 '클래스의'또는 '공통적인'의 의미를 가지고 있음.

* 하나의 변수를 모든 인스턴스가 공유하기 때문에, 인스턴스에 관계없이 같은 값을 갖음.

* static이 붙은 멤버변수와 메서드, 그리고 초기화 블럭은 클래스에 관계된 것이기 때문에 인스턴스를 생성하지 않고도 사용 가능.

* 인스턴스 메서드와 static메서드의 근본적인 차이는 **메서드 내에서 인스턴스 멤버를 사용하는가의 여부**

  

* **static이 사용될 수 있는 곳 - 멤버변수, 메서드, 초기화 블럭**

  | 제어자 | 대상     | 의미                                                         |
  | ------ | -------- | ------------------------------------------------------------ |
  | static | 멤버변수 | - 모든 인스턴스에 공통적으로 사용되는 클래스 변수가 된다.<br />- 클래스 변수는 인스턴스를 생성하지 않고도 사용 가능하다.<br />- 클래스가 메모리에 로드될 때 생성된다. |
  | static | 메서드   | - 인스턴스를 생성하지 않고도 호출이 가능한 static메서드가 된다.<br />- static메서드 내에서는 인스턴스멤버들을 직접 사용할 수 없다. |

  * 인스턴스 멤버를 사용하지 않는 메서드는 static을 붙여서 static메서드로 선언하는 것이, 인스턴스를 생성하지 않고도 호출이 가능하기 때문에, 더 편리하다.



```java
class StaticTest {
  static int width = 200;  // 클래스 변수(static변수)
  static int height = 120; // 클래스 변수(static변수)
  
  static {								 // 클래스 초기화 블럭
    // static변수의 복잡한 초기화 수행
  }
  static int max(int a,int b) { // 클래스 메서드(static메서드)
    return a>b?a:b;
  }
}
```



## 15. final - 마지막의, 변경될 수 없는

* final은 '마지막의' 또는 '변경될 수 없는'의 의미를 가지고 있음.

* 거의 모든 대상에 사용될 수 있음.

* 변수에 사용될 경우, 값을 변경할 수 없는 상수가 되며,
  메서드에 사용될 경우, 오버라이딩을 할 수 없게 되고,
  클래스에 사용되면 확장하는 자손클래스를 정의하지 못하게 된다.

  

* **final이 사용될 수 있는 곳 -클래스, 메서드, 멤버변수, 지역변수**

  | 제어자 | 대상     | 의미                                                         |
  | ------ | -------- | ------------------------------------------------------------ |
  | final  | 클래스   | 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다.<br />그래서 final로 지정된 클래스는 다른 클래스의 조상이 될 수 없다. |
  | final  | 메서드   | 변경될 수 없는 메서드, final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다. |
  | final  | 멤버변수 | 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.   |
  | final  | 지역변수 | 변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.   |



```java
final class FinalTest {			 // 조상이 될 수 없는 클래스
  final int MAX_SIZE = 10;   // 값을 변경할 수 없는 멤버변수(상수)
  
  final void getMaxSize() {  // 오버라이딩 할 수 없는 메서드(변경 불가)
    final int LV = MAX_SIZE; // 값을 변경할 수 없는 지역변수(상수)
    return MAX_SIZE;
  }
}
```



## 16. abstract - 추상의, 미완성의

* abstract는 '미완성'의 의미를 가지고 있다.
* 메서드의 선언부만 작성하고 실제 수행내용은 구현하지 않은 추상 메서드를 선언하는데 사용됨.



* **abstract가 사용될 수 있는 곳 - 클래스, 메서드**

  | 제어자   | 대상   | 의미                                                         |
  | -------- | ------ | ------------------------------------------------------------ |
  | abstract | 클래스 | 클래스 내에 추상 메서드가 선언되어 있음을 의미한다.          |
  | abstract | 메서드 | 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알린다. |

  

```java
abstract class AbstractTest { // 추상 클래스(추상 메서드를 포함한 클래스)
  abstract void move();				// 추상 메서드(구현부가 없는 메서드)
}
// 추상 클래스는 아직 완성되지 않은 메서드가 존재하므로, 인스턴스를 생성할 수 없다.
AbstractTest a = new AbstractTest(); // 에러. 추상 클래스의 인스턴스 생성 불가
```





## 17. 접근 제어자(access modifier)

* 접근제어자는 멤버 또는 클래스에 사용 됨.

* 해당하는 멤버 또는 클래스를 외부에서 접근하지 못하도록 제한하는 역할을 함.

* 접근제어자가 default임을 알리기 위해 실제로 default를 붙이지 않는다.
  (클래스나 멤버변수, 메서드, 생성자에 접근 제어자가 지정되어있지 않다면, default임을 뜻함.)

  > default: 아무런 접근 제어자도 붙이지 않은 것.



* **접근 제어자가 사용될 수 있는 곳 - 클래스, 멤버변수, 메서드, 생성자**

  * **private** : 같은 클래스 내에서만 접근이 가능하다.

  * **default** : 같은 패키지 내에서만 접근이 가능하다.

  * **protected** : 같은 패키지 내에서, 그리고 다른 패키지의 자손 클래스에서 접근이 가능하다.

  * **public** : 접근 제한이 전혀 없다.

    | 제어자    | 같은 클래스 | 같은 패키지 | 자손 클래스 | 전   체 |
    | --------- | ----------- | ----------- | ----------- | ------- |
    | public    | O           | O           | O           | O       |
    | protected | O           | O           | O           |         |
    | (default) | O           | O           |             |         |
    | private   | O           |             |             |         |



## 18. 캡슐화와 접근 제어자

* 외부로부터의 접근을 제한하는 것을 **데이터 감추기(data hiding)**라고 하며, 
  객체지향개념의 캡슐화(encapsulation)에 해당하는 내용이다.

* 접근 제어자를 사용하는 이유

  - 클래스의 내부에 선언된 데이터를 외부로부터 보호하기 위해서.

  - 외부에는 불필요한, 내부적으로만 사용되는 부분을 감추기 위해서.

    

```java
public class Time {
  private int hour;   
  private int minute;
  private int second;
  // 접근 제어자를 private으로 하여 외부에서 직접 접근하지 못하도록 한다.
  
  public int grtHour() { return hour; }
  public void setHour(int hour) {
    if (hour <0 || hour >23) return;
    this.hour = hour;
  }
  
  public int getMinute() { return minute; }
  public void setMinute(int minute) {
    if (minute <0 || minute >59) return;
    this.second = second;
  }
}
```

* get으로 시작하는 메서드: 멤버변수의 값을 반환 (보통 멤버변수의 값을 읽는 메서드의 이름. 겟터(getter)라 부름)
* set으로 시작하는 메서드: 매개변수에 지정된 값을 검사하여 조건에 맞는 값일때만 멤버변수의 값을 변경.(보통 멤버변수의 값을 변경하는 메서드의 이름. 셋터(stter)라 부름)
* 만일 상속을 통해 확장될 것이 예상되는 클래스라면, **멤버에 접근 제한을 주되 자손클래스에서 접근하는 것이 가능하도록 private 대신 protecte를 사용**.
  **private이 붙은 멤버는 자손클래스에서도 접근이 불가능 함.**





## 19. 다형성(polymorphism)

* 다형성이란, '여러 가지 형태를 가질 수 있는 능력'을 의미.

* 자바에서 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함으로써 다형성을 프로그램적으로 구현.

  ( 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록 함.)

> 조상타입의 참조변수로 자손타입의 인스턴스를 참조할 수 있음.
> 반대로 자손타입의 참조변수로 조상타입의 인스턴스를 참조할 수는 없다.



```java
class Tv {
  boolean power; // 전원상태(on/off)
  int channel;   // 채널
  
  void power() {power = !power;}
  void channelUp() {++channel;}
  void channelDown() {--channel;}
}

class CaptionTv extends Tv {
  String text; // 캡션(자막)을 보여 주기 위한 문자열
  void caption() {/* 내용생략 */}
}
```

* 인스턴스 타입과 참조변수의 타입이 일치하는 것이 보통이지만, 서로 상속관계에 있을 경우 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하는 것이 가능하다.

  ```java
  CaptionTv c = new CaptionTv(); // 참조 변수와 인스턴스 타입이 일치
  Tv        t = new CaprionTv(); // 조상 타입 참조 변수로 자손 타입 인스턴스 참조
  ```

  * 이 경우, 실제 인스턴스가 CaprionTv타입 일지라도, 참조변수 t로는 CaprionTv인스턴스의 **모든 멤버를 사용할 수 없다.**
  * Tv타입의 참조변수로는 CaprionTv인스턴스 중, Tv클래스의 멤버들(상속받은 멤버 포함)만 사용 가능.
  * **둘 다 같은 타입의 인스턴스지만 참조변수의 타입에 따라 사용할 수 있는 멤버의 개수가 달라짐.**



## 20. 참조변수의 형변환

* 참조변수도 기본형 변수처럼 형변환이 가능하지만, 서로 상속관계에 있는 클래스 사이에서만 가능.

* 바로 윗 조상이나 자손 타입이 아닌, 조상의 조상(ex: Object클래스)으로도 형변환이 가능.

* 예시:

  ```java 
  class Car{ }
  class FireEngine extends Car{ }
  class Ambluance extends Car { }
  
  FireEngine f = new FireEngine();
  Car c =(car)f;							 //OK. 조상인 Car타입으로 형변환(생략가능)
  FireEngine f2=(FireEngine)c; //OK. 자손인 FireEngine타입으로 형변환(조상타입을 자손타입으로 형변환 하는 경우 생략 불가)
  Ambulance a=(Ambulance)f;    //에러. 상속관계가 아닌 클래스 간의 형변환 불가.
  ```

  * 서로 상속 관계에 있는 타입간의 형변환은 양방향으로 자유롭게 수행될 수 있으나, **참조 변수가 가리키는 인스턴스의 자손타입으로 형변환은 허용되지 않는다.**
    **그래서 참조변수가 가리키는 인스턴스의 타입이 무엇인지 먼저 확인하는 것이 중요.**

* 예제:

  ```java
  class Ex7_7 {
  	public static void main(String[] args) {
  		Car car = null;
  		FireEngine fe=new FireEngine();
  		FireEngine fe2 = null;
  		
  		fe.water();
  		car = fe;				// car = (Car)fe; 에서 형변환이 생략됨.
  		// car.water(); < 컴파일 에러!!! Car타입의 참조변수로는 water()를 호출할 수 없다.
  		fe2 = (FireEngine)car;  // 자손타입 < 조상타입. 형변환 생략 불가 
  		fe2.water();
  	}
  }
  
  class Car {
  	String color;
  	int door;
  	
  	void drive() {				// 운전하는 기능 
  		System.out.println("drive, Brrrr~");
  	}
  	void stop() {				// 멈추는 기능 
  		System.out.println("stop!!!");
  	}
  }
  
  class FireEngine extends Car {  // 소방차 
  	void water() {				// 물을 뿌리는 기능 
  		System.out.println("water!!!");
  	}
  }
  ```

  > 위 식의 결과: 
  >
  > water!!!
  >
  > water!!!

  ![IMG_0845](https://user-images.githubusercontent.com/69128652/92455655-eee10b80-f1fc-11ea-88b3-1dac3c4128c9.JPG)

  * 참조변수 fe의 값을 car에 저장해서 car로도 FireEngine인스턴스를 다룰 수 있게 만든 것.
    다만 참조변수 fe와는 달리, car로는 FireEngine인스턴스의 멤버 중 4개만 사용 가능.



## 21. instanceof 연산자

* 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 instanceof연산자를 사용.

* 주로 조건문을 사용한다.

* 어떤 타입에 대한 instanceof연산의 결과가 true라는 것은 검사한 타입으로 형변환이 가능하다는 것을 의미.

  ```java
  void doWork(Car c) {
    if (c instanceof FireEngine) {		// 1. 형변환이 가능한지 확인
      FireEngine fe = (FireEngine)c;	// 2. 형변환
      fe.water();
  	...
  ```

  * 조상 타입의 참조변수로는 실제 인스턴스의 모든 멤버들 사용이 불가능 하기 때문에,
    인스턴스와 같은 타입의 참조변수로 형변환을 해야 모든 멤버들을 사용할 수 있다.



## 22. 매개변수의 다형성

* 참조변수의 다형적인 특징은 메서드의 매개변수에도 적용된다.

  ```java
  class Product {
  	int price;			// 제품의 가격
  	int bonusPoint; // 제품 구매 시 제공하는 보너스 점수
  	
  	Product(int price) {
  		this.price = price;
  		bonusPoint = (int)(price/10.0); // 보너스 점수는 제품 가격의 10%
  	}
  }
  
  class Tv1 extends Product {
  	Tv1() {
  		// 조상 클래스의 생성자 Product(int price)를 호출한다.
  		super(100);	// Tv의 가격을 100만원으로 한다.
  	}
  	// Object클래스의 toString()을 오버라이딩 한다.
  	public String toString() {return "Tv";}
  }
  
  class Computer extends Product {
  	Computer() {super(200);}
  	
  	public String toString() {return "Computer";}
  }
  
  class Buyer { // 고객, 물건을 사는사람
  	int money =1000; // 소유 금액
  	int bonusPoint = 0; // 보너스 점수
  	
  	void buy(Product p) { // 다형성을 적용 한 것. buy(Computer p) , buy(Tv t)등을 사용하지 않고 처리.
  		if(money<p.price) {
  			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
  			return;
  		}
  		
  		money -= p.price; // 가진 돈에서 구입한 제품의 가격을 뺀다
  		bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
  		System.out.println(p+"을/를 구입하셨습니다.");
  	}
  }
  public class Ex7_8 {
  	public static void main(String[] args) {
  		Buyer b = new Buyer();
  		
  		b.buy(new Tv1());
  		b.buy(new Computer());
  		
  		System.out.println("현재 남은 돈은 "+ b.money + "만원입니다.");
  		System.out.println("현재 보너스 점수는" +b.bonusPoint+"점입니다.");
  	}
  }
  ```

  * 위 상황에서, 매개변수가 Product타입의 참조변수 라는 것은**, 메서드의 매개변수로 Product클래스의 자손 타입의 참조변수면, 어느 것이나 매개변수로 받아들일 수 있다는 것.**

  * 다른 제품 클래스를 추가 할 때, Product클래스를 상속받기만 한다면, buy(Product p)메서드의 매개변수로 받아들여짐.

  * ```java
    Buyer b = new Buyer();
    Tv t= new Tv();
    Computer c= new Computer();
    b.buy(t);
    b.buy(c);
    ```

    > Tv 문장을 한문장으로 축약 시, b.buy(new Tv());가 됨.



## 23. 여러 종류의 객체를 배열로 다루기

* Product클래스가 Tv,Computer, Audio클래스의 조상일 경우:

  ```java
  Product p1 = new Tv();
  Product p2 = new Computer();
  Product p3 = new Audio();
  ```

  * 위 코드를 참조변수 배열로 처리할 경우:

    ```java
    Product p[] = new Product[3];
    p[0] = new Tv();
    p[1] = new Computer();
    p[2] = new Audio();
    ```

* 이처럼 조상 타입의 참조변수 배열을 사용하면, 공통의 조상을 가진 객체를 배열로 묶어서 다룰 수 있다.

* 혹은, 묶어서 다루고싶은 객체들의 상속관계를 따져서 가장 가까운 공통조상 클래스 타입의 참조변수 배열을 생성해서 객체를 저장하면 됨.

  * 예시:

    ```java
    class Buyer { 
    	int money =1000; 
    	int bonusPoint = 0; 
      Product[] cart = new Product[10]; // 구입한 제품을 저장하기 위한 배열(카트)
      int i =0;													// Product배열 cart에 사용될 index
    	
    	void buy(Product p) { 
    		if(money<p.price) {
    			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
    			return;
    		}
    		
    		money -= p.price; 					// 가진 돈에서 구입한 제품의 가격을 뺀다
    		bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
        cart[i++] = p;							// 제품을 Product[] cart에 저장한다.
    		System.out.println(p+"을/를 구입하셨습니다.");
    	}
    }
    ```



* 예제:

  ```java
  class Product2 {
  	int price;		// 제품의 가격 
  	int bonusPoint; // 제품 구매 시 제공하는 보너스 점수 
  	
  	Product2(int price) {
  		this.price = price;
  		bonusPoint = (int)(price/10.0);
  	}
  	
  	Product2() {} // 기본 생성자
  }
  
  class Tv2 extends Product2 {
  	Tv2() { super(100); }
  	
  	public String toString() {return "Tv";}
  }
  
  class Computer2 extends Product2 {
  	Computer2() {super(200);}
  	
  	public String toString() {return "Computer";}
  }
  
  class Audio2 extends Product2 {
  	Audio2() {super(50);}
  	
  	public String toString() {return "Audio";}
  }
  
  class Buyer2 { 						  // 고객, 물건을 사는 사람
  	int money =1000; 				  // 소유금액 
  	int bonusPoint = 0; 			  // 보너스 점수
  	Product2[] cart=new Product2[10]; // 구입한 제품을 저장하기 위한 배열
  	int i = 0; 						  //Product2배열에 사용 될 카운터 
  			
  	void buy(Product2 p) {
  		if(money<p.price) {
  			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
  			return;
  		}
  		
  		money -= p.price;			// 가진 돈에서 구입한 제품의 가격을 뺀다.
  		bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
  		cart[i++]= p;   				// 제품을 Product[] cart에 저장한다.
  		System.out.println(p+"을/를 구입하셨습니다.");
  	}
  	void summary() {		  // 구매한 물품에 대한 정보를 요약해서 보여 준다.
  		int sum=0;			  // 구입한 물품의 가격합계 
  		String itemList = ""; // 구입한 물품 목록 
  		
  		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
  		for(int i=0; i<cart.length;i++) {
  			if(cart[i]==null)break;
  			sum += cart[i].price;
  			itemList += cart[i] + ", ";
  		}
  		System.out.println("구입하신 물품의 총 금액은"+sum+"만원입니다.");
  		System.out.println("구입하신 제품은 "+itemList+"입니다.");
  	}
  }
  public class Ex7_9 {
  	public static void main(String[] args) {
  		Buyer2 b = new Buyer2();
  		
  		b.buy(new Tv2());
  		b.buy(new Computer2());
  		b.buy(new Audio2());
  		b.summary();
  	}
  }
  ```

  > 위 식의 결과:
  >
  > Tv을/를 구입하셨습니다.
  >
  > Computer을/를 구입하셨습니다.
  >
  > Audio을/를 구입하셨습니다.
  >
  > 구입하신 물품의 총 금액은350만원입니다.
  >
  > 구입하신 제품은 Tv, Computer, Audio, 입니다.

  * Product2배열로 구입한 제품들을 저장할 수 있도록 했지만, 배열의 크기를 10으로 지정했기에 11개 이상의 제품을 구입할 수 없다.
    무조건 크게 할 수 도 없어, 이런 경우 **Vector클래스를 사용하면 된다.**

  * Vector클래스는 내부적으로 Object타입의 배열을 가지고 있어, 이 배열에 객체를 추가하거나 제거할 수 있다.

  * 배열의 크기를 알아서 관리해주기 때문에 인스턴스의 개수에 신경쓰지 않아도 됨.

    ```java
    public class Vector extends AbstractList
      implements List, Cloneable, java.io.Serializable {
      protected Object elementData[];
      ...
    }
    ```




## 24 추상 클래스(abstract class)

* 클래스를 설계도로 비유 한다면, 추상 클래스는 미완성 설계도에 비유할 수 있음.

* 인스턴스 생성이 불가능 하다.

* 미완성 메서드(추상 메서드)를 포함하고 있는 클래스.
  추상 메서드를 제외하면, 생성자가 있고 멤버변수와 메서드도 가질 수 있는 등, 일반 클래스와 다를 바가 없다.

* 클래스로서의 역할은 못하지만, 새로운 클래스를 작성할 때 바탕이 되는 조상클래스.

* 사용 방법: 키워드 'abstract' 입력.

  ```java
  abstract class 클래스 이름 {
    ...
  }
  ```



### 1. 추상 메서드(abstract method)

#### 추상 메서드란?

* 선언부와 구현부(몸통)으로 구성 되어있는 메서드에서 선언부만 작성하고 구현부는 작성하지 않은 채로 남겨둔 것.

  * 미완성 상태로 남겨두는 이유:

    >  메서드의 내용이 상속받는 클래스에 따라 달라질 수 있기 때문에 조상 클래스에서는 선언부만 작성 후, 주석을 덧붙여 어떤 기능을 수행할 목적으로 작성되었는지 명시.
    > 이후 실제 내용은 상속받는 클래스에서 구현하도록 비워두는 것.
    >
    > 때문에, 추상클래스를 상속받는 자손 클래스는 조상의 추상메서드를 상황에 맞게 적절히 구현해주어야 함.

* 추상 메서드 사용 방법: 키워드  'abstract'를 앞에 붙여주고 구현부가 없으므로 괄호{} 대신 ';'을 붙여준다.

  ``` java
  /* 주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다. */
  abstract 리턴타입 메서드이름();
  ```

* 추상클래스로부터 상속받는 자손 클래스는 오버라이딩을 통해, 조상인 추상 클래스의 추상 메서드를 모두 구현해야 함.

  조상으로 부터 상속받은 추상메서드 중 하나라도 구현하지 않는다면, 자손 클래스 역시 추상클래스로 지정.

  ```java
  abstract class Player {
    abstract void play(int pos); 				// 추상 메서드
    abstract void stop();								// 추상 메서드
  }
  
  class AudioPlayer extends Player {
    void play(int pos) {/* 내용 생략 */}  // 추상 메서드를 구현
    void stop() {/* 내용 생략 */}					// 추상 메서드를 구현
  }
  
  abstract class AbstractPlayer extends Player {
    void play(int pos) {/* 내용 생략 */}  // 추상 메서드를 구현
  }
  ```

  * 메서드 작성 시 실제 작업 내용인 구현부 보다 더 중요한 부분이 선언부.
    메서드를 사용하는 쪽에서 메서드가 실제로 어떻게 구현되는지 몰라도 메서드 선언부만 알고있으면 되므로, 자손 클래스에 구현된 완성된 메서드가 호출되도록 할 수 있다.



### 2. 추상클래스의 작성

> 추상 : 낱낱의 구체적 표상이나 개념에서 공통된 성질을 뽑아 이를 일반적인 개념으로 파악하는 정신 작용

* 추상화는 기존의 클래스의 공통부분을 뽑아내서 조상 클래스를 만드는 것.
* 상속계층도를 따라 내려 갈수록 세분화되며, 올라갈 수록 공통 요소만 남게된다. 



* 비교 예제:

  1. 컴퓨터 게임 내의 유닛들을 클래스로 간단히 정의 한 것:

     ```java
     class Marine {		// 보병
       int x, y;				// 현재 위치
       void move(int x,int y) { /* 지정된 위치로 이동 */ }
       void stop() 					 { /* 현재 위치에 정지 */ }
       void stimPack()				 { /* 스팀팩을 사용한다 */ }
     }
     class Tank {			// 탱크
       int x, y;				// 현재 위치
       void move(int x,int y) { /* 지정된 위치로 이동 */ }
       void stop() 					 { /* 현재 위치에 정지 */ }
       void changeMode()				 { /* 공격모드를 변환한다 */ }
     }
     class Dropship {	// 수송선
       int x, y;				// 현재 위치
       void move(int x,int y) { /* 지정된 위치로 이동 */ }
       void stop() 					 { /* 현재 위치에 정지 */ }
       void load()						 { /* 선택된 대상을 태운다 */ }
       void unload()					 { /* 선택된 대상을 내린다 */ }
     }
     ```

  2. 각 클래스의 공통부분을 뽑아서 Unit클래스를 정의하고 이로부터 상속받도록 한 것:

     ```java
     abstract class Unit {
       int x, y;
       abstract void move(int x,int y);
       void stop() 					 { /* 현재 위치에 정지 */ }
     }
     
     class Marine extends Unit {		// 보병
       void move(int x,int y) { /* 지정된 위치로 이동 */ }
       void stimPack()				 { /* 스팀팩을 사용한다 */ }
     }
     class Tank extends Unit {			// 탱크
       void move(int x,int y) { /* 지정된 위치로 이동 */ }
       void changeMode()				 { /* 공격모드를 변환한다 */ }
     }
     class Dropship extends Unit {	// 수송선
       void move(int x,int y) { /* 지정된 위치로 이동 */ }
       void load()						 { /* 선택된 대상을 태운다 */ }
       void unload()					 { /* 선택된 대상을 내린다 */ }
     }
     ```



* 예제:

  ```java
  class Ex7_10 {
  	public static void main(String[] args) {
  		Unit[] group = { new Marine(), new Tank(), new Dropship() };
  		
  		for (int i = 0; i < group.length; i++)
  			group[i].move(100, 200); // Unit배열의 모든 유닛을 좌표(100,200)의 위치로 이동한다.
  	}
  }
  
  abstract class Unit {
  	  int x, y;
  	  abstract void move(int x,int y);
  	  void stop() 					 { /* 현재 위치에 정지 */ }
  	}
  
  	class Marine extends Unit {		// 보병
  	  void move(int x,int y) { 
  		  System.out.println("Marine[x=" +x +",y="+y+"]");
  	  }
  	  void stimPack()				 { /* 스팀팩을 사용한다 */ }
  	}
  	class Tank extends Unit {			// 탱크
  	  void move(int x,int y) { 
  		  System.out.println("Tank[x=" +x +",y="+y+"]");
  	  }
  	  void changeMode()				 { /* 공격모드를 변환한다 */ }
  	}
  	class Dropship extends Unit {	// 수송선
  	  void move(int x,int y) { 
  		  System.out.println("Dropship[x=" +x +",y="+y+"]");
  	  }
  	  void load()						 { /* 선택된 대상을 태운다 */ }
  	  void unload()					 { /* 선택된 대상을 내린다 */ }
  	}
  ```

  > 위 식의 결과: 
  >
  > Marine[x=100,y=200]
  >
  > Tank[x=100,y=200]
  >
  > Dropship[x=100,y=200]

  * 조상 타입의 참조변수로 자손 타입의 인스턴스를 참조하는 것이 가능하기 때문에, 조상 타입의 배열에 자손타입의 인스턴스를 담을 수 있는 것.

    공통 조상이 없다면 하나의 배열로 다룰 수 없음.

  * group[i].move(100,200)과 같이 호출하는 것이 unit클래스의 추상메서드인 move를 호출 하는 것 처럼 보이지만, 
    실제로는 추상메서드가 구현된 Marine, Tank, Dropship인스턴스의 메서드가 호출 되는 것.

  * Object클래스 타입의 배열로도 서로 다른 종류의 인스턴스를 하나의 묶음으로 다룰 수있지만, Object 클래스에는 move 메서드가 정의 되어 있지 않기 때문에 호출하는 부분에서 에러 발생.



## 25. 인터페이스 (interface)

#### 인터페이스란?

* 일종의 추상 클래스.

* 추상클래스처럼 추상메서드를 갖지만 추상클래스보다 추상화 정도가 높음.
  추상클래스와 달리 몸통을 갖춘 일반 메서드 또는 멤버변수를 구성원으로 가질 수 없다.

* 추상메서드와 상수만을 멤버로 가질 수 있으며, 그 외 의 다른 어떠한 요소도 허용하지 않음.

* 다른 클래스를 작성하는 데 도움을 줄 목적으로 작성 됨.

* 인터페이스 작성 방법:

  ```java
  interface 인터페이스이름 {
    public static final 타입 상수이름 = 값;
    public abstract 메서드이름(매개변수목록);
  }
  ```

* 인터페이스 멤버 제약 사항:

  1. 모든 멤버변수는 public static final 이어야 하며, 이를 생략할 수 있다.
  2. 모든 메서드는 public abstract이어야 하며, 이를 생략할 수 있다.
     ( 단, static 메서드와 디폴트 메서드는 예외.)

  > 생략 된 제어자는 자동적으로 컴파일러가 추가해줌.

```java
interface PlayingCard {
  public static final int SPADE = 4;
  final int DIAMOND=3; //public static final int DIAMOND=3;
  static int HEART=2;	 //public static final int HEART=2;
  int CLOVER=1;//public static final int CLOVER=1;
  
  public abstruct String getCardNumber();
  String getCardKind(); //public static String getCardKind();
}
```



### 1. 인터페이스의 상속

* 인터페이스는 인터페이스로부터만 상속받을 수 있으며, 클래스와는 달리 다중상속, 즉 여러개의 인터페이스로부터 상속을 받는 것이 가능하다.

  ```java
  interface Movable {
    /* 지정된 위치(x, y)로 이동하는 기능의 메서드 */
    void move(int x,int y);
  }
  
  interface Attackable {
    /* 지정된 대상(u)을 공격하는 기능의 메서드 */
    void attack(Unit u);
  }
  
  interface Fightable extends Movable,Attackable { }
    
  ```

  * 자손 인터페이스는 조상 인터페이스에 정의된 멤버를 모두 상속받는다.



### 2. 인터페이스의 구현

* 인터페이스 자체로는 인스터스 생성 불가능.
  인터페이스도 자신에 정의된 추상메서드의 몸통을 만들어주는 클래스를 작성해야한다.

* 방법은 자신을 상속받는 클래스를 정의하는 것과 다르지 않음.
  다만, 클래스와 같이 확장한다는 의미(extends)가 아닌, 구현한다는 의미의 'implements' 키워드를 사용 

  ``` java
  class 클래스이름 implements 인터페이스이름 {
    // 인터페이스에 정의된 추상메서드를 모두 구현해야한다.
  }
  
  class Fighter implements Fightable {
    public void move(int x,int y) { /* 내용생략 */}
    public void attack(Unit u) {/* 내용생략 */}
  }
  ```

* 만일 구현하는 인터페이스의 메서드 중 일부만 구현한다면, abstract를 붙여 추상클래스로 선언해야함.

  ```java
  abstract class Fighter implements Fightable {
    public void move(int x,int y) { /* 내용생략 */}
  }
  ```

* 상속과 구현을 동시에 할 수도있다.

  ```java
  class Fighter extends Unit implements Fightable {
    public void move(int x,int y) { /* 내용생략 */}
    public void attack(Unit u) {/* 내용생략 */}
  }
  ```



### 3. 인터페이스를 이용한 다형성

* 인터페이스 타입의 참조변수로 이를 구현한 클래스의 인스턴스를 참조할 수 있으며, 인터페이스 타입으로 형변환도 가능하다.

* 인터페이스 Fightable을 클래스 Fighter가 구현했을 때, 다음과 같이 참조변수로 참조하는 것이 가능하다.

  ```java
  Fightable f = (Fightable)new Fighter();
  	or
  Fightable f = new Fighter();
  ```

* 따라서 인터페이스는 다음과 같이 메서드의 매개변수의 타입으로도 사용될 수 있다.

  > void attack(Fightable f){
  >
  > ​		//...
  >
  > }

* 인터페이스 타입의 매개변수가 갖는 의미:
  메서드 호출 시 해당 인터페이스를 구현한 클래스의 인스턴스를 매개변수로 제공 해야 함.

  ```java
  class Fighter extends Unit implements Fightable {
    public void move(int x,int y) { /* 내용생략 */}
    public void attack(Fightable f) {/* 내용생략 */} //attack메서드의 매개변수로 Fighter인스턴스를 넘겨준 것.
  }
  ```

* 메서드의 리턴타입으로 인터페이스를 지정할 수 있음.

  ```java
  Fightable method() {
    ...
    Fighter f = new Fighter();
    return f;
  }
  ```

  * 리턴타입이 인터페이스라는 것은 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 의미.



### 4. 인터페이스의 장점

1. **개발시간을 단축시킬 수 있다.**
   * 인터페이스가 작성되면, 이를 사용해서 프로그램을 작성하는 것이 가능하다.
   * 인터페이스를 구현하는 클래스를 작성하게 하먄, 인타페이스를 구현하는 클래스가 작성될 때까지 기다리지 않고도 양쪽에서 동시에 개발을 진행할 수 있다.
2. **표준화가 가능하다.**
   * 프로젝트에 사용되는 기본 틀을 인터페이스로 작성한 다음, 개발자들에게 인터페이스를 구현하여 프로그램을 작성하도록 함으로써, 일관되고 정형화 된 프로그램의 개발이 가능.
3. **서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.**
   * 서로 상속관계도 아니고, 같은 조상클래스를 가지고 있지않은 클래스들에게 하나의 인터페이스를 공통적으로 구현함으로써 관계를 맺어줄 수 있음.
4. **독립적인 프로그래밍이 가능하다.**
   * 클래스의 선언과 구현을 분리시킬 수 있기 때문에 실제 구현에 독립적인 프로그램을 작성하는 것이 가능.
   * 클래스간의 관계를 간접적인 관계로 변경하면, 한 클래스의 변경이 관련된 다른 클래스에 영향을 미치지않는 독립적인 프로그래밍이 가능.



## 26. 디폴트 메서드와 static메서드

* 디폴트 메서드는 추상메서드의 기본적인 구현을 제공하는 메서드로, 추상메서드가 아니기 때문에 디폴트 메서드가 새로 추가되어도 해당 인터페이스를 구현한 클래스를 변경하지 않아도 된다.

* 디폴트 메서드 사용 방법:
  앞에 키워드 'default'를 붙이며, 추상메서드와 달리 일반 메서드처럼 몸통 {}이 있어야한다.

  접근제어자는 public이며, 생략 가능.

  ```java
  intergace MyInterface {
    void method();
    default void newMethod(){} //void new Method(); 와 같은 추상메서드 대신 쓰임.
  }
  ```

  * 위와 같이 디폴트 메서드를 추가하면, 기존의 MyInterface를 구현한 클래스를 변경하지 않아도 된다.
    조상클래스에 새로운 메서드를 추가한 것과 동일.

* 디폴트 메서드가 기존의 메서드와 이름이 중복되어 충돌하는 경우, 해결하는 규칙:

  1. 여러 인터페이스의 디폴트 메서드 간의 충돌
     - 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩해야한다.
  2. 디폴트 메서드와 조상 클래스의 메서드 간의 충돌
     * 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.



* 예제:

  ```java
  
  public class Ex7_11 {
  	public static void main(String[] args) {
  		Child3 c =new Child3();
  		c.method1();
  		c.method2();
  		MyInterface.staticMethod();
  		MyInterface2.staticMethod();
  	}
  }
  
  class Child3 extends Parent3 implements MyInterface, MyInterface2 {
  	public void method1() {
  		System.out.println("method1() in Child3");
  	}
  }
  
  class Parent3 {
  	public void method2() {
  		System.out.println("method2() in Parent3");
  	}
  }
  
  interface MyInterface {
  	default void mehod1() {
  		System.out.println("method1() in MyInterface");
  	}
  	
  	default void method2() {
  		System.out.println("method2() in MyInterface");
  	}
  	
  	static void staticMethod() {
  		System.out.println("staticMethod() in MyInterface");
  	}
  }
  
  interface MyInterface2 {
  	default void method1() {
  		System.out.println("method1() in MyInterface2");
  	}
  	
  	static void staticMethod() {
  		System.out.println("staticmethod() in MyInterface2");
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > method1() in Child3
  >
  > method2() in Parent3
  >
  > staticMethod() in MyInterface
  >
  > staticmethod() in MyInterface2



## 27. 내부 클래스(inner class)

* 내부 클래스는 클래스 내에 선언된 클래스.

* 내부 클래스 장점

  * 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.
  * 코드의 복잡성을 줄일 수 있다(캡슐화).

* 내부클래스는 외부클래스를 제외하고는 다른 클래스에서 잘 사용되지 않는 것이어야 한다.

  ```java
  class A { 		// 외부 클래스
    ...
      class B { // 내부 클래스
        ...
      }
    ...
  }
  ```



### 1. 내부 클래스의 종류와 특징

* 내부 클래스의 종류는 변수의 선언 위치에 따른 종류와 같음.
  변수를 선언하는 것과 같은 위치에 선언 할 수 있음.

  | 내부 클래스                           | 특징                                                         |
  | ------------------------------------- | ------------------------------------------------------------ |
  | 인스턴스 클래스<br />(instance class) | 외부 클래스의 멤버변수 선언위치에 선언하며, 외부 클래스의 인스턴스멤버처럼 다루어진다. <br />주로 외부 클래스의 인스턴스멤버들과 관련된 작업에 사용될 목적으로 선언된다. |
  | 스태틱 클래스<br />(static class)     | 외부 클래스의 멤버변수 선언위치에 선언하며, 외부 클래스의 static멤버처럼 다루어진다.<br />주로 외부 클래스의 static멤버, 특히 static메서드에서 사용될 목적으로 선언된다. |
  | 지역 클래스<br />(local class)        | 외부 클래스의 메서드나 초기화 블럭 안에 선언하며, 선언된 영역 내부에서만 사용될 수 있다. |
  | 익명 클래스<br />(anonymous class)    | 클래스의 선언과 객체의 생성을 동시에 하는 이름없는 클래스(일회용) |



### 2. 내부 클래스의 선언

* 아래의 코드를 비교해보면, 외부 클래스(Outer)에 3개의 서로 다른 종류의 내부 클래스가 선언 되어있음.
  코드를 비교해보면, 내부 클래스의 선언위치가 변수의 선언위치와 동일.
* 내부 클래스도 선언된 위치에 따라 변수처럼(인스턴스 변수, 클래스 변수) 나뉨.
* 내부 클래스의 선언 위치에 따라 같은 선언 위치의 변수와 동일한 유효범위(scope)와 접근성(accessibility)을 갖는다.



```java
class Outer {
  int iv = 0;
  static int cv = 0;
  
  void myMethod() {
    int lv = 0;
  }
}
```

↕️

```java
class Outer {
  class InstanceInner {}
  static class StaticInner {}
  
  void myMethod() {
    class LocalInner {}
  }
}
```



### 3. 내부 클래스의 제어자와 접근성

* 위의 코드에서 인스턴스 클래스(InstanceInner)와 스태틱 클래스(StaticInner)는 외부 클래스(Outer)의 멤버변수(인스턴스 변수와 클래스 변수)와 같은 위치에 선언되며, 
  또한 멤버변수와 같은 성질을 갖는다.
* 내부 클래스도 abstract나 final과 같은 제어자, private,protected과 접근제어자도 사용 가능하다.





### 4. 예제

* 예제 1: 내부 클래스 중에서 스태틱 클래스(StaticInner)만 static멤버를 가질 수 있다.
  내부 클래스에 static변수를 선언해야한다면, 스태틱클래스로 선언해야한다.
  다만, final과 static이 동시에 붙은 변수는 상수이므로 정의가 가능.

  ```java
  class Ex7_12 {
  	class InstanceInner {
  		int iv=100;
  		// static int cv = 100;		  < 에러! static변수를 선언할 수 없다.
  		final static int CONST = 100; // final static은 상수이므로 허용
  	}
  	
  	static class StaticInner {
  		int iv = 200;
  		static int cv = 200; // static클래스만 static 멤버를 정의할 수있다.
  	}
  	
  	void myMethod() {
  		class LocalInner {
  			int iv = 300;
  			// static int cv = 300;       < 에러! static변수를 선언할 수 없다.
  			final static int CONST = 300; // final static은 상수이므로 허용
  		}
  	}
  	
  	public static void main(String[] args) {
  		System.out.println(InstanceInner.CONST);
  		System.out.println(StaticInner.cv);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 100
  >
  > 200



* 예제 2: 인스턴스멤버와 static멤버 처럼, 인스턴스클래스는 **외부 클래스의 인스턴스 멤버를 객체 생성 없이 사용할 수 있지만**,
  **스태틱 클래스는 외부 클래스의 인스턴스 멤버를 객체 생성 없이 사용할 수 없다**.
  마찬가지로 **인스턴스 클래스는 스태틱클래스의 멤버들을 객체생성없이 사용 가능하지만, 스태틱 클래스의 경우 인스턴스 클래스의 멤버들을 객체 생성 없이 사용할 수 없다**.

  ```java
  class Ex7_13 {
  	class InstanceInner{}
  	static class StaticInner {}
  	
  	// 인스턴스멤버 간에는 서로 직접 접근이 가능하다.
  	InstanceInner iv = new InstanceInner();
  	// static 멤버간에는 서로 직접 접근이 가능하다.
  	static StaticInner cv = new StaticInner();
  	
  	static void staticMethod() {
  		// static멤버는 인스턴스멤버에 직접 접근할 수 없다.
  		//InstanceInner obj1 = new InstanceInner();
  		StaticInner obj2 = new StaticInner();
  		
  		// 굳이 접근하려면 아래와 같이 객체를 생성해야한다.
  		// 인스턴스 클래스는 외부 클래스를 먼저 생성해야만 생성할 수 있다.
  		Ex7_13 outer = new Ex7_13();
  		InstanceInner obj1 = outer.new InstanceInner();
  	}
  	
  	void instanceMethod() {
  		//인스턴스메서드에서는 인스턴스멤버와 static멤버 모두 접근 가능하다.
  		InstanceInner obj1=new InstanceInner();
  		StaticInner obj2=new StaticInner();
  		//메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근할 수 없다.
  		//LocalInner lv = new LocalInner();
  	}
  	
  	void myMethod() {
  		class LocalInner {}
  		LocalInner lv = new LocalInner();
  	}
  }
  ```



* 예제 3: 내부 클래스에서 외부 클래스의 변수들에 대한 접근성을 보여주는 예제.

  ```java
  class Outer {
  	private int outerIv = 0;
  	static int outerCv = 0;
  	
  	class InstanceInner {
  		int iiv = outerIv;	//외부 클래스의 private멤버도 접근 가능하다.
  		int iiv2 = outerCv;
  	}
  	
  	static class StaticInner {
  		// 스태틱 클래스는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
  		// int siv = outerIv;
  		static int scv = outerCv;
  	}
  	
  	void myMethod() {
  		int lv =0;
  		final int LV=0; //JDK1.8부터 final생략 가능.
  		
  		class LocalInner {
  			int liv = outerIv;
  			int liv2 = outerCv;
  			// 외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근 가능하다.
  			// int liv3=lv; < 에러! (JDK1.8부터 에러 아님.)
  			int liv4=LV; //OK
  		}
  	}
  }
  ```

  * 지역클래스(LocalInner)는 외부 클래스의 인스턴스멤버와 static멤버를 모두 사용할 수 있음.
    지역클래스가 포함 된 메서드에 정의된 지역변수도 사용 가능.(단, final이 붙은 지역변수만 접근 가능. 메서드가 수행을 마쳐 지역변수가 소멸된 시점에도, 지역클래스의 인스턴스가 소멸된 지역변수를 참조하려 할 수 도있기때문.)

* 예제 4: 외부 클래스가 아닌 다른 클래스에서 내부 클래스를 생성하고 내부 클래스의 멤버에 접근하는 예제.

  ```java
  class Outer2 {
  	class InstancInner {
  		int iv = 100;
  	}
  	
  	static class StaticInner {
  		int iv = 200;
  		static int cv = 300;
  	}
  	
  	void myMethod() {
  		class LocalInner {
  			int iv = 400;
  		}
  	}
  }
  
  public class Ex7_15 {
  	public static void main(String[] args) {
  		//인스턴스클래스의 인스턴스를 생성하려면 
  		// 외부 클래스의 인스턴스를 먼저 생성해야한다.
  		Outer2 oc = new Outer2();
  		Outer2.InstancInner ii = oc.new InstanceInner();
  		
  		System.out.println("ii.iv : "+ii.iv);
  		System.out.println("Outer2.StaticInner.cv : "+Outer2.StaticInner.cv);
  		
  		// 스태틱 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다.
  		Outer2.StaticInner si =new Outer2.StaticInner();
  		System.out.println("si.iv : "+si.iv);
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > ii.iv : 100
  >
  > Outer2.StaticInner.cv : 300
  >
  > si.iv : 200

* 예제 5: 내부 클래스와 외부 클래스에 선언된 변수의 이름이 같을 때 변수 앞에 'this'또는 '외부 클래스명.this'를 붙여서 서로 구별할 수 있다는 것을 보여줌.

  ```java
  class Outer3 {
  	int value = 10; // Outer3.this.value
  	
  	class Inner {
  		int value = 20; // this.value
  		
  		void method1() {
  			int value = 30;
  			System.out.println("value:"+value);
  			System.out.println("this.value:"+this.value);
  			System.out.println("Outer3.this.value:"+Outer3.this.value);
  		}
  	}//Inner클래스의 끝. 
  }// Outer3클래스의 끝.
  public class Ex7_16 {
  	public static void main(String[] args) {
  		Outer3 outer=new Outer3();
  		Outer3.Inner inner = outer.new Inner();
  		inner.method1();
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > value:30
  >
  > this.value:20
  >
  > Outer3.this.value:10



## 28. 익명 클래스(anonymous class)

* 익명 클래스는 다른 내부 클래스들과는 달리 이름이 없다.

* 클래스의 선언과 객체의 생성을 동시에 하기 때문에 단 한번만 사용 될 수 있고, 오직 하나의 객체만을 생성할 수 있는 일회용 클래스.

  ```java
  new 조상클래스이름() {
    // 멤버 선언
  }
  		또는
  new 구현인터페이스이름() {
        //멤버 선언
      }
  ```

* 이름이 없기 때문에 생성자도 가질 수 없으며,

  조상 클래스의 이름이나 구현하고자 하는 인터페이스의 이름을 사용해서 정의하기 때문에 
  하나의 클래스로 상속받는 동시에 인터페이스를 구현하거나 둘 이상의 인터페이스를 구현할 수없다.



* 예제1: 익명 클래스의 사용 예

  ```java
  class Ex7_17 {
    Object iv = new Object(){void method(){}};//익명 클래스
    static Object cv = new Object(){void method(){}};//익명 클래스
    
    void myMethod() {
      Object lv = new Object(){void method(){}} //익명 클래스
    }
  }
  ```

  * 이 예제를 컴파일 시, 생성되는 클래스파일.
    Ex77_17.class
    Ex77_17$1.class
    Ex77_17$2.class
    Ex77_17$3.class

* 예제 2: 익명클래스 변환 예

  ```java
  import java.awt.*;
  import java.awt.event.*;
  
  public class Ex7_18 {
  	public static void main(String[] args) {
  		Button b = new Button("Start");
  		b.addActionListener(new EventHandler());
  	}
  }
  
  class EventHandler implements ActionListener {
  	public void actionPerformed(ActionEvent e) {
  		System.out.println("ActionEvent occurred!!!");
  	}
  }
  ```

* 예제 3: 예제 2를 익명클래스를 이용해 변경한 것.
  먼저 두개의 독립된 클래스를 작성 후, 익명클래스를 이용하여 변경하면 쉽게 코드르 작성할 수 있다.

  ```java
  import java.awt.*;
  import java.awt.event.*;
  
  public class Ex7_19 {
  	public static void main(String[] args) {
  		Button b = new Button("Start");
  		b.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				System.out.println("ActionEvent occurred!!!");
  			}
  		}//익명 클래스의 끝.
  		);
  	}//main의 끝.
  }
  ```

  

