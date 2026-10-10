class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int st = newInterval[0];
        int end = newInterval[1];
        while(i < intervals.length && st > intervals[i][1]){
            res.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= end){
            st = Math.min(st, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{st, end});
        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}