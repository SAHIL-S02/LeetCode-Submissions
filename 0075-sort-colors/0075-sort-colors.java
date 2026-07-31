class Solution {
    public void sortColors(int[] nums) {
        int map[] = new int[3];
        for(int a : nums){
            map[a]++;
        }
        int j = 0;
        for(int i = 0; i < map.length; i++){
            for(int k = 0; k < map[i]; k++){
                nums[j] = i;
                j++;
            }
        }
    }
}