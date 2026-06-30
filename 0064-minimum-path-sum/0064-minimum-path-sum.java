class Solution {
    public int check(int m, int n, int[][] grid, int memo[][]){
        if(m == 0 && n == 0){
            return grid[m][n];
        }
        if(memo[m][n] != -1){
            return memo[m][n];
        }
        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        if(n != 0){
            left = grid[m][n] + check(m, n -1, grid, memo);
        }
        if(m != 0){
            up = grid[m][n] + check(m - 1, n, grid, memo);
        }
        memo[m][n] = Math.min(left, up);
        return memo[m][n];
    }
    public int minPathSum(int[][] grid) {
        int [][] memo = new int[grid.length][grid[0].length];
        for(int arr[] : memo){
            Arrays.fill(arr, -1);
        }
        return check(grid.length-1, grid[0].length-1, grid, memo);
    }
}