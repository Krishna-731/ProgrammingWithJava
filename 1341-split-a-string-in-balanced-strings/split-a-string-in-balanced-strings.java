class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int count = 0;
        for(char c : s.toCharArray()) {
            if ( c == 'R') {
                count++;
            }
            if ( c == 'L') {
                count--;
            }

            if (count == 0) {
                ans++;
            }
        }

        return ans;
    }
}