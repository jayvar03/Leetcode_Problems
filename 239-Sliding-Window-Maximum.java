class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for(int i = 0; i < n; i++) {
            //remove index outside the window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            //remove smaller elements from back
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            //add curr index
            dq.offerLast(i);

            //store ans when 1st win formed
            if(i >= k - 1) {
                ans[idx++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}