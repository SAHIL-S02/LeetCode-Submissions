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
    int max = Integer.MIN_VALUE;
    public int check(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = Math.max(0, check(root.left));
        int r = Math.max(0, check(root.right));
        max = Math.max(max, l + r + root.val);
        return root.val + Math.max(l , r);
    }
    public int maxPathSum(TreeNode root) {
        check(root);
        return max;
    }
}