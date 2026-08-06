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
    int pos = 0;
    public TreeNode check(int st, int ed, int [] inorder, int postorder[]){
        if(st > ed){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pos--]);
        int i = st;
        while(i <= ed){
            if(inorder[i] == root.val){
                break;
            }
            i++;
        }
        TreeNode right = check(i+1, ed, inorder, postorder);
        TreeNode left = check(st, i-1, inorder, postorder);
        
        root.left = left;
        root.right = right;
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pos = inorder.length-1;
        return check(0, inorder.length -1, inorder, postorder);
    }
}