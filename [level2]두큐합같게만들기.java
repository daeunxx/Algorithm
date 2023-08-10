import java.util.*;

class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long answer = 0;
        long q1Sum = 0L, sum = 0L;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum += queue1[i] + queue2[i];
            q1Sum += queue1[i];
        }
        
        if(sum%2!=0)
            return -1;
        
        sum /= 2;
        
        while(answer < 3*queue1.length){
            if(q1Sum==sum)
                return answer;
            else if(q1Sum<sum){
                q1Sum += q2.peek();
                q1.add(q2.poll());
            }
            else{
                q1Sum -= q1.peek();
                q2.add(q1.poll());
            }
            
            answer++;
            
            // System.out.println(q1 + " " + q2 + " " + answer);
        }
        
        
        return -1;
    }
}
