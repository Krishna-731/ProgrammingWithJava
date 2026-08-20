class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i = 2; i < n; i++) {
            if (arr1.getLast() > arr2.getLast()) {
                arr1.add(nums[i]);
            }
            else {
                arr2.add(nums[i]);
            }
        }
        int[] ans = new int[n];
        int i = 0;
        for(int x : arr1) {
            ans[i++] = x;
        }
        for(int x : arr2) {
            ans[i++] = x;
        }
        return ans;
    }
}