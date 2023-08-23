import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            char[][] maps = new char[5][5];
            for(int j=0; j<5; j++){
                maps[j] = places[i][j].toCharArray();
            }
            answer[i] = bfs(maps);
        }
        
        return answer;
    }
    
    public int bfs(char[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(maps[i][j]=='P' || maps[i][j]=='O'){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            // System.out.println(Arrays.toString(poll));
            int cnt = 0;
            
            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
                    continue;
                
                if(maps[nx][ny]=='P'){
                    
                    if(maps[poll[0]][poll[1]]=='P')
                        return 0;
                    
                    else
                        cnt++;
                    
                    if(cnt > 1)
                        return 0;
                }
            }
        }
        
        return 1;
    }
}
