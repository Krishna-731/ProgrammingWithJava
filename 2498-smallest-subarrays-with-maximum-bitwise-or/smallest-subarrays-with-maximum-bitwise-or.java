class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] near = new int[32];
        Arrays.fill(near, -1);
        
        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j < 32; j++) {
                if ( (nums[i] & (1 << j)) != 0) {
                    near[j] = i;
                }
            }

            int last = i;
            for(int j = 0; j < 32; j++) {
                if (near[j] != -1) {
                    last = Math.max(last, near[j]);
                }
            }

            ans[i] = last - i + 1;
        }
        
        return ans;
    }
}