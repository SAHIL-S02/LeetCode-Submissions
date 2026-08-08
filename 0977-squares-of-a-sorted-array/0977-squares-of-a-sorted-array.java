class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int res[] = new int[nums.length];
        while(i < j){
            if((nums[i]*nums[i]) > (nums[j] * nums[j])){
                res[j-i] = nums[i]*nums[i];
                i++;
            }else{
                res[j-i] = nums[j]*nums[j];
                j--;
            }
        }
        res[0] = nums[i]*nums[i];
        return res;
    }
}