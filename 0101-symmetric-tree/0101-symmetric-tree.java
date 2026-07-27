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
    public void dfsLeft(TreeNode root, ArrayList<Integer> lis){
        if(root == null){
            lis.add(null);
            return;
        }
        lis.add(root.val);
        dfsLeft(root.left, lis);
        dfsLeft(root.right, lis);
    }
    public void dfsRight(TreeNode root, ArrayList<Integer> lis){
        if(root == null){
            lis.add(null);
            return;
        }
        lis.add(root.val);
        dfsRight(root.right, lis);
        dfsRight(root.left, lis);
        
    }
    public boolean isSymmetric(TreeNode root) {
        ArrayList left = new ArrayList<>();
        ArrayList right = new ArrayList<>();
        dfsLeft(root.left, left);
        dfsRight(root.right, right);
        return left.equals(right);
    }
}