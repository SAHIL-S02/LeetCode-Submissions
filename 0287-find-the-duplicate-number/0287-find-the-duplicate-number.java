class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        int s2 = nums[0];
        while(s2 != slow){
            s2 = nums[s2];
            slow = nums[slow];
        }
        return slow;
    }
}