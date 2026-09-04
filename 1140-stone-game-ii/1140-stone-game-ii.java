class Solution {
    int n;
    int[] suffix;
    Integer[][] dp;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        // suffix[i] = sum of piles from i to n - 1
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new Integer[n][n + 1];

        return solve(0, 1);
    }

    private int solve(int i, int m) {

        // We can take all remaining piles
        if (i + 2 * m >= n) {
            return suffix[i];
        }

        // Already calculated
        if (dp[i][m] != null) {
            return dp[i][m];
        }

        int best = 0;

        // Take x piles, where 1 <= x <= 2 * m
        for (int x = 1; x <= 2 * m; x++) {

            int nextM = Math.max(m, x);

            // Total remaining stones - opponent's best score
            int current = suffix[i] - solve(i + x, nextM);

            best = Math.max(best, current);
        }

        return dp[i][m] = best;
    }
}