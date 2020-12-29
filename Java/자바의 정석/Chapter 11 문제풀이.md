### 11-1 다음 코드의 실행 결과를 적으시오

```java
import java.util.*;

public class Tx11_1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(3);
        list.add(6);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(7);

        HashSet set = new HashSet(list);
        TreeSet tset = new TreeSet(set);
        Stack stack = new Stack();
        stack.addAll(tset);

        while (!stack.empty())
            System.out.println(stack.pop());
    }
}
```

* 답: [7, 6, 3, 2]

* 해설 :

  ```java
  import java.util.*;
  
  public class Tx11_1 {
      public static void main(String[] args) {
          ArrayList list = new ArrayList(); // 중복을 허용하고 넣은 순서대로 저장함. (3, 6, 2, 2, 2, 7)
  
          list.add(3);
          list.add(6);
          list.add(2);
          list.add(2);
          list.add(2);
          list.add(7);
  
          HashSet set = new HashSet(list); // list에 있는 객체들을 HashSet에 저장하는 메소드.
        // 중복을 허용하지 않고, 저장 순서를 기억하지 않음. 따라서 중복 요소들은 제거된다. (2, 6, 3, 7)
          TreeSet tset = new TreeSet(set); // set에 있는 객체들을 TreeSet에 저장하는 메소드.
        // 오름차순으로 자동 정렬을 시켜줌. 따로 정렬 기준을 설정하지 않았기에, 숫자의 기본 세팅인 오름차순으로 정렬 한 것.
        // (2, 3, 6, 7)
          Stack stack = new Stack();
          stack.addAll(tset); // tset에 있는 객체들을 stack에 저장.
  
          while (!stack.empty()) // stack에 값이 남아있을 때 까지만 반복문 실행
              System.out.println(stack.pop()); // stack은 제일 마지막에 넣은 것을 제일 먼저 꺼낸다.
        // 따라서 결과는 (7, 6, 3, 2)가 된다.
      }
  }
  ```



### 11-2 다음 중 ArrayList에서 제일 비용이 많이 드는 작업은? 단, 작업 도중에 ArrayList의 크기 변경이 발생하지 않는다고 가정한다.

1. 첫 번째 요소 삭제
2. 마지막 요소 삭제
3. 마지막에 새로운 요소 추가
4. 중간에 새로운 요소 추가



* 답: 4





### ❌11-3 다음에 제시된 Student클래스가 Comparable인터페이스를 구현하도록 변경해서 이름(name)이 기본 정렬기준이 되도록 하시오.

```java
import java.util.*;
class Student{
    String name;
    int ban;
    int no;
    int kor, eng, math;
    
    Student(String name, int ban, int no, int kor, int eng, int math){
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    
    int getTotal(){
        return kor+eng+math;
    }
    
    float getAverage(){
        return (int)((getTotal()/3f)*10+0.5)/10f;
    }
    
    public String toString(){
        return name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage();
    }
}
public class Tx11_3 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student("김자바", 1, 3, 80, 80, 90));
        list.add(new Student("이자바", 1, 4, 70, 90, 70));
        list.add(new Student("안자바", 1, 5, 60, 100, 80));
        
        Collections.sort(list);
        Iterator it = list.iterator();
        
        while (it.hasNext())
            System.out.println(it.next());
    }
}

결과:
김자바, 1, 3, 80, 80, 90, 250, 83.3
남궁성, 1, 2, 90, 70, 80, 240, 80.0
안자바, 1, 5, 60, 100, 80, 240, 80.0
이자바, 1, 4, 70, 90, 70, 230, 76.7
홍길동, 1, 1, 100, 100, 100, 300, 100.0
```

* 답: 못풀었음

* 해설:

  ```java
  import java.util.*;
  class Student implements Comparable{
      String name;
      int ban;
      int no;
      int kor, eng, math;
  
      Student(String name, int ban, int no, int kor, int eng, int math){
          this.name = name;
          this.ban = ban;
          this.no = no;
          this.kor = kor;
          this.eng = eng;
          this.math = math;
      }
  
      int getTotal(){
          return kor+eng+math;
      }
  
      float getAverage(){
          return (int)((getTotal()/3f)*10+0.5)/10f;
      }
  
      public String toString(){
          return name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage();
      }
  
      @Override
      public int compareTo(Object o) {
          if(o instanceof Student){ // 형변환이 가능한지 확인한다. 가능하다면 true를 반환.
              Student tmp = (Student)o; // Student클래스의 tmp에 o 객체를 형변환 하여 저장.
  
              return name.compareTo(tmp.name); // 원래 String클래스에 존재하는 compareTo 메서드를 활용한 것.
            // Student로 형변환 한, o의 name을 확인하여 비교한 후, 정렬 하는 것.
            // compareTo: 
            // 매개 변수로 주어진 객체(o)를 인스턴스 자신과 비교하여 작으면 음수, 같으면 0, 크면 양수를 반환하도록 설정되어있음.
          } else {
              return -1;
          }
      }
  }
  ```





### 11-4 다음에 제시된 BanNoAscending 클래스를 완성하여, ArrayList에 담긴 Student인스턴스들이 반(ban)과 번호(no)로 오름차순 정렬되게 하시오. (반이 같은 경우, 번호를 비교하여 정렬.)

```java
import java.util.*;

class Student2 {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student2(String name, int ban, int no, int kor, int eng, int math){
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    
    int getTotal(){
        return kor+eng+math;
    }

    float getAverage(){
        return (int)((getTotal()/3f)*10+0.5)/10f;
    }

    public String toString(){
        return name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage();
    }
}

class BanNoAscending implements Comparator {
    public int compare(Object o1, Object o2){
        /*
        알맞은 코드를 넣어 완성 하시오
         */
    }
}

public class Tx11_4 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student("이자바", 2, 1, 70, 90, 70));
        list.add(new Student("안자바", 2, 2, 60, 100, 80));
        list.add(new Student("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student("김자바", 1, 2, 80, 80, 90));


        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();

        while (it.hasNext())
            System.out.println(it.next());
    }
}

결과:
남궁성, 1, 1, 90, 70, 80, 240, 80.0
김자바, 1, 2, 80, 80, 90, 250, 83.3
홍길동, 1, 3, 100, 100, 100, 300, 100.0
이자바, 2, 1, 70, 90, 70, 230, 76.7
안자바, 2, 2, 60, 100, 80, 240, 80.0
```

* 답:

  ```java
  class BanNoAscending implements Comparator {
      public int compare(Object o1, Object o2){
          if(o1 instanceof Student && o2 instanceof Student){
              Student s1 = (Student)o1;
              Student s2 = (Student)o2;
              
              int n = s1.ban - s2.ban;
              
              if(n==0){
                  return s1.no - s2.no;
              }
              
              return n;
          }
          return -1;
      }
  }
  ```

* 해설:

  ```java
  class BanNoAscending implements Comparator {
      public int compare(Object o1, Object o2){
          if(o1 instanceof Student && o2 instanceof Student){ // 형변환이 가능한지 확인.
              Student s1 = (Student)o1;	//s1 에 o1
              Student s2 = (Student)o2; //s2 에 o2를 형변환 하여 입력한다.
              
              int n = s1.ban - s2.ban; // 서로의 반을 비교하여 int n에 담는다.
              
              if(n==0){				// 만일 반이 같다면,
                  return s1.no - s2.no; // 번호를 비교하여 그 값을 반환한다.
              }
              
              return n;	// 반이 같지 않으면, 둘의 차를 반환한다.
          }
          return -1;
      }
  }
  ```

  

### ❌11-5 다음은 SutdaCard클래스를 HashSet에 저장하고 출력하는 예제이다. HashSet에 중복된 카드가 저장되지 않도록 SutdaCard의 hashCode()를 알맞게 오버라이딩 하시오.

```java
import java.util.*;
class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard(){
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang){
        this.num = num;
        this.isKwang = isKwang;
    }

    public boolean equals(Object obj){
        if(obj instanceof SutdaCard){
            SutdaCard c = (SutdaCard)obj;
            return num == c.num && isKwang == c.isKwang;
        } else {
            return false;
        }
    }

    public String toString(){
        return num+(isKwang? "K":"");
    }
}
public class Tx11_5 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3,true);
        SutdaCard c2 = new SutdaCard(3,true);
        SutdaCard c3 = new SutdaCard(1,true);

        HashSet set = new HashSet();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}

```

* 답: 못풀었음.

  ```java
  import java.util.*;
  class SutdaCard {
      int num;
      boolean isKwang;
  
      SutdaCard(){
          this(1, true);
      }
  
      SutdaCard(int num, boolean isKwang){
          this.num = num;
          this.isKwang = isKwang;
      }
  
      public boolean equals(Object obj){
          if(obj instanceof SutdaCard){
              SutdaCard c = (SutdaCard)obj;
              return num == c.num && isKwang == c.isKwang;
          } else {
              return false;
          }
      }
  
      public String toString(){
          return num+(isKwang? "K":"");
      }
  
      public int hashCode(){
          return toString().hashCode();
      }
  }
  public class Tx11_5 {
      public static void main(String[] args) {
          SutdaCard c1 = new SutdaCard(3,true);
          SutdaCard c2 = new SutdaCard(3,true);
          SutdaCard c3 = new SutdaCard(1,true);
  
          HashSet set = new HashSet();
          set.add(c1);
          set.add(c2);
          set.add(c3);
  
          System.out.println(set);
      }
  }
  
  ```

* 해설:

  ```java
  public int hashCode(){ // String의 hashCode()는 객체의 주소가 아닌, 문자열의 내용을 기반으로 해시코드를 생성하므로, 문자열의 내용이 같으면 동일한 해시코드를 반환.
          return toString().hashCode(); // toString()이 num과 isKwang의 값으로 문자열을 만들어 반환하기 때문에,
    // toString()을 호출한 곳에 hashCode()를 호출하여 구현했다.
      }
  ```





### 11-6 다음 예제의 빙고판은 1~30사이의 숫자들로 만든 것인데, 숫자들의 위치가 잘 섞이지 않는다는 문제가 있다. 이러한 문제가 발생하는 이유와 이 문제를 개선하기 위한 방법을 설명하고, 이를 개선한 새로운 코드를 작성하시오.

```java

```

