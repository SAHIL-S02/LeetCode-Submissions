class Solution {
    public int pivotIndex(int[] nums) {
        int pre = 0;
        int suff = 0;
        for(int i = 0; i < nums.length; i++){
            suff += nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            pre = pre + nums[i];
            if(pre == suff){
                return i;
            }
            suff -= nums[i];
        }
        return -1;
    }
}