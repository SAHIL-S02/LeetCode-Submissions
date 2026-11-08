class Solution {
    public boolean check(int nums[], int k, int guss){
        int count = 1;
        int temp = 0;
        for(int i : nums){
            if(temp + i > guss){
                count++;
                if(count > k){
                    return false;
                }
                temp = i;
            }else{
                temp += i;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        int res = 0;
        for(int i : nums){
            high += i;
            low = Math.max(low, i);
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(nums, k, mid)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
}