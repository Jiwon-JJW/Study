# CHAPTER 04

> 지금까지는, 코드의 실행 흐름이 무조건 위에서 아래로 한 문장씩 순차적으로 진행 되었지만,
> 때로는  조건에 따라 문장을 건너 뛰거나, 같은 문장을 반복해서 수행해야 할 때가 있다.

* 프로그램의 흐름 (flow)을 바꾸는 역할을 하는 문장들을

  #### '제어문(control statement)' 이라고한다.

  * 제어문의 종류
    1. 조건문: 조건에 따라 다른 문장이 수행
    2. 반복문: 조건에 따라 특정 문장들을 반복해서 수행


---

#### 조건문

---

## 01. if문

* if문은 가장 기본적인 조건문.

* '조건식'과 '괄호{}'로 이루어져 있음.

* **'만일(if) 조건식이 참(true)이면 괄호{}안의 문장들을 수행하라.'** 라는 의미.

  > if (조건식) {
  >
  > ​               **//조건식이 참(true)일 때 수행될 문장들을 적는다.
  >
  > }

* 예제:

  ```java
  class Ex4_1 {
  	public static void main(String[] args) {
  		int score = 80;
  		
  		if (score > 60) {                  // 점수가 60점 이상일 때
  			System.out.println("합격입니다.");  // 합격입니다. 라는 문장이 출력된다.
  		}
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 합격입니다.
  >
  > * if문의 조건식이 평가되는 과정:
  >   Score > 60
  >   -> 80 > 60
  >   -> true



## 02. 조건식의 다양한 예

* if문에 사용 되는 조건식은 **비교 연산자** 와 **논리 연산자** 로 구성됨.

  |               조건식                |                 조건식이 참일 조건                 |
  | :---------------------------------: | :------------------------------------------------: |
  |         90 <= x && x <= 100         |           정수 x가 90이상 100 이하일 때            |
  |         x < 0 \|\| x > 100          |        정수 x가 0보다 작거나 100보다 클 때         |
  |          x%3==0 && x%2!=0           |     정수 x가 3의 배수지만, 2의 배수는 아닐 때      |
  |        ch=='y' \|\| ch=='Y'         |            문자 ch가 'y'이거나 'Y'일 때            |
  | ch==' ' \|\| ch=='\t' \|\| ch=='\n' |    문자 ch가 공백이거나 탭 또는 개행 문자일 때     |
  |       'A' <= ch && ch <= 'Z'        |               문자 ch가 대문자일 때                |
  |        'a' <=ch && ch <= 'z'        |               문자 ch가 소문자일 때                |
  |          str.equals("yes")          |   문자열 str의 내용이 "yes"일 때(대소문자 구분)    |
  |     str.equalsIgnoreCase("yes")     | 문자열 str의 내용이 "yes"일 때(대소문자 구분 안함) |

* **자바에서 조건식의 결과는 반드시 true 또는 false 이어야 한다는 것을 잊지말자.**

* 예제:

  ```java
  class Ex4_2 {
  	public static void main(String[] args) {
  		int x = 0;
  		System.out.printf("x=%d일 때,참인 것은%n", x);
  		
  		if(x==0) System.out.println("x==0");
  		if(x!=0) System.out.println("x!=0");
  		if(!(x==0)) System.out.println("!(x==0)");
  		if(!(x!=0)) System.out.println("!(x!=0)");
  		
  		x = 1;
  		System.out.printf("x=%d 일 때, 참인것은%n", x);
  		
  		if(x==0) System.out.println("x==0");
  		if(x!=0) System.out.println("x!=0");
  		if(!(x==0)) System.out.println("!(x==0)");
  		if(!(x!=0)) System.out.println("!(x!=0)");
  	}
  }
  ```

  > 위 식의 값:x=0일 때,참인 것은
  >
  > x==0
  >
  > !(x!=0)
  
  
  
  > x=1 일 때, 참인것은
  >
  > x!=0
  >
  > !(x==0)



## 03. 블럭 {}

#### 블럭이란?

* 괄호{}를 이용해서 여러 문장을 하나의 단위로 묶는 것.
* 블럭은 '{' 로 시작해서 '}' 로 끝나는데, '}' 다음에 문장의 끝을 의미하는 ';'를 입력하지 않도록 주의.
* 블럭내의 문장들은 탭(tab)으로 들여쓰기(indentation)를 해서 블럭 안에 속한 문장이라는 것을 알기 쉽게 해주는 것이 좋다.



#### 블럭 사용의 예.

1. 가장 자주 사용함. 라인의 수가 짧아지는 장점이 있다.

   > if(조건식) { 
   >
   > ​			...
   > }

2. 블럭의 시작과 끝을 찾기 쉽다는 장점이 있다.

   > if (조건식)
   > {
   > 			...
   > }

3. 블럭 내의 문장이 하나뿐 일 때는, 괄호{}를 생략 할 수 있다.

   > If(score > 60)
   > 	System.out.println("합격입니다.");

4. 괄호{}를 생략하고 한 줄로 쓸 수도 있다.

   > if(score > 60) System.out.println("합격입니다.");

* 괄호{}를 생략 할 수도 있지만, 가능하면 생략하지 않고 사용하는 것이 바람직 하다.
  추후 문장이 추가되었을 때, 괄호{}를 빼먹을 수 있기 때문.



## 04. if-else문

* if문의 변형. if문에 'else블럭'이 더 추가 되었음.

  > if(조건식) {
  >
  > ​		// 조건식이 참(true)일 때 수행될 문장들을 적는다.
  >
  > }else {
  >
  > ​		// 조건식이 거짓(false)일 때 수행될 문장들을 적는다.
  >
  > }

* 조건식의 결과에 따라 이 두 개의 블럭{} 중 어느 한 블럭{}의 내용이 수행되고, 전체 if문을 벗어나게 됨.
  **두 블럭{}의 내용이 모두 수행되거나, 모두 수행되지 않는 경우는 있을 수 없다.**

* 두 개의 if문을 if-else문으로 바꾸면 다음과 같다.

  > if문
  > if(input==0) {
  >
  > ​	System.out.println("0입니다.");
  >
  > }
  > if(input!=0) {
  >
  > ​	System.out.println("0이 아닙니다.");
  >
  > }

  

  > if-else문으로 수정
  > if(input==0) {
  >
  > ​	System.out.println("0입니다.");
  >
  > } else {
  >
  > ​	System.out.println("0이 아닙니다.");
  >
  > }

  위와 같은 한 쪽이 참이고 한 쪽은 거짓인 if문의 경우, if-else문으로 사용하는 것이 하나의 조건식만 계산하면 되므로 더 효율적이고 간단하다.

* 예제:

  ```java
  import java.util.Scanner; // Scanner클래스를 사용하기 위해 추가.
  
  class Ex4_3 {
  	public static void main(String[] args) {
  		System.out.print(5);
  		Scanner scanner = new Scanner(System.in); 
  		int input=scanner.nextInt(); // 화면을 통해 입력받은 숫자를 input에 저장. 숫자는 console에 입력하면된다.
  		
  		if(input == 0) {
  			System.out.println("입력하신 숫자는 0입니다.");
  		} else { //input!=0인 경우.
  			System.out.println("입력하신 숫자는 0이 아닙니다.");
  		} scanner.close();
  	} //main의 끝. 
  }
  ```

  > 위 식의 값:
  > 숫자를 5로 입력했을 경우, : 입력하신 숫자는 0이 아닙니다.
  >
  > 숫자를 0으로 입력했을 경우: 입력하신 숫자는 0입니다.



## 05. if-else if문

* if-else문은 두 가지 경우 중 하나가 수행되는 구조이나, 처리해야하는 경우의 수가 셋 이상일 때 쓰는 문.

  ```java
  if (조건식 1) {
    	// 조건식 1의 연산결과가 참일 때 수행될 문장들을 적는다.
  } else if (조건식2) {
    	// 조건식 2의 연산결과가 참일 때 수행될 문장들을 적는다.
  }	else if (조건식3) {		// 여러 개의 else if를 사용할 수 있다.
    	// 조건식 3의 연산결과가 참일 때 수행될 문장들을 적는다.
  } else {		// 마지막은 보통 else블럭으로 끝나며, else블럭은 생략 가능하다.
    	// 위의 어느 조건식도 만족하지 않을 때 수행될 문장들을 적는다.
  }
  ```

  * else블럭은 생략이 가능한데, else블럭이 생략되었을 때는 if-else if문의 어떤 블럭도 수행되지 않을 수 있다.

* 예제:

  ```java
  import java.util.Scanner; // Scanner클래스를 사용하기 위해 추가.
  
  class Ex4_4 {
  	public static void main(String[] args) {
  		int score= 0;		// 점수를 저장하기 위한 변수
  		char grade= ' '; // 학점을 저장하기 위한 변수, 공백으로 초기화 한다.
  		
  		System.out.print("점수를 입력하세요. >");
  		Scanner scanner = new Scanner(System.in);
  		score= scanner.nextInt(); // 화면을 통해 입력받은 숫자를 score에 저장
  		
  		if(score >=90) {				// score가 90점보다 같거나 크면 A학점
  			grade = 'A';
  		} else if (score >=80) { // score가 80점보다 같거나 크면 B학점
  			grade = 'B';
  		} else if (score >=70) { // score가 70점보다 같거나 크면 C학점
  			grade = 'C';
  		} else if (score >=60) { // score가 60점보다 같거나 크면 D학점
  			grade = 'D';
  		} else {                 // 나머지는 F학점
  			grade = 'F';
  		}
  		System.out.println("당신의 학점은"+grade+"입니다.");
  	}
  }
  ```

  > 위 식의 결과:
  > 점수를 입력하세요. >20
  >
  > 당신의 학점은F입니다.

  

  > 점수를 입력하세요. >90
  >
  > 당신의 학점은A입니다.

  * 본래, 점수가 90점 미만이고 80점 이상인 사람에게 'B'학점을 주는 조건이라면,  조건식이
    '80 <= score && score < 90' 이 되어야 하지만,
    첫 번째 조건식인 'score >= 90' 이 거짓이기 때문에, 'score < 90'이 참이라는 뜻으로, 중복되어 확인 될 필요가 없기 때문에
    'score >=80'만 사용해도 되는 것.



## 06. 중첩 if문

* if문의 블럭 내에 또 다른 if문을 포함시키는것이 가능한 문.
  중첩의 횟수에는 거의 제한이 없음.

  ```java
  if (조건식1) {
    	// 조건식 1의 연산 결과가 true일 때 수행될 문장들을 적는다.
    if(조건식2) {
       // 조건식1과 조건식2가 모두 true일 때 수행되는 문장들
    } else {
       // 조건식 1이 true이고, 조건식2가 false일 때 수행되는 문장들
    }
  } else {
    //조건식 1일 false일 때 수행되는 문장들
  }
  ```

  * 위와 같이, 내부의 if문은 외부의 if문보다 안쪽으로 들여쓰기를 해서 **두 if문의 범위가 명확히 구분될 수 있도록 작성**해야함.
  * if문에서 괄호{}의 생략에 더욱 조심해야함. **바깥쪽의 if문과 안쪽의 if문이 서로 엉켜서 if문과 else블럭의 관계가 의도한 바와 다르게 형성 될 수 있기 때문.**

* 예제:

  ```java
  import java.util.Scanner; // Scanner클래스를 사용하기 위해 추가.
  
  class Ex4_5 {
  	public static void main(String[] args) {
  		int score =0;
  		char grade = ' ', opt = '0';
  		
  		System.out.print("점수를 입력해주세요.>");
  		
  		Scanner scanner=new Scanner(System.in);
  		score = scanner.nextInt(); // 화면을 통해 입력받은 점수를 score에 저장. console에 입력하면 됨.
  		
  		System.out.printf("당신의 점수는 %d입니다.%n", score);
  		
  		if (score >= 90) {  //score가 90점 보다 같거나 크면 A학점(grade)
  			grade = 'A';
  			if (score >= 98) { //90점 이상 중에서도 98점 이상은 A+
  				opt = '+';
  			} else if (score <94) { //90점 이상 중에서도 94점 미만은 A-
  				opt = '-';
  			}
  		} else if (score >=80) { // score가 80점 보다 같거나 크면 B학점(grade)
  			grade ='B';
  			if (score >=88) {
  				opt='+';
  			} else if (score < 84) {
  				opt='-';
  			}
  		} else {    //나머지는 C학점 (grade)
  			grade = 'C';
  		}
  		System.out.printf("당신의 학점은 %c%c입니다.%n", grade, opt);
  	}
  }
  ```

  > 위 식의 결과:
  > 점수를 입력해주세요.>80
  >
  > 당신의 점수는 80입니다.
  >
  > 당신의 학점은 B-입니다.

  

  > 점수를 입력해주세요.>85
  >
  > 당신의 점수는 85입니다.
  >
  > 당신의 학점은 B0입니다.

  * 총 3개의 if문과 if문 안의 또 다른 2개의 if문을 포함하고있는 식.
    **외부 if문의 조건식에 의해 한번 걸러졌기 때문에 내부 if문의 조건식은 더 간단해 질 수 있다.**



## 07. switch문

* if문은 조건식의 결과 참과 거짓 두 가지 밖에 없기 때문에, 경우의 수가 많아질 수록 조건식이 복잡해지므로, 3개의 조건이 넘어가면 if문보다는 switch를 사용하는 것이 좋다.

* switch문은 **단 하나의 조건식으로 많은 경우의 수를 처리할 수 있고, 표현도 간결**하므로 알아보기 쉽다.

* switch문의 처리방식:

  1. 조건식을 계산한다.
  2. 조건식의 결과와 일치하는 case문으로 이동한다.
  3. 이후의 문장들을 수행한다.
  4. break문이나 switch문의 끝을 만나면 switch문 전체를 빠져나간다.


  ```java
  switch(조건식) {
    case 값1 :
      // 조건식의 결과가 값1과 같을 경우 수행될 문장들
      // ...
      break;
    case 값2 :
      // 조건식의 결과가 값2와 같을 경우 수행될 문장들
      // ...
      break;
    // ...
    default :
      //조건식의 결과와 일치하는 case문이 없을 때 수행될 문장들
      // ...
  }
  ```

  * 조건식의 결과와 일치하는 case문이 하나도 없는 경우, default문으로 이동.
  * default문은 if문의 else블럭과 같은 역할을 함.
  * default문의 위치는 어디라도 상관 없으나, 보통 마지막에 놓기 때문에 break문을 쓰지 않아도 됨.

* switch문에서 break문은 각 case문의 영역을 구분하는 역할을 함.
  **만일 break문을 생략하면 case문 사이의 구분이 없어지므로, 다른 break문을 만나거나 switch문 블럭{}의 끝을 만날 때 까지 나오는 모든 문장을 수행하므로,** 
  case문의 마지막에 break문을 생략하지 않도록 주의.



#### - switch문의 제약조건

1. switch문의 조건식은 결과값이 반드시 **정수** 또는 문자열이어야 한다.
2. case문의 값은 반드시 **정수, 상수(문자 포함), 문자열**만 가능하며, 중복되지 않아야 한다.


```java
public static void main(String[] agrs) {
  int num, result;
  final int ONE = 1;
  
  ...
  
  switch(result) {
      case '1' :    // OK.문자 리터럴(정수 49와 동일)
      case ONE :    // OK. 정수 상수
      case "Yes" :  // OK. 문자열 리터럴. JDK 1.7부터 허용
      case num :    // 에러. 변수는 불가
      case 1.0 :    // 에러. 실수도 불가
           ...
  }
}
```



* 예제:

  ```java
  import java.util.Scanner; // Scanner클래스를 사용하기 위해 추가.
  
  class Ex4_6 {
  	public static void main(String[] args) {
  		System.out.print("현재 월을 입력하세요.>");
  		
  		Scanner scanner = new Scanner(System.in);
  		int month = scanner.nextInt(); // 화면을 통해 입력받은 숫자를 month에 저장
  		
  		switch (month) {
  		case 3:
  		case 4:
  		case 5:
  			System.out.println("현재의 계절은 봄입니다.");
  			break;
  		case 6: case 7: case 8:
  			System.out.println("현재의 계절은 여름입니다.");
  			break;
  		case 9: case 10: case 11:
  			System.out.println("현재의 계절은 가을입니다.");
  			break;
  		default:
          // case 12: case 1: case 2:
  			System.out.println("현재의 계절은 겨울입니다.");
  		}
  	} // main의 끝
  }
  ```

  > 위 식의 결과:
  >
  > 현재 월을 입력하세요.>8
  >
  > 현재의 계절은 여름입니다.



## 08. 임의의 정수 만들기 Math.random()

* 난수(임의의 수)를 얻기 위해서는 Math.random()을 사용해야 하는데,
  이 메서드는 0.0과 1.0사이의 범위에 속하는 하나의 double값을 반환.

  > 0.0 <= Math.random() < 1.0
  >
  > *  Math.random은 Java 제공 class이다.
  > * Ex) 1과 3사이의 정수를 구하고자 함.
  >   1. 각 변에 3을 곱한다.
  >      0.0 * 3 <= Math.random() * 3 < 1.0 * 3
  >      -> 0.0 <= Math.random() * 3 < 3.0
  >   2. 각 변을 int형으로 변환한다.
  >      (int)0.0 <= (int)(Math.random() *3) < (int) 3.0
  >      -> 0 <= (int)(Math.random() *3) < 3
  >   3. 각 변에 1을 더한다.
  >      0+1 =< (int)(Math.random() *3)+1 <  3+1
  >      -> 1 =< (int)(Math.random() *3)+1 < 4

* 예제:

  ```java
  class Ex4_7 {
  	public static void main(String[] args) {
  		int num = 0;
  		
  		// 괄호{} 안의 내용을 5번 반복한다.
  		for (int i = 1; i <= 5; i++) {
  			num = (int) (Math.random() * 6) + 1;
  			System.out.println(num);
  		}
  	}
  }
  ```

  > 위 식의 결과:
  > 6
  >
  > 4
  >
  > 4
  >
  > 5
  >
  > 3
  >
  > * Math.random()을 사용 했기 때문에 실행할 때 마다 실행 결과가 달라진다.



---

#### 반복문

* 반복문의 종류: for문, while문, do-while문
* for문과 while문은 구조와 기능이 유사. 어느 경우에나 서로 변환이 가능..
  **반복 횟수를 알고 있을 땐 for문, 반복횟수를 모를때는 while문 사용.**

---

## 09. for문

* for문의 예문: "I can do it." 의 문장을 5번 출력

  > for(int i =1; i<=5; i++ ) {
  >
  > ​	System.out.println("I can do it.");
  >
  > }
  >
  > * 위의 식의 경우, 변수 i에 1을 저장하고, 매 반복마다 i의 값을 1씩 증가시킨다.
  >   그러다, i의 값이 5를 넘으면 조건식 'i<=5' 가 거짓이 되기 때문에, 반복을 마치게 됨.

* for문의 구조와 수행 순서:

  1. 구조:

     > for (초기화; 조건식; 증감식) {
     >
     > ​	// 조건식이 참(true)인 동안 수행될 문장들을 적는다.
     > }

  2. 수행 순서: 아래의 순서로 반복되다, 조건식이 거짓이 되면 for문 전체를 빠져나가게 된다.

     1. 초기화
     2. 조건식
     3. 수행될 문장
     4. 증감식

* 예제:

  ```java
  class Ex4_8 {
  	public static void main(String[] args) {
  		for (int i=1; i <=3; i++) { //괄호{} 안의 문장을 3번 반복
  			System.out.println("Hello");
  		}
  	}
  }
  ```

  > 위 식의 값:
  > Hello
  >
  > Hello
  >
  > Hello



* 초기화:

  * 반복문에 사용될 변수를 초기화하는 부분이며, 처음 한 번만 수행된다.

  * 보통 변수 하나로 for문을 제어하지만, 둘 이상의 변수가 필요할 때는 콤마','를 구분자로 변수를 초기화.

  * 두 변수의 타입이 같아야 함.

    > for(**int i=1**; i<=10;i++) {...} // 변수 i의 값을 1로 초기화한다.
    > for(**int i=1,j=0**; i<=10; i++) {...} // int타입의 변수 i와 j를 선언하고 초기화

*  조건식:

  * 조건식의 값이 참(true)이면 반복을 계속하고, 거짓(false)면 반복을 중단하고 for문을 벗어난다.

    > for(int i=1;**i<=10**;i++) {...}

  * 조건식을 잘못 작성하면, 블럭{} 내의 문장이 한 번도 수행되지 않거나, 무한 반복에 빠지기 쉬우므로 주의.

*  증감식:

  * 반복문을 제어하는 변수의 값을 증가 또는 감소시키는 식.

  * 매 반복마다 변수의 값이 증감식에 의해서 점진적으로 변하다가, 조건식이 거짓이 되어 for문을 벗어나게 됨.

  * 주로 연산자 '++'가 증감식에 주로 사용되지만, 다음과 같이 다양한 연산자들로 증감식을 작성할 수도있다.

    > for(int i=1;i<=10;i++) {...}  // 1부터 10까지 1씩 증가
    >
    > for(int i=10; i >=1; i--) {...} // 10부터 1까지 1씩 감소
    >
    > for(int i =1;i<=10;i+=2) {...} // 1부터 10까지 2씩 증가
    >
    > for(int i=1;i<=10;i*=3) {...} // 1부터 10까지 3배씩 증가

  * 증감식도 쉼표','를 이용해서 두 문장 이상을 하나로 연결해서 쓸 수 있다.

    > for(int i=1; j=10;i<=10;i++,i--) {...} //i는 1부터 10까지 1씩 증가하고, j는 10부터 1까지 1씩 감소한다.



* 세 가지 요소는 필요하지 않으면 생략할 수 있으며, 모두 생략하는 것도 가능하다.

  > For ( ; ; ) {...}

  **하지만 조건식이 생략 된 경우, 참(true)으로 간주되어 무한 반복문이 된다.**
  생략하는 대신 블럭{} 안에 if문을 넣어서 for문을 빠져 나올 수 있게 해야한다.

---

* 예제 1: 1부터 5까지 세로로 한 번, 가로로 한 번 출력하는 예제.

  ```java
  class Ex4_9 {
  	public static void main(String[] args) {
  		for(int i=1; i<=5; i++)
  			System.out.println(i); //i의 값을 출력한다.
  		
  		for(int i=1; i<=5; i++)
  			System.out.print(i); // print()를 쓰면 가로로 출력 된다.
  		
  		System.out.println();
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
  > 4
  >
  > 5
  >
  > 12345
  >
  > * i의 값이 변화함에 따라 조건식의 결과가 어떻게 되는지 알 수 있는 표
  >
  >   | i    | i <= 5                       |
  >   | ---- | ---------------------------- |
  >   | 1    | 1 <=5 ➡️ true 참              |
  >   | 2    | 2 <=5 ➡️ true 참              |
  >   | 3    | 3 <=5 ➡️ true 참              |
  >   | 4    | 4 <=5 ➡️ true 참              |
  >   | 5    | 5 <=5 ➡️ true 참              |
  >   | 6    | 6 <=5 ➡️ true 거짓, 반복 종료 |

* 예제 2: 1부터 10까지의 합을 구하는 예제.

  ```java
  class Ex4_10 {
  	public static void main(String[] args) {
  		int sum = 0;
  		
  		for(int i=1; i <=5; i++) {
  			sum += i;
  			System.out.printf("1부터 %2d 까지의 합: %2d%n", i, sum);
  		}
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 1부터 1 까지의 합: 1
  >
  > 1부터 2 까지의 합: 3
  >
  > 1부터 3 까지의 합: 6
  >
  > 1부터 4 까지의 합: 10
  >
  > 1부터 5 까지의 합: 15
  >
  > 
  >
  > * 변수 i를 1부터 10까지 변화시키면서, i를 sum에 계속 더해서 누적시키는 것.
  >
  >   | i    | sum = sum+1 |
  >   | ---- | ----------- |
  >   | 1    | 1 = 0 + 1   |
  >   | 2    | 3 = 1 + 2   |
  >   | 3    | 6 = 3 + 3   |
  >   | 4    | 10 = 6 + 4  |
  >   | 5    | 15 = 10 + 5 |

---



#### 중첩 for문

* for문 안에 또 다른 for문을 포함시키는 것을 중첩 for문이라고 한다.

* 중첩 횟수는 거의 제한이 없다.

* 예제:

  ```java
  class Ex4_11 {
  	public static void main(String[] args) {
  		
  		for(int i=1; i<=5;i++) {
  			for(int j=1; j<=i; j++) {
  				System.out.print("@");
  			}
  			System.out.println();
  		}
  	}
  }
  ```

  > 위 식의 값: 
  >
  > @
  >
  > @@
  >
  > @@@
  >
  > @@@@
  >
  > @@@@@
  >
  > * 위의 코드를 풀어 사용 할 경우,다음과 같다.
  >
  >   > for(int j=1;j<=1;j++) {System.out.print("@");}System.out.println();
  >   > for(int j=1;j<=2;j++) {System.out.print("@");}System.out.println();
  >   >
  >   > for(int j=1;j<=3;j++) {System.out.print("@");}System.out.println();
  >   >
  >   > for(int j=1;j<=4;j++) {System.out.print("@");}System.out.println();
  >   >
  >   > for(int j=1;j<=5;j++) {System.out.print("@");}System.out.println();
  >
  >   조건식의 숫자만 변화할 뿐, 나머지는 같기 때문에 숫자 대신 변수 i를 넣고, i의 값이 1부터 5까지 증가하는 for문에 넣는 것.



## 10. while문

* for문에 비해 while문은 구조가 간단하다.

* if문처럼 조건식과 블럭{}만으로 이루어져있다.

* if문과 달리 조건식이 '참(true)인 동안', 즉 조건식이 거짓이 될 때 까지 블럭{} 내의 문장을 반복.

  > while (조건식) {
  >
  > ​	// 조건식의 연산결과가 참(true)인 동안, 반복될 문장들을 적는다.
  >
  > }

  1. 조건식이 참(true)이면 블럭{} 안으로 들어가고, 거짓(false)이면 while문을 벗어난다.
  2. 블럭{}의 문장을 수행하고 다시 조건식으로 돌아간다.



#### for문과 while문의 비교

* 1부터 10까지의 정수를 순서대로 출력하는 for문을 while문으로 변경

  * for문

  ```java
  // 초기화, 조건식, 증감식
  for(int i=1;i<=10;i++) {
    System.out.println(i);
  }
  ```

  ↕️

  * while문

  ```java
  int i=1; // 초기화
  
  while(i<=10) { // 조건식
    System.out.println(i);
    i++; // 증감식
  }
  ```

  * 위 두 가지의 문은 문법이 다르지만, 과정이나 결과는 같다.
    스타일과 용도의 차이일 뿐이다.

* for문과 while문은 항상 서로 변환이 가능하다.



---

* 예제1: 변수 i의 값만큼 블럭{}을 반복하는 예제.

  ```java
  class Ex4_12 {
  	public static void main(String[] args) {
  		int i= 5;
  		
  		while(i--!=0) {
  			System.out.println(i+" -I can do it.");
  		}
  	} // main의 끝.
  }
  ```

  > 위 식의 값:
  >
  > 4 -I can do it.
  >
  > 3 -I can do it.
  >
  > 2 -I can do it.
  >
  > 1 -I can do it.
  >
  > 0 -I can do it.
  >
  > * while문의 조건식 'i--!=0'은 i의 값이 0이 아닌 동안만 참이 되고,
  >   i의 값이 매 반복마다 1씩 감소하다가 0이 되면 조건식이 거짓이 된다.
  >
  > * i의 값이 5~1이 아닌, 4~0으로 출력 된 이유는, 
  >   위 식의 'i--'는 후위형이기 때문에 i의 값이 1일 때는 조건식이 참으로 평가된 후에 i의 값이 1 감소되어 0으로 표기 된 것이다.
  >
  >   위 식을 풀어쓴다면:
  >
  >   ```java
  >   while(i--!=0) { 
  >     System.out.println(i);
  >   }
  >   
  >   // 풀어 썼을 때
  >   
  >   while(i!=0) { //!=는 등가비교 연산자. 두 값이 다르면 false
  >     i--;
  >     System.out.println(i);
  >   }
  >   ```

  

  

* 예제 2: 1부터 몇 까지 더해야 100을 넘지 않는지 알아내는 예제.

  ```java
  class Ex4_13 {
  	public static void main(String[] args) {
  		int sum =0;
  		int i = 0;
  		// i를 1씩 증가시켜서 sum에 계속 더해나간다.
  		while (sum <= 100) {
  			System.out.printf("%d - %d%n", i, sum);
  			sum += ++i;
  		}
  	} // main의 끝. 
  }
  ```

  > 위 식의 결과:
  >
  > 0 - 0
  >
  > 1 - 1
  >
  > 2 - 3
  >
  > 3 - 6
  >
  > 4 - 10
  >
  > 5 - 15
  >
  > 6 - 21
  >
  > 7 - 28
  >
  > 8 - 36
  >
  > 9 - 45
  >
  > 10 - 55
  >
  > 11 - 66
  >
  > 12 - 78
  >
  > 13 - 91





* 예제 3: 사용자로부터 숫자를 입력받고, 이 숫자의 각 자리의 합을 구하는 예제.

  ```java
  import java.util.*;
  
  class Ex4_14 {
  	public static void main(String[] args) {
  		int num = 0, sum = 0;
  		System.out.print("숫자를 입력하세요.(예:12345)>");
  		
  		Scanner scanner = new Scanner(System.in);
  		String tmp = scanner.nextLine();
  		num=Integer.parseInt(tmp);
  		
  		while(num!=0) {
  			//num을 10으로 나눈 나머지를 sum에 더함.
  			sum += num%10;
  			System.out.printf("sum=%3d num=%d%n", sum,num);
  			
  			num/= 10;
  		}
  		System.out.println("각 자리수의 합:"+sum);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 숫자를 입력하세요.(예:12345)>12345
  >
  > sum= 5 num=12345
  >
  > sum= 9 num=1234
  >
  > sum= 12 num=123
  >
  > sum= 14 num=12
  >
  > sum= 15 num=1
  >
  > 각 자리수의 합:15
  >
  > * 위 식을 단계별로 살펴보면
  >
  >   | num   | num%10 | sum=sum+num%10<br />(sum+=num%10) | num=num/10<br />(num/=10) |
  >   | ----- | ------ | --------------------------------- | ------------------------- |
  >   | 12345 | 5      | 5 = 0+5                           | 1234 = 12345/10           |
  >   | 1234  | 4      | 9 = 5+4                           | 123 = 1234/10             |
  >   | 123   | 3      | 12 = 9+3                          | 12 = 123/10               |
  >   | 12    | 2      | 14 = 12+2                         | 1 = 12/10                 |
  >   | 1     | 1      | 15 = 14+1                         | 0= 1/10                   |
  >   | 0     | -      | -                                 | -                         |
  >
  >   * 어떤 수를 10으로 나머지 연산하면 , 마지막 자리를 얻을 수 있다. 그리고 10으로 나누면 마지막 한자리가 제거된다.



## 11. do-while문

* do-while문은 while문의 변형으로 기본적인 구조는 while문과 같으나 조건식과 블럭{}의 순서를 바꿔 놓은 것.

* while문과 반대로 블럭{}을 먼저 수행한 후에 조건식을 평가.

* while문은 조건식의 결과에 따라 블럭{}이 한 번도 수행 되지 않을 수 있지만, **do-while문은 블럭{}이 최소 한 번은 수행**된다.

  ```java
  do {
    // 조건식의 연산결과가 참일 때 수행될 문장들을 적는다.(처음 한 번은 무조건 실행)
  } while (조건식); // 끝에 ';'을 잊지 않도록 주의.
  ```

* 그리 많이 쓰이지는 않지만, 반복적으로 사용자의 입력을 받아서 처리할 때 유용
  
* 예제: Math.random()을 이용해서 임의 수를 변수 answer에 저장하고, 값을 맞출 때까지 반복하는 예제.

  ```java
  import java.util.*;
  
  class Ex4_15 {
  	public static void main(String[] args) {
  		int input =0, answer =0;
  		
  		answer = (int)(Math.random()*100)+1; //1~100 사이의 임의의 수를 저장
  		Scanner scanner = new Scanner(System.in);
  		
  		do {
  			System.out.print("1과 100사이의 정수를 입력하세요,>");
  			input = scanner.nextInt();
  			
  			if(input > answer) {
  				System.out.println("더 작은 수로 다시 시도해보세요.");
  			} else if(input < answer) {
  				System.out.println("더 큰 수로 다시 시도해보세요.");
  			}
  		} while(input!=answer);
  		
  		System.out.println("정답입니다.");
  	}
}
  ```
  
  > 위 식의 결과:1과 100사이의 정수를 입력하세요,>80
  >
  > 더 큰 수로 다시 시도해보세요.
  >
  > 1과 100사이의 정수를 입력하세요,>90
  >
  > 더 작은 수로 다시 시도해보세요.
  >
  > 1과 100사이의 정수를 입력하세요,>87
  >
  > 더 작은 수로 다시 시도해보세요.
  >
  > 1과 100사이의 정수를 입력하세요,>82
  >
  > 정답입니다.



---



## 12.break문

* 앞서 swith문에서 break문을 사용 하였듯이, 반복문에서도 break문을 사용할 수 있다.

* 자신이 포함 된 가장 가까운 반복문을 벗어난다.

* 주로 if문과 함께 사용되어, 특정 조건을 만족할 때 반복문을 벗어나게 한다.

* 예제: 숫자를 1부터 계속 더해 나가서 몇 까지 더하면 합이 100을 넘는지 알아내는 예제.

  ```java
  class Ex4_16 {
  	public static void main(String[] args) {
  		int sum = 0;
  		int i = 0;
  		
  		while(true) {
  			if(sum>100)
  				break;
  			++i;
  			sum += i;
  		}
  		
  		System.out.println("i=" +i);
  		System.out.println("sum=" + sum);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > i=14
  >
  > sum=105
  >
  > * sum+=i; 와 ++i; 두 문장을 sum+=i++; 와 같이 한 문장으로 줄여 쓸 수 있다.



## 13. continue문

* 반복문 내에서만 사용 될 수 있는 문.

* 반복이 진행되는 도중에 continue문을 만나면 반복문의 끝으로 이동하여 다음 반복으로 넘어간다.

  * for문의 경우 증감식으로 이동, while문과 do-while문의 경우 조건식으로 이동.

* break문과 다른점: continue문은 반복문 전체를 벗어나지 않고, 다음 반복을 계속 수행.

* 주로 if문과 함께 사용됨.

* 전체 반복 중 특정조건을 만족하는 경우를 제외하고자 할 때 유용

* 예제: 1과 10사이의 숫자를 출력하되, 그 중에서 3의 배수인 것은 제외하도록 하는 문.

  ```java
  class Ex4_17 {
  	public static void main(String[] args) {
  		for(int i=0; i<=10;i++) {
  			if(i%3==0)
  				continue; // 조건식이 참이되어 continue문이 수행되면 블럭의 끝으로 이동.
  			 			      // break문과 달리 반복문을 벗어나지 않는다.
  			System.out.println(i);
  		}
  	}
  }
  ```

  > 위 식의 결과:
  > 1
  >
  > 2
  >
  > 4
  >
  > 5
  >
  > 7
  >
  > 8
  >
  > 10





## * break문과 continue문 예제

* 예제 1: 메뉴를 보여주고 선택하게 하는 예제.

  ```java
  import java.util.*;
  
  class Ex4_18 {
  	public static void main(String[] args) {
  		int menu = 0;
  		int num = 0;
  		
  		Scanner scanner=new Scanner(System.in);
  		
  		while(true) {
  			System.out.println("(1) square");
  			System.out.println("(2) square root");
  			System.out.println("(3) log");
  			System.out.print("원하는 메뉴(1~3)를 선택하세요.(종료:0)>");
  			
  			String tmp = scanner.nextLine();
  			menu = Integer.parseInt(tmp);
  			
  			if(menu==0) {
  				System.out.println("프로그램을 종료합니다.");
  				break;
  			} else if (!(1<=menu && menu <=3)) {
  				System.out.println("메뉴를 잘못 선택하셨습니다.(종료는0)");
  				continue;
  			}
  			
  			System.out.println("선택하신 메뉴는 "+menu+"번입니다.");
  		}
  	}
  }
  ```

  > 위 식의 결과:
  >
  > (1) square
  >
  > (2) square root
  >
  > (3) log
  >
  > 원하는 메뉴(1~3)를 선택하세요.(종료:0)>3
  >
  > 선택하신 메뉴는 3번입니다.

  

  > (1) square
  >
  > (2) square root
  >
  > (3) log
  >
  > 원하는 메뉴(1~3)를 선택하세요.(종료:0)>4
  >
  > 메뉴를 잘못 선택하셨습니다.(종료는0)

  

  > (1) square
  >
  > (2) square root
  >
  > (3) log
  >
  > 원하는 메뉴(1~3)를 선택하세요.(종료:0)>0
  >
  > 프로그램을 종료합니다.



## 14. 이름 붙은 반복문

* break문은 근접한 단 하나의 반복문만 벗어날 수 있기 때문에, 중첩 반복문 앞에 이름을 붙이고 break문과 continue문에 이름을 지정해 줌으로써
  하나 이상의 반복문을 벗어나거나 반복을 건너뛸 수 있다.

* 예제: 구구단을 출력하는 예제.

  ```java
  class Ex4_19 {
  	public static void main(String[] args) {
  		// for문 앞에 Loop1이라는 이름을 붙였다.
  		Loop1 : for(int i=2;i <=9;i++) {
  			for(int j=1;j<=9;j++) {
  				if(j==5)
  					break Loop1;
  				// 1.break
  				// 2.continue Loop1
  				// 3. continue
  				System.out.println(i+"*"+j+"="+i*j);
  			} // 3. end or for i
  			System.out.println();
  		}// 2. end of Loop1
  	//1.
  	}
  }
  ```

  > 위 식의 결과:
  > 2*1=2
  >
  > 2*2=4
  >
  > 2*3=6
  >
  > 2*4=8

  * j가 5일 때 반복문 Loop1을 벗어나도록 했으므로, 2단의 4번째 줄 까지 밖에 출력되지 않은 것.
    만일 반복문의 이름이 지정되지 않은 break문이었다면, 2단부터 9단까지 출력되었을 것이다.

* 예제 2: 메뉴를 선택하면 해당 연산을 반복적으로 수행.

  ```java
  import java.util.*;
  
  class Ex4_20 {
  	public static void main(String[] args) {
  		int menu=0,num=0;
  		Scanner scanner = new Scanner(System.in);
  		
  		outher: //while문에 outher이라는 이름을 붙인다.
  			while(true) {
  				System.out.println("(1) square");
  				System.out.println("(2) square root");
  				System.out.println("(3) log");
  				System.out.print("원하는 메뉴(1~3)를 선택하세요.(종료:0)>");
  				
  				String tmp = scanner.nextLine(); //화면에서 입력받은 내용을 tmp에 저장
  				menu = Integer.parseInt(tmp);    //입력받은 문자열(tmp)을 숫자로 변환
  				
  				if(menu==0) {
  					System.out.println("프로그램을 종료합니다.");
  					break;
  				} else if (!(1<=menu && menu <= 3)) {
  					System.out.println("메뉴를 잘못 선택하셨습니다.(종료는 0)");
  					continue;
  				}
  				for(;;) {
  					System.out.print("계산할 값을 입력하세요.(계산 종료:0, 전체 종료:99)>");
  					tmp=scanner.nextLine(); //화면에서 입력받은 내용을 tmp에 저장.
  					num=Integer.parseInt(tmp); // 입력받은 문자열(tmp)을 숫자로 변환.
  					
  					if(num==0)
  						break; //계산 종료. for문을 벗어난다.
  					if(num==99)
  						break outher; //전체종료. for문과 while문을 모두 벗어난다.
  					
  					switch(menu) {
  					case 1:
  						System.out.println("result="+ num*num);
  						break;
  					case 2:
  						System.out.println("result="+ Math.sqrt(num));
  						break;
  					case 3:
  						System.out.println("resault="+ Math.log(num));
  						break;
  					}
  				}//for(;;)
  			}//while의 끝.
  	}// main의 끝.
  }
  ```

  > 위 식의 결과:
  >
  > (1) square
  >
  > (2) square root
  >
  > (3) log
  >
  > 원하는 메뉴(1~3)를 선택하세요.(종료:0)>1
  >
  > 계산할 값을 입력하세요.(계산 종료:0, 전체 종료:99)>10
  >
  > result=100
  >
  > 계산할 값을 입력하세요.(계산 종료:0, 전체 종료:99)>2
  >
  > result=4

  

  > (1) square
  >
  > (2) square root
  >
  > (3) log
  >
  > 원하는 메뉴(1~3)를 선택하세요.(종료:0)>2
  >
  > 계산할 값을 입력하세요.(계산 종료:0, 전체 종료:99)>10
  >
  > result=3.1622776601683795

  

  > (1) square
  >
  > (2) square root
  >
  > (3) log
  >
  > 원하는 메뉴(1~3)를 선택하세요.(종료:0)>3
  >
  > 계산할 값을 입력하세요.(계산 종료:0, 전체 종료:99)>10
  >
  > resault=2.302585092994046

  * 반복문만 떼어놓고보면, 무한 반복문인 while문 안에 또 다른 무한 반복문인 for문이 중첩된 구조라는 것을 알 수 있다.
    while문은 메뉴를 반복해서 선택할 수 있게 해주고,
    for문은 선택된 메뉴의 작업을 반복해서 할 수 있게 해준다.

    ```java
    outer:
    while(true) { //무한 반복문
      ...
        for(;;) { //무한 반복문
          ...
          if(num==0) //계산종료.for문을 벗어난다.
            break;
          if(num==99 //전체종료. for문과 while문 모두 벗어난다.
            break outer;
        }//for(;;)
    }//while(true)
    ```

    

