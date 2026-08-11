class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>> lis = new ArrayList<>();
       if(nums.length < 4) return lis;
       Arrays.sort(nums);
       for(int i = 0; i < nums.length; i++){
        if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+ 1; j < nums.length; ){
                int a = j + 1;
                int b = nums.length -1;
                while(a < b){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[a] + (long)nums[b];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        lis.add(temp);
                        a++;
                        b--;
                        while(a < b && nums[a] == nums[a-1]) a++;
                    }else if(sum < target){
                        a++;
                    }else{
                        b--;
                    }
                }
                j++;
                while(j < nums.length && nums[j] == nums[j-1]) j++;
            }
       }
       return lis;
    }
}