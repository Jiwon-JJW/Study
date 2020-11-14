
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class UserAccount {
    private String UserName;
    private String PassWord;
    HashMap<String,String> User = new HashMap<>();

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }


    public void initUser() {
        User.put("project","cocoa");
    }

    public void UserAccountIn() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("UserName: ");
        this.setUserName(scanner.nextLine());
        System.out.println("PassWord: ");
        this.setPassWord(scanner.nextLine());

        User.put(this.getUserName(),this.getPassWord());
        System.out.println("메인 화면으로 돌아갑니다.");
        Menu.UserMenu();

        }

        public boolean AccountCheck(String ID, String PW) {

            if(!User.containsKey(ID) || !User.containsValue(PW)){
                System.out.println("유저 이름 혹은 비밀번호가 잘못되었습니다.");
                return false;
            }
            return true;
        }

        public void Login() throws IOException {
            Scanner scanner = new Scanner(System.in);

            initUser();

            System.out.print("UserName: ");
            String UserName=scanner.nextLine();

            System.out.print("PassWord: ");
            String PassWord=scanner.nextLine();

            if(!AccountCheck(UserName, PassWord)){
                System.out.println("회원가입 하시겠습니까?(1.Yes/2.No)");
                System.out.print("> ");

                if(scanner.nextInt()==1) {
                    UserAccountIn();
                    return;
                }
                if(scanner.nextInt()==2){
                    Menu.UserMenu();
                }
            }

            Menu.MenuSelect();
        }
    }
