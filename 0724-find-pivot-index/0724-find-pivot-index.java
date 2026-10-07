class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = nums[0];
        suffix[suffix.length - 1] = nums[nums.length -1];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
            suffix[suffix.length -1 - i] = suffix[suffix.length - 1 - (i - 1)] + nums[nums.length - 1 - i];
        }
        for(int i = 0; i < prefix.length; i++){
            if(prefix[i] == suffix[i]){
                return i;
            }
        }
        return -1;
    }
}