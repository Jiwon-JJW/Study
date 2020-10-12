Q1. try-cath문의 try블럭 내에 if문과 같은 문장도 입력이 가능한가요?

Q2. 예외를 일부러 발생시키는 이유는 무엇이 있나요? 대표적 사례들이 궁금합니다.

Q3.

```java
import java.io.*;

public class Ex8_10 {
	public static void main (String[] args) {
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName()+"파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage()+"다시 입력해 주시기 바랍니다.");
		}
	}// main 메서드의 끝 
	
	static File createFile(String fileName) throws Exception {
		if (fileName==null || fileName.equals(""))
			throw new Exception("파일 이름이 유효하지 않습니다.");
		File f = new File(fileName); // File클래스의 객체를 만든다.
		// File객체의 createNewFile메서드를 이용해서 실제 파일을 생성한다.
		
		f.createNewFile();
		return f; // 생성된 객체의 참조를 반환한다.
	} // creatFile메서드의 끝.
} // 클래스의 끝 
```

 유선씨의 도움을 받아 10.메서드에 예외 선언하기 예제2의 

File f = createFile(args[0]); 
부분에 파일 이름을 입력해서 File f = *createFile*("test"); 파일이 정상적으로 생성되었다는 메세지를 받을 수 있었는데, 다른 방법으로는 할 수 없을까요?
값이 0이어서 생성이 안된다는 것 까지는 이해를 했는데, 정확하게 왜 저 쪽에 넣어야 하는건지 잘 이해가 안됩니다.



Q4. 사용자 정의 예외 만들기 기능은, 매번 작성하는 클래스? 파일? 패키지? 내에 적어줘야하는 것 일까요?

아니면 한 번 지정을 해두면 이클립스나 다른 java프로그램 내에 저장이 되는건지 궁금합니다.



Q5. try문에서 catch나 finally밑에 추가적으로 작성하는 문장은 순서를 그냥 맨 마지막으로 생각하면 되는 걸까요? 
아래의 경우, method2 실행 > catch문 찾기 > finally 출력 > println(4)출력 이런식이 맞는지요? 

catch문으로 예외를 해결 했을 때 출력되는 문장이 맞는 것인지 헷갈립니다.

```java
	static void method1() {
		try {
			method2(); // 예외가 발생됨
			System.out.println(1); 
		} catch (ArithmeticException e) { 
			System.out.println(2);
		} finally {									
			System.out.println(3);
		}
		
		System.out.println(4); 
	} //method1()
```

