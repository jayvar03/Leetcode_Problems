class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        for(int top = 0; top < m; top++) {
            int[] colSum = new int[n];
            for(int bottom = top; bottom < m; bottom++) {

                for(int col = 0; col < n; col++) {
                    colSum[col] += matrix[bottom][col];
                }

                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);

                int sum = 0;
                for(int num : colSum) {
                    sum += num;

                    count += map.getOrDefault(sum - target, 0);

                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}