class Solution {
    public int check(int n, int[] nums, int target, int dp[][], int off){
        if(n < 0){
            if(target == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if (target < -off || target > off) {
            return 0;
        }
        if(dp[n][target+off] != -1){
            return dp[n][target+off];
        }
        int p = check(n -1, nums, target-nums[n], dp, off);
        
        
        int m = check(n-1, nums, target+nums[n], dp, off);
        
        return dp[n][target+off] = p+m;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int a : nums){
            sum+=a;
        }
        int[][] dp = new int[nums.length][2*sum + 1];
        for(int arr[]:dp){
            Arrays.fill(arr, -1);
        }

        return check(nums.length -1, nums, target, dp, sum);
    }
}