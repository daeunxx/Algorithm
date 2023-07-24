import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0, right = 0, length = 10000001;
        int sum = sequence[0];
        
        while(sequence[0]!=k){
            if(right==sequence.length-1)
                sum -= sequence[left++];
            else if(sum > k)
                sum -= sequence[left++];
            else
                sum += sequence[++right];
            
            if(sum==k){
                if(right-left < length){
                    answer[0] = left;
                    answer[1] = right;
                    length = right - left;
                }
            }
            
            // System.out.println(left + " " + right + " " + sum);
            
            if(left==sequence.length-1)
                break;
            
        }
         
        return answer;
    }
}
