class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] pref = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                pref[i][j] = pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1] +  mat[i-1][j-1];
            }
        }

        int left = 0;
        int right = Math.min(m,n);
        int ans = 0;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (valid(pref, mid, threshold, m, n)) {
                ans = mid;
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }

        return ans;
    }

    public boolean valid(int[][] pref, int mid, int threshlod, int m, int n) {
        for(int i = mid; i <= m; i++) {
            for(int j = mid; j <= n; j++) {
                int sum = pref[i][j] - pref[i-mid][j] - pref[i][j-mid] + pref[i-mid][j-mid];

                if (sum <= threshlod) {
                    return true;
                }
            }
        }

        return false;
    }
}