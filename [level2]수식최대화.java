import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[] operators = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};
        
        for(int i=0; i<operators.length; i++){
            
            ArrayList<Long> numList = new ArrayList<>();
            ArrayList<Character> operList = new ArrayList<>();
            String number = "";

            for(int j=0; j<expression.length(); j++){
                char c = expression.charAt(j);

                if(c=='+' || c=='-' || c=='*'){
                    operList.add(c);
                    numList.add(Long.valueOf(number));
                    number = "";
                    continue;
                }
                number += Character.toString(c);
            }
            
            String lastNum = expression.substring(expression.lastIndexOf(Character.toString(operList.get(operList.size()-1)))+1);
            numList.add(Long.valueOf(lastNum));
            
            for(int j=0; j<3; j++){
                char operator = operators[i].charAt(j);
                int idx = operList.indexOf(operator);
                while(idx > -1 && idx < numList.size()-1){
                    operList.remove(idx);
                    
                    switch(operator){
                        case '+' :
                            numList.set(idx, numList.get(idx) + numList.get(idx+1));
                            break;
                        case '-' :
                            numList.set(idx, numList.get(idx) - numList.get(idx+1));
                            break;
                        case '*' :
                            numList.set(idx, numList.get(idx) * numList.get(idx+1));
                            break;     
                    }
                    numList.remove(idx+1);
                    
                    if(!operList.contains(operator))
                        break;
                    else
                        idx = operList.indexOf(operator);
                }
            }
            
            if(answer < Math.abs(numList.get(0)))
                answer = Math.abs(numList.get(0));
        }
        
        return answer;
    }
}
