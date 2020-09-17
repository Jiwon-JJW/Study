## Chapter 08. 연습문제

**[8-1] 예외처리의 정의와 목적에 대해서 설명하시오**

* 정의: 프로그램 실행 시 예기치 못한 예외가 발생하는 것에 대비하여 코드를 작성하는 것.
* 목적: 프로그램의 비정상적 종료를 막고, 정상 실행을 유지할 수 있도록 하는 것.



**[8-2] 다음은 실행도중 예외가 발생하여 화면에 출력된 내용이다. 이에 대한 설명 중 옳지 않은 것은?**

```java
java.lang.ArithmeticException : / by zero
  at ExceptionEx18.mathod2(ExceptionEx18.java:12)
  at ExceptionEx18.mathod1(ExceptionEx18.java:8)
  at ExceptionEx18.main(ExceptionEx18.java:4)
```

a. 위의 내용으로 예외가 발생했을 당시 호출스택에 존재했던 메서드를 알 수 있다.

b. 예외가 발생한 위치는 method2 메서드이며, ExceptionEx18.java파일의 12번째 줄이다.

c. 발생한 예외는 ArithmeticException이며, 0으로 나누어서 예외가 발생했다.

**d. method2메서드가 method1메서드를 호출하였고 그 위치는 ExceptionEx18.java파일의 8번째 줄이다.**



**[8-3] 다음 중 오버라이딩이 잘못된 것은? (모두 고르시오)**

```java
void add(int a, int b)
  throws InvalidNumberException, NotANumberException {}

class NumberException extends Exception {}
class InvalidNumberException extends NumberException {}
class NotANumberException extends NumberException {}
```

a. void add(int a, int b) throws InvalidNumberException, NotANumberException {}

**b. void add(int a, int b) throws InvalidNumberException {}**

**c. void add(int a, int b) throws NotANumberException {}**

d. void add(int a, int b) throws Exception {}

**e. void add(int a, int b) throws NumberException {}**



**[8-4] 아래의 코드가 수행되었을 때의 실행결과를 적으시오**.

```java
public class Exercise8_4 {
  static void method(boolean b) {
	  try {
		  System.out.println(1); // 무조건 출력
		  if (b) throw new ArithmeticException(); // 정수를 0으로 나누려 한 예외 발생
		  System.out.println(2); 									// 출력 되지 않음
	  } catch (RuntimeException r) {						// 프로그래머가 실수한 모든 예외한 것에 대한 예외 처리문
		  System.out.println(3);									// 예외 처리로 호출
		  return;
	  } catch (Exception e) {										// 외적인 요인에서 예외 처리문
		  System.out.println(4);									// 출력되지 않음
		  return;
	  } finally {
		  System.out.println(5);					        // 무조건 처리		
	  }
	  
	  System.out.println(6);
  }
  
  public static void main (String[] args) {
	  method(true);
	  method(false);
  }
}
```

* 위 식의 결과:
  1
  3
  5
  1
  2
  4

  5
  6

  



**[8-5] 아래의 코드가 수행되었을 때의 실행결과를 적으시오.**

```java
public class Exercise8_5 {
	public static void main(String[] args) {
		try {
			method1(); // 메소드 1 예외 발생.
		} catch (Exception e) {
			System.out.println(5); // 처리 완료. 호출 됨.
		}
	}
	
	static void method1() {
		try {
			method2(); // 예외가 발생됨
			System.out.println(1); // 출력되지 않음
		} catch (ArithmeticException e) { // 예외 처리 실패. (해당 사항은 정수를 0으로 나누려 한 예외 처리문)
			System.out.println(2);
		} finally {									// 무조건 출력
			System.out.println(3);
		}
		
		System.out.println(4);  // 예외 해결 X이므로 출력되지 않음.
	} //method1()
	
	static void method2() {
		throw new NullPointerException(); // 값이 null인 참조변수 호출 예외 발생.
	}
}
```

* 위 식의 결과:
  3
  5





**[8-6] 아래의 코드가 수행되었을 때의 실행결과를 적으시오.**

```java
public class Exercise8_6 {
	static void method(boolean b) {
		try {
			System.out.println(1);		// 출력 됨
			if (b) System.exit(0);		// 자바의 정상적인 종료
			System.out.println(2);		// 출력되지 않음
		} catch (RuntimeException r) { // 프로그래머 실수(내적인 요인) 
			System.out.println(3);		// 출력되지 않음
			return;
		} catch (Exception e) {			// 프로그램 외적인 이유의 예외
			System.out.println(4);		// 출력 됨
			return;
		} finally {
			System.out.println(5);		// 무조건 처리
		}
		
		System.out.println(6);
	}
	
	public static void main(String[] args) {
		method(true);
		method(false);
	}
}
```

* 위 식의 결과:
  1
  4
  5
  2
  3
  5
  6





**[8-7] 다음은 1~100사이의 숫자를 맞추는 게임을 실행하던 도중에 숫자가 아닌 영문자를 넣어서 발생한 예외이다. 예외처리를 해서 숫자가 아닌 값을 입력했을 때는 다시 입력을 받도록 보완하라.**

> ```java
> 1과 100사이의 값을 입력하세요 :50
> 더 작은 수를 입력하세요.
> 1과 100사이의 값을 입력하세요 :asdf
> Exception in thread "main" java.util.InputMismatchException
>   at java.utill.Scanner.throwFor(Scanner.java:819)
>   at java.utill.Scanner.next(Scanner.java:1431)
>   at java.utill.Scanner.nextInt(Scanner.java:2040)
>   at java.utill.Scanner.nextInt(Scanner.java:2000)
>   at Exercise8_8.main(Exercise8_8.java:16)
> ```

```java
import java.util.*;

public class Exercise8_7 {
	public static void main(String[] args) {
		// 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0; // 사용자입력을 저장할 공간 
		int count = 0; // 시도횟수를 세기 위한 변수 
		
		do {
			count++;
			System.out.println("1과 100사이의 값을 입력하세요 :");
			
			//input = new Scanner(System.in).nextInt();
      try {
				input = new Scanner(System.in).nextInt();
				} catch(Exception e) {
					System.out.println("숫자를 입력해 주세요.");
					continue;
				}
			
			if(answer > input) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if(answer < input) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println("맞췄습니다.");
				System.out.println("시도횟수는 " + count + "번입니다.");
				break; // do-while문을 벗어난다 
			}
		} while (true); // 무한 반복문 
	} // end of main
} // end of class HighLow 

* 결과:
1과 100사이의 값을 입력하세요 :
 50
더 큰 수를 입력하세요.
1과 100사이의 값을 입력하세요 :
80
더 작은 수를 입력하세요.
1과 100사이의 값을 입력하세요 :
77
더 큰 수를 입력하세요.
1과 100사이의 값을 입력하세요 :
78
맞췄습니다.
시도횟수는 4번입니다.
```

* 답:

  ```java
  try {
  				input = new Scanner(System.in).nextInt();
  				} catch(Exception e) {
  					System.out.println("숫자를 입력해 주세요.");
  					continue;
  				}
  ```

  





**[8-8] 아래의 코드가 수행되었을 때의 실행결과를 적으시오.**

```java
public class Exercise8_8 {
	public static void main(String[] args) {
		try {
			method1();											// 예외 해결 된 메소드 호출
			System.out.println(6);					// 출력 됨
		} catch (Exception e) {						
			System.out.println(7);
		}
	}
	
	static void method1() throws Exception {
		try {
			method2();
			System.out.println(1);					 // 출력되지 않음
		} catch (NullPointerException e) { // 결과가 null인 참조변수 호출 예외 처리
			System.out.println(2);					 // 출력 됨
			throw e;
		} catch (Exception e) {							// 출력 X
			System.out.println(3);						// 출력 X
		} finally {
			System.out.println(4);						// 출력 됨
		}
		
		System.out.println(5);							// 출력 됨
	} // method1()
	
	static void method2() {
		throw new NullPointerException(); // 결과가 Null인 참조변수 호출 예외 발생 
	}
}
```

* 위 식의 결과:
  2
  4

  5
  5







