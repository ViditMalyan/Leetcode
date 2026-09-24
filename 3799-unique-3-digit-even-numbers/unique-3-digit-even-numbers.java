class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        // Count each digit
        for (int digit : digits) {
            freq[digit]++;
        }
        
        int count = 0;

        // Hundreds digit: 1-9
        for (int hundreds = 1; hundreds <= 9; hundreds++) {
            if (freq[hundreds] == 0) {
                continue;
            }
            freq[hundreds]--;

            // Tens digit: 0-9
            for (int tens = 0; tens <= 9; tens++) {
                if (freq[tens] == 0) {
                    continue;
                }
                freq[tens]--;

                // Units digit: even
                for (int units = 0; units <= 8; units += 2) {
                    if (freq[units] > 0) {
                        count++;
                    }
                }
                freq[tens]++;
            }
            freq[hundreds]++;
        }
        return count;
    }
}