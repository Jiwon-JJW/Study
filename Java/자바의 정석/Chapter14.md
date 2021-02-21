# CHAPTER14

## 01. 람다식(Lambda Expression)

* 메서드를 하나의 '식(expression)'으로 표현한 것.
* 함수를 간략하고 명확하게 표현할 수 있게 해준다.
* 메서드의 이름과 반환값이 없어지기 때문에, 람다식을 '익명 함수(anonymous function)'라고도 한다.

```java
int[] arr = new int[5];
Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1);

//아래의 메서드와 동일한 작업을 한다.
int method(int i) {
  return (int)(Math.random()*5)+1;
}
```

* 람다식은 새로은 클래스를 만들고, 메서드를 만드는 일련의 과정을 거치지 않고 람다식 자체로 메서드의 역할을 대신 할 수 있는 메리트를 가진다.
* 메서드의 매개변수로 전달되는 것은 물론, 메서드의 결과로 반환될 수 있어 메서드를 변수처럼 다루는 것이 가능해졌다.



### 01. 람다식 작성하기

* 메서드에서 이름과 반환타입을 제거한 뒤, 매개변수 선언부와 몸통 사이에 '->'를 추가하면 된다.

  ```java
  int max(int a, int b) {
    return a>b? a:b;
  }
  
  // 람다식
  (int a, int b) -> { return a > b ? a : b; }
  
  // 반환 값이 있는 메서드의 경우, return문 대신 '식(expression)'으로대신할 수 있다.
  // '식'이므로 세미콜론(;)을 붙이지 않아도 되며, 계산결과가 자동 반환된다.
  (int a, int b) -> a > b ? a : b
    
  // 매개변수의 타입을 추론 가능 할 경우, 생략 가능하다.
  // (대부분 가능. 반환타입이 없는 이유도 추론이 가능하기 때문)
  (a , b) -> a > b? a : b
    
  // 매개변수가 하나 뿐인 경우, 괄호 생략 가능.
  // 단, 매개변수의 타입이 있을 경우 괄호 생략 불가능.
  (a) -> a * a     // OK
  (int a) -> a * a //에러
    
  // 대괄호 안의 문장이 하나일 때는 대괄호 생략 가능.
  // 문장 끝에 세미콜론을 안붙이는 것을 유의 하자.
  (String name, int i) -> {
    System.out.println(name + "=" + i);
  }
  
  (String name, int i) -> System.out.println(name + "=" + i);
  
  // 단, 대괄호 내의 문장이 return문 일 경우, 생략 불가능
  (int a, int b) -> { return a > b ? a : b; } // OK
  (int a, int b) ->  return a > b ? a : b // 에러
  ```

  

* 람다식의 예

  * 메서드1:

    ```java
    (int a, int b) -> { return a > b ? a : b; }
    ```

    람다식1:

    ```java
    (int a, int b) -> a > b ? a : b
      
    (a , b) -> a > b? a : b
    ```

  * 메서드2:

    ```java
    void printVar(String name, int i){
      System.out.println(name + "=" + i);
    }
    ```

    람다식2:

    ```java
    (String name, int i) -> {System.out.println(name + "=" + i);}
    
    (name, i) -> {System.out.println(name + "=" + i);}
    
    (name, i) -> System.out.println(name + "=" + i)
    ```

  * 메서드3:

    ```java
    int square(int x){
      return x * x;
    }
    ```

    람다식3:

    ```java
    (int x) -> x * x 
    (x) -> x * x
    x -> x * x 
    ```

  * 메서드4:

    ```java
    int roll(){
      return (int)(Math.random()*6);
    }
    ```

    람다식4:

    ```java
    () -> { return (int)(Math.random()*6); }
    () -> (int)(Math.random()*6);
    ```

  * 메서드5:

    ```java
    int sumArr(int[] arr){
      int sum = 0;
      for(int i : arr)
        sum += i;
      return sum;
    }
    ```

    람다식5:

    ```java
    (int[] arr) -> {
      int sum = 0;
      for(int i : arr)
        sum += i;
      return sum;
    }
    ```



## 02. 람다식은 익명 함수? 익명 객체!

* 람다식은 익명 클래스의 객체와 동등하다.
* 람다식으로 정의 된 익명 객체의 메서드를 어떻게 호출할 수 있을까?
  익히 알고있듯, 참조변수가 있어야 메서드를 호출 할 수 있다.
  따라서 이 익명 객체의 주소를 f라는 참조변수에 저장하고자 할 때, 타입은 어떻게 지정해야할까?
  * 참조형이니, 클래스 또는 인터페이스가 가능하다.
  * 그리고, 람다식과 동등한 메서드가 정의 되어있어야한다.
    그래야 참조변수로 익명객체(람다식)의 메서드를 호출할 수 있기 때문.



## 03. 함수형 인터페이스(Functional Interface)

* 인터페이스를 구현한 익명 객체를 람다식으로 대체할 수 있다.
  이 것이 되는 이우는, 람다식 또한 실제로 보면 익명 객체이고, 
  인터페이스를 구현한 익명 객체의 메서드와 람다식의 매개 변수의 타입, 개수 그리고 반환값이 일치하다면 문제가 없기 때문이다.
* 하나의 메서드가 선언된 인터페이스를 정의하여 람다식을 다루는 것은, 자바의 기존 규칙들을 어기지 않으면서도 자연스럽기 때문에 인터페이스를 통해 람다식을 다루기로 결정 되었다.
  * 그리고 이렇게 람다식을 다루기 위한 인터페이스를 '함수형 인터페이스(Functional Interface)'라고 한다.
  * 단, 함수형 인터페이스엔 오직 하나의 추상 메서드만 정의되어야 한다는 제약이 있다.
    그래야 람다식과 인터페이스의 메서드가 1:1로 연결될 수 있기 때문.



### 함수형 인터페이스 타입의 매개변수, 반환 타입



