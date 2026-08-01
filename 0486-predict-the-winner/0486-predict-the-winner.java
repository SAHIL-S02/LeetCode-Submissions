class Solution {
    public boolean check(int[] nums, int st, int ed, int player1, int player2, boolean flg){
        if(st > ed){
            return player1 >= player2;
        }
        boolean first = false;
        boolean last = false;
        if(flg){
            first = check(nums, st+1, ed, player1+nums[st], player2, false);
            last = check(nums, st, ed-1, player1+nums[ed], player2, false);
            return first || last;
        }else{
            first = check(nums, st+1, ed, player1, player2+nums[st], true);
            last = check(nums, st, ed-1, player1, player2+nums[ed], true);
            return first && last;
        }
        
    }
    public boolean predictTheWinner(int[] nums) {
        return check(nums, 0, nums.length-1, 0, 0, true);
    }
}