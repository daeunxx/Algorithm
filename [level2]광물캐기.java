import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int diaSum = 0, ironSum = 0, stoneSum = 0, idx = 0;
        int sum =  picks[0] + picks[1] + picks[2];
        int size = Math.min((int)Math.ceil((double)minerals.length/5), sum);
        int[][] arr= new int[size][3];
        
        // System.out.println(Arrays.toString(arr));
        
        for(int i=0; i<minerals.length; i++){
            if(idx==size)
                break;
            
            if(minerals[i].equals("diamond")){
                diaSum++;
                ironSum += 5;
                stoneSum += 25;
            }
            else if(minerals[i].equals("iron")){
                diaSum++;
                ironSum++;
                stoneSum += 5;
            }
            else{
                diaSum++;
                ironSum++;
                stoneSum++;
            }
            
            if(i%5==4 || i==minerals.length-1){
                arr[idx][0] = diaSum;
                arr[idx][1] = ironSum;
                arr[idx][2] = stoneSum;
                
                diaSum = 0;
                ironSum = 0;
                stoneSum = 0;
                
                idx++;
            }
        }
        
        // System.out.println(Arrays.toString(arr[0]));
        // if(arr.length > 1)
        //     System.out.println(Arrays.toString(arr[1]));
        
        Arrays.sort(arr, (o1, o2) -> o2[2]-o1[2]);
        // Arrays.sort(arr, (o1, o2) -> o1[0]==o2[0] ? o2[2]-o1[2] : o2[0]-o1[0]);
        
        idx = 0;
        
        for(int i=0; i<arr.length; i++){
            if(picks[idx]==0){
                while(true){
                    idx++;
                    if(picks[idx]!=0 || idx==3)
                        break;
                }
            }
            
            if(idx==3)
                break;
            
            else if(picks[idx]!=0){
                if(idx==0)
                    answer+=arr[i][0];
                else if(idx==1)
                    answer+=arr[i][1];
                else if(idx==2)
                    answer+=arr[i][2];
            }
            
            // System.out.println(Arrays.toString(arr[i]) + idx + " " + picks[idx]);
            picks[idx]--;
        }
        
        return answer;
    }
}
