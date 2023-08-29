import java.util.*;

class Solution {
    Queue<int[]> queue = new LinkedList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] percent = {10, 20, 30, 40};
        int idx = 0;
        List<int[]> list = new ArrayList<>();

        combination(0, 0, percent, new int[emoticons.length]);
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int[] emoji = new int[emoticons.length];
            int cnt = 0, price = 0;
            
            for(int i=0; i<emoticons.length; i++){
                emoji[i] = (int)(emoticons[i] * (100 - poll[i]) * 0.01);
                // System.out.print(emoji[i] + " ");
            }
            
            // System.out.println("");
            
            for(int[] user : users){
                int sum = 0;
                
                for(int i=0; i<emoji.length; i++){
                    if(poll[i] >= user[0])
                        sum += emoji[i];
                }
                
                if(sum >= user[1]){
                    cnt++;
                    sum = 0;
                }
                
                price += sum;
            }
            
            list.add(new int[]{cnt, price});
        }
        
        list.sort((o1, o2) -> o1[0]==o2[0] ? o2[1]-o1[1] : o2[0]-o1[0]);
        
        answer[0] = list.get(0)[0];
        answer[1] = list.get(0)[1];
        
        return answer;
    }
    
    public void combination(int depth, int start, int[] input, int[] output){
        if(depth==output.length){
            int[] arr = new int[output.length];
            for(int i=0; i<output.length; i++){
                arr[i] = output[i];
            }
            queue.add(arr);
            return;
        }
        
        for(int i=0; i<input.length; i++){
            output[depth] = input[i];
            combination(depth+1, i+1, input, output);
        }
    }
}
