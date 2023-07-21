import java.util.*;

class Solution {
    public int solution(int n) {
        int[] arr = new int[n];
        
        arr[0] = 1;
        arr[1] = 2;
        
        for(int i=2; i<n; i++){
            arr[i] = (arr[i-2]%1000000007 + arr[i-1]%1000000007)%1000000007;
        }
        // System.out.println(list);
        
        return arr[n-1];
    }
}

// 1 : 1                                            1
// 2 : 11 2                                         2
// 3 : 111 12 21                                    3
// 4 : 1111 112 121 211 22                          5
// 5 : 11111 1112 1121 1211 2111 122 212 221        8
// 6 : 111111 11112 11121 11211 12111 21111 1122 1212 1221 2112 2121 2211 222 13
