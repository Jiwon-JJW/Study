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
     public > protected > (default) > private 순.

  3. **조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.**

     * 오버라이딩의 바른 예시:

       ```java
       class parent {
         void parentMethod() throws IOException, SQLException {
           ...
         }
       }
       
       class Child extends Parent {
         void parentMethod() throws IOException {
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

