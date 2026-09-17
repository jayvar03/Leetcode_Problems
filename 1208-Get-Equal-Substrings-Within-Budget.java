class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0, len = 0, diff = 0;

        for(int r = 0; r < s.length(); r++) {
            diff += Math.abs(s.charAt(r) - t.charAt(r));
            if(diff > maxCost){
                diff -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }

            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}