class Solution {
    public int search(int[] nums, int target) {
        int st = 0;
        int end = nums.length-1;
        while(st < end){
            int mid = st + (end - st)/2;
            if(nums[mid] > nums[end]){
                st = mid +1;
            }else{
                end = mid;
            }
        }
        int fst = 0;
        int fend = st-1;
        while(fst <= fend){
            int mid = fst + (fend - fst)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                fst = mid+1;
            }else{
                fend = mid-1;
            }
        }
        fst = st;
        fend = nums.length-1;
        while(fst <= fend){
            int mid = fst + (fend - fst)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                fst = mid+1;
            }else{
                fend = mid-1;
            }
        }
        return -1;
    }
}