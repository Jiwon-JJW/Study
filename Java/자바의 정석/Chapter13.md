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



