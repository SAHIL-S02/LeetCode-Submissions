import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // Prefix sum of original digits
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) - '0');
        }

        // Store non-zero positions and digits
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                pos.add(i);
                digits.add(d);
            }
        }

        int m = digits.size();

        // powers of 10
        long[] pow = new long[m + 1];
        pow[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
        }

        // prefix hash/value of non-zero digits
        long[] pref = new long[m + 1];
        for (int i = 0; i < m; i++) {
            pref[i + 1] = (pref[i] * 10 + digits.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int sum = prefixSum[r + 1] - prefixSum[l];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r);

            if (left == right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left;

            long num = (pref[right] - pref[left] * pow[len]) % MOD;
            if (num < 0) num += MOD;

            ans[i] = (int) (num * sum % MOD);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}