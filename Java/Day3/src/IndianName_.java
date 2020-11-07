import java.security.PublicKey;
import java.util.Scanner;

class CallIndianName {

    public static void main(String[] args) {
        IndianName_ indianName_= new IndianName_();

        Scanner scanner = new Scanner(System.in);

        System.out.println("생년월일을 입력해주세요 ((ex) 2010 10 3)");
        System.out.print("> ");

        String Birthday = scanner.nextLine();

        String[] arr = Birthday.split(" ");

        String year = arr[0];
        String month = arr[1];
        String day = arr[2];

        char y = year.charAt(3);

        indianName_.Year(y);
        indianName_.Month(month);
        indianName_.Day(day);

        scanner.close();


        }

    static class IndianName_ {
    void Year(char y){
        switch (y){
            case '0':
                System.out.print("말 많은, 시끄러운");
                break;

            case '1':
                System.out.print("푸른");
                break;

            case '2':
                System.out.print("어두운, 적색");
                break;

            case '3':
                System.out.print("조용한");
                break;

            case '4':
                System.out.print("웅크린");
                break;

            case '5':
                System.out.print("백색");
                break;

            case '6':
                System.out.print("지혜로운");
                break;

            case '7':
                System.out.print("용감한");
                break;

            case '8':
                System.out.print("날카로운");
                break;

            case '9':
                System.out.print("욕심많은");
                break;
        }
    }

    void Month(String m){
        switch (m){
            case "1":
                System.out.print("늑대");
                break;

            case "2":
                System.out.print("태양");
                break;

            case "3":
                System.out.print("양");
                break;

            case "4":
                System.out.print("매");
                break;

            case "5":
                System.out.print("황소");
                break;

            case "6":
                System.out.print("불꽃");
                break;

            case "7":
                System.out.print("나무");
                break;

            case "8":
                System.out.print("달빛");
                break;

            case "9":
                System.out.print("말");
                break;

            case "10":
                System.out.print("돼지");
                break;

            case "11":
                System.out.print("하늘");
                break;

            case "12":
                System.out.print("바람");
                break;
        }
    }

         void Day(String d) {

            switch (d) {
                case "1":
                    System.out.println("와(과) 함께 춤을");
                    break;

                case "2":
                    System.out.println("의 기상");
                    break;

                case "3":
                    System.out.println("은(는) 그림자속에");
                    break;

                case "4":
                case "5":
                case "6":
                    break;

                case "7":
                    System.out.println("의 환생");
                    break;

                case "8":
                    System.out.println("의 죽음");
                    break;

                case "9":
                    System.out.println("아래에서");
                    break;

                case "10":
                    System.out.println("를(을) 보라");
                    break;

                case "11":
                    System.out.println("이(가) 노래하다");
                    break;

                case "12":
                    System.out.println("의 그림자");
                    break;

                case "13":
                    System.out.println("의 일격");
                    break;

                case "14":
                    System.out.println("에게 쫓기는 남자");
                    break;

                case "15":
                    System.out.println("의 행진");
                    break;

                case "16":
                    System.out.println("의 왕");
                    break;

                case "17":
                    System.out.println("의 유령");
                    break;

                case "18":
                    System.out.println("을 죽인자");
                    break;

                case "19":
                    System.out.println("는(은) 매일 잠잔다");
                    break;

                case "20":
                    System.out.println("처럼");
                    break;

                case "21":
                    System.out.println("의 고향");
                    break;

                case "22":
                    System.out.println("의 전사");
                    break;

                case "23":
                    System.out.println("은(는) 나의 친구");
                    break;

                case "24":
                    System.out.println("의 노래");
                    break;

                case "25":
                    System.out.println("의 정령");
                    break;

                case "26":
                    System.out.println("의 파수꾼");
                    break;

                case "27":
                    System.out.println("의 악마");
                    break;

                case "28":
                    System.out.println("와(과) 같은 사나이");
                    break;

                case "29":
                    System.out.println("를(을) 쓰러트린자");
                    break;

                case "30":
                    System.out.println("의 혼");
                    break;

                case "31":
                    System.out.println("은(는) 말이 없다");
                    break;
            }
        }
    }

}
