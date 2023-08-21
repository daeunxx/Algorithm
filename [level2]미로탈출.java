import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] arr;
    int n, m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;
        arr = new int[n][m];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(maps[i].charAt(j)=='S'){
                    sx = i;
                    sy = j;
                }
                else if(maps[i].charAt(j)=='L'){
                    lx = i;
                    ly = j;
                }
                else if(maps[i].charAt(j)=='E'){
                    ex = i;
                    ey = j;
                }
            }
        }
        
//         System.out.println(sx + " " + sy + " " + lx + " " + ly + " " + ex + " " + ey);
        
        bfs(sx, sy, lx, ly, maps, new boolean[n][m]);
        bfs(lx, ly, ex, ey, maps, new boolean[n][m]);
        
        // for(int i=0; i<n; i++)
        //     System.out.println(Arrays.toString(arr[i]));
        
        if(arr[lx][ly]!=0 && arr[ex][ey]!=0)
            return arr[ex][ey];
        else
            return -1;
    }
    
    public void bfs(int x1, int y1, int x2, int y2, String[] maps, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1});
        visited[x1][y1] = true;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            
            if(poll[0]==x2 && poll[1]==y2)
                break;
            
            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                
                if(!visited[nx][ny] && maps[nx].charAt(ny)!='X'){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    arr[nx][ny] = arr[poll[0]][poll[1]] + 1;
                }
            }
        }
    }
}
