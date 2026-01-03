class Solution {
    public int colorTheGrid(int m, int n) {
        long result = 0;
        int mod = 1_000_000_007;
        List<String> state = new ArrayList<>();
        generateStates(m, '#', "", 0, state);

        int s = state.size();

        boolean[][] valid = new boolean[s][s];
        for(int i = 0; i < s; i++) {
            for(int j = 0; j < s; j++) {
                valid[i][j] = isValid(state.get(i), state.get(j));
            }
        }
        
        long[] dp = new long[s];
        Arrays.fill(dp, 1);

        for(int col = 1; col < n; col++) {
            long[] newDp = new long[s];
            for(int i = 0; i < s; i++) {
                for(int j = 0; j < s; j++) {
                    if (valid[i][j]) {
                        newDp[i] = (newDp[i] + dp[j]) % mod;
                    }
                }
            }
            dp = newDp;
        }

        for(long value : dp) {
            result = (result + value) % mod;
        }

        return (int) result;
    }

    public void generateStates(int m, char prevChar, String currState, int l, List<String> state) {
        if (l == m) {
            state.add(currState);
            return;
        }

        for(char c : new char[]{'R', 'G', 'B'}) {
            if ( c == prevChar) {
                continue;
            }

            generateStates(m, c, currState+c, l+1, state);
        }

        return;
    }

    public boolean isValid(String a, String b) {
        for(int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}