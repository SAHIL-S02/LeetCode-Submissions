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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> lis = new ArrayList<>();
        if (root == null) return lis;
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr != null){
                temp.add(curr.val);
            }else{
                if(q.isEmpty()){
                    lis.add(temp);
                    break;
                }
                if(temp.isEmpty()){
                    continue;
                }
                lis.add(temp);
                temp = new ArrayList<>();
                q.add(null);
                continue;
            }
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        return lis;
    }
}