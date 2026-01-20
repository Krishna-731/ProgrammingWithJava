class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int currNum = nums.get(i);
            int x = -1;
            int d = 1;
            while ((currNum & d) != 0) {
                x = currNum - d;
                d = d << 1;
            }
            ans[i] = x;
        }
        return ans;
    }
}