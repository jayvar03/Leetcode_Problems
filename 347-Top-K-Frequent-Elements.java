class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int n : map.keySet()) {
            int freq = map.get(n);

            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(n);
        }

        int[] ans = new int[k];
        int j = 0;

        for(int i = bucket.length - 1; i >= 0 && j < k; i--) {
            if(bucket[i] != null) {
                for(int n : bucket[i]) {
                    ans[j++] = n;

                    if(j == k) break;
                }
            }
        }
        return ans;
    }
}