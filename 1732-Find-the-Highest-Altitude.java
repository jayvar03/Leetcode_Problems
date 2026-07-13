class Solution {
    public int largestAltitude(int[] gain) {
        int[] ans = new int[gain.length + 1];
        int i = 0;
        int max = 0;
        ans[i++] = 0;

        for(int g : gain) {
            ans[i] = ans[i-1] + g;
            max = Math.max(ans[i], max);
            i++;
        }
        return max;
    }
}