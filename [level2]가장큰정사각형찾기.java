import java.util.*;

class Solution{  
    public int solution(int[][] board){
        int max = 0;
        
        for(int i=1; i<board.length; i++){
            for(int j=1; j<board[0].length; j++){
                if(board[i][j]==1){
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    
                    if(max < board[i][j])
                        max = board[i][j];
                }
            }
        }
        
        if(max==0){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j]==1)
                        return 1;
                }
            }
        }
        
        return max*max;
    }
}
