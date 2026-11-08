class Solution {
    public int hIndex(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int n = arr.length;
        int res = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= n - mid){
                res = n - mid;
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return res;
    }
}