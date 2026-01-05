class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>( (a,b) -> a[0] - b[0]);
        int curMax = Integer.MIN_VALUE;

        for(int i = 0; i < nums.size(); i++) {
            queue.offer(new int[]{nums.get(i).get(0), i, 0});
            curMax = Math.max(curMax, nums.get(i).get(0));
        }

        int[] ans = new int[]{0, Integer.MAX_VALUE};

        while(true) {
            int[] curr = queue.poll();
            int curMin = curr[0];
            int listId = curr[1];
            int valId = curr[2];

            if (curMax - curMin < ans[1] - ans[0]) {
                ans[1] = curMax;
                ans[0] = curMin;
            }

            if (valId + 1 < nums.get(listId).size()) {
                int next = nums.get(listId).get(valId+1);
                queue.offer(new int[]{next, listId, valId+1});
                curMax = Math.max(curMax, next);
            }
            else {
                break;
            }
        }

        return ans;
    }
}