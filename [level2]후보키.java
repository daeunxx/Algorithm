import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<String> keyList = new ArrayList<>();
        int length = relation[0].length;
        
        for(int i=0; i<length; i++)
            input.add(i);
        
        for(int i=0; i<length; i++)
            combination(0, 0, input, new int[i]);
        
        list.remove(0);
        
        for(int i=0; i<list.size(); i++)
            list.set(i, list.get(i).trim());
        
        // System.out.println(list);
        
        for(int i=0; i<list.size(); i++){
            String[] strArr = list.get(i).split(" ");
            int[] arr = new int[strArr.length];
            
            for(int j=0; j<strArr.length; j++)
                arr[j] = Integer.valueOf(strArr[j]);
            
            // System.out.println(Arrays.toString(arr));
            Set<String> set = new HashSet<>();
            
            for(int j=0; j<relation.length; j++){
                String value = "";
                for(int k=0; k<arr.length; k++){
                    value += relation[j][arr[k]];
                }
                set.add(value);
            }
            
            if(set.size()==relation.length)
                keyList.add(list.get(i));
        }
        
        if(keyList.size()==0)
            return 1;
        
        while(keyList.size() > 0){
            String[] keyArr = keyList.get(0).split(" ");
            String str = "";
            
            for(int i=0; i<keyArr.length; i++)
                str += "(.*)" + keyArr[i];
            
            str += "(.*)";
            
            String regex = str;
            keyList.removeIf(k -> k.matches(regex));
            // System.out.println(regex + " " + keyList);
            answer++;
        }
        
        return answer;
    }
    
    public void combination(int depth, int start, ArrayList<Integer> input, int[] output){
        if(depth==output.length){
            String str = "";
            for(int n : output)
                str += Integer.toString(n) + " ";
            
            list.add(str);
            return;
        }
        
        for(int i=start; i<input.size(); i++){
            output[depth] = input.get(i);
            combination(depth+1, i+1, input, output);
        }
    }
}
