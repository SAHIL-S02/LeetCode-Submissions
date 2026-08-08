class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(hm.containsKey(temp)){
                return new int[]{hm.get(temp), i};
            }
            hm.put(nums[i], i);
        }
        return res;
    }
}