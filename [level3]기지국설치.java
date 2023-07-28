import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int i=1, idx = 0;

        while(i<=n){
            if(idx < stations.length && i >= stations[idx]-w){
                i = stations[idx] + w + 1;
                idx++;
            }
            else{
                i += 2*w + 1;
                answer++;
            }
            // System.out.println(i + " " + idx + " " + answer);
        }

        return answer;
    }
}
