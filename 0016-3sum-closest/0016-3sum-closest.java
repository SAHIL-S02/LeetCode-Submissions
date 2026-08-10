class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE;
        int sumDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int a = i+1;
            int b = nums.length -1;
            while(a < b){
                if(nums[a] + nums[b] == target - nums[i]){
                    return nums[i] + nums[a] + nums[b];
                }else if(nums[a] + nums[b] < target - nums[i]){
                    int temp = 0;
                    if(target > nums[i] + nums[a] + nums[b]){
                        temp = target - (nums[i] + nums[a] + nums[b]);
                    }else{
                        temp = (nums[i] + nums[a] + nums[b]) - target;
                    }
                    if(sumDiff > temp){
                        sum = nums[i] + nums[a] + nums[b];
                        sumDiff = temp;
                    }
                    a++;
                }else if(nums[a] + nums[b] > target - nums[i]){
                    int temp = 0;
                    if(target > nums[i] + nums[a] + nums[b]){
                        temp = target - (nums[i] + nums[a] + nums[b]);
                    }else{
                        temp = (nums[i] + nums[a] + nums[b]) - target;
                    }
                    if(sumDiff > temp){
                        sum = nums[i] + nums[a] + nums[b];
                        sumDiff = temp;
                    }
                    b--;
                }
            }
        }
        return sum;
    }
}