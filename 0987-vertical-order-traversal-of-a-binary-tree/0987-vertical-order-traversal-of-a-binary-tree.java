/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    public void dfs(TreeNode root, int row, int col){
        if(root == null){
            return;
        }
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).add(root.val);
        dfs(root.left, row+1, col-1);
        dfs(root.right, row+1, col+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()){
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> pq : rows.values()){
                while(!pq.isEmpty()){
                    temp.add(pq.remove());
                }
            }
            res.add(temp);
        }
        return res;
    }
}