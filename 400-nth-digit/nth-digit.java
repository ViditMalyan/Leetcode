class Solution {
    public int findNthDigit(int n) {
         long digits = 1;
        long count = 9;
        long start = 1;

        // Find which digit-length group contains n
        while (n > digits * count) {

            n -= digits * count;

            digits++;
            count *= 10;
            start *= 10;
        }

        // Find the actual number
        long number = start + (n - 1) / digits;

        // Find the digit inside that number
        int index = (int) ((n - 1) % digits);

        String s = String.valueOf(number);

        return s.charAt(index) - '0';
    }
}