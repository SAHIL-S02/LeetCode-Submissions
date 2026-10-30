class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = first(nums, target);
        int l = last(nums, target);
        return new int[]{f, l};
    }
    public int first(int[] nums, int x){
        int st = 0;
        int end = nums.length;
        int re = -1;
        while(st < end){
            int mid = st + (end - st)/2;
            if(nums[mid] == x){
                re = mid;
                end = mid;
            }else if(nums[mid] < x){
                st = mid +1;
            }else{
                end = mid;
            }
        }
        return re;
    }public int last(int[] nums, int x){
        int st = 0;
        int end = nums.length;
        int re = -1;
        while(st < end){
            int mid = st + (end - st)/2;
            if(nums[mid] == x){
                re = mid;
                st = mid + 1;
            }else if(nums[mid] < x){
                st = mid +1;
            }else{
                end = mid;
            }
        }
        return re;
    }
}