class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, max = 0;

        while(r < nums.length) {
            if(nums[r] == 0) k--;
            while(k < 0) {
                if(nums[l] == 0) k++;
                l++;
            }

            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}