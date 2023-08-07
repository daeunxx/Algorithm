import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] arr = new String[files.length][3];
        
        for(int i=0; i<files.length; i++){
            Pattern pattern  = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(files[i]);
            
            if(matcher.find()){
                arr[i][0] = files[i].substring(0, matcher.start());
                arr[i][1] = files[i].substring(matcher.start(), matcher.end());
                arr[i][2] = files[i].substring(matcher.end());
            }
            
            // System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0].toUpperCase().compareTo(o2[0].toUpperCase()) < 0)
               return -1;
            else if(o1[0].toUpperCase().compareTo(o2[0].toUpperCase()) > 0)
                return 1;
            else{
                if(Integer.valueOf(o1[1]) < Integer.valueOf(o2[1]))
                    return -1;
                else if(Integer.valueOf(o1[1]) > Integer.valueOf(o2[1]))
                    return 1;
                else
                    return 0;
            }
        });
        
        for(int i=0; i<arr.length; i++)
            answer[i] = arr[i][0] + arr[i][1] + arr[i][2];
        
        return answer;
    }
}
