class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int len = 0;
        for(int j = 0; j < nums.length; j++) {
            while ( (long)nums[j] > (long)nums[i]*k) {
                i++;
            }
            len = Math.max(len, j-i+1);
        }

        return nums.length-len;
    }
}