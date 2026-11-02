class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(candidates, target, 0, current, result);

        return result;
    }

    public void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {

        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // The array is sorted, so larger numbers cannot work.
            if (candidates[i] > remaining) {
                break;
            }

            // Skip duplicate choices at the same recursion level.
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);

            // i + 1 ensures each array element is used at most once.
            backtrack(candidates, remaining - candidates[i], i + 1, current, result);

            // Backtrack: undo the last choice.
            current.remove(current.size() - 1);
        }
    }
}