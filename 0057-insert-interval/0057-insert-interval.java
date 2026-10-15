class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int st = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        while(i < intervals.length && st > intervals[i][1]){
            list.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && end >= intervals[i][0]){
            st = Math.min(st, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        list.add(new int[]{st, end});
        while(i < intervals.length){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[0][]);
    }
}