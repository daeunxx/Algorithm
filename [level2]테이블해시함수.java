import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        ArrayList<Integer> list = new ArrayList<>();
        
        Arrays.sort(data, (o1, o2) -> o1[col-1]==o2[col-1] ? o2[0]-o1[0] : o1[col-1]-o2[col-1]);
        
        for(int i = row_begin-1; i<row_end; i++){
            int sum = 0;
            for(int j=0; j<data[0].length; j++){
                sum += data[i][j] % (i+1);
            }
            list.add(sum);
        }
        
        int answer = list.get(0);
        
        for(int i=1; i<list.size(); i++){
            answer ^= list.get(i);
        }
        
        return answer;
    }
}
