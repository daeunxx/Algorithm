import java.util.*;

class Solution {
    ArrayList<Long> factorialList = new ArrayList<>();
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        
        factorial(n);
        // System.out.println(factorialList);
        
        for(int i=n; i>1; i--){
            int idx = (int)((k-1)/factorialList.get(i-1));
            // System.out.print(k + " ");
            k -= factorialList.get(i-1)*idx;
            // System.out.println(k + " " + idx);
            answer[n-i] =  list.get(idx);
            list.remove(idx);
            // list.remove((k-1)/factorial(i-1));
        }
        
        answer[n-1] = list.get(0);
        
        return answer;
    }
    
    public void factorial(long n){
        factorialList.add(0L);
        factorialList.add(1L);
        
        for(long i=2; i<=n; i++)
            factorialList.add(i*factorialList.get((int)i-1));
    }
}
