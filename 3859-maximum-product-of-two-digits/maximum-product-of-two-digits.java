class Solution {
    public int maxProduct(int n) {
        int max = Integer.MIN_VALUE;
        String s = String.valueOf(n);
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j < s.length(); j++) {
                max = Math.max(max, (s.charAt(i) - '0')*(s.charAt(j)-'0'));
            }
        }
        return max;
    }
}