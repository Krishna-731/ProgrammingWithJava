class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int side = Math.min(helper(hBars), helper(vBars));
        return side*side;
    }

    public int helper(int[] bars) {
        int count = 2;
        int length = 2;
        for(int i = 1; i < bars.length; i++) {
            if (bars[i] - bars[i-1] == 1) {
                count++;
            }
            else {
                count = 2;
            }
            length = Math.max(length, count);
        }
        return length;
    }
}