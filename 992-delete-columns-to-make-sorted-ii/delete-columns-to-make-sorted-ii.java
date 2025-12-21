class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        boolean[] sort = new boolean[n+1];
        int ans = 0;

        for(int i = 0; i < m; i++) {
            boolean del = false;

            for(int j = 0; j < n-1; j++) {
                if (!sort[j] && strs[j].charAt(i) > strs[j+1].charAt(i)) {
                    del = true;
                    break;
                }
            }

            if (del) {
                ans++;
                continue;
            }

            for(int j = 0; j < n-1; j++) {
                if (!sort[j] && strs[j].charAt(i) < strs[j+1].charAt(i)) {
                    sort[j] = true;
                }
            }
        }

        return ans;
    }
}