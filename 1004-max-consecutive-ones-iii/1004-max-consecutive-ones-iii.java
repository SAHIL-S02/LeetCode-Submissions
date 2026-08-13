class Solution {
    public int longestOnes(int[] nums, int k) {

        int low = 0;
        int zeros = 0;
        int re = 0;

        for (int high = 0; high < nums.length; high++) {

            if (nums[high] == 0) {
                zeros++;
            }

            while (zeros > k) {

                if (nums[low] == 0) {
                    zeros--;
                }

                low++;
            }

            re = Math.max(re, high - low + 1);
        }

        return re;
    }
}