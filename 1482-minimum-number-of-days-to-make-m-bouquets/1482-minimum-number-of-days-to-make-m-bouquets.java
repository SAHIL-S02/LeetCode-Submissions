class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int st = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            st = Math.min(st, day);
            end = Math.max(end, day);
        }

        while (st < end) {

            int mid = st + (end - st) / 2;

            if (isPossible(bloomDay, mid, m, k)) {
                end = mid;
            } else {
                st = mid + 1;
            }
        }

        return st;
    }

    public boolean isPossible(int[] bloomDay, int day, int m, int k) {

        int flowers = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }

            } else {
                flowers = 0;
            }

            if (bouquets >= m) {
                return true;
            }
        }

        return false;
    }
}