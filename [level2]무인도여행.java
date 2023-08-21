import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    int n, m;
    
    public int[] solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        
        char[][] arr = new char[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                arr[i][j] = maps[i].charAt(j);
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && arr[i][j] != 'X'){
                    answer.add(bfs(i, j, arr));
                }
            }
        }
        
        Collections.sort(answer);
        
        if(answer.size()==0)
            answer.add(-1);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    public int bfs(int x, int y, char[][] arr){
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            sum += arr[poll[0]][poll[1]] - '0';
            
            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >=m)
                    continue;
                
                if(!visited[nx][ny] && arr[nx][ny]!='X'){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        return sum;
    }
}
