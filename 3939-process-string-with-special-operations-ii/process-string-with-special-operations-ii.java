class Solution {
    public char processStr(String s, long k) {
        long length = 0;
        for(char c : s.toCharArray()) {
            if (c == '*') {
                length = Math.max(0l, length-1);
            }
            else if (c == '#') {
                length *= 2;
            }
            else if (c != '%') {
                length++;
            }
        }

        if (k >= length) {
            return '.';
        }

        for(int i = s.length()-1; i>= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                length++;
            }
            else if (c == '#') {
                long half = length/2;
                if ( k >= half) {
                    k -= half;
                }
                length = half;
            }

            else if (c == '%') {
                k = length - 1 - k;
            }

            else {
                if ( k == length-1 ) {
                    return c;
                }
                length--;
            }
        }

        return '.';
    }
}