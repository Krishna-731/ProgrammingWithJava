class Solution {
    public int minimumCost(int[] nums) {
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;

        int n = nums.length;

        for(int i = 1; i < n; i++) {
            if (nums[i] < n1) {
                n2 = n1;
                n1 = nums[i];
            }
            else if(nums[i] < n2) {
                n2 = nums[i];
            }
        }

        return nums[0] + n1 + n2;
    }
}