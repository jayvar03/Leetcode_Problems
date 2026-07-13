class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int count = 0;

        for(int i = k; i < arr.length; i++) {
            if(sum / k >= threshold) count++;

            sum += arr[i];
            sum -= arr[i - k];
        }
        //last window
        if(sum / k >= threshold) count++;
        return count;
    }
}