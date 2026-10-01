/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Map<Integer, Integer> frequency = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        // Postorder DFS calculates every subtree sum
        dfs(root);

        // Find maximum frequency
        int maxFrequency = 0;

        for (int freq : frequency.values()) {
            maxFrequency = Math.max(maxFrequency, freq);
        }

        // Collect all sums with maximum frequency
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                result.add(entry.getKey());
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);
        int sum = node.val + leftSum + rightSum;

        frequency.put( sum, frequency.getOrDefault(sum, 0) + 1 );
        return sum;
    }
}