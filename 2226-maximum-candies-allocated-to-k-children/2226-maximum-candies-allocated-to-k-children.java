class Solution {
    public boolean check(int[] arr, long k, int guss){
        long child = 0;
        for(int i : arr){
            child += i/guss;
            if(child >= k){
                return true;
            }
        }
        if(child >= k){
            return true;
        }else{
            return false;
        }
    }
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int res =0;
        for(int i : candies){
            high = Math.max(high, i);
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(candies, k, mid)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }
}