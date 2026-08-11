class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int hig = nums.length -1;
        while (mid <= hig){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                int temp = nums[mid];
                nums[mid] = nums[hig];
                nums[hig] = temp;
                hig--;
            }
        }
    }
}