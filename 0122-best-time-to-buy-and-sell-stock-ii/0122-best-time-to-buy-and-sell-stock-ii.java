class Solution {
    public int check(int n, int[] pri, int buy, int memo[][]){
        if(n == pri.length){
            return 0;
        }
        if(memo[n][buy] != -1){
            return memo[n][buy];
        }
        if(buy == 1){
            int inc = -pri[n] + check(n+1, pri, 0, memo);
            int exc = check(n+1, pri, 1, memo);
            return memo[n][buy] = Math.max(inc, exc);
        }else{
            int inc = pri[n] +check(n+1, pri, 1, memo);
            int exc = check(n+1, pri, 0, memo);
            return memo[n][buy] = Math.max(inc, exc);
        }
    }
    public int maxProfit(int[] prices) {
        int memo[][] = new int[prices.length][2];
        for(int arr[]:memo){
            Arrays.fill(arr, -1);
        }
        return check(0, prices, 1, memo);
    }
}