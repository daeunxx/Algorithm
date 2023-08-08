import java.util.*;

class Solution {
    
    ArrayList<Integer> list = new ArrayList<>();
    
    public int solution(int[] cards) {
        
        bfs(cards, new boolean[cards.length+1]);
        Collections.sort(list, Collections.reverseOrder());
        
        return list.get(0) * list.get(1);
    }
    
    public void bfs(int[] cards, boolean[] visited){
        
        for(int i=0; i<cards.length; i++){
            Stack<Integer> stack = new Stack<>();
            
            if(!visited[cards[i]]){
                stack.push(cards[i]);
                visited[cards[i]] = true;
            }
            
            while(!stack.isEmpty()){
                int val = cards[stack.peek()-1];
                if(!visited[val]){
                    stack.push(val);
                    visited[val] = true;
                }
                else
                    break;

            }
            
            list.add(stack.size());
        }
    }
}
