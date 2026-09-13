class Solution {

    public int[] original;
    public Random random;

    public Solution(int[] nums) {
        // Save the original configuration
        original = nums.clone();
        random = new Random();
    }

    public int[] reset() {
        // Return a fresh copy of the original
        return original.clone();
    }

    public int[] shuffle() {
        // Work on a copy so the original stays unchanged
        int[] result = original.clone();

        // Fisher-Yates Shuffle
        for (int i = result.length - 1; i > 0; i--) {

            // Random index from 0 to i
            int j = random.nextInt(i + 1);

            // Swap
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */