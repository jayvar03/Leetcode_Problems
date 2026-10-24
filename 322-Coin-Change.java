class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = amount + 1;

        int[][] dp = new int[n + 1][amount + 1];

        for(int j = 1; j <= amount; j++) {
            dp[0][j] = INF;
        }

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= amount; j++) {

                dp[i][j] = dp[i - 1][j];

                if(coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        return dp[n][amount] >= INF ? -1 : dp[n][amount];
    }
}