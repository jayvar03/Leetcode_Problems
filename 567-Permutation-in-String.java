class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> count1 = new HashMap<>();
        HashMap<Character, Integer> count2 = new HashMap<>();

        int k = s1.length();
        if(k > s2.length()) return false;
        
        for(int i = 0; i < k; i++) {
            count1.put(s1.charAt(i), count1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i = 0; i < k; i++) {
            count2.put(s2.charAt(i), count2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(count1.size() == count2.size() && count1.equals(count2)) return true;

        for(int i = k; i < s2.length(); i++) {
            count2.put(s2.charAt(i - k), count2.get(s2.charAt(i - k)) - 1);
            if(count2.get(s2.charAt(i - k)) == 0) count2.remove(s2.charAt(i - k));

            count2.put(s2.charAt(i), count2.getOrDefault(s2.charAt(i), 0) + 1);

            if(count1.size() == count2.size() && count1.equals(count2)) return true;
        }

        return false;
    }
}