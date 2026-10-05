class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] re = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        int i = 0;
        int j = nums.length-1;
        int counter = nums.length-1;
        while(i < j){
            if(nums[i] > nums[j]){
                re[counter--] = nums[i++];
            }else{
                re[counter--] = nums[j--];
            }
        }
        re[counter] = nums[i] < nums[j]? nums[i] : nums[j];
        return re;
    }
}