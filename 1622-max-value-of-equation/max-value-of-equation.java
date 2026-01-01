class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>( (a,b) -> (b[0] - a[0]) );
        int ans = Integer.MIN_VALUE;
        for(int[] point : points) {
            int x = point[0];
            int y = point[1];

            while (!queue.isEmpty() && ( x - queue.peek()[1]) > k) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                ans = Math.max(ans, y + x + queue.peek()[0]);
            }

            queue.offer ( new int[] {y-x, x});
        }
        return ans;
    }
}