class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c : p.toCharArray()) {
            freq1[c - 'a']++;
        }

        int l = 0;

        for(int r = 0; r < s.length(); r++) {

            freq2[s.charAt(r) - 'a']++;

            if(r - l + 1 > p.length()) {
                freq2[s.charAt(l) - 'a']--;
                l++;
            }

            if(r - l + 1 == p.length()) {
                if(Arrays.equals(freq1, freq2)) {
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}