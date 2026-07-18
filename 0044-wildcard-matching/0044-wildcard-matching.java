class Solution {
    public boolean check(int n, int m, String s, String p, Boolean memo[][]){
        
        if(n < 0 && m < 0){
            return true;
        }
        if (m < 0){
            return false;
        }
        if(n < 0){
            while(m >=0){
                if(p.charAt(m) != '*'){
                    return false;
                }
                m--;
            }
            return true;
        }
        if(memo[n][m] != null){
            return memo[n][m];
        }
        if(p.charAt(m) == '*'){
            return memo[n][m] = check(n, m-1, s, p, memo) || check(n-1, m, s, p, memo);
        }
        if(s.charAt(n) == p.charAt(m)){
            return memo[n][m] = check(n-1, m-1, s, p, memo);

        }else if(p.charAt(m) == '?'){
            return memo[n][m] = check(n-1, m-1, s, p, memo);
        }else{
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        Boolean memo[][] = new Boolean[s.length()][p.length()];
        return check(s.length()-1, p.length()-1, s, p, memo);
    }
}