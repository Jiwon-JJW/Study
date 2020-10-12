# CHAPTHER 02



## 01. 화면에 글자 출력하기

* 글자를 출력 할 때 사용하는 명령어 : 

  >  System.out.print ( )          > 괄호 안의 내용을 출력하고, 줄바꿈을 **하지 않는다.**
  >
  >  System.out,println ( )       > 괄호 안의 내용을 출력하고, 줄바꿈을 **한다.**

  ✔️ **대소문자를 구분하기 때문에, System을 system으로 입력하지 않도록 주의할 것**
  
* 예제


  ```java
  class Ex2_1{
    public static void main(String args[]) {
      System.out.println("Hello, world"); //화면에 Hello, world를 출력하고 줄바꿈 한다.
      System.out.print("Hello");          //화면에 Hello를 출력하고 줄바꿈 하지 않는다.
      System.out.println("World");        //화면에 World를 출력하고 줄바꿈 한다.
    }
  }
  ```

  > 위 코드의 결과값:
  > Hello, world
  > Helloworld

  

  ```java
  class Ex2_2 {
    public static void main(String args[]) {
      System.out.println("Hello, world"); //화면에 Hello,world를 출력하고 줄바꿈 한다.
      Systen.out.print("3+5=");           //화면에 3+5=을 출력하고 줄바꿈 하지 않는다.
      System.out.println(3+5);            //화면에 8을 출력하고 줄바꿈 한다.
    }
  }
  ```

  > 위 코드의 결과값:
  > Hello, world
  > 3+5=8



## 02. 덧셈 뺄셈 계산하기

* 사칙연산 (+,-,*,/)이 포함 된 식(expression)의 결과를 출력할 때 사용하는 명령어:

  > System.out.println(5+3);

  

* 문장이 수행되는 과정:

  >  System.out.println(5+3);  //괄호 안의 식을 계산.
  >
  > ↪ System.out.println(8);  //식이 계산 결과로 바뀌어 8이 화면에 출력.



* 예제

  ```java
  class Ex2_3 {
    public static void main(String args[]) {
      System.out.println(5+3); //화면에 5+3의 결과인 8이 출력된다.
      System.out.println(5-3); //화면에 5-3의 결과인 2가 출력된다.
      System.out.println(5*3); //화면에 5*3의 결과인 15가 출력된다.
      System.out.println(5/3); //화면에 5/3의 결과인 1이 출력된다.
    }
  }
  ```

  > 위 코드의 결과값:
  > 8
  > 2
  > 15
  > 1

  ✔️ 정수 나누기 정수는 정수로 출력 된다.



## 03. 변수의 선언과 저장

#### 변수란?

하나의 값을 저장할 수 있는 저장공간.

* 값이란?: 0,1로 이루어진 컴파일.
  한 번 실행하면 사라진다.



1. 변수를 선언하는 방법:

   > 변수타입 변수이름;  
   >
   > * 변수 타입: 변수에 저장 할 값이 무엇이냐에 따라 달라짐.
   >
   > * 변수 이름: 저장공간이 서로 구별 되어야 하기 때문에 필요함.
   >   
   >* 예제:
   > 
   >  ```java
   >   int x; //정수(integer)를 저장하기 위한 변수 x를 선언
   >  ```
   
2. 변수에 값을 저장하는 방법:

   > * 예제:
   >
   >   ```java
   >   x = 5;   //변수 x에 5를 저장
   >   ```
   >
   >   * 수학에서 =는 같음을 의미하지만, Java에서는 오른쪽 값을 왼쪽에 저장하라는 의미.
   >     **'대입(할당) 연산자 (assignment operator)'** 라고 한다.

* **이 때, 변수의 선언과 대입을 한 줄로 간단히 진행할 수 있다.**

  ```java
  int x = 5;
  ```

  * 예제:

  ```JAVA
  class Ex2_4 {
    public static void main(String args[]) {
      int x = 5;             //int x;와 x = 5;를 한 줄로 합칠 수 있다.
      System.out.println(x); //화면에 x의 값인 5가 출력된다.
      
      x = 10;                //변수 x에 10을 저장. 기존에 저장되어 있던 5는 지워진다.
      System.out.println(x); //화면에 x의 값은 10이 출력된다.
    }
  }
  ```

  > 이 코드의 결과 값:
  > 5
  > 10

---

* 직접 정수를 입력 한 사칙연산의 경우, 값이 변동 되었을 때 코드의 숫자를 **매번 바꿔 줘야 한다.**
  변수를 이용 할 경우, 각 변수에 다른 값만 저장하면 되기 때문에, **매번 바꾸지 않아도 된다.**

  * 예제:

    ```java
    class Ex2_5 {
      public static void main(String args[]) {
        int x = 10;
        int y = 5;
        System.out.println(x+y);
        System.out.println(x-y);
        System.out.println(x*y);
        System.out.println(x/y);
      }
    }
    ```

    > 이 코드의 결과 값:
    >
    > 15
    >
    > 5
    >
    > 50
    >
    > 2



## 04. 변수의 타입

* 변수 선언 시, 저장 할 값의 종류에 따라 변수의 타입을 선택해야함.

  * 변수의 타입: 참조형 , 기본형 (총 8개)
    아래의 구분 표는 자주 사용하는 것만 정리한 것.

  | 분류  | 변수의 타입               | 설명                                                         |
  | ----- | ------------------------- | ------------------------------------------------------------ |
  | 숫자1 | **Int** (4byte)<br />long | 정수 (integer)를 저장하기 위한 타입(20억이 넘을 땐 long)     |
  | 숫자2 | float<br />**double**     | 실수(floating-point number)를 저장하기 위한 타입<br />(float는 오차없이 7자리, double는 15자리) |
  | 문자1 | char (1byte)              | 문자(character)를 저장하기 위한 타입                         |
  | 문자2 | String                    | 여러 문자(문자열, string)를 저장하기 위한 타입               |

  * 변수를 선언 한 예:

    ```java
    int x = 100;        //정수(integer)를 저장할 변수의 타입은 int로 한다.
    double pi = 3.14;   //실수를 저장할 변수의 타입은 double로 한다.
    char ch = 'a';      //문자(1개)를 저장할 변수의 타입은 char로 한다.
    String str = "abc"; //여러 문자(0~n개)를 저장할 변수의 타입은 String으로 한다.
    ```

  * 예제:

    ```java
    class Ex2_6 {
      public static void main(String args[]) {
        int      x = 100;
        double  pi = 3.14;
        char    ch = 'a';
        String str = "abc";
      }
    }
    ```

    > 위 코드의 결과값:
    > 100
    > 3.14
    > a
    > abc



## 05.상수와 리터럴

#### 상수(constant)란?

* 변수와 마찬가지로, '값을 저장할 수 있는 공간'이지만, **값을 저장하면 다른 값으로 변경할 수 없다.** 

* 선언 방법: 변수의 타입 앞에 'final' 입력

  > final int MAX_SPEED = 10;

  상수의 이름은 모두 **대문자**로 하는 것이 관례. 여러 단어로 이루어져 있을 경우, **'_'**로 구분.

* 예제:

  ```java
  final int MAX_VALUE; //정수형 상수 MAX_VALUE를 선언
  MAX_VALUE = 100;     //OK. 상수에 처음으로 값 저장
  MAX_VALUE = 200;     //에러. 상수에 저장된 값을 변경할 수 없음
  ```



---




#### 리터럴(literal)이란?

* 그 자체로 값을 의미하는 것.
  정확히는 값과 리터럴은 엄연히 다른 것 이며, 리터럴이 값(0,1로 이루어진 컴파일)을 만드는 것이지만
  **편의상 리터럴=값 으로 의미한다.**
* 리터럴 사용 시, 값으로 평가(변환/판단 이라는 말도 사용 가능) 됨.



---



### 총 정리


| 변수(variable)      | 하나의 값을 저장하기 위한 공간      |
| ------------------- | ----------------------------------- |
| **상수(Constant)**  | **값을 한번만 저장할 수 있는 공간** |
| **리터럴(Literal)** | **그 자체로 값을 의미하는 것**      |



## 06. 리터럴의 타입과 접미사

> 변수의 타입은, 저장 될 **값의 타입(리터럴의 타입)** 에 의해 결정 되므로,
> 리터럴에 타입이 없다면, 변수의 타입도 필요 없을 것이다.



* 리터럴의 타입:

  | 종류       | 리터럴                       | 접미사 |
  | ---------- | ---------------------------- | ------ |
  | 논리형     | false, true                  | 없음   |
  | **정수형** | 123, 0b0101, 077, 0xFF, 100L | L      |
  | **실수형** | 3.14, 3.0e8, 1.4f, 0x1.0p-1  | f, d   |
  | 문자형     | 'A', '1', '\n'               | 없음   |
  | 문자열     | "ABC", "123", "A", "true"    | 없음   |

  

  #### 정수형과 실수형 리터럴

  * 정수형과 실수형에는 여러 타입이 존재하므로, 리터럴에 접미사를 붙여 타입을 구분.

    > 정수형의 경우: 
    >
    > 1. long타입의 리터럴 :  "l" 또는, "L"을 붙임. (접미사가 없다면 int 타입의 리터럴이 됨)
    > 2. byte와 short타입의 리터럴: 접미사 존재하지 않음. 때문에 int타입의 리터럴을 사용하면 됨.
    >
    > 
    >
    > > 10진수 외의 2, 8, 16진수로 표현된 리터럴을 변수에 저장하는 법: **16진수**를 표시하기 위해 리터럴 앞에 접두사 **'0x' 또는 '0X'**를, **8진수**의 경우 **'0'**을 사용.
    > >
    > > * 예제:
    > >
    > >   ```java
    > >   int octNum = 010;  // 8진수 10, 10진수로 8
    > >   int hexNum = 0x10; //16진수 10, 10진수로 16
    > >   ```
    > >
    > >
    > > 큰 숫자를 읽기 편하게 만드는 '중간자' 기능 사용: JDK 1.7 이상부터 사용 가능
    > >
    > > * 예제:
    > >
    > >   ```java
    > >   long big = 100_000_000_000L;       // long big = 100000000000L;
    > >   long hex = 0xFFFF_FFFF_FFFF_FFFFL; // long hex = 0xFFFFFFFFFFFFFFFFL;
    > >   ```

    

    > 실수형의 경우:
    >
    > 1. float타입의 리터럴: 접미사 'f' 또는 'F'를 붙임.
    > 2. double 타입의 리터럴: 접미사 'd' 또는 'D'를 붙임.
    >
    > 
    >
    > > * 예제:
    > >
    > >   ```java
    > >   float    pi = 3.14f;  //접미사 f대신 F를 사용해도 된다. 생략불가
    > >   double rate = 1.618d; //접미사 d대신 D를 사용해도 된다. 생략가능
    > >   ```

    

  * 정수형에서는 int가 기본 자료형이기때문에 접미사를 붙이지 않은 것 처럼, 
    실수형에서는 double가 기본형이기 때문에, 접미사 생략가능.

    

  

  #### 문자 리터럴과 문자열 리터럴

  

  * 문자 리터럴과 문자열 리터럴의 차이점:

    1. 문자 리터럴 : 'A'와 같이 **작은 따옴표**로 문자 하나를 감싼 것.
    2. 문자열 리터럴: "ABC"와 같이 **큰 따옴표**로 문자를 감싼 것. 
       

  * char타입의 변수는 **단 하나의 문자**만 저장할 수 있기 때문에, **문자열**을 저장하기 위해서는 String타입을 사용.


```java
char     ch = 'J';    //char ch = 'Java'; 이렇게는 할 수 없음.
String name = "Java"; //변수 name에 문자열 리터럴 "Java"를 저장
```


​    

  * 문자열 리터럴 에서 "" 안에 아무 문자도 넣지 않는 것을 **허용**. 이를 **빈 문자열(empty string)** 이라고 한다.
    문자 리터럴은 반드시 '' 안에 하나의 문자가 있어야함.

    ```java
    String str = "";  //OK. 내용이 없는 빈 문자열 
    char    ch = '';  //에러. ''안에 반드시 하나의 문자가 필요
    char    ch = ' '; //OK. 공백 문자(blank)로 변수 ch를 초기화
    ```

    

    * 원래 String은 클래스 이므로, 연산자 new를 사용해야 함.
      하지만 특별히 아래와 같은 표현도 허용.

      ```JAVA
      String name = new String("Java"); //String객체를 생성
      String name = "Java";             //위의 문장을 간단히. 둘의 차이점은 추후 설명됨.
      ```


---

  ##### 문자열 결합

  * 두 문자열을 합쳐 출력할 때도 덧셈(+)을 이용할 수 있다.

    ```java
    String name = "Ja" + "va";
    String  str = name + 8.0;
    ```

    > 덧셈 연산자(+)는 피연산자가 모두 숫자일 때는 두 수를 더하지만, **한 쪽이라도 String일 경우, 나머지도 String으로 변환**하여 결합한다.
    >
    > 
    >
    > * 예제:
    >
    >   7 + ""   ➡️  "7" + ""  ➡️ "7 "
    >   7 + "7" ➡️ "7" +" 7" ➡️ "77"
    >
    >   덧셈 연산자의 경우, 왼쪽에서 오른쪽의 방향으로 연산을 수행.
    >   결합순서에 따라 결과가 달라지기 때문에 주의할것.
    >
    >   **숫자 7을 문자열"7"로 변환 할 때는, 빈 문자열("")을 더해주면 됨.**

    

  * 예제:

    ```java
    class Ex2_7 {
      public static void main(String[] args); {
        String name = "Ja" + "va";
        String str  = name + 8.0;
        
        System.out.println(name);
        System.out.println(str);
        System.out.println(7 + " ");
        System.out.println(" " + 7);
        System.out.println(7 + "");
        System.out.println("" + 7);
        System.out.println("" + "");
        System.out.println(7 + 7 + "");
        System.out.println("" + 7 + 7);
      }  
    }
    ```

    > 이 코드의 결과값:
    >
    > 7
    >
    >  7
    >
    > 7
    >
    > 7
    >
    > 14
    >
    > 77



## 07. 📌두 변수의 값 바꾸기

* 두 변수 x와 y에 저장 된 값을 바꾸기 위해서는,
  두 개의 컵에 담겨있는 음료의 내용물을 바꾸기 위해 빈 컵이 필요한 것처럼, **임시로 저장할 변수**가 **하나 더 필요**하다.

  이 때 사용하는 값은 

  > int tmp;  // 임시로 값을 저장하기 위한 변수 (빈 컵 역할)

  

* 예제:

  ```java
  class Ex2_8 {
    public static void main(String[] args) {
      int x = 10, y = 5  //int x = 10; int y = 5;를 한 줄로 표현
      System.out.println("x="+x);
      System.out.println("y="+y);
      
      int tmp = x;
      x = y;
      y = tmp;
      System.out.println("x="+x);
      System.out.println("y="+y);
    }
  }
  ```

  > 이 코드의 결과 값:
  >
  > x=10
  >
  > y=5
  >
  > x=5
  >
  > y=10



## 08. 기본형과 참조형

##### 자료형이란?

* 값(data)의 종류(type)에 따라 값이 저장될 공간의 크기와 저장 형식을 정의한 것

* 자료형의 종류:

  1. 기본형 (primitive type):
     논리형(boolean), 문자형(char), 정수형(byte, short, int, long), 실수형(float, double)
     **계산을 위한 실제 값을 저장한다. (총 8개)**

  2. 참조형 (reference type):

     **객체의 주소를 저장한다.** 8개의 기본형을 제외한 나머지가 이에 속한다.
     *값의 크기가 크기 때문에, 참조 방식으로 접근하는 것.*

     * String의 경우, 참조형에 속하는데, 이유는
       글자 수를 **예측할 수 없**기때문에, **크기를 지정해 둘 수 없**기 때문이다.

---

### 기본형의 종류와 범위



#### 기본형의 종류

* 값을 저장 할 때, 데이터의 크기를 보고 메모리를 확보한다.


| 종류 /크기 | 1 byte  | 2 byte | 4 byte  | 8 byte     |
| ---------- | ------- | ------ | ------- | ---------- |
| **논리형** | boolean |        |         |            |
| **문자형** |         | char   |         |            |
| **정수형** | byte    | short  | **int** | long       |
| **실수형** |         |        | float   | **double** |



> 외울 때 참고하면 유용한 문장
>
> * boolean은 true와 false 두 가지 값만 표현할 수 있으면 되므로, 가장 작은 크기인 1byte
> * char은 자바에서 유니코드(2 byte 문자 체계)를 사용하므로 2 byte
> * byte는 크기가 1 byte 라서 byte
> * Int(4 byte)를 기준으로 짧아서 short(2 byte), 길어서 long(8 byte)
> * float는 실수값을 부동소수점(**flot**ing-point)방식으로 저장하기 때문에 float
> * double는 float보다 **두 배**의 크기(8 byte)를 갖기 때문에 double



#### 기본형의 범위

* 정수형 (byte, short, int, long)의 경우 '-2(n승 -1) ~ 2(n승 -1) -1'(n은 bit 수) 라는 것을 기억하면 됨.

  ex) int 형의 경우, 32 bite(4 byte) 이므로 '-2(31승) ~ 2(31승) -1'의 범위.(약 10자리수의 값을 저장 할 수 있음)

  

  - 7~9 자리의 수를 계산할 때는 넉넉하게 long 타입(약 19자리)로 변수를 선언하는 것이 좋다.





## 09. printif를 이용한 출력

* println과 printif의 차이점:

  * println: 사용하기 용이 , **변수의 값을 그대로 출력**하므로 값을 변환하지 않으면, 다른 형식으로 출력할 수 **없음**.
  * printif: '지시자(specifier)'를 통해 **변수의 값을 여러가지 형식으로 변환 하여 출력**하는 기능을 가지고 있음.

* 예시:
  정수형 변수에 저장 된 값을 10진 정수로 출력할 때 사용하는 지시자: %d
  변수의 값을 지정 된 형식으로 변환하여 지시자 대신 넣는다.
* int타입의 변수 age 값이 14일 때,
    printif()는 지시자 '%d' 대신 14를 넣어 출력.


    ```java
    system.out.printif("age:%d", age);
    > system.out.printif("age:%d", 14);
    > system.out.printif("age:14");     //"age:14"가 화면에 출력된다.
    ```

  * 출력하려는 값이 2개일 경우, 지시자도 2개 입력 되어야 하며
    **출력될 값과 지시자의 순서가 동일해야한다. (이 때, 값의 개수 제한은 없다.)**

    ```java
    system.out.printif("age:%d year:%d", age, year);
    > system.out.printif("age:%d year:%d", 14, 2019);
    > system.out.printif("age:14 year:2019");        //"age:14 year:2019"가 화면에 출력된다.
    ```

* 자주 사용하는 print() 지시자

  * println과 달리, printif는 출력 후 줄 바꿈을 하지 않기 때문에, 지시자 '%n'을 넣어줘야함.

    *'%n' 대신 '\n'을 사용해도 되지만, OS마다 줄바꿈 문자가 다를 수 있기 때문에 '%n'을 사용하는 것이 안전*

    | 지시자 | 설명                                                         |
    | ------ | ------------------------------------------------------------ |
    | %d     | 10진(**d**ecimal)정수의 형식으로 출력                        |
    | %x     | 16진(hexa-decimal)정수의 형식으로 출력                       |
    | %f     | 부동 소수점(floating-point)의 형식으로 출력- **기본적으로 소수점 아래 6자리 까지만 출력 됨.**(이게 넘어갈 경우, 반올림 됨.) |
    | %c     | 문자(character)로 출력                                       |
    | %s     | 문자열(string)로 출력                                        |

    

  * 실수형 값을 출력하는 print () 지시자는 총 3개가 있다.

    | %f     | 주로 사용되는 지시자 |
    | ------ | -------------------- |
    | **%e** | 지수 형태로 출력     |
    | **%g** | 값을 간략하게 표현   |

    

* 출력 예제:

  * %f 특성때문에, 전체 자리수와 소수점 아래의 자리수를 지정할 수 있다.

    > %**전체자리.**소수점아래자리f

  * %s 에도 숫자를 추가하면 원하는 만큼의 출력공간을 확보하거나, 문자 열의 일부만 출력할 수 있다.

    > %(수치)s : 수치만큼 좌측에 공백 생성
    >
    > %(-수치)s: 수치만큼 우측에 공백 생성
    >
    > %(.수치)s: 수치만큼 문자열 일부만 출력 가능.

  ```java
  class Ex2_9 {
    public static void main(String[] args){
     String url = "www.codechobo.com";
     float f1 = .10f;                        //0.10, 1.0e-1
     float f2 = 1e1f;                        //10.0, 1.0e1, 1.0e+1
     float f3 = 3.14e3f;
     double d = 1.23456789;
     
      System.out.printif("f1=%f, %e, %g%n", f1, f1, f1);
      System.out.printif("f2=%f, %e, %g%n", f2, f2, f2);
      System.out.printif("f3=%f, %e, %g%n", f3, f3, f3);
      System.out.printif("d=%f%n, d");
      System.out.printif("d=%14.10f%n, d");  //전체 14자리 중 소수점 10자리 까지 (빈 자리는 0으로 채움)
      System.out.printif("[12345678901234567890]%n");
      System.out.printif("[%s]%n", url);
      System.out.printif("[%20s]%n", url);
      System.out.printif("[%-20]%n", url);   //왼쪽 정렬
      System.out.printif("[%8s]%n", url);    //왼쪽에서 8글자만 출력
    }
  }
  ```

  > 이 코드의 결과 값:
  > f1=0.100000, 1.000000e-01, 0.100000
  >
  > f2=10.000000, 1.000000e+01, 10.0000
  >
  > f3=3140.000000, 3.140000e+03, 3140.00
  >
  > d=1.234568 < 마지막 자리 반올림 됨
  > d=   1.2345678900
  >
  > [12345678901234567890]
  >
  > [www.codechobo.com]
  >
  > [   www.codechobo.com]
  >
  > [www.codechobo.com   ]
  >
  > [www.code]





## 10. 정수형의 오버플로우

#### 오버플로우란?

* 타입이 표현할 수 있는 값의 범위를 넘어서는 것을 오버플로우(overflow)라고 한다.
* 오버플로우가 발생했다 해서 에러가 발생하는 것은 아니지만, 예상치 못한 결과를 얻을 수있으니,
  **오버플로우가 발생하지 않게 충분한 크기의 타입을 선택해서 사용해야함**



## 11. 타입 간의 변환방법

1.  숫자를 문자로 변환 - 숫자에 '0'을 더한다.

   > (char)(3 + '0') ➡️ '3'

2. 문자를 숫자로 변환 - 문자에서 '0'을 뺀다.

   > '3' - '0' ➡️ 3

3. 숫자를 문자열로 변환 - 숫자에 빈 문자열("")을 더한다.

   > 3 + "" ➡️ 3

4. 문자열을 숫자로 변환 - Integer.parselnt() 또는 Double.parseDouble() 을 사용한다.

   > Integer.parselnt("3") ➡️ 3
   > Double.parseDouble("3.14") ➡️ 3.14

5. 문자열을 문자로 변환 - charAt(0) 을 사용한다.

   > "3".charAT(0) ➡️ '3'

6. 문자를 문자열로 변환 - 빈 문자열("")을 더한다.

   > '3' + "" ➡️ "3"



* 예제:

  ```java
  class Ex2_11 {
    public static void main(String args[]) {
      String str = "3";
      
      System.out.println(str.charAt(0) - '0');
      System.out.println('3' - '0' + 1);
      System.out.println(Interger.parseInt("3") + 1);
      System.out.println("3" + 1);
      System.out.println((char)(3+'0'));
    }
  }
  ```

  > 이 코드의 결과:
  > 3
  >
  > 4
  >
  > 4
  >
  > 31
  >
  > 3



---

###  

#### QnA 1) 기본형의 범위에 대해서, 정수형은 오버플로우를 넘기지 않기 위해 하는데, 문자형의 경우도 오버플로우와 비슷한 현상을 방지하기 위해 계산을 해야하는 걸까요?

#### QnA 2) printif를 사용 할 때, 예제에 적힌 부분 중 일부에 관해 이해가 안가는데..

```java
> 중략
Float f1 = .10f;

System.out.printif("f1=%f, %e, %g%n", f1, f1, f1);
```

의 결과 값이
f1= 0.100000, 1.000000e-01, 0.100000

위와 같이 나오는데,
%e는 지수 형태로 출력한다고 했습니다.

%e 의 결과 값이 1.000000e-01 로 나오는 이유가 궁금합니다...
소숫점 첫째점에서 시작되는 실수기 때문에 -01 인 것인지..? 0.1을 표현하기 위해?
왜... 소수점 뒤에 000000이 붙는것인지.. (소수점 아래 6글자를 채우기 위함인가요?) 

#### QnA 3) 2번의 질문과 이어집니다.

%g의 경우, 값을 간략하게 표현..이라고 했는데, 그 기준이 어떤 것인지.
예제에서는 

```java
   float f1 = .10f;                        //0.10, 1.0e-1
   float f2 = 1e1f;                        //10.0, 1.0e1, 1.0e+1
   float f3 = 3.14e3f;
   
    System.out.printif("f1=%f, %e, %g%n", f1, f1, f1);
    System.out.printif("f2=%f, %e, %g%n", f2, f2, f2);
    System.out.printif("f3=%f, %e, %g%n", f3, f3, f3);
```

의 결과 값이

f1=0.100000

f2=10.0000

f3=3140.00



인데 간략함의 기준이 무엇인지...궁금합니다.


