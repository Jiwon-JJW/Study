package honux.calendar;
import java.util.Scanner;


public class sum {

	public static void main(String[] args) {
		// 입력: 키보드로 두 수의 입력을 받는다.
		// 출력: 화면에 두 수의 합을 출력한다.

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("두 수를 입력해 주세요.(ex: 5,10) :");
			String number = scanner.nextLine();
			String[] arr = number.split(",");
			
			int first = Integer.parseInt(arr[0]);
			int second = Integer.parseInt(arr[1]);
		
			//System.out.println("두 수의 합은"+(first+second)+"입니다.");
			System.out.printf("두 수의 합은 %d입니다.", first+second);
			
			scanner.close(); // scanner를 열었기 때문에, 닫아줘야한다.
			}
			
		}



