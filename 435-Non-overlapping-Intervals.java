class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int remove = 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] curr = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if(curr[1] > next[0]) {
                remove++;

                if(curr[1] > next[1]) {
                    curr = next;
                }
            } else {
                curr = next;
            }
        }
        return remove;
    }
}