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



### String클래스의 생성자와 메서드 목록

* **String(String s)**

  * 주어진 문자열(s)을 갖는 String인스턴스를 생성한다.

  ```java
  String s= new String("Hello");
  ```

  > 결과: 
  > s= "Hello"

* **String(char[] value)**

  * 주어진 문자열(value)을 갖는 String인스턴스를 생성한다.

  ```java
  char[] c = {'H', 'e', 'l, 'l', 'o'}<br />String s = new String(c);
  ```

  > 결과:
  > s= "Hello"

* **String(StringBuffer buf)**

  * StringBuffer인스턴스가 갖고 있는 문자열과 같은 내용의 String 인스턴스를 생성한다.

  ```java
  StringBuffer sb =
    new StringBuffer("Hello");
  	String s = new String(sb);
  ```

  > 결과:
  >
  > s= "Hello"

* **char charAt(int index)**

  * 지정된 위치(index)에 있는 문자를 알려준다.(index는 0부터 시작)

  ```java
  String s = "Hello";
  String n = "0123456";
  char c = s.charAt(1);
  char c2 = n.charAt(1);
  ```

  > 결과:
  >
  > c = 'e'
  >
  > c2 = '1'

* **String concat(String str)**

  * 문자열(str)을 뒤에 덧붙인다.

  ```java
  String s = "Hello";
  String s2 = s.concat("World");
  ```

  > 결과:
  > s2 = "Hello World"

* **boolean contains(CharSequence s)**

  * 지정된 문자열(s)이 포함되었는지 검사한다.

  ```java
  String s = "abcdefg";
  boolean b = s.contains("bc");
  ```

  > 결과:
  >
  > b = true

* **boolean endsWith(String suffix)**

  * 지정된 문자열(suffix)로 끝나는지 검사한다.

  ```java
  String file = "Hello.txt";
  boolean b = file.endsWith("txt");
  ```

  > 결과:
  >
  > b = true

* **boolean equals(Object obj)**

  * 매개변수로 받은 문자열(obj)과 String인스턴스의 문자열을 비교한다.
    obj가 String이 아니거나, 문자열이 다르면 false를 반환한다.

  ```java
  String s = "Hello";
  boolean b = s.equals("Hello");
  boolean b2 = s.equals("hello");
  ```

  > 결과:
  >
  > b = true
  >
  > b2 = false

* **boolean equalsIgnoreCase(String str)**

  * 문자열과 String인스턴스의 문자열을 대소문자 구분없이 비교한다.

  ```java
  String s = "Hello";
  boolean b = s.equalsIgnoreCase("HELLO");
  boolean b2 = s.equalsIgnoreCase("hello");
  ```

  > 결과:
  >
  > b = true
  >
  > b2 = true

* **int indexOf(int ch)**

  * 주어진 문자(ch)가 문자열에 존재하는지 확인하여 위치(index)를 알려준다.
    못 찾으면 -1 을 반환한다.(index는 0부터 시작.)

  ```java
  String s = "Hello";
  int idx1 = s.indexOf('o');
  int idx2 = s.indexOf('k');
  ```

  > 결과:
  >
  > idx1 = 4
  >
  > idx2 = -1

* **int indexOf(String str)**

  * 주어진 문자열이 존재하는지 확인하여 그 위치(index)를 알려준다.
    못 찾으면 -1을 반환한다.(index는 0부터 시작.)

  ```java
  String s = "ABCDEFG";
  int idx = s.indexOf("CD")
  ```

  > 결과:
  >
  > idx = 2

* **String intern()**

  * 문자열을 constant pool에 등록한다. 이미 constant pool에 같은 내용의 문자열이 있을 경우,
    그 문자열의 주소값을 반환한다.

  ```java
  String s = new String("abc");
  String s2 = new String("abc");
  boolean b = (s==s2);
  boolean b2 = s.equals(s2);
  boolean b3 = (s.intern()==s2.intern());
  ```

  > 결과:
  >
  > b= false
  >
  > b2 = true
  >
  > b3 = true

* int lastIndexOf(int ch)

  * 지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서 부터 찾아서 위치(index)를 알려준다.
    못 찾으면 -1 을 반환한다.

  ``` java
  String s = "java.lang.Object";
  int idx1 = s.lastIndexOf('.');
  int idx2 = s.indexOf('.');
  ```

  > 결과:
  >
  > idx1 = 9
  >
  > idx2 = 4

* **int lastIndexOf(String str)**

  * 지정된 문자열을 인스턴스의 문자열 끝에서 부터 찾아서 위치(index)를 알려준다.
    못 찾으면 -1을 반환한다.

  ```java
  String s = "java.lang.java";
  int idx1 = s.lastIndexOf("java");
  int idx2 = s.IndexOf("java");
  ```

  > 결과:
  >
  > idx1 = 10
  >
  > idx2 = 0

* **int length()**

  * 문자열의 길이를 알려준다.

  ```java
  String s = "Hello";
  int length = s.length();
  ```

  > 결과:
  >
  > length = 5

* **String replace(char old, char nw)**

  * 문자열 중의 문자(old)를 새로운 문자(nw)로 바꾼 문자열을 반환한다.

  ```java
  String s = "Hello";
  String s1 = s.replace('H','C');
  ```

  > 결과:
  >
  > s1 = "Cello"

* **String replace(CharSequence old, CharSequence nw)**

  * 문자열 중의 문자열(old)를 새로운 문자열(nw)로 모두 바꾼 문자열을 반환한다.

  ```java
  String s = "Hellollo";
  String s1 = s.replace("ll","LL");
  ```

  > 결과:
  >
  > s1 = "HeLLoLLo"

* **String replaceAll(String regex, String replacement)**

  * 문자열 중에서 지정된 문자열(regex)과 일치하는 것을 새로운 문자열(replacement)로 모두 변경한다.

  ```java
  String ab = "AABBAABB";
  String r = ab.replaceAll("BB","bb");
  ```

  > 결과:
  >
  > r = "AAbbAAbb"

* **String replaceFirst(String regex, String replacement)**

  * 문자열 중에서 지정된 문자열(regex)과 일치 하는 것 중, 첫 번째 것만 새로운 문자열(replacement)로 변경한다.

  ```java
  String ab = "AABBAABB";
  String r = ab.replaceFirst("BB","bb");
  ```

  > 결과:
  >
  > r = "AAbbAABB"

* **String[] split(String regex)**

  * 문자열을 지정된 분리자(regex)로 나누어 문자열 배열에 담아 반환한다.

  ```java
  String animals = "dog,cat,bear";
  String[] arr = animals.split(",");
  ```

  > 결과:
  >
  > arr[0] = "dog"
  >
  > arr[1] = "cat"
  >
  > arr[2] = "bear"

* **String[] split(String regex, int limit)**

  * 문자열을 지정된 분리자(regex)로 나누어 문자열 배열에 담아 반환한다.
    단, 문자열 전체를 지정된 수(limit)로 자른다.

  ```java
  String animals = "dog,cat,bear";
  String[] arr = animals.split(",",2);
  ```

  > 결과:
  >
  > arr[0] = "dog"
  >
  > arr[1] = "cat, bear"

* **boolean startsWith(String prefix)**

  * 주어진 문자열(prefix)로 시작하는지 검사한다.

  ```java
  String s = "java.lang.Object";
  boolean b = s.startsWith("java");
  boolean b2 = s.startsWith("lang");
  ```

  > 결과:
  >
  > b = true
  >
  > b2 = false

* **String substring(int begin)**
  **String substring(int begin, int end)**

  * 주어진 시작위치(begin)부터 끝 위치(end) 범위에 포함된 문자열을 얻는다.
    이 때, 시작위치의 문자는 범위에 포함되지만, 끝 위치의 문자는 포함되지 않는다.

  ```java
  String s = "java.lang.object";
  String c = s.substring(10);
  String p = s.substring(5,9);
  ```

  > 결과:
  >
  > c = "object"
  >
  > p = "lang"

* **String toLowerCase()**

  * String 인스턴스에 저장되어있는 모든 문자열을 소문자로 변환하여 반환한다.

  ```java
  String s = "Hello";
  String s1 = s.toLowerCase();
  ```

  > 결과:
  >
  > s1 = "hello"

* **String toString()**

  * String인스턴스에 저장되어있는 문자열을 반환한다.

  ```java
  String s = "Hello";
  String s1 = s.toString();
  ```

  > 결과:
  >
  > s1 = "Hello"

* **String toUpperCase()**

  * String 인스턴스에 저장되어있는 모든 문자열을 대문자로 변환하여 반환한다.

  ```java
  String s = "Hello";
  String s1 = s.toUpperCase();
  ```

  > 결과:
  >
  > s1 = "HELLO"

* **String trim()**

  * 문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과를 반환한다.
    이 때 문자열 중간에 있는 공백은 제거되지 않는다.

  ```java
  String s = "   Hello World    ";
  String s1 = s.trim();
  ```

  > 결과:
  >
  > s1 = "Hello World"

* **static String valueOf(boolean b)**
  **static String valueOf(char c)**
  **static String valueOf(int i)**
  **static String valueOf(lang l)**
  **static String valueOf(float f)**
  **static String valueOf(double d)**
  **static String valueOf(Object o)**

  * 지정된 값을 문자열로 변환하여 반환한다.
    참조변수의 경우, toString()을 호출한 결과를 반환한다.

  ```java
  String b = String.valueOf(true);
  String c = String.valueOf('a');
  String i = String.valueOf(100);
  String l = String.valueOf(100L);
  String f = String.valueOf(10f);
  String d = String.valueOf(10.0);
  
  java.util.Date dd = new java.util.Date();
  String date = String.valueOf(dd);
  ```

  > 결과:
  >
  > b = true
  >
  > c = "a"
  >
  > i = "100"
  >
  > l = "100"
  >
  > f = "10.0"
  >
  > d = "10.0"
  >
  > date = "Sun 27 21:26:29 KST 2008"



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
  2. StringfBuffer인스턴스가 생성될 때, char형 배열이 생성되며 이 때 생성된 char형 배열을 인스턴스 변수 value가 참조하게 됨.

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



#### StringBuffer의 변경

* StringBuffer는 내용을 변경할 수 있다.
* 예시: StringBuffer생성
  StringBuffer sb = new StringBuffer("abc");

![](https://user-images.githubusercontent.com/69128652/93850573-56ad5100-fce9-11ea-9481-c27cd48ecb3b.png)

* sb에 문자열 "123"추가 시,
  sb.append("123"); // sb의 내용 뒤에 "123"을 추가한다.

  ![](https://user-images.githubusercontent.com/69128652/93850761-befc3280-fce9-11ea-9711-dc59223a3ec3.png)

* append()는 반환타입이 StringBuffer인데 자신의 주소를 반환 함.
  때문에 아래의 문장이 수행되면, sb에 새로운 문자열이 추가되고 sb의 주소를 반환하여 sb2에는 sb의 주소가 저장됨.

  StringBuffer sb2 = sb.append("ZZ"); // sb의 내용뒤에 "ZZ"를 추가한다.
  System.out.println(sb);   // abc123ZZ

  System.out.println(sb2); // abc123ZZ
  ![](https://user-images.githubusercontent.com/69128652/93850971-35009980-fcea-11ea-81e8-3015f3c3984e.png)



* 하나의 StringBuffer인스턴스에 대해 아래와 같이 연속적으로 append()를 호출하는 것도 가능.

  ```java
  StringBuffer sb = new StringBuffer("abc");
  sb.append("123");
  sb.append("ZZ");
  ```

  ⬇️

  ```java
  StringBuffer sb = new StringBuffer("abc");
  sb.append("123").append("ZZ");
  
  ```

  * sb.append("123") 부분이 sb이므로 다시 append를 호출 할 수 있었던 것.
    만일 append타입이 void라면 이렇게 할 수 없음.



#### StringBuffer의 비교

* StringBuffer클래스는 equals메서드를 오버라이딩하지 않아서 StringBuffer클래스의 equals메서드를 사용해도 등가비교연산자(==)로 비교한 것과 같은 결과를 얻는다.

  ```java
  Stringbuffer sb = new StringBuffer("abc");
  StringBuffer sb2= new StringBuffer("abc");
  
  System.out.println(sb==sb2); 				// false
  System.out.println(sb.equals(sb2)); // false
  ```

* 반면, toString()은 오버라이딩 되어있어, StringBuffer인스턴스에 toString()을 호출하면, 담고있는 문자열을 String으로 반환한다.
  그래서 StringBuffer인스턴스에 담긴 문자열을 비교하기 위해서는,

  * StringBuffer인스턴스에 toString을 호출해, String인스턴스를 얻는다.
  * equals메서드를 사용해 비교한다.

  위와 같은 과정을 거쳐야한다.

  ```java
  String s= sb.toString();
  String s2= sb2.toString();
  
  System.out.println(s.equals(s2)); // true
  ```



* 예제:

  ```java
  public class Ex9_11 {
  	public static void main(String[] args) {
  		StringBuffer sb = new StringBuffer("abc");
  		StringBuffer sb2 = new StringBuffer("abc");
  		
  		System.out.println("sb==sb2 ?"+(sb==sb2));
  		System.out.println("sb.equals(sb2) ?"+ sb.equals(sb2));
  		
  		// StringBuffer의 내용을 String으로 변환한다.
  		String s = sb.toString(); // String s = new String(sb);와 같다.
  		String s2 = sb2.toString();
  		
  		System.out.println("s.equals(s2) ?"+ s.equals(s2));
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > sb==sb2 ?false
  >
  > sb.equals(sb2) ?false
  >
  > s.equals(s2) ?true



### StringBuffer의 생성자와 메서드

* String클래스와 유사한 메서드를 많이 가지고 있다.
* StringBuffer는 추가, 변경, 삭제와 같이 저장된 내용을 변경할 수 있는 메서드들이 추가로 제공됨.

---

* **StringBuffer()**

  * 16문자를 담을 수 있는 버퍼를 가진 StringBuffer 인스턴스를 생성한다.

  ```java
  StringBuffer sb = new StringBuffer();
  ```

  > 결과:
  > sb = ""

* **StringBuffer(int length)**

  * 지정된 개수의 문자를 담을 수 있는 버퍼를 가진 StringBuffer인스턴스를 생성한다.

  ```java
  StringBuffer sb = new StringBuffer(10);
  ```

  > 결과:
  >
  > sb = " "

* **StringBuffer(String str)**

  * 지정된 문자열 값(str)을 갖는 StringBuffer 인스턴스를 생성한다.

  ```java
  StringBuffer sb = new StringBuffer("Hi");
  ```

  > 결과:
  >
  > sb = "Hi"

* **StirngBuffer append(boolean b)**
  **StringBuffer append(char c)**
  **StringBuffer append(char[] str)**
  **StringBuffer append(double d)**
  **StringBuffer append(float f)**
  **StringBuffer append(int i)**
  **StringBuffer append(long l)**
  **StringBuffer append(Object obj)**
  **StringBuffer append(String str)**

  * 매개변수로 입력된 값을 문자열로 변환하여 StringBuffer인스턴스가 저장하고 있는 문자열의 뒤에 덧붙인다.

  ```java
  StringBuffer sb = new StringBuffer("abc");
  StringBuffer sb2 = sb.append(true);
  sb.append('d').append(10.0f);
  StringBuffer sb 3 = sb.append("ABC").append(123);
  ```

  > 결과:
  >
  > sb = "abctrued10.0ABC123"
  > sb2 = "abctrued10.0ABC123"
  >
  > sb3 = "abctrued10.0ABC123"

* **int capacity()**

  * StringBuffer 인스턴스의 버퍼크기를 알려준다. length()는 버퍼에 담긴 문자열의 크기를 알려준다.

  ```java
  StringBuffer sb = new StringBuffer(100);
  sb.append("abcd");
  int bufferSize = sb.capacity();
  int stringSize = sb.length();
  ```

  > 결과:
  > bufferSize = 100
  >
  > stringSize = 4(sb에 담긴 문자열이 "abcd"이므로)

* **char charAt(int index)**

  * 지정된 위치(index)에 있는 문자를 반환한다.

  ```java
  StringBuffer sb = new StringBuffer("abc");
  char c = sb.charAt(2);
  ```

  > 결과:
  >
  > c = 'c'

* **StringBuffer delete(int start, int end)**

  * 시작위치(start)부터 끝 위치(end) 사이에 있는 문자를 제거한다.
    단, 끝 위치의 문자는 제외

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  StringBuffer sb2 = sb.delete(3,6);
  ```

  > 결과:
  >
  > sb = "0126"
  >
  > sb2 = "0126"

* StringBuffer deleteCharAt(int index)

  * 지정된 위치(index)의 문자를 제거한다.

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  sb.deleteCharAt(3);
  ```

  > 결과: 
  >
  > sb = "012456"

* **StirngBuffer insert(int pos, boolean b)**
  **StringBuffer insert(int pos, char c)**
  **StringBuffer insert(int pos, char[] str)**
  **StringBuffer insert(int pos, double d)**
  **StringBuffer insert(int pos, float f)**
  **StringBuffer insert(int pos, int i)**
  **StringBuffer insert(int pos, long l)**
  **StringBuffer insert(int pos, Object obj)**
  **StringBuffer insert(int pos, String str)**

  * 두 번째 매개변수로 받은 값을 문자열로 변환하여 지정된 위치(pos)에 추가한다.
    pos는 0부터 시작

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  sb.insert(4,'.');
  ```

  > 결과:
  >
  > sb = "0123.456"

* **int length()**

  * StringBuffer인스턴스에 저장되어있는 문자열의 길이를 반환한다.

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  int length = sb.length();
  ```

  > 결과:
  >
  > length = 7

* **StringBuffer replace(int start, int end, String str)**

  * 지정된 범위(start~ end)의 문자들을 주어진 문자열로 바꾼다. end위치의 문자는 범위에 포함안됨.

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  sb.replace(3, 6, "AB");
  ```

  > 결과:
  >
  > sb = "012AB6"
  >
  > > "345"를 AB로 바꿨다.

* **StringBuffer reverse()**

  * StringBuffer인스턴스에 저장되어 있는 문자열의 순서를 거꾸로 나열한다.

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  sb.reverse();
  ```

  > 결과:
  >
  > sb = "6543210"

* **void setCharAt(int index, char ch)**

  * 지정된 위치의 문자를 주어진 문자(ch)로 바꾼다.

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  sb.srtCharAt(5, 'o');
  ```

  > 결과:
  >
  > sb = "01234o6"

* **void setLength(int newLength)**

  * 지정된 크기로 문자열의 길이를 변경한다.
    크기를 늘리는 경우, 나머지 빈 공간을 널 문자'₩u0000'로 채운다.

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  sb.setLength(5);
  StringBuffer sb2=new StringBuffer("0123456");
  sb2.setLength(10);
  String str = sb2.toString().trim();
  ```

  > 결과:
  >
  > sb = "01234"
  >
  > sb2 = "0123456    "
  >
  > str = "0123456"

* **String toString()**

  * StringBuffer인스턴스의 문자열을 String으로 반환한다.

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  String str = sb.toString;
  ```

  > 결과:
  >
  > str = "0123456"

* **String substring(int start)**
  **String substring(int start, int end)**

  * 지정된 범위 내의 문자열을 String으로 뽑아서 반환한다.
    시작위치(start)만 지정하면 시작 위치부터 문자열 끝까지 뽑아서 반환한다.

  ```java
  StringBuffer sb = new StringBuffer("0123456");
  String str = sb.substring(3);
  String str2 = sb.substring(3,5);
  ```

  > 결과:
  >
  > str = "3456"
  >
  > str2 = "34"



---



* 예제:

  ```java
  public class Ex9_12 {
  	public static void main(String[] args) {
  		StringBuffer sb = new StringBuffer("01");
  		StringBuffer sb2 = sb.append(23);
  		sb.append('4').append(56);
  		
  		StringBuffer sb3 = sb.append(78);
  		sb3.append(9.0);
  		
  		System.out.println("sb="+sb);
  		System.out.println("sb2="+sb2);
  		System.out.println("sb3="+sb3);
  		
  		System.out.println("sb="+sb.deleteCharAt(10));
  		System.out.println("sb="+sb.delete(3, 6));
  		System.out.println("sb="+sb.insert(3, "abc"));
  		System.out.println("sb="+sb.replace(6, sb.length(), "END"));
  		
  		System.out.println("capacity="+sb.capacity());
  		System.out.println("length="+sb.length());
  	}
  }
  ```

  > 예제:
  >
  > sb=0123456789.0
  >
  > sb2=0123456789.0
  >
  > sb3=0123456789.0
  >
  > sb=01234567890
  >
  > sb=01267890
  >
  > sb=012abc67890
  >
  > sb=012abcEND
  >
  > capacity=18
  >
  > length=9



## 06. StringBuilder

* StringBuffer는 멀티쓰레드에 안전(thread safe)하도록 동기화 되어있다.
  멀티쓰레드로 작성된 프로그램이 아닌 경우, StringBuffer의 동기화는 불필요하게 성능만 떨어트린다.

* 때문에 Stringbuffer에서 쓰레드의 동기화를 뺀 것이 StringBuilder.

* 완전히 같은 기능으로 이루어져 있기 때문에, 소스코드에서 StringBuffer대신 StringBuild를 사용하도록 생성자를 바꾸면 됨.

  ```java
  StringBuffer sb;
  sb = new StringBuffer();
  sb.append("abc");
  ```

  ⬇️

  ```java
  StringBuilder sb;
  sb = new StringBuilder();
  sb.append("abc");
  ```

* 성능향상이 반드시 필요한 경우를 제외하곤 기존에 작성 한 코드에서 굳이 바꿀 필요는 없다.





## 07. Math클래스

* 기본적인 수학계산에 유용한 메서드로 구성되어있는 클래스.
  임의의 수를 얻을 수 있는 random()과 반올림에 사용되는 round()등이 이 클래스에 포함 됨.

* Math클래스의 생성자는 접근 제어자가 private이기 때문에 다른 클래스에서 Math인스턴스를 생성할 수 없도록 되어있음.
  (클래스 내에 인스턴스변수가 하나도 없어, 인스턴스를 생성할 필요가 없기 때문.)

* Math클래스의 메서드는 모두 static이며, 2개의 상수만 정의 해 둠.

  ```java
  public static final double E = 2.7182818284590452354; // 자연로그의 밑
  public statuc final double PI = 3.141592653589779323846; // 원주율
  ```



#### 올림, 버림, 반올림

* 소수점 n번째 자리에서 반올림한 값을 얻기 위해서는 round()를 사용해야하는데, 이 메서드는 항상 소수점 첫째자리에서 반올림을 해서 정수값(long)를 결과로 돌려준다.

* 간단히 10의 n제곱으로 곱한 후, 다시 곱한 수로 나눠주기만 하면 된다.

  1. 원래 값에 100을 곱한다.

     > 90.7552 * 100 -> 9075.52

  2. 위의 결과에 Math.round()를 사용한다.

     > Math.round(9075.52) -> 9076

  3. 위의 결과를 다시 100.0으로 나눈다.

     > 9076/100.0 -> 90.76
     > 9076/100 -> 90

* 만일 정수형 값인 100 또는 100L로 나눌 경우, 정수형 값을 얻게 될 것이다.
  정수형간의 연산에서는 반올림이 이루어지지 않는다는 것을 반드시 기억하자.

* 만일 소수점 넷째자리에서 반올림된 소수점 세 자리 값을 얻으려면 100대신 1000으로 곱하고 1000.0으로 나누면 된다.
  반올림이 필요하지 않다면 round()를 사용하지 않고 단순히 1000으로 곱하고 1000.0으로 나누면 됨.



---

### Math의 메서드

* **static int abs(int f)**
  **static long abs(long f)**
  **static float abs(float f)**
  **static double abs(double a)**

  * 주어진 값의 절대값을 반환한다.

  ```java
  int i = Math.abs(-10);
  double d = Math.abs(-10.0);
  ```

  > 결과:
  >
  > i = 10
  >
  > d = 10.0

* **static double ceil(double a)**

  * 주어진 값을 올림하여 반환한다.

  ```java
  double d = Math.ceil(10.1);
  double d2 = Math.ceil(-10.1);
  double d3 = Math.ceil(10.0000015);
  ```

  > 결과:
  >
  > d = 11.0
  >
  > d2 = -10.0
  >
  > d3 = 11.0

* **static double floor(double a)**

  * 주어진 값을 버림하여 반환한다.

  ```java
  double d = Math.floor(10.8);
  double d2 = Math.floor(-10.8);
  ```

  > 결과:
  >
  > d = 10.0
  >
  > d2 = -11.0

* **static int max(int a, int b)**
  **static float max(float a, float b)**
  **static long max(long a, long b)**
  **static double max(double a, double b)**

  * 주어진 두 값을 비교하여 큰 쪽을 반환한다.

  ```java
  double d = Math.max(9.5, 9.50001);
  int i = Math.max(0, -1);
  ```

  > 결과:
  >
  > d = 9.50001
  >
  > i = 0

* **static int min(int a, int b)**
  **static float min(float a, float b)**
  **static long min(long a, long b)**
  **static double min(double a, double b)**

  * 주어진 두 값을 비교하여 작은쪽을 반환한다.

  ```java
  double d = Math.min(9.5, 9.50001);
  int i = Math.min(0, -1);
  ```

  > 결과: 
  >
  > d = 9.5
  >
  > i = -1

* **static double random()**

  * 0.0~1.0범위의 임의의 double값을 반환한다.
    0.0은 범위에 포함되지만, 1.0은 포함 안됨.

  ```java
  double d = Math.random();
  int i = (int)(Math.random()*10)+1
  ```

  > 결과:
  >
  > d = 0.0~1.0의 실수
  >
  > i = 1~10의 정수

* **static double rint(double a)**

  * 주어진 double값과 가장 가까운 정수값을 double형으로 반환한다.

  ```java
  double d = Math.rint(5.55);
  double d2 = Math.rint(5.11);
  double d3 = Math.rint(-5.55);
  double d4 = Math.rint(-5.11);
  ```

  > 결과:
  >
  > d = 6.0
  >
  > d2 = 5.0
  >
  > d3 = -6.0
  >
  > d4 = -5.0

* static long round(double a)
  static long round(float a)

  * 소수점 첫째자리에서 반올림한 정수값(long)을 반환한다.

  ```java
  long l = Math.round(5.55);
  long l2 = Math.round(5.11);
  long l3 = Math.round(-5.55);
  long l4 = Math.round(-5.11);
  double d = 90.7552;
  double d2 = Math.round(d*100)/100.0;
  ```

  > 결과:
  >
  > l = 6
  >
  > l2 = 5
  >
  > l3 = -6
  >
  > l4 = -5
  >
  > d = 90.7552
  >
  > d2 = 90.76



---



* Math의 메서드 예제:

  ```java
  import static java.lang.Math.*;
  import static java.lang.System.*;
  
  public class Ex9_13 {
  	public static void main(String[] args) {
  		double val = 90.7552;
  		out.println("round("+val+")"+round(val)); // 반올림
  		
  		val += 100;
  		out.println("round("+val+")"+round(val)); // 반올림
  		
  		out.println("round("+val+")/100"+round(val)/100); // 반올림
  		out.println("round("+val+")/100.0"+round(val)/100.0); // 반올림
  		out.println();
  		out.printf("ceil(%3.1f)=%3.1f%n", 1.1, ceil(1.1)); //올림 
  		out.printf("floor(%3.1f)=%3.1f%n", 1.5, floor(1.5)); //버림
  		out.printf("round(%3.1f)=%d%n", 1.1, round(1.1)); //반올림
  		out.printf("round(%3.1f)=%d%n", 1.5, round(1.5)); //반올림
  		out.printf("rint(%3.1f)=%f%n", 1.5, rint(1.5)); //반올림
  		out.printf("round(%3.1f)=%d%n", -1.5, round(-1.5)); //반올림
  		out.printf("rint(%3.1f)=%f%n", -1.5, rint(-1.5)); //반올림
  		out.printf("ceil(%3.1f)=%f%n", -1.5, ceil(-1.5)); //올림 
  		out.printf("floor(%3.1f)=%f%n", -1.5, floor(-1.5)); //버림
  	}
  }
  ```

  > 위 식의 결과:
  >
  > round(90.7552)91
  >
  > round(190.7552)191
  >
  > round(190.7552)/1001
  >
  > round(190.7552)/100.01.91
  >
  > 
  >
  > ceil(1.1)=2.0
  >
  > floor(1.5)=1.0
  >
  > round(1.1)=1
  >
  > round(1.5)=2
  >
  > rint(1.5)=2.000000
  >
  > round(-1.5)=-1
  >
  > rint(-1.5)=-2.000000
  >
  > ceil(-1.5)=-1.000000
  >
  > floor(-1.5)=-2.000000

  * rint()도 round()처럼 소수점 첫 째 자리에서 반올림하지만, 반환값이 doule이다.

    > out.printf("round(%3.1f)=%d%n", 1.5, round(1.5)); //반환 값이 int
    > out.printf("rint(%3.1f)=%f%n", 1.5, rint(1.5)); //반환 값이 double

  * 음수를 반올림 할 때, round(-1.5) 의 결과는 -2가 아니라 -1이다. 항상 가장 가까운 큰 정수로 반올림 하기 때문.
    rint()도 가장 가까운 정수로 반올림 하지만, 1.5와 같이 두 정수의 정가운데 있는 값은 짝수 정수를 결과로 반환 함.

    > out.printf("round(%3.1f)=%d%n", -1.5, round(-1.5)); //-1
    > out.printf("rint(%3.1f)=%f%n", -1.5, rint(-1.5)); //-2.0

  * 음수에서는 양수와 달리 -1.5를 버림(floor)하면 -2.0이 된다.

    > out.printf("ceil(%3.1f)=%f%n", -1.5, ceil(-1.5)); //-1.0
    > out.printf("floor(%3.1f)=%f%n", -1.5, floor(-1.5)); //-2.0



## 08. 래퍼(wrapper)클래스

* 때로는 기본형(primitive type)변수도 어쩔 수 없이 객체로 다뤄야 하는 경우엔 기본형 값들을 객체로 변환하여 작업을 수행해야 한다.

  > 매개변수로 객체를 요구할 때, 기본형 값이 아닌 객체로 저장해야할 때, 객체간의 비교가 필요할 때 등등

  이 때 사용 되는 것이 래퍼(wrapper)클래스.
  9개의 기본형을 대표하는 8개의 래퍼클래스가 있는데, 이 클래스들을 이용하면 기본형 값을 객체로 다룰 수 있음.

  ```java
  public final class Integer extends Number implements Comparable {
    ...
      private int value;
    ...
  }
  ```

* 래퍼 클래스들은 객체 생성 시에 생성자의 인자로 주어진 각 자료형에 알맞은 값을 내부적으로 저장하고 있음.

* 래퍼클래스의 메서드:
  
| 기본형  | 래퍼클래스 | 생성자                                                       | 활용예                                                       |
  | ------- | ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | boolean | Boolean    | Boolean(boolean value)<br />Boolean(String s)                | Boolean b = new Boolean(true);<br />Boolean b2 = new Boolean("true"); |
  | char    | Character  | Character(char vlaue)                                        | Character c = new Character('a');                            |
  | byte    | Byte       | Byte(byte value)<br />Byte(String s)                         | Byte b = new Byte(10);<br />Byte b2 = new Byte("10");        |
  | short   | Short      | Short(short value)<br />Short(String s)                      | Short s = new Short(10);<br />Short s2 = new Short("10");    |
  | int     | Integer    | Integer(int value)<br />Integer(String s)                    | Integer i = new Integer(100);<br />Integer i2 = new Integer("100"); |
  | long    | Long       | Long(long value)<br />Long(String s)                         | Long l = new Long(100);<br />Long l2 = new Long("100");      |
  | float   | Float      | Float(double value)<br />Float(float value)<br />Float(String s) | Float f = new Float(1.0);<br />Float f2 = new Float(1.0f);<br />Float f3 = new Float("1.0f"); |
  | double  | Double     | Double(double value)<br />Double(String s)                   | Double d = new Double(1.0);<br />Double d2 = new Double("1.0"); |
  
* 래퍼 클래스의 생성자는 매개변수로 문자열이나 각 자료형의 값들을 인자로 받음.

* 주의해야할 것: 생성자의 매개변수로 문자열을 제공할 때, 각 자료형에 알맞은 문자열을 사용해야함.



* 예제:

  ```java
  public class Ex9_14 {
  	public static void main(String[] args) {
  		Integer i = new Integer(100);
  		Integer i2= new Integer(100);
  		
  		System.out.println("i==i2 ?" + (i==i2));
  		System.out.println("i.equals(i2) ?" + i.equals(i2));
  		System.out.println("i.compareTo(i2)="+i.compareTo(i2));
  		System.out.println("i.toString()="+i.toString());
  		
  		System.out.println("MAX_VALUE="+Integer.MAX_VALUE);
  		System.out.println("MIN_VALUE="+Integer.MIN_VALUE);
  		System.out.println("SIZE="+Integer.SIZE+"bits");
  		System.out.println("BYTES="+Integer.BYTES+"bytes");
  		System.out.println("TYPE="+Integer.TYPE);
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > i==i2 ?false
  >
  > i.equals(i2) ?true
  >
  > i.compareTo(i2)=0
  >
  > i.toString()=100
  >
  > MAX_VALUE=2147483647
  >
  > MIN_VALUE=-2147483648
  >
  > SIZE=32bits
  >
  > BYTES=4bytes
  >
  > TYPE=int

* 래퍼 클래스들은 모두 equals()가 오버라이딩 되어 있어서 주소값이 아닌 객체가 가지고 있는 값을 비교한다.
  오토박싱이 된다고 해도 Integer객체에 비교연산자를 사용할 수 없다. (대신 compareTo())를 제공한다.

* toString()도 오버라이딩되어 있어서 객체가 가지고있는 값을 문자열로 변환하여 반환한다.

* 래퍼 클래스들은 MAX_VALUE, MIN_VALUE, SIZE, BYTES, TYPE등의 static상수를 공통적으로 가지고 있다.



## 09. Number클래스

* 이 클래스는 추상클래스로 내부적으로 숫자를 멤버변수로 갖는 래퍼 클래스들의 조상이다/

* 래퍼 클래스의 상속계층도를 보면, 기본형 중에서 숫자와 관련된 래퍼 클래스들은 모두 Number클래스의 자손이라는 것을 알 수 있다.

  ![image-20200922175557220](https://user-images.githubusercontent.com/69128652/95006183-7e32e080-063c-11eb-90b0-ced9c1b0be12.png)

* Number클래스 자손으로 BigInteger와 BigDecimal 등이 있는데, BigInteger는 long으로도 다룰 수 없는 큰 범위의 정수를, BigDecimal은 double로도 다룰 수 없는 큰 범위의 부동 소수점수를 처리하기 위한 것으로 연산자의 역할을 대신하는 다양한 메서드를 제공.

* Number클래스의 실제 소스는 아래와 같다.
  객체가 가지고 있는 값을 숫자와 관련된 기본형으로 변환하여 반환하는 메서드들을 정의하고 있다.

  ```java
  public abstract class Number implements java.io.Serializable {
    public abstract int intValue();
    public abstract long longValue();
    public abstract float floatValue();
    public abstract double doubleValue();
    
    public byte byteValue() {
      return (byte)intValue();
    }
    
    public short shortValue() {
      return (short)intValue();
    }
  }
  ```

  

## 10. 문자열을 숫자로 변환하기

* 문자열을 숫자로 변환하는 다양한 방법:

  ```java
  int i = new Integer("100").intValue(); // floatValue(),longValue(), ...
  int i2 = Integer.parseInt("100"); 	   // 주로 이 방법을 많이 사용.
  Integer i3 = Integer.valueOf("100");
  ```

* 래퍼클래스의 '타입.parse타입 (String s)'형식의 메서드와 '타입.valueOf()'메서드를 정리한 것.
  둘 다 문자를 숫자로 바꿔주는 일을 하지만, 전자는 반환값이 기본형(primaitive type)이고
  후자는 반환값이 래퍼클래스 타입이라는 차이가 있다.

  | 문자열 -> 기본형                                             | 문자열 -> 래퍼 클래스                                        |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | byte b = Byte.parseByte("100");<br />short s = Short.parseShort("100");<br />int i = Int.parseInt("100");<br />long l = Long.parseLong("100");<br />float f = Float.parseFolat("3.14");<br />double d = Double.parseDouble("3.14"); | Byte b = Byte.valueOf("100");<br />Short s = Short.valueOf("100");<br />Int i = Int.valueOf("100");<br />Long l = Long.valueOf("100");<br />Float f = Float.valueOf("3.14");<br />Double d = Double.valueOf("3.14"); |

* 문자열이 10진수가 아닌 다른 진법(radix)의 숫자일 때도 변환이 가능하도록 다음과 같은 메서드가 제공.

  ```java
  static int parseInt(String s, int radix) // 문자열 s를 radix진법으로 인식
  static Integer valueOf(String s, int radix)
  ```

* 문자열 "100"이 2진법의 숫자라면 10진수로 4이고, 8진법의 숫자라면 10진수로 64이고, 16진법의 숫자라면 10진수로 256이 된다.
  참고로 2진수 100은 100(2)와 같이 표기함.

  ```java
  int i4 = Integer.parseInt("100",2); // 100(2) -> 4
  int i5 = Integer.parseInt("100",8); // 100(8) -> 64
  int i6 = Integer.parseInt("100",16); // 100(16) -> 256
  int i7 = Integer.parseInt("FF",16); // FF(16) -> 255
  // int i8 = Integer.parseInt("FF"); // NumberFormatException발생
  ```

  * 16진법에서는 'A~F'의 문자도 허용 하지만, 진법을 생략하면 10진수로 간주하기 때문에 오류가 발생.

* 예제:

  ```java
  public class Ex9_15 {
  	public static void main(String[] args) {
  		int i = new Integer("100").intValue();
  		int i2 = Integer.parseInt("100");
  		Integer i3 = Integer.valueOf("100");
  				
  		int i4 = Integer.parseInt("100",2);
  		int i5 = Integer.parseInt("100",8);
  		int i6 = Integer.parseInt("100",16);
  		int i7 = Integer.parseInt("FF",16); 
  		// int i8 = Integer.parseInt("FF"); // NumberFormatException발생
  		
  		int i9 = Integer.valueOf("100",2);
  		int i10 = Integer.valueOf("100",8);
  		int i11 = Integer.valueOf("100",16);
  		int i12 = Integer.valueOf("FF",16); 
  		// int i13 = Integer.valueOf("FF"); // NumberFormatException발생
  		
  		System.out.println(i);
  		System.out.println(i2);
  		System.out.println(i3);
  		System.out.println("100(2)->"+i4);
  		System.out.println("100(8)->"+i5);
  		System.out.println("100(16)->"+i6);
  		System.out.println("FF(16)->"+i7);
  		
  		
  		System.out.println("100(2)->"+i9);
  		System.out.println("100(8)->"+i10);
  		System.out.println("100(16)->"+i11);
  		System.out.println("FF(16)->"+i12);
  	}
  }
  ```

  > 위 코드의 결과:
  >
  > 100
  >
  > 100
  >
  > 100
  >
  > 100(2)->4
  >
  > 100(8)->64
  >
  > 100(16)->256
  >
  > FF(16)->255
  >
  > 100(2)->4
  >
  > 100(8)->64
  >
  > 100(16)->256
  >
  > FF(16)->255



## 11. 오토박싱 & 언박싱

* JDK1.5이전에는 기본형과 참조형 간의 연산이 불가능 했기 때문에, 래퍼클래스로 기본형을 객체로 만들어 연산해야 했음.

  ```java
  int i = 5;
  Integer iObj = new Integer(7);
  
  int sum = i+ iObj; // 에러. 기본형과 참조형 간의 덧셈 불가(JDK1.5이전.)
  ```

* 그러나 이제는 컴파일러가 자동으로 변환하는 코드를 넣어주기 때문에 기본형과 참조형 간의 덧셈이 가능하다.

* 아래의 경우, 컴파일러가 Integer객체를 int타입의 값으로 변환해주는 intValue()를 추가해준다.

  | 컴파일 전의 코드                                             | 컴파일 후의 코드                                             |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | int i = 5;<br/>Integer iObj = new Integer(7);<br/><br/>int sum = i+ iObj; | int i = 5;<br/>Integer iObj = new Integer(7);<br/><br/>int sum = i+ iObj.intValue(); |

* 이외에도 내부적으로 객체 배열을 가지고 있는 Vector 클래스나 ArrayList클래스에 기본형 값을 저장해야할 때나 형변환이 필요할 때도 컴파일러가 자동적으로 코드를 추가함.

* 오토박싱(autoboxing) :기본형 값을 래퍼클래스의 객체로 변환해 주는 것 

  언박싱(unboxig) : 래퍼클래스의 값을 기본형 객체로 변환해 주는 것.

  ```java
  ArrayList<Integer> list = new ArrayList<Integer>();
  list.add(10); 			  		//오토박싱. 10 -> new Integer(10)
  
  int value = list.get(0); // 언박싱. new Integer(10) ->10
  ```

  * ArrayList에 숫자를 저장하거나 꺼낼 때, 기본형 값을 래퍼 클래스의 객체로 변환하지 않아도 되므로 편리.
    

* 예제: 오토박싱을 이용해서 기본형과 참조형 간의 형변환과 연산을 수행하는 예

  ```java
  public class Ex9_16 {
  	public static void main(String[] args) {
  		int i=10;
  		
  		
  		Integer intg = (Integer)i; // Integer intg = Integer.valueOf(i);
  		Object obj = (Object)i; // Object obj = (Object)Integer.valueOf(i);
  		
  		Long lng = 100L; // Long lng = new Long (100L);
  		
  		int i2 = intg + 10;
  		long l = intg + lng;
  		
  		Integer intg2=new Integer(20);
  		int i3 = (int)intg2;
  		
  		Integer intg3 = intg2+i3;
  		
  		System.out.println("i ="+i);
  		System.out.println("intg ="+intg);
  		System.out.println("obj ="+obj);
  		System.out.println("lng ="+lng);
  		System.out.println("intg + 10 ="+i2);
  		System.out.println("intg + lng ="+l);
  		System.out.println("intg2 ="+intg2);
  		System.out.println("i3 ="+i3);
  		System.out.println("intg2+ i3 ="+intg3);
  		}
  }
  ```

  > 위 코드의 식:
  >
  > i =10
  >
  > intg =10
  >
  > obj =10
  >
  > lng =100
  >
  > intg + 10 =20
  >
  > intg + lng =110
  >
  > intg2 =20
  >
  > i3 =20
  >
  > intg2+ i3 =40

  * 위의 예제는 생성자가 없는 클래스에 기본 생성자가 자동으로 추가되듯이, 개발자가 간략하게 쓴 구문을 컴파일러가 원래의 구문으로 변경해 주는 것.

    | 컴파일 전의 코드                                             | 컴파일 후의 코드                                             |
    | ------------------------------------------------------------ | ------------------------------------------------------------ |
    | Integer intg = (Integer)i;<br />Object obj = (Object)i;<br />Long lng = 100L; | Integer intg = Integer.valueOf(i);<br />Object obj = (Object)Integer.valueOf(i);<br />Long lng = new Long(100L); |

    
