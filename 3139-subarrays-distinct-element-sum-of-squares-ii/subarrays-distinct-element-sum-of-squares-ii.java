class Solution {
        public static final long MOD = 1_000_000_007L;

    public static class SegmentTree {
        public final int n;
        public final long[] sum;
        public final long[] sumSq;
        public final long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void update(int left, int right) {
            if (left > right) {
                return;
            }
            update(1, 0, n - 1, left, right);
        }

        public void apply(int node, int start, int end, long delta) {
            long len = end - start + 1L;

            sumSq[node] = (sumSq[node] + 2L * delta * sum[node] + delta * delta % MOD * len) % MOD;
            sum[node] = (sum[node] + delta * len) % MOD;
            lazy[node] = (lazy[node] + delta) % MOD;
        }

        public void pushDown(int node, int start, int end) {
            if (lazy[node] == 0 || start == end) {
                return;
            }

            int mid = start + (end - start) / 2;
            long delta = lazy[node];

            apply(node * 2, start, mid, delta);
            apply(node * 2 + 1, mid + 1, end, delta);

            lazy[node] = 0;
        }

        public void update(int node, int start, int end, int left, int right) {
            if (right < start || end < left) {
                return;
            }

            if (left <= start && end <= right) {
                apply(node, start, end, 1);
                return;
            }

            pushDown(node, start, end);

            int mid = start + (end - start) / 2;

            update(node * 2, start, mid, left, right);
            update(node * 2 + 1, mid + 1, end, left, right);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

            sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
        }

        long getSquaredSum() {
            return sumSq[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int value = nums[i];

            int previous = lastSeen.getOrDefault(value, -1);
            tree.update(previous + 1, i);
            lastSeen.put(value, i);
            answer = (answer + tree.getSquaredSum()) % MOD;
        }
        return (int) answer;
    }
}