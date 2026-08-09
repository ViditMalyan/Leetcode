class Solution {
    public boolean find132pattern(int[] nums) {
         int n = nums.length;

        if (n < 3) {
            return false;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        // This represents the "2" in 132
        int second = Integer.MIN_VALUE;

        // Scan from right to left
        for (int i = n - 1; i >= 0; i--) {

            // nums[i] can be the "1"
            if (nums[i] < second) {
                return true;
            }

            // Find a bigger number that can be the "3"
            while (!stack.isEmpty() &&
                   nums[i] > stack.peek()) {

                second = stack.pop();
            }

            // Add current number as a possible "3"
            stack.push(nums[i]);
        }

        return false;

       
    }
}