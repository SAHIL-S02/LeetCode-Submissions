class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return n;
        }

        int bits = 31 - Integer.numberOfLeadingZeros(n);
        return 1 << (bits + 1);
    }
}