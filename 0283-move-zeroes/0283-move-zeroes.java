class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> lis = new ArrayList<>();
        for(int i : nums){
            lis.add(i);
        }
        System.out.print(lis);
        int n = lis.size();
        for(int i = 0; i < n; i++){
            if(lis.get(i) == 0){
                lis.addLast(0);
                lis.set(i, null);
            }
            
        }
        
        for(int i = 0; i < lis.size(); i++){
            if(lis.get(i) == null){
                lis.remove(i);
                i--;
            }
        }
        System.out.print(lis);
        for(int i = 0; i < lis.size(); i++){
            nums[i] = lis.get(i);
        }
    }
}