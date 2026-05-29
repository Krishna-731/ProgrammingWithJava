class Solution {
    public int calcSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = calcSum(nums[i]);
            min = Math.min(min, sum);
        }
        return min;
    }
}