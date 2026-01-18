class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] row = new int[m][n+1];
        int[][] col = new int[m+1][n];
        int[][] dia1 = new int[m+1][n+1];
        int[][] dia2 = new int[m+1][n+1];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                row[i][j+1] = row[i][j] + grid[i][j];
                col[i+1][j] = col[i][j] + grid[i][j];
                dia1[i+1][j+1] = dia1[i][j] + grid[i][j];
                dia2[i+1][j] = dia2[i][j+1] + grid[i][j];
            }
        }

        for(int k = Math.min(m, n); k >= 2; k--) {
            for(int i = 0; i+k <= m; i++) {
                for(int j = 0; j+k <= n; j++) {
                    if (isValid(grid, row, col, dia1, dia2, i ,j, k)) {
                        return k;
                    }
                }
            }
        }

        return 1;
    }

    public boolean isValid(int[][] grid, int[][] row, int[][] col, int[][] dia1, int[][] dia2, int r, int c, int k) {
        int target = row[r][c+k] - row[r][c];

        for(int i = 0; i < k; i++) {
            if (row[r+i][c+k] - row[r+i][c] != target) {
                return false;
            }
            if (col[r+k][c+i] - col[r][c+i] != target) {
                return false;
            }
        }

        if ( dia1[r+k][c+k] - dia1[r][c] != target) {
            return false;
        }

        if ( dia2[r+k][c] - dia2[r][c+k] != target) {
            return false;
        }


        return true;
    }
}