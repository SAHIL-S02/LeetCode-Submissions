class Solution {
    public boolean speed(int[] piles, int h, int speed){
        int re = 0;
        for(int i : piles){
            if(i % speed != 0){
                re += (i/speed)+1;
            }else{
                re += i/speed;
            }
        }
        return re <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int res = -1;
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i : piles){
            high = Math.max(high, i);
        }
        while(low < high){
            int mid = low + (high - low)/2;
            if(speed(piles, h, mid)){
                res = mid;
                high = mid;
            }else{
                low = mid +1;
            }
        }
        return low;
    }
}