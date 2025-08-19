class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int zeroCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 ) {
                zeroCount = 0;
            }
            else {
                zeroCount++;
                ans += zeroCount;
            }
        }

        return ans;
    }
}