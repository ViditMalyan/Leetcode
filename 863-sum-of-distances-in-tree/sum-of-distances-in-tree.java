class Solution {

    List<Integer>[] graph;
    int[] count;
    int[] answer;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        this.n = n;

        graph = new ArrayList[n];
        count = new int[n];
        answer = new int[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs1(0, -1, 0);
        dfs2(0, -1);

        return answer;
    }

    // Compute subtree sizes and answer[0]
    private void dfs1(int node, int parent, int depth) {

        count[node] = 1;
        answer[0] += depth;

        for (int next : graph[node]) {

            if (next == parent)
                continue;

            dfs1(next, node, depth + 1);

            count[node] += count[next];
        }
    }

    // Re-root DP
    private void dfs2(int node, int parent) {

        for (int next : graph[node]) {

            if (next == parent)
                continue;

            answer[next] = answer[node] + n - 2 * count[next];

            dfs2(next, node);
        }
    }
}