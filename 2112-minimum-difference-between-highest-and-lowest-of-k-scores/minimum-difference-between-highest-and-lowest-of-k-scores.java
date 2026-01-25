class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int diff = nums[k-1] - nums[0];
        for(int i = 0; i + k <= n; i++) {
            diff = Math.min(diff, nums[i+k-1] - nums[i]);
        }

        return diff;
    }
}