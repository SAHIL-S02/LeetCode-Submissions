class Solution {

    Boolean[][] dp;
    int start = 0;
    int maxLen = 1;

    boolean solve(String s, int i, int j) {

        if(i >= j)
            return true;

        if(dp[i][j] != null)
            return dp[i][j];

        if(s.charAt(i) != s.charAt(j))
            return dp[i][j] = false;

        boolean ans = solve(s, i + 1, j - 1);

        if(ans && j - i + 1 > maxLen){
            maxLen = j - i + 1;
            start = i;
        }

        return dp[i][j] = ans;
    }

    public String longestPalindrome(String s) {

        int n = s.length();

        dp = new Boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                solve(s, i, j);
            }
        }

        return s.substring(start, start + maxLen);
    }
}