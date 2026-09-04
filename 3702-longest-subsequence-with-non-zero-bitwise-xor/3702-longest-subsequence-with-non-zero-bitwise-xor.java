class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int nonZero = 0;

        for (int x : nums) {
            xor ^= x;

            if (x != 0) {
                nonZero++;
            }
        }

        // All elements are zero
        if (nonZero == 0) {
            return 0;
        }

        // Whole array already has non-zero XOR
        if (xor != 0) {
            return n;
        }

        // XOR is zero, so remove one non-zero element
        return n - 1;
    }
}