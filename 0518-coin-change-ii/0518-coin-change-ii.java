class Solution {
    public int check(int n, int[] coins, int amount, int[][] memo){
        if(n < 0){
            return 0;
        }
        if(memo[n][amount] != -1){
            return memo[n][amount];
        }
        if(amount == 0){
            return 1;
        }
        if(coins[n] > amount){
            return memo[n][amount] = check(n-1, coins, amount, memo);
        }
        int inc = check(n, coins, amount - coins[n], memo);
        // if(inc != 0){
        //     inc++;
        // }
        int exc = check(n-1, coins, amount, memo);
        return memo[n][amount] = inc+exc;
    }
    public int change(int amount, int[] coins) {
        int memo[][] = new int[coins.length][amount+1];
        for(int arr[]:memo){
            Arrays.fill(arr, -1);
        }
        return check(coins.length - 1, coins, amount, memo);
    }
}