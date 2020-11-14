import java.util.*;

public class Programmers12910 {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            int[] answer= {};
            ArrayList<Integer> num= new ArrayList<>();
            for(int i = 0; i<arr.length; i++){
                if(arr[i]%divisor==0){
                    num.add(arr[i]);
                }
            }
            if(num.isEmpty()){
                num.add(-1);
            }

            answer = new int[num.size()];

            for (int j =0; j<answer.length;j++){
                answer[j]=num.get(j);
            }
            Arrays.sort(answer);
            return answer;
        }
    }
    }

