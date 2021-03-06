# Chapter 12.

## 01. 지네릭스(Generics)

* 지네릭스:

  * **다양한 타입**의 객체들을 다루는 **메서드**나, **컬렉션 클래스**에 컴파일 시 타입 체크(compile - time type check) 를 해주는 기능.

    객체의 타입 안전성을 높이고 형변환의 번거로움이 줄어듬.

  * ex) ArrayList를 생성할 때, 저장할 객체의 타입을 지정하여, 다른 객체를 저장하려 시도할 경우 에러가 발생하도록 함.

    ```java
    ArrayList<Tv> tvList = new ArrayList<Tv>();
    
    tvList.add(new Tv());		 // OK
    tvList.add(new Audio()); // 컴파일 에러. Tv외의 다른 타입 저장 불가.
    ```

  * 이미 어떤 객체를 저장할 것인지 지정을 해두었기 때문에, 저장된 객체를 꺼낼 때 형변환 할 필요가 없어 편리함.

    ```java
    // 원본
    ArrayList tvList = new ArrayList();
    tvList.add(new Tv());
    Tv t = (Tv)tvList.get(0);
    ```

    ```java
    // 지네릭스 적용 코드
    ArrayList<Tv> tvList = new ArrayList<Tv>();
    tvList.add(new Tv());
    Tv t = tvList.get(0); // 형변환 불필요.
    ```

  * 장점:

    1. 타입 안전성을 제공.

       > 의도하지않은 타입의 객체 저장을막고, 꺼내올 때 원래의 타입과 다른 타입으로 형변환 되어 발생할 수 있는 오류 감축.

    2. 타입 체크와 형변환을 생략할 수 있으므로, 코드가 간결해짐.

### 1. 타입 변수

* ArrayList클래스의 선언에서 '<>'안에 있는 E를 **'타입 변수(type variable)'** 라 한다.

  일반적으로 'Type'의 첫 글자를 따서 T를 사용한다.

* 반드시 'T' 를 사용해야 하는 것은 아니며, 'Element(요소)'의 첫 글자를 따서 E를 사용해도 된다.
  이들은 실제로 이 값을 사용하는 것이 아닌, 임의의 참조형 타입으로, 실 사용 시 실제의 타입을 대입하면 된다.

* ex)

  ```java
  public class ArrayList<E> extends AbstructList<E> { // 일부 생략
    private transient E[] elementData;
    public boolean add(E o) { /* 내용 생략 */ }
    public E get(int index) { /* 내용 생략 */ }
  }
  ```

* 타입 변수가 여러개일 경우, Map<K, V>와 같이 콤마','를 구분자로 나열하면 된다.
  K는 키(key), V는 값(value)를 의미한다. 이 또한 위처럼 '임의의 참조형 타입'을 의미한다.



* 타입 변수에 대입하기:
   `ArrayList<Tv> list = new ArrayList<Tv>();`

  * 위에서 설명한 타입 변수 E대신 지정된 타입 Tv를 **'대입된 타입(parameterized type)'**이라 한다.

  * 타입이 대입되고 나면, ArrayList의 선언에 포함된 타입 변수 E가 아래와 같이 지정된 타입으로 바뀐다.

    ```java
    public class ArrayList extends AbstructList { // 일부 생략
      private transient Tv[] elementData;
      public boolean add(Tv o) { /* 내용 생략 */ }
      public Tv get(int index) { /* 내용 생략 */ }
    }
    ```



### 2. 지네릭스 용어

* `class Box<T> {}`

  * `Box<T>` : 지네릭 틀래스. 'T의 Box' 또는 'T Box'라고 읽는다.

  * `T` : 타입 변수 또는 타입 매개변수. (T는 타입 문자)

    > 메서드의 매개변수와 유사한 면이 있기 때문에 이러하게 부른다.
    >
    > * 때문에, 아래와 같이 타입 매개변수에 타입을 지정하는 것을 **'지네릭 타입 호출'** 이라고 하고,
    > * 지정된 타입 'String'과 같은 것을 **'매개변수화된 타입(parameterized type)'** 이라고 한다.
    >   이는 너무 길기 때문에, '대입된 타입'이라고도 부른다.
    >
    > ![스크린샷 2020-12-29 오후 6 27 14](https://user-images.githubusercontent.com/69128652/103273787-7ac4b080-4a03-11eb-88eb-6e72709301c7.png)
    >
    > * 컴파일이 된 후에는`Box<String>` , `Box<Integer>` 이었던 것이
    >    '원시타입'인 Box로 바뀌어, 지네릭 타입이 제거된다.

  * `Box` : 원시 타입(raw type)



### 3. 지네릭 타입과 다형성

* 지네릭 클래스의 객체 생성 시, 참조변수에 지정해준 지네릭 타입과 생성자에 지정한 지네릭 타입은 일치해야한다.
  서로 상속관계에 있어도 이는 허용되지 않음.

  ```java
  ArrayList<Tv> 		 list = new ArrayList<Tv>(); // OK. 일치
  ArrayList<Product> list = new ArrayList<Tv>(); // 에러. 불일치
  				...
  class Product{ }
  class Tv extends Product{ }
  class Audio extends Product{ }
  ```

* 지네릭 타입이 아닌, 클래스의 타입간에 다형성을 적용하는 것은 가능하다.
  단, 이 때도 지네릭 타입은 일치해야함.

  ```java
  List<Tv> list = new ArrayList<Tv>();	// Ok. 다형성. ArrayList가 List를 구현.
  List<Tv> list = new LinkedList<Tv>(); // Ok. 다형성. LinkedList가 List를 구현.
  ```

* ArrayList에 Product의 자손 객체만 저장하고 싶다면, 지네릭 타입이 Product인 ArrayList를 생성 후, Product인 ArrayList를 생성 후, 이 ArrayList에 자손인 Tv와 Audio의 객체를 저장하면 된다.

  ```java
  ArrayList<Product> list = new ArrayList<product>();
  list.add(new Product());
  list.add(new Tv());
  list.add(new Audio());
  ```

  * 대신 저장된 객체를 꺼낼 때, 형변환이 필요.

    ```java
    Product p = list.get(0); // Product객체는 형변환이 필요없다.
    Tv t = (Tv)list.get(1);  // Product의 자손 객체들은 형변환을 필요로한다.
    ```



* 예제:
  다형성 예제

  ```java
  import java.util.*;
  
  class Product{ }
  class Tv extends Product { }
  class Audio extends Product { }
  
  public class Ex12_1 {
      public static void main(String[] args) {
          ArrayList<Product> productList = new ArrayList<Product>();
          ArrayList<Tv>      tvList = new ArrayList<Tv>();
  //        ArrayList<Product>      tvList = new ArrayList<Tv>(); // 에러
  //        List<Tv>      tvList = new ArrayList<Tv>();           // Ok. 다형성
          
          productList.add(new Tv());
          productList.add(new Audio());
          
          tvList.add(new Tv());
          tvList.add(new Tv());
          
          printAll(productList);
          // printAll(tvList); // 컴파일 에러가 발생한다.
      }
      
      public static void printAll(ArrayList<Product> list){
          for(Product p : list)
              System.out.println(p);
      }
  }
  ```

  > 위 코드의 결과:
  > Tv@29453f44
  > Audio@5cad8086



---

### 4. Iterator< E >

* Iterator에도 지네릭스가 적용되어있다.
  지네릭스가 도입 되며, 기존의 소스에 Object가 들어간 클래스는 전부 이런식으로 바뀌었다고 보면 된다.

  ```java
  public interface Iterator<E> {
    boolean hashNext();
    E next();
    void remove();
  }
  ```

* 예제:

  Iterator에 지네릭스를 적용한 예.

  ```java
  import java.util.*;
  
  public class Ex12_2 {
      public static void main(String[] args) {
         ArrayList<Student> list = new ArrayList<Student>();
         list.add(new Student("자바왕", 1, 1));
         list.add(new Student("자바왕", 1, 2));
         list.add(new Student("자바왕", 2, 1));
         
         Iterator<Student> it = list.iterator();
         while (it.hasNext()){
             // Student s = (Student)it.next(); // 지네릭스 사용하지 않으면 형변환 필요.
             Student s = it.next();
             System.out.println(s.name);
         }
      }
  }
  
  class Student {
      String name = "";
      int ban;
      int no;
  
      Student(String name, int ban, int no){
          this.name = name;
          this.ban = ban;
          this.no = no;
      }
  }
  ```

  > 결과:
  > 자바왕
  > 자바짱
  > 홍길동

  

---

### 5. HashMap<K, V>

* HashMap처럼 데이터를 키(Key), 값(Value)의 형태로 저장하는 컬렉션 클래스는 지정해 줘야 할 타입이 두 개이다.

  때문에 콤마',' 로 구분해서 적어줘야한다.

  * 위의 K, V도 임의의 참조형 타입(refernce type)이다.

  ```java
  public class HashMap<K, V> extends AbstructMap<K,V> { //일부 생략
    		...
  	public V get(Object key){ /* 내용 생략 */ }
    public V put(K key, V value){ /* 내용 생략 */ }
    public V remove(Object key) { /* 내용 생략 */ }
    		...  
  }
  ```

* 키의 타입이 String이고 저장할 값의 타입이 Student인 HashMap을 생성하려면 다음과 같이 하면 된다.

  ```java
  HashMap<String, Student> map = new HashMap<String, Student>(); // 생성
  map.put("자바왕", new Student("자바왕", 1,1,100,100,100)) // 데이터 저장
  ```

  * 위와 같이 제작이 되었다면, 실제 소스는 'K' 대신 String, 'V'대신 Student가 사용되어 이런 식으로 변하게 된다.

    ```java
    public class HashMap extends AbstructMap { //일부 생략
      		...
    	public Student get(Object key){ /* 내용 생략 */ }
      public Student put(String key, String value){ /* 내용 생략 */ }
      public Student remove(Object key) { /* 내용 생략 */ }
      		...  
    }
    ```

* 이 또한, 값을 꺼내오는 get(Object key)를 사용 할 때나, 저장된 키와 값을 꺼내오는 keySet(), values()를 사용할 때 형변환 하지 않아도 됨.



---

### 6. 제한된 지네릭 클래스

* 타입 매개변수 T에 지정할 수 있는 타입의 종류를 제한 하기 위해, 
  지네릭 타입에 'extends'를 사용하여 특정 타입의 자손들만 대입할 수 있게 만들 수 있다.

  ```java
  FruitBox<Toy> fruitBox = new FruitBox<Toy>();
  fruitBox.add(new Toy());
  ```

  ⬇️

  ```java
  class FruitBox<T extends Fruit> {
    ArrayList<T> list = new ArrayList<T>();
    ...
  }
  ```

  * 한 종류의 타입만 담을 수 있지만, Fruit클래스의 자손들만 담을 수 있다는 제한이 추가된 것.

    ```java
    FruitBox<Apple> appleBox = new FruitBox<Apple>(); //OK
    FruitBox<Toy>   toyBox = new FruitBox<Toy>(); //에러. Toy는 Fruit의 자손이 아님.
    ```

* 만일 클래스가 아닌 인터페이스를 구현해야한다는 제약이 필요하다면, 이 때도 'extends'를 사용한다.
  'implements'를 사용하지 않는다는 점에 주의하자.

  ```java
  interface Eatable {}
  class FruitBox<T extends Eatable> { ... }
  ```

  * Fruit의 자손이면서, Eatable 인터페이스도 구현해야 할 경우:

    ```java
    class FruitBox<T extends Fruit & Eatable> { ... }
    ```

* 예제:

  ```java
  import java.util.ArrayList;
  
  class Fruit implements Eatable {
      public String toString() { return "Fruit";}
  }
  class Apple extends Fruit {
      public String toString() { return "Apple";}
  }
  class Grape extends Fruit {
      public String toString() { return "Grape";}
  }
  class Toy extends Fruit {
      public String toString() { return "Toy";}
  }
  
  interface Eatable{ }
  
  public class Ex12_3 {
      public static void main(String[] args) {
          FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
          FruitBox<Apple> appleBox = new FruitBox<Apple>();
          FruitBox<Grape> grapeBox = new FruitBox<Grape>();
  //        FruitBox<Grape> grapeBox = new FruitBox<Apple>(); // 에러. 타입 불일치
  //        FruitBox<Toy> toyBox = new FruitBox<Toy>();       // 에러.
  
          fruitBox.add(new Fruit());
          fruitBox.add(new Apple());
          fruitBox.add(new Grape());
          appleBox.add(new Apple());
  //        appleBox.add(new Grape()); // 에러. Grape는 Apple의 자손이 아님.
          grapeBox.add(new Grape());
  
          System.out.println("fruitBox - "+ fruitBox);
          System.out.println("appleBox - "+ appleBox);
          System.out.println("grapeBox - "+ grapeBox);
      }
  }
  
  class FruitBox<T extends Fruit & Eatable> extends Box<T> {}
  
  class Box<T>{
      ArrayList<T>list = new ArrayList<T>();
      void add(T item) {
          list.add(item);
      }
      T get(int i){
          return list.get(i);
      }
      int size() {
          return list.size();
      }
      public String toString() {
          return list.toString();
      }
  }
  ```

  > 위 코드의 결과:
  > fruitBox - [Fruit, Apple, Grape]
  > appleBox - [Apple]
  > grapeBox - [Grape]

* **지네릭스의 제약**

  * 위처럼, Box의 객체를 생성 시, 객체별로 다른 타입을 지정하는 것은 적절하지만, 
    모든 객체에 동일하게 동작해야하는 static멤버에 타입변수 T를 사용하는 것은 적절하지 않다.

    > T는 인스턴스 변수로 간주되기 때문에, static 멤버는 인스턴스 변수를 참조할 수 없다.

    ```java
    class Box<T>{
      static T item; // 에러
      static int compare(T t1, T t2){...} // 에러
      ...
    }
    ```

  * static 멤버는 타입 변수에 대입된 타입의 종류에 관계없이 동일한 것이어야 한다.

    > 'Box<Apple>.item'과 'Box<Grape>.item'이 다른것이면 안된다.

  * 지네릭 타입의 배열을 생성하는 것이 불가능 하다.
    정확히는 지네릭 배열 타입의 **참조변수를 선언**하는 것은 **가능**하지만, 'new T[10]'과 같이 **배열을 생성하는 것은 안된다.**

    ```java
    class Box<T>{
     T[] itemArr; // OK. T타입의 배열을 위한 참조변수
      ...
     T[] toArray(){
        T[] tmpArr = new T[itemArr.length]; // 에러. 지네릭 배열 생성 불가.
        ...
        return tmpArr;
      }
      		...
    }
    ```

    > 배열을 생성하지 못하는 이유는 연산자 new 때문이다.
    > 컴파일 시점에 타입 T가 무엇인지 정확히 알아야 하는데, 컴파일 시점에서 T가 어떤 타입이 될지는 모르기 때문.
    >
    >
    > instanceof연산자도 new연산자와 같은 이유로 T를 피연산자로 사용할 수 없다.



### 7. 와일드 카드

* 지네릭 클래스 생성 시, 참조변수에 지정된 지네릭 타입과 생성자에 지정된 지네릭 타입은 일치해야하는데, (3번 참조)
  지네릭 타입에 다형성을 적용하고 싶다면, '와일드 카드'를 사용하면 된다.

  * 와일드 카드는 기호 **'?'를 사용**하며, **'extends'**와 **'super'**로 상한(upper bound)과 하한(lower bound)을 제한 할 수 있다.

    | 종류          | 설명                                                    |
    | ------------- | ------------------------------------------------------- |
    | <? extends T> | 와일드 카드의 상한제한. T와 그 자손들만 가능            |
    | <? super T>   | 와일드 카드의 하한제한. T와 그 조상들만 가능            |
    | <?>           | 제한 없음. 모든 타입이 가능. <? extends Object>와 동일. |

* 와일드 카드 이용 시, 다음과 같이 하나의 참조변수로 다른 지네릭타입이 지정된 객체를 다룰 수 있음.
  (Tv와 Audio가 Product의 자손이라고 가정.)

  ```java
  // 지네릭 타입이 <? extends Product> 이면, Product와 Product의 모든 자손이 OK
  ArrayList<? extends Product> list = new ArrayList<Tv>(); // OK
  ArrayList<? extends Product> list = new ArrayList<Audio>(); // OK
  ```

* 메서드의 매개 변수에 적용 하면,

  ```java
  static Juice makeJuice(FruitBox<? extends Fruit> box){
    String tmp = "";
    for(Fruit f : box.getList()) tmp += f + " ";
    return new Juice(tmp);
  }
  ```

  다음과 같이 지네릭 타입이 다른 객체를 매개 변수로 지정할 수 있다.

  ```java
  System.out.println(Juicer.makeJuice(new FruitBox<Fruit>())); // OK
  System.out.println(Juicer.makeJuice(new FruitBox<Apple>();)); // OK
  ```

* 예제: 

  ```java
  import java.util.ArrayList;
  
  class Fruit2 {
      public String toString() { return "Fruit";}
  }
  class Apple2 extends Fruit2 {
      public String toString() { return "Apple";}
  }
  class Grape2 extends Fruit2 {
      public String toString() { return "Grape";}
  }
  
  class Juice{
      String name;
  
      Juice(String name) {
          this.name = name + "Juice";
      }
  
      public String toString(){
          return name;
      }
  }
  
  class Juicer {
      static Juice makeJuice(FruitBox2<? extends Fruit2> box){
          String tmp = "";
  
          for(Fruit2 f : box.getList())
              tmp += f + " ";
          return new Juice(tmp);
      }
  }
  public class Ex12_4 {
      public static void main(String[] args) {
          FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
          FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>();
  
          fruitBox.add(new Apple2());
          fruitBox.add(new Grape2());
          appleBox.add(new Apple2());
          appleBox.add(new Apple2());
  
          System.out.println(Juicer.makeJuice(fruitBox));
          System.out.println(Juicer.makeJuice(appleBox));
      }
  }
  
  class FruitBox2<T extends Fruit2> extends Box2<T>{}
  class Box2<T> {
      ArrayList<T> list = new ArrayList<T>();
      void add(T item) {
          list.add(item);
      }
      T get(int i){
          return list.get(i);
      }
      ArrayList<T> getList() {
          return list;
      }
      int size() {
          return list.size();
      }
      public String toString() {
          return list.toString();
      }
  }
  ```

  > 위 식의 결과:
  > Apple Grape Juice
  > Apple Apple Juice





---

### 8. 지네릭 메서드

* 메서드의 선언부에 지네릭 타입이 선언된 메서드를 **지네릭 메서드**라 한다.

* Collcetions.sort()가 지네릭 메서드 이며, 지네릭 타입의 선언위치는 **반환타입 바로 앞**이다.

  ```java
  static <T> void sort(List<T> list, Comparator<? super T> c)
  ```

  * 여기에 있는 <T>의 경우, 클래스에 정의된 타입 매개변수와 같아보이지만, 별개의 것이다.
    같은 타입 문자 T를 사용해도 같은 것이 아니라는 것에 주의 하자.

* 지네릭클래스가 아닌 클래스에도 지네릭 메서드를 정의 할 수 있다.

  ```java
  class FruitBox<T> {
    ...
    static <T> void sort(List<T> list, Comparator<? super T> c)
  }
  ```

  * 위의 경우, FruitBox<T>의 T와 sort 내의 List<T>는 문자만 같고 서로 다른 것.
  * 앞서 static멤버에는 타입 매개변수를 사용 할수 없다 하였지만,
    위 처럼 메서드에 지네릭 타입을 선언하고 사용하는 것은 가능하다.



* 메서드에 선언된 지네릭 타입 == 지역변수를 선언한것
  이라고 생각하면 이해하기가 쉽다.

  이 타입 매개변수는 메서드 내에서만 **지역적으로 사용**될 것이므로, 메서드가 static이어도 괜찮은것이다.



* 위의 예제에서 makeJuice()를 

  ```java
  class Juicer {
      static Juice makeJuice(FruitBox2<? extends Fruit2> box){
          String tmp = "";
  
          for(Fruit2 f : box.getList())
              tmp += f + " ";
          return new Juice(tmp);
      }
  }
```
  

  
  지네릭 메서드로 바꾼 예제:
  
  ```java
class Juicer {
      static <T extends Fruit> Juice makeJuice(FruitBox2<T> box){
        String tmp = "";
  
        for(Fruit2 f : box.getList())
              tmp += f + " ";
        return new Juice(tmp);
      }
  ```
  
  * 이러한 메서드 호출 시, 타입 변수에 타입을 대입해야한다.
  
    ```java
    System.out.println(Juicer.<Fruit2>makeJuice(fruitBox));
    System.out.println(Juicer.<Apple2>makeJuice(appleBox));
    ```
  
    그렇지만 대부분의 경우, 컴파일러가 대입된 타입을 선언부를 통해 추정할 수 있기 때문에 생략해도 된다.
  
    
  
  * 다만, 지네릭 메서드 호출 시, 대입된 타입을 생략할 수 없는 경우에 참조변수나 클래스의 이름을 생략할 수 없음.
  
    ```java
    System.out.println(<Fruit2>makeJuice(fruitBox)); // 에러. 클래스 이름 생략 불가.
    System.out.println(this.<Fruit2>makeJuice(fruitBox)); //OK
    System.out.println(Juicer.<Fruit2>makeJuice(fruitBox));//OK
    ```



### 9. 지네릭 타입의 형변환

* 지네릭 타입 -> 원시 타입 (primitive type)간의 형변환은 경고가 발생하지만, 형변환이 가능하다.

  ```java
  Box box = null;
  Box<Object> objBox = null;
  
  box = (Box)objBox;         // OK.지네릭타입 > 원시 타입. 경고발생
  objBox = (Box<Object>)box; // OK.원시 타입 > 지네릭타입. 경고발생
  ```

  

* 지네릭타입이 다른 경우엔 형변환이 불가능(대입된 타입이 Object여도 불가능.) 한게 일반적이지만,

  ```java
  Box<String> strBox = null;
  Box<Object> objBox = null;
  
  strBox = (Box<String>)objBox; // 에러.
  objBox = (Box<Object>)strBox; // 에러.
  ```

  만일 와일드 카드 사용 시 형변환을 할 수 있다.

  ```java
  Box<? extends Object> wBox = new Box<String>();
  
  static Juice makeJuice(FruitBox<? extends Fruit> box){...}
  FruitBox<? extends Fruit> fruitBox = new FruitBox<Fruit>();
  FruitBox<? extends Fruit> appleBox = new FruitBox<Apple>();
  ```



### 10. 지네릭 타입의 제거

* 지네릭이 도입 되기 이전의 소스코드와 호환성 유지를 위해,

  1. 컴파일러는 지네릭 타입을 이용해 소스파일을 체크
  2. 필요한 곳에 형변환을 넣음.
  3. 지네릭 타입을 제거함.

  위와 같은 과정을 거쳐, 컴파일이 된 이후의 파일(.class)에는 지네릭 타입에 대한 정보를 없도록 만든다.



* 제거 과정은 복잡하기 때문에, 기본적인 과정만 알아보자.

  1. **지네릭 타입의 경계(bound)를 제거한다.**

     * 지네릭 타입이 <T extends Fruit> 라면, T는 Fruit로 치환됨.
       <T>의 경우 T는 Object로 치환됨.

     * 이후 지네릭 타입 선언 제거.

       ```java
       class Box<T extends Fruit> {
         void add(T t){
           ...
         }
       }
       ```

       ⬇️

       ```java
       class Box {
         void add(Fruit t){
           ...
         }
       }
       ```

       

  2. **지네릭 타입을 제거 후, 타입이 일치하지 않다면 형변환 추가.**

     * List의 get()은 Object타입을 반환하므로 형변환 필요.

       ```java
       T get(int i){
         return list.get(i);
       }
       ```

       ⬇️

       ```java
       Fruit get(int i){
         return (Fruit)list.get(i);
       }
       ```

       

     * 와일드 카드 포함 시, 적절한 타입으로의 형변환이 추가됨.

       ```java
        static Juice makeJuice(FruitBox2<? extends Fruit2> box){
               String tmp = "";
       
               for(Fruit2 f : box.getList())
                   tmp += f + " ";
               return new Juice(tmp);
           }
       ```

       ⬇️

       ```java
        static Juice makeJuice(FruitBox2 box){
               String tmp = "";
       				Iterator it = box.getList().iterator();
               while(it.hasNext()){
                   tmp += (Fruit)it.next() + " ";
               }
               return new Juice(tmp);
           }
       ```



## 02. 열거형(enum)

* 열거형:

  * 여러 상수를 선언 해야 할 때, 편리하게 선언하는 방법.

  * 예시:

    ```java
    class Card{
      static final int CLOVER = 0;
      static final int HEART = 1;
      static final int DIAMOND = 2;
      static final int SPADE = 3;
      
      static final int TWO = 0;
      static final int THREE = 1;
      static final int FOUR = 2;
      
      final int kind;
      final int num;
    }
    ```

    ⬇️ enum으로 변경. 값을 별도로 지정하지 않아도, 배열처럼 0부터 순차적으로 정수값이 할당된다.

    ```java
    class Card{//  0   ,   1  ,    2   ,   3
      enum Kind {CLOVER, HEART, DIAMOND, SPADE} // 열거형 Kind를 정의
      enum Value {TWO, THREE, FOUR}							// 열거형 Value를 정의
      
      final Kind kind;	// 타입이 int가 아닌, Kind임에 유의하기.
      final Value value;
    }
    ```

    * 위와 같은 예제에서, 열거형을 사용 하기 이전의 값의 경우,
      `if(Card.CLOVER == Card.TWO)` 와 같은 조건식을 진행 할 경우, 값이 0이기에 true를 반환한다.
      하지만 이는, 숫자와 무늬를 비교한 것이라 실제로는 false가 반환이 되어야 하는 것이 맞다.
    * 이에 반해 열거형의 경우, 값을 비교하기 이전에 타입을 먼저 비교하기 때문에
      값이 같더라도 타입이 다르면 컴파일 에러를 발생시킨다.
      `if(Card.Kind.CLOVER == Card.Value.TWO)`



### 열거형의 정의와 사용

* 정의 방법:
  괄호{} 안에 상수의 이름을 나열한다.

  ```java
  enum 열거형이름 {상수명1, 상수명2, ...}
  
  enum Direction {EAST, SOUTH, WEST, NORTH}
  ```

* 사용 방법:
  '열거형이름.상수명'을 작성하여 사용하면 된다. static변수를 참조하는 것과 동일.

  ```java
  class Unit{
    int x, y; 		 //유닛의 위치
    Direction dir; //열거형을 인스턴스 변수로 선언
    
    void init(){
      dir = Direction.EASR;	// 유닛의 방향을 EAST로 초기화
    }
  }
  ```

* 열거형 상수간의 비교:

  * '=='를 사용하며, equals()를 사용하지 않아도 비교가 된다.(빠른 성능 제공)

  * '<','>' 와 같은 비교연산자는 사용 할 수 없다. 

  * comparTo()는 다른 곳에서 사용할 때와 같이, 두 비교 대상이 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면 음수를 반환.

    ```java
    if(dir == Direction.EAST){
      x++;
    } else if (dir > Direction.WEST){ // 에러. 열거형 상수에 비교연산자 사용 불가
      ...
    } else if (dir.compareTo(Direction.WEST) > 0){ // compareTo()는 가능
      ...
    }
    ```

     

### 열거형의 조상 - java.lang.Enum

* 모든 열거형의 조상은 java.lang.Enum 이며, 다음과 같은 메소드를 제공

  | 메서드                                    | 설명                                                       |
  | ----------------------------------------- | ---------------------------------------------------------- |
  | Class<E> getDeclaringClass()              | 열거형의 Class객체를 반환한다.                             |
  | String name()                             | 열거형 상수의 이름을 문자열로 반환한다.                    |
  | int ordinal()                             | 열거형 상수가 정의된 순서를 정수로 반환한다.(0부터 시작)   |
  | T valueOf(Class<T> enumType, String name) | 지정된 열거형에서  name과 일치하는 열거형 상수를 반환한다. |

* 컴파일러가 모든 열거형에 자동적으로 추가해주는 메소드가 두 개 있다.

  * `static E[] values()`

    * 열거형 Direction에 정의된 모든 상수를 출력하는 데 사용됨.

      ```java
      Direction[] dArr = Direction.values();
      
      for(Direction d : dArr) // for(Direction d : Direction.values())
        System.out.printf("%s = %d%n", d.name(), d.ordinal());
      ```

  * `static E valueOf(String name)`

    * 열거형 상수의 이름으로 문자열 상수에 대한 참조를 얻을 수 있게 해준다.

      ```java
      Direction d = Direction.valueOf("WEST");
      
      System.out.println(d); // WEST
      System.out.println(Direction.WEST == Direction.valueOf("WEST")); // true
      ```



* 예제:

  ```java
  enum Direction {EAST, SOUTH, WEST, NORTH}
  
  public class Ex12_5 {
      public static void main(String[] args) {
          Direction d1 = Direction.EAST;
          Direction d2 = Direction.valueOf("WEST");
          Direction d3 = Enum.valueOf(Direction.class, "EAST");
  
          System.out.println("d1="+d1);
          System.out.println("d2="+d2);
          System.out.println("d3="+d3);
  
          System.out.println("d1==d2 ?"+(d1==d2));
          System.out.println("d1==d3 ?"+(d1==d3));
          System.out.println("d1.equals(d3) ?"+ d1.equals(d3));
  //        System.out.println("d2 > d3 ? "+ (d2 > d3)); // 에러
          System.out.println("d1.compareTo(d3) ?" + d1.compareTo(d3));
          System.out.println("d1.compareTo(d2) ?" + d1.compareTo(d2));
  
          switch (d1){
              case EAST: // Direction.EAST라고 쓸 수 없다.
                  System.out.println("The direction is EAST.");
                  break;
  
              case SOUTH:
                  System.out.println("The direction is SOUTH.");
                  break;
  
              case WEST:
                  System.out.println("The direction is WEST.");
                  break;
  
              case NORTH:
                  System.out.println("The direction is NORTH.");
                  break;
          }
  
          Direction[] dArr = Direction.values();
  
          for(Direction d : dArr) // for (Direction d : Direction.values())
              System.out.printf("%s = %d%n", d.name(), d.ordinal());
      }
  }
  ```

  > 위 코드의 결과:
  > d1=EAST
  > d2=WEST
  > d3=EAST
  > d1==d2 ?false
  > d1==d3 ?true
  > d1.equals(d3) ?true
  > d1.compareTo(d3) ?0
  > d1.compareTo(d2) ?-2
  > The direction is EAST.
  > EAST = 0
  > SOUTH = 1
  > WEST = 2
  > NORTH = 3



### 열거형에 멤버 추가하기

* Enum 클래스의 ordinal()이 열거형 상수가 정의된 순서를 반환하지만, 이 값은 내부적 용도로 사용하기 위함이므로, 열거형 상수의 값으로 쓰지않는 것이 좋다.

* 열거형 상수의 값이 불규칙할 경우, 열거형 상수의 이름 옆에 괄호를 적은 후, 그 안에 값을 입력하면 된다.

  ```java
  enum Direction {EAST(1), SOUTH(5), WEST(-1), NORTH(10)}
  ```

* 이런식으로 값을 입력 후, 이 값을 저장할 수 있는 인스턴스 변수와 생성자를 추가해주어야한다.
  열거형 상수를 선언 한 후, 다른 멤버들을 추가하면 된다.

  ```java
  enum Direction {
    EAST(1), SOUTH(5), WEST(-1), NORTH(10); // 끝에 ';'를 반드시! 추가해야한다.
  
    private final int value;	// 정수를 저장할 필드(인스턴스 변수) 추가
    Direction(int value){     // 생성자 추가
      this.value = value;
    }
    
    public int getValue() { // 외부에서 값을 얻을 수 있도록 만든 기능.
      return value;
    }
  }
  ```

  * 인스턴스 변수는 반드시 상수여야 할 필요는 없다.

  * 열거형의 생성자는 외부에서 호출할 수 없다. 묵시적으로 private이기 때문.

    ```java
    Direction d = new Direction(1); // 불가능. 외부에서 호출 불가.
    
    enum Direction {
    	...
      Direction(int value){     // == private Direction(int value)
    	... 
    }
    ```

* 예제:

  ```java
  import java.util.IllegalFormatCodePointException;
  
  enum Direction2 {
      EAST(1,">"), SOUTH(2,"V"), WEST(3,"<"), NORTH(4,"^");
  
      private static final Direction2[] DIR_ARR = Direction2.values();
      private final int value;
      private final String symbol;
  
      Direction2(int value, String symbol) { // 접근제어자 private 생략 됨.
          this.value = value;
          this.symbol = symbol;
      }
  
      public int getValue() {
          return value;
      }
  
      public String getSymbol() {
          return symbol;
      }
  
      public static Direction2 of(int dir){
          if(dir < 1 || dir > 4)
              throw new IllegalArgumentException("Invalid value:" + dir);
          return DIR_ARR[dir-1];
      }
  
      // 방향을 회전시키는 메서드. num의 값만큼 90도씩 시계방향으로 회전한다.
      public Direction2 rotate(int num){
          num = num%4;
  
          if(num<0) num+=4; // num이 음수일 경우, 반시계방향으로 회전
  
          return DIR_ARR[(value-1+num)%4];
      }
  
      public String toString() {
          return name()+getSymbol();
      }
  }
  
  public class Ex12_6 {
      public static void main(String[] args) {
          for(Direction2 d : Direction2.values())
              System.out.printf("%s=%d%n", d.name(), d.getValue());
  
          Direction2 d1 = Direction2.EAST;
          Direction2 d2 = Direction2.of(1);
  
          System.out.printf("d1 = %s ,%d%n", d1.name(), d1.getValue());
          System.out.printf("d2 = %s ,%d%n", d2.name(), d2.getValue());
          System.out.println(Direction2.EAST.rotate(1));
          System.out.println(Direction2.EAST.rotate(2));
          System.out.println(Direction2.EAST.rotate(-1));
          System.out.println(Direction2.EAST.rotate(-2));
      }
  }
  ```

  

## 03. 애너테이션

### 애너테이션이란?

* 프로그램의 소스코드안에 다른 프로그램을 위한 정보를 **약속된 형식으로 포함**시킨 것.
* 주석(comment)처럼 프로그래밍 언어에 영향을 미치지 않으며, 다른 프로그램에 유용한 정보를 제공하는 장점이 있음.
* 애너테이션의 조상인 Annotation인터페이스의 소스코드 중, '/**'로 시작하는 주석 안의 소스코드에 대한 설명을 적고, '@'이 붙은 태그들을 볼 수 있는다.
  이는 정의된 태그를 이용해 주석 내의 정보를 저장하고, 이 정보를 javadoc.exe라는 프로그램이 문서를 작성하는 것에 사용되는 것이다.
  그리고 이 기능을 응용하여 만들어 진 것이 애너테이션. 



* 표준 애너테이션과 메타애너테이션이 존재한다.



### 표준 애너테이션

* 주로 컴파일러를 위한 것. 컴파일러에게 유용한 정보를 제공한다.

  | 애너테이션           | 설명                                                   |
  | -------------------- | ------------------------------------------------------ |
  | @Override            | 컴파일러에게 메서드를 오버라이딩 하는 것이라고 알린다. |
  | @Deprecated          | 앞으로 사용하지 않을 것을 권장하는 대상에 붙인다.      |
  | @SupperessWarnings   | 컴파일러의 특정 경고메세지가 나타나지 않게 해준다.     |
  | @SafeVarargs         | 지네릭스 타입의 가변인자에 사용한다.(JDK1.7)           |
  | @FunctionalInterface | 함수형 인터페이스라는 것을 알린다.(JDK1.8)             |
  | @Native              | native메서드에서 참조되는 상수 앞에 붙인다.(JDK1.8)    |



#### @Override

* 메서드 앞에만 붙일 수 있는 애너테이션.

* 조상의 메서드를 오버라이딩하는 것이라는 것을 컴파일러에게 알려주는 역할.

  * 만일 조상의 메서드를 오버라이딩 할 때, 이름을 잘못 적는 실수를 해도 이 애너테이션을 이용하면, 에러 코드가 나타나서 쉽게 알 수 있다.

* 예제:

  ```java
  public class Parent {
      void parentMethod() {}
  }
  
  class Child extends Parent {
      @Override
      void parentmethod(){} //조상의 이름 잘못적음(M을 m으로)
  }
  ```

  > 위 코드의 결과:
  > java: method does not override or implement a method from a supertype

  * 이름이 정상적일 땐 해당 오류가 나타나지 않는다.



#### @Deprecated

* 새로운 기능이 추가되어, 더 이상 사용되지 않는 필드나 메서드에 붙이는 애너테이션.
  다른 것으로 대체되었으니, 더 이상 사용하지 않을 것을 권하는 의미다.

* 만일 '@Deprecated'가 붙은 대상을 사용하는 코드를 작성할 경우:

  ```
  Note: AnnotationEx2.java uses or overrides a deprecated API.
  Note: Recompile with -Xlint:deprecation for details.
  ```

  와 같은 메세지가 나타나며,
  해당 소스파일(AnnotationEx2.java)이 'deprecated'된 대상을 사용하고 있으며, '-Xlint:deprecation' 옵션을 붙여, 재 컴파일 할 경우 자세한 내용을 알 수 있다는 의미이다.





#### @FunctionalInterface

* '함수형 인터페이스(functional interface)'를 선언 할 때, 올바르게 선언 했는지 확인하고, 잘못된 경우 에러를 발생시키는 애너테이션.

* 실수를 방지할 수 있으므로 붙이는 것이 좋다.

  > 함수형 인터페이스는 추상 메서드가 하나뿐이어야 한다는 제약이 있다.

  ```java
  @FunctionalInterface
  public interface Runnable{
    public abstruct void run(); // 추상 메서드
  }
  ```



#### @SupperessWarnings

* 컴파일러가 보여주는 경고 메세지가 나타나지 않도록 해주는 애너테이션.
* 다른 경고메세지들을 놓칠 가능성이 있을 때 사용하며, 묵인해야하는 경고가 발생하는 대상에 해당 애너테이션을 사용하면된다.



* 주로 사용되는 경고 메세지의 종류:2

  * deprecation:
    @Deprecated 가 붙은 대상을 사용해서 발생하는 경고를 차단한다.
  * unchecked: 
    지네릭스로 타입을 지정하지 않았을 때 발생하는 경고를 차단한다.
  * rawtypes:
    지네릭스를 사용하지 않아서 발생하는 경고를 차단한다.
  * varargs:
    가변인자의 타입이 지네릭타입일 때 발생하는 경고를 차단한다.

* 억제하려는 경고메시지를 애너테이션 뒤에 괄호() 안 문자열로 지정하면 된다.

  ```java
  @SupperessWarnings("unchecked") //지네릭스와 관련된 경고를 억제.
  ArrayList lisr = new ArrayList(); // 지네릭 타입 지정하지않음.
  list.add(obj);				// 여기서 오류가 발생하지만 차단됨.
    
  // 둘 이상의 경고를 동시에 억제하고 싶을 경우: 대괄호가 필수다.
  @SupperessWarnings({"unchecked","deprecation"}) 
  ```

  

### 메타 애너테이션

* 새로운 애너테이션을 정의할 때 애너테이션의 적용대상(target)이나, 유지기간(retention)을 지정하는 데 사용한다.
* 에너테이션을 위한 애너테이션.

| 애너테이션  | 설명                                                       |
| ----------- | ---------------------------------------------------------- |
| @Target     | 애너테이션이 적용 가능한 대상을 지정하는 데 사용한다.      |
| @Documented | 애너테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다. |
| @Inherited  | 애너테이션이 자손 클래스에 상속되도록 한다.                |
| @Retention  | 애너테이션이 유지되는 범위를 지정하는 데 사용한다.         |
| @Repeatable | 애너테이션을 반복해서 적용할 수 있게 한다.(JDK 1.8)        |



#### @Target

* 애너테이션이 적용 가능한 대상을 지정하는 데 사용한다.

* 애너테이션에 적용할 수 있는 대상을 지정한 예시:
  이 또한 여러개를 이용하고 싶다면 대괄호를 이용해야한다.

  ```java
  @Target({Type, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
  @Retention(RetentionPolicy.SOURCE)
  public @interface SuppressWarnings {
    String[] value();
  }
  ```

* @Target으로 지정할 수 있는 애너테이션 적용대상:

  | 대상 타입       | 의미                                                         |
  | --------------- | ------------------------------------------------------------ |
  | ANNOTATION_TYPE | 애너테이션                                                   |
  | CONSTRUCTION    | 생성자                                                       |
  | FIELD           | 필드(멤버변수, enum tkdtn)                                   |
  | LOCAL_VARIABLE  | 지역변수                                                     |
  | METHOD          | 메서드                                                       |
  | PACKAGE         | 패키지                                                       |
  | PRAMETER        | 매개변수                                                     |
  | TYPE            | 타입(클래스, 인터페이스, enum)<br />타입 선언 시, 애너테이션을 붙일 수 있다. |
  | TYPE_PRAMETER   | 타입 매개변수(JDK1.8)                                        |
  | TYPE_USE        | 타입이 사용되는 모든 곳(JDK1.8)<br />해당 타입의 변수를 선언할 때 붙일 수 있다. |

  * 표의 값들은 'java.lang.annotation.ElementType' 이라는 열거형에 정의 되어 있으며, 아래와 같이 static import 문 사용 시,
    Element.TYPE과 같은 것들을 위의 표 처럼 간단히 사용할 수 있다.

    ```java
    import java.lang.annotation.ElementType.*;
    
    @Target({TYPE, FIELD, TYPE_USE}) // 적용 대상이 TYPE, FIELD, TYPE_USE
    
    public @interface MyAnnotation { } // MyAnnotation을 정의
    
    @MyAnnotation // 적용 대상이 TYPE인 경우.
    class Myclass {
      @MyAnnotation // 적용 대상이 FIELD인 경우
      int i;
      
      @MyAnnotation  // 적용 대상이 TYPE_USE인 경우
      MyClass mc;
    }
    ```

    

#### @Retention

* 애너테이션이 유지(retention)되는 기간을 지정하는 데 사용한다.

* 애너테이션의 유지정책(retention policy)의 종류: 

  * SOURCE:
    * 소스파일에만 존재. 클래스 파일에는 존재하지 않음.
    * 컴파일러가 사용하는 애너테이션의 유지정책. 컴파일러를 직접 작성할 것이 아니면, 이 유지정책은 필요없음.
    * '@Override', '@SuppresssWarnings'가 대표적 예시.

  * CLASS:
    * 클래스 파일에 존재. 실행시에 사용 불가. 기본값이다.
    * 컴파일러가 애너테이션의 정보를 클래스 파일에 저장할 수 있게 하지만, 클래스 파일이 JVM에 로딩될때 애너테이션의 정보가 무시되기 때문에, 기본값임에도 잘 사용되지 않는다.
  * RUNTIME:
    * 클래스 파일에 존재. 실행시에 사용 가능.
    * 실행 시, '리플렉션(reflection)'을 통해 클래스 파일에 저장된 애너테이션의 정보를 읽어 처리할 수 있다.
    * '@FunctionalInterface'는 'Override'처럼 컴파일러가 체크하지만, 실행 시에도 사용되므로 'RUNTIME'으로 되어 있다.



#### @Documented

* 애너테이션에 대한 정보가 javadoc으로 작성한 문서에 포함되도록 한다.

* 자바에서 제공하는 기본 애너테이션 중, @Override', '@SuppresssWarnings'을 제외한 나머지는 모두 이 애너테이션이 붙어있다.

  ```java
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  public @interface FunctionalInterface{}
  ```



#### @Inherited

* 애너테이션이 자손 클래스에 상속되도록한다.

* '@Inherited'가 붙은 애너테이션을 조상클래스에 붙이면, 자손 클래스도 이 애너테이션이 붙은 것과 같이 인식된다.

  ```java
  @Inherited //@SuperAnno가 자손까지 영향 미치게.
  @interface SuperAnno {}
  
  @SuperAnno
  class Parent{}
  
  class Chiled extends Parent { } // Child에 애너테이션이 붙은 것으로 인식
  ```

  

#### @Repeatable

* 보통 하나의 대상에 한 종류의 애너테이션을 붙이는데, 이 애너테이션이 붙은 애너테이션은 여러번 붙일 수 있다.

  ```java
  @Repeatable(ToDos.class) //ToDo 애너테이션을 여러번 반복해서 쓸 수 있게 한다.
  @interface ToDo{
    String value();
  }
  ```

  * '@ToDo' 라는 애너테이션이 위와같이 정의 되어있을경우, 다음과 같이 '@ToDo' 를 여러 번 붙이는 것이 가능하다.

    ```java
    @ToDo("delete test codes.")
    @ToDo("override inherited methods")
    class MyClass{
      ...
    }
    ```

* 같은 이름의 애너테이션이 하나의 대상에 여러번 적용될 수 있기 때문에, 
  이 애너테이션들을 하나로 묶어 다룰 수 있는 애너테이션도 추가로 정의해야함.

  ```java
  @interface ToDos{	// 여러 개의 ToDo애너테이션을 담을 컨테이너 애너테이션 ToDos
    ToDo[] value(); // ToDo애너테이션 배열타입의 요소 선언. 이름이 반드시 value여야 함.
  }
  
  @Repeatable(ToDos.class) // 괄호 안에 컨테이너 애너테이션을 지정해 줘야한다.
  @interface ToDo{
    String value();
  }
  ```





### 애너테이션 타입 정의하기

* 새로운 애너테이션을 정의하는 방법:
  '@'를 붙이는 것을 제외하면 인터페이스 정의와 동일.

  ```java
  @interface 애너테이션이름{
    타입 요소이름(); //애너테이션의 요소를 선언
    ...
  }
  ```

* 엄밀히 말하면, @Override는 애너테이션 / Override는 애너테이션의 타입 이다.



### 애너테이션의 요소(element)

* 애너테이션 내에 선언된 메서드를 뜻한다.

* TestInfo를 이용한 예제:

  ```java
  @interface TestInfo {
    int      count();
    String   testedBy();
    String[] testTools();
    TestType testType();  // enum TestType{FIRST, FINAL}. 상수를 정의 할 수 있으나, 디폴트 메서드는 정의할 수 없음.
    DateTime testDate();  // 자신이 아닌 다른 애너테이션(@DateTime)을 포함시킬 수 있다.
  }
  
  @interface DateTime{
    String yymmdd();
    String hhmmss();
  }
  ```

  * 애너테이션의 요소는,

    * 반환값이 있고 매개변수는 없는 추상 메서드의 형태를 가짐
    * 상속을 통해 구현하지 않아도 됨.
    * 단, 애너테이션 적용 시, 요소들의 값을 빠짐없이 지정해주어야한다. (순서는 상관없음)

    ```java
    @TestInfo(
    	count = 3, testedBy = "Kim",
      testTools = { "JUnit","AutoTester"},
      testType = TestType.FIRST,
      testDate = @DateTime(yymmdd="160101", hhmmss = "235959")
    )
    
    public class NewClass{...}
    ```

    

    * 기본 값을 가질 수 있으며, 기본값이 있는 요소는 애너테이션을 적용 시 값을 지정하지않으면 기본값이 사용 됨.

    ```java
    @interface TestInfo {
      int      count() default 1;
    }
    
    @TestInfo // @TestInfo(count=1)과 동일.
    public class NewClass{...}
    ```

    

    * 애너테이션 요소가 오직 하나 뿐이고 이름이 value일 경우, 애너테이션 적용 시, 요소의 이름 생략 후 값만 적어도 된다.
      이는 요소의 타입이 배열일 때도 동일하게 적용된다.

      ```java
      @interface TestInfo {
        String value();
      }
      
      @TestInfo("passed") // @TestInfo(value="passed")과 동일.
      public class NewClass{...}
      
      //만일 요소의 타입이 배열 일 경우
      @TestInfo({"passed","test"})
      ```

      

    * 요소의 타입이 배열일 경우, 괄호{}를 사용해 여러개의 값을 지정할 수 있음.

      ```java
      @interface TestInfo {
        String[] testTools();
      }
      
      @TestInfo(testTools = { "JUnit","AutoTester"}) // 값이 여러개일 경우
      @TestInfo(testTools = "JUnit") // 값이 하나일 때는 괄호 생략 가능.
      @TestInfo(testTools = {}) // 값이 없을 땐 괄호 생략 불가능.
      public class NewClass{...}
      ```

    

    * 기본값 지정 시에도 괄호{} 사용 가능하다.

      ```java
      @interface TestInfo(
      	String[] info() default{"aaa","bbb"} // 값이 여러개일 경우
        String[] info2() default "ccc" //값이 하나일 경우 괄호 생략 가능
      )
        
      @TestInfo // 기본 값 사용
      @TestInfo(info2 = {}) // info2가 "ccc"가 아닌, info2 = {} 와 같아짐. info는 기본값.
      ```





### 모든 애너테이션의 조상

* 모든 애너테이션의 조상 Annotation 은 일반적인 인터페이스로 정의 되어있다.
  (따라서 extends 방식의 상속 불가능)

  ```java
  package java.lang.annotation;
  
  public interface Annotation { // Annotation자신은 인터페이스이다.
    boolean equals(Object obj);
    int hashCode();
    String toString();
    
    Class<? extends Annotation> annotationType(); // 애너테이션의 타입 반환
  }
  ```

  * 위와 같이 정의 되어있기 때문에, 모든 애너테이션 객체는 equals(), hashCode(), toString()과 같은 메서드 호출 가능.

    ```java
    Class<AnnotationTest> cls = AnnotationTest.class;
    Annotation[] annoArr = cls.getAnnotations();
    
    for(Annotation a : annoArr){
      System.out.println("toString():"+a.toString());
      System.out.println("hashCode():"+a.hashCode());
      System.out.println("equals():"+a.equals());
      System.out.println("annotationType():"+a.annotationType());
    }
    ```



### 마커 애너테이션

* Serializable이나, Cloneable인터페이스처럼, **요소가 하나도 정의 되지 않은 애너테이션**을 뜻한다.

  ```java
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Override{ } //마커 에너테이션. 정의된 요소가 하나도 없다
  
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface Test{ } //마커 에너테이션. 정의된 요소가 하나도 없다
  ```

  

### 애너테이션 요소의 규칙

* 요소의 타입은 기본형, String, enum, 애너테이션, Class만 허용된다.
* () 안에 매개변수를 선언할 수 없다.
* 예외를 선언할 수 없다.
* 요소를 타입 매개변수로 정의할 수 없다.

```java
@interface AnnoTest{
  int id = 100; //OK. 상수로 하고싶다면? static final int id = 100;
  String major(int i, int j); //매개변수 선언 불가능
  String minor() throws Exception; // 예외 선언 불가능
  ArrayList<T> list(); // 요소의 타입에 타입매개변수 사용 불가.
}
```





### 애너테이션 활용 예제

* 애너테이션을 직접 정의하고, 요소의 값을 출력하는 방법을 보여주는 예제.

```java
import java.lang.annotation.*;

@Deprecated
@SuppressWarnings("111") // 유효하지 않은 애너테이션은 무시된다.
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
public class Ex12_8 {
    public static void main(String[] args) {
        //Ex12_8의 객체를 얻음.
        Class<Ex12_8> cls = Ex12_8.class; // Ex12_8.class는 클래스 객체를 의미하는 리터럴.
																					// (클래스 객체는 클래스 로더에의해 생성. 침조 시, '클래스이름.class' 의 형식 사용)

        TestInfo anno = (TestInfo)cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = "+anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = "+anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = "+anno.testDate().hhmmss());

        for(String str : anno.testTools())
            System.out.println("testTools ="+str);

        System.out.println();


        // Ex12_8에 적용된 모든 애너테이션을 가져온다.
				// 이는 클래스객체 내에 해당 클래스의 모든 정보를 가지고 있기 때문에 가능 한 일이다.
        Annotation[] annoArr = cls.getAnnotations();

        for(Annotation a: annoArr)
            System.out.println(a);
    }
}
@Retention(RetentionPolicy.RUNTIME) // 실행 시, 사용가능하도록 지정
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit"; //하나이기 때문에, 대괄호 생략 가능.
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType {FIRST, FINAL}
```

> 이 식의 결과:
> anno.testedBy() = aaa
> anno.testDate().yymmdd() = 160101
> anno.testDate().hhmmss() = 235959
> testTools =JUnit
>
> @java.lang.Deprecated()
> @TestInfo(count=1, testType=FIRST, testTools=[JUnit], testedBy=aaa, testDate=@DateTime(yymmdd=160101, hhmmss=235959))

