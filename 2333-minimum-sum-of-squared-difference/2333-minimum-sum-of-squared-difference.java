class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        int[] diff = new int[n];
        int maxDiff = 0;
        long totalDiff = 0;

        // Step 1: Calculate absolute differences
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);

            totalDiff += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // Both operation budgets can be combined
        long k = (long) k1 + k2;

        // If we can eliminate every difference, the answer is 0
        if (totalDiff <= k) {
            return 0;
        }

        // Step 2: Binary search for the minimum achievable maximum difference
        int low = 0;
        int high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;

            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // Step 3: Reduce every difference greater than low to low
        for (int i = 0; i < n; i++) {
            if (diff[i] > low) {
                k -= diff[i] - low;
                diff[i] = low;
            }
        }

        // Step 4: Use remaining operations to reduce differences by 1
        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] == low) {
                diff[i]--;
                k--;
            }
        }

        // Step 5: Calculate the minimum sum of squared differences
        long ans = 0;

        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}