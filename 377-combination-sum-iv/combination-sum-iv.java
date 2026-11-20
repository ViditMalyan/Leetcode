class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        // One way to form zero: choose nothing
        dp[0] = 1;

        // Calculate ways for every sum
        for (int i = 1; i <= target; i++) {

            // Try every available number
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}