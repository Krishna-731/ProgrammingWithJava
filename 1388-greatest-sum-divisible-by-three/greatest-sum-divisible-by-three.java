class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] % 3 == 1) {
                l1.add(nums[i]);
            }
            else if (nums[i] % 3 == 2) {
                l2.add(nums[i]);
            }
        }

        Collections.sort(l1);
        Collections.sort(l2);

        int rem = sum % 3;
        if (rem == 0) {
            return sum;
        }

        int sub = Integer.MAX_VALUE;

        if (rem == 1) {
            if (l1.size() >= 1) {
                sub = Math.min(sub, l1.get(0));
            }
            if (l2.size() >= 2) {
                sub = Math.min(sub, l2.get(0) + l2.get(1));
            }
        }
        else {
            if (l2.size() >= 1) {
                sub = Math.min(sub, l2.get(0));
            }
            if (l1.size() >= 2) {
                sub = Math.min(sub, l1.get(0) + l1.get(1));
            }
        }

        return sub == Integer.MAX_VALUE ? 0 : sum - sub;
    }
}