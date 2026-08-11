class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int re = Integer.MAX_VALUE;
        int sum = 0;
        int low = 0;
        for(int high = 0; high < nums.length; high++){
            sum += nums[high];
            while(sum >= target){
                re = Math.min(re, high-low+1);
                sum -= nums[low];
                low++;
            }
        }
        return re == Integer.MAX_VALUE? 0 : re;
    }
}