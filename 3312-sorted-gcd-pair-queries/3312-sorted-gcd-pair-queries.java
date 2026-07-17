class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        // divisibleCount[d] = how many numbers are divisible by d
        int[] divisibleCount = new int[max + 1];

        for (int d = 1; d <= max; d++) {
            for (int multiple = d; multiple <= max; multiple += d) {
                divisibleCount[d] += freq[multiple];
            }
        }

        // gcdPairs[g] = number of pairs whose gcd is exactly g
        long[] gcdPairs = new long[max + 1];

        for (int g = max; g >= 1; g--) {
            long cnt = divisibleCount[g];
            gcdPairs[g] = cnt * (cnt - 1) / 2;

            for (int multiple = g + g; multiple <= max; multiple += g) {
                gcdPairs[g] -= gcdPairs[multiple];
            }
        }

        // prefix[g] = number of pairs with gcd <= g
        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + gcdPairs[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1; // 0-indexed query

            int l = 1, r = max;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (prefix[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}