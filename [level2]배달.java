import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int arr[][] = new int[N+1][N+1];

        for(int i=0; i<road.length; i++){
            
            if(arr[road[i][0]][road[i][1]]!=0 && arr[road[i][0]][road[i][1]] < road[i][2])
                continue;
            
            arr[road[i][0]][road[i][1]] = road[i][2];
            arr[road[i][1]][road[i][0]] = road[i][2];
        }
        
        int distance[] = dijkstra(1, arr);
        // System.out.println(Arrays.toString(distance));
        
        for(int i=1; i<distance.length; i++){
            if(distance[i]<=K){
                answer++;
            }
        }

        return answer;
    }
    
    public int[] dijkstra(int v, int arr[][]){
        int n = arr.length-1;
        int distance[] = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for(int i=1; i<=n; i++)
            distance[i] = 500001;

        distance[v] = 0;
        visited[v] = true;

        for(int i=1; i<=n; i++){
            if(!visited[i] && arr[v][i]!=0)
                distance[i] = arr[v][i];
        }

        for(int i=1; i<=n-1; i++){
            int min = 500001;
            int minIdx = -1;

            for(int j=1; j<=n; j++){
                if(!visited[j] && distance[j]!=500001){
                    if(distance[j] < min){
                        min = distance[j];
                        minIdx = j;
                    }
                }
            }

            visited[minIdx] = true;
            for(int j=1; j<=n; j++){
                if(!visited[j] && arr[minIdx][j]!=0){
                    if(distance[j] > distance[minIdx] + arr[minIdx][j])
                        distance[j] = distance[minIdx] + arr[minIdx][j];
                }
            }
        }

        return distance;
    }
}
