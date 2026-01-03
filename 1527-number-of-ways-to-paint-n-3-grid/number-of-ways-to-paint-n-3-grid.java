class Solution {
    public int numOfWays(int n) {
        int mod = 1_000_000_007;
        int[][][][] dp = new int[n][4][4][4];

        for (int i = 0; i < n; i++) {
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    for (int c = 0; c < 4; c++) {
                        dp[i][a][b][c] = -1;
                    }
                }
            }
        }

        return solve(0, n, 0, 0, 0, mod, dp);
    }

    public int solve(int i, int n, int prev1, int prev2, int prev3, int mod, int[][][][] dp) {
        if (i == n) {
            return 1;
        }

        if (dp[i][prev1][prev2][prev3] != -1) {
            return dp[i][prev1][prev2][prev3];
        }

        int ans = 0;

        for(int col1 = 1; col1 <= 3; col1++) {
            if (col1 == prev1) {
                continue;
            }

            for(int col2 = 1; col2 <= 3; col2++) {
                if (col2 == prev2 || col2 == col1) {
                    continue;
                }

                for(int col3 = 1; col3 <= 3; col3++) {
                    if (col3 == prev3 || col3 == col2) {
                        continue;
                    }

                    ans = (ans + solve(i+1, n, col1, col2, col3, mod, dp)) % mod;
                }
            }
        }

        return dp[i][prev1][prev2][prev3] = ans;
    }
}