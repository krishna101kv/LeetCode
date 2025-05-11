class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create a matrix to mark positions to be set to zero
        boolean[][] toZero = new boolean[rows][cols];

        // Iterate through the original matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // Mark row and column to be set to zero
                    for (int a = 0; a < rows; a++) {
                        toZero[a][j] = true;
                    }
                    for (int b = 0; b < cols; b++) {
                        toZero[i][b] = true;
                    }
                }
            }
        }

        // Set positions to zero based on the markings
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (toZero[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}