class Solution {
    public int longestSubsequence(int[] nums) {
        int total = 0;
        int n = nums.length;
        int zero = 0;

        for(int num : nums) {
            if (num == 0) {
                zero++;
            }
            total ^= num;
        }

        if (zero == n) {
            return 0;
        }
        return total == 0 ? n-1 : n;
    }
}