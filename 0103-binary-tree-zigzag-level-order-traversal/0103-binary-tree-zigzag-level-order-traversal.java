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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean z = true;
        List<List<Integer>> lis = new ArrayList<>();
        if(root == null){
            return lis;
        }
        LinkedList<Integer> temp = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    lis.add(temp);
                    break;
                }
                lis.add(temp);
                temp = new LinkedList<>();
                z = !z;
                q.add(null);
            }else{
                if(z){
                    temp.addLast(curr.val);
                }else{
                    temp.addFirst(curr.val);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return lis;
    }
}