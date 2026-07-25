class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(n > 0){
            pq.add(n % 10);
            n /= 10;
        }
        int temp1 = pq.remove();
        int temp2 = pq.remove();
        return temp1 * temp2;
    }
}