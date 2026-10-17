class Solution{
    public int[] dailyTemperatures(int[] nums){
        System.gc();
        int len = nums.length;
        int[] out = new int[len];
        int[] stack = new int[len];
        int top = -1;
        for(int i = 0;i<len;i++){
            while(top>=0 && nums[stack[top]]<nums[i]){
                out[stack[top]] = i - stack[top--];
            }stack[++top] = i;
        }return out;
    }
}