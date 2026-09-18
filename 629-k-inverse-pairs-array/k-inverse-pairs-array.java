class Solution {
    public static final int MOD = 1_000_000_007;

    public int kInversePairs(int n, int k) {

        int maxInversions = n * (n - 1) / 2;
        if (k > maxInversions) {
            return 0;
        }

        int[] prev = new int[k + 1];
        int[] curr = new int[k + 1];

        // One way to have 0 inversions with 0 numbers
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            long window = 0;
            for (int j = 0; j <= k; j++) {
                window += prev[j];

                // Keep only the last i values
                if (j >= i) {
                    window -= prev[j - i];
                }

                window %= MOD;

                if (window < 0) {
                    window += MOD;
                }

                curr[j] = (int) window;
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[k];
    }
}