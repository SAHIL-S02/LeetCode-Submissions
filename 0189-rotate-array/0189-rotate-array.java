class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> lis = new ArrayList<>();
        for(int a: nums){
            lis.add(a);
        }
        for(int i = 0; i < k; i++){
            int temp = lis.removeLast();
            lis.addFirst(temp);
        }
        for(int i = 0; i < lis.size(); i++){
            nums[i] = lis.get(i);
        }
    }
}