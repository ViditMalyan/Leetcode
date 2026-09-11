class Solution {
    public int integerReplacement(int n) {
        long num = n;
        int operations = 0;

        while (num != 1) {

            if (num % 2 == 0) {
                // Even → divide by 2
                num /= 2;
            } else if (num == 3) {
                // Special case: 3 → 2 → 1
                num--;
            } else if ((num & 3) == 3) {
                // Binary ends in 11 → +1
                num++;
            } else {
                // Binary ends in 01 → -1
                num--;
            }
            operations++;
        }
        return operations;
    }
}