import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int m, int n, String[] board) {
        
        while(true){
            ArrayList<String> list = new ArrayList<>();
            
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(check(i, j, board))
                        list.add(i+ " " + j);
                }
            }
            
            if(list.isEmpty())
                break;
            
            // System.out.println(list);
            board = change(list, board);
        
            for(int i=0; i<n; i++)
                board = blockSort(i, m, board);
        }
        
        return answer;
    }
    
    public boolean check(int i, int j, String[] board){
        if(board[i].charAt(j)=='0')
            return false;
        
        else if(board[i].charAt(j) == board[i+1].charAt(j)){
            if(board[i].charAt(j) == board[i].charAt(j+1)){
                if(board[i].charAt(j) == board[i+1].charAt(j+1))
                    return true;
            }
        }
        return false;
    }
    
    public String[] change(ArrayList<String> list, String[] board){
        
        for(int i=0; i<list.size(); i++){
            int idx = list.get(i).indexOf(" ");
            int x = Integer.valueOf(list.get(i).substring(0, idx));
            int y = Integer.valueOf(list.get(i).substring(idx+1));
            
            StringBuilder builder = new StringBuilder(board[x]);
            
            if(builder.charAt(y)!='0')
                answer++;
            
            if(builder.charAt(y+1)!='0')
                answer++;
            
            // System.out.print(answer + " ");
            builder.setCharAt(y, '0');
            builder.setCharAt(y+1, '0');
            
            board[x] = builder.toString();
            
            
            builder = new StringBuilder(board[x+1]);
            
            if(builder.charAt(y)!='0')
                answer++;
            
            if(builder.charAt(y+1)!='0')
                answer++;
            
            builder.setCharAt(y, '0');
            builder.setCharAt(y+1, '0');
            
            board[x+1] = builder.toString();
            
            // System.out.println(answer);
        }
        
        return board;
    }
    
    public String[] blockSort(int x, int m, String[] board){
        String str1 = "", str2 = "";
        
        for(int i=0; i<m; i++){
            if(board[i].charAt(x)=='0')
                str1 += "0";
            else
                str2 += Character.toString(board[i].charAt(x));
        }
        
        str1 += str2;
        
        for(int i=0; i<m; i++){
            StringBuilder builder = new StringBuilder(board[i]);
            builder.setCharAt(x, str1.charAt(i));
            board[i] = builder.toString();
        }
            
        
        return board;
    }
}
