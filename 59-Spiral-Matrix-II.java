class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int[][] ans = new int[n][n];
        int x = 1;

        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                ans[top][i] = x;
                x++;
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                ans[i][right] = x;
                x++;
            }
            right--;

            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    ans[bottom][i] = x;
                    x++;
                }
                bottom--;
            }

            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    ans[i][left] = x;
                    x++;
                }
                left++;
            }
        }
        return ans;
    }
}