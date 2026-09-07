class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007L;

        // dp = number of distinct non-empty subsequences so far
        long dp = 0;

        // last[c] = dp + 1 value saved after the previous occurrence of c
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';

            long newDp = (2 * dp + 1 - last[idx]) % MOD;

            if (newDp < 0) {
                newDp += MOD;
            }

            last[idx] = (dp + 1) % MOD;
            dp = newDp;
        }

        return (int) dp;
    }
}