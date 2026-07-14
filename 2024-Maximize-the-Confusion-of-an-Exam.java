class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] ques = new int[26];
        int l = 0, r = 0, maxFreq = 0, len = 0;

        while(r < answerKey.length()) {
            ques[answerKey.charAt(r) - 'A']++;

            maxFreq = Math.max(maxFreq, ques[answerKey.charAt(r) - 'A']);

            if((r - l + 1) - maxFreq > k) {
                ques[answerKey.charAt(l) - 'A']--;
                l++;
            }

            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}