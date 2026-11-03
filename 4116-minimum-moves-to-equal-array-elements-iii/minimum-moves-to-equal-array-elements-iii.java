class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];

        // Step 1: Find the largest element.
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Step 2: Add the moves needed for each element.
        int moves = 0;
        for (int num : nums) {
            moves += max - num;
        }
        return moves;
    }
}