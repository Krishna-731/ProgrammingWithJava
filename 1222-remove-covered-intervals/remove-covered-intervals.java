class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int prev = 0;
        for(int[] interval : intervals) {
            int end = interval[1];

            if (prev < end) {
                count++;
                prev = end;
            }
        }

        return count;
    }
}