import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i =0; i<orders.length; i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = new String(charArr);
        }
        
        
        for(int n : course){
            int max = 0;
            map = new HashMap<>();
            ArrayList<Integer> valueList = new ArrayList<>();
            
            for(String order : orders){
                if(order.length() < n)
                    continue;
                
                String[] input = order.split("");
                combination(0, 0, input, new String[n]);
            }
            
            // System.out.println(map);
            
            if(!map.isEmpty()){
                valueList = new ArrayList<>(map.values());
                max = Collections.max(valueList);
            }
            
            
            if(max < 2)
                continue;
            
            for(String key : map.keySet()){
                if(map.get(key)==max)
                    answer.add(key);
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    public void combination(int depth, int start, String[] input, String[] output){
        if(depth==output.length){
            
            String key = "";
            
            for(String str : output)
                key += str;
                
            map.put(key, map.getOrDefault(key, 0)+1);
            return;
        }
        
        for(int i=start; i<input.length; i++){
            output[depth] = input[i];
            combination(depth+1, i+1, input, output);
        }
    }
}
