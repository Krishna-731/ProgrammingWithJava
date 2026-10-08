class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        char[] chArr = s.toCharArray();
        for(int i = 0; i < chArr.length; i++) {
            if (chArr[i] == '(') {
                if (!stack.isEmpty()) {
                    sb.append('(');
                }
                stack.push('(');
            }
            else {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }
}