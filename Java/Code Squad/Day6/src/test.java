//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class test {
//    ArrayList<Phone> tel = new ArrayList<Phone>();
//    //Phone의 데이터를 가지는 ArrayList의 변수를 tel이라고 만들고
//    //Phone의 데이터를 가지는 ArrayList의 객체를 만들어서 변수 tel에 대입
//
//    Controller c = new Controller();
//    //Controller 라는 클래스 변수 이름을 c로 하고 Controller 객체를 생성해서 대입
//
//        File f = new File("C:\\Phonenumber\\phone.txt");
//
//        if(f.exists()) {
//        tel.clear();
//        //ArrayList tel의 내용 클리어해서 tel을 비움
//
//        FileReader fr = new FileReader("C:\\Phonenumber\\phone.txt");
//        //FileReader fr에 FileReader 객체를 생성 생성자 인자에는 파일경로를 문저열로 넣어서 객체 생성
//
//        BufferedReader reader1 = new BufferedReader(fr);
//        // BufferReader reader1에 BufferedReader 객체를 생성 생성자 인자에는 FileReader을 넣어서 객체 생성
//        String line1;
//        //문자열 line1 생성
//        String[] splitLine1 = null;
//        //문자열 배열 splitLine을 생성 하고 null 값 대입
//
//        while((line1=reader1.readLine()) != null)
//        //BufferReader reader1을 이용해 한줄을 읽어 와서 문자열 line1에 대입하고 line1이 널이 아니면 반복
//        {
//            //System.out.println(line1);
//            splitLine1 = line1.split("\t\t");
//            //문자열 splitLine 배열에 line1을 "\t\t"로 자른 문자열들을 대입
//            //               System.out.println(splitLine.length);
//            tel.add(new Phone(splitLine1[0], splitLine1[1], splitLine1[2]));
//            //ArrayList tel 추가할때 Phone 객체를 생성 하고 생성자는 문자열 splitLine1 배열을 대입
//        }
//    }
//
//
//    while(true) //무한반복
//    {
//        Scanner sc = new Scanner(System.in); //입력
//        FileWriter fw; //FileWriter의 fw라는 변수 선언
//        System.out.print("1. 입력 2.검색 3.삭제 4.출력 5.종료"); //출력
//        int num = sc.nextInt(); // 입력
//        if(c.tel.size() == 0)
////            Controller의 변수 c의 객체변서 tel의 사이즈가 0이면 실행
//        {
//            fw = new FileWriter("C:\\Phonenumber\\phone.txt",false);
//            // fw 변수에 FileWriter 객체를 생성해서 대입
//            // 객체 생성시 파일 경로명 문자열 생성자 인자에 넣어서 객체 생성 대입
//            //덮어쓰기
//        }
//	else //if문이 아니면
//        {
//            //System.out.println("11");
//            fw = new FileWriter("C:\\Phonenumber\\phone.txt",true);
//            //fw 변수에 FileWriter 객체를 생성해서 대입
//            // 객체 생성시 파일 경로명 문자열 생성자 인자에 넣어서 객체 생성 대입
//            //이어쓰기
//        }
//        switch (num) { //num의 값에 따라 분기
//            case 1: //num 1이면
//                c.input(fw);
//                // Controller의 변수 c의 input 함수에 FileWriter 객체 fw를 인자로 넣어서 호출
//                break; //탈출
//            case 2: //num 2이면
//                c.search();
//              //  Controller의 변수 c의 search 함수 호출
//                break; // 탈출
//            case 3: //num 3이면
//                FileWriter fw1 = new FileWriter("C:\\Phonenumber\\phone.txt",false);
//                //FileWriter의 변수명 fw1로 선언 후 FileWriter 객체 생성
//                //객체 생성시 파일 경로명을 문자열로 인자로 전달해서 객체 생성
//                c.delete(fw1);
//                //Controller의 변수 c의 deleter 함수에 FileWriter 객체 fw1를 인자로 넣어서 호출
//                break;//탈출
//            case 4://num 3이면
//                c.allPrint();
//                //Controller의 변수 c의 allPrint 함수 호출
//                break;// 탈출
//            case 5:
//                System.out.println("프로그램을 종료합니다.");//입력
//                break;//탈출
//
//            default: //위에게 다아니면
//                System.out.println("잘못된 입력입니다.");//출력
//                break;//탈출
//        }
//
//        if(num == 5) //num이 5이면
//        {
//            break; //반복문 탈출
//        }
//    }
//
//    public test() throws IOException {
//    }
//
//    class Phone //클래스 Phone
//    {
//        String name; // 문자열 변수 name
//        String phoneNumber; // 문자열 변수 phoneNumber
//        String address; // 문자열 변수 address
//
//        public Phone(String name, String phoneNumber, String address) {
//            //Phone 생성자 인자로 문자열 name, 문자열 phoneNumber, 문자열 address 받아서 생성
//            // TODO Auto-generated constructor stub
//            this.name = name;
//            //인자 name을 객체 변수 name에 대입
//            this.phoneNumber = phoneNumber;
//            //인자 phoneNumber을 객체 변수 phoneNumber에 대입
//            this.address = address;
//            //인자 address을 객체 변수 address에 대입
//        }
//    }
//
//
//    class Controller //class Controller
//    {
//        ArrayList<Phone> tel;    // Phone이 있는 ArrayList를 tel이라고 선언
//        FileWriter fw; // FileWriter를 fw라고 선언
//        Scanner sc; // Scanner를 sc라고 선언
//        FileReader fr; // FileReader를 fr이라고 선언
//
//        public Controller() throws IOException {
//            // TODO Auto-generated constructor stub
//            tel = new ArrayList<Phone>();
//            // tel 변수에 ArrayList<Phone>객체 생성 해서 대입
//            sc = new Scanner(System.in); // 입력
//
//        }
//
//        void input(FileWriter fw) throws IOException
//        //인자를 FileWriter로 받고 리턴이 없는 input이라는 함수
//        {
//            if(tel.size() == 0) // ArrayList 변수 tel의 크기가 0이면 실행
//            {
//                String opn1 = "이름"+"\t\t"+"전화번호"+"\t\t"+"주소"+"\r\n";
//                //문자열 변수 opn1에 위에 문자열 대입
//                tel.add(new Phone("이름","전화번호","주소"));
//                //ArrayList 변수 tel의 리스트 추가 Phone 객체를 생성해서 추가
//                fw.write(opn1);
//                // FileWrite의 변수 fw를 이용해 write 함수 호출 파일에 문자열 쓰기
//            }
//
//
//            System.out.print("이름 :"); //입력
//            String name=sc.next(); // String name에 입력 값 대입
//            System.out.print("전화번호 :"); //입력
//            String number=sc.next(); // String number에 입력 값 대입
//            System.out.print("주소 :"); // 입력
//            String address=sc.next(); // String address에 입력 값 대입
//
//            tel.add(new Phone(name,number,address));
//            //ArrayList 변수 tel의 리스트 추가 Phone 객체를 생성해서 추가 Phone은 입력받은 값을 생성자에 추가
//
//            String tatal = name+"\t\t"+number+"\t\t"+address+"\r\n";
//            // 문자열 tatal 에 입력 받은 문자열을 더해서 대입
//            fw.write(tatal);
//            // FileWrite의 변수 fw를 이용해 write 함수 호출 파일에 tatal문자열 쓰기
//            fw.close();
//            //FileWriter 끄기
//        }
//        void search()
//        //인자가 없고 리턴이 없는 search 함수
//        {
//            System.out.print("검색할 이름을 넣어주세요 : "); //입력
//            String search =sc.next(); // 문자열 search에 입력 문자열 대입
//
//            boolean check = false; // boolean check 변수를 false로 초기화
//            int index = -1; // int index 변수를 -1로 초기화
//
//            for(int i = 0;i<tel.size();i++)
//            //int i 변수를 0으로 대입 i는 ArrayList tel의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
//            {
//                if(tel.get(i).name.equals(search))
//                //ArrayList tel에 i 인덱스에 이름이 search와 같으면 아래 명령어 실행
//                {
//                    index = i; // 변수 index에 i를 대입
//                    check = true; // 변수 check에 true 대입
//                }
//            }
//
//            if(check == true)
//            // 변수 check가 true 라면 아래 명령어 실행
//            {
//                System.out.println(tel.get(index).name +","+tel.get(index).phoneNumber+","+tel.get(index).address );//출력
//            }
//            else
//            {
//                System.out.println("검색결과가 없습니다.");//출력
//            }
//        }
//
//        void delete(FileWriter fw) throws IOException
//        //인자를 FileWriter를 받고 리턴값이 없는 delete라는 함수
//        {
//            System.out.print("검색할 이름을 넣어주세요 : ");// 출력
//            String search1 =sc.next();
//            //문자열 search1 에 입력 값 대입
//            for(int i = 0;i<tel.size();i++)
//            //int i 변수를 0으로 대입 i는 ArrayList tel의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
//            {
//                if(tel.get(i).name.equals(search1))
//                //ArrayList tel에 i 인덱스에 이름이 search와 같으면 아래 명령어 실행
//                {
//                    System.out.println("remove");//출력
//                    tel.remove(i);//ArrayList tel 에 i 인덱스 삭제
//                }
//            }
//            for(int i =0;i<tel.size();i++)
//            //int i 변수를 0으로 대입 i는 ArrayList tel의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
//            {
//                String tatal1 = tel.get(i).name+"\t\t"+tel.get(i).phoneNumber+"\t\t"+tel.get(i).address+"\r\n";
//                //문자열 tatal1에 ArrayList tel에 i인덱스 문자열 이름, 전화번호, 주소를 더해서 대입
//                fw.write(tatal1);
//                // FileWrite의 변수 fw를 이용해 write 함수 호출 파일에 tatal1문자열 쓰기
//            }
//            fw.close();
//            //FileWriter 끄기
//        }
//        void allPrint() throws IOException
//        //인자는 없고 리턴값도 없는 allPrint라는 함수
//        {
//            tel.clear();
//            //ArrayList tel의 내용 클리어해서 tel을 비움
//            fr = new FileReader("C:\\Phonenumber\\phone.txt");
//            //FileReader fr에 FileReader 객체를 생성 생성자 인자에는 파일경로를 문저열로 넣어서 객체 생성
//            BufferedReader reader1 = new BufferedReader(fr);
//            // BufferReader reader1에 BufferedReader 객체를 생성 생성자 인자에는 FileReader을 넣어서 객체 생성
//            String line1;
//            //문자열 line1 생성
//            String[] splitLine1 = null;
//            //문자열 배열 splitLine을 생성 하고 null 값 대입
//
//            while((line1=reader1.readLine()) != null)
//            //BufferReader reader1을 이용해 한줄을 읽어 와서 문자열 line1에 대입하고 line1이 널이 아니면 반복
//            {
//                //System.out.println(line1);
//                splitLine1 = line1.split("\t\t");
//                //문자열 splitLine 배열에 line1을 "\t\t"로 자른 문자열들을 대입
//                //               System.out.println(splitLine.length);
//                tel.add(new Phone(splitLine1[0], splitLine1[1], splitLine1[2]));
//                //ArrayList tel 추가할때 Phone 객체를 생성 하고 생성자는 문자열 splitLine1 배열을 대입
//            }
//
//            for(int i = 0;i<tel.size();i++)
//            //int i 변수를 0으로 대입 i는 ArrayList tel의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
//            {
//                System.out.println(tel.get(i).name + "\t\t"+tel.get(i).phoneNumber +"\t\t"+ tel.get(i).address);
//                //출력
//            }
//        }
//    }
//
//
//    //출처: https://it-dolphin.tistory.com/entry/JAVA-파일을-이용한-전화번호부-만들기콘솔-출력 [IT돌고래의 삶]
//}
