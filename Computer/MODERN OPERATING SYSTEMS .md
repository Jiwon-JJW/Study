# MODERN OPERATING SYSTEMS

## Introduction

### What Is An Operating System

* 하드웨어와 응용프로그램(Applications) 사이의 소프트웨어.

  * 서로 다른 응용프로그램 사이나, 서로 다른 사용자의 사이를 참조한다.

* 응용프로그램에 서비스 및 인터페이스를 제공한다.
  (= 자원 핸들링을 진행하는 역할.)

* 하드웨어에 아무나 접근할 수 없도록 액세스 권한을 부여한다.

  

  ![스크린샷 2020-11-12 오후 1 01 06](https://user-images.githubusercontent.com/69128652/98894010-21ea9880-24e7-11eb-9a90-de002da439e5.png)

  

### What Dose an Operating System Do?

* 하드웨어 리소스에 대한 추상화 레이어를 제공 한다.
  * 추상화를 통해서 고차원적인 접근을 할 수 있다.
  * 사용자 프로그램이 단순하고 이식 가능한, 더 높은 수준의 개념을 다룰 수 있도록 한다.
  * 한정된 리소스를 마치 한정되지 않은것 처럼(무한대 인 것 처럼) 사용할 수 있게 해준다. 

* 하드웨어 리소스 관리
  * 응용프로그램에 대한 복잡한 리소스 및 상호작용을 관리해준다.
  * 여러 응용프로그램이 함께 진행될 때, 서로 손상 없이 리소스를 공유 할 수 있게 해준다.
  * 여러 사용자가 서로에게 영향 및 피해를 주지않고 리소스를 공유할 수 있게 해준다.



### The Operating System as a Respurce Manager

* 여러 프로그램이 동시에(at the same time) 실행 되는 것을 허용한다.
* 메모리, I/O장치 및 기타 리소스를 관리하고 보호한다.
* 다중화(:Multiplexing (공유)) 리소스를 포함하는 두가지 방법이 있다.
  * In time(시간) – CPU sharing
  * In space(공간) – Memory sharing



## Computer Hardware Review

### CPU Pipelining

* 커널 모드와 유저 모드가 존재한다.

  * 커널 모드:수퍼바이저(Supervisor) 모드. OS에 커널이 동작되는 모드이며,
    모든 하드웨어 접근 및 모든 명령어를 실행할 수 있다.
  * 유저 모드: OS제외 모든 응용프로그램 사용 가능하며,
    제한이 되어있어, 일부 명령어만 사용할 수 있다.

* System call = Trap

* Registers = program counter(PC), stack pointer(SP), general purpose register, Program Status Wor가 존재한다.

  * program counter:

    다음에 가져올 instruction의 메모리주소.

  * stack pointer:
    메모리 스택의 Top을 가리키는 pointer.



### System Call

![image](https://user-images.githubusercontent.com/69128652/98897569-100cf380-24ef-11eb-817d-e5505e116025.png)

1. User program이 OS를 불러야 할 때, 혹은 User mode에서 프로세스가 System call을 호출 하면, Trap이 발생한다.

2. Trap instruction이 user mode 에서 kernel mode로 전환 된다. 
   
   > (평소에는 kernel mode로 접근 할 수 없으며, OS가 System call을 발생시켰을 때에만 접근 가능하다.)
   
   이 때, 현재 진행하던 caller의 state(레지스터나 CPU의 상태 같은 정보)를 모두 저장시킨다.
   
3. parameter로 요청 된 System call을 수행한다.

4. return-from-trap이 발생되어, user mode로 돌아와 system call 이후 실행 순서부터 다시 실행하기 시작한다.

* OS를 호출하는 두 가지 방법이 존재한다. :
  - Trap (System call)
    * 소프트웨어가 발생시키는 메세지로, system call이나 프로그램 실행 중 오류 발생 시 출력됨.
  - Interrupt (I/O)
    * 하드웨어에서 발생되는 문제.



### Memory

* 메모리의 계층 구도화. (Memory Hierarchy)

![스크린샷 2020-11-14 오후 3 44 05](https://user-images.githubusercontent.com/69128652/99141598-3ddd6e00-2690-11eb-83dd-22cb20d222b0.png)

* 위 메모리 계층은 CPU의 거리 순으로 이루어져있으며, 상위 계층으로 올라갈 수록 CPU와 가까워 진다.
  CPU와 가까워질 수록 메모리 접근 속도가 빨라지는 대신 메모리 용량이 작고, CPU와 거리가 멀 수록 메모리 용량이 커지는 대신 메모리 접근 속도가 느려진다.
* 제일 상단에 있는 Register는 CPU에 내장 되어있는 저장공간이며, 
  CPU의 내부에 있기 때문에 다른 메모리에 비해서 가장 빠른 속도로 접근 할 수 있다.
* Cache는 프로세서가 접근하여 Cache 내부에 메모리가 존재하는지 확인 할 수 있다.
* Cache와 SRAM은 프로세스와 가장 가깝다.
* Main Memory 부터는 CPU외부에 존재하며, 접근 속도가 Cache나 Register보다 느리다.
  하드디스크 내에 있는 내용의 경우, 프로그램 실행을 위해 Main Memory로 이동 된다.



### Disk

* Cylinder, track
  ![image](https://user-images.githubusercontent.com/69128652/99141593-31f1ac00-2690-11eb-99ec-3de9ca97e02b.png)

* Virtual memory(가상 메모리)

  * RAM의 크기는 최대 4GB인데, 실행하려는 프로그램의 크기가 4GB이상일 경우, 디스크 내의 프로그램 정보를 가지고 올 수 없기 때문에 등장하였다.

  * 각 프로그램에 실제 메모리가 아닌, 가상 메모리 주소를 부여하여 주는 메모리 관리 기법이다.

  * 메모리에서 프로그램 실행 명령어를 읽어 오게 될 경우, 명령어가 필요로 하는 데이터가 있다면,그 데이터도 메모리에서 읽어온 후 그 결과를 메모리에 기록하는 형식이다.

  * 운영 체제 내에서 디스크 공간을 메모리처럼 활용할 수 있는 기능을 제공해 준다.

  * 가상 메모리의 경우, 주소가 다르기 때문에 실제 메모리에 저장 될 때 매핑의 과정을 거쳐야한다.

    

* MMU (Memory Management Unit)

  * CPU에서 코드 실행 시, 가상 메모리 접근이 필요할 때 해당 주소를 물리 주소값으로 변환해주는 하드웨어 장치.

  * 가상 메모리 내의 가상 주소(logical address)를 물리 주소(physical address)로 변경해주는 매핑(Mapping)을 지원한다.

  * 메모리 관리 하드웨어 이다.

    

* Context Switch

  * 하나의 OS 내에서 프로세스가 번갈아가며 동작하는 것을 말한다.

  * 예시:

    1. 프로세스 A가 실행 도중, System call 혹은 I/O Interrupt를 만나게 될 경우, 실행 중이던 프로세스 A의 정보를 모두 PCB내에 저장한 후, OS로 넘어가게 된다.
    2. 이 때, OS가 스케줄링을 하여 프로세스 A가 문제를 처리할 동안 우선순위가 높은쪽을 골라 실행할 항목을 고른다.
    3. 위의 스케줄링이 끝난 후 프로세스 B가 실행 하게 되는데, 도중에 프로세스 A가 끝날 경우 OS는 다시 스케줄링 상태에 들어가게된다.
    4. 스케줄링의 판단 하에 프로세스 A가 우선순위가 높다면 프로세스 B의 항목을 모두 PCB에 저장한 후, 
       프로세스 A가 진행하던 중의 데이터를 PCB에서 가져와 프로세스 A를 실행한다.

    ![image](https://user-images.githubusercontent.com/69128652/99141984-f78a0e00-2693-11eb-94bc-1ca31fde478e.png)

### I/O Devices

* I/O장치를 시작한 후, 인터럽트를 얻는 단계 : 

![스크린샷 2020-11-14 오후 3 44 37](https://user-images.githubusercontent.com/69128652/99141608-50f03e00-2690-11eb-8571-af4f9aa9e1f7.png)

* Device Driver – Device Controller
  * Disk Driver는 Controller와만 연결 되어, 소통한다. Controller는 나머지와도 소통이 가능하다.
*  I/O port space for device register
* I/O Access – busy waiting, interrupt, DMA (Direct Memory Access)
*  Interrupt Vector – addresses of interrupt handlers



### Operating System Concepts

- Processes
- Address spaces
- Files
- Input/Output
- Protection
- The shell
- Ontogeny recapitulates phylogeny
  - Large memories
  - Protection hardware 
  - Disks
  -  Virtual memory



### Process

* Note that a program is totally passive
   – just bytes on a disk that contain instructions to be run

* 프로세스는 실행중인 프로그램의 인스턴스이다.(실행중인 프로그램의 한 단위.)

  – 프로세스는 독립적인 인스턴스 이지만, 프로그램(ex: 편집기)의 복사본을 실행하는 프로세스가 있을 수 있다.

* The process is the OS’s abstraction for execution(- 프로세스는 OS 실행을 위한 추상화를 제공.)
  
*  the unit of execution
  * the unit of scheduling
  * the dynamic (active) execution context
  * 프로그램과의 비교: static, just a bunch of bytes
  
* Process 는, job, task, or sequential process이라고도 불린다.



### Process operations

* OS는 프로세스에 대해 다음과 같은 작업을 제공한다. (: 프로세스 추상화 인터페이스):

  * create a process
  * delete a process
  * suspend a process
  * resume a process
  * clone a process
  * inter-process communication
  * inter-process synchronization
  * create/delete a child process (subprocess)
  * 프로세스 트리:
    프로세스 A가 하위 프로세스B,C를 생성. 그리고 프로세스 B가 세 개의 하위 프로세스(D,E,F)를 생성했다. 

  ![스크린샷 2020-11-14 오후 5 07 02](https://user-images.githubusercontent.com/69128652/99142808-e6dd9600-269b-11eb-818e-9bb786ccf67e.png)



### Difference between process and program?

* 프로세스는..
  * 일반적으로 보호되어있고, 가상 메모리에 매핑된 주소 공간을 가진다.
  * 실행중인 프로그램의 코드
  * 실행중인 프로그램의 데이터
  * 실행 스택 및 Stack Pointer(SP)와 힙을 가짐.
  * Program counter(PC)를 가짐
  * 일반 목적 및 상태를 보여주는, 프로세서 레지스터 세트를 가짐.
  * 시스템 리소스 세트:
    * 파일, 네트워크 연결, 파이프, ...
    * 권한, 사용자 연결, ...

### Process Address Space (traditional Unix)

![스크린샷 2020-11-14 오후 5 15 04](https://user-images.githubusercontent.com/69128652/99142938-f3aeb980-269c-11eb-8ba9-5baa4c09a875.png)

* 프로그램이 실행되면, 프로세스 주소공간(Process Adress space)이 Memory에 할당 되며, 
  이 할당된 프로세스를 실행시키는 것이 CPU이다.
* 모든 프로세스는 자신만의 주소공간(adress space)을 가지고 있으며, 프로세스 주소공간의 안은 Stack,data(heap),code 등으로 이루어진다.



### Process states

* 각 프로세스에는 현재 수행중인 작업을 나타내는 실행상태가 있다.
  * 준비(ready): CPU를 할당받기위해 대기하고 있다.
    * CPU를 부여 해도 실행하지 못하는 상태일 수 있다.
    * 인터럽트나 시스템 콜이 끝나면 ready 상태로 돌아오며, ready 상태가 되었다고 바로 실행 할 수 있는 것은 아니다.
  * 실행(running): CPU에서 실행되고 있는 상태.
    * 현재 CPU를 제어하는 프로세스 이다.
  * 차단 / 중지 (Block): 이벤트 발생(I/O)상태의 경우 나타나는 상태.
    * 상태가 끝날 경우 , ready로 돌아간다.
* 프로세스가 실행 되면, 상태간의 이동이 일어난다.
* 선점형 스케줄러의 경우, 실행상태의 프로세스를 준비상태로 강제 전환 할 수 있다. 
  이 때, 비 선점 스케줄러가 대기하게 된다.



###  Implementation of Processes

* 프로세스의 기본 구성:
  * 하나의 주소 공간
  * 실행중인 프로그램 코드
  * 실행중인 프로그램 데이터
  * 실행 스택 및 스택포인터(SP)
  * traces state of procedure calls made
  * 다음 명령어를 나타내는 프로그램 카운터(PC)
  * 범용 프로세서 및 레지스터 값 세트
  * OS 리소스 세트
  * open files, network connections, sound channels, ...
* 프로세스는 모든 상태에 대한 컨테이너.
  * 프로세스는 프로세스 ID로 명명된다.(PID)
    * PID: just an integer (actually, typically a short)



### Process data structures

* OS가 커널에서 프로세스를 표현하는 방법:
  * 각각 고유한 프로세스가 있다.
  * 각각을 나타내는 OS data structure를 **프로세스 제어블록(PCB: Process Control Block)**또는 **Process table**이라고 한다.
* PCB는 프로세스에 대한 모든 정보를 저장하고 있다.
  * OS는 프로세스가 실행되지 않을 때, PCB에 있는 모든 프로세스의 하드웨어 실행상태를 유지시킨다.
    * PC
    * SP
    * 레지스터
  * 프로세스가 schedule(예약) 되어있지 않을 경우, 프로세스 상태가 하드웨어에서 PCB로 전송한다.



### PCBs and Hardware State

* 프로세스가 실행 중일 때, 하드웨어 상태는 CPU내부에 존재한다.
  * PC, SP, registers
  * CPU 현재 값 포함.
* OS가 프로세스 실행을 중지하게 될 경우, 레지스터의 값을 PCB에 저장한다.
  * OS가 프로세스를 다시 실행 상태로 만들면, 해당 프로세스의 PCB에 저장되어있는 값에서 하드웨어 레지스터를 불러온다.
* 한 프로세스에서 다른 프로세스로 CPU를 전환하는 행위를 Context Switch라고 한다.
  * 시분할 시스템은 초당 100 또는 1000개의 스위치를 수행할 수 있다.

