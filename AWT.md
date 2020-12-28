# AWT / Swing

## 1. AWT

### 1) AWT(Abstract Window Toolkit)란?

* Window 프로그래밍(GUI 프로그래밍)을 하기 위한 도구.

  GUI어플리케이션의 개발에 필요한 여러 개의 관련 패키지와 클래스의 집합으로 구성 되어있다.

  > GUI(Graphical User Interface)란?
  >
  > * 사용자가 그래픽을 통해서 하드웨어와 상호작용을 하는 환경.
  > * 그래픽 기반의 어플리케이션으로, 윈도우의 아이콘을 마우스로 클릭해서 사용할 수 있는 이유도, 이 GUI덕분이다.
  > * 대표적 사용 예 : 마이크로소프트 사의 Windows , 애플 매킨토시의 GUI

* AWT로 작성된 GUI 어플리케이션 또한 플랫폼(Platform)과 독립적이라서 여러 종류의 OS에서 코드 변경 없이 사용이 가능하지만,
  버튼과 같은 것들을 OS의 컴포넌트(native component)를 사용하기 때문에 GUI어플리케이션의 외양(appearance)이 다를 수 있다.

  > 플랫폼: 자바(JVM)가 설치될 수 있는 기반환경. OS보다 넓은 의미.

* 여러 종류의 GUI기반의 OS가 공통적으로 가진 컴포넌트만으로 구성해야하기 때문에, AWT가 제공하는 GUI컴포넌트가 제한적이다.

  대신, OS가 제공하는 컴포넌트는 해당 OS에 최적화 되어있기 때문에, 자바로 구현한 컴포넌트보다 속도가 빠르다.

* 위의 문제를 해결하기 위해 새롭게 등장한 것이 Swing.



### 2) Swing이란?

* AWT를 확장한 것 이지만, AWT와는 달리 순수한 자바로 이루어져 있다.
* AWT보다 다양하고 풍부한 기능의 컴포넌트를 제공함으로써 진정한 GUI어플리케이션을 개발하기 위한 도구로 사용됨.
* AWT의 클래스들을 기반으로 만들어진 자손 클래스를 구성으로 가지고 있다.
  AWT와 Swing은 컴포넌트의 종류와 사용법만 조금 다를 뿐, 나머지는 거의 같다.



### 3) AWT의 구성
