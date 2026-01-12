class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int totalTime = 0;
        for(int i = 0; i < n-1; i++) {
            int currX = points[i][0];
            int currY = points[i][1];
            int nextX = points[i+1][0];
            int nextY = points[i+1][1];

            totalTime += helper(currX, currY, nextX, nextY);
        }

        return totalTime;
    }

    public int helper(int currX, int currY, int nextX, int nextY) {
        if (currX == nextX && currY == nextY) {
            return 0;
        }

        int x = Integer.compare(nextX, currX);
        int y = Integer.compare(nextY, currY);

        return 1 + helper(currX + x, currY + y, nextX, nextY);
    }
}