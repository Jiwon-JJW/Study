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



## 08. 쓰레드의 상태

| 상태                       | 설명                                                         |
| -------------------------- | ------------------------------------------------------------ |
| NEW                        | 쓰레드가 생성되었지만, start()가 호출 되지 않은 상태         |
| RUNNABLE                   | 실행 중 또는 실행 가능한 상태                                |
| BLOCKED                    | 동기화블럭에 의해서 일시정지된 상태(lock이 풀릴 때 까지 대기 상태) |
| WAITING,<br />TIMED_WATING | 쓰레드 작업이 종료되지는 않았지만 실행이 가능하지 않은 일시정지 상태(UNRUNNABLE).<br />TIME_WAITING 은 일시정지 시간이 정해진 경우 |
| TERMINATED                 | 쓰레드의 작업이 종료된 상태                                  |

* 쓰레드 상태 변화 과정:
  1. 쓰레드가 생성 된 후(NEW), start() 호출 시, 실행 대기열에 저장되어 자신의 순번을 기다린다.
     이 때, 실행 대기열은 큐(Queue)의 구조와 같아, 먼저 들어온 쓰레드가 먼저 실행됨.
  2. 실행 순번이 돌아왔을 경우, 실행상태로 변경.
  3. 주어진 실행시간이 완료되거나, yield()를 만날 경우 실행 대기 상태로 돌아가며, 이후 순번의 쓰레드가 실행상태가 됨.
  4. 쓰레드 실행 도중, suspend(), sleep(), wait(), join(), I/O block(입출력 작업에서 발생되는 지연상태. 사용자 입력 대기 등을 의미.)에 의해 일시정지 상태가 될 수 있다.
  5. 지정된 일시정지 시간(time-out)이 다되거나, notify(), resume(), interrupt() 호출 시, 일시정지 상태에서 벗어나, 실행대기열에 저장되어 다시 순번을 기다림.
  6. 실행이 완료 되거나, stop() 호출 시, 쓰레드 소멸.



### * 쓰레드 실행제어

* 효율적인 멀티쓰레드 프로그램을 만들기 위해서는, 정교한 스케줄링(scheduling)을 통해 프로세스에게 주어진 자원과 시간을 여러 쓰레드가 낭비없이 사용하도록 프로그래밍 해야됨.

  > 쓰레드 프로그래밍이 어려운이유는, 동기화(synchronization)과 스케줄링(scheduling)때문이다.

* 쓰레드 스케줄링 메서드:

  | 메서드                                                       | 설명                                                         |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | static void sleep(long millis)<br />static void sleep(long millis, int nanos) | 지정된 시간(천분의 일초 단위)동안 쓰레드를 일시정지시킴.<br />지정한 시간 후에는 자동적으로 다시 실행대기 상태가 됨. |
  | void join()<br />void join(long millis)<br />void join(long millis, int nanos) | 지정된 시간동안 쓰레드가 실행됨.<br />지정된 시간이 지나거나 작업 종료시, join()을 호출한 쓰레드로 돌아와 실행을 계속함. |
  | void interrupt()                                             | sleep()이나 join()에 의해 일시정지상태인 쓰레드를 깨워서 실행대기 상태로 만듬. <br />해당 쓰레드에서는 intterupted Exception이 발생함으로써 일시정지 상태 벗어남. |
  | void stop()                                                  | 쓰레드 즉시 종료                                             |
  | void suspend()                                               | 쓰레드를 일시정지 시킴.<br />resume() 호출 시, 다시 실행대기 상태로 돌아간다. |
  | void resume()                                                | suspend()에 의해 일시정지 상태가 된 쓰레드를 실행대기 상태로 만듬. |
  | static void yield()                                          | 실행 중, 주어진 실행시간을 다른 쓰레드에게 양보(yield)하고, 자신은 실행대기 상태가 됨. |



### 1. sleep()

* 지정된 시간동안 쓰레드가 멈춘다.

* 밀리세컨드와 나노세컨드의 시간단위로 세밀한 값 지정이 가능하지만, 어느정도 오차가 발생할 수 있다.

* 사용 예시:

  ```java
  try{
    Thread.sleep(1,500000); // 쓰레드를 0.0015초 동안 멈추게 함.
  }catch(InterruptedException e){}
  ```

* 일시정지가 된 쓰레드는, 지정된 시간이 다되거나 interrupt()호출 시, InterruptedException발생으로 실행대기 상태로 돌아간다.
  따라서, sleep()호출 시 항상 try-catch문으로 예외처리를 시켜줘야함.



* 예제:

  ```java
  public class Ex13_8 {
      public static void main(String[] args) {
          ThreadEx8_1 th1 = new ThreadEx8_1();
          ThreadEx8_2 th2 = new ThreadEx8_2();
  
          th1.start();
          th2.start();
  
          try {
              th1.sleep(2000); 
          }catch (InterruptedException e){
  
          }
  
          System.out.println("<<main 종료>>");
      }
  }
  
  class ThreadEx8_1 extends Thread {
      @Override
      public void run() {
          for(int i = 0; i< 300; i++){
              System.out.print("-");
          }
      }
  }
  
  class ThreadEx8_2 extends Thread {
      @Override
      public void run() {
          for(int i = 0; i< 300; i++){
              System.out.print("|");
          }
      }
  }
  ```

  > 위 코드의 결과:
  > ----------------------------------||||||||||||||||||||||||||||----------||----------------------------------------------------|||||||||||||||||||||||||||----------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|----------------------------|||||||||||||<<th1 종료>>||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||<<th2 종료>><<main 종료>>

  * th1을 sleep(2000);으로 멈췄음에도 불구하고 먼저 종료된 이유는, sleep()이 main에서 실행되었기 때문에 main쓰레드 자체가 sleep()에 영향을 받기 때문이다.
    th1에 sleep()을 적용하고 싶다면, th1 쓰레드 내에 적용해야됨.

### 2. interrupt()

* 진행중인 쓰레드의 작업을 도중에 취소하고 싶은 경우에 보통 사용이 된다.
  interrupt()발생 시, 쓰레드에게 작업을 멈추라고 요청하는데, 쓰레드가 멈추는 것 일 뿐 종료되진 않는다.

  > 그냥 interrupted상태(인스턴스 변수를 바꾸는 것.

* interrupted() : 쓰레드에 대해, interrupt()가 호출되었는지 알려주는 메소드.
  true / false로 알려준다.

* 사용 예시:

  ```java
  Thread th = new Thread();
  th.start();
    ...
  th.interrupt(); // interrupt() 호출
  	...
  class MyThread extends Thread {
    public void run(){
      while(!interrupted()){ // interrupted()가 false일동안 반복
        ...
      }
    }
  }
  ```

* isInterrupted()도 쓰레드의 interrupt()가 호출 되었는지 확인 할 수 있지만, interrupted()와 같이 false로 초기화 하지 않는다.

  ```java
  void interrupt()						 // 쓰레드의 interrupted 상태를 false에서 true로 변경
  boolean isInterrupted()			 // 쓰레드의 interupted 상태를 반환
  static boolean interrupted() // 현재 쓰레드의 interrupted 상태 반환 후, false로 변경
  ```



* 예제:

  ```java
  import javax.swing.*;
  
  public class Ex13_9 {
      public static void main(String[] args) {
          ThreadEx9_1 th1 = new ThreadEx9_1();
          th1.start();
  
          String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
          System.out.println("입력하신 값은 "+input+"입니다.");
          th1.interrupt(); // interrupt()호출 시, interrupted 상태가 true로 변경.
          System.out.println("isInterrupted():"+th1.isInterrupted());
      }
  }
  
  class ThreadEx9_1 extends Thread{
      @Override
      public void run() {
          int i = 10;
  
          while (i!=0 && !isInterrupted()){
              System.out.println(i--);
              for (long x = 0; x<2500000000L; x++); // 시간 지연
          }
          System.out.println("카운트 종료");
      }
  }
  ```

  > 결과:
  > 10
  > 9
  > 8
  > 7
  > 입력하신 값은 1입니다.
  > isInterrupted():true
  > 카운트 종료



### 3. suspend(), resume(), stop()

* suspend()는 sleep()처럼 쓰레드를 멈추게 만들지만, sleep()과는 달리 resume()을 수동으로 호출 해 줘야, 다시 실행상태로 돌아간다.
* stop()은 호출 즉시 쓰레드가 종료됨.
* 이 세개의 메서드는 쓰레드의 실행제어가 손쉽지만, suspend()와 stop()이 교착상태(deadlock)를 일으키기 쉽게 구성되어있으므로, 권장되는 메서드는 아니다.
* 하위 호환성을 위해 삭제되지 않았으므로, 사용하지 않는 것이 좋다. 



* 예제:

  ```java
  public class Ex13_10 {
      public static void main(String[] args) {
          RunImplEx10 r = new RunImplEx10();
  
          Thread th1 = new Thread(r, "*");
          Thread th2 = new Thread(r, "**");
          Thread th3 = new Thread(r, "***");
  
          th1.start();
          th2.start();
          th3.start();
  
          try {
              Thread.sleep(2000);
              th1.suspend();
              Thread.sleep(2000);
              th2.suspend();
              Thread.sleep(3000);
              th1.resume();
              Thread.sleep(3000);
              th1.stop();
              th2.stop();
              Thread.sleep(2000);
              th3.stop();
          }catch (InterruptedException e){
  
          }
  
      }
  }
  
  class RunImplEx10 implements Runnable {
      @Override
      public void run() {
          while (true){
              System.out.println(Thread.currentThread().getName());
              try {
                  Thread.sleep(1000);
              }catch (InterruptedException e){
  
              }
          }
  
      }
  }
  ```

  > 결과:
  >
  > ```
  > *
  > **
  > ***
  > *
  > **
  > ***
  > *
  > ***
  > *
  > ***
  > *
  > ***
  > *
  > **
  > ***
  > **
  > ```



### 4. join()과 yield()

* join() - 다른 쓰레드의 작업을 기다린다.
  * 쓰레드가 하던 작업을 잠시 멈추고, 다른 쓰레드가 지정된 시간동안 작업을 수행하도록 할 때 사용.
  * 시간 미지정시, 해당 쓰레드가 작업을 마칠때 까지 대기하게 됨.
  * sleep()과 동일하게 interrupt()에 의해 대기상태에서 벗어날 수 있으며, 호출되는 부분을 try-catch문으로 감싸야 한다.
  * sleep()과 유사한점이 많지만, 다른점은 특정 쓰레드에 대해 동작하므로, static이 아니라는 점이다.
* yield() - 다른 쓰레드에게 양보한다.
  * 자신에게 주어진 실행시간을 다음 차례의 쓰레드에게 양보한다.
  * 1초간의 실행시간이 주어졌다 할 때, 0.5초를 사용 후 yield() 호출 시, 나머지 0.5초는 포기하고 실행 대기 상태가 된다.
* 위의 두개의 메서드를 적절히 사용 시, 프로그램의 응답성을 높이고 효율적인 실행을 가능하게 할 수 있다.



* 예제:

  ```java
  public class Ex13_11 {
      static long startTime = 0;
  
      public static void main(String[] args) {
          ThreadEx11_1 th1 = new ThreadEx11_1();
          ThreadEx11_2 th2 = new ThreadEx11_2();
          th1.start();
          th2.start();
          startTime = System.currentTimeMillis();
  
          try {
              th1.join(); // main쓰레드가 th1의 작업이 끝날 때 까지 대기.
              th2.join(); // main쓰레드가 th2의 작업이 끝날 때 까지 대기.
          }catch (InterruptedException e){}
  
          System.out.print("소요시간:"+(System.currentTimeMillis() - Ex13_11.startTime));
      }
  
  }
  
  class ThreadEx11_1 extends Thread{
      @Override
      public void run() {
          for(int i = 0; i < 300; i++){
              System.out.print("-");
          }
      }
  }
  
  class ThreadEx11_2 extends Thread{
      @Override
      public void run() {
          for(int i = 0; i < 300; i++){
              System.out.print("|");
          }
      }
  }
  ```

  > 결과:
  > ------------------------------------------------------------------------------------------------------------||||||||||||||||||-----------------------------------------------------------------------------------------------------------------------------------------------------------|||-|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||----|||||||||||||||||||||||||||||||||--------------------------------|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||소요시간:6

  * join() 미사용시, main 쓰레드는 바로 종료되었겠지만, join()을 사용함으로써 두 쓰레드의 작업 소요시간을 출력할 수 있는 것.



### 5. 쓰레드의 동기화(synchronization)

* 멀티 쓰레드를 사용하는 프로세스의 경우, 프로세스의 자원을 공유하여 사용하는 멀티 쓰레드 특성 상, 서로의 작업에 영향을 주게 된다.
* 예시로, 쓰레드 A의 작업 도중 다른 쓰레드에게 제어권이 넘어가게 되었을 때, 그 쓰레드가 공유 데이터를 임의로 변경한다면 쓰레드 A가 나머지 작업을 처리할 때, 원래 의도와 다른 결과를 얻을 수 있다.
  * 이런 일을 방지하기 위해, 한 쓰레드가 특정 작업을 마치기 전까지 다른 쓰레드에 의해 방해받지 않도록 도입된 개념이 '임계영역(critical section)'과 '잠금(lock)'이다.



* 한 쓰레드가 진행중인 작업을 다른 쓰레드가 간섭하지 못하도록 막는것을 '쓰레드의 동기화(synchronization)' 라고 한다.

  > 공유데이터를 사용하는 코드를 임계 영역으로 잡아놓고, lock을 획득한 쓰레드만 이 영역 내의 코드를 수행하고, 모든 코드 수행 시 lock을 반납해야만 다른 쓰레드가 lock을 획득하여 임계영역의 코드를 수행하는 식.
  > 공중화장실과 같은 것으로 생각하면 더욱 이해가 쉽다.

* synchronized 블럭으로 동기화 지원이 되고, JDK1.5 부터 'java.util.concurrent.lock', 'java.util.concurrent.atomic'패키지를 통해서도 동기화를 구현할 수 있다.





#### synchronized를 이용한 동기화

* 이 키워드는 임계 영역을 설정하는 데 사용되며, 두가지 방식이 있다.

  1. 메서드 전체를 임계 영역으로 지정

     ```java
     public synchronized void calcSum(){
       //...
     }
     ```

     * 메서드 앞에 synchronized를 붙여서 사용.
       메서드 전체가 임계 영역으로 설정되며, synchronized메서드가 호출된 시점부터 lock을 얻어 수행 후, 메서드 종료 시 lock을 반환.

  2. 특정한 영역을 임계 영역으로 지정

     ```java
     synchronized(객체의 참조변수){
       // ...
     }
     ```

     * 메서드 내의 코드 일부를 블럭으로 감싸고, 블럭 앞에 synchronized(참조변수)를 붙이는 것.
       참조변수는 락을 걸고자 하는 객체를 참조하는 것이어야 한다.
     * 이 블럭을 synchronized블럭이라고 부르며, 블럭의 영역 안으로 들어가면서부터 쓰레드는 지정된 객체의 lock을 얻게 되고, 블럭을 벗어날 때 lock을 반납한다.

* 두 방식 모두 lock을 반환하고 얻는 과정은 자동이므로, 임계 영역만 지정해주면 된다.
  메서드 전체에 락을 거는 것 보다, synchronized블럭으로 임계 영역을 최소화 하여 효율적인 프로그램이 되도록 하는 것이 좋다.



* 예제1:

  ```java
  public class Ex13_12 {
      public static void main(String[] args) {
          Runnable r = new RunnableEx12();
  
          new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상 아님.
          new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상 아님.
      }
  }
  
  class Account {
      private int balance = 1000;
  
      public int getBalance(){
          return balance;
      }
  
      public void withdraw(int money){
          if(balance >= money){ // 출금액보다 잔고가 클 때
              try {
                  Thread.sleep(1000);
              }catch (InterruptedException e){ }
              balance -= money;
          }
      }
  }
  
  class RunnableEx12 implements Runnable {
      Account acc = new Account();
  
      @Override
      public void run() {
          while (acc.getBalance() > 0){
              // 100, 200, 300중 한 값을 임의로  선택하여 출금(withdraw)
              int money = (int)(Math.random() * 3 + 1)*100;
              acc.withdraw(money);
  
              System.out.println("balance:"+acc.getBalance());
          }
      }
  }
  ```

  > 결과:
  > balance:800
  > balance:700
  > balance:600
  > balance:300
  > balance:200
  > balance:-100
  > balance:-300

  * 출금 액보다 잔고가 클 때만 가능하도록 설정 해두었지만, 동기화 처리가 제대로 이루어지지 않아 음수가 출력되는 경우를 볼 수 있다.

* 예제2:

  ```java
  public class Ex13_12 {
      public static void main(String[] args) {
          Runnable r = new RunnableEx12();
  
          new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상 아님.
          new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상 아님.
      }
  }
  
  class Account {
      private int balance = 1000;
  
      public int getBalance(){
          return balance;
      }
  
      public synchronized void withdraw(int money){
          if(balance >= money){
              try {
                  Thread.sleep(1000);
              }catch (InterruptedException e){ }
              balance -= money;
          }
      }
  }
  
  class RunnableEx12 implements Runnable {
      Account acc = new Account();
  
      @Override
      public void run() {
          while (acc.getBalance() > 0){
              // 100, 200, 300중 한 값을 임의로  선택하여 출금(withdraw)
              int money = (int)(Math.random() * 3 + 1)*100;
              acc.withdraw(money);
  
              System.out.println("balance:"+acc.getBalance());
          }
      }
  }
  ```

  > 결과:
  > balance:900
  > balance:800
  > balance:700
  > balance:400
  > balance:300
  > balance:200
  > balance:0
  > balance:0

  * withdraw() 에 synchronized를 붙였더니, 동기화가 처리되어 음수 값이 나타나지 않는 것을 볼 수 있다.
  * balance가 private인 것도 중요한 요소인데, 이 것이 public일 경우, 쓰레드 외에도 외부에서 접근이 가능 하므로 유의 해야한다.
    synchronized를 이용한 동기화는 지정된 영역의 코드를 하나의 쓰레드가 수행하는 것을 보장하는 것일 뿐이기 때문이다.



### 6. wait()과 notify()

* synchronized로 동기화 하여 공유 데이터를 보호할 때, 특정 쓰레드가 객체의 락을 오래 점유하지 않도록 하는 것이 중요하다.
  이렇게 점유 하게 되면, 다른 쓰레드가 점유가 해제되기만을 기다리느라 다른 작업을 원활히 처리 할 수 없기 때문.
* 이러한 상황을 개선하기 위해 나온 것이 wait()과 norify()이다.
  코드 수행 중, 더이상 진행할 수 없을 경우 wait()을 호출하여 락을 반납 후 기다리게 한다. 이후 다시 작업을 진행 할 수 있는 상황이 되면 notify()를 호출하여 다시 락을 얻어 작업을 진행할 수 있게 한다.



* wait(), notify(), notifyAll()
  * Object에 정의 됨.
  * 동기화 블록(synchronized블록)내에서만 사용 가능.
  * 효율적인 동기화를 가능하게 한다.



> waiting pool은 모든 객체마다 존재하므로, notifyAll()이 호출한다고 모든 객체의 waiting pool의 쓰레드가 깨워지는 것은 아니다.



* 예제1:

  ```java
  import java.util.ArrayList;
  
  class Customer implements Runnable {
      private  Table table;
      private  String food;
      
      Customer(Table table, String food){
          this.table = table;
          this.food = food;
      }
  
      @Override
      public void run() {
          while (true){
              try {
                  Thread.sleep(10);
              } catch (InterruptedException e){
                  
              }
              String name = Thread.currentThread().getName();
              
              if(eatFood())
                  System.out.println(name + " ate a "+food);
              else
                  System.out.println(name + " failed to eat. :(");
          }
      }
      
      boolean eatFood(){
          return table.remove(food);
      }
  }
  
  
  class Cook implements Runnable {
      private Table table;
      
      Cook(Table table){
          this.table = table;
      }
  
      @Override
      public void run() {
          while (true){
              int idx = (int)(Math.random()*table.dishNum());
              table.add(table.dishNames[idx]);
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e){
                  
              }
          }
      }
  }
  
  class Table {
      String[] dishNames = {"donut", "donut", "burger"};
      final int MAX_FOOD = 6;
      private ArrayList<String> dishes = new ArrayList<>();
      
      public synchronized void add(String dish) {
          if(dishes.size() >= MAX_FOOD)
              return;
          
          dishes.add(dish);
          System.out.println("Dishes:"+dishes.toString());
      }
      
      public boolean remove(String dishName) {
          synchronized (this){
              while (dishes.size() == 0) {
                  String name = Thread.currentThread().getName();
                  System.out.println(name + " is waiting");
                  try {
                      Thread.sleep(500);
                  } catch (InterruptedException e){
                      
                  }
              }
              
              for (int i = 0; i<dishes.size(); i++){
                  if(dishName.equals(dishes.get(i))) {
                      dishes.remove(i);
                      return true;
                  }
              }
          }
          return false;
      }
      public  int dishNum() {
          return dishNames.length;
      }
  }
  
  public class Ex13_13 {
      public static void main(String[] args) throws Exception {
          Table table = new Table();
          
          new Thread(new Cook(table), "Cook").start();
          new Thread(new Customer(table, "donut"), "CUST1").start();
          new Thread(new Customer(table, "burger"), "CUST2").start();
          
          Thread.sleep(5000);
          System.exit(0);
      }
  }
  
  ```

  > 결과:
  > Dishes:[burger]
  > CUST1 failed to eat. :( -> 도넛 없어서 못먹음
  > CUST2 ate a burger
  > CUST1 is waiting
  > ...
  > CUST1 is waiting -> 음식이 없어서 테이블에 lock을 건 채로 계속 기다리고 있다.

* 손님 쓰레드가 원하는 음식이 없으면 'failed to eat'을 출력하고, 테이블에 음식이 하나도 없으면, 0.5초마다 음식이 추가되었는지 확인하면서 기다리도록 작성 되어있는데,
  요리사가 음식을 추가하지않고 손님 쓰레드를 계속 기다리게 하고있다.

* 이유는 손님 쓰레드가 테이블 객체의 락을 쥐고 기다리고 있기 때문에, 요리사가 음식을 추가할 수 없는 것.
  이럴때 사용하는 것이 'wait() & notify()'이다.
  이를 개선한게 예제 2.





* 예제2:

  ```java
  import java.util.ArrayList;
  
  class Customer2 implements Runnable {
      private Table2 table;
      private String food;
  
      Customer2(Table2 table, String food) {
          this.table = table;
          this.food = food;
      }
  
      @Override
      public void run() {
          while (true) {
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) { }
              String name = Thread.currentThread().getName();
  
              table.remove(food);
              System.out.println(name + " ate a " + food);
          }
      }
  }
  
  
  class Cook2 implements Runnable {
      private Table2 table;
  
      Cook2(Table2 table) {
          this.table = table;
      }
  
      @Override
      public void run() {
          while (true) {
              int idx = (int) (Math.random() * table.dishNum());
              table.add(table.dishNames[idx]);
              try {
                  Thread.sleep(10);
              } catch (InterruptedException e) { }
          }
      }
  }
  
  class Table2 {
      String[] dishNames = {"donut", "donut", "burger"};
      final int MAX_FOOD = 6;
      private ArrayList<String> dishes = new ArrayList<>();
  
      public synchronized void add(String dish) {
          while (dishes.size() >= MAX_FOOD) {
              String name = Thread.currentThread().getName();
              System.out.println(name + " is waiting");
              try {
                  wait();
                  Thread.sleep(500);
              } catch (InterruptedException e) { }
          }
          dishes.add(dish);
          System.out.println("Dishes:" + dishes.toString());
      }
  
      public void remove(String dishName) {
          synchronized (this) {
              String name = Thread.currentThread().getName();
              while (dishes.size() == 0) {
                  System.out.println(name + " is waiting");
                  try {
                      wait();
                      Thread.sleep(500);
                  } catch (InterruptedException e) { }
              }
  
              while (true) {
                  for (int i = 0; i < dishes.size(); i++) {
                      if (dishName.equals(dishes.get(i))) {
                          dishes.remove(i);
                          notify();
                          return;
                      }
                  }
                  try {
                      System.out.println(name + " is waiting");
                      wait();
                      Thread.sleep(500);
                  } catch (InterruptedException e) {
  
                  }
              }
          }
      }
  
      public int dishNum() {
          return dishNames.length;
      }
  }
  
  public class Ex13_14 {
      public static void main(String[] args) throws Exception {
          Table2 table = new Table2();
  
          new Thread(new Cook2(table), "Cook").start();
          new Thread(new Customer2(table, "donut"), "CUST1").start();
          new Thread(new Customer2(table, "burger"), "CUST2").start();
  
          Thread.sleep(2000);
          System.exit(0);
      }
  }
  
  ```

  > 결과:
  > Dishes:[donut]
  > ...
  > Dishes:[donut, donut, burger, donut, donut, donut]
  > Cook is waiting < 요리 대기창이 다 차서 대기
  > CUST1 ate a donut < 원하는 음식 먹음
  > Dishes:[donut, burger, donut, donut, donut, burger] < 요리 제작
  > CUST1 ate a donut
  > CUST2 ate a burger
  > Dishes:[donut, donut, donut, burger, burger]
  > Dishes:[donut, donut, donut, burger, burger, burger]
  > Cook is waiting
  > ...
  > Cook is waiting
  > CUST2 ate a burger

  * 이전보단 더 나아졌지만, waiting pool에 요리사 쓰레드와 손님 쓰레드가 같이 기다리기 때문에, 둘 중 누가 통지를 받을지 알 수 없는 문제가 있다.

