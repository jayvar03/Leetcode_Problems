class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0;
        int r = plants.length - 1;

        int alice = capacityA;
        int bob = capacityB;

        int refills = 0;

        while(l < r) {
            if(alice < plants[l]) {
                refills++;
                alice = capacityA;
            }

            alice -= plants[l];
            l++;

            if(bob < plants[r]) {
                refills++;
                bob = capacityB;
            }

            bob -= plants[r];
            r--;
        }

        if(l == r) {
            if(Math.max(alice, bob) < plants[l]) {
                refills++;
            }
        }
        return refills;
    }
}