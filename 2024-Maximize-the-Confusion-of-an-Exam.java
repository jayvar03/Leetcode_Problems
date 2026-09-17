class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] freq = new int[26];
        int l = 0, maxFreq = 0, len = 0;

        for(int r = 0; r < answerKey.length(); r++) {
            freq[answerKey.charAt(r) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[answerKey.charAt(r) - 'A']);

            if((r - l + 1) - maxFreq > k) {
                freq[answerKey.charAt(l) - 'A']--;
                l++;
            }

            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}