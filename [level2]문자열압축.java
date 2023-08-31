import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=1; i<=s.length()/2; i++){
            StringBuilder builder = new StringBuilder();
            String preStr = "";
            int idx = 0, cnt = 1;
            
            while(idx + i <= s.length()){
                String curStr = s.substring(idx, idx+i);
                idx += i;
                
                if(curStr.equals(preStr)){
                    cnt++;
                    continue;
                }
                else if(cnt > 1){
                    builder.append(cnt + preStr);
                    cnt = 1;
                }
                else
                    builder.append(preStr);
                
                preStr = curStr;
            }
            
            builder.append((cnt > 1) ? cnt + preStr : preStr);
            
            if(s.length()%i !=0)
                builder.append(s.substring(s.length() - s.length()%i, s.length()));
            
            answer = Math.min(answer, builder.length());
            
        }
        
        answer = (s.length()==1) ? 1 : answer;
        
        return answer;
    }
}
