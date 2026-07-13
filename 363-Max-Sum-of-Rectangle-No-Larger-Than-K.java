class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for(int top = 0; top < m; top++) {
            int[] colSum = new int[n];
            for(int bottom = top; bottom < m; bottom++) {

                for(int col = 0; col < n; col++) {
                    colSum[col] += matrix[bottom][col];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                int sum = 0;
                for(int num : colSum) {
                    sum += num;

                    Integer prev = set.ceiling(sum - k);

                    if(prev != null) {
                        ans = Math.max(ans, sum - prev);
                    }

                    set.add(sum);
                }
            }
        }
        return ans;
    }
}