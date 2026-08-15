class Solution {
    public int strangePrinter(String s) {
        // Remove consecutive duplicate characters
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i));
            }
        }

        s = sb.toString();

        int n = s.length();

        int[][] dp = new int[n][n];

        // One character = one turn
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Process smaller substrings before larger ones
        for (int length = 2; length <= n; length++) {

            for (int i = 0; i + length - 1 < n; i++) {

                int j = i + length - 1;

                // Print s[i] separately
                dp[i][j] = dp[i + 1][j] + 1;

                // Try sharing the printing turn
                for (int k = i + 1; k <= j; k++) {

                    if (s.charAt(i) == s.charAt(k)) {

                        int middle = 0;

                        if (k > i + 1) {
                            middle = dp[i + 1][k - 1];
                        }

                        dp[i][j] = Math.min(
                            dp[i][j],
                            middle + dp[k][j]
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}