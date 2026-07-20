class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        List<List<Integer>> ans = new ArrayList<>();

        // Initialize answer grid
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ans.add(row);
        }

        // Place each element in its new position
        for (int i = 0; i < total; i++) {
            int oldRow = i / n;
            int oldCol = i % n;

            int newIndex = (i + k) % total;
            int newRow = newIndex / n;
            int newCol = newIndex % n;

            ans.get(newRow).set(newCol, grid[oldRow][oldCol]);
        }

        return ans;
    }
}