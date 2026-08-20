class Solution {
    public int pivotIndex(int[] nums) {
        int prefixSum[] = new int[nums.length];
        int suffixSum[] = new int[nums.length];
        prefixSum[0] = nums[0];
        suffixSum[suffixSum.length - 1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1]+ nums[i];
            suffixSum[(suffixSum.length - 1) - i] = suffixSum[suffixSum.length - i] + nums[nums.length - 1 - i];
        }
        for(int i = 0; i < prefixSum.length; i++){
            if(prefixSum[i] - nums[i] ==
                suffixSum[i] - nums[i]){
                return i;
            }
        }
        return -1;
    }
}