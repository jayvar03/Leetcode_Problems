class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int MOD = 1_000_000_007;

        int[] pow = new int[nums.length];
        pow[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int l = 0, r = nums.length - 1, ans = 0;

        while(l <= r) {
            if(nums[l] + nums[r] <= target) {
                ans = (ans + pow[r - l]) % MOD;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}