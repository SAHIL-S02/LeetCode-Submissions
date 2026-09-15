class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];

        // dp[i] = maximum palindromes using s[0 .. i-1]
        for (int i = 0; i < n; i++) {
            // Skip s[i]
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // Odd-length palindromes centered at i
            int l = i, r = i;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
                }

                l--;
                r++;
            }

            // Even-length palindromes centered between i and i+1
            l = i;
            r = i + 1;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
                }

                l--;
                r++;
            }
        }

        return dp[n];
    }
}