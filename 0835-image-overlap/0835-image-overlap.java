class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        // Store coordinates of all 1s
        java.util.List<int[]> ones1 = new java.util.ArrayList<>();
        java.util.List<int[]> ones2 = new java.util.ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    ones1.add(new int[]{r, c});
                }

                if (img2[r][c] == 1) {
                    ones2.add(new int[]{r, c});
                }
            }
        }

        // translation -> number of overlapping 1s
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        int ans = 0;

        for (int[] a : ones1) {
            for (int[] b : ones2) {
                int dr = b[0] - a[0];
                int dc = b[1] - a[1];

                String key = dr + "," + dc;

                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}