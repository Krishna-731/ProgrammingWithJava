class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int[] arr = new int[26];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            Arrays.fill( arr, 0);
            int max = 0;
            int unique = 0;
            for(int j = i; j < n; j++) {
                int curr = s.charAt(j) - 'a';
                if ( ++arr[curr] == 1) {
                    unique++;
                }
                max = Math.max(max, arr[curr]);
                if (max*unique == j-i+1) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
}