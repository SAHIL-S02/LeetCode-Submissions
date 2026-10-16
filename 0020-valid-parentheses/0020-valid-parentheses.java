import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> res = new Stack<>();

        for(char a : s.toCharArray()){
            if(a == '(' || a == '{' || a == '['){
                res.push(a);
            }else{
                if(res.isEmpty()){
                    return false;
                }
                char temp = res.pop();
                if((a == ')' && temp != '(') || 
                (a == '}' && temp != '{') ||
                (a == ']' && temp != '[')){
                    return false;
                }
            }
        }
        return res.isEmpty();
    }
}