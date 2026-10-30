class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int st = 0;
        int end = arr.length-1;
        int peak = Integer.MIN_VALUE;
        while(st < end){
            int mid = st + (end - st)/ 2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                st =  mid+1;
            }
        }
        return st;
    }
}