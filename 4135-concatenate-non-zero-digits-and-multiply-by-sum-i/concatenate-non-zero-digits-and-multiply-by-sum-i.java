class Solution {
    public long sumAndMultiply(int n) {
        long x = 0L;
        long sum = 0L;
        String s = String.valueOf(n);
        for(char c : s.toCharArray()) {
            if (c != '0') {
                int lastDigit = c - '0';
                x = x*10 + lastDigit;
                sum += lastDigit;
            }
        }
        return x*sum;
    }
}