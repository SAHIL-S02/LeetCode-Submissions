import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        ArrayList<Integer> list = new ArrayList<>();

        int st = 0;
        int end = nums.length;

        // Find the first index where nums[i] >= target.
        while (st < end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }

        // Collect all indices containing target.
        for (int i = st; i < nums.length && nums[i] == target; i++) {
            list.add(i);
        }

        return list;
    }
}