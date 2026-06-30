class Solution {
    public int check(int m, int n, int [][] obs, int memo[][]){
        if(obs[0][0] == 1){
            return 0;
        }
        if(obs.length == 1 && obs[0][0] == 1){
            return 0;
        }
        if(m == 0 && n == 0){
            
            return 1;
        }
        if(obs[m][n] == 1){
            return 0;
        }
        int count1 = 0;
        int count2 = 0;
        if(memo[m][n] != -1){
            return memo[m][n];
        }
        if(m != 0){
            count1 = check(m -1, n, obs, memo);
        }
        if(n != 0){
           count2 = check(m, n - 1, obs, memo);
        }
        memo[m][n] = count1 + count2;
        return memo[m][n];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int memo[][] = new int [m][n];
        for(int arr[] : memo){
            Arrays.fill(arr, -1);
        }
        return check(m-1, n-1, obstacleGrid, memo);
    }
}