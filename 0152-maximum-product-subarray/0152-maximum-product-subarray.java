class Solution {
    public int maxProduct(int[] nums) {
        int re = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tempMax = max;

            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(tempMax * nums[i], min * nums[i]));
            re = Math.max(re, max);
        }
        return re;
    }
}