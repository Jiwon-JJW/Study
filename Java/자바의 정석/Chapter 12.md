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

  

