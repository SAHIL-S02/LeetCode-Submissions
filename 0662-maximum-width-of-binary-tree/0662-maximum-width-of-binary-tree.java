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
class Pa{
    TreeNode node;
    int idx;
    Pa(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pa> q = new LinkedList<>();
        q.add(new Pa(root, 0));
        int max = 0;
        while(!q.isEmpty()){
            int currLevel = q.size();
            int stIdx = q.peekFirst().idx;
            int edIdx = q.peekLast().idx;
            max = Math.max(max, edIdx - stIdx + 1);
            for(int i = 0; i < currLevel; i++){
                Pa curr = q.remove();
                if(curr.node.left != null){
                    q.add(new Pa(curr.node.left, (2 * curr.idx) + 1));
                }
                if(curr.node.right != null){
                    q.add(new Pa(curr.node.right, (2 * curr.idx) + 2));
                }
            }
        }
        return max;
    }
}