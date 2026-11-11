class Solution {
    public int coinChange(int[] coins, int amount) {

         // Create DP array
        int[] dp = new int[amount + 1];

        // Initialize every position with an impossible value
        Arrays.fill(dp, amount + 1);

        // Zero amount requires zero coins
        dp[0] = 0;

        // Calculate answers for every amount
        for (int i = 1; i <= amount; i++) {

            // Try every available coin
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(
                        dp[i],
                        1 + dp[i - coin]
                    );
                }
            }
        }
        // Check whether the target amount is possible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}