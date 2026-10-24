class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        int remaining = n;
        boolean leftToRight = true;

        while (remaining > 1) {
            // Update the first remaining number
            if (leftToRight || remaining % 2 == 1) {
                head += step;
            }

            // Half the numbers remain
            remaining /= 2;

            // The gap between numbers doubles
            step *= 2;

            // Reverse the elimination direction
            leftToRight = !leftToRight;
        }
        return head;
    }
}