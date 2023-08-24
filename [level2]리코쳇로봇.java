import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        int sx = 0, sy = 0;
        char[][] maps = new char[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i].charAt(j)=='R'){
                    sx = i;
                    sy = j;
                }
            }
            maps[i] = board[i].toCharArray();
        }
        
        return bfs(sx, sy, maps);
    }
    
    public int bfs(int x, int y, char[][] maps){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = poll[0];
                int ny = poll[1];
                int cnt = poll[2];
                
                while(true){
                    nx += dx[i];
                    ny += dy[i];
                    
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                        break;
                    
                    if(maps[nx][ny]=='D'){
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    if(i==0)
                        nx = 0;
                    else if(i==1)
                        nx = n-1;
                    else if(i==2)
                        ny = 0;
                    else
                        ny = m-1;
                }
                
                if(maps[nx][ny]=='G')
                    return cnt + 1;
                
                if(!visited[nx][ny]){
                    queue.add(new int[]{nx, ny, cnt+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}
