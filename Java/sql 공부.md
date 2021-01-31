```java
import java.util.LinkedList;
import java.util.Scanner;

public class Data {
    public static LinkedList<String> Date = new LinkedList<>();
    public static LinkedList<String> Summary = new LinkedList<>();
    public static LinkedList<Integer> Income = new LinkedList<>();
    public static LinkedList<Integer> Expenditure = new LinkedList<>();
    public static LinkedList<String> Type = new LinkedList<>();

    Scanner scanner =new Scanner(System.in);

    public void DataInput(){

        System.out.println("데이터를 저장할 번호를 입력해주세요");
        int num = scanner.nextInt();
        int n = num-1;

        System.out.println("소비유형: 1. 현금 | 2. 카드 ");
        Type.add(n,scanner.next());

        System.out.print("날짜: ");
        Date.add(n,scanner.next());

        System.out.print("적요: ");
        Summary.add(n,scanner.next());

        System.out.print("수입: ");
        Income.add(n,scanner.nextInt());

        System.out.print("지출: ");
        Expenditure.add(n,scanner.nextInt());

        System.out.println("=======================================");
        System.out.println("입력하신 내용은 다음과 같습니다.");
        System.out.println(Type.get(n)+"/"+Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));

        System.out.println("저장이 완료되었습니다.");

        Menu.ReturnMenu();

    }

    public void DataDelete(){
        System.out.println("삭제하실 데이터 번호를 입력해주세요.");
        int num = scanner.nextInt();
        int n = num-1;

        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
        System.out.println(Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));
        System.out.println("정말 삭제하시겠습니까?(1.Yes/2.No)");

        if(scanner.nextInt()==1) {
            Date.remove(n);
            Summary.remove(n);
            Income.remove(n);
            Expenditure.remove(n);
            Menu.ReturnMenu();
        }
        if(scanner.nextInt() == 2){
            Menu.ReturnMenu();
        }
    }

    public void DataEdit() {
        System.out.println("수정하실 데이터 번호를 입력해주세요.");
        int num = scanner.nextInt();
        int n = num-1;

        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
        System.out.println(Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));
        System.out.println("정말 수정하시겠습니까?(1.Yes/2.No)");

        if(scanner.nextInt() == 1) {
            System.out.println("수정하실 사항을 선택하여, 번호로 입력해주세요");
            System.out.println("1.소비 유형 / 2.날짜  / 3.적요  / 4.수입  / 5.지출  / 6.종료");
            int num2 = scanner.nextInt();

            if (num2 == 1){
                Type.remove(n);
                System.out.println("소비유형: 1. 현금 | 2. 카드 ");
                System.out.print("번호로 입력하여주세요: ");
                if(scanner.nextInt() == 1){
                    Type.add(n,"현금");
                }
                if(scanner.nextInt() == 2){
                    Type.add(n,"카드");
                }
                else {
                    System.out.println("공백으로 저장됩니다.");
                    Type.add(n,"  ");
                }
            }

            if (num2 == 2){
                Date.remove(n);
                System.out.println("1. 날짜");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Date.add(n,scanner.next());
            }

            if(num2 == 3){
                Summary.remove(n);
                System.out.println("2. 적요");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Summary.add(n,scanner.next());

            }

            if(num2 == 4){
                Income.remove(n);
                System.out.println("3. 수입");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Income.add(n,scanner.nextInt());

            }

            if(num2 == 5){
                Expenditure.remove(n);
                System.out.println("4. 지출");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Expenditure.add(n,scanner.nextInt());

            }

            if(num2 == 6){
                System.out.println("수정을 종료합니다.");
                Menu.ReturnMenu();
            }

            System.out.println("수정하신 데이터 번호의 내용은 다음과 같습니다.");
            System.out.println(Type.get(n)+"/"+Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));
            System.out.println("저장이 완료되었습니다.");
            Menu.ReturnMenu();
        }

        if(scanner.nextInt() == 2) {
            Menu.ReturnMenu();
        }
    }

    public void DataPrint(){
        System.out.println("=============================================================");
        System.out.println(" No / 소비 유형 /   날짜   /   적요   /   수입   /   지출   /   잔액  ");
        for(int i = 0; i < Date.size(); i++) {
            int total = 0;
            total = (total + Income.get(i)) - Expenditure.get(i);
            System.out.println(" " + i + " / "+ Type.get(i) +" / " + Date.get(i) + " / " + Summary.get(i) + " / "
                    + Income.get(i) + "원 / " + Expenditure.get(i) + "원 / " + total + "원 ");
        }
        System.out.println("=============================================================");
        System.out.println("출력이 완료되었습니다.");
        Menu.ReturnMenu();
    }
}




```





```java
import java.util.Scanner;

public class Data {
    static SelectTest selectTest;
    static InsertTest insertTest;
    static UserAccount userAccount;

    private String Date;
    private String Summary;
    private int Income;
    private int Expenditure;
    private String Type;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public int getIncome() {
        return Income;
    }

    public void setIncome(int income) {
        Income = income;
    }

    public int getExpenditure() {
        return Expenditure;
    }

    public void setExpenditure(int expenditure) {
        Expenditure = expenditure;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }


    Scanner scanner =new Scanner(System.in);

    public void DataInput(){

        System.out.println("데이터를 저장할 번호를 입력해주세요");
        int num = scanner.nextInt();
        int n = num-1;

        System.out.println("소비유형: 1. 현금 | 2. 카드 ");
        System.out.print("");
        setType(scanner.next());

        System.out.print("날짜: ");
        setDate(scanner.next());

        System.out.print("적요: ");
        setSummary(scanner.next());

        System.out.print("수입: ");
        setIncome(scanner.nextInt());

        System.out.print("지출: ");
        setExpenditure(scanner.nextInt());

        System.out.println("=======================================");
        System.out.println("입력하신 내용은 다음과 같습니다.");
        System.out.println(getType()+"/"+getDate()+"/"+getSummary()+"/"+getIncome()+"/"+getExpenditure());
        insertTest.insert(userAccount.getUserName(),getType(),getDate(),getSummary(),getIncome(),getExpenditure());
        System.out.println("저장이 완료되었습니다.");

        Menu.ReturnMenu();

    }

    public void DataDelete(){
        System.out.println("삭제하실 데이터 번호를 입력해주세요.");
        int num = scanner.nextInt();
        int n = num-1;

        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
        System.out.println(getType()+"/"+getDate()+"/"+getSummary()+"/"+getIncome()+"/"+getExpenditure());
        System.out.println("정말 삭제하시겠습니까?(1.Yes/2.No)");

        if(scanner.nextInt()==1) {
            Date.remove(n);
            Summary.remove(n);
            Income.remove(n);
            Expenditure.remove(n);
            Menu.ReturnMenu();
        }
        if(scanner.nextInt() == 2){
            Menu.ReturnMenu();
        }
    }

    public void DataEdit() {
        System.out.println("수정하실 데이터 번호를 입력해주세요.");
        int num = scanner.nextInt();
        int n = num-1;

        System.out.println("입력하신 데이터 번호의 내용은 다음과 같습니다.");
        System.out.println(Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));
        System.out.println("정말 수정하시겠습니까?(1.Yes/2.No)");

        if(scanner.nextInt() == 1) {
            System.out.println("수정하실 사항을 선택하여, 번호로 입력해주세요");
            System.out.println("1.소비 유형 / 2.날짜  / 3.적요  / 4.수입  / 5.지출  / 6.종료");
            int num2 = scanner.nextInt();

            if (num2 == 1){
                Type.remove(n);
                System.out.println("소비유형: 1. 현금 | 2. 카드 ");
                System.out.print("번호로 입력하여주세요: ");
                if(scanner.nextInt() == 1){
                    Type.add(n,"현금");
                }
                if(scanner.nextInt() == 2){
                    Type.add(n,"카드");
                }
                else {
                    System.out.println("공백으로 저장됩니다.");
                    Type.add(n,"  ");
                }
            }

            if (num2 == 2){
                Date.remove(n);
                System.out.println("1. 날짜");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Date.add(n,scanner.next());
            }

            if(num2 == 3){
                Summary.remove(n);
                System.out.println("2. 적요");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Summary.add(n,scanner.next());

            }

            if(num2 == 4){
                Income.remove(n);
                System.out.println("3. 수입");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Income.add(n,scanner.nextInt());

            }

            if(num2 == 5){
                Expenditure.remove(n);
                System.out.println("4. 지출");
                System.out.print("변경하실 사항을 입력해주세요: ");
                Expenditure.add(n,scanner.nextInt());

            }

            if(num2 == 6){
                System.out.println("수정을 종료합니다.");
                Menu.ReturnMenu();
            }

            System.out.println("수정하신 데이터 번호의 내용은 다음과 같습니다.");
            System.out.println(Type.get(n)+"/"+Date.get(n)+"/"+Summary.get(n)+"/"+Income.get(n)+"/"+Expenditure.get(n));
            System.out.println("저장이 완료되었습니다.");
            Menu.ReturnMenu();
        }

        if(scanner.nextInt() == 2) {
            Menu.ReturnMenu();
        }
    }

    public void DataPrint(){
        System.out.println("=============================================================");
        System.out.println(" No / 소비 유형 /   날짜   /   적요   /   수입   /   지출   /   잔액  ");
        selectTest.print();
        System.out.println("=============================================================");
        System.out.println("출력이 완료되었습니다.");
        Menu.ReturnMenu();
    }
}




```





```sql
use new_schema1; ## 스키마 사용

desc Account; ## 테이블 칼럼 확인 (정보확인)

select * from Account; ## 조회

-- 주석
## 주석
select * from Account where Type= "카드";
select * from Account where Type like "%현%"; ## %가 있으면 앞글자, %가 뒤에 있으면 정해진 단어 뒤에 글자 찾는거. 부분글자.

insert into Account 
(User_userid, type, Date, Summary, Income, Expenditure)
values("project","현금","2020-11-11","빼빼로",10000,1000); ## 데이터 추가
## 저장은 어플라이 삭제는 에딧에 있는삭제 누르거나 우클릭해서 딜리트.

update Account set type = "카드" ; ##모든 값이 입력한 값으로 바뀜

update Account set type = "카드" where no = 8 ; ## 8번 인것 만 변경 < > 사용 가능
## 안전 업데이트 모드 해제 방법 = 프리퍼런스 가서 에스큐엘 에디터  맨 밑에 세이프 업데이트 체크 해제

delete from Account where no = 8; ## 삭제 명령. < > 사용 가능. 이전 데이터 삭제 / 이후 데이터 삭제
drop table Account; ## 테이블 전체 삭제
truncate table Account; ## 구조 냅두고 내용 전체 삭제


select account.*,user.iduser from Account left join User on account.user_userid = user.iduser;
Select a.*,u.* from Account as a left join user as u on a.user_userid = u.user_userid; ## *은 잘 안씀.

select user_userid from Account union select iduser from user; ## 셀렉트 문의 결과를 하나로 합쳐서 출력  자동 중복 제거됨.
select user_userid from Account union all select iduser from user; ## 중복되지 않은 데이터 출력 
```





## DDL(Data Definition Language) - 데이터 정의어

데이터 베이스의 구조를 정의하거나 변경, 삭제 하기 위해 사용. 주로 DB관리자 또는 설계자가 사용하기 때문에, 관리자로 로그인 해야 사용할 수 있다.

- create (개체 생성)

  * 테이블 생성
    creat table student (
    칼럼명 타입 조건(not null 등),
    칼럼명 타입 조건(not null 등),
    칼럼명 타입 조건(not null 등),

    PRIMARY KEY~~)

- alter (개체 수정)

- drop (개체 삭제)

- truncate (개체 초기화. 삭제 + 생성 합쳐짐)

- rename (개체 이름 변경)