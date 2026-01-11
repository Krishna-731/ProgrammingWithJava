class Solution {
    int maxArea = 0;
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] level = new int[n];
        for(char[] charArr : matrix) {
            for(int i = 0; i < charArr.length; i++) {
                if (charArr[i] == '0') {
                    level[i] = 0;
                }
                else {
                    level[i]++;
                }
            }
            maxArea = Math.max(maxArea, calcArea(level));
        }

        return maxArea;
    }

    public int calcArea(int[] level) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i <= level.length; i++) {
            int currHeight = (i == level.length) ? 0 : level[i];
            
            while (!stack.isEmpty() && currHeight < level[stack.peek()]) {
                int h = level[stack.pop()];
                int w = stack.isEmpty() ? i : i-stack.peek() - 1;
                result = Math.max(result, h*w);
            }

            stack.push(i);
        }

        return result;
    }
}