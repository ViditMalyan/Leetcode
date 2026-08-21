class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] notPrime = new boolean[n];

        for (int p = 2; p * p < n; p++) {
            if (!notPrime[p]) {
                for (int multiple = p * p;
                     multiple < n;
                     multiple += p) {
                    notPrime[multiple] = true;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }
        return count;
    }
}