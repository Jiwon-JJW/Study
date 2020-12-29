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

  