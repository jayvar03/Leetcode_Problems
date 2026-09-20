class Solution {
    public int reverseDegree(String s) {
        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            int val = 26 - (s.charAt(i) - 'a');
            ans += val * (i + 1);
        }

        return ans;
    }
}