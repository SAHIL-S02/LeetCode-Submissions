/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        hm.put(root, null);
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr= q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }else{
                if(curr.left != null){
                    q.add(curr.left);
                    hm.put(curr.left, curr);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    hm.put(curr.right, curr);
                }
            }
        }
        q = new LinkedList<>();
        q.add(target);
        int t = k;
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);
        while(!q.isEmpty()){
            if(k == 0){
                    break;
            }
            int size = q.size();
            while(size-- > 0){

                TreeNode curr = q.poll();

                TreeNode par = hm.get(curr);

                if(par != null && visited.add(par))
                    q.offer(par);

                if(curr.left != null && visited.add(curr.left))
                    q.offer(curr.left);

                if(curr.right != null && visited.add(curr.right))
                    q.offer(curr.right);
            }

            k--;
        }
        System.out.print(q);
        for(TreeNode temp : q){
            if(temp != null){
                ans.add(temp.val);
            }
        }
        return ans; 
    }
}