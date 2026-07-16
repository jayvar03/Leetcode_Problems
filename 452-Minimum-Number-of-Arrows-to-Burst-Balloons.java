class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;

        int[] curr = points[0];

        for(int i = 1; i < points.length; i++) {
            int[] next = points[i];

            if(next[0] > curr[1]) {
                arrows++;
                curr = next;
            }
        }
        return arrows;
    }
}