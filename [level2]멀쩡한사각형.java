import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long width = (long)w;
        long height = (long)h;
        int gcd = gcd(w, h);
        
        System.out.println(width/gcd + " " +  height/gcd + " " + gcd);
        
        return (width * height) - ((width/gcd + height/gcd - 1) * gcd);
    }
    
    public int gcd(int a, int b){
        if(a%b==0)
            return b;
        else
            return gcd(b, a%b);
    }
}
