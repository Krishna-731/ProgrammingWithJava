class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int ans = 0;
        int cost = 1;
        for (int i = 25; i >= 0;) {
            if (freq[i] == 0) break;
            for (int j = 0; j < 8 && i >= 0; j++) {
                ans += freq[i] * cost;
                i--;
            }
            cost++;
        }
        return ans;
    }
}