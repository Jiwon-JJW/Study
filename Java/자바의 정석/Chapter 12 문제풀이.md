#### ❌12-1. 클래스 Box가 다음과 같이 정의 되어 있을 때, 다음 중 오류가 발생하는 문장은?

```java
class Box<T>{
    T item;
    
    void setItem(T item){
        this.item = item;
    }
    
    T getItem() {
        return item;
    }
}
```

1. `Box<Object> b = new Box<String>();`
2. `Box<Object> b = (Object)new Box<String>();`
3. `new Box<String>().setItem(new Object());`
4. `new Box<String>().setItem("ABC");`

* 답: 1,  3
* 원래 정답: 1, 2, 3
  * 해설:
    1. `Box<Object> b = new Box<String>();`
       *  타입의 값이 다름.
    2. `Box<Object> b = (Object)new Box<String>();`
       * Object 타입을 `Box<Object>` 타입의 참조변수에 저장 할 수 없음. ( 타입 불일치 )
    3. `new Box<String>().setItem(new Object());`
       * 타입이 String이므로, 넣어질 매개변수 값도 String 이외에는 허용하지 않음.



#### 12-2. 지네릭 메서드 makeJuice()가 아래와 같이 저장되어있을 때, 이 메서드를 올바르게 호출한 문장을 모두 고르시오(Apple과 Grape는 Fruit의 자손이라고 가정.)

```java
class Juicer {
    static <T extends Fruit> String makeJuice(FruitBox<T> box) {
        String tmp = "";
        for(Fruit f : box.getList())
            tmp += f+" ";
        
        return tmp;
    }
}
```

1. `Juicer.<Apple>makeJuice(new FruitBox<Fruit>());`
2. `Juicer.<Fruit>makeJuice(new FruitBox<Grape>());`
3. `Juicer.<Fruit>makeJuice(new FruitBox<Fruit>());`
4. `Juicer.makeJuice(new FruitBox<Apple>());`
5. `Juicer.makeJuice(new FruitBox<Object>());`



* 답: 3, 4
* 해설:
  1. `Juicer.<Apple>makeJuice(new FruitBox<Fruit>());`
     * 대입 된 타입이 일치하지 않으며, 자동형변환도 불가능.
  2. `Juicer.<Fruit>makeJuice(new FruitBox<Grape>());`
     * 자손이긴 하지만, 타입이 달라서 안됨.
  3. `Juicer.<Fruit>makeJuice(new FruitBox<Fruit>());`
  4. `Juicer.makeJuice(new FruitBox<Apple>());`
  5. `Juicer.makeJuice(new FruitBox<Object>());`
     * 타입 호출이 생략된 형태이긴 하지만, 기본적으로 `<Fruit>`인 상태이기 때문에, 타입이 달라서 안됨.



#### 12-3. 다음 중 올바르지 않은 문장을 모두 고르시오

```java
class Box<T extends Fruit>{
    T item;

    void setItem(T item){
        this.item = item;
    }

    T getItem() {
        return item;
    }
}
```

1. `Box<?> b = new Box();`
2. `Box<?> b = new Box<>();`
3. `Box<?> b = new Box<Object>();`
4. `Box<Object> b = new Box<Fruit>();`
5. `Box b = new Box<Fruit>;` 
6. `Box<? extends Fruit> b = new Box<Apple>();`
7. `Box<? extends Object> b = new Box<? extends Fruit>();`



* 답: 3, 4,  7 

* 해설: 

  1. `Box<?> b = new Box();`

     * 타입입력 생략가능

  2. `Box<?> b = new Box<>();`

     * 1과 같음

  3. `Box<?> b = new Box<Object>();`

     * Box<?> 는 `<? extend Object>` 를 줄여서 쓴 것인데, 위의 예제에서는 `<T extends Fruit>` 로 제한 된 상태라서

       `<Object>`가 올 수 없다.

  4. `Box<Object> b = new Box<Fruit>();`

     * 타입이 불일치 하여 불가능.

  5. `Box b = new Box<Fruit>;`

     * 원래는 `Box<?> b = new Box<Fruit>; `로 쓰는 것이 더 바람직하지만, 작동은 된다.

  6.  `Box<? extends Fruit> b = new Box<Apple>();`

     * 자손까지 가능하기 때문에 가능.

  7. `Box<? extends Object> b = new Box<? extends Fruit>();`

     * new 연산자는 타입이 분명해야하기 때문에, 와일드 카드와 사용 불가능.





#### 12-4. 아래의 메서드는 두 개의 ArrayList를 매개변수로 받아서, 하나의 ArrayList로 병합하는 메서드이다. 이를 지네릭 메서드로 변경하시오.

```java
public static ArrayList<? extends Product> merge(
		ArrayList<? extends Product> list, ArrayList<? extends Product> list2) {
   		ArrayList<? extends Product> newList = new ArrayList<>(list);
    
    	newList.addAll(list2);
    
    return newList;
}
```

* 답:

  ```java
  public static <T extends Product> ArrayList<T> merge(ArrayList<T> list, ArrayList<T> list2) {
          ArrayList<T> newList = new ArrayList<T>(list);
  
          newList.addAll(list2);
  
          return newList;
      }
  ```

  

#### 12-5. 다음중 메타 애너테이션이 아닌 것을 모두 고르시오.

1. Documented
2. Target
3. Native
4. Inherited



* 답: 3.



#### 12-6. 애너테이션 TestInfo가 다음과 같이 정의되어 있을 때, 이 애너테이션이 올바르게 적용되지 않은 것은?

```java
@interface TestInfo{
  int count() default 1;
  String[] value() default "aaa";
}
```

1. `@TestInfo              class Exercise12_7{}`
2. `@TestInfo(1)           class Exercise12_7{}`
3. `@TestInfo("bbb")       class Exercise12_7{}`
4. `@TestInfo("bbb","ccc") class Exercise12_7{}`



* 답: 4.
* 해설: 
  `@TestInfo("bbb","ccc") class Exercise12_7{}` 에 ("bbb","ccc") 가 아닌 , ({"bbb","ccc"}) 가 되어야 한다.



* 정답: 2, 4

  * 해설: 

    2. `@TestInfo(1)           class Exercise12_7{}` 의 경우, 요소의 이름이 value가 아닌 경우, count = 1 이라고 작성하여야 맞는 답이다.

    4번은 내가 한 해설과 동일.

