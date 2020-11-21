import java.util.Calendar;

public class ClockSetting {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

     String[] arr = {"한", "두", "세", "네", "다", "섯",
            "여", "섯", "일", "곱", "여", "덟",
            "아", "홉", "열", "한", "두", "시",
            "자", "이", "삼", "사", "오", "십",
            "정", "일", "이", "삼", "사", "오",
            "오", "육", "칠", "팔", "구", "분"};


    public void InitClock() {
        Calendar today = Calendar.getInstance();
        int hour = today.get(Calendar.HOUR_OF_DAY);
        int minute = today.get(Calendar.MINUTE);

        ResetColor();
        for (int i = 1; i <= 36; i++) {
            HourColor(hour);
            MinuteColor(minute);
            System.out.printf("%s ", arr[i-1]);
            if (i % 6 == 0) {
                System.out.println();
            }
        }
    }

    public void HourColor(int hour) {
        arr[17] = ANSI_GREEN + arr[17] + ANSI_RESET;
        switch (hour) {
            case 0 -> {
                arr[14] = ANSI_GREEN + arr[14] + ANSI_RESET;
                arr[16] = ANSI_GREEN + arr[16] + ANSI_RESET;
                arr[18] = ANSI_GREEN + arr[18] + ANSI_RESET;
                arr[24] = ANSI_GREEN + arr[24] + ANSI_RESET;
                break;
            }
            case 1, 13 -> {
                arr[0] = ANSI_GREEN + arr[0] + ANSI_RESET;
                break;
            }
            case 2, 14 -> {
                arr[1] = ANSI_GREEN + arr[1] + ANSI_RESET;
                break;
            }
            case 3, 15 -> {
                arr[2] = ANSI_GREEN + arr[2] + ANSI_RESET;
                break;
            }
            case 4, 16 -> {
                arr[3] = ANSI_GREEN + arr[3] + ANSI_RESET;
                break;
            }
            case 5, 17 -> {
                arr[4] = ANSI_GREEN + arr[4] + ANSI_RESET;
                arr[5] = ANSI_GREEN + arr[5] + ANSI_RESET;
                break;
            }
            case 6, 18 -> {
                arr[6] = ANSI_GREEN + arr[6] + ANSI_RESET;
                arr[7] = ANSI_GREEN + arr[7] + ANSI_RESET;
                break;
            }
            case 7, 19 -> {
                arr[8] = ANSI_GREEN + arr[8] + ANSI_RESET;
                arr[9] = ANSI_GREEN + arr[9] + ANSI_RESET;
                break;
            }
            case 8, 20 -> {
                arr[10] = ANSI_GREEN + arr[10] + ANSI_RESET;
                arr[11] = ANSI_GREEN + arr[11] + ANSI_RESET;
                break;
            }
            case 9, 21 -> {
                arr[12] = ANSI_GREEN + arr[12] + ANSI_RESET;
                arr[13] = ANSI_GREEN + arr[13] + ANSI_RESET;
                break;
            }
            case 10, 22 -> {
                arr[14] = ANSI_GREEN + arr[14] + ANSI_RESET;
                break;
            }
            case 11, 23 -> {
                arr[14] = ANSI_GREEN + arr[14] + ANSI_RESET;
                arr[15] = ANSI_GREEN + arr[15] + ANSI_RESET;
                break;
            }
            case 12 -> {
                arr[14] = ANSI_GREEN + arr[14] + ANSI_RESET;
                arr[16] = ANSI_GREEN + arr[16] + ANSI_RESET;
                arr[24] = ANSI_GREEN + arr[24] + ANSI_RESET;
                arr[30] = ANSI_GREEN + arr[30] + ANSI_RESET;
                break;
            }
        }
    }

    public void MinuteColor(int minute){
        int m2 = minute/10;// 분의 10의 자리 수
        int m1 =minute%10;// 분의 1의 자리수

        if(minute>0) {
            arr[35] = ANSI_GREEN + arr[35] + ANSI_RESET;
        }

        switch (m1) {
            case 1 -> {
                arr[25] = ANSI_GREEN + arr[25] + ANSI_RESET;
                break;
            }
            case 2 -> {
                arr[26] = ANSI_GREEN + arr[26] + ANSI_RESET;
                break;
            }
            case 3 -> {
                arr[27] = ANSI_GREEN + arr[27] + ANSI_RESET;
                break;
            }
            case 4 -> {
                arr[28] = ANSI_GREEN + arr[28] + ANSI_RESET;
                break;
            }
            case 5 -> {
                arr[29] = ANSI_GREEN + arr[29] + ANSI_RESET;
                break;
            }
            case 6 -> {
                arr[31] = ANSI_GREEN + arr[31] + ANSI_RESET;
                break;
            }
            case 7 -> {
                arr[32] = ANSI_GREEN + arr[32] + ANSI_RESET;
                break;
            }
            case 8 -> {
                arr[33] = ANSI_GREEN + arr[33] + ANSI_RESET;
                break;
            }
            case 9 -> {
                arr[34] = ANSI_GREEN + arr[34] + ANSI_RESET;
                break;
            }

        }
        if(minute>9){
            arr[23] = ANSI_GREEN + arr[23] + ANSI_RESET;
            switch (m2){
                case 2 -> {
                    arr[19] = ANSI_GREEN + arr[19] + ANSI_RESET;
                    arr[23] = ANSI_GREEN + arr[23] + ANSI_RESET;
                    break;
                }
                case 3 -> {
                    arr[20] = ANSI_GREEN + arr[20] + ANSI_RESET;
                    arr[23] = ANSI_GREEN + arr[23] + ANSI_RESET;
                    break;
                }
                case 4 -> {
                    arr[21] = ANSI_GREEN + arr[21] + ANSI_RESET;
                    arr[23] = ANSI_GREEN + arr[23] + ANSI_RESET;
                    break;
                }
                case 5 -> {
                    arr[22] = ANSI_GREEN + arr[22] + ANSI_RESET;
                    arr[23] = ANSI_GREEN + arr[23] + ANSI_RESET;
                    break;
                }
            }
        }

    }

    public void ResetColor(){
        String s = "한,두,세,네,다,섯,여,섯,일,곱,여,덟,아,홉,열,한,두,시,자,이,삼,사,오,십,정,일,이,삼,사,오,오,육,칠,팔,구,분";

        arr = s.split(",");
    }

}

