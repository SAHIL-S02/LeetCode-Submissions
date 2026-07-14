class Solution {
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[][] dp = new int[max + 1][max + 1];
        dp[0][0] = 1;

        for (int num : nums) {
            int[][] next = new int[max + 1][max + 1];

            for (int g1 = 0; g1 <= max; g1++) {
                for (int g2 = 0; g2 <= max; g2++) {
                    int cur = dp[g1][g2];
                    if (cur == 0) continue;

                    // 1. Skip current number
                    next[g1][g2] = (next[g1][g2] + cur) % MOD;

                    // 2. Put into first subsequence
                    int ng1 = gcd(g1, num);
                    next[ng1][g2] = (next[ng1][g2] + cur) % MOD;

                    // 3. Put into second subsequence
                    int ng2 = gcd(g2, num);
                    next[g1][ng2] = (next[g1][ng2] + cur) % MOD;
                }
            }

            dp = next;
        }

        int ans = 0;
        for (int g = 1; g <= max; g++) {
            ans += dp[g][g];
            if (ans >= MOD) ans -= MOD;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}