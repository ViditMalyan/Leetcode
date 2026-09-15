class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int n = nums.length;
        long sum = 0;
        long current = 0;

        // Calculate sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            current += (long) i * nums[i];
        }
        long max = current;

        // Derive every next rotation
        for (int k = 1; k < n; k++) {
            int movedElement = nums[n - k];
            current = current + sum - (long) n * movedElement;
            max = Math.max(max, current);
        }
        return (int) max;
    }
}