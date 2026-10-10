import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {

            if (res.isEmpty() ||
                res.get(res.size() - 1)[1] < interval[0]) {

                res.add(interval);

            } else {
                int[] last = res.get(res.size() - 1);

                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}