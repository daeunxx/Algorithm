import java.util.*;

class Solution {
    public String solution(String p) {
        if(isRight(p))
            return p;
        
        String u = "", v = "";
        
        for(int i=1; i<=p.length(); i++){
            u = p.substring(0, i);
            v = p.substring(i, p.length());

            if(isSameCnt(u))
                break;
        }
        
        System.out.println(u + " " + v);
        
        if(isRight(u))
            return u + solution(v);
        
        return "(" + solution(v) + ")" + reverse(u);
    }
    
    public boolean isRight(String p){
        Stack<Character> stack = new Stack<>();
        
        if(p.length()==0)
            return true;
        
        if(p.charAt(0)==')')
            return false;
        else{
            stack.push(p.charAt(0));
            
            for(int i=1; i<p.length(); i++){
                if(!stack.isEmpty() && stack.peek()=='(' && p.charAt(i)==')')
                    stack.pop();
                else
                    stack.push(p.charAt(i));
            }
        }
        
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    
    public boolean isSameCnt(String p){
        int cnt1 = 0, cnt2 = 0;
        
        for(char c : p.toCharArray()){
            if(c=='(')
                cnt1++;
            else
                cnt2++;
        }
        
        if(cnt1==cnt2)
            return true;
        else
            return false;
    }
    
    public String reverse(String p){
        p = p.substring(1, p.length()-1);
        p = p.replace("(", "*").replace(")", "(").replace("*", ")");
        
        return p;
    }
}
