class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int j = 0;

        while(j < chars.length) {
            
            int count = 0;
            char curr = chars[j];

            while(j < chars.length && chars[j] == curr) {
                j++;
                count++;
            }

            chars[i] = curr;
            i++;

            if(count > 1) {
                String freq = String.valueOf(count);
                for(char f : freq.toCharArray()) {
                    chars[i] = f;
                    i++;
                }
            }
        }
        return i;
    }
}