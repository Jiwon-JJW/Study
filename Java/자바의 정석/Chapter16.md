# 16. 네트워킹

## 01. 네트워킹(networking)이란?

* 두 대 이상의 컴퓨터를 케이블로 연결하여 네트워크(network)를 구성하는 것.
* 첫 개념은 컴퓨터들을 연결하여 데이터를 손쉽게 주고받거나, 프린터와같은 주변기기를 함께 공유하고자 하는 노력에서 시작됨.
* 자바에서 제공하는 java.net패키지를 사용하여 네트워크 어플리케이션의 데이터 통신부분을 작성할 수 있다.



## 02. 클라이언트와 서버(client & server)

* 컴퓨터간의 관계를 역할로 구분하는 개념.

  * 서버: 서비스를 제공하는 컴퓨터(service provider)
    서비스를 제공하는 소프트웨어가 실행되는 컴퓨터
    * 서비스: 서버가 클라이언트로부터 요청받은 작업을 처리하여, 결과를 제공하는 것.
      서비스의 종류에 따라 파일 서버(file server), 메일 서버(mail server), 어플리케이션 서버(application server) 등으로 나뉨.
    * 접속하는 클라이언트의 수에 따라 하나의 서버가 여러가지 서비스를 제공하거나, 하나의 서비스를 여러 대의 서버로 제공한다.
  * 클라이언트: 서비스를 사용하는 컴퓨터(service user)
    * 서비스를 제공받기 위하여 서버와 연결할 수 있는 클라이언트 프로그램이 필요.(ex. 웹 브라우저, FTP 프로그램 등)

* 네트워크 구성 시, 전용 서버를 두는 것을 서버 기반 모델(server - based model)이라 하고,
  별도의 전용서버 없이 각 클라이언트가 서버역할을 동시에 수행하는 것을 P2P모델(peer - to - peer)이라 한다.

  | 서버 기반 모델                                               | P2P모델                                                      |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | - 안정적인 서비스의 제공 가능<br />- 공유 데이터의 관리와 보안 용이<br />- 서버 구축 비용과 관리비용이 많이 듬. | - 서버 구축 및 운용비용 절감 가능.<br />- 자원의 활용 극대화<br />- 자원의 관리가 까다롭고, 보안에 취약함. |





## 03. IP 주소(IP address)

* 컴퓨터(호스트: host)를 구별하는 데 사용되는 고유한 값.

* 4byte(32 bit)의 정수로 구성되며, 마침표를 구분자로 'a.b.c.d'와 같은 형식으로 표현된다.
  a,b,c,d 들은 부호없는 1byte값인 0~255 사이의 정수로 표현됨.(192.168.0.200)

* 네트워크 주소와 호스트 주소로 나눌 수 있으며, 이 주소가 각각 몇 bit를 차지하는 지는 네트워크를 어떻게 구성하였는지에 따라 달라짐.

  * 서로 다른 호스트의 IP 주소의 네트워크 주소가 같다면, 두 호스트가 같은 네트워크에 포함된 것을 의미한다.

    > IP주소와 서브넷 마스크를 '&'로 연산하면 네트워크 주소를 얻어낼 수 있기 때문에,
    > 서로 다른 두 호스트의 IP 주소를 서브넷 마스크로 '&'연산을 수행 후 비교 시, 두 호스트가 같은 네트워크 상에서 존재 하는지에 대한 여부를 알 수 있다.

## 04. InetAddress 클래스

* IP 주소를 다루기 위한 클래스.

| 메서드                                         | 설명                                                         |
| ---------------------------------------------- | ------------------------------------------------------------ |
| byte[] getAddress()                            | IP주소를 byte배열로 반환                                     |
| static InetAddress[] getAllByName(String host) | 도메인명(host)에 지정된 모든 호스트의 IP주소를 배열에 담아 반환 |
| static InetAddress getByAddress(byte[] addr)   | byte배열을 통해 IP주소를 얻음.                               |
| static InetAddress getByName(String host)      | 도메인명(host)을 통해 IP주소를 얻음                          |
| String getCanonicalHostName()                  | FQDN(fully qualified domain name)을 반환                     |
| String getHostAddress()                        | 호스트의 IP주소를 반환                                       |
| String getHostName()                           | 호스트의 이름을 반환                                         |
| static InetAddress getLocalHost()              | 지역 호스트의 IP주소를 반환                                  |
| boolean isMulticastAddress()                   | IP주소가 멀티캐스트 주소인지 알려준다.                       |
| boolean isLoopbackAddress()                    | IP주소가 loopback 주소(127.0.0.1)인지 알려준다.              |



* 예제

  ```java
  import java.net.InetAddress;
  import java.net.UnknownHostException;
  import java.util.Arrays;
  
  public class Ex16_1 {
      public static void main(String[] args){
          InetAddress ip = null;
          InetAddress[] ipArr = null;
  
          try {
              ip = InetAddress.getByName("www.naver.com");
              System.out.println("getHostName() :" + ip.getHostName());
              System.out.println("getHostAddress() :"+ip.getHostAddress());
              System.out.println("toString() :"+ip.toString());
  
              byte[] ipAddr = ip.getAddress();
              System.out.println("getAddress() :"+ Arrays.toString(ipAddr));
  
              String result = "";
              for(int i =0; i<ipAddr.length; i++)
                  result+= (ipAddr[i] < 0? ipAddr[i]+256 : ipAddr[i])+".";
                  System.out.println("getAddress() + 256 :"+result);
                  System.out.println();
          } catch (UnknownHostException e){
              e.printStackTrace();
          }
  
          try {
              ip = InetAddress.getLocalHost();
              System.out.println("getHostName() :" + ip.getHostName());
              System.out.println("getHostAddress() :"+ip.getHostAddress());
              System.out.println();
          }catch (UnknownHostException e){
              e.printStackTrace();
          }
  
          try {
              ipArr = InetAddress.getAllByName("www.naver.com");
  
              for(int i = 0; i< ipArr.length; i++)
                  System.out.println("ipArr["+i+"] :"+ ipArr[i]);
              
          } catch (UnknownHostException e){
              e.printStackTrace();
          }
      }
  }
  
  ```

  > 결과:
  > getHostName() :www.naver.com
  > getHostAddress() :125.209.222.100
  > toString() :www.naver.com/125.209.222.100
  > getAddress() : [125, -47, -34, -115]
  > getAddress() + 256 : 125.209.222.100.
  >
  > getHostName() : mycom
  > getHostAddress() :127.0.0.1
  >
  > ipArr[0] :www.naver.com/125.209.222.100
  > ipArr[1] :www.naver.com/125.209.222.101

  * 하나의 도메인 명에 여러 IP주소가 맵핑 될 수도있고, 그 반대의 경우도 가능하다.
    전자의 경우 getAllByName()을 통해 모든 IP주소를 얻을 수 있다.
  * getLocalHost() 사용시, 호스트명과 IP주소를 알아 낼 수 있다.



## 05. URL(Uniform Resource Locator)

* 인터넷에 존재하는 여러 서버들이 제공하는 자원에 접근 할 수 있는 주소.

* '프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조 ' 의 형태로 이루어짐.

  > http://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1
  > 
  >
  >
  > 프로토콜 : 자원에 접근하기 위해 서버와 통신하는데 사용되는 통신규약(http)
  >
  > 호스트명 : 자원을 제공하는 서버의 이름(www.codechobo.com)
  >
  > 포트번호 : 통신에 사용되는 서버의 포트번호(80)
  >
  > > 포트번호 생략 시, 각 프로토콜의 기본 포트가 사용됨. 위의 주소의 경우, 80
  >
  > 경로명 : 접근하려는 자원이 저장된 서버상의 위치(/sample/)
  >
  > 파일명 : 접근하려는 자원의 이름(hello.html)
  >
  > 쿼리(query) : URL에서 '?'이후의 부분(referer = codechobo)
  >
  > 참조(anchor) : URL에서 '#'이후의 부분(index1)



### URL 클래스

| 메서드                                                       | 설명                                               |
| ------------------------------------------------------------ | -------------------------------------------------- |
| URL (String spec)                                            | 지정된 문자열 정보의 URL객체를 생성한다.           |
| URL (String protocol, String host, String file)              | 지정된 값으로 구성된 URL 객체를 생성한다.          |
| URL (String protocol, String host, int port, String file)    | 지정된 값으로 구성된 URL 객체를 생성한다.          |
| String getAuthority()                                        | 호스트명과 포트를 문자열로 반환한다.               |
| Object getContent()                                          | URL의 Content객체를 반환.                          |
| Object getContent(Class[] classes)                           | URL의 Content객체를 반환.                          |
| int getDefaultPort()                                         | URL의 기본 포트를 반환한다(http는 80)              |
| String getFile()                                             | 파일명을 반환                                      |
| String getHost()                                             | 호스트명을 반환                                    |
| String getPath()                                             | 경로명을 반환                                      |
| int getPort()                                                | 포트를 반환                                        |
| String getProtocol()                                         | 프로토콜을 반환                                    |
| String getQuery()                                            | 쿼리를 반환                                        |
| String getRef()                                              | 참조(anchor)를 반환                                |
| String getUserInfo()                                         | 사용자 정보를 반환                                 |
| URLConnection openConnection()                               | URL과 연결된 URLConnection을 얻는다                |
| URLConnection openConnection(Proxy proxy)                    | URL과 연결된 URLConnection을 얻는다                |
| InputStream openStream()                                     | URL과 연결된 URLConnection의 InputStream을 얻는다. |
| boolean sameFile(URL other)                                  | 두 URL이 서로 같은것인지 알려준다.                 |
| void set(String protocol, String host, int port, String file, String ref) | URL객체의 속성을 지정된 값으로 설정                |
| void set(String protocol, String host, int port, String authority, String userInfo, String path, String query, String ref) | URL객체의 속성을 지정된 값으로 설정                |
| String toExternalForm()                                      | URL을 문자열로 변환하여 반환                       |
| URI to URI()                                                 | URL을 URI로 변환하여 반환                          |



* 예제:

  ```java
  import java.net.*;
  
  public class Ex16_2 {
      public static void main(String[] args) throws Exception{
          URL url = new URL("http://www.codechobo.com:80/sample/"
                  +"hello.html?referer=codechobo#index1");
  
          System.out.println("url.getAuthority():"+url.getAuthority());
          System.out.println("url.getContent():"+url.getContent());
          System.out.println("url.getDefaultPort():"+url.getDefaultPort());
          System.out.println("url.getPort():"+url.getPort());
          System.out.println("url.getFile():"+url.getFile());
          System.out.println("url.getHost():"+url.getHost());
          System.out.println("url.getPath():"+url.getPath());
          System.out.println("url.getProtocol():"+url.getProtocol());
          System.out.println("url.getQuery():"+url.getQuery());
          System.out.println("url.getRef():"+url.getRef());
          System.out.println("url.getUserInfo():"+url.getUserInfo());
          System.out.println("url.toExternalForm():"+url.toExternalForm());
          System.out.println("url.toURI():"+url.toURI());
      }
  }
  
  ```

  > 결과:
  > url.getAuthority():www.codechobo.com:80
  >
  > url.getContent(): sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@c17164
  >
  > url.getDefaultPort():80
  > url.getPort():80
  > url.getFile():/sample/hello.html?referer=codechobo
  > url.getHost():www.codechobo.com
  > url.getPath():/sample/hello.html
  > url.getProtocol():http
  > url.getQuery():referer=codechobo
  > url.getRef():index1
  > url.getUserInfo():null
  > url.toExternalForm():http://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1
  > url.toURI():http://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1



## 06. URLConnection 클래스

* 어플리케이션과 URL간의 통신 연결을 나타내는 클래스의 최상위 클래스. 추상클래스이다.
* 연결하고자 하는 자원에 접근하고 읽고 쓰기를 할 수 있으며, 이에 관련된 메서드가 제공된다.
* URLConnection클래스를 상속받은 클래스:
  * HttpURLConnection
  * JarURLConnection



* 예제1 :
  해당 URL에 연결하여 그 내용을 읽어오는 예제.
  URL이 유효하지 않을 경우, Malformed-URLException이 발생한다.

  ```java
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.net.MalformedURLException;
  import java.net.URL;
  
  public class Ex16_4 {
      public static void main(String[] args) {
          URL url = null;
          BufferedReader input = null;
          String address =  "http://www.codechobo.com/sample/hello.html";
          String line = "";
  
          try {
              url = new URL(address);
              input = new BufferedReader(new InputStreamReader(url.openStream()));
            //InputStreamReader(url.openStream(); 은,
            // URLConnection conn = url.openConnection();
            // InputStream in = conn.getInputStream(); 과 같다.
  
              while ((line=input.readLine())!=null) {
                  System.out.println(line);
              }
              input.close();
          } catch (MalformedURLException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

* 예제2:
  위의 예제와 유사하지만, 텍스트 데이터가 아닌, 이진데이터를 읽어 파일로 저장한다.
  때문에 FileReader가 아닌, FileOutputStream 사용

  ```java
  import java.io.*;
  import java.net.MalformedURLException;
  import java.net.URL;
  
  public class Ex16_5 {
      public static void main(String[] args) {
          URL url = null;
          InputStream in = null;
          FileOutputStream out = null;
          String address =  "http://www.codechobo.com/sample/hello.html";
  
          int ch = 0;
  
          try {
              url = new URL(address);
              in = url.openStream();
              out = new FileOutputStream("javabasic_src.zip");
  
              while ((ch = in.read())!=-1) {
                  out.write(ch);
              }
              in.close();
              out.close();
          } catch (MalformedURLException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

  



## 07. 소켓(socket)프로그래밍

* 소켓 프로그래밍은 소켓을 이용한 통신 프로그래밍.
  * 소켓? 
    프로세스간의 통신에 사용되는 양쪽 끝단(endpoint)



### TCP와 UDP

* TCP/IP 프로토콜은 이기종 시스템간의 통신을 위한 표준 프로토콜. 프로토콜의 집합.

* TCP와 UDP모두 TCP/IP 프로토콜(TCP/IP protocol suites)에 포함 되어 있으며 
  OSI 7계층의 전송 계층 (transport layer)에 해당하는 프로토콜.

* TCP와 UDP의 특징:

  | 항목        | TCP                                                          | UDP                                                          |
  | ----------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | 연결 방식   | 연결기반(connection - oriented)<br />- 연결 후 통신 (전화기)<br />- 1:1 통신 방식 | 비연결기반(connectionless - oriented)<br />- 연결없이 통신(소포)<br />- 1:1,1:n, n:n 통신방식 |
  | 특징        | 데이터의 경계를 구분안함(byte-stream)<br />신뢰성 있는 데이터 전송<br />- 데이터의 전송 순서 보장<br />- 데이터의 수신여부 확인<br />(데이터가 손실되면 재전송)<br />- 패킷을 관리할 필요가 없음<br />UDP보다 전송속도가 느림 | 데이터의 경계를 구분함(datagram)<br />신뢰성 없는 데이터 전송<br />-데이터의 전송 순서가 바뀔 수 있음<br />- 데이터의 수신 여부 확인 안함<br />(데이터가 손실되어도 알 수 없음)<br />- 패킷 관리 필요<br />TCP보다 전송속도가 빠름 |
  | 관련 클래스 | Socket<br />ServerSocket                                     | DatagramSocket<br />DatagramPacket<br />MulticastSocket      |



### TCP소켓 프로그래밍

* 클라이언트와 서버간의 일대일 통신.

* 통신과정:
  1. 서버 프로그램에서 서버소켓을 이용하여 서버 컴퓨터의 특정 포트에서 클라이언트의 연결요청 처리 준비.
  2. 클라이언트 프로그램은 접속할 서버의 IP주소와 포트 정보를 가지고 소켓을 생성하여 서버에 연결 요청
  3. 서버 소켓은 클라이언트의 연결 요청을 받아, 서버에 새로운 소켓을 생성하여 클라이언트 소켓과 연결
  4. 클라이언트 소켓과 새로만들어진 서버 소켓은 서버소켓과 관계없이 일대일 통신 진행.
  
* 서버 소켓(ServerSocket)의 역학: 포트와 결합(bind)되어 포트를 통해 원격 사용자의 연결요청을 기다리다,
  연결요청이 올 때마다 새로운 소켓을 생성해, 상대편 소켓과 통신할 수 있도록 연결.

* 실제적인 데이터 통신은 서버 소켓과 관계없이 **소켓과 소켓간에 이루어짐.**

  * 예시로, 서버 소켓은 전화 교환기, 소켓은 전화기에 비유할 수 있다.

* 여러 개의 소켓이 하나의 포트를 공유해 사용할 수 있지만, 서버소켓은 포트를 독점한다.

  * 포트: 

    * 호스트(컴퓨터)가 외부와 통신을 하기 위한 통로.
    * 하나의 호스트가 65536개의 포트를 가지고 있으며, 번호로 구별됨.

    

### Socket, ServerSocket

* 소켓:

  * 데이터를 주고받는 연결통로는 입출력 스트림.
  * 소켓 하나 당 입력과 출력 스트림을 가지며, 상대편 소켓의 스트림과 교차 연결된다.
    따라서, 한 소켓에서 출력 스트림으로 데이터 전송 시, 상대편 소켓의 입력 스트림으로 받게됨.

* 자바의 소켓과 서버 소켓:

  * 소켓(Socket):
    프로세스간의 통신 담당. Input/Output Stream을 가짐.
    이 두 스트림을 통해 프로세스간의 통신이 이루어진다.
  * 서버 소켓(Server Socket):포트와 결합(bind)되어 포트를 통해 원격 사용자의 연결요청을 기다리다,
    연결요청이 올 때마다 새로운 소켓을 생성해, 상대편 소켓과 통신할 수 있도록 연결.
    한 포트에 하나의 ServerSocket만 연결 가능. (프로토콜이 다르면 같은 포트 공유 가능)

* 예제:
  간단하게 TCP/IP 서버를 구현한 것. 

  1. 서버 소켓이 7777번 포트에서 클라이언트 프로그램 연결요청을 기다림.
  2. 요청이 올 때 까지 진행을 멈추고 대기.
  3. 클라이언트 프로그램이 서버 연결 요청시, 새로운 소켓 생성
  4. 클라이언트 프로그램 소켓과 연결
  5. 새로운 소켓은 "[Notice] Test Message1 from Server"을 원격소켓에 전송 후 종료
  6. 실행 결과는 서버 프로그램을 실행 시킨 후, 클라이언트 프로그램을 실행시킨 뒤, 서버프로그램 종료.

  ```java
  import javax.imageio.IIOException;
  import java.io.DataOutputStream;
  import java.io.IOException;
  import java.io.OutputStream;
  import java.net.ServerSocket;
  import java.net.Socket;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  
  public class TcpIpServer {
      public static void main(String[] args) {
          ServerSocket serverSocket = null;
  
          try {
              // 서버 소켓을 생성하여 7777번 포트와 결합(bind) 시킨다.
              serverSocket = new ServerSocket(7777);
              System.out.println(getTime()+"서버가 준비 되었습니다.");
          } catch (IOException e){
              e.printStackTrace();
          }
  
          while (true){
              try {
                  System.out.println(getTime()+"연결 요청을 기다립니다.");
                  // 서버 소켓은 클라이언트의 연결요청이 올때까지 실행을 멈추고 대기.
                  // 클라이언트의 연결 요청이 오면 클라이언트 소켓과 통신할 새로운 소켓 생성.
                  Socket socket = serverSocket.accept();
                  System.out.println(getTime()+socket.getInetAddress()+"로 부터 연결요청이 들어왔습니다.");
  
                  // 소켓의 출력스트림을 얻음
                  OutputStream out = socket.getOutputStream();
                  DataOutputStream dos = new DataOutputStream(out);
  
                  // 원격소켓(remote Socket)에 데이터 전송
                  dos.writeUTF("[Notice] Test Message1 from Server");
                  System.out.println(getTime()+"데이터를 전송했습니다.");
                  
                  // 소켓과 스트림을 닫아줌.
                  dos.close();
                  socket.close();
              } catch (IOException e){
                  e.printStackTrace();
              }
          }
      }
      
      // 현재시간 문자열 반환
      static String getTime() {
          SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
          return f.format(new Date());
      }
  }
  ```

* 예제2:
  예제 1과 통신하기 위한 클라이언트 프로그램.
  연결하고자 하는 서버의 IP와 포트번호를 가지고 소켓 생성 시, 자동적으로 서버에 연결요청 함.

  ```java
  import java.io.DataInputStream;
  import java.io.IOException;
  import java.io.InputStream;
  import java.net.Socket;
  import java.net.UnknownHostException;
  
  public class TcpIpClient {
      public static void main(String[] args) {
          try {
              String serverIP = "127.0.0.1";
  
              System.out.println("서버에 연결중입니다. 서버IP: " + serverIP);
              // 소켓을 생성하여 연결 요청
              Socket socket = new Socket(serverIP,7777);
  
              // 소켓의 입력스트림을 얻음
              InputStream in = socket.getInputStream();
              DataInputStream dis = new DataInputStream(in);
  
              // 소켓으로부터 받은 데이터 출력
              System.out.println("서버로부터 받은 메세지: "+dis.readUTF());
              System.out.println("연결을 종료시킵니다.");
  
              // 스트림과 소켓 닫기.
              dis.close();
              socket.close();
              System.out.println("연결이 종료되었습니다.");
          } catch (UnknownHostException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  
  ```

  

### UDP 소켓 프로그래밍 -Client

* TCP 소켓 프로그래밍에서는 Socket과 Server Socket를 사용하지만, UDP소켓프로그래밍에서는 UDP가 연결 지향적인 프로토콜이 아니기 때문에 
  통신에서 사용되는 DatagramSocket과, 데이터를 담아 전송하는 DatagramPacket이 있다.

*  DatagramPacket은 헤더와 데이터로 구성되어,
  헤더에는 DatagramPacket을 수신할 호스트의 정보(호스트 주소, 포트)가 저장되어있다.
  따라서 DatagramPacket을 전송하면 지정된 주소의 Socket에 도착하게 됨.

  

```java
import javax.imageio.IIOException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UdpClient {
    public void start() throws IOException, UnknownHostException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
        
        // 데이터가 저장될 공간으로 byte배열 생성
        byte[] msg = new byte[100];
        
        DatagramPacket outputPacket = new DatagramPacket(msg,1,serverAddress,7777);
        // DatagramPacket 전송
        DatagramPacket inputPacket = new DatagramPacket(msg,msg.length);
        // DatagramPacket 수신
        
        
        datagramSocket.send(outputPacket);
        datagramSocket.receive(inputPacket);
        
        datagramSocket.close();
    }
    
    public static void main(String[] args) {
        try {
            new UdpClient().start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

```



### UDP 소켓 프로그래밍 -Server

* 서버로부터 서버시간을 전송받아 출력하는 클라이언트와 서버 프로그램.
  클라이언트가 DatagramPacket을 생성해, DatagramSocket으로 서버에 전송하면,
  서버는 전송받은 DatagramPacket의 getAddress(), getPort()를 호출해, 클라이언트의 정보를 얻어 서버시간을 DatagramPacket에 담아 전송한다.

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
    public void start() throws IOException {
        // 포트 7777번을 사용하는 소켓 생성

        DatagramSocket socket = new DatagramSocket(7777);
        DatagramPacket inPacket, outPacket;

        byte[] inMsg = new byte[10];
        byte[] outMsg;

        while (true){
            // 데이터를 수신하기 위한 패킷 생성
            inPacket = new DatagramPacket(inMsg,inMsg.length);
            socket.receive(inPacket);

            // 수신한 패킷으로부터 client의 IP주소와 Port를 얻는다
            InetAddress address = inPacket.getAddress();
            int port = inPacket.getPort();

            // 서버의 현재 시간을 시분초 형태로 반환
            SimpleDateFormat sdf = new SimpleDateFormat("[hh:mmLss");
            String time = sdf.format(new Date());
            outMsg = time.getBytes();

            // 패킷을 생성해서 client에게 전송 한다.
            outPacket = new DatagramPacket(outMsg,outMsg.length,address,port);
            socket.send(outPacket);
        }
    }

    public static void main(String[] args) {
        try {
            new UdpServer().start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

```

