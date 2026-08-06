class Solution {
    public int helper(int n) {
        int ans = 1;
        while ( n > 0) {
            int digit = n%10;
            ans *= digit;
            n /= 10;
        }
        return ans;
    }
    public int smallestNumber(int n, int t) {
        for(int i = n; i <= n+10; i++) {
            if (helper(i)%t == 0) {
                return i;
            }
        }
        return 0;
    }
}