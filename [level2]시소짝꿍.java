import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int left = 0, right = 1;
        
        Arrays.sort(weights);
        
        while(left < weights.length-1){
            
            if(weights[left]==weights[right] || 2*weights[left]==weights[right] || 3*weights[left]==2*weights[right] || 4*weights[left]==3*weights[right])
                answer++;
            
            if(2*weights[left] < weights[right] || right==weights.length-1){
                left++;
                right = left + 1;
            }
            else
                right++;
        }
        
        return answer;
    }
    
}
