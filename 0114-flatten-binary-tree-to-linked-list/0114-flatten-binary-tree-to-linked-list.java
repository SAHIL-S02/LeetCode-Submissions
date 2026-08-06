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
    ArrayList<Integer> lis = new ArrayList<>();
    public void check(TreeNode root){
        if(root == null){
            return;
        }
        lis.add(root.val);
        check(root.left);
        check(root.right);
    }
    public void con(TreeNode root, int n){
        if(n == lis.size()){
            return;
        }
        root.val = lis.get(n);
        if(n +1 < lis.size()){
            root.right = new TreeNode();
            root.left = null;
            con(root.right, n+1);
        }
    }
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        check(root);
        con(root, 0);
    }
}