import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        int total = 0;
        for (int x : nums) total += x;

        // leftSums[k] -> all subset sums choosing k elements from left half
        // rightSums[k] -> all subset sums choosing k elements from right half
        List<Integer>[] leftSums = new ArrayList[n + 1];
        List<Integer>[] rightSums = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        int limit = 1 << n;

        // Generate subset sums
        for (int mask = 0; mask < limit; mask++) {
            int leftSum = 0;
            int rightSum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    count++;
                    leftSum += left[i];
                    rightSum += right[i];
                }
            }

            leftSums[count].add(leftSum);
            rightSums[count].add(rightSum);
        }

        // Sort every right list
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }

        int ans = Integer.MAX_VALUE;

        // Try every possible split
        for (int leftCount = 0; leftCount <= n; leftCount++) {

            int rightCount = n - leftCount;

            List<Integer> leftList = leftSums[leftCount];
            List<Integer> rightList = rightSums[rightCount];

            for (int leftSum : leftList) {

                double target = total / 2.0 - leftSum;

                int idx = Collections.binarySearch(rightList, (int)Math.ceil(target));

                if (idx < 0)
                    idx = -idx - 1;

                // Check insertion point
                if (idx < rightList.size()) {
                    int sum = leftSum + rightList.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }

                // Check previous element
                if (idx > 0) {
                    int sum = leftSum + rightList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return ans;
    }
}