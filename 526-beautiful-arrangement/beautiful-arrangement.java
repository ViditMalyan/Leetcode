class Solution {
    public int[] memo;
    public int n;
    
    public int countArrangement(int n) {
        this.n = n;
        memo = new int[1 << n];
        Arrays.fill(memo, -1);

        return backtrack(1, 0);
    }

    public int backtrack(int position, int mask) {
        if (position > n) {
            return 1;
        }

        if (memo[mask] != -1) {
            return memo[mask];
        }

        int count = 0;

        for (int num = 1; num <= n; num++) {
            int bit = 1 << (num - 1);
            if ((mask & bit) == 0 && (num % position == 0 || position % num == 0)) {
                count += backtrack(position + 1, mask | bit);
            }
        }
        memo[mask] = count;
        return count;
    }
}