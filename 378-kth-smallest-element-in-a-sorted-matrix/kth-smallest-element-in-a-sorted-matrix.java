class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        while (low < high) {
            int mid = low + (high-low)/2;
            if (helper(matrix, mid) >= k) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return high;
    }

    private int helper(int[][] matrix, int mid) {
        int n = matrix.length;
        int ans = 0;
        int row = n-1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                ans += (row+1);
                col++;
            }
            else {
                row--;
            }
        }

        return ans;
    }
}