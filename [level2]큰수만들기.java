import java.util.*;

class Solution {
    public StringBuilder solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int[] arr = new int[number.length()];
        int idx = 0;
        
        for(int i=0; i<number.length(); i++)
            arr[i] = number.charAt(i) - '0';
        
        while(k < arr.length){
            int max = 0;
            for(int i=idx; i<=k; i++){
                if(max < arr[i]){
                    max = arr[i];
                    idx = i;
                }
            }
            
            answer.append(arr[idx]);
            arr[idx] = 0;
            // System.out.println(max + " " + idx + " " + k);
            k++;
        }
        
        return answer;
    }
}
