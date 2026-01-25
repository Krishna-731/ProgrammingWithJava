class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            result = Math.max(result, nums[n-i-1] + nums[i]);
        }

        return result;
    }
}