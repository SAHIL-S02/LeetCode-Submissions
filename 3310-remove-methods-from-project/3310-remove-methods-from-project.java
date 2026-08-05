class Solution {

    public void dfs(int node, List<Integer>[] graph, boolean[] vis) {
        vis[node] = true;

        for (int next : graph[node]) {
            if (!vis[next]) {
                dfs(next, graph, vis);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : invocations)
            graph[e[0]].add(e[1]);

        boolean[] vis = new boolean[n];

        // Mark all suspicious methods
        dfs(k, graph, vis);

        // Check if any outside method calls a suspicious one
        for (int[] e : invocations) {
            if (!vis[e[0]] && vis[e[1]]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        // Return remaining methods
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i])
                ans.add(i);
        }

        return ans;
    }
}