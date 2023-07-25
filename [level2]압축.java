import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int idx = 0;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        String str = "";
        
        while(idx < msg.length()){
            String word = Character.toString(msg.charAt(idx));
            int count = 0;
            
            for(int i=idx+1; i < msg.length(); i++){
                word += Character.toString(msg.charAt(i));
                if(!list.contains(word)){
                    list.add(word);
                    count = i;
                    break;
                }
            }
                       
            if(count==0){
                idx++;
            }
            else{
                idx = count;
                if(word.length() < 3){
                    str += Character.toString(word.charAt(0));
                    answerList.add(word.charAt(0)-'0'-16);
                }
                else{
                    str += word.substring(0, word.length()-1);
                    int listIdx = list.indexOf(word.substring(0, word.length()-1));
                    answerList.add(listIdx + 27);
                }   
            }
        }
        
        msg = msg.replace(str, "");
        
        if(list.contains(msg))
            answerList.add(list.indexOf(msg) + 27);
        else
            answerList.add(msg.charAt(0)-'0'-16);
        
        return answerList.stream().mapToInt(i->i).toArray();
    }
}
