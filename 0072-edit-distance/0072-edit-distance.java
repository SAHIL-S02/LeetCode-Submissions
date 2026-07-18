class Solution {
    public int check(int n, int m, String s1, String s2, int dp[][]){
        if(n < 0){
            return m+1;
        }
        if(m < 0){
            return n+1;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(s1.charAt(n) == s2.charAt(m)){
            return dp[n][m] = check(n-1, m-1, s1, s2, dp);
        }
        int ins = check(n, m-1, s1, s2, dp);
        int rep = check(n-1, m-1, s1, s2, dp);
        int del = check(n-1, m, s1, s2, dp);
        
        System.out.println(ins);
        System.out.println(rep);
        System.out.println(del);
        return dp[n][m] = 1+Math.min(Math.min(ins, rep), del);
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return check(word1.length()-1, word2.length()-1, word1, word2, dp);
    }
}