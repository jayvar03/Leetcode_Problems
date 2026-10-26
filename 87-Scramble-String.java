class Solution {
    Boolean[][][] dp;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        dp = new Boolean[n][n][n + 1];

        return solve(s1, s2, 0, 0, n);
    }
    private boolean solve(String s1, String s2, int i, int j, int len) {
        if(s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return true;
        }

        if(dp[i][j][len] != null) {
            return dp[i][j][len];
        }

        for(int k = 1; k < len; k++) {
            //no swap
            boolean noSwap = solve(s1, s2, i, j, k) && solve(s1, s2, i + k, j + k, len - k);

            //swap
            boolean swap = solve(s1, s2, i, j + len - k, k) && solve(s1, s2, i + k, j, len - k);

            if(noSwap || swap) {
                return dp[i][j][len] = true;
            }
        }
        return dp[i][j][len] = false;
    }
}