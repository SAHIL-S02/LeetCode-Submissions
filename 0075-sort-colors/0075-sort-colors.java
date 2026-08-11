class Solution {
    public void sortColors(int[] nums) {
        int[] map = new int[3];
        for(int i : nums){
            map[i]++;
        }
        int a = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < map[i]; j++){
                nums[a++] = i; 
            }
        }
    }
}