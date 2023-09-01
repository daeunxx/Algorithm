import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int n = 0, idx = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = ++n;
            }
        }
        
        for(int[] query : queries){
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;

            int tmp1 = arr[x1][y1];
            int tmp2;
            int min = tmp1;

            for(int i=y1+1; i<=y2; i++){
                tmp2 = arr[x1][i];
                arr[x1][i] = tmp1;
                tmp1 = tmp2;
                min = Math.min(min, tmp1);
            }

            for(int i=x1+1; i<=x2; i++){
                tmp2 = arr[i][y2];
                arr[i][y2] = tmp1;
                tmp1 = tmp2;
                min = Math.min(min, tmp1);
            }

            for(int i=y2-1; i>=y1; i--){
                tmp2 = arr[x2][i];
                arr[x2][i] = tmp1;
                tmp1 = tmp2;
                min = Math.min(min, tmp1);
            }

            for(int i=x2-1; i>=x1; i--){
                tmp2 = arr[i][y1];
                arr[i][y1] = tmp1;
                tmp1 = tmp2;
                min = Math.min(min, tmp1);
            }
            
            answer[idx++] = min;
        }
        
        // for(int i=0; i<rows; i++)
        //     System.out.println(Arrays.toString(arr[i]));
        
        return answer;
    }
}
