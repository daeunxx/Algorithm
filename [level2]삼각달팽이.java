import java.util.*;

class Solution {
    public int[] solution(int n) {
        int length = n;
        int size = (n*n + n)/2;
        int[][] arr = new int[n][n];
        int num = 0, n1 = 0, n2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(length > 0){
            for(int i=0; i<length; i++)
                arr[i+n1][n2] = ++num;

            for(int i=0; i<length-1; i++)
                arr[n-n2-1][n2+1+i] = ++num;

            for(int i=0; i<length-2; i++)
                arr[n-n2-2-i][n-n1-1] = ++num;
            
            length-=3;
            n1+=2;
            n2++;
            // System.out.println(length + " " + x + " " + y);
        }
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++)
                list.add(arr[i][j]);
        }
        
        list.removeIf(k -> k==0);
        // System.out.println(list);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}
