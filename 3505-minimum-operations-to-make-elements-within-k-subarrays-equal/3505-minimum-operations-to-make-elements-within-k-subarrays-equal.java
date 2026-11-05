import java.util.*;

class Solution {

    class FenwickTree {

        int n;
        long[] tree;

        FenwickTree(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        void update(int i, long val) {
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        long query(int i) {
            long sum = 0;

            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }

            return sum;
        }

        int kth(int k) {

            int idx = 0;

            for (int bit = Integer.highestOneBit(n);
                 bit > 0; bit >>= 1) {

                int next = idx + bit;

                if (next <= n && tree[next] < k) {
                    idx = next;
                    k -= (int) tree[next];
                }
            }

            return idx + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Coordinate Compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0;

        for (int v : sorted) {
            if (m == 0 || sorted[m - 1] != v) {
                sorted[m++] = v;
            }
        }

        int[] values = Arrays.copyOf(sorted, m);

        // Map each element to its compressed index
        int[] compressed = new int[n];

        for (int i = 0; i < n; i++) {
            compressed[i] =
                Arrays.binarySearch(values, nums[i]) + 1;
        }

        FenwickTree countBIT = new FenwickTree(m);
        FenwickTree sumBIT = new FenwickTree(m);

        long total = 0;

        // Calculate the first window
        for (int i = 0; i < x; i++) {

            countBIT.update(compressed[i], 1);
            sumBIT.update(compressed[i], nums[i]);

            total += nums[i];
        }

        // Cost of every window
        int windows = n - x + 1;
        long[] cost = new long[windows];

        for (int i = 0; i < windows; i++) {

            // Find median (lower median)
            int medianIndex = countBIT.kth((x + 1) / 2);

            long median = values[medianIndex - 1];

            // Count and sum of elements <= median
            long cnt = countBIT.query(medianIndex);
            long sum = sumBIT.query(medianIndex);

            // Calculate cost
            long left = median * cnt - sum;

            long right =
                (total - sum) - median * (x - cnt);

            cost[i] = left + right;

            // Slide the window
            if (i < windows - 1) {

                int removeIndex = compressed[i];
                int addIndex = compressed[i + x];

                countBIT.update(removeIndex, -1);
                sumBIT.update(removeIndex, -nums[i]);

                countBIT.update(addIndex, 1);
                sumBIT.update(addIndex, nums[i + x]);

                total += (long) nums[i + x] - nums[i];
            }
        }

        // Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {

            dp[i][0] = 0;

            for (int j = 1; j <= k; j++) {

                // Option 1: Skip current element
                dp[i][j] = dp[i - 1][j];

                // Option 2: Select a window of size x
                if (i >= x && dp[i - x][j - 1] != INF) {

                    long take =
                        dp[i - x][j - 1] + cost[i - x];

                    dp[i][j] = Math.min(
                        dp[i][j],
                        take
                    );
                }
            }
        }

        return dp[n][k];
    }
}