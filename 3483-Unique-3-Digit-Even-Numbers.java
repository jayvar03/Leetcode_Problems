class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    for(int k = 0; k < n; k++) {

                        if(k != j && k != i && digits[i] != 0 && digits[k] % 2 == 0) {
                            int digit = (digits[i] * 100) + (digits[j] * 10) + digits[k];
                            set.add(digit);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}