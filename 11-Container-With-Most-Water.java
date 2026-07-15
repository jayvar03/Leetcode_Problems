class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int max = 0;

        while(l < r) {
            int w = r - l;
            int h = Math.min(height[l], height[r]);
            int a = w * h;

            max = Math.max(a, max);

            if(height[l] > height[r]) r--;
            else if(height[l] < height[r]) l++;
            else {
                l++;
                r--;
            }
        }
        return max;
    }
}