class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lis = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            // if(i > 0 && nums[i] == nums[i-1]) continue ;
            int a = i+1;
            int b = nums.length-1;
            while(a < b){
                if(i == a){
                    a++;
                    continue;
                }else if(b == i){
                    b--;
                    continue;
                }
                if(nums[a] + nums[b] == (-1)*(nums[i])){
                    List<Integer> temp = new ArrayList<>();
                    
                    temp.add(nums[i]);
                    temp.add(nums[a]);
                    temp.add(nums[b]);
                    if(hs.contains(temp)){
                        a++;
                        b--;
                        continue;
                    }
                    lis.add(temp);
                    
                    hs.add(temp);
                    a++;
                    b--;
                }else if(nums[a] + nums[b] > (-1)*(nums[i])){
                    b--;
                }
                else if(nums[a] + nums[b] < (-1)*(nums[i])){
                    a++;
                }
            }
        }
        return lis;
    }
}