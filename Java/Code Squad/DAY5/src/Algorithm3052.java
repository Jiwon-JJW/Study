import java.util.Scanner;

public class Algorithm3052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        int count = 0;

        for(int i = 0; i<arr.length; i++){
            int j = scanner.nextInt();
            arr[i]= j%42;
        }

        for(int i=0; i<arr.length; i++){
            for(int k =0; k<i; k++){
                if(arr[i]==arr[k]){
                    continue;
                }
                if(arr[i]!=arr[k]){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
