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
    public void check(TreeNode root, ArrayList<Integer> lis){
        if(root == null){
            return;
        }
        lis.add(root.val);
        check(root.left, lis);
        check(root.right, lis);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> lis = new ArrayList<>();
        check(root, lis);
        return lis;
    }
}