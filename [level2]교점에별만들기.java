import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        ArrayList<long[]> list = new ArrayList<>();
        
        for(int i=0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++){
                if(line[i][0]*line[j][1] - line[i][1]*line[j][0]==0)
                    continue;
                
                double x = (double)((long)line[i][1]*(long)line[j][2] - (long)line[i][2]*(long)line[j][1]) / ((long)line[i][0]*(long)line[j][1] - (long)line[i][1]*(long)line[j][0]);
                double y = (double)((long)line[i][2]*(long)line[j][0] - (long)line[i][0]*(long)line[j][2]) / ((long)line[i][0]*(long)line[j][1] - (long)line[i][1]*(long)line[j][0]);
                // System.out.println(x + " " + y + " " + Math.abs(x%1));
                
                if(Math.abs(x%1)==0.0 && Math.abs(y%1)==0.0){
                    list.add(new long[]{(long)x, (long)y});
                    // System.out.println(x + " " + y + " " + Math.abs(x%1));
                }
            }
        }
        
        long minY = list.get(0)[1];
        long maxY = list.get(0)[1];
        long minX = list.get(0)[0];
        long maxX = list.get(0)[0];
        
        for(int i=0; i<list.size(); i++){
            if(minX > list.get(i)[0])
                minX = list.get(i)[0];
            
            if(maxX < list.get(i)[0])
                maxX = list.get(i)[0];
            
            if(minY > list.get(i)[1])
                minY = list.get(i)[1];
            
            if(maxY < list.get(i)[1])
                maxY = list.get(i)[1];
        }
        
        String floor = "";
        
        for(long i=minX; i<=maxX; i++)
            floor += ".";
        
        System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
        // System.out.println(floor);
        
        String[] answer = new String[(int)(maxY-minY+1)];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = floor;
        }
        
        for(int i=0; i<list.size(); i++){
            int x = (int)(list.get(i)[0] - minX);
            int y = (int)(maxY - list.get(i)[1]);
            // System.out.println(list.get(i)[0] + " " + list.get(i)[1] +  " " + x + " " + y);
            StringBuilder builder = new StringBuilder(answer[y]);
            builder.setCharAt(x, '*');
            
            answer[y] = builder.toString();
        }
        
        return answer;
    }
}
