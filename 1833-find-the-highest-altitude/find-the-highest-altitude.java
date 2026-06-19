class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int alt = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            alt += gain[i];
            result = Math.max(result, alt);
        }
        return Math.max(result, 0);
    }
}