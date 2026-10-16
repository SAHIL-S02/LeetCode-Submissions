import java.util.Arrays;

class Solution {

    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        int[] lastSeen = new int[100001];
        Arrays.fill(lastSeen, -1);

        SegmentTree tree = new SegmentTree(n);

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int prev = lastSeen[nums[i]];

            // Increase distinct counts for valid starting positions.
            tree.update(prev + 1, i);

            // Add squared distinct counts of subarrays ending at i.
            ans = (ans + tree.getSquareSum()) % MOD;

            // Store the latest occurrence.
            lastSeen[nums[i]] = i;
        }

        return (int) ans;
    }

    static class SegmentTree {

        int n;
        long[] sum;
        long[] squareSum;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;

            sum = new long[4 * n];
            squareSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        // Add 1 to every element in the range [l, r].
        void update(int l, int r) {
            update(1, 0, n - 1, l, r);
        }

        private void update(int node, int start, int end,
                            int l, int r) {

            if (start > r || end < l) {
                return;
            }

            if (l <= start && end <= r) {
                apply(node, start, end, 1);
                return;
            }

            push(node, start, end);

            int mid = start + (end - start) / 2;

            update(node * 2, start, mid, l, r);
            update(node * 2 + 1, mid + 1, end, l, r);

            sum[node] =
                (sum[node * 2] + sum[node * 2 + 1]) % MOD;

            squareSum[node] =
                (squareSum[node * 2] + squareSum[node * 2 + 1])
                % MOD;
        }

        // Apply a range addition to a segment.
        private void apply(int node, int start, int end,
                           long delta) {

            long len = end - start + 1L;
            long oldSum = sum[node];
            long d = delta % MOD;

            /*
             * (x + d)^2 = x^2 + 2*x*d + d^2
             *
             * Sum of squares after addition:
             * oldSquareSum + 2*d*oldSum + len*d*d
             */
            squareSum[node] =
                (squareSum[node]
                + (2L * d % MOD) * oldSum % MOD
                + (len % MOD) * d % MOD * d % MOD)
                % MOD;

            // Update the ordinary sum.
            sum[node] =
                (oldSum + (len % MOD) * d % MOD) % MOD;

            lazy[node] += delta;
        }

        // Push pending updates to children.
        private void push(int node, int start, int end) {

            if (lazy[node] == 0 || start == end) {
                return;
            }

            int mid = start + (end - start) / 2;
            long delta = lazy[node];

            apply(node * 2, start, mid, delta);

            apply(node * 2 + 1, mid + 1, end, delta);

            lazy[node] = 0;
        }

        // Return the sum of squared distinct counts.
        long getSquareSum() {
            return squareSum[1];
        }
    }
}