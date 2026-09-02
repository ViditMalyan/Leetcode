class Solution {
    public Boolean[] memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        // Target already reached
        if (desiredTotal <= 0) {
            return true;
        }

        // Even using every number, we cannot
        // reach desiredTotal.
        int totalSum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;

        if (totalSum < desiredTotal) {
            return false;
        }

        // Each bit represents whether a number is used.
        memo = new Boolean[1 << maxChoosableInteger];

        return dfs(maxChoosableInteger, desiredTotal, 0);
    }

    public boolean dfs(int max, int remaining, int mask) {

        if (memo[mask] != null) {
            return memo[mask];
        }

        for (int num = 1; num <= max; num++) {
            int bit = 1 << (num - 1);

            // Number already used
            if ((mask & bit) != 0) {
                continue;
            }

            // We win immediately
            if (num >= remaining) {
                return memo[mask] = true;
            }

            // Choose this number
            int newMask = mask | bit;

            // Give the turn to opponent
            boolean opponentWins = dfs(max, remaining - num, newMask);

            // Opponent loses => we win
            if (!opponentWins) {
                return memo[mask] = true;
            }
        }

        // Every move eventually lets opponent win
        return memo[mask] = false;
    }
}