class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n0 = 0;
        int n1 = 0;
        int n2 = 0;
        for (int stone : stones) {
            if (stone % 3 == 0) {
                n0++;
            } else if (stone % 3 == 1) {
                n1++;
            } else {
                n2++;
            }
        }
        if (n1 == 0 && n2 == 0) {
            return false;
        }
        if (n0 % 2 == 0) {
            return Math.min(n1, n2) > 0;
        } else {
            return Math.abs(n1 - n2) > 2;
        }
    }
}