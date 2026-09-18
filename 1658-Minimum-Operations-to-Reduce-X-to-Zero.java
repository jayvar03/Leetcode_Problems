class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        if(target == 0) return n;
        if(target < 0) return -1;

        int l = 0;
        int sum = 0;
        int max = -1;

        for(int r = 0; r < n; r++) {
            sum += nums[r];

            while(sum > target) {
                sum -= nums[l];
                l++;
            }

            if(sum == target) {
                max = Math.max(max, r - l + 1);
            }
        }

        if(max == -1) return -1;

        return n - max;
    }
}