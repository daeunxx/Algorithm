import java.util.*;

class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        if(numbers.length%2==0){            
            for(int i=0; i<numbers.length; i++){
                if(i%2==0)
                    list.add(numbers[i]);
            }
        }
        else{
            for(int i=0; i<numbers.length; i++){
                if(i%2==0)
                    list.add(numbers[i]);
            }
            
            for(int i=0; i<numbers.length; i++){
                if(i%2==1)
                    list.add(numbers[i]);
            }
            
        }
        
        System.out.println(list);
        
        return list.get((k-1)%list.size());
    }
}
