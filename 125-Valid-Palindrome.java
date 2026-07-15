class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String res = s.replaceAll("[^a-z0-9]", "");

        int l = 0, r = res.length() - 1;
        while(l <= r) {
            if(res.charAt(l) != res.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}