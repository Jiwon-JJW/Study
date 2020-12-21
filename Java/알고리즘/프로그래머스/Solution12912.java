public class Solution12912 {
    public long solution(int a, int b) {
        long answer = 0;
        if(a == b){
            answer = a;
            return answer;
        }
        if(a<b){
            for (int i = a; i<=b; i++){
                answer += i;
            }
            return answer;
        }
        if(a>b){
            for (int i = b; i<=a; i++){
                answer += i;
            }
            return answer;
        }
        return answer;
    }
}
