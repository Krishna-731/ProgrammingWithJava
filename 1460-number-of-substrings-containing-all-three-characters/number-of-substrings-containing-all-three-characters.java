class Solution {
    public int numberOfSubstrings(String s) {
        int start = 0;
        int end = 0;
        int[] frequency = new int[3];
        int ans = 0;
        while (start < s.length()) {
            char currchar = s.charAt(start);
            frequency[currchar - 'a']++;
            while( frequency[0] > 0 && frequency[1] > 0 && frequency[2] > 0) {
                ans = ans + (s.length() - start);
                char endchar = s.charAt(end);
                frequency[endchar - 'a']--;
                end++;
            }
            start++;
        }
        return ans;
    }
}