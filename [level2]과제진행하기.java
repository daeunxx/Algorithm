import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Queue<String[]> queue = new PriorityQueue<>((o1, o2) -> o1[1].compareTo(o2[1]));
        Stack<String[]> stack = new Stack<>(); 
        int idx = 0;
        
        for(String[] plan : plans){
            queue.add(new String[]{plan[0], plan[1], plan[2]});
        }
        
        while(!queue.isEmpty()){
            String[] poll = queue.poll();
            
            if(queue.isEmpty()){
                answer[idx++] = poll[0];
                break;
            }
            
            String[] peek = queue.peek();
            String endTime = calEndTime(poll[1], poll[2]);
            
            System.out.println(poll[0] + " " + poll[1] + " " + endTime + " " + peek[0] + " " + peek[1] + " " + subTime(endTime, peek[1]));
            
            if(subTime(endTime, peek[1]) > 0){
                // System.out.println(poll[0] + " " + Integer.toString(subTime(peek[1], endTime)));
                stack.add(new String[]{poll[0], Integer.toString(subTime(endTime, peek[1]))});
            }
            else{
                answer[idx++] = poll[0];
                
                int remaining = subTime(peek[1], endTime);
                System.out.println(remaining);
                
                if(remaining==0)
                    continue;
                
                while(remaining > 0 && !stack.isEmpty()){
                    String[] sPeek = stack.peek();
                    
                    if(remaining >= Integer.valueOf(sPeek[1])){
                        answer[idx++] = sPeek[0];
                        remaining -= Integer.valueOf(sPeek[1]);
                        stack.pop();
                    }
                    else{
                        stack.pop();
                        System.out.println(sPeek[0] + " " + Integer.toString(Integer.valueOf(sPeek[1]) - remaining));
                        stack.push(new String[]{sPeek[0], Integer.toString(Integer.valueOf(sPeek[1]) - remaining)});
                        break;
                    }
                }
            }
        }
        
        while(!stack.isEmpty()){
            String[] peek = stack.peek();
            answer[idx++] = peek[0];
            stack.pop();
        }
        
        return answer;
    }
    
    public String calEndTime(String time, String during){
        String[] str = time.split(":");
        
        int hour = Integer.valueOf(str[0]);
        int minute = Integer.valueOf(str[1]) + Integer.valueOf(during);
        
        if(minute >= 60){
            hour += Math.ceil(minute/60);
            minute = minute%60;
        }
        
        return Integer.valueOf(hour) + ":" + Integer.valueOf(minute);
    }
    
    public int subTime(String time1, String time2){
        String[] str1 = time1.split(":");
        String[] str2 = time2.split(":");
        
        return (Integer.valueOf(str1[0])*60 + Integer.valueOf(str1[1])) - (Integer.valueOf(str2[0])*60 + Integer.valueOf(str2[1]));
    }
}
