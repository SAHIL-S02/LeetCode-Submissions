class Solution {
    public boolean check(int[] arr, int days, int guss){
        int counter = 1;
        int temp = 0;
        for(int i : arr){
            if(temp + i > guss){
                counter++;
                if(counter > days){
                    return false;
                }
                temp = i;
            }else{
                temp += i;
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        int res = 0;
        for(int i : weights){
            high += i;
            low = Math.max(low, i);
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(weights, days, mid)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
}