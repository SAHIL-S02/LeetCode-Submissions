class Solution {
    public int check(int m, int n, int memo[][]){
        if(m == 0 && n == 0){
            
            return 1;
        }
        int count1 = 0;
        int count2 = 0;
        if(memo[m][n] != -1){
            return memo[m][n];
        }
        if(m != 0){
            count1 = check(m -1, n, memo);
        }
        if(n != 0){
           count2 = check(m, n - 1, memo);
        }
        memo[m][n] = count1 + count2;
        return memo[m][n];
    }
    public int uniquePaths(int m, int n) {
        int memo[][] = new int [m][n];
        for(int arr[] : memo){
            Arrays.fill(arr, -1);
        }
        return check(m-1, n-1, memo);
    }
}