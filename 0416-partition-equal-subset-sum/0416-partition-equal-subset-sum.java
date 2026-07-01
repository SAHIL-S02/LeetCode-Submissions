class Solution {
    public boolean check(int n, int k, int[] nums, Boolean memo[][]){
        if (n == 0) {
            return nums[0] == k;
        }
        if(k == 0){
            return true;
        }
        if(k == nums[n]){
            return true;
        }
        if(memo[n][k] != null){
            return memo[n][k];
        }
        boolean temp1 = false;
        if(nums[n] < k){
            temp1 = check(n -1, k - nums[n], nums, memo);
        }
        boolean temp2 = check(n -1, k, nums, memo);
        memo[n][k] = temp1 || temp2;
        return memo[n][k];
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i : nums){
            total += i;
        }
        if(total %2 != 0){
            return false;
        }
        total /= 2;
        Boolean memo[][] = new Boolean[nums.length +1][total +1];
        return check(nums.length - 1, total, nums, memo);
    }
}