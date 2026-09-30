class Solution {
    public int magicalString(int n) {
         if (n <= 0) {
            return 0;
        }

        if (n <= 3) {
            return 1;
        }

        char[] s = new char[n];

        // Initial magical string: "122"
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';

        int head = 2;
        int tail = 3;

        int num = 1;
        int ones = 1;

        while (tail < n) {
            // How many times should we write num?
            int count = s[head] - '0';

            for (int i = 0; i < count && tail < n; i++) {
                s[tail++] = (char) ('0' + num);
                
                if (num == 1) {
                    ones++;
                }
            }
            // Alternate between 1 and 2
            num = 3 - num;
            head++;
        }
        return ones;
    }
}