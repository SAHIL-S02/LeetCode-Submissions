class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] a : intervals){
            list.add(a);
        }
        for(int i = 1; i < list.size(); i++){
            if(list.get(i)[0] <= list.get(i-1)[1]){
                list.add(i ,new int[]{list.get(i-1)[0], Math.max(list.get(i-1)[1], list.get(i)[1])});
                list.remove(i-1);
                list.remove(i);
                i--;
            }
        } 
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}