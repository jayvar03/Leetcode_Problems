class NumMatrix {
    int[][] pref;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        pref = new int[rows + 1][cols + 1];

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                pref[r + 1][c + 1] =
                    matrix[r][c] 
                    + pref[r][c + 1] 
                    + pref[r + 1][c] 
                    - pref[r][c]; 
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pref[row2 + 1][col2 + 1] //big
               - pref[row1][col2 + 1] //top
               - pref[row2 + 1][col1] //left
               + pref[row1][col1]; //overlap
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */