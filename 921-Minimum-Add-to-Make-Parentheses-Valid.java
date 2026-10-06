class Solution {
    public int minAddToMakeValid(String s) {
        int opened = 0, added = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') opened++;
            else if(opened > 0) opened--;
            else added++;
        }
        return opened + added;
    }
}