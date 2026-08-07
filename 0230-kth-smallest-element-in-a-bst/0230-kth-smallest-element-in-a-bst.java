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
    public void check(TreeNode root, PriorityQueue<Integer> pq){
        if(root == null){
            return;
        }
        pq.add(root.val);
        check(root.left, pq);
        check(root.right, pq);
    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        check(root, pq);
        while(k > 1){
            pq.remove();
            k--;
        }
        return pq.remove();
    }
}