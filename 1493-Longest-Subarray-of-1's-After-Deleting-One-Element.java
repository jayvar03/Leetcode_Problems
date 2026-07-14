class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0, k = 1, max = 0;

        while(r < nums.length) {
            if(nums[r] == 0) k--;
            while(k < 0) {
                if(nums[l] == 0) k++;
                l++;
            }

            max = Math.max(max, r - l);
            r++;
        }
        return max;
    }
}