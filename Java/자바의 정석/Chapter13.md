# CHAPTER 13

## 01. 프로세스(process)와 쓰레드(thread)

* 프로세스(process):

  * 실행중인 프로그램(program)

    프로그램을 실행하면, OS로 부터 실행에 필요한 자원(메모리)를 할당받아 프로세스가 된다.

  * 프로그램을 수행하는데 필요한 데이터와 메모리 등의 자원, 쓰레드로 구성되어있다.

  * 최소 하나 이상의 쓰레드가 존재하며, 두 개이상의 쓰레드를 가진 프로세스를 **'멀티 쓰레드 프로세스(multi-thread process)'**라 한다.

* 쓰레드(thread):

  * 프로세스의 자원을 이용하여 실제로 작업을 수행하는 것.
  * 가벼운 프로세스(경량 프로세스 LWP: light - weight process)라고 부르기도 한다.

* 프로세스는 공장, 쓰레드는 일꾼으로 생각한다면 이해하기가 쉽다.



### * 멀티 쓰레딩의 장단점

* 멀티 쓰레딩의 장점:
  * CPU의 사용률을 향상시킨다.
  * 자원을 효율적으로 사용할 수 있다.
  * 사용자에 대한 응답성이 향상된다.
  * 작업이 분리되어 코드가 간결해진다.
* 멀티 쓰레딩의 단점:
  * 여러 쓰레드가 같은 프로세스 내에서 자원을 공유하며 사용하기 때문에, 
    **동기화(synchronization), 교착상태(deadlock)**와 같은 문제를 고려해서 **신중히 프로그래밍** 해야한다.



* 멀티 쓰레딩의 예:

  * 도스(DOS)와 달리 윈도우의 경우 같은 OS인데, 윈도우는 멀티태스킹이 가능하다.
    이는 싱글 쓰레드와 멀티 쓰레드 프로그램의 차이와 같다.

  * 메신저로 채팅하며 파일을 다운로드 하거나 하는 등의 멀티태스킹이 가능한 이유가, 멀티 쓰레드로 작성되어있기 때문에.
    싱글 쓰레드는 이러한 작업이 불가능 하여, 서버 프로그램의 경우 멀티 쓰레드로 작성하는 것은 필수적이다.

    > 하나의 서버 프로세스가 여러 쓰레드를 생성해, 쓰레드와 사용자의 요청이 일대일로 처리되도록 해야한다.
    >
    > 이를 싱글 쓰레드로 작성 할 경우, 많은 시간과 메모리가 필요하기 때문에 많은 수의 사용자 요청을 서비스 하기 어렵다.



## 02. 쓰레드의 구현과 실행

* 쓰레드를 구현하는 법:
  두 가지의 방법 중, 어떤 것을 써도 상관은 없으며, 둘 다 추상메서드인 run()의 몸통{}을 채우면 된다.

  1. Tread를 상속

     * 다른 클래스를 상속받을 수 없다.

     ```java
     class MyThread extends Thread {
       public void run() { /* 작업 내용 */ } //Thread클래스의 run()을 오버라이딩
     }
     ```

  2. Runnable인터페이스를 구현

     * 일반적으로 사용하는 방법.
     * 재사용성(resuability)이 높고 코드의 일관성(consistency)을 유지할 수 있다. 보다 객체지향적인 방법.

     ```java
     class MyThread implements Runnable {
       public void run() { /* 작업 내용 */ } //Runnable 인터페이스의 run()을 구현
     }
     ```

     * 오로지 run()만 정의 되어있는 간단한 인터페이스로, 구현하기 위해서는 추상메서드인 run()의 몸통{}을 만들어 주는 것만 하면 된다.

       ```java
       public interface Runnable{
         public abstruct void run();
       }
       ```



* 예제:

  ```java
  public class Ex13_1 {
      public static void main(String[] args) {
          ThreadEx1_1 t1 = new ThreadEx1_1(); // Thread의 자손 클래스의 인스턴스를 생성.
  
          Runnable r = new ThreadEx1_2(); // Runnable을 구현한 클래스의 인스턴스를 생성
          Thread t2 = new Thread(r);     // 생성자 Thread(Runnable target)
        
        // Thread t2 = new Thread(new ThreadEx1_2()); 와 같이 하나로 합칠 수 있다.
  
          t1.start();
          t2.start();
      }
  }
  
  class ThreadEx1_1 extends Thread {
      @Override
      public void run() {
          for(int i = 0; i < 5; i++) {
              System.out.println(getName()); // 조상인 Thread의 getName()을 호출
          }
      }
  }
  
  class ThreadEx1_2 implements Runnable {
      @Override
      public void run() {
          for(int i = 0; i < 5; i++){
              // Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
              System.out.println(Thread.currentThread().getName());
          }
      }
  }
  ```

  > 위 코드의 결과:
  > Thread-0
  > Thread-0
  > Thread-0
  > Thread-0
  > Thread-0
  > Thread-1
  > Thread-1
  > Thread-1
  > Thread-1
  > Thread-1

  * Runnable인터페이스를 구현한 경우, Runnable인터페이스를 구현한 클래스의 인스턴스를 생성 후,
    이 인스턴스를 Thread클래스의 생성자의 매개변수로 제공해야한다.

    > static Thread currentThread()	현재 실행중인 쓰레드의 참조를 반환한다.
    >
    > String getName()						  쓰레드의 이름을 반환한다.



### 쓰레드의 실행 - start()

* 쓰레드를 생성 후, 반드시 start()를 호출해야 쓰레드가 실행된다.

* start()가 호출 된 후, 실행 과정은 다음과 같다.

  * 실행대기중인 쓰레드가 하나도 없다면 곧바로 실행된다.
  * 단, 실행대기중인 쓰레드가 있다면 이 쓰레드 또한 실행대기 상태에 있다가 순서에 맞춰 실행된다.

* 한 번 종료된 쓰레드는 다시 실행할 수 없다.(두 번 실행시, IllegalThreadStateException 발생)
  다만, 만일 쓰레드 작업을 한 번 더 수행해야 한다면, 새로운 쓰레드를 생성 후 start()를 해야한다.

  ```java
  ThreadEx1_1 t1 = new ThreadEx1_1();
  
  t1.start();
  t1.start(); // 예외 발생.
  ```

  ⬇️

  ```java
  ThreadEx1_1 t1 = new ThreadEx1_1();
  t1.start();
  
  t1 = new ThreadEx1_1(); // 다시 생성
  t1.start(); // OK.
  ```



### start()와 run()

* start()와 run()의 차이
  * run(): 
    * 생성된 쓰레드를 실행시키는 것이 아닌, 클래스에 선언된 메서드를 호출 하는 것.
  * start():
    * 새로운 스레드가 작업을 실행하는데 필요한 호출스택(call stack)을 생성한 다음,
      run()을 호출해, 생성된 호출스택에 run()이 첫 번째로 올라가게 한다.
    * 모든 쓰레드는 독립적인 작업을 수행하기 위해, 호출스택을 필요로한다.
      새로운 쓰레드를 생성하고 실행시킬 때 마다 호출스택이 새롭게 생성되고, 쓰레드 종료 시 사용한 호출스택 또한 소멸된다.
* 쓰레드가 실행되는 과정
  1. main메서드에서 쓰레드의 start()를 호출한다.
      ![스크린샷 2021-01-02 오후 6 37 56](https://user-images.githubusercontent.com/69128652/103454664-a3151d80-4d29-11eb-8885-93d66782c8f7.png)
  2. start()는 새로운 쓰레드를 생성 후, 쓰레드가 작업하는데 사용될 호출 스택 생성
     ![스크린샷 2021-01-02 오후 6 38 39](https://user-images.githubusercontent.com/69128652/103454679-bd4efb80-4d29-11eb-9075-b607815dea5c.png)
  3. 새로 생성된 호출스택에 run()이 호출되어, 쓰레드가 독립적인 작업을 수행.
     ![스크린샷 2021-01-02 오후 6 39 05](https://user-images.githubusercontent.com/69128652/103454686-ccce4480-4d29-11eb-8b9d-a4b3b0ca0d21.png)
  4. 호출스택이 2개이므로, 스케줄러가 정산 순서에 의해 번갈아 가며 실행.
     ![스크린샷 2021-01-02 오후 6 39 26](https://user-images.githubusercontent.com/69128652/103454689-d9529d00-4d29-11eb-8f0b-7cf5797c738d.png)

### main 쓰레드

* main 메서드의 작업을 수행하는 것도 쓰레드다. 이를 main쓰레드라고 한다.

* 프로그램을 실행하면, 기본적으로 하나의 쓰레드를 생성하고, 그 쓰레드가 main메서드를 호출해서 작업이 수행되도록 하는 것이다.

  ![스크린샷 2021-01-02 오후 6 47 50](https://user-images.githubusercontent.com/69128652/103454827-05225280-4d2b-11eb-9dac-8633706e097a.png)

  * main메서드가 수행을 마쳤다고 하더라도, 다른 쓰레드가 아직 작업을 마치지 않았다면 프로그램이 종료되지 않는다.

    > 실행 중인 사용자 쓰레드가 하나도 없을 때 프로그램은 종료된다.

* 쓰레드의 종류는 '사용자 쓰레드(user thread)'와 '데몬 쓰레드(daemon thread)'가 있는데,
  사용자 쓰레드는 'non-daemon thread'라고도 한다.



## 03. 싱글쓰레드와 멀티쓰레드

* 동일하게 두 작업(t1, t2)을 진행하는 경우: 

  * 싱글 쓰레드:

    한 작업을 완전히 마친 수, 다음 작업을 진행한다.
    ![스크린샷 2021-01-02 오후 7 05 33](https://user-images.githubusercontent.com/69128652/103455119-7f53d680-4d2d-11eb-8be3-2ca59a8e7550.png)

  * 멀티 쓰레드:

    짧은 시간 동안 2개의 쓰레드(t1, t2) 가 번갈아 가면서 작업을 수행해, 동시에 두 작업이 처리되는 것 처럼 느껴지게 한다.
    ![스크린샷 2021-01-02 오후 7 08 00](https://user-images.githubusercontent.com/69128652/103455156-d659ab80-4d2d-11eb-96f6-9b07d072711c.png)

  

* 하나의 쓰레드로 두 개의 작업을 수행한 시간과 두 개의 쓰레드로 두 개의 작업을 수행한 시간은 거의 같다.
  오히려 멀티 쓰레드 작업시간이 더 걸리게 되는데, 이는 **쓰레드간의 작업전환(context switching)**에 시간이 걸리기 때문.

  * 작업전환 시, 현재 진행중인 작업 상태(ex. 다음에 실행해야 할 위치를 가리키는 PC(프로그램 카운터) 등 )를 저장하고 읽어오는 데 시간이 소요됨.

  * 쓰레드 스위칭에 비해, 프로세스의 스위칭이 더 많은 정보를 저장해야하므로, 더 많은 시간 소요됨.

    > 이러한 작업 전환을 '컨텍스트 스위칭(context switching)'이라고 한다.

* 때문에, CPU를 사용하는 단순 계산 작업이면 멀티쓰레드보다 싱글쓰레드가 효율적이다.





* 예제1:

  * '-'를 출력하는 작업과 '|'를 출력하는 작업을 하나의 쓰레드가 연속적으로 처리하는 시간을 측정하는 예제.
  * 일부러 new String("-")를 사용해 속도를 늦춤.

  ```java
  public class Ex13_2 {
      public static void main(String[] args) {
          long startTime = System.currentTimeMillis();
  
          for(int i =0; i < 300; i++){
              System.out.printf("%s", new String("-"));
          }
  
          System.out.print("소요시간1:"+(System.currentTimeMillis() - startTime));
  
          for (int i=0; i< 300; i++){
              System.out.printf("%s", new String("|"));
          }
          System.out.print("소요시간2:"+(System.currentTimeMillis() - startTime));
      }
  }
  ```

  > 위 코드의 결과:
  > ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------소요시간1:51||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||소요시간2:70



* 예제2:

  ```java
  public class Ex13_3 {
      static long startTime = 0;
  
      public static void main(String[] args) {
          ThreadEx3_1 th1 = new ThreadEx3_1();
          th1.start();
          startTime = System.currentTimeMillis();
  
          for(int i =0; i < 300; i++){
              System.out.printf("%s", new String("-"));
          }
  
          System.out.print("소요시간1:"+(System.currentTimeMillis() - Ex13_3.startTime));
      }
  }
  
  class ThreadEx3_1 extends Thread {
      @Override
      public void run() {
          for (int i=0; i< 300; i++){
              System.out.printf("%s", new String("|"));
          }
          System.out.print("소요시간2:"+(System.currentTimeMillis() - Ex13_3.startTime));
      }
  }
  ```

  > 위 코드의 결과:
  > ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||--------------------|||||||||||||||||||||||||||||||||||---------------------------------------------------||||||||||||||||||||||||||||||||||||||||||--------------------------------------------------------------------------------------------------------------------------------|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||-----------------------------------------------------------------------------------------------------소요시간1:72소요시간2:67

  * 두 개의 쓰레드로 작업하는데, 더 많은 시간이 걸린 이유:

    1. 두 쓰레드가 번갈아가며 작업을 처리하기 때문에, 작업전환 시간이 소요됨.
    2. 한 쓰레드가 화면에 출력하고 있는 동안, 다른 쓰레드는 출력이 끝나기를 기다리며 발생하는 대기 시간 때문.

  * 멀티 코어는 동시에 두 쓰레드가 수행될 수 있으므로, 멀티 코어냐 싱글 코어냐도 소요시간에 영향을 끼친다. 

    > 멀티 코어의 경우, 화면(console)이라는 자원을 놓고 두 쓰레드가 경쟁하게 됨.

  * 위 결과는 OS의 프로세스 스케줄러의 영향을 받기 때문에, 실행할 때마다 다른 결과를 얻을 수 있다.
    JVM의 쓰레드 스케줄러에 의해 어떤 쓰레드가 얼마동안 실행될 것인지 결정되는 것과 같이, 프로세스도 프로세스 스케줄러에 의해 실행 순서와 시간이 결정되기 때문에 매 상황마다 일정하지 않기 때문이다.

  * 쓰레드가 이러한 불확실성을 가지고 있다는 것을 염두에 두어야한다.

    > OS(플랫폼) 독립적이라고 하지만, OS종속적인 부분이 몇가지 있는데, 그 중 하나가 쓰레드.



## 04. 쓰레드의 I/O블락킹(blocking)

>  입출력(I/O) 처리를 위해 기다리는 것을 I/O블락킹(blocking)이라 한다.

* 두 쓰레드가 서로 다른 자원을 사용하는 작업의 경우,싱글 쓰레드 프로세스보다 멀티 쓰레드 프로세스가 더 효율적이다.
  * ex) 데이터를 입력받는 작업, 네트워크로 파일을 주고받는 작업, 프린터로 파일을 출력하는 작업 등.
    외부기기와의 입출력을 필요로 하는 경우.
* 입출력이 필요한 경우, 사용자로부터 입력을 기다리는 구간에서 
  * 싱글 쓰레드 프로세스의 경우:
    아무 일도 하지 못한다. 한 가지 작업이 모두 완료가 되어야 다음으로 넘어가기 때문.
  * 멀티 쓰레드 프로세스의 경우:
    다른 쓰레드가 입력을 받는 동안 작업을 처리할 수 있기 때문에, 보다 효율적인 CPU의 사용이 가능하다.



* 예제1:
  하나의 쓰레드로 사용자의 입력을 받는 작업과, 화면에 숫자를 출력하는 작업을 처리함.
  입력 전에는 작동하지 않다가, 입력 완료 후 작업이 시작된다.

  ```java
  import javax.swing.JOptionPane;
  
  public class Ex13_4 {
      public static void main(String[] args) throws Exception {
          String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
          System.out.println("입력하신 값은" + input + "입니다.");
  
          for(int i = 10; i >0 ; i --){
              System.out.println(i);
  
              try {
                  Thread.sleep(1000); // 1초간 시간을 지연한다.
              } catch (Exception e){
  
              }
          }
      }
  }
  ```

  > 위 코드의 결과:
  > 입력하신 값은asfsd입니다.
  > 10
  > 9
  > 8
  > 7
  > 6
  > 5
  > 4
  > 3
  > 2
  > 1



* 예제2:
  이전의 예제와 달리, 두 개의 쓰레드로 나누어 처리했기 때문에, 입력하는 동안 숫자가 출력된다.

  ```java
  import javax.swing.JOptionPane;
  
  public class Ex13_5 {
      public static void main(String[] args) {
          ThreadEx5_1 th1 = new ThreadEx5_1();
          th1.start();
  
          String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
          System.out.println("입력하신 값은"+input+"입니다.");
      }
  }
  
  class ThreadEx5_1 extends Thread {
      public void run(){
          for(int i =10; i >0; i--){
              System.out.println(i);
              try {
                  sleep(1000);
              } catch (Exception e){
  
              }
          }
      } // run()
  }
  ```

  > 위 코드의 결과:
  > 10
  > 9
  > 8
  > 7
  > 6
  > 입력하신 값은asd입니다.
  > 5
  > 4
  > 3
  > 2
  > 1



## 05. 쓰레드의 우선순위

* 쓰레드는 우선순위(priority)라는 속성(멤버변수)을 가지고 있다.
  이 우선순위의 값에 따라 얻는 실행시간이 달라짐.
* 쓰레드가 수행하는 작업의 중요도에 따라 쓰레드의 우선순위를 다르게 하여 특정 쓰레드의 작업시간을 더 많이 갖도록 할 수 있음.
  * 시각적인 부분이나, 사용자에게 빠르게 반응해야하는 작업을 하는 쓰레드의 우선순위는 다른 쓰레드 보다 높아야함.
    (ex. 파일 전송 기능이 있는 메신저의 경우, 메세지 발송 쓰레드의 우선순위가 높아야, 채팅하는 것에 불편함이 없다.)



#### 우선순위 지정하기

```java
void setPriority(int newPriority) // 쓰레드의 우선순위를 지정한 값으로 변경한다.
int  getPriority()								// 쓰레드의 우선순위를 반환한다.

public static final int MAX_PRIORITY = 10 // 최대 우선순위
public static final int MIN_PRIORITY = 1  // 최소 우선순위
public static final int NORM_PRIORITY = 5 // 보통 우선순위
```

* 우선순위의 범위는 1~10이며, 숫자가 높을수록 우선순위가 높음.
* 쓰레드의 우선순위는 쓰레드를 생성한 쓰레드로부터 상속받음.
  main메서드를 수행하는 쓰레드는 우선순위가 5이므로, main메서드 내에서 생성하는 우선순위는 자동적으로 5가 됨.



* 예제:

  ```java
  public class Ex13_6 {
      public static void main(String[] args) {
          ThreadEx6_1 th1 = new ThreadEx6_1();
          ThreadEx6_2 th2 = new ThreadEx6_2();
  
          th2.setPriority(7); // start()전에 우선순위를 지정해야한다.
  
          System.out.println("Priority of th1(-) : "+ th1.getPriority());
          System.out.println("Priority of th2(-) : "+ th2.getPriority());
  
          th1.start();
          th2.start();
      }
  }
  
  class ThreadEx6_1 extends Thread {
      @Override
      public void run() {
          for(int i = 0; i<300; i++){
              System.out.print("-");
              for (int x = 0; x <10000000; x++);
          }
      }
  }
  
  class ThreadEx6_2 extends Thread {
      @Override
      public void run() {
          for(int i = 0; i<300; i++){
              System.out.print("|");
              for (int x = 0; x <10000000; x++);
          }
      }
  }
  ```

  > 위 코드의 결과:
  > Priority of th1(-) : 5
  > Priority of th2(-) : 7
  > -|-|----------------------------------|||||||||||||||||||||||||||||||||||----------|||||||||||||||||||||----------------------------------------------------------------------------------------------------------------||||||||--------------------------------------------------------------------------||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||--------------------------------------------------------------------||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

  * main메서드에서 생성하였기 때문에, 우선순위인 5를 상속받았다.
    이후, `th2.setPriority(7);`로 우선순위를 7로 변경 후, start()로 쓰레드를 실행시킴. 
     start() 이전에만 우선순위를 변경할 수 있다.

    

## 06. 쓰레드 그룹(thread group)

* 쓰레드 그룹?

  * 서로 관련된 쓰레드를 그룹으로 다루기 위한 것.

  * 폴더를 생성해, 파일들을 넣어 관리하는 것 처럼 쓰레드 그룹을 생성해, 관리 할 수 있다.

    폴더 내부에 폴더를 생성하는 것이 가능한 것처럼, 쓰레드 그룹에 다른 쓰레드 그룹을 만들어 포함시킬 수 있다.

  * 보안상의 이유로 도입된 개념으로, 자신이 속한 쓰레드 그룹, 하위 쓰레드 그룹은 변경할 수 있지만, 
    다른 쓰레드 그룹의 쓰레드를 변경할 수 없음.



* 쓰레드 그룹에 포함시키려면 Thread 생성자를 이용한다.

  ```java
  Thread(ThreadGroup group, String name)
  Thread(ThreadGroup group, Runnable target)
  Thread(ThreadGroup group, Runnable target, String name)
  Thread(ThreadGroup group, Runnable target, String name, long stackSize)
  ```

  * 모든 쓰레드는 반드시 쓰레드 그룹에 포함되어야 하기 때문에, 쓰레드 그룹이 지정되지 않은 채 생성된 쓰레드는
    자신을 생성한 쓰레드와 같은 쓰레드 그룹에 속함.
  * JVM은 자바 어플리케이션 실행 시, main과 system이라는 쓰레드 그룹을 만들어, 운영에 필요한 쓰레드를 각각의 그룹에 포함시킨다.
    기본적으로 아무런 그룹 지정 없이 생성하는 쓰레드들은 자동적으로 main쓰레드 그룹의 하위 쓰레드 그룹이 되어, 이 그룹에 속하게 됨.



* Thread의 쓰레드 그룹과 관련된 메서드:

  ```java
  ThreadGroup getThreadGroup() // 쓰레드 자신이 속한 쓰레드 그룹을 반환한다.
  void uncaughtException(Thread t, Throwable e)
  // 처리되지 않은 예외에 의해 쓰레드 그룹의 쓰레드가 실행 종료 되었을 때, JVM에 의해 이 메서드가 자동 호출됨.
  ```

  



### 쓰레드 그룹(thread group) 메서드

| 생성자 / 메서드                                              | 설명                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| ThreadGroup (String name)                                    | 지정된 이름의 새로운 쓰레드 그룹을 생성                      |
| ThreadGroup (ThreadGroup, String name)                       | 지정된 쓰레드 그룹에 포함되는 새로운 쓰레드 그룹을 생성      |
| int activeCount()                                            | 쓰레드 그룹에 포함된 활성상태에 있는 쓰레드의 수를 반환      |
| int activeGroupCount()                                       | 쓰레드 그룹에 포함된 활성상태에 있는 쓰레드 그룹의 수를 반환 |
| void checkAccess()                                           | 현재 실행중인 쓰레드가 쓰레드 그룹을 변경할 권한이 있는지 체크.<br />만일 권한이 없다면, SecurityException을 발생시킨다. |
| void destroy                                                 | 쓰레드 그룹과 하위 쓰레드 그룹까지 모두 삭제한다.<br />단, 쓰레드 그룹이나 하위 쓰레드 그룹이 비어있어야한다. |
| int enumerate(Thread[] list),<br />int enumerate(Thread[] list, boolean recurse),<br />int enumerate(ThreadGroup[] list),<br />int enumerate(ThreadGroup[] list, boolean recurse) | 쓰레드 그룹에 속한 쓰레드 또는 하위 쓰레드 그룹의 목록을 지정된 배열에 담고 그 개수를 반환.<br />두 번째 매개변수인 recurse의 값을 true로 하면 쓰레드 그룹에 속한<br />하위 쓰레드 그룹에 쓰레드 또는 쓰레드 그룹까지 배열에 담는다. |
| int getMaxPriority()                                         | 쓰레드 그룹의 최대 우선순위를 반환                           |
| String getName()                                             | 쓰레드 그룹의 이름을 반환                                    |
| ThreadGroup getParent()                                      | 쓰레드 그룹의 상위 쓰레드 그룹을 반환                        |
| void interrupt()                                             | 쓰레드 그룹에 속한 모든 쓰레드를 interrupt                   |
| boolean isDaemon()                                           | 쓰레드 그룹이 데몬 쓰레드 그룹인지 확인                      |
| boolean isDestroyed()                                        | 쓰레드 그룹이 삭제되었는지 확인                              |
| void list()                                                  | 쓰레드 그룹에 속한 쓰레드와 하위 쓰레드 그룹에 대한 정보를 출력 |
| boolean parentOf(ThreadGroup g)                              | 지정된 쓰레드 그룹의 상위 쓰레드 그룹인지 확인               |
| void setDaemon(boolean daemon)                               | 쓰레드 그룹을 데몬 쓰레드 그룹으로 설정/해제                 |
| void setMaxPriority(int pri)                                 | 쓰레드 그룹의 최대 우선순위를 설정                           |





## 07. 데몬 쓰레드 (daemon thread)

* 다른 일반 쓰레드의 작업을 돕는 보조적인 역할을 수행하는 쓰레드.
  때문에, 일반 쓰레드가 모두 종료될 경우, 데몬 쓰레드 또한 자동 종료된다.

* 사용 예시:
  가비지 컬렉터, 워드 프로세서의 자동저장, 화면 자동갱신 등.

* 작성 방법:
  무한 루프와 조건문을 이용해 실행 한 후,대기 상태에서 특정 조건이 만족되면 작업을 수행하고 다시 대기상태로 돌아가도록 작성해야한다.

  ```java
  public void run() {
    while(true) {
      try {
        Thread.sleep(3*1000);
      } catch(InterruptedException e){}
      
      // autoSave의 값이 true라면, autoSave()를 호출.
      if(autoSave) autoSave();
    }
  }
  ```

   

* 실행 방법:
  일반 쓰레드와 비슷하나, 실행하기 전 `setDaemon(true)` 를 호출 해야한다.

  > `boolean isDaemon()`
  >
  > * 쓰레드가 데몬 쓰레드인지 확인한다. 데몬 쓰레드면 true 반환.
  >
  > `void setDaemon(boolean on)`
  >
  > * 쓰레드를 데몬 쓰레드 또는 사용자 쓰레드로 변경한다.
  >   매개변수 on의 값을 true로 변경 시, 데몬쓰레드로 변경.

* 예제:

  ```java
  public class Ex13_7 implements Runnable {
      static boolean autoSave = false;
  
    public static void main(String[] args) {
      Thread t = new Thread(new Ex13_7()); // 이 부분이 없으면 동료되지 않음.
      t.setDaemon(true);
      t.start();
  
      for(int i = 1; i <= 10; i++){
        try {
          Thread.sleep(1000);
        }catch (InterruptedException e){}
        System.out.println(i);
  
        if(i==5) autoSave = true;
  
      }
      System.out.println("프로그램을 종료합니다.");
    }
    public void run() {
      while (true) {
        try {
          Thread.sleep(3*1000); // 3초마다
        } catch (InterruptedException e) {}
  
        // autoSave의 값이 true면, autoSave()를 호출.
        if(autoSave) autoSave();
  
      }
    }
  
    public void autoSave() {
      System.out.println("작업파일이 자동 저장 되었습니다.");
    }
  }
  
  
  ```

  > 결과:
  > 1
  > 2
  > 3
  > 4
  > 5
  > 작업파일이 자동 저장 되었습니다.
  > 6
  > 7
  > 8
  > 작업파일이 자동 저장 되었습니다.
  > 9
  > 10
  > 프로그램을 종료합니다.

* 3초마다 autoSave의 값을 확인하여 값이 true라면 계속 autoSave()를 호출하는 무한 반복 쓰레드를 작성함.
  이 쓰레드가 데몬쓰레드가 아니었다면, 강제종료 하지 않는 이상 종료되지 않았다.

* setDeamon메서드는 start()호출 전에 반드시 실행해야 한다.

