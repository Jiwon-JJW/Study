# CHAPTER 09

* java.lang패키지는 자바프로그래밍에서 가장 기본이 되는 클래스들을 포함하고 있다.
  그렇기 때문에 java.lang패키지의 클래스들은 import문 없이도 사용할 수 있다.


## 01. Object클래스

* Object클래스는 모든 클래스의 최고 조상이기 때문에, Object클래스의 멤버들은 모든 클래스에서 바로 사용이 가능하다.
* Object클래스는 멤버변수는 없고 오직 11개의 메서드만 가지고 있다.


|                    Object클래스의 메서드                     |                            설 명                             |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
|                   protcted Object clone ()                   |                객체 자신의 복사본을 반환한다.                |
|              public boolean equals(Object obj)               | 객체 자신과 객체 obj가 같은 객체인지 알려준다.(같으면 true)  |
|                  protected void finalize()                   | 객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출된다. 이 때 수행되어야하는 코드가 있을 때 오버라이딩한다. (거의 사용안함) |
|                   public Class getClass()                    | 객체 자신의 클래스 정보를 담고 있는 Class인스턴스를 반환한다. |
|                    public int hashCode()                     |               객체 자신의 해시코드를 반환한다.               |
|                   public String toString()                   |            객체 자신의 정보를 문자열로 반환한다.             |
|                     public void notify()                     |   객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다.    |
|                   publid void notifyAll()                    |    객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨운다.     |
| public void wait()<br />public void wait(long timeout)<br />public void wait(long timeout,int nanos) | 다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간(timeout, nanos)동안 기다리게 한다.(timeout은 천 분의 1초, nanos는 109분의 1초) |



### 01. Object클래스의 메서드 - equals()

* 매개변수로 객체의 참조변수를 받아서 비교하여 그 결과를 boolean값으로 알려주는 역할.

* Object클래스에 정의되어 있는 equals메서드의 실제 내용:

  ```java
  public boolean equals(Object obj) {
    return (this==obj);
  }
  ```

  * 두 객체의 같고 다름을 참조변수의 값으로 판단.
    때문에 서로 다른 두 객체를 equals메서드로 비교하면 항상 false를 결과로 얻게 됨.

* 예제:

  ```java
  public class Ex9_1 {
  	public static void main(String[] args) {
  		Value v1 = new Value(10);
  		Value v2 = new Value(10);
  		
  		if(v1.equals(v2))
  			System.out.println("v1과 v2는 같습니다.");
  		else
  			System.out.println("v1과 v2는 다릅니다.");
  	} //main
  }
  
  class Value {
  	int value;
  	
  	Value(int value) {
  		this.value = value;
  	}
  }
  ```

  > 위 식의 결과:
  >
  > v1과 v2는 다릅니다.

  * equlas는 주소값으로 비교하기 때문에 두 Value인스턴스의 멤버변수 value의 값이 10으로 서로 같아도 equlas로 비교한 결과는 false일 수 밖에 없다.



#### equals()의 오버라이딩

* Object클래스로부터 상속받은 equals메서드는 결국 두 개의 참조변수에 저장된 주소값이 같은지 판단하는 기능 밖에 할 수 없지만
  위의 예제에서 Value인스턴스 내에 value 값을 비교하도록 할 수 있다.

* Value클래스에서 equals메서드를 오버라이딩하여 주소가 아닌 객체에 저장된 내용을 비교하도록 변경하는 것.

* 예제: equals메서드가 Person인스턴스의 주소값이 아닌 멤버변수 id의 값을 비교하도록 equals를 오버라이딩 한 것.

  ```java
  class Person {
  	long id;
  	
  	public boolean equals(Object obj) {
  		if(obj instanceof Person)
  			return id ==((Person)obj).id; // obj가 Object타입이므로 id값을 참조하기 위해서는 Person타입으로 형변환이 필요하다.
  		
  		else
  			return false; // 타입이 Person이 아니면 값을 비교할 필요도 없다.
  	}
  	
  	Person(long id) {
  		this.id = id;
  	}
  }
  public class Ex9_2 {
  	public static void main(String[] args) {
  		Person p1= new Person(8011081111222L);
  		Person p2= new Person(8011081111222L);
  		
  		if(p1.equals(p2))
  			System.out.println("p1과 p2는 같은 사람입니다.");
  		else
  			System.out.println("p1과 p2는 다른 사람입니다.");
  	}
  }
  ```

  > 위 식의 결과:
  >
  > p1과 p2는 같은 사람입니다.



---

### 02. Object클래스의 메서드 - hashCode()

* 해싱(hashing)기법에 사용되는 '해시함수(hash function)'를 구현한 것.다량의 데이터를 저장하고 검색하는 데 유용하다.
* 해시함수는 찾고자하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드(hashcode)를 반환한다.
* Object클래스에 정의된 hashCode메서드는 객체의 주소값을 이용해서 해시코드를 만들어 반환하기 때문에 두 객체는 같은 해시코드를 가질 수없다.
* 클래스의 인스턴스변수 값으로 객체의 같고 다름을 판단해야하는 경우라면, equals()와 같이 적절한 오버라이딩이 필요하다.



* 예제: 

  ```java
  public class Ex9_3 {
  	public static void main(String[] args) {
  		String str1 = new String("abc");
  		String str2 = new String("abc");
  		
  		System.out.println(str1.equals(str2));
  		System.out.println(str1.hashCode());
  		System.out.println(str2.hashCode());
  		System.out.println(System.identityHashCode(str1));
  		System.out.println(System.identityHashCode(str2));
  	}
  }
  ```

  > 위 식의 결과:
  >
  > true
  >
  > 96354
  >
  > 96354
  >
  > 977993101
  >
  > 429313384

  * String클래스는 문자열이 같으면, 동일한 해시코드를 반환하도록 hashCode메서드가 오버라이딩 되어있음.

    때문에, 문자열의 내용이 같은 str1과 str2가 항상 동일한 해시코드값을 얻는다.

  * 반면, System.identityHashCode(Object x)는 Object클래스의 hashCode메서드처럼 객체의 주소갑으로 해시코드를 생성하기 때문에
    모든 객체에 대해 항상 다른 해시코드를 반환한다.

---

### 03. Object클래스의 메서드 - toString()

* 인스턴스에 대한 정보를 문자열(String)로 제공할 목적으로 정의. 대부분의 경우 인스턴스 변수에 저장된 값들을 문자열로 표현함.

* Object클래스에 정의된 toString()은 아래와 같다.

  ```java
  public String toString() {
    return getClass().getName()+"@"+Integer.toHexString(hashCode());
  }
  ```

  * 클래스를 작성 시, toString()을 오버라이딩 하지 않는다면, 위와 같은 내용이 그대로 사용되어 클래스 이름과 16진수의 해시코드를 얻게 될 것이다.

* 예제: 오버라이딩을 하지 않았기 때문에 Object클래스의 toString()이 호출 된 모습을 볼 수 있다.

  ```java
  class Card {
  	String kind;
  	int number;
  	
  	Card() {
  		this("SPADE",1);
  	}
  	
  	Card(String kind, int number) {
  		this.kind = kind;
  		this.number = number;
  	}
  }
  public class Ex9_4 {
  	public static void main(String[] args) {
  		Card2 c1 = new Card();
  		Card2 c2 = new Card();
  		
  		System.out.println(c1.toString());
  		System.out.println(c2.toString());
  	}
  }
  ```

  > 위의 결과:
  >
  > Card2@6d1e7682
  >
  > Card2@424c0bc4



#### toString()의 오버라이딩

* 일반적으로 인스턴스나 클래스에 대한 정보 또는 인스턴스 변수들의 값을 문자열로 변환하여 반환하도록 오버라이딩 되는 것이 보통이다.

* 위의 예제를 보다 오버라이딩 하여 쓸모있는 정보를  제공할 수 있도록 바꿔보자.

  ```java
  class Card3 {
  	String kind;
  	int number;
  	
  	Card3() {
  		this("SPADE",1); // Card(String kind, int number)를 호출 	
  	}
  	
  	Card3(String kind, int number) {
  		this.kind = kind;
  		this.number = number;
  	}
  	
  	public String toString() {
  		return "kind: " + kind + ", number: "+number; // Card2인스턴스의 kind와 number를 문자열로 반환한다.
  	}
  }
  
  public class Ex9_5 {
  	public static void main(String[] args) {
  		Card3 c1 = new Card3();
  		Card3 c2 = new Card3("HEART",10);
  		System.out.println(c1.toString());
  		System.out.println(c2.toString());
  	}
  }
  ```

  > 위 식의 결과:
  >
  > kind: SPADE, number: 1
  >
  > kind: HEART, number: 10

  * Card3 인스턴스의 toString()을 호출하면 인스턴스가 갖고 있는 인스턴스 변수 kind와 number의 값을 문자열로 변환하여 반환하도록 오버라이딩 한 것.
    Object클래스에 정의된 toString()의 접근 제어자가 public이므로 toString()의 접근 제어자도 public으로 했다는 것을 눈여겨 볼 것.

    > 조상에 정의된 메서드를 자손에서 오버라이딩할 때는 조상에 정의 된 접근범위보다 같거나 넓어야하기 때문.



## 02. String클래스

* 문자열을 저장하고 이를 다루는데 필요한 메서드를 함께 제공하는 클래스.
* 아주 중요한 클래스이므로 자세히 공부해야한다.



**변경 불가능(immutable)클래스**

* String클래스에는 문자열을 저장하기 위해 문자형 배열 참조변수(char[]) value를 인스턴스 변수로 정의 해놓고 있다.

  인스턴스 생성 시 생성자의 매개변수로 입력받는 문자열은 이 인스턴스변수(value)에 문자형 배열(char[])로 저장 되는 것.

  ```java
  public final class String implements java.io.Serializable, Comparable {
    private char[] value;
    ...
  }
  ```

* 한 번 생성된 String인스턴스가 갖고있는 문자열은 읽어 올 수만 있고 변경할 수 없다.

* 예를 들어 '+'연산자를 이용해 문자열을 결합하는 경우("a"+"b") , 인스턴스 내의 문자열이 바뀌는것이 아니라 새로운 문자열이 담긴 String인스턴스가 생성되는 것.("ab")

* 문자열 간의 결합이나 추출 등 문자열을 다루는 작업이 많이 필요한 경우, String클래스 대신 StringBuffer클래스를 사용하는 것이 좋다.

  > StringBuffer인스턴스에 저장한 문자열은 변경이 가능하기 때문.



#### 문자열(String)의 비교

* 문자열을 만들 때의 방법:

  1. 문자열 리터럴을 지정한다.
     - 이미 존재하는 것을 재사용 하는 것.
  2. String클래스의 생성자를 사용해서 만듦.
     - new연산자에 의해서 메모리할당이 이루어지기 때문에 항상 새로운 String인스턴스가 생성된다.

  ```java
  String str1 = "abc";						 // 문자열 리터럴 "abc"의 주소가 str1에 저장됨
  String str2 = "abc";						 // 문자열 리터럴 "abc"의 주소가 str2에 저장됨
  String str3 = new String("abc"); // 새로운 String인스턴스를 생성
  String str4 = new String("abc"); // 새로운 String인스턴스를 생성
  ```

* equals()를 사용했을 때는 두 문자열의 내용("abc")을 비교하기 때문에 두 경우 모두 true를 결과로 얻지만,
  String인스턴스의 주소를 등가비교연산자'=='로 비교했을 때는 결과가 다르다.

* 예제:

  ```java
  public class Ex9_6 {
  	public static void main(String[] args) {
  		String str1="abc";
  		String str2="abc";
  		System.out.println("String str1= \"abc\";");
  		System.out.println("String str2= \"abc\";");
  		
  		System.out.println("str1 == str2 ? "+ (str1==str2));
  		System.out.println("str1.equals(str2) ?" + str1.equals(str2));
  		System.out.println();
  		
  		String str3= new String("abc");
  		String str4= new String("abc");
  		
  		System.out.println("String str3= \"abc\";");
  		System.out.println("String str4= \"abc\";");
  		
  		System.out.println("str1 == str2 ? "+ (str3==str4));
  		System.out.println("str1.equals(str2) ?" + str3.equals(str4));
  	}
  }
  
  ```

  > 위 식의 결과:
  >
  > String str1= "abc";
  >
  > String str2= "abc";
  >
  > str1 == str2 ? true
  >
  > str1.equals(str2) ?true
  >
  > 
  >
  > String str3= "abc";
  >
  > String str4= "abc";
  >
  > str1 == str2 ? false
  >
  > str1.equals(str2) ?true



#### 문자열 리터럴(String리터럴)

* 자바 소스파일에 포함된 모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장.
  이 때 같은 내용의 문자열 리터럴은 한번만 저장됨.

  > 문자열 리터럴도 String인스턴스이고, 한번 생성하면 내용을 변경할 수 없으니 하나의 인스턴스를 공유하면 되기 때문.

  ```java
  public class Ex9_7 {
  	public static void main(String[] args) {
  		String s1= "AAA";
  		String s2= "AAA";
  		String s3= "AAA";
  		String s4= "BBB";
  	}
  }
  ```

  * 이 때, 내용을 16진 코드에디터로 본다면 "AAA"와 "BBB"가 보이는데, 이와 같이 String리터럴들은 컴파일 시에 클래스파일에 저장됨.
  * 이후, 예제를 실행 시 "AAA"라는 문자열을 담고 있는 String인스턴스가 생성된 후, 참조변수 s1, s2,s3는 모두 이 String인스턴스를 참조하게 됨.



#### 빈 문자열(empty string)

* 길이가 0인 배열을 내부적으로 가지고있는 문자열.

* 'String s="";' 과 같은 문장이 있을 때, 참조변수 s가 참조하고 있는 String 인스턴스는 내부에 'new char[0]'과 같이 길이가 0인 char형 배열을 저장하고 있는 것.

  > char[] chArr = new char[0]; // 길이가 0인 char배열
  >
  > int[] iArr = {}; // 길이가 0인 int배열

* 단, 'char c = '';'의 경우, 불가능 하기 때문에 공백으로 초기화를 해줘야한다.

* 예제: 길이가 0인 배열을 생성해, char배열 참조변수 cArr을 초기화 해준 것.

  ```java
  public class Ex9_8 {
  	public static void main(String[] args) {
  		//길이가 0인 char배열을 생성한다.
  		char[] cArr = new char[0]; // char[] cArr = {}; 와 같다.
  		String s = new String(cArr); // String s = new String("");와 같다.
  		
  		System.out.println("cArr.length="+cArr.length);
  		System.out.println("@@@"+s+"@@@");
  	}
  }
  
  ```

  > 위 식의 결과:
  >
  > cArr.length=0
  >
  > @@@@@@



#### String클래스의 생성자와 메서드 목록

![image](https://user-images.githubusercontent.com/69128652/93695273-d43d5980-fb4f-11ea-853d-5168500c0487.png)

![image](https://user-images.githubusercontent.com/69128652/93695279-dacbd100-fb4f-11ea-960f-705f695fea01.png)

![image](https://user-images.githubusercontent.com/69128652/93695285-e15a4880-fb4f-11ea-923d-d4c2d8a7bd76.png)



## 03. join()과 StringJoiner

* join()은 여러 문자열 사이에 구분자를 넣어서 결합함.
  구분자로 문자열을 자르는 split()과 반대의 작업을 한다고 생각하면 이해하기 쉬움.

  ```java
  String animals = "dog,cat,bear";
  String[] arr = animals.split(","); // 문자열을 ','를 구분자로 나눠서 배열에 저장
  String str = String.join("-",arr); // 배열의 문자열을 '-'로 구분해서 결합
  System.out.println(str);					 // dog-cat-bear
  ```

* java.util.StringJoiner클래스를 사용해서 문자열을 결합할 수도 있다.
  방법:

  ```java
  StringJoiner sj = new StringJoiner(",","[","]");
  String[] strArr = {"aaa","bbb","ccc"};
  
  for(String s: strArr)
    sj.add(s.toUpperCase());
  
  System.out.println(sj.toString()); //[AAA,BBB,CCC]
  ```

* 예제:

  ```java
  import java.util.StringJoiner;;
  public class Ex9_9 {
  	public static void main(String[] args) {
  		String animals = "dog,cat,bear";
  		String[] arr = animals.split(",");
  		
  		System.out.println(String.join("-", arr));
  		
  		StringJoiner sj = new StringJoiner("/","[","]");
  		
  		for(String s: arr)
  			sj.add(s);
  		
  		System.out.println(sj.toString());
  	}
  }
  ```

  > 위 식의 결과:
  >
  > dog-cat-bear
  >
  > [dog/cat/bear]



## 04. 문자열과 기본형 간의 변환

* 숫자로 이루어진 문자열을 숫자로, 또는 그 반대로 변환하는 것.

* 기본형을 문자열로 변경하는 방법:

  1. 숫자에 빈 문자열""을 더해준다.

  2. valueOf()를 사용한다.

     > 성능은 이 것이 더 좋지만, 빈 문자열을 더하는 방법이 간단하고 편하기 때문에, 성능향상이 필요할 때만 사용.

  ```java
  int i = 100;
  String str1 = i+ "";
  String str2 = String.valueOf(i);
  ```

* String을 기본형으로 변환하는 방법:

  1. valuOf()를 사용한다.
  2. parseInt()를 사용한다.

  ```java
  int i = Integer.parseInt("100");
  int i2 = Integer.valueOf("100");
  // 원래 valueOf()의 반환타입은 int가 아닌 Interger이지만, 오토박싱(auto-boxing)에 의해 int로 자동 변환 됨.
  // Integer i2= Integer.valueOf("100");
  ```

* 이전에는 parseInt()와 같은 메서드를 많이 썼는데, 메서드 이름을 통일하기 위해 valueOf()가 나중에 추가됨.
  valueOf(String s)는 메서드 내부에서 parseInt(String s)를 호출 할 뿐이므로, 반환타입만 다르지 같은 메서드다.

  ```java
  public static Integer valueOf(String s)throws NumberFormatException {
    return Integer.valueOf(parseInt(s,10)); // 여기서 10은 10진수를 의미 
  }
  ```

  

| 기본형 > 문자열                                              | 문자열 > 기본형                                              |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| String String.valueOf(boolean b)<br />String String.valueOf(char c)<br />String String.valueOf(int i)<br />String String.valueOf(long l)<br />String String.valueOf(float f)<br />String String.valueOf(double d) | boolean  Boolean.parseBoolean(String s)<br />byte  Byte.parseByte(String s)<br />short  Short.parseShort(String s)<br />int  Int.parseInt(String s)<br />long  Long.parseLong(String s)<br />float  Float.parseFloat(String s)<br />double  Double.parseDouble(String s) |



* 예제: 문자열과 기본형간의 변환의 예

  ```java
  public class Ex9_10 {
  	public static void main(String[] args) {
  		int iVal =100;
  		String strVal = String.valueOf(iVal); //int를 String으로 변환한다.
  		
  		double dVal=200.0;
  		String strVal2 = dVal + ""; //int를 String으로 변환하는 또 다른 방법.
  		
  		double sum = Integer.parseInt("+"+strVal) + Double.parseDouble(strVal2);
  		double sum2 = Integer.parseInt(strVal)+ Double.valueOf(strVal2);
  		
  		System.out.println(String.join("", strVal,"+",strVal2,"=")+sum);
  		System.out.println(strVal+"+"+strVal2+"="+sum2);
  	}
  }
  ```

  > 위 식의 결과:
  >
  > 100+200.0=300.0
  >
  > 100+200.0=300.0

  * parseInt() 나 parseFloat()같은 메서드는 문자열에 공백 또는 문자가 포함되어있는 경우 변환시 예외(NumberFormat Exception)가 발생할 수 있으므로 주의.
    그래서 문자열 양 끝의 공백을 제거해주는 trim()을 습관적으로 같이 사용하기도 한다.

    > int val = Integer.parseInt(" 123 ".trim()); // 문자열 양 끝의 공백을 제거 후 변환.

  * 부호를 의미하는 '+'나 소수점을 의미하는 '.'와 float형 값을 뜻하는 f와 같은 자료형 접미사는 허용.
    단, 자료형에 알맞은 변환을 하는 경우에만 허용.



## 05. StringBuffer 클래스

* String클래스는 인스턴스를 생성할 때 지정된 문자열을 변경할 수 없지만, StringBuffer클래스는 변경이 가능하다.

* 내부적으로 문자열 편집을 위한 버퍼(buffer)를 가지고 있으며, StringBuffer인스턴스를 생성할 때 그 크기를 지정할 수 있다.
  편집할 문자열의 길이를 고려하여 버퍼의 길이를 충분히 잡아주는 것이 좋다. 추후 문자열이 버퍼의 길이를 넘어서면 버퍼의 길이를 늘려주는 작업을 수행해야하기 때문에, 작업효율이 떨어짐.

* String클래스와 StringBuffer클래스가 유사한 점:

  1. 문자열을 저장하기 위한 char형 배열의 참조변수를 인스턴스 변수로 선언해놓고 있다.
  2. StrinfBuffer인스턴스가 생성될 때, char형 배열이 생성되며 이 때 생성된 char형 배열을 인스턴스 변수 value가 참조하게 됨.

  ```java
  public final class StringBuffer implements java.io.Serializable {
    private char[] value;
    ...
  }
  ```

  

### StringBuffer의 생성자

* StringBuffer클래스의 인스턴스를 생성할 때, 생성자 StringBuffer(int length)를 사용해서 StringBuffer인스턴스에 저장될 문자열의 길이를 고려하여 충분히 여유있는 크기로 지정하는 것이 좋다.

* 생성 시, 버퍼의 크기를 지정해주지않으면 16개의 문자를 저장할 수 있는 크기의 버퍼를 생성한다.

  ```java
  public StringBuffer(int length) {
    value = new char[length];
    shared = false;
  }
  
  public StringBuffer() {
    this(16); // 버퍼의 크기를 지정하지 않으면 버퍼의 크기는 16이 된다.
  }
  
  public StringBuffer(String str){
    this(str.length()+16); // 지정한 문자열의 길이보다 16이 더 크게 버퍼를 생성한다.
    append(str);
  }
  ```

* 아래의 코드는 StringBuffer클래스의 일부인데, 버퍼의 크기를 변경하는 내용의 코드.
  StringBuffer인스턴스로 문자열을 다루는 작업을 할 때, 버퍼의 크기가 작업하려는 문자열의 길이보다 작을 때는 내부적으로 버퍼의 크기를
  증가시키는 작업이 수행된다.

* 배열의 길이는 변경될 수 없으므로 새로운 길이의 배열을 생성 후, 이전 배열의 값을 복사해야한다.

  ```java
  ...
    // 새로운 길이(newCapacity)의 배열을 생성한다. newCapacity는 정수값이다.
  char newValue[] = new char[newCapacity];
  
  // 배열 value의 내용을 배열 newValue로 복사한다.
  System.arraycopy(value, 0, newValue, 0, count); // count는 문자열의 길이
  value = newValue; // 새로 생성된 배열의 주소를 참조변수 value에 저장.
  ```

  * 이렇게 함으로써 StringBuffer클래스의 인스턴스변수 value는 길이가 증가된 새로운 배열을 참조하게 된다.



