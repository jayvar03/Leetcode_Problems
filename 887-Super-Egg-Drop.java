class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(k, n, dp);
    }
    private int solve(int e, int f, int[][] dp) {
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;

        if(dp[e][f] != -1) {
            return dp[e][f];
        }

        int low = 1;
        int high = f;
        int min = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int breaks = solve(e - 1, mid - 1, dp);
            int survives = solve(e, f - mid, dp);

            int worst = 1 + Math.max(breaks, survives);
            min = Math.min(worst, min);

            if(breaks > survives) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return dp[e][f] = min;
    }
}