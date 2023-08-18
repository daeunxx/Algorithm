import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n,m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return bfs(0, 0, maps, new boolean[n][m]);
    }
    
    public int bfs(int x, int y, int[][] maps, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                
                if(!visited[nx][ny] && maps[nx][ny]==1){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    maps[nx][ny] = maps[poll[0]][poll[1]] + 1;
                }
            }
        }
        
        if(visited[n-1][m-1])
            return maps[n-1][m-1];
        else
            return -1;
    }
}
