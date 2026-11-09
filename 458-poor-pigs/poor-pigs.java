class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
          int rounds = minutesToTest / minutesToDie;

        long states = rounds + 1;

        int pigs = 0;
        long combinations = 1;

        while (combinations < buckets) {
            pigs++;

            // Prevent unnecessary overflow
            if (combinations > (buckets - 1) / states) {
                combinations = buckets;
            } else {
                combinations *= states;
            }
        }

        return pigs;
    }
}