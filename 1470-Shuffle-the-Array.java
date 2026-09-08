class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];

        int a = 0, b = n;
        for(int i = 0; i < nums.length; i += 2) {
            ans[i] = nums[a++];
            ans[i + 1] = nums[b++];
        }

        return ans;
    }
}