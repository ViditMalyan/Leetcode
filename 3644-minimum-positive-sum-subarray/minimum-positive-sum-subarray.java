class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
         int n = nums.size();

        int[] prefix = new int[n + 1];

        // Step 1: Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int answer = Integer.MAX_VALUE;

        // Step 2: Try every ending position
        for (int j = l; j <= n; j++) {

            // Add the newly eligible starting position
            int addIndex = j - l;
            int addValue = prefix[addIndex];

            map.put(addValue, map.getOrDefault(addValue, 0) + 1);

            // Remove starting positions that are too far away
            int removeIndex = j - r - 1;

            if (removeIndex >= 0) {
                int removeValue = prefix[removeIndex];
                int count = map.get(removeValue);
                if (count == 1) {
                    map.remove(removeValue);
                } else {
                    map.put(removeValue, count - 1);
                }
            }

            // Find the largest prefix sum smaller than prefix[j]
            Integer best = map.lowerKey(prefix[j]);
            if (best != null) {
                answer = Math.min(answer, prefix[j] - best);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}