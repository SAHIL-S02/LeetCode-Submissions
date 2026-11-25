import java.util.*;

class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;

    private static final long BASE1 = 100_019L;
    private static final long BASE2 = 100_043L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int left = 1;
        int right = n;
        int ans = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (hasUnique(nums, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean hasUnique(int[] nums, int len) {
        int n = nums.length;

        long pow1 = 1;
        long pow2 = 1;

        for (int i = 0; i < len; i++) {
            pow1 = (pow1 * BASE1) % MOD1;
            pow2 = (pow2 * BASE2) % MOD2;
        }

        long hash1 = 0;
        long hash2 = 0;

        Map<Long, Integer> map = new HashMap<>();

        // Calculate the first window hash
        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * BASE1 + nums[i]) % MOD1;
            hash2 = (hash2 * BASE2 + nums[i]) % MOD2;
        }

        long key = hash1 * MOD2 + hash2;
        map.put(key, 1);

        // Sliding window with rolling hash
        for (int i = len; i < n; i++) {

            hash1 = (hash1 * BASE1 + nums[i]
                    - (pow1 * nums[i - len]) % MOD1
                    + MOD1) % MOD1;

            hash2 = (hash2 * BASE2 + nums[i]
                    - (pow2 * nums[i - len]) % MOD2
                    + MOD2) % MOD2;

            key = hash1 * MOD2 + hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check whether any subarray occurs exactly once
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}