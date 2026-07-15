class Solution {
    public int check(int n, int[] coins, int amount, int dp[][]){
        if(n < 0){
            return - 1;
        }
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(coins[n] > amount){
            return dp[n][amount] = check(n -1, coins, amount, dp);
        }
        if(dp[n][amount] != -2){
            return dp[n][amount];
        }
        int inC = check(n, coins, amount - coins[n], dp);
        if(inC != -1){
            inC++;
        }
        int exC = check(n-1, coins, amount, dp);
        if(exC == -1 && inC == -1){
            return dp[n][amount] = -1;
        }else if(exC == -1){
            return dp[n][amount] = inC;
        }else if(inC == -1){
            return dp[n][amount] = exC;
        }
        return dp[n][amount] = Math.min(inC, exC);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int arr[]:dp){
            Arrays.fill(arr, -2);
        }
        return check(coins.length - 1, coins, amount, dp);
    }
}