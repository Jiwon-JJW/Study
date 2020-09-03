# CHAPTER 05

## 01. 배열이란?

* 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것.
* 다른 타입의 변수들로 구성된 배열은 만들 수 없다.
* 변수와 달리 배열은 각 저장공간이 연속적으로 배치 되어있다.



## 02. 배열의 선언과 생성

* 배열의 선언 방법:

  * 원하는 타입의 변수를 선언하고, 변수 또는 타입에 배열임을 의미하는 대괄호[] 를 붙이면 됨.

  * 대괄호[]는 타입 뒤에 붙여도 되고, 변수 이름 뒤에 붙여도 된다.

    | 선언 방법                                                    | 선언 예                           |
    | ------------------------------------------------------------ | --------------------------------- |
    | 타입[] 변수이름;<br />// 배열을 선언 (배열을 다루기 위한 참조변수 선언) | int [] score;<br />String[] name; |
    | 타입 변수이름[]:<br />// 배열을 생성 (실제 저장공간을 생성)  | int score[];<br />Strint name[];  |

* 배열의 생성:

  * 배열을 선언 한 다음에, 배열을 생성해야한다. 배열을 생성해야만 비로소 값을 저장할 수 있는 공간이 만들어 지는 것.

  * 배열을 생성하기 위해서는 연산자'new'와 함께 배열의 타입과 길이를 지정해 주어야 한다.

    > 타입 [] 변수이름;                   // 배열을 선언(배열을 다루기 위한 참조변수 선언)
    >
    > 변수이름 = new 타입[길이]; // 배열을 생성(실제 저장 공간을 생성)

    * 예제: 길이가 5인 int 배열을 생성

      ```java
      int[] score;			  // int 타입의 배열을 다루기 위한 참조변수 score선언
      score = new int[5]; // int 타입의 값 5개를 저장할 수 있는 배열 생성
      ```

      * 이때, 변수 score는 배열을 다루는데 필요한 참조변수일 뿐, 값을 저장하기 위한 공간은 아님.
        

      위의 코드를 간략화 할 경우,

      ```java 
      타입[] 변수 이름 = new 타입[길이]; //배열의 선언과 생성을 동시에.
      int[] score = new int[5];    //길이가 5인 int 배열
      ```

  * 생성된 배열의 각 저장 공간을 '배열의 요소(element)'라고 하며,
    '배열이름[인덱스]'의 형식으로 배열의 요소에 접근한다.


## 03. 배열의 인덱스

* **인덱스 (index)는 배열의 요소마다 붙여진 일렬 번호**로, 각 요소를 구별하는 데 사용됨.

* '인덱스(index)'의 범위는 0부터 '배열길이 -1'까지이다.

* ex) 길이가 5인 배열의 경우,

  > int[] score = new int[5]; // 길이가 5인 int 배열
  > ![인덱스 예제1](https://user-images.githubusercontent.com/69128652/90595743-7bb12e80-e228-11ea-879e-84b95f78c9b3.png)

  * 배열에 값을 저장하고 읽어오는 방법은 변수와 **같으나**,
     **변수 이름 대신 '배열이름 [인덱스]'를 사용한다.**

  > score[3] = 100;  // 배열 score의 4번째 요소에 100을 저장한다.
  > ![인덱스 예제 2](https://user-images.githubusercontent.com/69128652/90596238-7dc7bd00-e229-11ea-91f9-a9ab96becd49.png)
  >
  >
  > int value = score[3];  // 배열 score의 4번째 요소의 값을 읽어서 value에 저장
  > ![인덱스 예제3](https://user-images.githubusercontent.com/69128652/90596485-05adc700-e22a-11ea-9efa-ede3c5b5dca1.png)

* 배열은 index로 상수 대신 변수나 수식도 사용할 수 있다.
  따라서, 아래와같은 코드를 for문을 이용해서 간단히 할 수 있다.

  ```java
  score[0] = 0;
  score[1] = 10;
  score[2] = 20;
  score[3] = 30;
  ```

  ⬇️ 간단히 변환

  ```java
  for (int i=0; i<=3;i++) {
    score[i] = i+10;
  }
  ```



## 04. 배열의 길이

* 자바 가상머신(JVM)이 모든 배열의 길이를 별도로 관리하며,
  **'배열이름.length'를 통해서 배열의 길이에 대한 정보를 얻을 수 있다.**

  > 아래의 코드를 참고하자.
  > int[] arr = new int[5];  // 길이가 5인 int배열
  >
  > int  tmp = arr.length; // arr.length의 값은 5이고, tmp에 5가 저장된다.


* 배열은 한 번 생성하면 길이를 변경할 수 없기 때문에,
  **이미 생성된 배열의 길이는 변하지 않는다.** 따라서, '배열이름.length'는 **상수**다.

  * 아래의 코드는 배열의 각 요소를 for문을 이용해서 출력하는 것이다.

    ```java
    int[] score = new int[6]; //배열 score의 길이는 6, 인덱스의 범위는 0~5
    
    for (int i=0;i<6;i++)
      System.out.println(score[i]);
    ```
    
    만일 이 코드를 아래처럼 배열의 길이를 줄인다면, 에러가 발생한다.
    
    ```java
    int[] score = new int[5]; //배열의 길이를 6에서 5로 변경
    
    for (int i=0;i<6;i++)	    //실수로 조건식을 변경하지 않음
      System.out.println(score[i]); //에러 발생
    ```
  
* 위와 같은 에러의 경우가 발생 될 수 있으므로, **for문의 조건식에는** 배열의 길이를 직접 넣어 주는 것 보다,
  **'배열이름.length'를 사용하는 것이 좋다.**

  ```java
  int[] score = new int[5]; //배열의 길이를 6에서 5로 변경
  
  for (int i=0; i<score.length; i++) // 조건식을 변경하지 않아도 됨.
    System.out.println(score[i]);
  ```

  

## 05. 배열의 초기화

* 배열은 생성과 동시에 자동적으로 기본값(0)으로 초기화 되므로, 배열을 사용하기 전 따로 초기화 해주지 않아도 된다.

* 원하는 값을 저장하려면 아래와 같이 각 요소마다 값을 지정해줘야함.

  ```java
  int[] score = new int[5]; // 길이가 5인 int형 배열을 생성
  score[0] =50;             // 각 요소에 직접 값을 입력.
  score[1] =60;
  score[2] =70;
  score[3] =80;
  score[4] =90;
  ```

  배열의 길이가 큰 경우, for문을 사용하는 것이 더 좋다.

  * 위 코드를 for문으로 바꾼 경우:

  ```java
  int score=new int[5]; // 길이가 5인 int형 배열을 생성.
  
  for(int i=0; i < score.length; i++)
    score[i] = i*10+50;
  ```

  * for문으로 배열을 초기화 하려면:

    * 저장하려는 값에 일정한 규칙이 있어야만 가능 하기 때문에, 자바에서 배열을 간단히 초기화 할 수 있는 방법을 제공함.

      ```java
      	기본형: int[] score = new int[]{ 50,60,70,80,90}; // 배열의 생성과 초기화를 동시에
      	생략형: int[] score = new int[];
      				int[] score = { 50,60,70,80,90}; //이의 경우, 배열의 선언과 생성을 따로하는 경우 생략할 수 없음.
      ```





## 06. 배열의 출력

* 배열을 초기화 할 때, for문을 사용 하듯, 배열에 저장된 값을 확인 할 때도 for문을 사용하면 된다.

  ```java
  int[] iArr = { 100,95,80,70,60};
  for(int i=0;i <iArr.length; i++) { // 배열의 요소를 순서대로 하나씩 출력
    System.out.println(iArr[i]);
  }
  ```

* println메서드는 출력후에 줄바꿈이 되므로, 여러 줄에 출력되는 것이 불편하다면, print메서드를 사용하면 된다.

  ```java
  int[] iArr = { 100,95,80,70,60};
  for(int i=0;i<iArr.length;i++) {
    System.out.print(iArr[i]+","); //각 요소간의 구별을 위해 쉼표를 넣는다.
  }
  System.out.println(); // 다음 출력이 바로 이어지지 않도록 줄 바꿈을 한다.
  ```

* 더 간단한 방법으로는, **'Arrays.toString(배열이름)'메서드를 사용하는 것**이다.
  이 메서드는 배열의 모든 요소를 '[첫번째 요소,두번째 요소, ...]'와 같은 형식의 문자열로 만들어서 반환.

  ```java
  int[] iArr ={100,95,80,70,60};
  // 배열 iArr의 모든 요소를 출력한다. [100,95,80,70,60]이 출력된다.
  System.out.println(Arrays.toString(iArr));
  ```

  * iArr의 값을 바로 출력 할 경우, '타입@주소'의 형식으로 출력된다.
    참조 변수를 출력해봐야 별로 얻을 정보가 없다.

    ```java
    //배열을 가리키는 참조변수 iArr의 값을 출력한다.
    System.out.println(iArr); //[I@14318bb와 같은 형식의 문자열이 출력된다.
    ```

  * 예외적으로 char 배열의 경우, println메서드로 참조변수를 출력할 경우,
    각 요소가 구분자없이 그대로 출력된다. println내에서 char 배열일 때만 이렇게 동작되도록 작성되었기 때문.

    ```java
    char[] chArr = {'a','b','c','d'};
    System.out.println(chArr); // abcd가 출력됨.
    ```

    

## 07. 배열의 출력 예제

```java
class Ex5_1 {
	public static void main(String[] args) {
		int[] iArr1 = new int[10];
		int[] iArr2 = new int[10];
		// int[] iArr3 = new int {100,95,80,70,60}
		int[] iArr3 = {100,95,80,70,60};
		char[] chArr = {'a','b','c','d'};
		
		for (int i=0;i<iArr1.length;i++) {
			iArr1[i]= i+1; //1~10의 숫자를 순서대로 배열에 넣는다.
		}
		
		for (int i =0; i<iArr2.length;i++) {
			iArr2[i]=(int)(Math.random()*10)+1; //1~10의 값을 배열에 저장.
		}
		
		//배열에 저장된 값들을 출력한다.
		for(int i=0; i < iArr1.length;i++) {
			System.out.print(iArr1[i]+",");
		}
		System.out.println();
		
		System.out.println(Arrays.toString(iArr2));
		System.out.println(Arrays.toString(iArr3));
		System.out.println(Arrays.toString(chArr));
		System.out.println(iArr3);
		System.out.println(chArr);
	}
}
```

> 위 식의 결과:
>
> 1,2,3,4,5,6,7,8,9,10,
>
> [3, 4, 10, 10, 4, 2, 4, 5, 1, 9]
>
> [100, 95, 80, 70, 60]
>
> [a, b, c, d]
>
> [I@7440e464
>
> abcd





####  배열의 활용 (1) - 총합과 평균

* 배열의 모든 요소를 더해서 총합과 평균을 구한다.

  ```java
  class Ex5_2 {
  	public static void main(String[] args) {  
  		int sum=0;        // 총합을 저장하기 위한 변수
  		float average=0f; // 평균을 저장하기 위한 변수 
  		
  		int[]score = {100,88,100,100,90};
  		
  		for(int i=0;i<score.length;i++) {
  			sum += score[i];                   // 반복문을 이용해서 배열에 저장되어 있는 값들을 모두 더한다.
  		}
  		average = sum / (float)score.length; // 계산결과를 float타입으로 얻으려 형변환. 정확한 평균값을 위해.
  		
  		System.out.println("총합:"+sum);
  		System.out.println("평균:"+average);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 총합:478
  >
  > 평균:95.6



#### 배열의 활용 (2) - 최대값과 최소값

* 배열에 저장된 값 중에서 최대값과 최소값을 구한다.

  ```java
  class Ex5_3 {
  	public static void main(String[] args) {
  		int[] score= {79,88,91,33,100,55,95};
  		
  		int max = score[0]; // 배열의 첫 번째 값으로 최대값을 초기화한다.
  		int min = score[0]; // 배열의 첫 번째 값으로 최소값을 초기화한다.
  		
  		for(int i=1; i <score.length; i++) { // 배열의 두번째 요소부터 읽기위해, 변수 i의 값을 1로 초기
  			if(score[i] >max) {
  				max = score[i];
  			} else if(score[i] < min) {
  				min = score[i];
  			}
  		} //end of for
  		
  		System.out.println("최대값:"+max);
  		System.out.println("최소값:"+min);
  	} //end of main
  }// end of class
  ```

  > 위 식의 결과:
  >
  > 최대값:100
  >
  > 최소값:33
  >
  > * 진행 과정:
  >   1. 배열의 첫 번째 요소 'score[0]'의 값으로 최대값을 의미하는 변수 max와 최소값을 의미하는 변수 min을 초기화.
  >   2. 반복문을 통해 배열의 두 번째 요소 'score[1]'부터 max와 비교한다.
  >      만일 배열에 담긴 값이 max에 저장된 값보다 크다면, 이 값을 max에 저장한다.



#### 배열의 활용(3) - 섞기 (shuffle)

* 길이가 10인 배열 numArr을 생성하고 0~9의 숫자로 차례대로 초기화 하여 출력한다.

  ```java
  import java.util.Arrays;
  
  class Ex5_4 {
  	public static void main(String[] args) {
  		int[] numArr = {0,1,2,3,4,4,5,6,7,8,9};
  		System.out.println(Arrays.toString(numArr));
  		
  		for (int i=0; i<100; i++) {
  			int n = (int)(Math.random()*10); //0~9중의 한 값을 임의로 얻는다.
  			int tmp = numArr[0];   //numArr[0]과 numArr[n]의 값을 서로 바꾼다.
  			numArr[0] = numArr[n]; //numArr[0]과 numArr[n]의 값을 서로 바꾼다.
  			numArr[n] = tmp;       //numArr[0]과 numArr[n]의 값을 서로 바꾼다.
  		}
  		System.out.println(Arrays.toString(numArr));
  	} // main의 끝.
  }
  ```

  > 위 식의 결과:
  >
  > [0, 1, 2, 3, 4, 4, 5, 6, 7, 8, 9]
  >
  > [6, 3, 5, 7, 4, 2, 4, 0, 8, 1, 9]



#### 배열의 활용(4) - 로또 번호 만들기

* 로또번호를 생성한다.

  ```java
  class Ex5_5 {
  	public static void main(String[] args) {
  		int[] ball = new int[45]; //45개의 정수값을 저장하기 위한 배열생성.
  		
  		//배열의 각 요소에 1~45의 값을 저장한다.
  		for(int i=0; i< ball.length;i++)
  			ball[i] = i+1; //ball[0]에 1이 저장된다.
  		
  		int tmp=0; //두 값을 바꾸는데 사용할 임시변수.
  		int j=0;   //임의의 값을 얻어서 저장할 변수.
  		
  		//배열의 i번째 요소와 임의의 요소에 저장된 값을 서로 바꿔서 값을 섞는다.
  		//0번째부터 5번째 요소까지 모두 6개만 바꾼다.
  		for(int i=0;i<6;i++) {
  			j=(int)(Math.random()*45); //0~44범위의 임의의 값을 얻는다.
  			tmp =ball[i];
  			ball[i]=ball[j];
  			ball[j]=tmp;
  		}
  		
  		//배열 ball의 앞에서 부터 6개의 요소를 출력한다.
  		for(int i=0;i<6;i++)
  			System.out.printf("ball[%d]=%d%n", i, ball[i]);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > ball[0]=26
  >
  > ball[1]=9
  >
  > ball[2]=16
  >
  > ball[3]=8
  >
  > ball[4]=12
  >
  > ball[5]=2
  >
  > * 위 식은, random()에 의해서 결정된 임의의 위치에 있는 값과 자리를 바꾸는것을 6번 반복한다.
  >   때문에, 1부터 45까지의 번호가 쓰인 카드를 잘 섞은 다음, 맨 위의 6장을 꺼내는것과 같다고 할 수 있다.



## 08. String배열의 선언과 생성

* 배열의 타입이 String인 경우에도 int배열의 선언과 생성 방법은 다르지 않다.

  > ex) String[] name = new String[3]; // 3개의 문자열을 담을 수 있는 배열을 생성한다. 
  > ![String배열 예제](https://user-images.githubusercontent.com/69128652/90623570-9f3c9f00-e251-11ea-98d9-b35341f9b525.png)
  >
  > * String타입의 참조변수를 저장하기 위한 공간이 마련되고, 참조형 변수의 기본값은 null이므로, 각 요소의 값은 null이 된다.



* 변수의 타입에 따른 기본값:

  | 자료형           | 기본값        |
  | ---------------- | ------------- |
  | boolean          | false         |
  | char             | '\u0000'      |
  | byte, short, int | 0             |
  | long             | 0L            |
  | float            | 0.0f          |
  | double           | 0.0d 또는 0.0 |
  | 참조형           | null          |

  

#### String배열의 초기화

* 초기화 역시 int배열과 동일한 방법으로 진행한다.
  배열의 각 요소에 문자열을 지정하면 된다.

  ```java
  String[] name= new String[3]; //길이가 3인 String배열을 생성
  name[0] = "Kim";
  name[1] = "Park";
  name[2] = "Yi";
  ```

  또는, 괄호{}를 사용해서 간단히 초기화 할 수도 있다.

  ```java
  String[] name = new String[] {"Kim","Park","Yi"};
  String[] name = {"Kim","Park","Yi"}; // new String[]을 생략 할 수 있다.
  ```

  * 특별히 String클래스만 "Kim"과 같이 큰 따옴표만으로 간략히 표현하는 것이 허용되지만, 원래는 아래와 같이 new연산자를 사용해 객체를 생성해야함.

    > name[0] = new String("Kim")

* 예제:

  ```java
  class Ex5_6 {
  	public static void main(String[] args) {
  		String[] names = {"Kim","Park","Yi"};
  		
  		for(int i=0; i< names.length; i++)
  			System.out.println("names["+i+"]:"+names[i]);
  		
  		String tmp= names[2]; //배열 names의 세 번째 요소를 tmp에 저
  		System.out.println("tmp:"+tmp);
  		names[0] = "Yu"; //배열 names의 첫 번째 요소를 "Yu"로 변
  		
  		for(int i=0; i <names.length;i++)
  			System.out.println(names[i]);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > names[0]:Kim
  >
  > names[1]:Park
  >
  > names[2]:Yi
  >
  > tmp:Yi
  >
  > Yu
  >
  > Park
  >
  > Yi



#### String클래스

* String클래스는 char배열에 기능(메서드)을 추가한 것이다.

* 다른 언어에서는 문자열을 char배열로 다루지만,
  객체지향언어인 자바에서는 char배열과 그에 관련된 기능들을 함께 묶어 클래스에 정의한다.

* 객체지향개념이 나오기 전의 언어는 데이터와 기능(함수=메서드)을 따로 다루었지만, 객체지향언어에서는 하나의 클래스에 묶어 다룰 수 있게한다.
  (서로 관련된 것 들 끼리의 데이터와 기능을 구분하지 않음.)

* char배열과 String클래스의 차이는, String객체(문자열)는 읽을 수 만 있을 뿐 내용을 변경할 수 없다.

  ```java
  String str = "Java";
  str=str+"8";             //"Java8" 이라는 새로운 문자열이 str에 저장된다.
  System.out.println(str); //"Java8"
  ```

  * 위의 문장에서 문자열 str의 내용이 변경되는 것 같지만, 문자열은 변경할 수 없으므로 새로운 내용의 문자열이 생성된다.



#### String클래스의 주요 메서드

| 메서드                            | 설명                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| char charAt(int index)            | 문자열에서 해당 위치(index)에 있는 문자를 반환한다.<br />배열에서 '배열이름[index]'로 index에 위치한 값을 가져오는 것과 같다. |
| int length()                      | 문자열의 길이를 반환한다.                                    |
| String substring(int from,int to) | 문자열에서 해당 범위(from~to)의 문자열을 반환한다.(to는 포함 안 됨- 범위의 끝) |
| boolean equals(Object obj)        | 문자열의 내용이 같은지 확인한다. 같으면 결과는 true, 다르면 false |
| char[] toCharArray()              | 문자열을 문자배열(char[])로 변환해서 반환한다.               |

* charAt메서드의 예제:

  > String str = "ABCDE"
  > char ch = str.charAt(3); // 문자열 str의 4번째 문자 'D'를 ch에 저장.
  >
  > | index | 0    | 1    | 2    | 3    | 4    |
  > | ----- | ---- | ---- | ---- | ---- | ---- |
  > | 문자  | A    | B    | C    | D    | E    |

* substring()메서드의 예제:

  > String str = "012345"
  >
  > String tmp = str.substring(1,4); // str에서 index범위 1~4의 문자들을 반환
  >
  > System.out.println(tmp);           // "123"이 출력 된다.

* equals() 메서드의 예제:

  > String str = "abc"
  >
  > if(str.equals("abc")) { // str과 "abc"의 내용이 같은지 확인.
  >
  > ​	...
  > }



## 09. 커맨드 라인을 통해 입력받기

* 프로그램을 실행할 때 클래스이름 뒤에 공백문자로 구분 하여 여러 개의 문자열을 프로그램에 전달 할 수 있다.

  > 실행 할 프로그램의 main메서드가 담긴 클래스의 이름이 MainTest로 가정했을 때 실행 방법:
  > c:\jdk1.8\work\ch5>java MainTest abc 123
  >
  > 
  >
  > * 이클립스 내에서 매개변수 입력할 때는, Run Configuration에서 해당 클래스의 Arguments탭의 Program arguments: 란에
  >   abc 123 "Helloworld"
  >
  >   라고 입력한 후, 해당 클래스를 실행하면 된다.

* 커맨드 라인을 통해 입력된 두 문자열의 출력 방식:

  1. 두 문자열이 String 배열에 담긴다.
  2. MainTest 클레스의 main메서드의 매개변수(args)에 전달 됨.
  3. main메서드 내에서 args[0], args[1]과 같은 방식으로 커맨드 라인으로부터 전달받은 문자열에 접근 가능.
     * 여기서 args[0]은 "abc"이고, args[1]은 "123"이 된다.

* 예제:

  ```java
  class Ex5_7 {
  	public static void main(String[] args) {
  		System.out.println("매개변수의 개수:"+args.length);
  		for(int i=0;i<args.length;i++) {
  			System.out.println("args["+i+"]=\""+args[i] + "\"");
  		}
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 매개변수의 개수:3
  >
  > args[0]="abc"
  >
  > args[1]="123"
  >
  > args[2]="Hello world"

  

  > 매개 변수를 입력하지 않았을 경우:
  > 매개변수의 개수:0



## 10. 2차원 배열의 선언

* 여태 배운것은 1차원 배열이며, 2차원 이상의 배열 (다차원(multi-dimensional))도 선언해서 사용할 수 있다.

* 2차원 배열을 선언하는 방법:

  | 선언 방법           | 선언 예         |
  | ------------------- | --------------- |
  | 타입[][\] 변수이름; | int[][\] score; |
  | 타입 변수이름[][\]; | int score[][\]; |
  | 타입[] 변수이름[]:  | int[] score[];  |

  * 3차원 이상의 고차원 배열 선언은 대괄호[]의 개수를 차원의 수만큼 추가해주면 된다.

* 2차원 배열은, 주로 테이블 형태의 데이터를 담는 데 사용된다.

* ex) 4행 3열의 데이터를 담기위한 배열을 생성할 경우:

  > int[\][] score=new int[4]\[3]; // 4행 3열의 2차원 배열을 생성한다.
  >
  > - 위 문장이 수행 될 경우: 모두 12개의 int값을 저장할 수 있는 공간이 마련됨.
  >
  >   | int  | int  | int  |
  >   | :--: | :--: | :--: |
  >   | int  | int  | int  |
  >   | int  | int  | int  |
  >   | int  | int  | int  |
  >
  >   위의 표는 저장공간의 타입을 적어놓은 것이며, 실제로는 배열요소의 타입인 int의 기본값(=0)이 저장된다.
  >   **자동적으로 배열의 각 요소에 배열요소 타입의 기본값이 저장됨.**



#### 2차원 배열의 인덱스

* 2차원 배열은 행(row)과 열(column)로 구성되어 있기 때문에, **index도 행과 열에 각각 하나씩 존재**한다.

  * '행index'의 범위: '0~행의 길이 -1'
  * '열index'의 범위: '0~열의 길이-1'

* 2차원 배열의 각 요소에 접근하는 법: '배열이름[행indec]\[열index]'

* ex) 4행 3열의 2차원 배열 생성 후,접근 하기:

  > int[]\[] score=new int[4]\[3];    // 4행 3열의 2차원 배열 score를 생성
  >
  > |      |      0       |      1       |      2       |
  > | :--: | :----------: | :----------: | :----------: |
  > |  0   | score[0]\[0] | score[0]\[1] | score[0]\[2] |
  > |  1   | score[1]\[0] | score[1]\[1] | score[1]\[2] |
  > |  2   | score[2]\[0] | score[2]\[1] | score[2]\[2] |
  > |  3   | score[3]\[0] | score[3]\[1] | score[3]\[2] |
  >
  > * 배열 score의 1행 1열에 100을 저장하고, 값을 출력하려면:
  >
  >   > score[0]\[0] = 100;						 // 배열 score의 1행 1열에 100을 저장
  >   >
  >   > System.out.println(score[0]\[0]); // 배열 score의 1행 1열의 값을 출력



#### 2차원 배열의 초기화

* 2차원 배열도 괄호{}를 사용해서 생성과 초기화를 동시에 할 수 있다.

  다만, 괄호{}를 한번 더 써서 행별로 구분해준다.

  > int[]\[] arr = new int[]\[]{ {1,2,3},{4,5,6}};
  >
  > int[]\[] arr = {{1,2,3},{4,5,6}}; // new int[]\[]가 생략됨

* 크기가 작은 배열은 간단히 한 줄로 써도 되지만, 크기가 큰 경우, 행 별로 줄 바꿈을 해주는 것이 이해하기 쉽다.

  > int[]\[] arr = { 
  >
  > ​						{1,2,3},
  >
  > ​						{4,5,6}
  >
  > };



#### 2차원 배열의 초기화 예제

* 예제 1: 2차원 배열 score의 모든 요소의 합을 구하고, 출력하는 예제,

  ```java
  class Ex5_8 {
  	public static void main(String[] args) {
  		int[][] score= {
  				{100, 100, 100},
  				{20, 20, 20},
  				{30, 30, 30},
  				{40, 40, 40}
  		};
  		int sum = 0;
  		
  		for (int i=0; i<score.length; i++) {
  			for (int j = 0; j<score[i].length; j++) {
  				System.out.printf("score[%d][%d]=%d%n", i,j,score[i][j]);
  				
  				sum += score [i][j];
  			}
  		}
  		
  		System.out.println("sum="+sum);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > score[0]\[0]=100
  >
  > score[0]\[1]=100
  >
  > score[0]\[2]=100
  >
  > score[1]\[0]=20
  >
  > score[1]\[1]=20
  >
  > score[1]\[2]=20
  >
  > score[2]\[0]=30
  >
  > score[2]\[1]=30
  >
  > score[2]\[2]=30
  >
  > score[3]\[0]=40
  >
  > score[3]\[1]=40
  >
  > score[3]\[2]=40
  >
  > sum=570

  * 2차원 배열은 '배열의 배열'로 구성되어있기 때문에, score.length의 값을 측정 할 경우,
    * 배열 참조 변수 score가 참조하고 있는 배열의 길이를 세어본다.
      (위의 예제의 경우 4)
  * score[0].length의 값을 측정할경우.
    * 배열 참조변수 score[0]이 참조하고있는 배열의 길이를 세어본다.
      (위의 예제의 경우 3)



* 예제 2: 5명의 학생의 세 과목 점수를 더해서 각 학생의 총점과 평균을 계산하고, 과목별 총점을 계산하는 예제.

  ```java
  class Ex5_9 {
  	public static void main(String[] args) {
  		int[][] score= {
  				{100, 100, 100},
  				{20, 20, 20},
  				{30, 30, 30},
  				{40, 40, 40},
  				{50, 50, 50}
  		};
  		// 과목별 총점
  		int korTotal = 0, engTotal = 0, mathTotal = 0;
  		
  		System.out.println("번호  국어  영어  수학  총점  평균");
  		System.out.println("=================================");
  		
  		for(int i=0;i< score.length; i++) {
  			int sum = 0;	  // 개인별 총점.
  			float avg = 0.0f; // 개인별 평균.
  			
  			korTotal += score[i][0];
  			engTotal += score[i][1];
  			mathTotal += score [i][2];
  			System.out.printf("%3d", i+1);
  			
  			for(int j=0; j<score[i].length;j++) {
  				sum += score[i][j];
  				System.out.printf("%5d", score[i][j]);
  			}
  			
  			avg = sum/(float)score[i].length; // 평균 계산
  			System.out.printf("%5d %5.1f%n", sum, avg);
  		}
  		
  		System.out.println("=================================");
  		System.out.printf("총점:%3d %4d %4d%n", korTotal, engTotal, mathTotal);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 번호 국어 영어 수학 총점 평균
  >
  > =================================
  >
  >  1 100 100 100 300 100.0
  >
  >  2  20  20  20  60 20.0
  >
  >  3  30  30  30  90 30.0
  >
  >  4  40  40  40 120 40.0
  >
  >  5  50  50  50 150 50.0
  >
  > =================================
  >
  > 총점:240 240 240





* 예제 3: 영단어를 보여주고 단어의 뜻을 맞추는 예제:

  ```java
  class Ex5_10 {
  	public static void main(String[] args) {
  		String[][] words = {
  				{"chair","의자"},      //words[0][0], words[0][1]
  				{"computer","컴퓨터"}, //words[1][0], words[1][1]
  				{"interger","정수"}    // words[2][0],words[2][1]
  		};
  		
  		Scanner scanner = new Scanner(System.in);
  		
  		for(int i=0;i<words.length;i++) {
  			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);
  			
  			String tmp= scanner.nextLine();
  			
  			if(tmp.equals(words[i][1])) {
  				System.out.printf("정답입니다.%n%n");
  			} else {
  				System.out.printf("틀렸습니다. 정답은 %s입니다.%n%n", words[i][1]);
  			}
  		}// for
  	}// main의 끝
  }
  ```

  > 위 식의 결과:
  >
  > Q1. chair의 뜻은?dmlwk
  >
  > 틀렸습니다. 정답은 의자입니다.
  >
  > 
  >
  > Q2. computer의 뜻은?컴퓨터
  >
  > 정답입니다.
  >
  > 
  >
  > Q3. interger의 뜻은?정수
  >
  > 정답입니다.

  * words[i]\[0]은 문제, words[i]\[1]은 답이다.
    진행방식은 다음과 같다.
    1. words[i]\[0]을 화면에 보여주고, 입력받은 답은 tmp에 저장한다.
    2. 그 다음, eqials()로 tmp와 words[i\][1]을 비교해서 정답인지 확인한다.





## 11. Arrays로 배열 다루기

* 자주 사용 되는 메서드들이며, 보다 자세한 사항은 Chapter 11에서 다룰 예정.



#### 문자열의 비교와 출력 - equals(), toString()

* toString()배열

  * 모든 요소를 문자열로 편하게 출력할 수 있다.

  * 일차원 배열에서만 사용할 수 있다.
    다차원 배열에는 deepToString()을 사용.

    > deepToString()은 배열의 모든 요소를 재귀적으로 접근해, 문자열을 구성.
    >
    > 다차원 배열에도 동작함.

  ```java
  int[] arr = {0, 1, 2, 3, 4};
  int[][] arr2D = {{11,12},{21,22}};
  
  System.out.println(Arrays.toString(arr));   //[0, 1, 2, 3, 4]
  System.out.println(Attays.roString(arr2D)); //[[11, 12].[21, 22]]
  ```

* equals()배열

  * 두 배열에 저장된 모든 요소를 비교 후, 같으면 true , 다르면 false를 반환.
  * 일차원 배열에서만 사용할 수 있다.
    다차원 배열에는 deepEquals()를 사용.

  ```java
  String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
  String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
  
  System.out.println(Arrays.equals(str2D, str2D2));     //false
  System.out.println(deepArrays.equals(str2D, str2D2)); //true
  ```

* 배열의 복사 - copyOf(), copyOfRange()

  * copyOf() - 배열 전체를 복사해서 새로운 배열을 만들어 반환.
  * coptOfRange() - 배열의 일부를 복사해서 새로운 배열을 만들어 반환.
    - coptOfRange()에 지정된 범위의 끝은 포함되지 않음.

  ```java
  int[] arr = {0, 1, 2, 3, 4};
  int[] arr2 = Arrays.copyOf(arr, arr.length); //arr2=[0,1,2,3,4]
  int[] arr3 = Arrays.copyOf(arr, 3);          //arr3=[0,1,2]
  int[] arr4 = Arrays.copyOf(arr, 7);          //arr4=[0,1,2,3,4,0,0]
  int[] arr5 = Arrays.copyOfRange(arr, 2,4);   //arr5=[2,3] < 4는 불포함
  int[] arr6 = Arrays.copyOfRange(arr, 0,7);   //arr6=[0,1,2,3,4,0,0]
  ```

* 배열의 정렬 - sort()

  * 배열을 정렬한다. (보다 자세한 사항은 Chapter11에서.)

  ```java
  int[] arr = {3,2,0,1,4};
  Arrays.sort(arr); //배열 arr을 정렬한다.
  System.out.println(Arrays.toString(arr)); //[0,1,2,3,4]
  ```

  