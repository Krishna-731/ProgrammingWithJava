class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int result = 0;
        int maxDiagonal = 0;
        for(int[] arr  : dimensions) {
            int len = arr[0];
            int wid = arr[1];
            int currDiagonal = len*len + wid*wid;
            if (currDiagonal > maxDiagonal || (currDiagonal == maxDiagonal && len*wid > result)) {
                maxDiagonal = currDiagonal;
                result = len*wid;
            }
        }

        return result;
    }
}