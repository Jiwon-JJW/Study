import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void UserMenu() throws IOException {
        UserAccount userAccount = new UserAccount();

        System.out.println("=======================================");
        System.out.println("     작업하실 사항을 번호로 입력하여 주세요.     ");
        System.out.println("   1.로그인   |   2.회원가입   |   3.종료   ");
        System.out.println("=======================================");
        System.out.print("> ");
        int input = scanner.nextInt();

        if (input == 1) {
            userAccount.Login();
        }
        if (input == 2) {
            userAccount.UserAccountIn();
        }

        if (input == 3) {
            System.exit(0);
        }
    }

    public static void MenuSelect() throws IOException{
        AccountMgr accountMgr = new AccountMgr();
        FileUtil fileUtil = new FileUtil();

        String filepath = "/Users/jeongjiwon/codesquad_cocoa/DAY6/Mission 3,4/";
        String filename = "DB.md";

        System.out.println("================================================================");
        System.out.println("                 작업하실 사항을 번호로 입력하여 주세요.");
        System.out.println(" 1.입력 | 2.삭제 | 3.수정 | 4.출력 | 5.파일 저장 | 6.파일 불러오기 | 7.종료");
        System.out.println("================================================================");
        System.out.print("> ");
        int input = scanner.nextInt();
        if (input == 1) {
            accountMgr.addInfo(DataInput());
            ReturnMenu();
        }
        if (input == 2) {
            System.out.println("삭제하실 데이터 번호를 입력해주세요.");
            accountMgr.removeInfo(scanner.nextInt());
            ReturnMenu();
        }
        if (input == 3) {
            System.out.println("수정하실 데이터 번호를 입력해주세요.");
            int PN = scanner.nextInt();
            accountMgr.updateInfo(DataInput(),PN);
            ReturnMenu();
        }
        if (input == 4) {
            accountMgr.showInfo();
            ReturnMenu();
        }

        if (input == 5) {
            fileUtil.FileWrite(filepath,filename,accountMgr.getInfoList());
            ReturnMenu();
        }
        if (input == 6) {
            accountMgr.setInfoList(FileUtil.readFile(new File(filepath,filename)));
            ReturnMenu();
        }
        if (input == 7) {
            scanner.close();
            System.exit(0);
        }
    }



    public static void ReturnMenu() throws IOException {
        System.out.println("=======================================");
        System.out.println(" 메뉴로 돌아가 계속 진행하시겠습니까?(1.Yes/2.No)");
        System.out.println("=======================================");
        System.out.print("> ");
        if(scanner.nextInt() == 1){
            MenuSelect();
        }
        if(scanner.nextInt() == 2){
            scanner.close();
            System.exit(0);
        }
    }

    public static AccountInfo DataInput(){
        Scanner scanner =new Scanner(System.in);
        AccountInfo accountInfo = new AccountInfo();

        System.out.println("소비유형: 1. 현금 | 2. 카드 ");
        accountInfo.setType(scanner.next());

        System.out.print("날짜: ");
        accountInfo.setDate(scanner.next());

        System.out.print("적요: ");
        accountInfo.setSummary(scanner.next());

        System.out.print("수입: ");
        accountInfo.setIncome(scanner.nextInt());

        System.out.print("지출: ");
        accountInfo.setExpenditure(scanner.nextInt());

        System.out.println("=======================================");
        System.out.println("저장이 완료되었습니다.");

        return accountInfo;
    }
}
