class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        boolean found = false;
        int temp = k;
        while (!found) {
            if (!set.contains(temp)) {
                found = true;
                return temp;
            }
            else {
                temp += k;
            }
        }
        return -1;
    }
}