# CHAPTER 08. 예외처리

## 01. 프로그램 오류

### 프로그램 오류란?

* 프로그램 실행 중 어떤 원인에 의해서 오작동을 하거나 비정상적으로 종료되는 경우, 이러한 결과를 초래하는 원인.
* 발생 시점에 따라 '컴파일 에러(compile-time error)'와 '런타임 에러(runtime error)', 이외에 '논리적 에러(logical error)'로 나눌 수 있다.
  1. **컴파일 에러:** 컴파일 시에 발생하는 에러
     * 컴파일러가 소스코드(*.java)에 대해 오타나 잘못된 구문,자료형 체크 등 검사를 진행하여 오류가 있는지 알려줌.
  2. **런타임 에러:** 실행 시에 발생하는 에러
     * 실행 시 발생할 수 있는 프로그램 오류를 '에러(error)'와 '예외(exception)' 두가지로 구분.
       1. 에러 (error): 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
          ex) 메모리 부족(OutOfMemoryError), 스택오버플로우(StackOverflowError)
       2. 예외(exception): 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
  3. **논리적 에러:** 실행은 되지만, 의도와 다르게 동작하는 것



## 02. 예외 클래스의 계층구조

* 자바에서는 실행 시 발생할 수 있는 오류(Exception과 Error)를 클래스로 정의 함.
* Excption과 Error클래스도 Object클래스의 자손들임.

![image](https://user-images.githubusercontent.com/69128652/93057473-f1ce7700-f6a8-11ea-9bfc-8a0571767c9a.png)

* Exception클래스와 RuntimeException클래스 중심의 상속계층도
  ![image](https://user-images.githubusercontent.com/69128652/93057770-673a4780-f6a9-11ea-9c63-1b34979324fd.png)
  * 예외클래스들은 다음과 같이 두 그룹으로 나눠 질 수 있다.
    1. Exception클래스와 그 자손들(윗부분)
    2. RuntimeException클래스와 그 자손들(아랫부분)



## 03. Exception과 RuntimeException

* RuntimeException 클래스와 그 자손들: 'RuntimeException클래스들'

  * RuntimeException클래스들: 프로그래머의 실수로 발생하는 예외

    * ex) 배열의 범위를 벗어남 (ArrayIndexOutOfBoundsException)

      값이 null인 참조변수의 멤버를 호출하려 함 (NullPointerException)
      클래스간의 형변환을 잘못함 (ClassCastException)
      정수를 0으로 나누려고함 (ArithmeticException)

* RuntimeException 클래스를 제외한 나머지 클래스들: 'Exception클래스들'

  * Exception클래스들: 사용자의 실수와 같은 외적인 요인 의해 발생하는 예외
    * ex) 존재하지 않는 파일의 이름을 입력함 (FileNotFoundException)
      실수로 클래스의 이름을 잘못적음 (ClassNotFoundException)
    * 입력한 데이터 형식이 잘못됨(DataFormatException)



## 04. 예외처리하기 - try - catch문

#### * 예외처리(exception handling)란?

* 정의: 프로그램 실행 시 발생할 수 있는 예기치 못한 예외의 발생에 대비한 코드를 작성하는 것.
* 목적: 프로그램의 갑작스런 비정상 종료를 막고, 정상적인 실행상태를 유지할 수 있도록 하는 것.



---

* 발생한 예외를 처리하지 못하면, 프로그램은 비정상적으로 종료 되며
  처리되지 못한 예외(uncaught exception)는 JVM의 '예외처리기(UncaughtExceptionHandler)'가 받아서 원인을 화면에 출력.

* 예외를 처리하기 위해 try-catch문을 사용.

  ```java
  try{
    //예외가 발생할 가능성이 있는 문장들을 넣는다.
  } catch (Exception1 e1) {
    //Exception1이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
  } catch (Exception2 e2) {
    //Exception2가 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
  } catch (ExceptionN eN) {
    //ExceptionN이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
  }
  ```

  * 하나의 try블럭 다음에는 여러 종류의 예외를 처리할 수 있도록,하나 이상의 catch블럭이 올 수 있음.
  * 이 중 발생한 예외의 종류와 일치하는 단 한개의 catch블럭만 수행됨. 일치하는 catch블럭이 없으면 처리되지 않음.
  * catch블럭 내에 포함된 문장이 하나뿐이어도 괄호{}를 생략할 수 없다.



#### * try-catch문에서의 흐름

* try-catch문에서, 예외가 발생한 경우와 그렇지 않았을 때 흐름이 달라짐.
  * try블럭 내에서 예외가 발생한 경우.
    1. 발생한 예외와 일치하는 catch블럭이 있는지 확인한다.
    2. 일치하는 catch블럭을 찾게 되면, 그 catch블럭 내의 문장들을 수행하고 전체 try-catch문을 빠져나가서 그 다음 문장을 계속해서 수행.
       일치하는 catch블럭을 찾지 못하면 예외는 처리되지 않는다.
  * try블럭 내에서 예외가 발생하지 않은 경우.
    1. catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속함.
       

* 예제1: 예외가 발생하지 않아, catch블럭의 문장이 실행되지 않는 예.

  ```java
  class Ex8_1 {
  	public static void main (String[] args) {
  		System.out.println(1);
  		try {
  			System.out.println(2);
  			System.out.println(3);
  		}catch (Exception e) {
  			System.out.println(4); //실행되지 않는다.
  		} // try-catch의 끝 
  		System.out.println(5);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 1
  >
  > 2
  >
  > 3
  >
  > 5

* 예제 2: 예제 1을 변경해서 try 블럭에서 예외가 생기도록 변경 한 예.

  ```java
  public class Ex8_2 {
  	public static void main(String[] args) {
  		System.out.println(1);
  		try{
  			System.out.println(0/0);
  			System.out.println(2);
  		} catch (ArithmeticException ae) {
  			System.out.println(3);
  		} // try-catch의 끝 
  		System.out.println(4);
  	}// main 메서드의 끝 
  }
  ```

  > 위 식의 결과:
  > 1
  >
  > 3
  >
  > 4



## 05.예외의 발생과 catch블럭

* catch블럭은 괄호()와 블럭{} 두 부분으로 나눠져 있는데,
  괄호() 내에는 처리하고자 하는 예외와 같은 타입의 참조변수를 하나 선언해야한다.

* 예외가 발생 시, 발생한 예외에 해당하는 클래스의 인스턴스가 만들어짐.
  예외가 발생한 문장이 try블럭에 포함되어 있다면, 이 예외를 처리할 수 있는 catch블럭이 있는지 찾게됨.

  > 검사 결과가 true인 catch블럭을 만날 때 까지 검사는 계속된다.

* 모든 예외 클래스는 Exception클래스의 자손이므로, catch블럭의 괄호()에 Exception클래스 타입의 참조변수를 선언해 놓으면, 어떤 종류의 예외가 발생하더라도 이 catch블럭에 의해서 처리됨.





* 예제1: ArithmeticException클래스는 Exception클래스의 자손이므로 ArithmeticException인스턴스와 Exception클래스와의 instanceof연산 결과가 true가 되어 Exception클래스 타입의 참조변수를 선언한 catch블럭의 문장들이 수행되고 예외가 처리되는 것.

  ```java
  	public static void main(String[] args) {
  		System.out.println(1);
  		System.out.println(2);
  		
  		try {
  			System.out.println(3);
  			System.out.println(0/0); // 0으로 나눠서 고의로 ArithmeticException을 발생시킨다.
  			System.out.println(4);	 // 실행되지 않는다.
  		} catch (Exception e) {		 // ArithmeticException대신 Exception을 사용.
  			System.out.println(5);
  		} // try-catch의 끝.
  		
  		System.out.println(6);
  	} 	  // main 메서드의 끝.
  }
  ```

  > 위 식의 결과:
  >
  > 1
  >
  > 2
  >
  > 3
  >
  > 5
  >
  > 6



* 예제 2: ArithmeticException 타입을 선언 한 catch문과 Exception 타입을 선언 한 catch문을 사용한 예제.
  ArithmeticException이 true이기 때문에 Exception 타입은 실행되지 않았다.

  ```java
  public class Ex8_4 {
  	public static void main(String[] args) {
  		System.out.println(1);
  		System.out.println(2);
  		try {
  			System.out.println(3);
  			System.out.println(0/0); // 0으로 나눠서 고의로 ArithmeticException을 발생시킨다.
  			System.out.println(4);   // 실행되지 않는다 
  		} catch (ArithmeticException ae) {
  			if (ae instanceof ArithmeticException)
  				System.out.println("ArithmeticException");
  		} catch (Exception e) {		 // AtithmeticException을 제외한 모든 예외가 처리된다.
  			System.out.println("Exception");
  		} // try-catch의 끝.
  		System.out.println(6);
  	}// main 메서드의 끝 
  }
  ```

  > 위 식의 결과:
  >
  > 1
  >
  > 2
  >
  > 3
  >
  > ArithmeticException
  >
  > 6

* 위의 예제들 처럼, try-catch문의 마지막에 Exception타입의 참조변수를 선언한 catch블럭을 사용 시, 어떤 종류의 예외가 발생하더라도
  이 catch 블럭에 의해 처리되도록 할 수 있다.



## 06. printStackTrace() 와 getMessage()

* 예외가 발생했을 때 생성되는 예외 클래스의 인스턴스에는 발생한 예외에 대한 정보가담겨 있는데,
  getmessage() 와, printStackTrace()를 통해 이 정보들을 얻을 수 있다.

* catch블럭의 괄호()에 선언된 참조변수를 통해 이 인스턴스에 접근할 수 있다.
  참조변수는 선언된 catch블럭 내에서만 사용 가능.

  * printStackTrace(): 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
  * getMessage(): 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.

* 예제: 

  ```java
  public class Ex8_5 {
  	public static void main(String[] args) {
  		System.out.println(1);
  		System.out.println(2);
  		
  		try {
  			System.out.println(3);
  			System.out.println(0/0); // 에러 발생 !!! 
  			System.out.println(4); // 실행되지 않는다 
  		} catch(ArithmeticException ae) {
  			ae.printStackTrace(); // 참조변수 ae를 통해, 생성된 ArithmeticException인스턴스에 접근할 수 있다.
  			System.out.println("예외메시지:" + ae.getMessage());
  		} // try-catch의 끝 
  		
  		System.out.println(6);
  	} // main메서드의 끝 
  }
  ```

  > 위 식의 결과 : 
  >
  > 1
  >
  > 2
  >
  > 3
  >
  > java.lang.ArithmeticException: / by zero
  >
  > ​	at Ex8_5.main(Ex8_5.java:9)
  >
  > 예외메시지:/ by zero
  >
  > 6

  * try-catch문으로 예외 처리를 하여 예의가 발생해도 비정상적으로 종료하지 않도록 해주는 동시에,
    printStackTrace()또는 getMessage()와 같은 메서드를 통해 예외의 발생 원인을 알 수 있다.



## 07. 멀티 catch블럭

* JDK1.7부터 여러 catch블럭을 '|' 기호를 이용해서, 하나의 catch블럭으로 합칠 수 있게 되었음. 이를 '멀티 catch블럭'이라 한다.

  * 중복된 코드를 줄일 수 있음.

  * '|'기호로 연결할 수 있는 예외 클래스의 개수는 제한이 없다.

    > * 변경 전
    >
    >   > try {
    >   >
    >   > ​		...
    >   >
    >   > } catch (ExceptionA e) {
    >   >
    >   > ​	e.printStackTrace();
    >   >
    >   > } catch (ExceptionA e2){
    >   >
    >   > ​	e2.printStackTrace();
    >   >
    >   > }
    >
    > * 변경 후
    >
    >   > try {
    >   >
    >   > ​		...
    >   >
    >   > }catch (ExceptionA | Exception B e) {
    >   >
    >   > ​	e. printStackTrace();
    >   >
    >   > }

* 만일 멀티 catch블럭의 '|'기호로 연결된 예외 클래스가 조상과 자손의 관계에 있다면 컴파일 에러 발생.

  ```java
  try {
    ...
  // }catch (ParentException | ChildException e) { // 에러
  } catch (ParentException e){ // OK.위의 라인과 의미상 동일
    e.printStackTrace();
  }
  ```

  * 두 예외 클래스가 조상과 자손의 관계에 있다면, 그냥 조상 클래스만 써주는 것과 똑같기 때문에, 불필요한 코드는 제거하라는 뜻에서 에러가 발생하는 것.

* 멀티 catch는 하나의 catch블럭으로 여러 예외를 처리하는 것이기 때문에, 
  발생한 예외를 멀티 catch블럭으로 처리하게 되었을 때, **멀티 catch블럭 내에서 어떤 예외가 발생한 것인지 알 수 없다.**

* 참조 변수 e로 멀티 catch블럭에 '|' 기호로 연결된 예외 클래스들의 공통 분모인 조상 예외 클래스에 선언된 멤버만 사용할 수 있음.

  ```java
  try {
    ...
  }catch (ExceptionA | ExceptionB e) {
    e.methodA(); // ERROR. ExceptionA에 선언된 methodA()는 호출 불가
    
    if(e instanceof ExceptionA) {
      ExceptionA e1 = (ExceptionA)e;
      e1.methodA(); // OK. ExceptionA에 선언된 메서드 호출 가능.
    }else { // if(e instanceof ExceptionB)
      ...
    }
  }
  ```

  

## 08. 예외 발생시키기

* 키워드 throw를 사용해, 프로그래머가 고의로 예외를 발생시킬 수 있음.

* 예외를 발생시키는 방법:

  1. 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든다.
     Exception e = new Exception("고의로 발생시켰음");
  2. 키워드 throw를 이용해서 예외를 발생시킨다.
     throw e;

* 예제:

  ```java
  public class Ex8_6 {
  	public static void main(String args[]) {
  		try {
  			Exception e = new Exception("고의로 발생시켰음.");
  			throw e; // 예외를 발생시킴.
  			// throw new Exception("고의로 발생시켰음"); 위의 두 줄을 한 줄로 줄여 쓴 것.
  		} catch (Exception e) {
  			System.out.println("에러메시지:"+e.getMessage());
  			e.printStackTrace();
  		}
  		System.out.println("프로그램이 정상 종료되었음.");
  	}
  }
  ```

  > 위 식의 결과:
  > 에러메시지:고의로 발생시켰음.
  >
  > java.lang.Exception: 고의로 발생시켰음.
  >
  > ​	at Ex8_6.main(Ex8_6.java:5)
  >
  > 프로그램이 정상 종료되었음.



## 09. checked예외, unchecked예외

* 예제1:

  ```java
  public class Ex8_7 {
  	public static void main(String[] args) {
  		throw new Exception(); // Exception을 고의로 발생시킨다. 
  	}
  }
  ```

  > 위 식의 컴파일 결과:
  > Ex8_7.java:3: unreported exception java.lang.Exception; must be caught or declared to be thrown
  >
  > ​	throw new Exeption();
  >
  > ^
  >
  > 1 error

  - 예외 처리가 되어있지 않다는 에러 발생.
    'Exception 클래스와 그 자손들(checked예외)'이 발생할 가능성이 있는 문장들에 대해 예외 처리를 해주지 않으면 컴파일 조차 되지않음.

* 예제2:

  ```java
  public class Ex8_8 {
  	public static void main(String[] args) {
  		throw new RuntimeException(); // RuntimeException을 고의로 발생시킨다.
  	}
  }
  ```

  > 위 식의 결과: 
  >
  > Exception in thread "main" java.lang.RuntimeException
  >
  > ​	at Ex8_8.main(Ex8_8.java:4)

  * RuntimeException을 발생시키는 코드를 가지고 있고, 이에 대한 예외처리를 하지 않았음에도 성공적으로 컴파일 되었으나, RuntimeException이 발생하여 비 정상적으로 종료.

  * 'RuntimeException클래스와 그 자손(unchecked예외)' 에 해당하는 예외는 프로그래머가 실수로 발생하는 것들이기 때문에 예외처리를 강제하지 않는 것.

  * 만일 RuntimeException 클래스들에 속하는 예외가 발생할 가능성이 있는 코드에도 예외 처리를 해야한다면, 참조 변수와 배열이 사용 되는 모든 곳에 예외 처리를 해줘야 할 것.

    ```java
    try {
      int[] arr = new int [10];
      Ststem.out.println(arr[0]);
    } catch(IndexOutOfBoundsException ie){
      ...
    } catch(NullPointException ne) {
      ...
    }
    ```



## 10. 메서드에 예외 선언하기.

* 선언 방법:

  > void method() throws Exception, Exception2, ... ExceptionN {
  > // 메서드의 내용
  > }
  >
  > * 예외를 발생하는 키워드 throw와 예외를 메서드에 선언할 때 쓰이는 throws를 잘 구분할 것.

* 아래의 코드와 같이 모든 예외의 최고조상인 Exception클래스를 메서드에 선언하면,
  이 메서드는 모든 종류의 예외가 발생할 가능성이 있다는 뜻.

  > void method() throws Exception {
  >
  > // 메서드 내용
  >
  > }

* 예외 선언 시, 이 예외 뿐만 아니라 자손타입의 예외까지도 발생할 수 있다는 점을 주의 할 것.
  오버라이딩 할 때 처럼 단순히 선언된 예외의 개수가 아니라 상속관계까지 고려해야함.

* 예외를 선언함으로써 메서드 선언부를 보았을 때, 이 메서드를 사용하기 위해 어떠한 예외들이 처리 되어져야하는지 쉽게 알 수 있음.



* 예제 1:

  ```java
  public class Ex8_9 {
  	public static void main(String[] args) throws Exception {
  		method1(); // 같은 클래스 내의 static멤버이므로 객체 생성없이 직접 호출 가능.
  	} // main 메서드의 끝 
  	
  	static void method1() throws Exception {
  		method2();
  	} // method1의 끝 
  	
  	static void method2() throws Exception {
  		throw new Exception();
  	} // method2의 끝 
  }
  ```

  > 위 식의 결과:
  >
  > Exception in thread "main" java.lang.Exception
  >
  > ​	at Ex8_9.method2(Ex8_9.java:12)
  >
  > ​	at Ex8_9.method1(Ex8_9.java:8)
  >
  > ​	at Ex8_9.main(Ex8_9.java:4)

  * 위의 실행결과를 보면, 프로그램의 실행 도중 java.lang.Exception이 발생하여 비정상적으로 종료했다는 것과, 
    예외가 발생했을 때 호출 스택 (call stack)의 내용을 알 수 있다.

    > 1. 예외가 발생했을 때 , 모두 3개의 메서드(main, method1, method2)가 호출스택에 있었으며
    > 2. 예외가 발생한 곳은 제일 윗줄에 있는 method2라는 것과
    > 3. main메서드가 method1()을, 그리고 method1()은 method2()를 호출했다는 것을 알 수 있음.

  * 예외가 발생한 메서드에서 예외처리를 하지 않고 자**신을 호출한 메서드에게 예외를 넘겨줄 수는 있지만,**
    **이 것으로 예외가 처리된 것은 아니고 예외를 단순히 전달만 하는것.**
    그렇기 때문에 **어느 한 곳에서는 반드시 try-catch문으로 예외처리를 해주어야함**.

    ```java
    public static void main(String[] args) throws Exception {
      method1(); // 같은 클래스내의 static멤버이므로 객체생성없이 직접 호출가능.
    }
    ```

    * 예외가 선언되어 있으면 Exception과 같은 체크드(checked) 예외를 try-catch문으로 처리하지않아도 컴파일 에러가 발생하지 않음.



* 예제 2: 사용자로부터 파일 이름을 입력받아서 파일을 생성하는 예제.

  ```java
  import java.io.*;
  
  public class Ex8_10 {
  	public static void main (String[] args) {
  		try {
  			File f = createFile(args[0]);
  			System.out.println(f.getName()+"파일이 성공적으로 생성되었습니다.");
  		} catch (Exception e) {
  			System.out.println(e.getMessage()+"다시 입력해 주시기 바랍니다.");
  		}
  	}// main 메서드의 끝 
  	
  	static File createFile(String fileName) throws Exception {
  		if (fileName==null || fileName.equals(""))
  			throw new Exception("파일 이름이 유효하지 않습니다.");
  		File f = new File(fileName); // File클래스의 객체를 만든다.
  		// File객체의 createNewFile메서드를 이용해서 실제 파일을 생성한다.
  		
  		f.createNewFile();
  		return f; // 생성된 객체의 참조를 반환한다.
  	} // creatFile메서드의 끝.
  } // 클래스의 끝 
  ```

  > 위 식의 답변: 
  > c:\jdk1.8\work\ch8>java Ex8_10 test2.txt
  >
  > test2.txt파일이 성공적으로 생성되었습니다.
  >
  > 
  >
  >
  > c:\jdk1.8\work\ch8>java Ex8_10 ""
  >
  > 파일이름이 유효하지 않습니다. 다시 입력해주시길 바랍니다.

  * 예외가 발생했을 때, 예외가 발생한 메서드 내에서 자체적으로 처리해도 되는 경우 메서드 내에 try-catch문을 넣어서 처리하고,
    위 예제처럼 메서드 내에서 자체적 해결이 안되는 경우(파일 이름을 다시 받아와야 하는 경우)에는 예외를 선언해서 호출한 메서드가 처리하도록 해야한다.



## 11. finally블럭

#### finally블럭:

* 예외의 발생여부에 상관없이 실행되어야할 코드를 포함시킬 목적으로 사용됨.

* try-catch문의 끝에 선택적으로 덧붙여 사용할 수 있음.

* try-catch-finally순서로 구성 됨.

  ```java
  try {
    //예외가 발생할 가능성이 있는 문장들을 넣는다.
  } catch (Exception1 e1) {
    //예외처리를 위한 문장을 적는다.
  } finally {
    //예외의 발생여부에 관계없이 항상 수행되어야하는 문장들을 넣는다.
    //finally블럭은 try-catch문의 맨 마지막에 위치해야함.
  }
  ```

  * 예외가 발생한 경우, 'try ➡️ catch ➡️ finally'의 순으로 실행.
    예외가 발생하지 않은 경우 'try ➡️ finally'의 순으로 실행 됨.

* 아래와 같이 프로그램을 설치하는 코드가 있을 때, 설치를 정상적으로 마쳐도 임시파일을 삭제해야하고 중간에 예외가 발생해도 임시파일을 삭제해야함.

  ```java
  try {
    startInstall(); //프로그램 설치에 필요한 준비를 한다.
    copyFiles();	  //파일들을 복사한다.
    deleteTempFiles(); // 프로그램 설치에 사용된 임시파일들을 삭제한다.
  }catch (Exception e){
    e.printStackTrace();
    deleteTempFiles(); // 프로그램 설치에 사용된 임시파일들을 삭제한다.
  } // try-catch의 끝
  ```

  * 이럴 땐 try블럭과 catch블럭에 같은 코드를 넣기보다는, 아래와 같이 finally블럭에 넣는 것이 낫다.

    ```java
    try {
      startInstall(); //프로그램 설치에 필요한 준비를 한다.
      copyFiles();		//파일들을 복사한다.
    } catch (Exception e){
      e.printStackTrace();
    }finally {
      deleteTempFiles(); // 프로그램 설치에 사용된 임시파일들을 삭제한다.
    }// try-catch의 끝
    ```



## 12. 사용자 정의 예외 만들기

* 기존의 정의된 예외 클래스 외에 필요에 따라 프로그래머가 새로운 예외 클래스를 정의하여 사용할 수 있다.

* 보통 Exception클래스 또는 RuntimeException클래스로부터 상속받는 클래스를 만들지만, 필요에 따라서 알맞은 예외 클래스를 선택할 수 있다.

  ```java
  class MyException extends Exception {
    MyException(String msg) { // 문자열을 매개변수로 받는 생성자
      super(msg);							// 조상인 Exception클래스의 생성자를 호출한다.
    }
  }
  ```

  * Exception클래스로부터 상속받아서 MyException클래스를 만들었다. 필요하다면 멤버변수나 메서드를 추가할 수 있다.

  * Exception클래스는 생성 시에 String값을 받아서 메시지로 저장할 수 있다.

    (사용자정의 예외 클래스에 메세지를 저장할 수 있으려면, 위처럼 String을 매개변수로 받는 생성자를 추가해야한다.)

    ```java
    class MyException extends Exception {
      //에러 코드 값을 저장하기 위한 필드를 추가했다.
      private final int ERR_CODE; // 생성자를 통해 초기화 한다.
      
      MyExceotion(String msg, int errCode) { //생성자
      	super(msg);
        ERR_CODE = errCode;
      }
      
      MyException(String msg) {// 생성자
        this(msg,100); 				 // ERR_CODE를 100(기본값)으로 초기화한다.
      }
      
      public int getErrCode() { // 에러 코드를 얻을 수 있는 메서드도 추가했다.
        return ERR_CODE;				// 이 메서드는 주로 getMessage()와 함께 사용될 것이다.
      }
    }
    ```

    * 이전의 코드를 개선하여 메시지 뿐만 아니라 에러코드 값도 저장할 수 있도록 ERR_CODE와 getErrCode()를 MyException클래스의 멤버로 추가함.
    * 추후 MyException이 발생했을 때, catch블럭에서 getMassage()와 getErrCode()를 사용해 에러코드와 메시지를 모두 얻을 수 있을 것이다.
    * 기존에는 Exception을 상속받아 'checked예외'로 작성하는 경우가 많았지만, 예외처리를 선택적으로 하는 RuntimeException을 상속받아 작성하는것으로 바뀌어 가고 있음. (전자의 경우, 불필요한 경우에도 try-catch문을 넣어 코드가 복잡해짐.)

---



* 예제: 설치 프로그램을 코드로 풀어 쓴 것.
  MemotyException과 SpaceException. 두 개의 사용자정의 예외 클래스를 새로만들어 사용 한 것.
  두 예외는 startInstall()을 수행하는 동안 발생할 수 있으며, enoughSpace()와 enoughMemory()의 실행결과에 따라 발생하는 예외의 종류가 달라지게 설정.

  ```java
  
  public class Ex8_11 {
  	public static void main(String[] args) {
  		try {
  			startInstall();				// 프로그램 설치에 필요한 준비를 한다.
  			copyFiles();					// 파일들을 복사한다.
  		}catch (SpaceException e) {
  			System.out.println("에러 메시지 : "+e.getMessage());
  			e.printStackTrace();
  			System.out.println("공간을 확보한 후에 다시 설치하시기 바랍니다.");
  		} catch (MemoryException me) {
  			System.out.println("에러메시지 : "+me.getMessage());
  			me.printStackTrace();
  			System.gc();				 	// Garbage Collection을 수행하여 메모리를 늘려준다.
  			System.out.println("다시 설치를 시도하세요.");
  		} finally {
  			deleteTempFiles();		// 프로그램 설치에 사용된 임시파일들을 삭제한다.
  		} // try의 끝
  	}   // main의 끝
  	
  	static void startInstall() throws SpaceException, MemoryException {
  		if(!enoughSpace())			// 충분한 설치 공간이 없으면
  			throw new SpaceException("설치할 공간이 부족합니다.");
  		if(!enoughMemory())			// 충분한 메모리가 없으면..
  			throw new MemoryException("메모리가 부족합니다.");
  	} // startInstall메서드의 끝
  	
  	static void copyFiles() {/* 파일들을 복사하는 코드를 적는다 */}
  	static void deleteTempFiles() {/* 임시파일들을 삭제하는 코드를 적는다 */ }
  	
  	static boolean enoughSpace() {
      // 설치하는데 필요한 공간이 있는지 확인하는 코드를 적는다.
  		return false;
  	}
  	
  	static boolean enoughMemory() {
      // 설치하는데 필요한 메모리공간이 있는지 확인하는 코드를 적는다.
  		return true;
  	}
  }// ExceptionTest클래스의 끝.
  
  class SpaceException extends Exception {
  	SpaceException(String msg) {
  		super(msg);
  	}
  }
  
  class MemoryException extends Exception {
  	MemoryException(String msg) {
  		super(msg);
  	}
  }
  ```

  > 위 식의 결과: 
  >
  > 에러 메시지 : 설치할 공간이 부족합니다.
  >
  > SpaceException: 설치할 공간이 부족합니다.
  >
  > ​	at Ex8_11.startInstall(Ex8_11.java:23)
  >
  > ​	at Ex8_11.main(Ex8_11.java:5)
  >
  > 공간을 확보한 후에 다시 설치하시기 바랍니다.



## 13.예외 되던지기(exception re-throwing)

* 예외를 처리한 후 인위적으로 다시 발생시키는 방법을 통해, 하나의 예외에 대해서 예외가 발생한 메서드와 호출한 메서드, 양 쪽에서 처리하도록 하는 것.
* 예외가 발생할 가능성이 있는 메서드에서 try-catch문을 사용해서 예외를 처리해주고, catch문에서 필요한 작업을 행한 후, throw문을 사용해서 예외를 다시 발생시킨다.
  다시 발생한 예외는 이 메서드를 호출한 메서드에게 전달되고, 호출한 메서드 try-catch문에서 예외를 또다시 처리함.
* 하나의 예외에 대해서 예외가 발생한 메서드와 이를 호출한 메서드 양쪽 모두에서 처리해줘야할 작업이 있을 때 사용.
* **주의할 점:** 예외가 발생할 메서드에서 try-catch문을 사용해서 예외처리를 해줌과 동시에 메서드의 선언부에 발생할 예외를 throws에 지정해줘야함.



* 예제:

  ```java
  public class Ex8_12 {
  	public static void main(String[] args) {
  		try {
  			method1();
  		} catch (Exception e) {
  			System.out.println("main메서드에서 예외가 처리되었습니다.");
  		}
  	} // main 메서드의 끝 
  	
  	static void method1() throws Exception {
  		try {
  			throw new Exception();
  		} catch ( Exception e ) {
  			System.out.println("method1메서드에서 예외가 처리되었습니다.");
  			throw e; 	// 다시 예외를 발생시킨다.
  		}
  	} // method1메서드의 끝  
  }
  ```

  > 위 식의 결과:
  >
  > method1메서드에서 예외가 처리되었습니다.
  >
  > main메서드에서 예외가 처리되었습니다.

  * return문의 경우, catch블럭에도 return문이 있어야 한다.
    예외가 발생했을 경우에도 값을 반환해야하기 때문.

    ```java
    static int method1() {
      try {
        System.out.println("method1()이 호출되었습니다.")
          return 0;
      } catch (Exception e) {
        e.printStackTrace();
        return 1;
      } finally {
        System.out.println("method1()의 finally블럭이 실행되었습니다.")
      }
    }// method1메서드의 끝
    ```



## 14. 연결된 예외(chained exception)

* 한 예외가 다른 예외를 발생시킬 수 있다. 
  ex) 예외 A가 예외B를 발생시켰다면, A를 B의 '원인 예외(cause exception)'라고 한다.

* 예제 8_11의 일부를 변경한 것으로, SpaceException을 원인 예외로 하는 InstallException을 발생시키는 방법을 보여주는 코드:

  ```java
  try {
    startInstall(); // SpaceException 발생
    coptFiles();
  }catch (SpaceException e) {
    InstallException ie = new InstallException("설치중 예외 발생"); // 예외 생성
    ie.initCause(e); // InstallException의 원인 예외를 SpaceException으로 지정
    throw is;				 // InstallException을 발생시킨다.
  } catch(MemoryException me) {
    ...
  }
  ```

  1. 먼저 InstallException을 생성함.
  2. initCause()로 SpaceException을 InstallException의 원인 예외로 등록한다.
  3. 'throw'로 이 예외를 던진다.

  initCause()는 Exception클래스의 조상인 Throwable클래스에 정의되어 있기 때문에 모든 예외에서 사용가능 하다.

  > Throwable initCause(Throwable cause) 	지정한 예외를 원인 예외로 등록
  >
  > Throwavle getCause() 								   원인 예외를 반환

  * 발생한 예외를 원인 예외로 등록해서 다시 예외를 발생시키는 이유는,
    여러가지 예외를 하나의 큰 분류의 예외로 묶어서 다루기 위해.

  * 그렇다고 InstallException을 SpaceException과 MemoryException의 조상으로 해서 catch블럭을 작성하면,
    발생된 예외가 어떤 것인지 알 수 없다는 문제가 생김.
    +) SpaceException과 MemoryException의 상속관계를 변경해야하는 것도 부담.

    ```java
    try {
      startInstall(); // SpaceException 발생
      coptFiles();
    }catch (InstallException e) { //InstallException은
      e.printStackTrace();				//SpaceException과 MemoryException의 조상
    }
    ```

    * 그래서 예외가 원인 예외를 포함할 수 있게 한 것.
      이렇게 하면 두 예외는 상속관계가 아니어도 상관없다.

      ```java
      public class Throwable implements Serializable {
        ...
        private Throwble cause = this; // 객체 자신(this)를 원인 예외로 등록.
        ...
      }
      ```

  * 또 다른 이유는, checked예외를 unchecked예외로 바꿀 수 있도록 하기 위해서.

  * checked예외로 예외처리를 강제한 이유는 프로그래밍 경험이 적은 사람도 보다 견고한 프로그램을 작성할 수록 유도한 것이나,
    checked예외를 uncheck예외로 바꾸면 예외처리가 선택적이 되므로 억지로 예외처리를 하지 않아도 됨.

    * 변경 전:

    ```java
    static void startInstall() throws SpaceException, MemoryException {
      if(!enoughSpace())				// 충분한 설치 공간이 없으면...
        throw new SpaceException("설치할 공간이 부족합니다.");
      
      if(!enoughMemory())				// 충분한 메모리가 없으면...
        throw new MemoryException("메모리가 부족합니다.");
    }
    ```

    * 변경 후:

    ```java
    static void startInstall() throws SpaceException {
      if(!enoughSpace())				// 충분한 설치 공간이 없으면...
        throw new SpaceException("설치할 공간이 부족합니다.");
      
      if(!enoughMemory())				// 충분한 메모리가 없으면...
        throw new RuntimeException(new MemoryException("메모리가 부족합니다.");
    } // startInstall메서드의 끝
                                 
    ```

  * MemoryException은 Exception의 자손이므로 반드시 예외를 처리해야하는데, 이 예외를 RuntimeException으로 감싸버렸기 때문에
    unchecked 예외가 됨.

  * 그렇기 때문에 더이상 startInstall()의 선언부에 MemoryException을 선언하지 않아도 됨.

    > RuntimeException(Throwable cause) : 원인 예외를 등록하는 생성자



* 예제:

  ```java
  
  public class Ex8_13 {
  	public static void main(String[] args) {
  		try {
  			install();
  		} catch(InstallException e) {
  			e.printStackTrace();
  		} catch(Exception e) {
  			e.printStackTrace();
  		}
  } // main의 끝 
  
  static void install() throws InstallException {
  	try {
  		startInstall();   // 프로그램 설치에 필요한 준비를 한다.
  		copyFiles();	  // 파일들을 복사한다.
  	} catch (SpaceException2 e) {
  		InstallException ie = new InstallException("설치 중 예외발생");
  		ie.initCause(e);
  		throw ie;
  	} catch (MemoryException2 me) {
  		InstallException ie = new InstallException("설치 중 예외발생");
  		ie.initCause(me);
  		throw ie;
  	} finally {
  		deleteTempFiles(); // 프로그램 설치에 사용된 임시파일들을 삭제한다.
  	} // try의 끝 
  }
  
  static void startInstall() throws SpaceException2, MemoryException2 {
  	if(!enoughSpace()) {		 // 충분한 설치 공간이 없으면...
  		throw new SpaceException2("설치할 공간이 부족합니다.");
  	}
  	
  	if (!enoughMemory()) {
  		throw new MemoryException2("메모리가 부족합니다.");
  		//throw new RuntimeException(new MemoryException("메모리가 부족합니다."));
  	}
  } // startInstall 메서드의 끝 
  
  static void copyFiles() {/* 파일들을 복사하는 코드를 적는다. */}
  static void deleteTempFiles() {/* 임시파일들을 삭제하는 코드를 적는다.*/}
  
  static boolean enoughSpace() {
  	// 설치하는데 필요한 공간이 있는지 확인하는 코드를 적는다.
  	return false;
  }
  static boolean enoughMemory() {
  	//설치하는데 필요한 메모리공간이 있는지 확인하는 코드를 적는다.
  	return true;
  	}
  } // ExceptionTest클래스의 끝 
  
  class InstallException extends Exception {
  	InstallException(String msg) {
  		super(msg);
  	}
  }
  
  class SpaceException2 extends Exception {
  	SpaceException2(String msg) {
  		super(msg);
  	}
  }
  
  class MemoryException2 extends Exception {
  	MemoryException2(String msg) {
  		super (msg);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > InstallException: 설치 중 예외발생
  >
  > ​	at Ex8_13.install(Ex8_13.java:18)
  >
  > ​	at Ex8_13.main(Ex8_13.java:5)
  >
  > Caused by: SpaceException2: 설치할 공간이 부족합니다.
  >
  > ​	at Ex8_13.startInstall(Ex8_13.java:32)
  >
  > ​	at Ex8_13.install(Ex8_13.java:15)
  >
  > ​	... 1 more