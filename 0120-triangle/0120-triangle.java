class Solution {
    public int check(int n, int m, List<List<Integer>> triangle, Integer memo[][]){
        if(n == triangle.size() -1){
            return triangle.get(n).get(m);
        }
        if(memo[n][m] != null){
            return memo[n][m];
        }
        memo[n][m] = triangle.get(n).get(m) + Math.min(check(n + 1, m, triangle, memo), check(n +1, m+1, triangle, memo));
        return memo[n][m];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer memo[][] = new Integer [triangle.size()][triangle.get(triangle.size()-1).size()];
        return check(0, 0, triangle, memo);
    }
}