class Solution {
    public int[] twoSum(int[] nums, int target) {
        int temp =0;
        for (int i = 0; i < nums.length; i++){
            temp = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                int data = temp + nums[j];
                if(data == target){
                    return new int[]{i, j};
                };
            };
        };
        return new int[]{};
    }
}