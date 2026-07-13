class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        backtrack(1, n, k, new ArrayList<>());

        return answer;
    }

    private void backtrack(int start, int n, int k, List<Integer> current) {

        // If we have selected k numbers
        if (current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        // Try every possible next number
        for (int i = start; i <= n; i++) {

            current.add(i); // Choose

            backtrack(i + 1, n, k, current); // Explore

            current.remove(current.size() - 1); // Undo (Backtrack)
        }
    }
}