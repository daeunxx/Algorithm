import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        Set<String> set = new HashSet<>();
        
        m = m.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a");      
        
        for(int i=0; i<m.length(); i++){
            set.add(m.substring(i) + m.substring(0,i));
        }
        
        // System.out.println(set);
        
        for(String music : musicinfos){
            String[] arr = music.split(",");
            
            if(!arr[0].substring(0,2).equals(arr[1].substring(0,2))){
                int hour = Integer.valueOf(arr[1].substring(0,2)) - Integer.valueOf(arr[0].substring(0,2));
                arr[1] = arr[0].substring(0,2) + ":" + Integer.toString(hour*60 + Integer.valueOf(arr[1].substring(3)));
            }
            
            // System.out.println(arr[1]);
            
            arr[3] = arr[3].replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a"); 
            
            int time = Integer.valueOf(arr[1].substring(3)) - Integer.valueOf(arr[0].substring(3));
            int size = arr[3].length();
            
            if(time < size)
                arr[3] = arr[3].substring(0, time);
            else if(time > size){
                StringBuilder builder = new StringBuilder(arr[3]);
                int idx = 0;
                
                while(true){
                    if(idx==builder.length())
                        idx =0;               
                    arr[3] += Character.toString(builder.charAt(idx));
                    size++;
                    idx++;
                    
                    if(time==size)
                        break;
                }
            }
            
            if(arr[3].indexOf(m)!=-1 && time > max){
                max = time;
                answer = arr[2];
            }
        }
        
        return answer;
    }
}