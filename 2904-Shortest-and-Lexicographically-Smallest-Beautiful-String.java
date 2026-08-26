class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> list = new ArrayList<>();
        String ans = "";
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                list.add(i);
            }
        }

        if(list.size() < k) return ans;

        for(int i = k - 1; i < list.size(); i++) {
            int start = list.get(i - k + 1);
            int end = list.get(i);

            int len = end - start + 1;

            String curr = s.substring(start, end + 1);

            if(min > len) {
                min = len;
                ans = curr;
            } else if(len == min && curr.compareTo(ans) < 0) {
                ans = curr;
            }
        }
        return ans;
    }
}