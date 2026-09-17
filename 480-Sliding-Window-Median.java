class Solution {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();

    HashMap<Integer, Integer> delayed = new HashMap<>();
    int smallSize = 0;
    int largeSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        int idx = 0;

        for(int i = 0; i < n; i++) {

            //add curr element
            if(small.isEmpty() || nums[i] <= small.peek()) {
                small.offer(nums[i]);
                smallSize++;
            } else {
                large.offer(nums[i]);
                largeSize++;
            }

            //balance
            balance();

            //once win reaches size k
            if(i >= k - 1) {
                prune(small);
                prune(large);

                //get median
                if(k % 2 == 1) {
                    ans[idx++] = small.peek();
                } else {
                    ans[idx++] = ((double) small.peek() + large.peek()) / 2.0;
                }

                //remove outgoing element
                int outgoing = nums[i - k + 1];

                delayed.put(outgoing, delayed.getOrDefault(outgoing, 0) + 1);

                //update size
                if(outgoing <= small.peek()) {
                    smallSize--;
                } else {
                    largeSize--;
                }

                //remove it physically
                prune(small);
                prune(large);

                //balance again
                balance();
            }
        }
        return ans;
    }
    private void balance() {
        if(smallSize > largeSize + 1) {
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        } else if(smallSize < largeSize) {
            small.offer(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        }
    }
    private void prune(PriorityQueue<Integer> heap) {
        while(!heap.isEmpty()) {
            int num = heap.peek();

            if(!delayed.containsKey(num)) break;

            heap.poll();

            int freq = delayed.get(num);

            if(freq == 1) {
                delayed.remove(num);
            } else {
                delayed.put(num, freq - 1);
            }
        }
    }
}