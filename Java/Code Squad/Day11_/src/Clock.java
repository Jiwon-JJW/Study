public class Clock {

    public static void main(String[] args) {
        PrintClock();

    }

    static String[] arr = {"한","두","세","네","다","섯","분","섯","일","곱","여","덟","아","홉","열","한","두","시","자",
            "이","삼","사","오","십","정","일","이","삼","사","오","오","육","칠","팔","구"};


    public static void PrintClock(){
        for (int i = 0; i< arr.length; i++){
            System.out.printf("%3d",arr[i]);
            if(i%6==0){
                System.out.println();
            }
        }

    }

}
