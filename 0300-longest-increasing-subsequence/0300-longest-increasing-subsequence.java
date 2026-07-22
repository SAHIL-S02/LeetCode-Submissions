class Solution {
    public int check(int n, int[] nums, int prevIdx, int dp[][]){
        if(n == nums.length){
            return 0;
        }
        if(dp[n][prevIdx+1] != -1){
            return dp[n][prevIdx+1];
        }
        if(prevIdx == -1){
            int exc = check(n + 1, nums, prevIdx, dp);
            int inc = 1 + check(n + 1, nums, n, dp);
            return dp[n][prevIdx+1] = Math.max(inc, exc);
        }
        if(dp[n][prevIdx+1] != -1){
            return dp[n][prevIdx+1];
        }
        if(nums[n] > nums[prevIdx]){
            int exc = check(n + 1, nums, prevIdx, dp);
            int inc = 1 + check(n + 1, nums, n, dp);
            return dp[n][prevIdx+1] = Math.max(inc, exc);
        }
        else{
            return dp[n][prevIdx+1] = check(n+1, nums, prevIdx, dp);
        }
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return check(0, nums, -1, dp);
    }
}