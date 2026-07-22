class Solution {

    int[][][] dp;

    public int solve(int idx, int buy, int cap, int[] prices) {

        if (idx == prices.length || cap == 0)
            return 0;

        if (dp[idx][buy][cap] != -1)
            return dp[idx][buy][cap];

        if (buy == 1) {

            int take = -prices[idx] + solve(idx + 1, 0, cap, prices);
            int skip = solve(idx + 1, 1, cap, prices);

            return dp[idx][buy][cap] = Math.max(take, skip);

        } else {

            int sell = prices[idx] + solve(idx + 1, 1, cap - 1, prices);
            int hold = solve(idx + 1, 0, cap, prices);

            return dp[idx][buy][cap] = Math.max(sell, hold);
        }
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;

        dp = new int[n][2][3];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < 2; j++)
                java.util.Arrays.fill(dp[i][j], -1);

        return solve(0, 1, 2, prices);
    }
}