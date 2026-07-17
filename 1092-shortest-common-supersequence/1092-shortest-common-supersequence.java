class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Step 1: Build LCS DP table
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Reconstruct SCS
        StringBuilder ans = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {

            // Same character -> include once
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            }

            // Move in direction of larger LCS
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(str1.charAt(i - 1));
                i--;
            } else {
                ans.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Append remaining characters
        while (i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }

        // Built backwards
        return ans.reverse().toString();
    }
}