class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int ans = 0;
        int minPenelty = 0;
        int currPenelty = 0;

        for(int i = 0; i < n; i++) {
            char ch = customers.charAt(i);
            currPenelty += (ch == 'Y' ? -1 : 1);

            if (currPenelty < minPenelty) {
                ans = i+1;
                minPenelty = currPenelty;
            }
        }

        return ans;
    }
}