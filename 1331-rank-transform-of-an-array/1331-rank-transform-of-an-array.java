class Node implements Comparable<Node>{
    int val;
    int idx;
    public Node(int val, int idx){
        this.idx = idx;
        this.val = val;
    }
    @Override
    public int compareTo(Node p){
        return this.val - p.val;
    }
}
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int res[] = new int[arr.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            pq.add(new Node(arr[i], i));
        }
        int prev = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            Node curr = pq.remove();
            if(i == 0){
                j++;
                res[curr.idx] = j;
                prev = curr.val;
                continue;
            }
            if(prev == curr.val){
                res[curr.idx] = j;
            }else{
                j++;
                res[curr.idx] = j;
            }
            prev = curr.val;
        }
        return res;
    }
}