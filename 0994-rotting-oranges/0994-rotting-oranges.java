class Solution {
    static class Graph{
        int i;
        int j;
        int time;
        Graph (int i, int j, int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Queue<Graph> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Graph(i, j, 0));
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
            Graph curr = q.remove();
            ans = Math.max(ans, curr.time);
            int i = curr.i;
            int j = curr.j;
            int time = curr.time;
            if(i -1 > -1 && !visited[i -1][j] && grid[i-1][j] == 1){
                visited[i -1][j] = true;
                q.add(new Graph(i -1, j, time +1));
            }
            if(j + 1 < grid[0].length && !visited[i][j + 1] && grid[i][j+1] == 1){
                visited[i][j + 1] = true;
                q.add(new Graph(i , j + 1, time +1));
            }
            if(j - 1 > -1 && !visited[i][j - 1] && grid[i][j-1] == 1){
                visited[i][j-1] = true;
                q.add(new Graph(i , j - 1, time +1));
            }
            if(i + 1 < grid.length && !visited[i + 1][j] && grid[i + 1][j] == 1){
                visited[i + 1][j] = true;
                q.add(new Graph(i + 1, j, time +1));
            }
            
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    return -1;
                }
            }
        }
        return ans;
    }
}