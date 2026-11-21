import java.util.*;

class Solution {

    int[] ans;
    int[] newParent;
    int[] last;

    List<Integer>[] children;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        ans = new int[n];
        newParent = parent.clone();
        last = new int[26];

        Arrays.fill(last, -1);

        children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        // Find the nearest ancestor with the same character
        dfs1(0, s);

        // Build modified tree
        Arrays.fill(children, null);

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[newParent[i]].add(i);
        }

        // Calculate subtree sizes
        dfs2(0);

        return ans;
    }

    void dfs1(int node, String s) {

        int ch = s.charAt(node) - 'a';

        int prev = last[ch];

        if (prev != -1) {
            newParent[node] = prev;
        }

        last[ch] = node;

        for (int child : children[node]) {
            dfs1(child, s);
        }

        // Backtrack
        last[ch] = prev;
    }

    int dfs2(int node) {

        int size = 1;

        for (int child : children[node]) {
            size += dfs2(child);
        }

        ans[node] = size;

        return size;
    }
}