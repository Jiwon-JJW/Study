import java.util.ArrayList;

public class Programmers12928 {
    class Solution {
        public int solution(int n) {
            int x = 0;
            for(int i =1; i<=n; i++){
                if(n%i==0){
                    x+=i;
                }
            }
            int answer = x;
            return answer;
        }
    }
    }



