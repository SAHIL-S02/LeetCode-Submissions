class Solution {
    public int maximumSum(int[] arr) {
        int oneDelete = 0;
        int noDelete = arr[0];
        int re = arr[0];
        for(int i = 1; i < arr.length; i++){
            int prevNoDelete = noDelete;
            noDelete = Math.max(arr[i], noDelete + arr[i]);
            oneDelete = Math.max(prevNoDelete, oneDelete + arr[i]);
            re = Math.max(re, Math.max(noDelete, oneDelete));
        }
        return re;
    }
}