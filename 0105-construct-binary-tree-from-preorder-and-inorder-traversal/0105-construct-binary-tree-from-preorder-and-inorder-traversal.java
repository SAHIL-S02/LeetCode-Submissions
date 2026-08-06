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
    int pre = 0;
    public TreeNode check(int st, int ed, int[] inorder, int[] preorder){
        if(st > ed){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre++]);
        int i = st;
        while(i <= ed){
            if(inorder[i] == root.val){
                break;
            }
            i++;
        }
        TreeNode left = check(st, i-1, inorder, preorder);
        TreeNode right = check(i+1, ed, inorder, preorder);
        root.left = left;
        root.right = right;
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return check(0, preorder.length-1, inorder, preorder);
    }
}