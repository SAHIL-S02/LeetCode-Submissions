class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int re = Math.abs(nums[0]);
        for(int i = 1; i < nums.length; i++){
            int prevMax = max;
            max = Math.max(nums[i], Math.max(max + nums[i], min + nums[i]));
            min = Math.min(nums[i], Math.min(prevMax + nums[i], min + nums[i]));
            re = Math.max(re, Math.max(Math.abs(max), Math.abs(min)));
        }
        return re;
    }
}