class Solution {
    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            rotated[j][n - i - 1] = mat[i][j];
            }
        }
    return rotated;
    }

    private boolean areMatricesEqual(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat1[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
    return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {         
        for (int i = 0; i < 4; i++) {
            if (areMatricesEqual(mat, target)) {
                return true;
            }
            mat = rotate(mat);  
        }
    return false;
    }
}