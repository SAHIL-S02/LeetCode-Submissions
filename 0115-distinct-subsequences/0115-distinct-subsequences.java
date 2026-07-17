class Solution {
    public int check (int n, int m, String s, String t, int[][] memo){
        if(m < 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(memo[n][m] != -1){
            return memo[n][m];
        }
        if(s.charAt(n) == t.charAt(m)){
            return memo[n][m] = check(n - 1, m-1, s, t, memo) + check(n-1, m, s, t, memo);
        }
        return memo[n][m] = check(n-1, m, s, t, memo);
    }
    public int numDistinct(String s, String t) {
        int memo [][]  = new int[s.length()][t.length()];
        for(int arr[]:memo){
            Arrays.fill(arr, -1);
        }
        return check(s.length()-1, t.length()-1, s, t, memo);
    }
}