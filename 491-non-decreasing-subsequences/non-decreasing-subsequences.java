class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack( int[] nums, int start, List<Integer> current, List<List<Integer>> result ) {

        // Any non-decreasing sequence of length >= 2 is valid
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }

        // Avoid choosing the same value twice
        // at this particular recursion level.
        Set<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {

            // Duplicate choice at the same level
            if (used.contains(nums[i])) {
                continue;
            }

            // Must remain non-decreasing
            if (!current.isEmpty()
                    && nums[i] < current.get(current.size() - 1)) {
                continue;
            }

            used.add(nums[i]);

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current, result);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}