class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0, ans = 0;
        
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        for(int r = 0; r < nums.length; r++) {
            while(!max.isEmpty() && nums[max.peekLast()] < nums[r]) {
                max.pollLast();
            }
            max.addLast(r);

            while(!min.isEmpty() && nums[min.peekLast()] > nums[r]) {
                min.pollLast();
            }
            min.addLast(r);

            while(nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                if(max.peekFirst() == l) {
                    max.pollFirst();
                }
                if(min.peekFirst() == l) {
                    min.pollFirst();
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}