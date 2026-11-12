class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int tempIn = 1;
        int maxIn = 1;
        int tempDe = 1;
        int maxDe = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                tempIn++;
            }else{
                maxIn = Math.max(tempIn, maxIn);
                tempIn = 1;
            }
            if(nums[i] < nums[i-1]){
                tempDe++;
            }else{
                maxDe = Math.max(tempDe, maxDe);
                tempDe = 1;
            }
        }
        maxIn = Math.max(tempIn, maxIn);
        maxDe = Math.max(tempDe, maxDe);
        System.out.println("DE"+" " + maxDe);
        return Math.max(maxIn, maxDe);
    }
}